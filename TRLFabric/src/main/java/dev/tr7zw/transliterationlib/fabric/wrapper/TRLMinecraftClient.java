package dev.tr7zw.transliterationlib.fabric.wrapper;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import net.minecraft.client.MinecraftClient;

public class TRLMinecraftClient extends AbstractWrapper<MinecraftClient, TRLMinecraftClient, dev.tr7zw.transliterationlib.api.wrapper.MinecraftClient>
implements dev.tr7zw.transliterationlib.api.wrapper.MinecraftClient {

	@Override
	public float getTickDelta() {
		return handle().getTickDelta();
	}

	@Override
	public ClientPlayer getPlayer() {
		return transliteration.creationWrapper().getClientPlayer().of(handle().player);
	}


}
