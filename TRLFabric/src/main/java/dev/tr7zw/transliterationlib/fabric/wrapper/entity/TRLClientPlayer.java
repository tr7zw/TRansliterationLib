package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import net.minecraft.client.network.AbstractClientPlayerEntity;

public class TRLClientPlayer extends AbstractWrapper<AbstractClientPlayerEntity, TRLClientPlayer, ClientPlayer>
		implements ClientPlayer {

	@Override
	public int getId() {
		return handle().getEntityId();
	}

}
