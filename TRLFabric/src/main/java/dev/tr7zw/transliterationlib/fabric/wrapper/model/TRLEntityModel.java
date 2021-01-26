package dev.tr7zw.transliterationlib.fabric.wrapper.model;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.Entity;

public class TRLEntityModel<T extends TRLEntityModel<T, B>, B extends EntityModel<Entity>>
extends AbstractWrapper<B, T, T>
implements dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel, HandleHolder<T> {

}
