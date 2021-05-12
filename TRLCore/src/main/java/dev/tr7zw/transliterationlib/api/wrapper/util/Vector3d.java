package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleField;
import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.util.math.Vec3d", mcp = "net.minecraft.util.math.vector.Vector3d")
public interface Vector3d extends HandleHolder<Vector3d> {

	@SimpleField(yarn = "x", mcp = "x")
	public double getX();

	@SimpleField(yarn = "y", mcp = "y")
	public double getY();

	@SimpleField(yarn = "z", mcp = "z")
	public double getZ();

}
