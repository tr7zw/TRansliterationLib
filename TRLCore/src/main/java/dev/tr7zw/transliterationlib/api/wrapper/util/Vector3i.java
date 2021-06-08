package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.util.math.Vec3i", mcp = "net.minecraft.util.math.vector.Vector3i")
public interface Vector3i extends HandleHolder<Vector3i> {

	@SimpleMethod(yarn = "getX", mcp = "getX")
	public int getX();
	@SimpleMethod(yarn = "getY", mcp = "getY")
	public int getY();
	@SimpleMethod(yarn = "getZ", mcp = "getZ")
	public int getZ();
	
}
