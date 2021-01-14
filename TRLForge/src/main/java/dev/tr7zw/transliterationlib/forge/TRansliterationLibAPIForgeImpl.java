package dev.tr7zw.transliterationlib.forge;

import dev.tr7zw.transliterationlib.api.TRansliterationLibAPI;
import dev.tr7zw.transliterationlib.api.config.ConfigBuilder;
import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.Wrapper;
import dev.tr7zw.transliterationlib.forge.config.ConfigBuilderImpl;
import dev.tr7zw.transliterationlib.forge.registry.KeybindingsImpl;
import dev.tr7zw.transliterationlib.forge.wrapper.WrapperImpl;

public class TRansliterationLibAPIForgeImpl implements TRansliterationLibAPI {

	private Wrapper wrapper = new WrapperImpl();
	private Keybindings keybindings = new KeybindingsImpl();
	
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
