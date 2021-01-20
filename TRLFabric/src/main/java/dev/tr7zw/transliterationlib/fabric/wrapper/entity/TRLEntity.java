package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import net.minecraft.entity.Entity;

public class TRLEntity<T extends TRLEntity<T, B>, B extends Entity>
		extends AbstractWrapper<B, T, T>
		implements dev.tr7zw.transliterationlib.api.wrapper.entity.Entity, HandleHolder<T> {

	@Override
	public int getId() {
		return handle().getEntityId();
	}
	
}
