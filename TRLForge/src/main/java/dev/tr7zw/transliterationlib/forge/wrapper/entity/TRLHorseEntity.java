package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import net.minecraft.world.entity.animal.horse.Horse;

public class TRLHorseEntity<T extends TRLHorseEntity<T, B>, B extends Horse> extends TRLLivingEntity<T, B> implements dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity  {

	@Override
	public float getLimbAngle() {
		return handle().animationPosition;
	}

}
