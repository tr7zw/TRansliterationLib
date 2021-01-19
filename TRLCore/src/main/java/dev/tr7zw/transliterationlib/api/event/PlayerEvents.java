package dev.tr7zw.transliterationlib.api.event;

import java.util.UUID;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftSessionService;

import dev.tr7zw.transliterationlib.api.event.api.TREvent;
import dev.tr7zw.transliterationlib.api.event.api.TREventFactory;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.api.wrapper.util.WrappedCallbackInfoReturnable;

public class PlayerEvents {

	public static final TREvent<SkinResolveEvent> SKIN_RESOLVE = TREventFactory.createArrayBacked(SkinResolveEvent.class, callbacks -> (service, profile, requireSecure, info) -> {
		for (SkinResolveEvent callback : callbacks) {
			callback.onSkinResolve(service, profile, requireSecure, info);
		}
	});
	
	@FunctionalInterface
	public interface SkinResolveEvent {
		void onSkinResolve(MinecraftSessionService service, GameProfile profile, boolean requireSecure, CallbackInfo info);
	}
	
	public static final TREvent<HasSkinEvent> HAS_SKIN = TREventFactory.createArrayBacked(HasSkinEvent.class, callbacks -> (player, info) -> {
		for (HasSkinEvent callback : callbacks) {
			callback.hasSkin(player, info);
		}
	});
	
	@FunctionalInterface
	public interface HasSkinEvent {
		void hasSkin(ClientPlayer player, CallbackInfoReturnable<Boolean> info);
	}
	
	public static final TREvent<GetSkinEvent> GET_SKIN = TREventFactory.createArrayBacked(GetSkinEvent.class, callbacks -> (player, info) -> {
		for (GetSkinEvent callback : callbacks) {
			callback.getSkin(player, info);
		}
	});
	
	@FunctionalInterface
	public interface GetSkinEvent {
		void getSkin(ClientPlayer player, WrappedCallbackInfoReturnable<Identifier> info);
	}
	
	public static final TREvent<GetDefaultSkinEvent> GET_DEFAULT_SKIN = TREventFactory.createArrayBacked(GetDefaultSkinEvent.class, callbacks -> (uuid, info) -> {
		for (GetDefaultSkinEvent callback : callbacks) {
			callback.getSkin(uuid, info);
		}
	});
	
	@FunctionalInterface
	public interface GetDefaultSkinEvent {
		void getSkin(UUID uuid, WrappedCallbackInfoReturnable<Identifier> info);
	}
	
}
