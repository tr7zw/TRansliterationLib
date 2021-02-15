package dev.tr7zw.transliterationlib.forge.wrapper.world;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import net.minecraft.world.World;

public class TRLWorld 
extends AbstractWrapper<World, TRLWorld, dev.tr7zw.transliterationlib.api.wrapper.world.World>
implements dev.tr7zw.transliterationlib.api.wrapper.world.World {

	@Override
	public Entity getEntityById(int id) {
		return transliteration.creationWrapper().getBestMatchingEntityWrapper(handle().getEntityByID(id));
	}

}
