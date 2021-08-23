package dev.tr7zw.transliterationlib.forge.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;

import dev.tr7zw.transliterationlib.api.event.PlayerEvents;
import net.minecraft.client.resources.SkinManager;

@Mixin(SkinManager.class)
public class PlayerSkinProviderMixin {

	@Shadow
	private MinecraftSessionService sessionService;
	
	@Inject(method =  "registerSkins", at = @At("HEAD"), cancellable = true)
	public void loadSkin(GameProfile profile, SkinManager.SkinTextureCallback callback, boolean requireSecure, CallbackInfo info) {
		PlayerEvents.SKIN_RESOLVE.invoker().onSkinResolve(sessionService, profile, requireSecure, info);
	}
	
}
