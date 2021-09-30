package dev.tr7zw.transliterationlib.forge.wrapper.api;

public class SingletonWrapper extends AbstractWrapperBase {

  private final dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack getitemstack =
      new dev.tr7zw.transliterationlib.forge.wrapper.item.TRLItemStack();
  private final dev.tr7zw.transliterationlib.api.wrapper.world.World getworld =
      new dev.tr7zw.transliterationlib.forge.wrapper.world.TRLWorld();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d getvector3d =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVector3d();
  private final dev.tr7zw.transliterationlib.api.wrapper.entity.BoatEntity getboatentity =
      new dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLBoatEntity();
  private final dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity gethorseentity =
      new dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLHorseEntity();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider
      getvertexconsumerprovider =
          new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVertexConsumerProvider();
  private final dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel getentitymodel =
      new dev.tr7zw.transliterationlib.forge.wrapper.model.TRLEntityModel();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack getmatrixstack =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLMatrixStack();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion getquaternion =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLQuaternion();
  private final dev.tr7zw.transliterationlib.api.wrapper.entity.Entity getentity =
      new dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLEntity();
  private final dev.tr7zw.transliterationlib.api.wrapper.item.Item getitem =
      new dev.tr7zw.transliterationlib.forge.wrapper.item.TRLItem();
  private final dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity getlivingentity =
      new dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLLivingEntity();
  private final dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getmodelpart =
      new dev.tr7zw.transliterationlib.forge.wrapper.model.TRLModelPart();
  private final dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel
      getplayerentitymodel =
          new dev.tr7zw.transliterationlib.forge.wrapper.model.TRLPlayerEntityModel();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i getvector3i =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVector3i();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f getvector3f =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVector3f();
  private final dev.tr7zw.transliterationlib.api.wrapper.entity.Player getplayer =
      new dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLPlayer();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Keybind getkeybind =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLKeybind();
  private final dev.tr7zw.transliterationlib.api.wrapper.util.Identifier getidentifier =
      new dev.tr7zw.transliterationlib.forge.wrapper.util.TRLIdentifier();
  private final dev.tr7zw.transliterationlib.api.wrapper.model.ModelWithArms getmodelwitharms =
      new dev.tr7zw.transliterationlib.forge.wrapper.model.TRLModelWithArms();
  private final dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer getclientplayer =
      new dev.tr7zw.transliterationlib.forge.wrapper.entity.TRLClientPlayer();

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack getItemStack() {
    return getitemstack;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.world.World getWorld() {
    return getworld;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d getVector3d() {
    return getvector3d;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.BoatEntity getBoatEntity() {
    return getboatentity;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity getHorseEntity() {
    return gethorseentity;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider
      getVertexConsumerProvider() {
    return getvertexconsumerprovider;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel getEntityModel() {
    return getentitymodel;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack getMatrixStack() {
    return getmatrixstack;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion getQuaternion() {
    return getquaternion;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.Entity getEntity() {
    return getentity;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.item.Item getItem() {
    return getitem;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity getLivingEntity() {
    return getlivingentity;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getModelPart() {
    return getmodelpart;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel getPlayerEntityModel() {
    return getplayerentitymodel;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i getVector3i() {
    return getvector3i;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f getVector3f() {
    return getvector3f;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.Player getPlayer() {
    return getplayer;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Keybind getKeybind() {
    return getkeybind;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Identifier getIdentifier() {
    return getidentifier;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.model.ModelWithArms getModelWithArms() {
    return getmodelwitharms;
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer getClientPlayer() {
    return getclientplayer;
  }
}
