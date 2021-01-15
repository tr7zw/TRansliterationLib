package dev.tr7zw.transliterationlib.api.event;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.mojang.authlib.GameProfile;

import dev.tr7zw.transliterationlib.api.event.api.TREvent;
import dev.tr7zw.transliterationlib.api.event.api.TREventFactory;

public class PlayerEvents {

	public static final TREvent<SkinResolveEvent> SKIN_RESOLVE = TREventFactory.createArrayBacked(SkinResolveEvent.class, callbacks -> (profile, requireSecure, info) -> {
		for (SkinResolveEvent callback : callbacks) {
			callback.onSkinResolve(profile, requireSecure, info);
		}
	});
	
	@FunctionalInterface
	public interface SkinResolveEvent {
		void onSkinResolve(GameProfile profile, boolean requireSecure, CallbackInfo info);
	}
	
}
