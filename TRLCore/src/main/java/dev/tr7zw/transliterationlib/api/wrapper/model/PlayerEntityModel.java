package dev.tr7zw.transliterationlib.api.wrapper.model;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;

@AddToWrapper
public interface PlayerEntityModel extends ModelWithArms  {

	public PlayerEntityModel of(Object handle);
	
	public ModelPart getLeftArm();
	public ModelPart getRightArm();
}
