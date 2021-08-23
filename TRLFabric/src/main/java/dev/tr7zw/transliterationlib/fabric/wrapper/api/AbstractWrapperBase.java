package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity;
import dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;

public abstract class AbstractWrapperBase implements Wrapper {

	@Override
	public Entity getBestMatchingEntityWrapper(Object handle) {
		if (handle instanceof AbstractClientPlayer)
			return getClientPlayer().of(handle);
		if (handle instanceof Player)
			return getPlayer().of(handle);
		if(handle instanceof Boat)
			return getBoatEntity().of(handle);
		if(handle instanceof Horse)
			return getHorseEntity().of(handle);
		if (handle instanceof net.minecraft.world.entity.LivingEntity)
			return getLivingEntity().of(handle);
		if (handle instanceof net.minecraft.world.entity.Entity)
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
		if(handle instanceof ArmedModel) {
			return getModelWithArms().of(handle);
		}
		if(handle instanceof net.minecraft.client.model.EntityModel<?>) {
			return getEntityModel().of(handle);
		}
		return null;
	}
	

}
