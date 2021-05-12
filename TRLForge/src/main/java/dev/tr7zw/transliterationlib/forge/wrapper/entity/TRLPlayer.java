package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;

public class TRLPlayer<T extends TRLPlayer<T, B>, B extends PlayerEntity> extends TRLLivingEntity<T, B> implements Player {

	@Override
	public boolean isCrawling() {
		return handle().getPose() == Pose.SWIMMING;
	}


}
