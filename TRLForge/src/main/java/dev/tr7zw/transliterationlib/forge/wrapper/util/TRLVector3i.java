package dev.tr7zw.transliterationlib.forge.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.util.math.vector.Vector3i;

public class TRLVector3i
		extends AbstractWrapper<Vector3i, TRLVector3i, dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i>
		implements dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i {

	@Override
	public int getX() {
		return handle().getX();
	}

	@Override
	public int getY() {
		return handle().getY();
	}

	@Override
	public int getZ() {
		return handle().getZ();
	}

}
