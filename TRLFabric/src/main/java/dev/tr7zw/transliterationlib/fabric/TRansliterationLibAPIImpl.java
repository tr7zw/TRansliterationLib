package dev.tr7zw.transliterationlib.fabric;

import dev.tr7zw.transliterationlib.api.TRansliterationLibAPI;
import dev.tr7zw.transliterationlib.api.config.ConfigBuilder;
import dev.tr7zw.transliterationlib.api.registry.ItemGroups;
import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.MinecraftClient;
import dev.tr7zw.transliterationlib.api.wrapper.OldWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;
import dev.tr7zw.transliterationlib.api.wrapper.api.EnumWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.fabric.config.ConfigBuilderImpl;
import dev.tr7zw.transliterationlib.fabric.registry.ItemGroupsImpl;
import dev.tr7zw.transliterationlib.fabric.registry.KeybindingsImpl;
import dev.tr7zw.transliterationlib.fabric.wrapper.TRLMinecraftClient;
import dev.tr7zw.transliterationlib.fabric.wrapper.WrapperImpl;
import dev.tr7zw.transliterationlib.fabric.wrapper.api.ConstructorImpl;
import dev.tr7zw.transliterationlib.fabric.wrapper.api.NormalWrapper;
import dev.tr7zw.transliterationlib.fabric.wrapper.api.SingletonWrapper;
import dev.tr7zw.transliterationlib.fabric.wrapper.api.TRLEnumWrapper;
import net.minecraft.client.Minecraft;

public class TRansliterationLibAPIImpl implements TRansliterationLibAPI {

	private final OldWrapper wrapper = new WrapperImpl();
	private final Keybindings keybindings = new KeybindingsImpl();
	private final ItemGroups itemgroups = new ItemGroupsImpl();
	private final Wrapper singletonWrapper = new SingletonWrapper();
	private final Wrapper creationWrapper = new NormalWrapper();
	private final Constructors constructors = new ConstructorImpl(creationWrapper);
	private final EnumWrapper enumWrapper = new TRLEnumWrapper();
	private final MinecraftClient client = new TRLMinecraftClient().of(Minecraft.getInstance());
	
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

	@Override
	public MinecraftClient getMinecraftClient() {
		return client;
	}

	@Override
	public ItemGroups getItemGroups() {
		return itemgroups;
	}

}
