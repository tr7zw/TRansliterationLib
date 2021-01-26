package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.entity.BoatEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.HorseEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import dev.tr7zw.transliterationlib.api.wrapper.item.Item;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.model.ModelPart;
import dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f;
import dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLBoatEntity;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLClientPlayer;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLEntity;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLEntityLiving;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLHorseEntity;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLPlayer;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItem;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItemStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.model.TRLModelPart;
import dev.tr7zw.transliterationlib.fabric.wrapper.model.TRLPlayerEntityModel;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLIdentifier;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLMatrixStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLQuaternion;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLVector3f;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLVertexConsumerProvider;
import lombok.Getter;

@Getter
public class SingletonWrapper extends AbstractWrapperBase {

	private final Entity entity = new TRLEntity<>();
	private final Identifier identifier = new TRLIdentifier();
	private final ClientPlayer clientPlayer = new TRLClientPlayer<>();
	private final Player player = new TRLPlayer<>();
	private final ItemStack itemStack = new TRLItemStack();
	private final Item item = new TRLItem();
	private final LivingEntity livingEntity = new TRLEntityLiving<>();
	private final BoatEntity boatEntity = new TRLBoatEntity<>();
	private final PlayerEntityModel playerEntityModel = new TRLPlayerEntityModel();
	private final ModelPart modelPart = new TRLModelPart();
	private final HorseEntity horseEntity = new TRLHorseEntity<>();
	private final Vector3f vector3f = new TRLVector3f();
	private final Quaternion quaternion = new TRLQuaternion();
	private final MatrixStack matrixStack = new TRLMatrixStack();
	private final VertexConsumerProvider vertexConsumerProvider = new TRLVertexConsumerProvider();

}
