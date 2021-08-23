package dev.tr7zw.transliterationlib.fabric.wrapper.api;

public class NormalWrapper extends AbstractWrapperBase {

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.item.Item getItem() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItem();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f getVector3f() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLVector3f();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.world.World getWorld() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.world.TRLWorld();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d getVector3d() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLVector3d();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.BoatEntity getBoatEntity() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLBoatEntity();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer getClientPlayer() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLClientPlayer();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Identifier getIdentifier() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLIdentifier();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel getPlayerEntityModel() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.model.TRLPlayerEntityModel();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack getItemStack() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItemStack();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart getModelPart() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.model.TRLModelPart();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack getMatrixStack() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLMatrixStack();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i getVector3i() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLVector3i();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion getQuaternion() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLQuaternion();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider
      getVertexConsumerProvider() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLVertexConsumerProvider();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel getEntityModel() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.model.TRLEntityModel();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.Player getPlayer() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLPlayer();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.Entity getEntity() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLEntity();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.util.Keybind getKeybind() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLKeybind();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.model.ModelWithArms getModelWithArms() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.model.TRLModelWithArms();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity getHorseEntity() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLHorseEntity();
  }

  @Override
  public dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity getLivingEntity() {
    return new dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLLivingEntity();
  }
}
