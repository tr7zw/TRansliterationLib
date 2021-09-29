package dev.tr7zw.transliterationlib.forge;

import dev.tr7zw.transliterationlib.api.event.RenderEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.event.TickEvent.RenderTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class TRLEventListener {

	@SubscribeEvent
	public void onRenderStart(RenderTickEvent event) {
		if(event.phase == Phase.START) {
			RenderEvent.START_RENDER.invoker().onRender();
		}
	}
	
}
