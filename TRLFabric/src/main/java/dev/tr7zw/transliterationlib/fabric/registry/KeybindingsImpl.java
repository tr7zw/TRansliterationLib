package dev.tr7zw.transliterationlib.fabric.registry;

import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.WrappedKeybind;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;

public class KeybindingsImpl implements Keybindings{

	@Override
	public void registerKeybinding(WrappedKeybind keybind) {
		KeyBindingHelper.registerKeyBinding(keybind.getHandler(KeyBinding.class));
	}

}
