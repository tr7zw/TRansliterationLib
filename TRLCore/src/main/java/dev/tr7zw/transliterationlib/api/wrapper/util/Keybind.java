package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleMethod;
import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.client.option.KeyBinding", mcp = "net.minecraft.client.KeyMapping")
public interface Keybind extends HandleHolder<Keybind> {

	@SimpleMethod(yarn = "isPressed", mcp = "isDown")
	public boolean isPressed();

}
