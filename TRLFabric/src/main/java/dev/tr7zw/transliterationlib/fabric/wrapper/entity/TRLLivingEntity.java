package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import java.util.Optional;

import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.item.Hand;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;

public class TRLLivingEntity<T extends TRLLivingEntity<T, B>, B extends LivingEntity>
extends TRLEntity<T, B>
implements dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity {

	@Override
	public float getBodyYaw() {
		return handle().yBodyRot;
	}

	@Override
	public void setBodyYaw(float value) {
		handle().yBodyRot = value;
	}

	@Override
	public float getPrevBodyYaw() {
		return handle().yBodyRotO;
	}

	@Override
	public void setPrevBodyYaw(float value) {
		handle().yBodyRotO = value;
	}

	@Override
	public float getHeadYaw() {
		return handle().yHeadRot;
	}

	@Override
	public void setHeadYaw(float value) {
		handle().yHeadRot = value;
	}

	@Override
	public float getPrevHeadYaw() {
		return handle().yHeadRotO;
	}

	@Override
	public void setPrevHeadYaw(float value) {
		handle().yHeadRotO = value;
	}

	@Override
	public Arm getMainArm() {
		return transliteration.getEnumWrapper().getArm().of(handle().getMainArm());
	}
	
	@Override
	public ItemStack getActiveItemStack() {
		return transliteration.creationWrapper().getItemStack().of(handle().getUseItem());
	}
	
	@Override
	public boolean isUsingItem() {
		return handle().isUsingItem();
	}

	@Override
	public ItemStack getStackInHand(Hand hand) {
		return transliteration.creationWrapper().getItemStack().of(handle().getItemInHand((InteractionHand)hand.getHandler()));
	}

	@Override
	public boolean isSleeping() {
		return handle().isSleeping();
	}

	@Override
	public Hand getActiveHand() {
		return transliteration.getEnumWrapper().getHand().of(handle().getUsedItemHand());
	}

	@Override
	public int getItemUseTime() {
		return handle().getTicksUsingItem();
	}

	@Override
	public int getItemUseTimeLeft() {
		return handle().getUseItemRemainingTicks();
	}

	@Override
	public boolean isHandSwinging() {
		return handle().swinging;
	}
	
	@Override
	public ItemStack getOffHandStack() {
		return getStackInHand(transliteration.getEnumWrapper().getHand().getOffHand());
	}

	@Override
	public ItemStack getMainHandStack() {
		return getStackInHand(transliteration.getEnumWrapper().getHand().getMainHand());
	}

	@Override
	public boolean isClimbing() {
		return handle().onClimbable();
	}

	@Override
	public Optional<Vector3i> getClimbingPos() {
		return handle().getLastClimbablePos().map(v -> transliteration.creationWrapper().getVector3i().of(v));
	}


}
