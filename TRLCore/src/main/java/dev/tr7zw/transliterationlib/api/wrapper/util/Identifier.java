package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.util.Identifier", mcp = "net.minecraft.resources.ResourceLocation")
public interface Identifier extends HandleHolder<Identifier> {

	@SimpleMethod(yarn = "getNamespace", mcp = "getNamespace")
	public String getNamespace();
	@SimpleMethod(yarn = "getPath", mcp = "getPath")
	public String getId();
	
}
