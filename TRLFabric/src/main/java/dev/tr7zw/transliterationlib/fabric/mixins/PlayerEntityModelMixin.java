package dev.tr7zw.transliterationlib.fabric.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.tr7zw.transliterationlib.api.event.RenderEvent;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.LivingEntity;
import static dev.tr7zw.transliterationlib.api.TRansliterationLib.transliteration;

@Mixin(PlayerEntityModel.class)
public abstract class PlayerEntityModelMixin<T extends LivingEntity> extends BipedEntityModel<T> {

	public PlayerEntityModelMixin(float scale) {
		super(scale);
	}

	@Inject(method = "setAngles", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/ModelPart;copyPositionAndRotation(Lnet/minecraft/client/model/ModelPart;)V", ordinal = 0))
	public void setAnglesEnd(T livingEntity, float f, float g, float tick, float i, float j, CallbackInfo info) {
		RenderEvent.SET_ANGLES_END.invoker().onSet(
				transliteration.singletonWrapper().getBestMatchingLivingEntityWrapper(livingEntity),
				transliteration.singletonWrapper().getPlayerEntityModel().of(this), tick, info);
	}

}
