package dev.tr7zw.transliterationlib.fabric.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;

import dev.tr7zw.transliterationlib.api.event.PlayerEvents;
import net.minecraft.client.texture.PlayerSkinProvider;
import net.minecraft.client.texture.PlayerSkinProvider.SkinTextureAvailableCallback;

@Mixin(PlayerSkinProvider.class)
public class PlayerSkinProviderMixin {

	@Shadow
	private MinecraftSessionService sessionService;
	
	@Inject(method =  "Lnet/minecraft/client/texture/PlayerSkinProvider;loadSkin(Lcom/mojang/authlib/GameProfile;Lnet/minecraft/client/texture/PlayerSkinProvider$SkinTextureAvailableCallback;Z)V", at = @At("HEAD"), cancellable = true)
	public void loadSkin(GameProfile profile, SkinTextureAvailableCallback callback, boolean requireSecure, CallbackInfo info) {
		PlayerEvents.SKIN_RESOLVE.invoker().onSkinResolve(profile, requireSecure, info);
	}
	
}
