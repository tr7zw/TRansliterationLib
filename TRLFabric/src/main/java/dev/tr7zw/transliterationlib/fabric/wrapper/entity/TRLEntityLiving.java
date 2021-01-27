package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.item.Hand;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import net.minecraft.entity.LivingEntity;
import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

public class TRLEntityLiving<T extends TRLEntityLiving<T, B>, B extends LivingEntity>
extends TRLEntity<T, B>
implements dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity {

	@Override
	public float getBodyYaw() {
		return handle().bodyYaw;
	}

	@Override
	public void setBodyYaw(float value) {
		handle().bodyYaw = value;
	}

	@Override
	public float getPrevBodyYaw() {
		return handle().prevBodyYaw;
	}

	@Override
	public void setPrevBodyYaw(float value) {
		handle().prevBodyYaw = value;
	}

	@Override
	public float getHeadYaw() {
		return handle().headYaw;
	}

	@Override
	public void setHeadYaw(float value) {
		handle().headYaw = value;
	}

	@Override
	public float getPrevHeadYaw() {
		return handle().prevHeadYaw;
	}

	@Override
	public void setPrevHeadYaw(float value) {
		handle().prevHeadYaw = value;
	}

	@Override
	public Arm getMainArm() {
		return transliteration.getEnumWrapper().getArm().of(handle().getMainArm());
	}
	
	@Override
	public ItemStack getActiveItemStack() {
		return transliteration.creationWrapper().getItemStack().of(handle().getActiveItem());
	}
	
	@Override
	public boolean isUsingItem() {
		return handle().isUsingItem();
	}

	@Override
	public ItemStack getStackInHand(Hand hand) {
		return transliteration.creationWrapper().getItemStack().of(handle().getStackInHand((net.minecraft.util.Hand)hand.getHandler()));
	}

	@Override
	public boolean isSleeping() {
		return handle().isSleeping();
	}

	@Override
	public Hand getActiveHand() {
		return transliteration.getEnumWrapper().getHand().of(handle().getActiveHand());
	}

	@Override
	public int getItemUseTime() {
		return handle().getItemUseTime();
	}

	@Override
	public int getItemUseTimeLeft() {
		return handle().getItemUseTimeLeft();
	}

	@Override
	public boolean isHandSwinging() {
		return handle().handSwinging;
	}

	@Override
	public ItemStack getOffHandStack() {
		return getStackInHand(transliteration.getEnumWrapper().getHand().getOffHand());
	}

	@Override
	public ItemStack getMainHandStack() {
		return getStackInHand(transliteration.getEnumWrapper().getHand().getMainHand());
	}


}
