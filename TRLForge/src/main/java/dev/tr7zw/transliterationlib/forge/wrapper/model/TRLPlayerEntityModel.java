package dev.tr7zw.transliterationlib.forge.wrapper.model;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLMatrixStack;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.HandSide;

public class TRLPlayerEntityModel<T extends TRLPlayerEntityModel<T, B>, B extends PlayerModel<?>>
		extends AbstractWrapper<B, T, T>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel, HandleHolder<T> {

	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getLeftArm() {
		return transliteration.creationWrapper().getModelPart().of(handle().bipedLeftArm);
	}

	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getRightArm() {
		return transliteration.creationWrapper().getModelPart().of(handle().bipedRightArm);
	}

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrix) {
		handle().translateHand((HandSide) arm.getHandler(), ((TRLMatrixStack) matrix).handle());
	}

}
