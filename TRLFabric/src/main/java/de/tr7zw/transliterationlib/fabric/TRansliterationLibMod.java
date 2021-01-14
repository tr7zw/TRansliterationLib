package de.tr7zw.transliterationlib.fabric;

import de.tr7zw.transliterationlib.TRansliterationLibCore;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class TRansliterationLibMod extends TRansliterationLibCore implements ModInitializer {
	

	public TRansliterationLibMod() {
		instance = this;
	}

	
	@Override
	public void onInitialize() {

	}


	@Override
	public Object getIdentifier(String namespace, String id) {
		return new Identifier(namespace, id);
	}

	   
}
