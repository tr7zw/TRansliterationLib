package dev.tr7zw.transliterationlib.api.wrapper.internal;

import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d;

public interface InternalEntity {

	public int getId();
	public boolean hasVehicle();
	public Entity getVehicle();
	public float getPitch();
	public void setPitch(float amount);
	public float getYaw();
	public void setYaw(float amount);
	public Vector3d getPos();
	public Vector3d getVelocity();
	
}
