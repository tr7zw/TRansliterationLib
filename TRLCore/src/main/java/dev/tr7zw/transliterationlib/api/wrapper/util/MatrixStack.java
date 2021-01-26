package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

public interface MatrixStack extends HandleHolder<MatrixStack>  {

	public void push();
	public void pop();
	public void multiply(Quaternion quaternion);
	public void translate(double x, double y, double z);
	
}
