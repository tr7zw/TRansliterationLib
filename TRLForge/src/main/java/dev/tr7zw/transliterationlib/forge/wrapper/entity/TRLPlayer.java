package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import net.minecraft.entity.player.PlayerEntity;

public class TRLPlayer<T extends TRLPlayer<T, B>, B extends PlayerEntity> extends TRLEntityLiving<T, B> implements Player {


}
