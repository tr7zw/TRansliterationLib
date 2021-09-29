package dev.tr7zw.transliterationlib.api.event;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.tr7zw.transliterationlib.api.event.api.TREvent;
import dev.tr7zw.transliterationlib.api.event.api.TREventFactory;
import dev.tr7zw.transliterationlib.api.wrapper.entity.LivingEntity;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.model.EntityModel;
import dev.tr7zw.transliterationlib.api.wrapper.model.PlayerEntityModel;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider;

public class RenderEvent {

	public static final TREvent<SetAnglesEvent> SET_ANGLES_END = TREventFactory.createArrayBacked(SetAnglesEvent.class,
			callbacks -> (entity, model, tick, info) -> {
				for (SetAnglesEvent callback : callbacks) {
					callback.onSet(entity, model, tick, info);
				}
			});

	@FunctionalInterface
	public interface SetAnglesEvent {
		void onSet(LivingEntity entity, PlayerEntityModel model, float tick, CallbackInfo info);
	}

	public static final TREvent<RenderHeldItem> RENDER_HELD_ITEM = TREventFactory.createArrayBacked(
			RenderHeldItem.class,
			callbacks -> (entity, model, stack, arm, matrixStack, vertexConsumer, light, info) -> {
				for (RenderHeldItem callback : callbacks) {
					callback.onRender(entity, model, stack, arm, matrixStack, vertexConsumer, light, info);
				}
			});

	@FunctionalInterface
	public interface RenderHeldItem {
		void onRender(LivingEntity entity, EntityModel model, ItemStack stack, Arm arm, MatrixStack matrixStack,
				VertexConsumerProvider vertexConsumer, int light, CallbackInfo info);
	}
	
	public static final TREvent<StartRenderEvent> START_RENDER = TREventFactory.createArrayBacked(StartRenderEvent.class,
			callbacks -> () -> {
				for (StartRenderEvent callback : callbacks) {
					callback.onRender();
				}
			});

	@FunctionalInterface
	public interface StartRenderEvent {
		void onRender();
	}

}
