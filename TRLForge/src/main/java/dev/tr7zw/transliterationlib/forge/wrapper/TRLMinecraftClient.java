package dev.tr7zw.transliterationlib.forge.wrapper;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.world.World;
import net.minecraft.client.Minecraft;

public class TRLMinecraftClient extends AbstractWrapper<Minecraft, TRLMinecraftClient, dev.tr7zw.transliterationlib.api.wrapper.MinecraftClient>
implements dev.tr7zw.transliterationlib.api.wrapper.MinecraftClient {

	@Override
	public float getTickDelta() {
		return handle().getTickLength();
	}

	@Override
	public ClientPlayer getPlayer() {
		return transliteration.singletonWrapper().getClientPlayer().of(handle().player);
	}

	@Override
	public World getWorld() {
		return transliteration.singletonWrapper().getWorld().of(handle().world);
	}


}
