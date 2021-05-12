package dev.tr7zw.transliterationlib.api.wrapper.model;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;

@AddToWrapper
public interface ModelWithArms extends EntityModel{

	public ModelWithArms of(Object handle);
	
	public void setArmAngle(Arm arm, MatrixStack matrix);
	
}
