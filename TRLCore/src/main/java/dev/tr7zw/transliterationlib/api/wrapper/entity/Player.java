package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalPlayer;

@AddToWrapper
public interface Player extends InternalPlayer, LivingEntity {

	public Player of(Object handle);
	
}
