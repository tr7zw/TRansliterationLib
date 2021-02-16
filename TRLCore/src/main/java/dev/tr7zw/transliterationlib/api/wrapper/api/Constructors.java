package dev.tr7zw.transliterationlib.api.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.api.wrapper.util.Keybind;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3f;
import dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i;

public interface Constructors {

	public Identifier newIdentifier(String namespace, String id);
	public Keybind newKeybind(String name, int key, String namespace);
	public Vector3d newVector3d(double x, double y, double z);
	public Vector3i newVector3i(int x, int y, int z);
	public Vector3f newVector3f(float x, float y, float z);
	
}
