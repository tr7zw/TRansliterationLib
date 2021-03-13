package dev.tr7zw.transliterationlib.forge;

import org.apache.commons.lang3.tuple.Pair;

import dev.tr7zw.transliterationlib.api.TRansliterationLib;
import dev.tr7zw.transliterationlib.api.event.APIEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.FMLNetworkConstants;

@Mod(TRansliterationLibMod.MODID)
public class TRansliterationLibMod {

	public static final String MODID = "transliterationlib";

	public TRansliterationLibMod() {
		TRansliterationLib.transliteration = new TRansliterationLibAPIImpl();
		APIEvent.LOADED.invoker().run();
		ModLoadingContext.get().registerExtensionPoint(ExtensionPoint.DISPLAYTEST,
				() -> Pair.of(() -> FMLNetworkConstants.IGNORESERVERONLY, (remote, isServer) -> true));
	}

}
