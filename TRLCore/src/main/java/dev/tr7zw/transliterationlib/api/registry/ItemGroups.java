package dev.tr7zw.transliterationlib.api.registry;

import java.util.List;

import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;

public interface ItemGroups {

	public void registerItemGroup(Identifier id, ItemStack icon, List<ItemStack> items);
	
}
