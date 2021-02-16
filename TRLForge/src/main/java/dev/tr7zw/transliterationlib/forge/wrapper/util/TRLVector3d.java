package dev.tr7zw.transliterationlib.forge.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.util.math.vector.Vector3d;

public class TRLVector3d
		extends AbstractWrapper<Vector3d, TRLVector3d, dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d>
		implements dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d {

	@Override
	public double getX() {
		return handle().x;
	}

	@Override
	public double getY() {
		return handle().y;
	}

	@Override
	public double getZ() {
		return handle().z;
	}

}
