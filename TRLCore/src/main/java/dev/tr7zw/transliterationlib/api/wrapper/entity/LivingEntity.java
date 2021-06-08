package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalLivingEntity;

@AddToWrapper
public interface LivingEntity extends InternalLivingEntity, Entity{

	public LivingEntity of(Object handle);
	
}
