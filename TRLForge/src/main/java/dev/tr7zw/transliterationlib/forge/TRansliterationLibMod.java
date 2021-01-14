package dev.tr7zw.transliterationlib.forge;

import dev.tr7zw.transliterationlib.api.TRansliterationLib;
import net.minecraftforge.fml.common.Mod;

@Mod(TRansliterationLibMod.MODID)
public class TRansliterationLibMod {

	public static final String MODID = "transliterationlib";

	public TRansliterationLibMod() {
		TRansliterationLib.transliteration = new TRansliterationLibAPIForgeImpl();
	}

}
