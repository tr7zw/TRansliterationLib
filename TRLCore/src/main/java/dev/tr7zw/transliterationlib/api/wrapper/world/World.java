package dev.tr7zw.transliterationlib.api.wrapper.world;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;

public interface World extends HandleHolder<World> {

	public Entity getEntityById(int id);
	
}
