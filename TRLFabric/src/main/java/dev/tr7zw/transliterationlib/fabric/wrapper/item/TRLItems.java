package dev.tr7zw.transliterationlib.fabric.wrapper.item;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.Items;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLIdentifier;
import net.minecraft.util.registry.Registry;

public class TRLItems implements Items {

	private Item AIR = transliteration.creationWrapper().getItem().of(net.minecraft.item.Items.AIR);

	@Override
	public Item getAir() {
		return AIR;
	}

	@Override
	public Item getItem(Identifier id) {
		return transliteration.creationWrapper().getItem().of(Registry.ITEM.get(((TRLIdentifier)id).handle()));
	}


}
