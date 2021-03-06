package dev.tr7zw.transliterationlib.forge.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity;
import dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;

public abstract class AbstractWrapperBase implements Wrapper {

	@Override
	public Entity getBestMatchingEntityWrapper(Object handle) {
		if (handle instanceof AbstractClientPlayerEntity)
			return getClientPlayer().of(handle);
		if (handle instanceof PlayerEntity)
			return getPlayer().of(handle);
		if(handle instanceof BoatEntity)
			return getBoatEntity().of(handle);
		if(handle instanceof HorseEntity)
			return getHorseEntity().of(handle);
		if (handle instanceof net.minecraft.entity.LivingEntity)
			return getLivingEntity().of(handle);
		if (handle instanceof net.minecraft.entity.Entity)
			return getEntity().of(handle);
		return null;
	}

	@Override
	public LivingEntity getBestMatchingLivingEntityWrapper(Object entity) {
		return (LivingEntity) getBestMatchingEntityWrapper(entity);
	}
	
	@Override
	public EntityModel getBestMatchingEntityModel(Object handle) {
		if(handle instanceof PlayerModel<?>) {
			return getPlayerEntityModel().of(handle);
		}
		if(handle instanceof IHasArm) {
			return getModelWithArms().of(handle);
		}
		if(handle instanceof net.minecraft.client.renderer.entity.model.EntityModel<?>) {
			return getEntityModel().of(handle);
		}
		return null;
	}
	

}
