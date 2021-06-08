package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalClientPlayer;

@AddToWrapper
public interface ClientPlayer extends InternalClientPlayer, Player{

	public ClientPlayer of(Object handle);
	
}
