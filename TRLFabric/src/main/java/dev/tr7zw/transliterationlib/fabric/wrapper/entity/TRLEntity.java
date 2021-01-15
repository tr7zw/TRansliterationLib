package dev.tr7zw.transliterationlib.fabric.wrapper.entity;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.entity.Entity;

public class TRLEntity
		extends AbstractWrapper<Entity, TRLEntity, dev.tr7zw.transliterationlib.api.wrapper.entity.Entity>
		implements dev.tr7zw.transliterationlib.api.wrapper.entity.Entity {

	@Override
	public int getId() {
		return handle().getEntityId();
	}

}
