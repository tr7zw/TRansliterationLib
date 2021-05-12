package dev.tr7zw.transliterationlib.api.wrapper.item;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@AddToWrapper
public interface ItemStack extends HandleHolder<ItemStack> {

	public Item getItem();
	public boolean isEmpty();
	public UseAction getUseAction();
	
}
