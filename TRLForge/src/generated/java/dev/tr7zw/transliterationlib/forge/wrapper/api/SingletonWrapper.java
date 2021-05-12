package dev.tr7zw.transliterationlib.forge.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.entity.BoatEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel;
import dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart;
import dev.tr7zw.transliterationlib.api.wrapper.model.ModelWithArms;
import dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.api.wrapper.util.Keybind;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i;
import dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider;
import dev.tr7zw.transliterationlib.api.wrapper.world.World;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLBoatEntity;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLClientPlayer;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLEntity;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLEntityLiving;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLHorseEntity;
import dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLPlayer;
import dev.tr7zw.transliterationlib.forge.wrapper.item.TRLItem;
import dev.tr7zw.transliterationlib.forge.wrapper.item.TRLItemStack;
import dev.tr7zw.transliterationlib.forge.wrapper.model.TRLEntityModel;
import dev.tr7zw.transliterationlib.forge.wrapper.model.TRLModelPart;
import dev.tr7zw.transliterationlib.forge.wrapper.model.TRLModelWithArms;
import dev.tr7zw.transliterationlib.forge.wrapper.model.TRLPlayerEntityModel;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLIdentifier;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLKeybind;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLMatrixStack;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLQuaternion;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVector3d;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVector3f;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVector3i;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVertexConsumerProvider;
import dev.tr7zw.transliterationlib.forge.wrapper.world.TRLWorld;

public class SingletonWrapper extends AbstractWrapperBase {

  private final Entity entity = new TRLEntity<>();
  private final ClientPlayer clientPlayer = new TRLClientPlayer<>();
  private final Player player = new TRLPlayer<>();
  private final ItemStack itemStack = new TRLItemStack();
  private final Item item = new TRLItem();
  private final LivingEntity livingEntity = new TRLEntityLiving<>();
  private final BoatEntity boatEntity = new TRLBoatEntity<>();
  private final PlayerEntityModel playerEntityModel = new TRLPlayerEntityModel<>();
  private final ModelPart modelPart = new TRLModelPart();
  private final HorseEntity horseEntity = new TRLHorseEntity<>();
  private final Vector3f vector3f = new TRLVector3f();
  private final MatrixStack matrixStack = new TRLMatrixStack();
  private final VertexConsumerProvider vertexConsumerProvider = new TRLVertexConsumerProvider();
  private final ModelWithArms modelWithArms = new TRLModelWithArms<>();
  private final EntityModel entityModel = new TRLEntityModel<>();
  private final TRLWorld world = new TRLWorld();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Keybind getkeybind =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLKeybind();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d getvector3d =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVector3d();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Identifier getidentifier =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLIdentifier();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i getvector3i =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVector3i();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion getquaternion =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLQuaternion();

  public Entity getEntity() {
    return entity;
  }

  public ClientPlayer getClientPlayer() {
    return clientPlayer;
  }

  public Player getPlayer() {
    return player;
  }

  public ItemStack getItemStack() {
    return itemStack;
  }

  public Item getItem() {
    return item;
  }

  public LivingEntity getLivingEntity() {
    return livingEntity;
  }

  public BoatEntity getBoatEntity() {
    return boatEntity;
  }

  public PlayerEntityModel getPlayerEntityModel() {
    return playerEntityModel;
  }

  public ModelPart getModelPart() {
    return modelPart;
  }

  public HorseEntity getHorseEntity() {
    return horseEntity;
  }

  public Vector3f getVector3f() {
    return vector3f;
  }

  public MatrixStack getMatrixStack() {
    return matrixStack;
  }

  public VertexConsumerProvider getVertexConsumerProvider() {
    return vertexConsumerProvider;
  }

  public ModelWithArms getModelWithArms() {
    return modelWithArms;
  }

  public EntityModel getEntityModel() {
    return entityModel;
  }

  @Override
  public World getWorld() {
    return world;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Keybind getKeybind() {
    return getkeybind;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d getVector3d() {
    return getvector3d;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Identifier getIdentifier() {
    return getidentifier;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i getVector3i() {
    return getvector3i;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion getQuaternion() {
    return getquaternion;
  }
}
