package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import net.minecraft.client.player.AbstractClientPlayer;

public class TRLClientPlayer<T extends TRLClientPlayer<T>> extends TRLPlayer<T, AbstractClientPlayer> implements ClientPlayer {

}
