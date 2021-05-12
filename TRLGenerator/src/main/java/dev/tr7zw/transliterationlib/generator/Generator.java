package dev.tr7zw.transliterationlib.generator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.reflections8.Reflections;
import org.reflections8.scanners.MethodAnnotationsScanner;
import org.reflections8.scanners.SubTypesScanner;
import org.reflections8.scanners.TypeAnnotationsScanner;
import org.reflections8.util.ClasspathHelper;
import org.reflections8.util.ConfigurationBuilder;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

import dev.tr7zw.transliterationlib.api.annotations.SimpleMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;

public class Generator {

	private static File coreGen = new File("../TRLCore/src/generated/java");
	private static File fabricGen = new File("../TRLFabric/src/generated/java");
	private static File forgeGen = new File("../TRLForge/src/generated/java");
	
	public static void main(String[] args) throws IOException, FormatterException {
		fabricGen.mkdirs();
		forgeGen.mkdirs();
		coreGen.mkdirs();
		deleteFolder(fabricGen);
		deleteFolder(forgeGen);
		deleteFolder(coreGen);
		Reflections reflections = createReflections(new String[]{"dev.tr7zw.transliterationlib.api"});
		Set<Class<?>> allClasses = new HashSet<>();
		Set<Class<?>> simpleWrapper = reflections.getTypesAnnotatedWith(SimpleWrapper.class);
		allClasses.addAll(simpleWrapper);
		Set<String> wrapperList = new HashSet<>();
		for(Class<?> clazz : simpleWrapper) {
			proccessClass(clazz, Side.Fabric);
			proccessClass(clazz, Side.Forge);
			wrapperList.add(clazz.getName() + " get" + clazz.getSimpleName());
		}
		
		generateWrapperInterface(wrapperList);
	}
	
	private static Reflections createReflections(String[] packages) {
		ConfigurationBuilder conf = new ConfigurationBuilder()
				.forPackages(packages)
				.setUrls(effectiveClassPathUrls(ClasspathHelper.contextClassLoader()))
				.setScanners(new SubTypesScanner(), new TypeAnnotationsScanner(), new MethodAnnotationsScanner());
		return new Reflections(conf);
	}
	
	/**
	 * Bypasses some issues with running junit tests in maven.
	 * https://stackoverflow.com/questions/13576665/
	 * 
	 * @param classLoaders
	 * @return
	 */
	private static Collection<URL> effectiveClassPathUrls(ClassLoader... classLoaders) {
	    return ClasspathHelper.forManifest(ClasspathHelper.forClassLoader(classLoaders));
	}
	
	private static void deleteFolder(File folder) {
		for(File f : folder.listFiles()) {
			if(f.isDirectory()) {
				deleteFolder(f);
			}
			f.delete();
		}
	}
	
	private static void proccessClass(Class<?> clazz, Side side) throws IOException, FormatterException {
		String packageName = clazz.getPackage().getName().replace(".api.", side == Side.Fabric ? ".fabric." : ".forge.");
		File packageFolder = new File(side == Side.Fabric ? fabricGen : forgeGen, packageName.replace(".", "/"));
		packageFolder.mkdirs();
		String clazzName = "TRL" + clazz.getSimpleName();
		String nmsClassName = getName(clazz.getAnnotation(SimpleWrapper.class), side);
		String interfaceFullType = clazz.getName();
		File outFile = new File(packageFolder, clazzName + ".java");
		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("package", packageName);
		mapping.put("name", clazzName);
		mapping.put("imports", Arrays.asList("dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper"));
		mapping.put("nmsClassName", nmsClassName);
		mapping.put("interfaceFullType", interfaceFullType);
		Set<SimpleAccess> getter = new HashSet<>();
		for(Method method : clazz.getDeclaredMethods()) {
			if(method.getParameterCount() == 0) {
				getter.add(new SimpleAccess(method.getName(),  method.getReturnType().getName(), getName(method.getAnnotation(SimpleMethod.class), side)));
			}
		}
		mapping.put("simpleGetter", getter);

		Files.write(outFile.toPath(), generateSimpleWrapper(mapping).getBytes());
	}
	
	private static String generateSimpleWrapper(Map<String, Object> mapping) throws FormatterException {
		MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache = mf.compile("SimpleWrapperTemplate.mustache");
		
		StringWriter writer = new StringWriter();
	    mustache.execute(writer, mapping);
	    
	    String formattedSource = new Formatter().formatSource(writer.toString());
	    System.out.println(formattedSource);
	    return formattedSource;
	}
	
	private static String getName(SimpleWrapper wrapper, Side side) {
		return side == Side.Fabric ? wrapper.yarn() : wrapper.mcp();
	}
	
	private static String getName(SimpleMethod wrapper, Side side) {
		return side == Side.Fabric ? wrapper.yarn() : wrapper.mcp();
	}
	
	private static void generateWrapperInterface(Set<String> wrappers) throws FormatterException, IOException {
		File packageFolder = new File(coreGen, "dev/tr7zw/transliterationlib/api/wrapper/api");
		packageFolder.mkdirs();
		File outFile = new File(packageFolder, "Wrapper.java");
		MustacheFactory mf = new DefaultMustacheFactory();
	    Mustache mustache = mf.compile("WrapperInterface.mustache");
		
	    Map<String, Object> mapping = new HashMap<String, Object>();
	    mapping.put("wrappers", wrappers);
	    
		StringWriter writer = new StringWriter();
	    mustache.execute(writer, mapping);
	    
	    String formattedSource = new Formatter().formatSource(writer.toString());
	    System.out.println(formattedSource);
	    Files.write(outFile.toPath(), formattedSource.getBytes());
	}
	
	public static enum Side{
		Fabric, Forge
	}

}
