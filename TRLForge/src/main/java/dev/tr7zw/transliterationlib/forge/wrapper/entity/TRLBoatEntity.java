package dev.tr7zw.transliterationlib.forge.wrapper.entity;

import net.minecraft.world.entity.vehicle.Boat;

public class TRLBoatEntity<T extends TRLBoatEntity<T, B>, B extends Boat>
extends TRLEntity<T, B>
implements dev.tr7zw.transliterationlib.api.wrapper.entity.BoatEntity {

	@Override
	public float interpolatePaddlePhase(int side, float tick) {
		return handle().getRowingTime(side, tick);
	}

}
