package dev.tr7zw.transliterationlib.forge.wrapper.item;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.Items;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLIdentifier;
import net.minecraft.util.registry.Registry;

public class TRLItems implements Items {

	@Override
	public Item getAir() {
		return transliteration.creationWrapper().getItem().of(net.minecraft.item.Items.AIR);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Item getItem(Identifier id) {
		return transliteration.creationWrapper().getItem().of(Registry.ITEM.getOrDefault(((TRLIdentifier)id).handle()));
	}


}
