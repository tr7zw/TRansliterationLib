package dev.tr7zw.transliterationlib.api.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.entity.*;
import dev.tr7zw.transliterationlib.api.wrapper.item.*;
import dev.tr7zw.transliterationlib.api.wrapper.model.*;
import dev.tr7zw.transliterationlib.api.wrapper.util.*;
import dev.tr7zw.transliterationlib.api.wrapper.world.*;

public interface Wrapper {

  public Entity getBestMatchingEntityWrapper(Object entity);

  public LivingEntity getBestMatchingLivingEntityWrapper(Object entity);

  public EntityModel getBestMatchingEntityModel(Object entityModel);

  public Entity getEntity();

  public LivingEntity getLivingEntity();

  public ClientPlayer getClientPlayer();

  public Player getPlayer();

  public ItemStack getItemStack();

  public Item getItem();

  public BoatEntity getBoatEntity();

  public ModelPart getModelPart();

  public PlayerEntityModel getPlayerEntityModel();

  public HorseEntity getHorseEntity();

  public Vector3f getVector3f();

  public Quaternion getQuaternion();

  public MatrixStack getMatrixStack();

  public VertexConsumerProvider getVertexConsumerProvider();

  public EntityModel getEntityModel();

  public ModelWithArms getModelWithArms();

  public World getWorld();

  public Vector3d getVector3d();

  public Vector3i getVector3i();

  public dev.tr7zw.transliterationlib.api.wrapper.util.Identifier getIdentifier();

  public dev.tr7zw.transliterationlib.api.wrapper.util.Keybind getKeybind();
}
