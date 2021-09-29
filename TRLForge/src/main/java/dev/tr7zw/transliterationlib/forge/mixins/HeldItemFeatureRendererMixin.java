package dev.tr7zw.transliterationlib.forge.mixins;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.blaze3d.vertex.PoseStack;

import dev.tr7zw.transliterationlib.api.event.RenderEvent;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

@Mixin(ItemInHandLayer.class)
public abstract class HeldItemFeatureRendererMixin<T extends LivingEntity, M extends EntityModel<T>>
        extends RenderLayer<T, M> {

    public HeldItemFeatureRendererMixin(RenderLayerParent<T, M> renderLayerParent) {
        super(renderLayerParent);
    }

    @Inject(at = @At("HEAD"), method = "renderArmWithItem", cancellable = true)
    private void renderArmWithItem(LivingEntity livingEntity, ItemStack itemStack, TransformType transformType, HumanoidArm humanoidArm, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, CallbackInfo ci) {
        RenderEvent.RENDER_HELD_ITEM.invoker().onRender(
                transliteration.singletonWrapper().getBestMatchingLivingEntityWrapper(livingEntity),
                transliteration.singletonWrapper().getBestMatchingEntityModel(this.getParentModel()),
                transliteration.singletonWrapper().getItemStack().of(itemStack),
                transliteration.getEnumWrapper().getArm().of(humanoidArm),
                transliteration.singletonWrapper().getMatrixStack().of(poseStack),
                transliteration.singletonWrapper().getVertexConsumerProvider().of(multiBufferSource), i, ci);
    }

}
