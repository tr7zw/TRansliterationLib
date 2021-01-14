package dev.tr7zw.transliterationlib.fabric;

import dev.tr7zw.transliterationlib.api.TRansliterationLibAPI;
import dev.tr7zw.transliterationlib.api.config.ConfigBuilder;
import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.Wrapper;
import dev.tr7zw.transliterationlib.fabric.config.ConfigBuilderImpl;
import dev.tr7zw.transliterationlib.fabric.registry.KeybindingsImpl;
import dev.tr7zw.transliterationlib.fabric.wrapper.WrapperImpl;

public class TRansliterationLibAPIFabricImpl implements TRansliterationLibAPI {

	private final Wrapper wrapper = new WrapperImpl();
	private final Keybindings keybindings = new KeybindingsImpl();
	
	@Override
	public Wrapper getWrapper() {
		return wrapper;
	}

	@Override
	public ConfigBuilder getNewConfigBuilder() {
		return new ConfigBuilderImpl();
	}

	@Override
	public Keybindings getKeybindings() {
		return keybindings;
	}

}
