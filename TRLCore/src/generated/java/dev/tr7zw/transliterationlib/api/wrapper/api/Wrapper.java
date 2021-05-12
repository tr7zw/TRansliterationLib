package dev.tr7zw.transliterationlib.api.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.entity.*;
import dev.tr7zw.transliterationlib.api.wrapper.model.*;

public interface Wrapper {

  public Entity getBestMatchingEntityWrapper(Object entity);

  public LivingEntity getBestMatchingLivingEntityWrapper(Object entity);

  public EntityModel getBestMatchingEntityModel(Object entityModel);

  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i getVector3i();

  public dev.tr7zw.transliterationlib.api.wrapper.item.Item getItem();

  public dev.tr7zw.transliterationlib.api.wrapper.entity.Player getPlayer();

  public dev.tr7zw.transliterationlib.api.wrapper.model.ModelWithArms getModelWithArms();

  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d getVector3d();

  public dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack getItemStack();

  public dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel getPlayerEntityModel();

  public dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion getQuaternion();

  public dev.tr7zw.transliterationlib.api.wrapper.entity.BoatEntity getBoatEntity();

  public dev.tr7zw.transliterationlib.api.wrapper.world.World getWorld();

  public dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack getMatrixStack();

  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f getVector3f();

  public dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity getHorseEntity();

  public dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel getEntityModel();

  public dev.tr7zw.transliterationlib.api.wrapper.util.Keybind getKeybind();

  public dev.tr7zw.transliterationlib.api.wrapper.util.Identifier getIdentifier();

  public dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider
      getVertexConsumerProvider();

  public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getModelPart();

  public dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity getLivingEntity();

  public dev.tr7zw.transliterationlib.api.wrapper.entity.Entity getEntity();

  public dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer getClientPlayer();
}
