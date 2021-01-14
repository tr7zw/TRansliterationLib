package dev.tr7zw.transliterationlib.forge;

import de.tr7zw.transliterationlib.TRansliterationLibCore;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;

@Mod(TRansliterationLibMod.MODID)
public class TRansliterationLibMod extends TRansliterationLibCore
{

    public static final String MODID = "transliterationlib";

    public TRansliterationLibMod() {
    	instance = this;

    }

	@Override
	public Object getIdentifier(String namespace, String id) {
		return new ResourceLocation(namespace, id);
	}

}
