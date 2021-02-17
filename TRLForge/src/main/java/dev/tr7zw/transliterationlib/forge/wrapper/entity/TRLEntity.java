package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d;
import net.minecraft.entity.Entity;
import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

public class TRLEntity<T extends TRLEntity<T, B>, B extends Entity>
		extends AbstractWrapper<B, T, T>
		implements dev.tr7zw.transliterationlib.api.wrapper.entity.Entity, HandleHolder<T> {

	@Override
	public int getId() {
		return handle().getEntityId();
	}

	@Override
	public boolean hasVehicle() {
		return handle().isPassenger();
	}
	
	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.entity.Entity getVehicle() {
		return transliteration.creationWrapper().getBestMatchingEntityWrapper(handle().getRidingEntity());
	}

	@Override
	public float getPitch() {
		return handle().rotationPitch;
	}

	@Override
	public void setPitch(float amount) {
		handle().rotationPitch = amount;
	}

	@Override
	public float getYaw() {
		return handle().rotationYaw;
	}

	@Override
	public void setYaw(float amount) {
		handle().rotationYaw = amount;
	}

	@Override
	public Vector3d getPos() {
		return transliteration.creationWrapper().getVector3d().of(handle().getPositionVec());
	}

	@Override
	public Vector3d getVelocity() {
		return transliteration.creationWrapper().getVector3d().of(handle().getMotion());
	}
	
}
