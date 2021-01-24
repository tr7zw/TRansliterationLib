package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.item.Hand;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import net.minecraft.entity.LivingEntity;

public class TRLEntityLiving<T extends TRLEntityLiving<T, B>, B extends LivingEntity>
extends TRLEntity<T, B>
implements dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity {

	@Override
	public float getBodyYaw() {
		return handle().renderYawOffset;
	}

	@Override
	public void setBodyYaw(float value) {
		handle().renderYawOffset = value;
	}

	@Override
	public float getPrevBodyYaw() {
		return handle().prevRenderYawOffset;
	}

	@Override
	public void setPrevBodyYaw(float value) {
		handle().prevRenderYawOffset = value;
	}

	@Override
	public float getHeadYaw() {
		return handle().rotationYawHead;
	}

	@Override
	public void setHeadYaw(float value) {
		handle().rotationYawHead = value;
	}

	@Override
	public float getPrevHeadYaw() {
		return handle().prevRotationYawHead;
	}

	@Override
	public void setPrevHeadYaw(float value) {
		handle().prevRotationYawHead = value;
	}

	@Override
	public Arm getMainArm() {
		return transliteration.getEnumWrapper().getArm().of(handle().getPrimaryHand());
	}
	
	@Override
	public ItemStack getActiveItemStack() {
		return transliteration.creationWrapper().getItemStack().of(handle().getActiveItemStack());
	}
	
	@Override
	public boolean isUsingItem() {
		return handle().isHandActive();
	}

	@Override
	public ItemStack getStackInHand(Hand hand) {
		return transliteration.creationWrapper().getItemStack().of(handle().getHeldItem((net.minecraft.util.Hand)hand.getHandler()));
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
		return handle().getItemInUseCount();
	}

}
