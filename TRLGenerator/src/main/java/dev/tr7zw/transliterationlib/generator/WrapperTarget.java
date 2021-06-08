package dev.tr7zw.transliterationlib.generator;

public class WrapperTarget {

	public WrapperTarget(String name, String returnType, String targetClass) {
		this.name = name;
		this.lowercasedName = name.toLowerCase();
		this.returnType = returnType;
		this.targetClass = targetClass;
	}
	
	public String name;
	public String lowercasedName;
	public String returnType;
	public String targetClass;
	
}
