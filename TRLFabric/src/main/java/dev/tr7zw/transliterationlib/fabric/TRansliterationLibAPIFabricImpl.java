package dev.tr7zw.transliterationlib.fabric;

import dev.tr7zw.transliterationlib.api.TRansliterationLibAPI;
import dev.tr7zw.transliterationlib.api.config.ConfigBuilder;
import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.OldWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;
import dev.tr7zw.transliterationlib.api.wrapper.api.EnumWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.fabric.config.ConfigBuilderImpl;
import dev.tr7zw.transliterationlib.fabric.registry.KeybindingsImpl;
import dev.tr7zw.transliterationlib.fabric.wrapper.WrapperImpl;
import dev.tr7zw.transliterationlib.fabric.wrapper.api.ConstructorImpl;
import dev.tr7zw.transliterationlib.fabric.wrapper.api.NormalWrapper;
import dev.tr7zw.transliterationlib.fabric.wrapper.api.SingletonWrapper;
import dev.tr7zw.transliterationlib.fabric.wrapper.api.TRLEnumWrapper;

public class TRansliterationLibAPIFabricImpl implements TRansliterationLibAPI {

	private final OldWrapper wrapper = new WrapperImpl();
	private final Keybindings keybindings = new KeybindingsImpl();
	private final Wrapper singletonWrapper = new SingletonWrapper();
	private final Wrapper creationWrapper = new NormalWrapper();
	private final Constructors constructors = new ConstructorImpl(creationWrapper);
	private final EnumWrapper enumWrapper = new TRLEnumWrapper();
	
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
		return constructors;
	}

	@Override
	public Wrapper singletonWrapper() {
		return singletonWrapper;
	}

	@Override
	public Wrapper creationWrapper() {
		return creationWrapper;
	}

	@Override
	public EnumWrapper getEnumWrapper() {
		return enumWrapper;
	}

}
