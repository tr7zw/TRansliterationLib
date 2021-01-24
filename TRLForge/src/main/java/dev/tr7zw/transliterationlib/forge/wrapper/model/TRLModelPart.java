package dev.tr7zw.transliterationlib.forge.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.client.renderer.model.ModelRenderer;

public class TRLModelPart
		extends AbstractWrapper<ModelRenderer, TRLModelPart, dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart {

	@Override
	public float getPitch() {
		return handle().rotateAngleX;
	}

	@Override
	public float getYaw() {
		return handle().rotateAngleY;
	}

	@Override
	public float getRoll() {
		return handle().rotateAngleZ;
	}

	@Override
	public void setPitch(float value) {
		handle().rotateAngleX = value;
	}

	@Override
	public void setYaw(float value) {
		handle().rotateAngleY = value;
	}

	@Override
	public void setRoll(float value) {
		handle().rotateAngleZ = value;
	}

}
