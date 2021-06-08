package dev.tr7zw.transliterationlib.generator;

public class SimpleAccess {
	
	public SimpleAccess(boolean returning, String name, String returnType, String method) {
		this.returning = returning;
		this.name = name;
		this.returnType = returnType;
		this.method = method;
	}
	
	public SimpleAccess(boolean returning, String name, String returnType, String method, String argsDef, String params) {
		this.returning = returning;
		this.name = name;
		this.returnType = returnType;
		this.method = method;
		this.argsDef = argsDef;
		this.params = params;
	}
	
	public boolean returning;
	public String name;
	public String returnType;
	public String method;
	public String argsDef;
	public String params;
	
}
