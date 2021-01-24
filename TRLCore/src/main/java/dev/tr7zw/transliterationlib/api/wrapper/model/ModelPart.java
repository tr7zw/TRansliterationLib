package dev.tr7zw.transliterationlib.api.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

public interface ModelPart extends HandleHolder<ModelPart> {

	public float getPitch();
	public float getYaw();
	public float getRoll();
	public void setPitch(float value);
	public void setYaw(float value);
	public void setRoll(float value);
	
}
