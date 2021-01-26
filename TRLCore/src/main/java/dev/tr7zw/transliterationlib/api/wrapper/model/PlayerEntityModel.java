package dev.tr7zw.transliterationlib.api.wrapper.model;

public interface PlayerEntityModel extends ModelWithArms  {

	public PlayerEntityModel of(Object handle);
	
	public ModelPart getLeftArm();
	public ModelPart getRightArm();
}
