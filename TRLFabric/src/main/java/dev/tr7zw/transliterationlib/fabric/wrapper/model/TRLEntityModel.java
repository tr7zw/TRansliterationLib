package dev.tr7zw.transliterationlib.fabric.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import net.minecraft.world.entity.Entity;

public class TRLEntityModel<T extends TRLEntityModel<T, B>, B extends net.minecraft.client.model.EntityModel<Entity>>
extends AbstractWrapper<B, T, T>
implements dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel, HandleHolder<T> {

}
