package dev.tr7zw.transliterationlib.fabric.wrapper.model;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLMatrixStack;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.world.entity.HumanoidArm;

public class TRLPlayerEntityModel<T extends TRLPlayerEntityModel<T, B>, B extends PlayerModel<?>>
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
		handle().translateToHand((HumanoidArm) arm.getHandler(), ((TRLMatrixStack) matrix).handle());
	}

}
