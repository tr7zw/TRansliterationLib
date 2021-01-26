package dev.tr7zw.transliterationlib.fabric.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion;
import net.minecraft.client.util.math.Vector3f;

public class TRLVector3f
		extends AbstractWrapper<Vector3f, TRLVector3f, dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f>
		implements dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f {

	private final static dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f POSITIVE_X = new TRLVector3f().ofTyped(Vector3f.POSITIVE_X);
	private final static dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f POSITIVE_Y = new TRLVector3f().ofTyped(Vector3f.POSITIVE_Y);
	private final static dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f POSITIVE_Z = new TRLVector3f().ofTyped(Vector3f.POSITIVE_Z);
	
	
	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f getPositiveX() {
		return POSITIVE_X;
	}

	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f getPositiveY() {
		return POSITIVE_Y;
	}

	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f getPositiveZ() {
		return POSITIVE_Z;
	}

	@Override
	public Quaternion getDegreesQuaternion(float angle) {
		return new TRLQuaternion().ofTyped(handle().getDegreesQuaternion(angle));
	}

}
