package dev.tr7zw.transliterationlib.forge.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;
import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import net.minecraft.util.ResourceLocation;

public class ConstructorImpl implements Constructors{

	private final Wrapper wrapper;
	
	public ConstructorImpl(Wrapper creationWrapper) {
		this.wrapper = creationWrapper;
	}

	@Override
	public Identifier newIdentifier(String namespace, String id) {
		return wrapper.getIdentifier().of(new ResourceLocation(namespace, id));
	}

}