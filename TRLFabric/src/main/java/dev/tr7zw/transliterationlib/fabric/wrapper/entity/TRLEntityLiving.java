package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import net.minecraft.entity.LivingEntity;

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

}
