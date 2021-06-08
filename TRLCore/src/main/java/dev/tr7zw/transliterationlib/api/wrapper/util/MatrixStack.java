package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimplePassthroughMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimpleUnboxingMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.client.util.math.MatrixStack", mcp = "com.mojang.blaze3d.matrix.MatrixStack")
public interface MatrixStack extends HandleHolder<MatrixStack>  {

	@SimpleMethod(yarn = "push", mcp = "push")
	public void push();
	@SimpleMethod(yarn = "pop", mcp = "pop")
	public void pop();
	@SimplePassthroughMethod(yarn = "multiply", mcp = "rotate")
	public void multiply(Quaternion quaternion);
	@SimplePassthroughMethod(yarn = "translate", mcp = "translate")
	public void translate(double x, double y, double z);
	
}
