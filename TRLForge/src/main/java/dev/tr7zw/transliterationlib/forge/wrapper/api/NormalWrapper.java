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

public class NormalWrapper extends AbstractWrapperBase {

	@Override
	public Entity getEntity() {
		return new TRLEntity<>();
	}

	@Override
	public Identifier getIdentifier() {
		return new TRLIdentifier();
	}

	@Override
	public ClientPlayer getClientPlayer() {
		return new TRLClientPlayer<>();
	}

	@Override
	public Player getPlayer() {
		return new TRLPlayer<>();
	}

	@Override
	public ItemStack getItemStack() {
		return new TRLItemStack();
	}

	@Override
	public Item getItem() {
		return new TRLItem();
	}

	@Override
	public LivingEntity getLivingEntity() {
		return new TRLEntityLiving<>();
	}

	@Override
	public BoatEntity getBoatEntity() {
		return new TRLBoatEntity<>();
	}

	@Override
	public ModelPart getModelPart() {
		return new TRLModelPart();
	}

	@Override
	public PlayerEntityModel getPlayerEntityModel() {
		return new TRLPlayerEntityModel<>();
	}

	@Override
	public HorseEntity getHorseEntity() {
		return new TRLHorseEntity<>();
	}

	@Override
	public Vector3f getVector3f() {
		return new TRLVector3f();
	}

	@Override
	public Quaternion getQuaternion() {
		return new TRLQuaternion();
	}

	@Override
	public MatrixStack getMatrixStack() {
		return new TRLMatrixStack();
	}

	@Override
	public VertexConsumerProvider getVertexConsumerProvider() {
		return new TRLVertexConsumerProvider();
	}

	@Override
	public EntityModel getEntityModel() {
		return new TRLEntityModel<>();
	}

	@Override
	public ModelWithArms getModelWithArms() {
		return new TRLModelWithArms<>();
	}
	
	@Override
	public Keybind getKeybind() {
		return new TRLKeybind();
	}
	
	@Override
	public World getWorld() {
		return new TRLWorld();
	}

	@Override
	public Vector3d getVector3d() {
		return new TRLVector3d();
	}

	@Override
	public Vector3i getVector3i() {
		return new TRLVector3i();
	}

	
}
