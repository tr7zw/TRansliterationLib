package dev.tr7zw.transliterationlib.api.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

public interface ItemStack extends HandleHolder<ItemStack> {

	public Item getItem();
	public boolean isEmpty();
	
}
