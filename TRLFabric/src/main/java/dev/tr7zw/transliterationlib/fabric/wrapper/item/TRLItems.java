package dev.tr7zw.transliterationlib.fabric.wrapper.item;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.Items;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLIdentifier;
import net.minecraft.core.Registry;

public class TRLItems implements Items {

	@Override
	public Item getAir() {
		return transliteration.creationWrapper().getItem().of(net.minecraft.world.item.Items.AIR);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Item getItem(Identifier id) {
		return transliteration.creationWrapper().getItem().of(Registry.ITEM.get(((TRLIdentifier)id).handle()));
	}


}
