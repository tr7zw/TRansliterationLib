package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;
import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.api.wrapper.util.Keybind;
import net.minecraft.client.options.KeyBinding;

public class ConstructorImpl implements Constructors{

	private final Wrapper wrapper;
	
	public ConstructorImpl(Wrapper creationWrapper) {
		this.wrapper = creationWrapper;
	}

	@Override
	public Identifier newIdentifier(String namespace, String id) {
		return wrapper.getIdentifier().of(new net.minecraft.util.Identifier(namespace, id));
	}

	@Override
	public Keybind newKeybind(String name, int key, String namespace) {
		return wrapper.getKeybind().of(new KeyBinding(name, key, namespace));
	}

}
