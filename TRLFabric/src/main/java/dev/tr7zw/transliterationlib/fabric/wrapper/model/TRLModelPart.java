package dev.tr7zw.transliterationlib.fabric.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.client.model.ModelPart;

public class TRLModelPart
		extends AbstractWrapper<ModelPart, TRLModelPart, dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart {

	@Override
	public float getPitch() {
		return handle().pitch;
	}

	@Override
	public float getYaw() {
		return handle().yaw;
	}

	@Override
	public float getRoll() {
		return handle().roll;
	}

	@Override
	public void setPitch(float value) {
		handle().pitch = value;
	}

	@Override
	public void setYaw(float value) {
		handle().yaw = value;
	}

	@Override
	public void setRoll(float value) {
		handle().roll = value;
	}

}
