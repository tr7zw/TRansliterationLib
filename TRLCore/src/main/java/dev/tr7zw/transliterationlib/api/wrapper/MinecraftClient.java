package dev.tr7zw.transliterationlib.api.wrapper;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;

public interface MinecraftClient extends HandleHolder<MinecraftClient> {

	public float getTickDelta();
	public ClientPlayer getPlayer();
	
}
