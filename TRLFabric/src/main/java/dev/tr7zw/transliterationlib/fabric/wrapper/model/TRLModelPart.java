package dev.tr7zw.transliterationlib.fabric.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.client.model.geom.ModelPart;

public class TRLModelPart
		extends AbstractWrapper<ModelPart, TRLModelPart, dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart {

	@Override
	public float getPitch() {
		return handle().xRot;
	}

	@Override
	public float getYaw() {
		return handle().yRot;
	}

	@Override
	public float getRoll() {
		return handle().zRot;
	}

	@Override
	public void setPitch(float value) {
		handle().xRot = value;
	}

	@Override
	public void setYaw(float value) {
		handle().yRot = value;
	}

	@Override
	public void setRoll(float value) {
		handle().zRot = value;
	}

}
