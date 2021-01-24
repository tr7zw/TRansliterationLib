package dev.tr7zw.transliterationlib.fabric.wrapper.model;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;

public class TRLPlayerEntityModel extends
		AbstractWrapper<PlayerEntityModel<LivingEntity>, TRLPlayerEntityModel, dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel {

	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getLeftArm() {
		return transliteration.creationWrapper().getModelPart().of(handle().leftArm);
	}

	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getRightArm() {
		return transliteration.creationWrapper().getModelPart().of(handle().rightArm);
	}

}
