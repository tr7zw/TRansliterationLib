package dev.tr7zw.transliterationlib.fabric;

import dev.tr7zw.transliterationlib.api.TRansliterationLib;
import net.fabricmc.api.ModInitializer;

public class TRansliterationLibMod implements ModInitializer {
	
	@Override
	public void onInitialize() {
		TRansliterationLib.transliteration = new TRansliterationLibAPIFabricImpl();
	}

	   
}
