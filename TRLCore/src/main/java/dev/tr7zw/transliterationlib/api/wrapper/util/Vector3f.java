package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@AddToWrapper
public interface Vector3f extends HandleHolder<Vector3f> {

	public Vector3f getPositiveX();
	public Vector3f getPositiveY();
	public Vector3f getPositiveZ();
	public Quaternion getDegreesQuaternion(float angle);
	public float getX();
	public float getY();
	public float getZ();
	
}
