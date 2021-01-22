package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

public class TRLPlayer<T extends TRLPlayer<T, B>, B extends PlayerEntity> extends TRLEntityLiving<T, B> implements Player {

	@Override
	public boolean isUsingItem() {
		return isUsingItem();
	}

	@Override
	public ItemStack getActiveItemStack() {
		return transliteration.creationWrapper().getItemStack().of(handle().getActiveItem());
	}


}
