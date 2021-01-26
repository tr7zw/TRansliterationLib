package dev.tr7zw.transliterationlib.fabric.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLMatrixStack;
import net.minecraft.client.render.entity.model.ModelWithArms;

public class TRLModelWithArms<T extends TRLModelWithArms<T, B>, B extends ModelWithArms>
		extends AbstractWrapper<B, T, T>
		implements dev.tr7zw.transliterationlib.api.wrapper.model.ModelWithArms, HandleHolder<T> {

	@Override
	public void setArmAngle(Arm arm, MatrixStack matrix) {
		handle().setArmAngle((net.minecraft.util.Arm) arm.getHandler(), ((TRLMatrixStack) matrix).handle());
	}

}
