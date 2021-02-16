package dev.tr7zw.transliterationlib.api.wrapper.internal;

import java.util.Optional;

import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.item.Hand;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i;

public interface InternalLivingEntity {

	public float getBodyYaw();
	public void setBodyYaw(float value);
	public float getPrevBodyYaw();
	public void setPrevBodyYaw(float value);
	public float getHeadYaw();
	public void setHeadYaw(float value);
	public float getPrevHeadYaw();
	public void setPrevHeadYaw(float value);
	public Arm getMainArm();
	public boolean isUsingItem();
	public ItemStack getActiveItemStack();
	public ItemStack getOffHandStack();
	public ItemStack getMainHandStack();
	public ItemStack getStackInHand(Hand hand);
	public boolean isSleeping();
	public Hand getActiveHand();
	public int getItemUseTime();
	public int getItemUseTimeLeft();
	public boolean isHandSwinging();
	public boolean isClimbing();
	public Optional<Vector3i> getClimbingPos();
	
}
