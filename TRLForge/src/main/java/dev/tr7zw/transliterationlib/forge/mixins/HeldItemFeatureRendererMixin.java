package dev.tr7zw.transliterationlib.forge.mixins;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.matrix.MatrixStack;

import dev.tr7zw.transliterationlib.api.event.RenderEvent;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;

@Mixin(HeldItemLayer.class)
public abstract class HeldItemFeatureRendererMixin<T extends LivingEntity, M extends EntityModel<T>>
		extends LayerRenderer<T, M> {

	public HeldItemFeatureRendererMixin(IEntityRenderer<T, M> entityRendererIn) {
		super(entityRendererIn);
	}

	@Inject(at = @At("HEAD"), method = "func_229135_a_", cancellable = true)
	private void func_229135_a_(LivingEntity entity, ItemStack stack, ItemCameraTransforms.TransformType p_229135_3_,
			HandSide arm, MatrixStack matrices, IRenderTypeBuffer vertexConsumers, int light, CallbackInfo info) {
		RenderEvent.RENDER_HELD_ITEM.invoker().onRender(
				transliteration.singletonWrapper().getBestMatchingLivingEntityWrapper(entity),
				transliteration.singletonWrapper().getBestMatchingEntityModel(getEntityModel()),
				transliteration.singletonWrapper().getItemStack().of(stack),
				transliteration.getEnumWrapper().getArm().of(arm),
				transliteration.singletonWrapper().getMatrixStack().of(matrices),
				transliteration.singletonWrapper().getVertexConsumerProvider().of(vertexConsumers), light, info);
	}

}
