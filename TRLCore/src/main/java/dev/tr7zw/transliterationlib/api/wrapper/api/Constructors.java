package dev.tr7zw.transliterationlib.api.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.api.wrapper.util.Keybind;

public interface Constructors {

	public Identifier newIdentifier(String namespace, String id);
	public Keybind newKeybind(String name, int key, String namespace);
	
}
