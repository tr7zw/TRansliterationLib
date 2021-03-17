package dev.tr7zw.transliterationlib.api.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

public interface Item extends HandleHolder<Item> {

	public int getMaxUseTime(ItemStack item);
	public UseAction getUseAction(ItemStack item);
	public String getKeyPath();
	
}
