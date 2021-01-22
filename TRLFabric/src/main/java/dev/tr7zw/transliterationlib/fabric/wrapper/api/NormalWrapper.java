package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLClientPlayer;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLEntity;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLPlayer;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItem;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItemStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLIdentifier;

public class NormalWrapper implements Wrapper {

	@Override
	public Entity getEntity() {
		return new TRLEntity<>();
	}

	@Override
	public Identifier getIdentifier() {
		return new TRLIdentifier();
	}

	@Override
	public ClientPlayer getClientPlayer() {
		return new TRLClientPlayer<>();
	}

	@Override
	public Player getPlayer() {
		return new TRLPlayer<>();
	}

	@Override
	public ItemStack getItemStack() {
		return new TRLItemStack();
	}

	@Override
	public Item getItem() {
		return new TRLItem();
	}

}
