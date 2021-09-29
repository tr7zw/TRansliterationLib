package dev.tr7zw.transliterationlib.fabric;

import dev.tr7zw.transliterationlib.api.TRansliterationLib;
import dev.tr7zw.transliterationlib.api.event.APIEvent;
import dev.tr7zw.transliterationlib.api.event.RenderEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;

public class TRansliterationLibMod implements ModInitializer {
	
	@Override
	public void onInitialize() {
		System.out.println("Loading TRansliterationLib");
		TRansliterationLib.transliteration = new TRansliterationLibAPIImpl();
		APIEvent.LOADED.invoker().run();
		registerFabricEvents();
		System.out.println("Loaded TRansliterationLib");
	}

	private void registerFabricEvents() {
		WorldRenderEvents.START.register((context) -> RenderEvent.START_RENDER.invoker().onRender());
	}
	   
}
