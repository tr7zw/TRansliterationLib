package dev.tr7zw.transliterationlib.fabric.wrapper.model;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLMatrixStack;
import net.minecraft.client.render.entity.model.PlayerEntityModel;

public class TRLPlayerEntityModel<T extends TRLPlayerEntityModel<T, B>, B extends PlayerEntityModel<?>>
		extends AbstractWrapper<B, T, T>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel, HandleHolder<T> {

	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getLeftArm() {
		return transliteration.creationWrapper().getModelPart().of(handle().leftArm);
	}

	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getRightArm() {
		return transliteration.creationWrapper().getModelPart().of(handle().rightArm);
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrix) {
		handle().setArmAngle((net.minecraft.util.Arm) arm.getHandler(), ((TRLMatrixStack) matrix).handle());
	}

}
