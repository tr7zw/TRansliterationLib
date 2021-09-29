package dev.tr7zw.transliterationlib.api;

import dev.tr7zw.transliterationlib.api.config.ConfigBuilder;
import dev.tr7zw.transliterationlib.api.registry.ItemGroups;
import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.MinecraftClient;
import dev.tr7zw.transliterationlib.api.wrapper.ModLoaderWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.OldWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;
import dev.tr7zw.transliterationlib.api.wrapper.api.EnumWrapper;

/**
 * Used to wrap NMS and other mods like ClothConfig for Modloader independed usage.
 * 
 * @author tr7zw
 *
 */
public interface TRansliterationLibAPI {
	
	public OldWrapper getWrapper();
	
	public ConfigBuilder getNewConfigBuilder();
	
	public Keybindings getKeybindings();
	
	public ItemGroups getItemGroups();
	
	public Constructors constructors();
	
	public EnumWrapper getEnumWrapper();
	
	public dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper singletonWrapper();
	
	public dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper creationWrapper();
	
	public MinecraftClient getMinecraftClient();
	
	public ModLoaderWrapper getModLoaderWrapper();
	
}
