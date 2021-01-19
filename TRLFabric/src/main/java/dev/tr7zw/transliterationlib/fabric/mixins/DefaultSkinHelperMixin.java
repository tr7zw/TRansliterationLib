package dev.tr7zw.transliterationlib.fabric.mixins;

import java.util.UUID;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import dev.tr7zw.transliterationlib.api.event.PlayerEvents;
import dev.tr7zw.transliterationlib.api.wrapper.util.WrappedCallbackInfoReturnable;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.util.Identifier;

@Mixin(DefaultSkinHelper.class)
public class DefaultSkinHelperMixin {

	@Inject(method = "getTexture(Ljava/util/UUID;)Lnet/minecraft/util/Identifier;", at = @At("HEAD"), cancellable = true)
	private static Identifier getTexture(UUID uuid, CallbackInfoReturnable<Identifier> callback) {
		PlayerEvents.GET_DEFAULT_SKIN.invoker().getSkin(uuid, new WrappedCallbackInfoReturnable<>(callback));
		return null;
	}

}
