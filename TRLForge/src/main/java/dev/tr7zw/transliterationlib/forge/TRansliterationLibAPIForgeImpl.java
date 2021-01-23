package dev.tr7zw.transliterationlib.forge;

import dev.tr7zw.transliterationlib.api.TRansliterationLibAPI;
import dev.tr7zw.transliterationlib.api.config.ConfigBuilder;
import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.OldWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;
import dev.tr7zw.transliterationlib.api.wrapper.api.EnumWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.forge.config.ConfigBuilderImpl;
import dev.tr7zw.transliterationlib.forge.registry.KeybindingsImpl;
import dev.tr7zw.transliterationlib.forge.wrapper.WrapperImpl;

public class TRansliterationLibAPIForgeImpl implements TRansliterationLibAPI {

	private OldWrapper wrapper = new WrapperImpl();
	private Keybindings keybindings = new KeybindingsImpl();
	
	@Override
	public OldWrapper getWrapper() {
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

	@Override
	public Constructors constructors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wrapper singletonWrapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wrapper creationWrapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EnumWrapper getEnumWrapper() {
		// TODO Auto-generated method stub
		return null;
	}

}
