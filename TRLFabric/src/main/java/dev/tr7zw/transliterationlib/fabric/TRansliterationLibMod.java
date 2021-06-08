package dev.tr7zw.transliterationlib.fabric;

import dev.tr7zw.transliterationlib.api.TRansliterationLib;
import dev.tr7zw.transliterationlib.api.event.APIEvent;
import net.fabricmc.api.ModInitializer;

public class TRansliterationLibMod implements ModInitializer {
	
	@Override
	public void onInitialize() {
		System.out.println("Loading TRansliterationLib");
		TRansliterationLib.transliteration = new TRansliterationLibAPIImpl();
		APIEvent.LOADED.invoker().run();
		System.out.println("Loaded TRansliterationLib");
	}

	   
}
