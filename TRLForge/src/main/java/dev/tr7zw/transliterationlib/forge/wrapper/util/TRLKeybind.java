package dev.tr7zw.transliterationlib.forge.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.client.settings.KeyBinding;

public class TRLKeybind 
extends AbstractWrapper<KeyBinding, TRLKeybind, dev.tr7zw.transliterationlib.api.wrapper.util.Keybind>
implements dev.tr7zw.transliterationlib.api.wrapper.util.Keybind {

	@Override
	public boolean isPressed() {
		return handle().isPressed();
	}

}
