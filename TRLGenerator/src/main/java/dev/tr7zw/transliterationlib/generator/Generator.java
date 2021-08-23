package dev.tr7zw.transliterationlib.generator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
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

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.annotations.SimpleField;
import dev.tr7zw.transliterationlib.api.annotations.SimpleMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimplePassthroughMethod;
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
		Reflections reflections = createReflections(new String[] { "dev.tr7zw.transliterationlib.api" });
		Set<Class<?>> allClasses = new HashSet<>();
		Set<Class<?>> simpleWrapper = reflections.getTypesAnnotatedWith(SimpleWrapper.class);
		allClasses.addAll(simpleWrapper);
		Set<WrapperTarget> wrapperList = new HashSet<>();
		for (Class<?> clazz : simpleWrapper) {
			proccessClass(clazz, Side.Fabric);
			proccessClass(clazz, Side.Forge);
			wrapperList.add(new WrapperTarget(" get" + clazz.getSimpleName(), clazz.getName(), clazz.getName()
					.replace(clazz.getSimpleName(), "TRL" + clazz.getSimpleName()).replace(".api.", ".{{side}}.")));
		}
		Set<Class<?>> addToWrapper = reflections.getTypesAnnotatedWith(AddToWrapper.class);
		for (Class<?> clazz : addToWrapper) {
			wrapperList.add(new WrapperTarget(" get" + clazz.getSimpleName(), clazz.getName(), clazz.getName()
					.replace(clazz.getSimpleName(), "TRL" + clazz.getSimpleName()).replace(".api.", ".{{side}}.")));
		}

		generateWrapperInterface(wrapperList);
		generateWrapperNormalImpl(wrapperList, Side.Fabric);
		generateWrapperNormalImpl(wrapperList, Side.Forge);
		generateWrapperSingletonImpl(wrapperList, Side.Fabric);
		generateWrapperSingletonImpl(wrapperList, Side.Forge);
	}

	private static Reflections createReflections(String[] packages) {
		ConfigurationBuilder conf = new ConfigurationBuilder().forPackages(packages)
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
		for (File f : folder.listFiles()) {
			if (f.isDirectory()) {
				deleteFolder(f);
			}
			f.delete();
		}
	}

	private static void proccessClass(Class<?> clazz, Side side) throws IOException, FormatterException {
		String packageName = clazz.getPackage().getName().replace(".api.",
				side == Side.Fabric ? ".fabric." : ".forge.");
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
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.getParameterCount() == 0 && method.getAnnotation(SimpleMethod.class) != null) {
				getter.add(new SimpleAccess(method.getReturnType() != void.class, method.getName(),
						method.getReturnType().getName(), getName(method.getAnnotation(SimpleMethod.class), side)));
			}
		}
		mapping.put("simpleGetter", getter);
		Set<SimpleAccess> fieldGetter = new HashSet<>();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.getParameterCount() == 0 && method.getAnnotation(SimpleField.class) != null) {
				fieldGetter.add(new SimpleAccess(method.getReturnType() != void.class, method.getName(),
						method.getReturnType().getName(), getName(method.getAnnotation(SimpleField.class), side)));
			}
		}
		mapping.put("fieldGetter", fieldGetter);
		Set<SimpleAccess> simplePassthrough = new HashSet<>();
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.getAnnotation(SimplePassthroughMethod.class) != null) {
				simplePassthrough.add(new SimpleAccess(method.getReturnType() != void.class, method.getName(),
						method.getReturnType().getName(),
						getName(method.getAnnotation(SimplePassthroughMethod.class), side),
						getMethodParameters(method.getParameters()), getCallParameters(method.getParameters(), side)));
			}
		}
		mapping.put("simplePassthrough", simplePassthrough);

		Files.write(outFile.toPath(), generateSimpleWrapper(mapping).getBytes());
	}

	private static String getMethodParameters(Parameter[] parms) {
		StringBuilder str = new StringBuilder();
		for (Parameter p : parms) {
			if (str.length() != 0) {
				str.append(", ");
			}
			str.append(p.getType().getName() + " " + p.getName());
		}
		return str.toString();
	}

	private static String getCallParameters(Parameter[] parms, Side side) {
		StringBuilder str = new StringBuilder();
		for (Parameter p : parms) {
			if (str.length() != 0) {
				str.append(", ");
			}
			if (p.getType().getName().startsWith("dev.tr7zw")) {
				str.append("(("
						+ p.getType().getName().replace(".api.", side == Side.Fabric ? ".fabric." : ".forge.")
								.replace(p.getType().getSimpleName(), "TRL" + p.getType().getSimpleName())
						+ ")" + p.getName() + ").handle()");
			} else {
				str.append(p.getName());
			}
		}
		return str.toString();
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
		return wrapper.mcp();
	}

	private static String getName(SimpleMethod wrapper, Side side) {
		return wrapper.mcp();
	}

	private static String getName(SimpleField wrapper, Side side) {
		return wrapper.mcp();
	}

	private static String getName(SimplePassthroughMethod wrapper, Side side) {
		return wrapper.mcp();
	}

	private static void generateWrapperInterface(Set<WrapperTarget> wrappers) throws FormatterException, IOException {
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

	private static void generateWrapperNormalImpl(Set<WrapperTarget> wrappers, Side side)
			throws FormatterException, IOException {
		File packageFolder = new File(side == Side.Fabric ? fabricGen : forgeGen,
				"dev/tr7zw/transliterationlib/" + (side == Side.Fabric ? "fabric" : "forge") + "/wrapper/api");
		packageFolder.mkdirs();
		File outFile = new File(packageFolder, "NormalWrapper.java");
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile("NormalWrapper.mustache");

		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("wrappers", wrappers);
		mapping.put("side", side == Side.Fabric ? "fabric" : "forge");

		StringWriter writer = new StringWriter();
		mustache.execute(writer, mapping);

		String formattedSource = new Formatter()
				.formatSource(writer.toString().replace("{{side}}", (String) mapping.get("side")));
		System.out.println(formattedSource);
		Files.write(outFile.toPath(), formattedSource.getBytes());
	}

	private static void generateWrapperSingletonImpl(Set<WrapperTarget> wrappers, Side side)
			throws FormatterException, IOException {
		File packageFolder = new File(side == Side.Fabric ? fabricGen : forgeGen,
				"dev/tr7zw/transliterationlib/" + (side == Side.Fabric ? "fabric" : "forge") + "/wrapper/api");
		packageFolder.mkdirs();
		File outFile = new File(packageFolder, "SingletonWrapper.java");
		MustacheFactory mf = new DefaultMustacheFactory();
		Mustache mustache = mf.compile("SingletonWrapper.mustache");

		Map<String, Object> mapping = new HashMap<String, Object>();
		mapping.put("wrappers", wrappers);
		mapping.put("side", side == Side.Fabric ? "fabric" : "forge");

		StringWriter writer = new StringWriter();
		mustache.execute(writer, mapping);

		String formattedSource = new Formatter()
				.formatSource(writer.toString().replace("{{side}}", (String) mapping.get("side")));
		System.out.println(formattedSource);
		Files.write(outFile.toPath(), formattedSource.getBytes());
	}

	public static enum Side {
		Fabric, Forge
	}

}
