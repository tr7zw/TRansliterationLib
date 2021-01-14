package dev.tr7zw.transliterationlib.api;

import dev.tr7zw.transliterationlib.api.config.ConfigBuilder;
import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.Wrapper;

/**
 * Used to wrap NMS and other mods like ClothConfig for Modloader independed usage.
 * 
 * @author tr7zw
 *
 */
public interface TRansliterationLibAPI {
	
	public Wrapper getWrapper();
	
	public ConfigBuilder getNewConfigBuilder();
	
	public Keybindings getKeybindings();
	
}
