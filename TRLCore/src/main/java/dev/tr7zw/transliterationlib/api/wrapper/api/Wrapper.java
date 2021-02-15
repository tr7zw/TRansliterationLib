package dev.tr7zw.transliterationlib.api.wrapper.api;

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
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f;
import dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider;

public interface Wrapper {

	public Entity getEntity();
	public LivingEntity getLivingEntity();
	public Identifier getIdentifier();
	public ClientPlayer getClientPlayer();
	public Player getPlayer();
	public ItemStack getItemStack();
	public Item getItem();
	public BoatEntity getBoatEntity();
	public Entity getBestMatchingEntityWrapper(Object entity);
	public LivingEntity getBestMatchingLivingEntityWrapper(Object entity);
	public ModelPart getModelPart();
	public PlayerEntityModel getPlayerEntityModel();
	public HorseEntity getHorseEntity();
	public Vector3f getVector3f();
	public Quaternion getQuaternion();
	public MatrixStack getMatrixStack();
	public VertexConsumerProvider getVertexConsumerProvider();
	public EntityModel getEntityModel();
	public ModelWithArms getModelWithArms();
	public EntityModel getBestMatchingEntityModel(Object entityModel);
	public Keybind getKeybind();
	
}
