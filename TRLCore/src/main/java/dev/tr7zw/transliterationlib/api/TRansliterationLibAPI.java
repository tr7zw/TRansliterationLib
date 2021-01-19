package dev.tr7zw.transliterationlib.api;

import dev.tr7zw.transliterationlib.api.config.ConfigBuilder;
import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.OldWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;

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
	
	public Constructors constructors();
	
	public dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper singletonWrapper();
	
	public dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper creationWrapper();
	
}
