package dev.tr7zw.transliterationlib.forge.wrapper.api;

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
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLBoatEntity;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLClientPlayer;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLEntity;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLEntityLiving;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLHorseEntity;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLPlayer;
import dev.tr7zw.transliterationlib.forge.wrapper.item.TRLItem;
import dev.tr7zw.transliterationlib.forge.wrapper.item.TRLItemStack;
import dev.tr7zw.transliterationlib.forge.wrapper.model.TRLModelPart;
import dev.tr7zw.transliterationlib.forge.wrapper.model.TRLPlayerEntityModel;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLIdentifier;

public class NormalWrapper extends AbstractWrapperBase {

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

	@Override
	public LivingEntity getLivingEntity() {
		return new TRLEntityLiving<>();
	}

	@Override
	public BoatEntity getBoatEntity() {
		return new TRLBoatEntity<>();
	}

	@Override
	public ModelPart getModelPart() {
		return new TRLModelPart();
	}

	@Override
	public PlayerEntityModel getPlayerEntityModel() {
		return new TRLPlayerEntityModel();
	}

	@Override
	public HorseEntity getHorseEntity() {
		return new TRLHorseEntity<>();
	}

}