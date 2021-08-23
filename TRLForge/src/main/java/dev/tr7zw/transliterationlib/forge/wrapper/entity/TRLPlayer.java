package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import net.minecraft.world.entity.Pose;

public class TRLPlayer<T extends TRLPlayer<T, B>, B extends net.minecraft.world.entity.player.Player> extends TRLLivingEntity<T, B> implements Player {

	@Override
	public boolean isCrawling() {
		return handle().getPose() == Pose.SWIMMING;
	}


}
