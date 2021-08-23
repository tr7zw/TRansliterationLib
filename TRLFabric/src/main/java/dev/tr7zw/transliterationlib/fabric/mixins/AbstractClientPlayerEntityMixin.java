package dev.tr7zw.transliterationlib.fabric.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.tr7zw.transliterationlib.api.TRansliterationLib;
import dev.tr7zw.transliterationlib.api.event.PlayerEvents;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.util.WrappedCallbackInfoReturnable;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.resources.ResourceLocation;

@Mixin(AbstractClientPlayer.class)
public class AbstractClientPlayerEntityMixin {

	private ClientPlayer clientPlayer = TRansliterationLib.transliteration.creationWrapper().getClientPlayer().of(this);
	
	@Inject(method = "isSkinLoaded", at = @At("HEAD"), cancellable = true)
	public boolean isSkinLoaded(CallbackInfoReturnable<Boolean> info) {
		PlayerEvents.HAS_SKIN.invoker().hasSkin(clientPlayer, info);
		return false;
	}

	@Inject(method = "getSkinTextureLocation", at = @At("HEAD"), cancellable = true)
	public ResourceLocation getSkinTextureLocation(CallbackInfoReturnable<Boolean> info) {
		PlayerEvents.GET_SKIN.invoker().getSkin(clientPlayer, new WrappedCallbackInfoReturnable<>(info));
		return null;
	}
	
}
