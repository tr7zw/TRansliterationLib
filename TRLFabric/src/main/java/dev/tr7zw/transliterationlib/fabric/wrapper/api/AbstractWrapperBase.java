package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity;
import dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.model.ModelWithArms;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.passive.HorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;

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
		if(handle instanceof PlayerEntityModel<?>) {
			return getPlayerEntityModel().of(handle);
		}
		if(handle instanceof ModelWithArms) {
			return getModelWithArms().of(handle);
		}
		if(handle instanceof net.minecraft.client.render.entity.model.EntityModel<?>) {
			return getEntityModel().of(handle);
		}
		return null;
	}
	
	

}
