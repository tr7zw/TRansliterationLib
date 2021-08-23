package dev.tr7zw.transliterationlib.forge.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Constructors;
import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.api.wrapper.util.Keybind;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i;
import net.minecraft.client.KeyMapping;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;

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
		return wrapper.getKeybind().of(new KeyMapping(name, key, namespace));
	}

	@Override
	public Vector3d newVector3d(double x, double y, double z) {
		return wrapper.getVector3d().of(new Vec3(x, y, z));
	}

	@Override
	public Vector3i newVector3i(int x, int y, int z) {
		return wrapper.getVector3i().of(new Vec3i(x, y, z));
	}

	@Override
	public Vector3f newVector3f(float x, float y, float z) {
		return wrapper.getVector3f().of(new com.mojang.math.Vector3f(x, y, z));
	}

	@Override
	public ItemStack newItemStackFromNBT(String nbt) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	

}
