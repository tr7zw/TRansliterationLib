package dev.tr7zw.transliterationlib.api.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.entity.BoatEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart;
import dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;

public interface Wrapper {

	public Entity getEntity();
	public LivingEntity getLivingEntity();
	public Identifier getIdentifier();
	public ClientPlayer getClientPlayer();
	public Player getPlayer();
	public ItemStack getItemStack();
	public Item getItem();
	public BoatEntity getBoatEntity();
	public Entity getBestMatchingEntityWrapper(Object entity);
	public LivingEntity getBestMatchingLivingEntityWrapper(Object entity);
	public ModelPart getModelPart();
	public PlayerEntityModel getPlayerEntityModel();
	public HorseEntity getHorseEntity();
	
}
