package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalLivingEntity;

public interface LivingEntity extends InternalLivingEntity, Entity{

	public LivingEntity of(Object handle);
	
}
