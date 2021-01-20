package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalPlayer;

public interface Player extends InternalPlayer, LivingEntity {

	public Player of(Object handle);
	
}
