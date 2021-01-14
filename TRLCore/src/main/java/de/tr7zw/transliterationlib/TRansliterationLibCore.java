package de.tr7zw.transliterationlib;

import java.util.Set;
import java.util.UUID;

import com.google.common.collect.Sets;

public abstract class TRansliterationLibCore {

	public static TRansliterationLibCore instance;

	private static int skinCount = 84;
	private static Set<String> noSkinUrls = Sets.newHashSet(
			"http://textures.minecraft.net/texture/1a4af718455d4aab528e7a61f86fa25e6a369d1768dcb13f7df319a713eb810b",
			"http://textures.minecraft.net/texture/3b60a1f6d562f52aaebbf1434f1de147933a3affe0e764fa49ea057536623cd3");

	public abstract Object getIdentifier(String namespace, String id);

	public Object getSkin(UUID uuid) {
		boolean alex = (uuid.hashCode() & 1) == 1;
		int skinId = Math.abs((uuid.hashCode() % skinCount)) + 1;
		return getIdentifier("transliterationlib", "textures/skin/" + (alex ? "alex" : "steve") + "/skin_" + skinId + ".png");
	}

	public boolean isSteveAlexSkin(String url) {
		return noSkinUrls.contains(url);
	}

}
