package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import net.minecraft.entity.player.PlayerEntity;

public class TRLClientPlayer<T extends TRLClientPlayer<T>> extends TRLPlayer<T, PlayerEntity> implements ClientPlayer {

}
