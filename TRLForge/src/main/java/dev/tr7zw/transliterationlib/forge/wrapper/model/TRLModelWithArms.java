package dev.tr7zw.transliterationlib.forge.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLMatrixStack;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.world.entity.HumanoidArm;

public class TRLModelWithArms<T extends TRLModelWithArms<T, B>, B extends ArmedModel> extends AbstractWrapper<B, T, T>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.ModelWithArms, HandleHolder<T> {

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrix) {
		handle().translateToHand((HumanoidArm) arm.getHandler(), ((TRLMatrixStack) matrix).handle());
	}

}
