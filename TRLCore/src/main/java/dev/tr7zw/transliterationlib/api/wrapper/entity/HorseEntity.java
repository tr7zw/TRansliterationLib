package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalHorseEntity;

@AddToWrapper
public interface HorseEntity extends LivingEntity, InternalHorseEntity {

	public HorseEntity of(Object handle);
	
}
