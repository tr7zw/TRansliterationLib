package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d;
import net.minecraft.world.entity.Entity;

public class TRLEntity<T extends TRLEntity<T, B>, B extends Entity>
		extends AbstractWrapper<B, T, T>
		implements dev.tr7zw.transliterationlib.api.wrapper.entity.Entity, HandleHolder<T> {

	@Override
	public int getId() {
		return handle().getId();
	}

	@Override
	public boolean hasVehicle() {
		return handle().isPassenger();
	}
	
	@Override
	public dev.tr7zw.transliterationlib.api.wrapper.entity.Entity getVehicle() {
		return transliteration.creationWrapper().getBestMatchingEntityWrapper(handle().getVehicle());
	}

	@Override
	public float getPitch() {
		return handle().getXRot();
	}

	@Override
	public void setPitch(float amount) {
		handle().setXRot(amount);
	}

	@Override
	public float getYaw() {
		return handle().getYRot();
	}

	@Override
	public void setYaw(float amount) {
		handle().setYRot(amount);
	}

	@Override
	public Vector3d getPos() {
		return transliteration.creationWrapper().getVector3d().of(handle().position());
	}

	@Override
	public Vector3d getVelocity() {
		return transliteration.creationWrapper().getVector3d().of(handle().getDeltaMovement());
	}

	@Override
	public int getAge() {
		return handle().tickCount;
	}
	
}
