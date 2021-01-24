package dev.tr7zw.transliterationlib.api.event;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.tr7zw.transliterationlib.api.event.api.TREvent;
import dev.tr7zw.transliterationlib.api.event.api.TREventFactory;
import dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity;
import dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel;

public class RenderEvent {

	public static final TREvent<SetAnglesEvent> SET_ANGLES_END = TREventFactory.createArrayBacked(SetAnglesEvent.class, callbacks -> (entity, model, tick, info) -> {
		for (SetAnglesEvent callback : callbacks) {
			callback.onSet(entity, model, tick, info);
		}
	});
	
	@FunctionalInterface
	public interface SetAnglesEvent {
		void onSet(LivingEntity entity, PlayerEntityModel model, float tick, CallbackInfo info);
	}
	
}
