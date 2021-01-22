package dev.tr7zw.transliterationlib.api.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;

public interface Wrapper {

	public Entity getEntity();
	public Identifier getIdentifier();
	public ClientPlayer getClientPlayer();
	public Player getPlayer();
	public ItemStack getItemStack();
	public Item getItem();
	
}
