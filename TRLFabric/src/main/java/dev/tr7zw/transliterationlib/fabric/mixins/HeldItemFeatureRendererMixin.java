package dev.tr7zw.transliterationlib.fabric.mixins;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.tr7zw.transliterationlib.api.event.RenderEvent;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.feature.HeldItemFeatureRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Arm;

@Mixin(HeldItemFeatureRenderer.class)
public abstract class HeldItemFeatureRendererMixin<T extends LivingEntity, M extends EntityModel<T>>
		extends FeatureRenderer<T, M> {

	public HeldItemFeatureRendererMixin(FeatureRendererContext<T, M> context) {
		super(context);
	}

	@Inject(at = @At("HEAD"), method = "renderItem", cancellable = true)
	private void renderItem(LivingEntity entity, ItemStack stack, ModelTransformation.Mode transformationMode, Arm arm,
			MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo info) {
		RenderEvent.RENDER_HELD_ITEM.invoker().onRender(
				transliteration.singletonWrapper().getBestMatchingLivingEntityWrapper(entity),
				transliteration.singletonWrapper().getBestMatchingEntityModel(getContextModel()),
				transliteration.singletonWrapper().getItemStack().of(stack),
				transliteration.getEnumWrapper().getArm().of(arm),
				transliteration.singletonWrapper().getMatrixStack().of(matrices),
				transliteration.singletonWrapper().getVertexConsumerProvider().of(vertexConsumers), light, info);
	}

}
