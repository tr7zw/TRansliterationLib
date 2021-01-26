package dev.tr7zw.transliterationlib.forge.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLMatrixStack;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.util.HandSide;

public class TRLModelWithArms<T extends TRLModelWithArms<T, B>, B extends IHasArm> extends AbstractWrapper<B, T, T>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.ModelWithArms, HandleHolder<T> {

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrix) {
		handle().translateHand((HandSide) arm.getHandler(), ((TRLMatrixStack) matrix).handle());
	}

}
