package dev.tr7zw.transliterationlib.fabric.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion;
import net.minecraft.client.util.math.MatrixStack;

public class TRLMatrixStack
extends AbstractWrapper<MatrixStack, TRLMatrixStack, dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack>
implements dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack {

	@Override
	public void multiply(Quaternion quaternion) {
		handle().multiply(((TRLQuaternion)quaternion).handle());
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
