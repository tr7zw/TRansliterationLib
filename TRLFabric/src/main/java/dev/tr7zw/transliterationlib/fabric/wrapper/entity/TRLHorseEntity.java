package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import net.minecraft.entity.passive.HorseEntity;

public class TRLHorseEntity<T extends TRLHorseEntity<T, B>, B extends HorseEntity> extends TRLEntityLiving<T, B> implements dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity  {

	@Override
	public float getLimbAngle() {
		return handle().limbAngle;
	}

}
