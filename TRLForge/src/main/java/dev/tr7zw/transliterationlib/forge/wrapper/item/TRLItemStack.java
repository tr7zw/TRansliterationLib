package dev.tr7zw.transliterationlib.forge.wrapper.item;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.UseAction;
import net.minecraft.world.item.ItemStack;

public class TRLItemStack extends AbstractWrapper<ItemStack, TRLItemStack, dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack>
implements dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack {

	@Override
	public Item getItem() {
		return transliteration.creationWrapper().getItem().of(handle().getItem());
	}

	@Override
	public boolean isEmpty() {
		return handle().isEmpty();
	}

	@Override
	public UseAction getUseAction() {
		return transliteration.getEnumWrapper().getUseAction().of(handle().getUseAnimation());
	}

}
