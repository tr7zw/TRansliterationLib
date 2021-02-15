package dev.tr7zw.transliterationlib.fabric.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.client.options.KeyBinding;

public class TRLKeybind 
extends AbstractWrapper<KeyBinding, TRLKeybind, dev.tr7zw.transliterationlib.api.wrapper.util.Keybind>
implements dev.tr7zw.transliterationlib.api.wrapper.util.Keybind {

	@Override
	public boolean isPressed() {
		return handle().isPressed();
	}

}
