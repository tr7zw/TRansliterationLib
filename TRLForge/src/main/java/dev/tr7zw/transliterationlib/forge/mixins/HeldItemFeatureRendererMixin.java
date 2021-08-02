package dev.tr7zw.transliterationlib.forge.mixins;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.tr7zw.transliterationlib.api.event.RenderEvent;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@Mixin(ItemInHandLayer.class)
public abstract class HeldItemFeatureRendererMixin<T extends LivingEntity, M extends EntityModel<T>>
		extends RenderLayer<T, M> {


	public HeldItemFeatureRendererMixin(RenderLayerParent<T, M> p_117346_) {
		super(p_117346_);
	}

	@Inject(at = @At("HEAD"), method = "renderArmWithItem", cancellable = true)
	private void renderArmWithItem(LivingEntity entity, ItemStack stack, ItemTransforms.TransformType p_229135_3_,
			HumanoidArm arm, MatrixStack matrices, MultiBufferSource vertexConsumers, int light, CallbackInfo info) {
		RenderEvent.RENDER_HELD_ITEM.invoker().onRender(
				transliteration.singletonWrapper().getBestMatchingLivingEntityWrapper(entity),
				transliteration.singletonWrapper().getBestMatchingEntityModel(this.getParentModel()),
				transliteration.singletonWrapper().getItemStack().of(stack),
				transliteration.getEnumWrapper().getArm().of(arm),
				transliteration.singletonWrapper().getMatrixStack().of(matrices),
				transliteration.singletonWrapper().getVertexConsumerProvider().of(vertexConsumers), light, info);
	}

}
