package dev.tr7zw.transliterationlib.forge.mixins;

import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.tr7zw.transliterationlib.api.event.RenderEvent;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.LivingEntity;

@Mixin(PlayerModel.class)
public abstract class PlayerEntityModelMixin<T extends LivingEntity> extends BipedModel<T> {

	public PlayerEntityModelMixin(float scale) {
		super(scale);
	}

	@Inject(method = "setRotationAngles", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/model/ModelRenderer;copyModelAngles(Lnet/minecraft/client/renderer/model/ModelRenderer;)V", ordinal = 0))
	public void setAnglesEnd(T livingEntity, float f, float g, float tick, float i, float j, CallbackInfo info) {
		RenderEvent.SET_ANGLES_END.invoker().onSet(
				transliteration.singletonWrapper().getBestMatchingLivingEntityWrapper(livingEntity),
				transliteration.singletonWrapper().getPlayerEntityModel().of(this), tick, info);
	}

}
