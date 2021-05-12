package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalBoatEntity;

@AddToWrapper
public interface BoatEntity extends InternalBoatEntity, Entity {

	public BoatEntity of(Object handle);
	
}
