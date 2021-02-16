package dev.tr7zw.transliterationlib.forge.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;
import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.api.wrapper.util.Keybind;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i;
import net.minecraft.client.settings.KeyBinding;
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

	@Override
	public Keybind newKeybind(String name, int key, String namespace) {
		return wrapper.getKeybind().of(new KeyBinding(name, key, namespace));
	}

	@Override
	public Vector3d newVector3d(double x, double y, double z) {
		return wrapper.getVector3d().of(new net.minecraft.util.math.vector.Vector3d(x, y, z));
	}

	@Override
	public Vector3i newVector3i(int x, int y, int z) {
		return wrapper.getVector3i().of(new net.minecraft.util.math.vector.Vector3i(x, y, z));
	}

	@Override
	public Vector3f newVector3f(float x, float y, float z) {
		return wrapper.getVector3f().of(new net.minecraft.util.math.vector.Vector3f(x, y, z));
	}
	

}
