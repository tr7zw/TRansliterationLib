package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimplePassthroughMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.client.util.math.MatrixStack", mcp = "com.mojang.blaze3d.vertex.PoseStack")
public interface MatrixStack extends HandleHolder<MatrixStack>  {

	@SimpleMethod(yarn = "push", mcp = "pushPose")
	public void push();
	@SimpleMethod(yarn = "pop", mcp = "popPose")
	public void pop();
	@SimplePassthroughMethod(yarn = "multiply", mcp = "mulPose")
	public void multiply(Quaternion quaternion);
	@SimplePassthroughMethod(yarn = "translate", mcp = "translate")
	public void translate(double x, double y, double z);
	
}
