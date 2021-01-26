package dev.tr7zw.transliterationlib.forge.wrapper.util;

import com.mojang.blaze3d.matrix.MatrixStack;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion;

public class TRLMatrixStack
extends AbstractWrapper<MatrixStack, TRLMatrixStack, dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack>
implements dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack {

	@Override
	public void multiply(Quaternion quaternion) {
		handle().rotate(((TRLQuaternion)quaternion).handle());
	}

	@Override
	public void translate(double x, double y, double z) {
		handle().translate(x, y, z);
	}

	@Override
	public void push() {
		handle().push();
	}

	@Override
	public void pop() {
		handle().pop();
	}

}
