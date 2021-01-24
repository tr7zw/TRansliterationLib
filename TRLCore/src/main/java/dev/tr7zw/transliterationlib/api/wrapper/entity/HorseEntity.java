package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalHorseEntity;

public interface HorseEntity extends LivingEntity, InternalHorseEntity {

	public HorseEntity of(Object handle);
	
}
