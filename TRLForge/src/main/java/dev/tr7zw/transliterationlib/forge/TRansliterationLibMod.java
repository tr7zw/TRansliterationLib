package dev.tr7zw.transliterationlib.forge;

import dev.tr7zw.transliterationlib.api.TRansliterationLib;
import dev.tr7zw.transliterationlib.api.event.APIEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(TRansliterationLibMod.MODID)
public class TRansliterationLibMod {

	public static final String MODID = "transliterationlib";

	public TRansliterationLibMod() {
		TRansliterationLib.transliteration = new TRansliterationLibAPIImpl();
		APIEvent.LOADED.invoker().run();
		TRansliterationLib.transliteration.getModLoaderWrapper().disableForgeServerDisplayTest();
		registerForgeEvents();
	}
	
	private void registerForgeEvents() {
		TRLEventListener listener = new TRLEventListener();
		MinecraftForge.EVENT_BUS.addListener(listener::onRenderStart);
	}

}
