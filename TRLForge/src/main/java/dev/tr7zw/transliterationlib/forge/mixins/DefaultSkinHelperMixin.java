package dev.tr7zw.transliterationlib.forge.mixins;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.tr7zw.transliterationlib.api.event.PlayerEvents;
import dev.tr7zw.transliterationlib.api.wrapper.util.WrappedCallbackInfoReturnable;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;

@Mixin(DefaultPlayerSkin.class)
public class DefaultSkinHelperMixin {

	@Inject(method = "getDefaultSkin", at = @At("HEAD"), cancellable = true)
	private static ResourceLocation getTexture(UUID uuid, CallbackInfoReturnable<ResourceLocation> callback) {
		PlayerEvents.GET_DEFAULT_SKIN.invoker().getSkin(uuid, new WrappedCallbackInfoReturnable<>(callback));
		return null;
	}

}
