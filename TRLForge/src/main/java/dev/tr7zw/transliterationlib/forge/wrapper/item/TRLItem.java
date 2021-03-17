package dev.tr7zw.transliterationlib.forge.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.item.UseAction;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

public class TRLItem extends AbstractWrapper<Item, TRLItem, dev.tr7zw.transliterationlib.api.wrapper.item.Item>
implements dev.tr7zw.transliterationlib.api.wrapper.item.Item {

	@Override
	public int getMaxUseTime(ItemStack item) {
		return handle().getUseDuration(((TRLItemStack)item).handle());
	}

	@Override
	public UseAction getUseAction(ItemStack item) {
		UseAction action = transliteration.getEnumWrapper().getUseAction();
		net.minecraft.item.UseAction ac = handle().getUseAction(((TRLItemStack)item).handle());
		switch(ac) {
		case BLOCK:
			return action.getBlock();
		case BOW:
			return action.getBow();
		case CROSSBOW:
			return action.getCrossbow();
		case DRINK:
			return action.getDrink();
		case EAT:
			return action.getEat();
		case SPEAR:
			return action.getSpear();
		default:
			return action.getNone();
		}
	}

	@Override
	public String getKeyPath() {
		return Registry.ITEM.getKey(getHandler()).getPath();
	}
	
}
