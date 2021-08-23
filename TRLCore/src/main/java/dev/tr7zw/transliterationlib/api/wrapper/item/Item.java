package dev.tr7zw.transliterationlib.api.wrapper.item;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@AddToWrapper
public interface Item extends HandleHolder<Item> {

	public int getMaxUseTime(ItemStack item);
	public UseAction getUseAction(ItemStack item);
	public String getKeyPath();
	public ItemStack getItemStack();
	
}
