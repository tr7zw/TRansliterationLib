package dev.tr7zw.transliterationlib.api.wrapper.internal;

import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;

public interface InternalEntity {

	public int getId();
	public boolean hasVehicle();
	public Entity getVehicle();
	public float getPitch();
	public void setPitch(float amount);
	public float getYaw();
	public void setYaw(float amount);
	
}
