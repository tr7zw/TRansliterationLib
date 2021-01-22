package dev.tr7zw.transliterationlib.api.wrapper.internal;

import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;

public interface InternalPlayer {

	public boolean isUsingItem();
	public ItemStack getActiveItemStack();
	
}
