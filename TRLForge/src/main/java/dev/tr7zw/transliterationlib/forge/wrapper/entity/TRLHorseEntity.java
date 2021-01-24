package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import net.minecraft.entity.passive.horse.HorseEntity;

public class TRLHorseEntity<T extends TRLHorseEntity<T, B>, B extends HorseEntity> extends TRLEntityLiving<T, B> implements dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity  {

	@Override
	public float getLimbAngle() {
		return handle().limbSwing;
	}

}
