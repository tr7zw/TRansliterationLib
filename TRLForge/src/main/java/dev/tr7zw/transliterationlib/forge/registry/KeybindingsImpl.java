package dev.tr7zw.transliterationlib.forge.registry;

import dev.tr7zw.transliterationlib.api.registry.Keybindings;
import dev.tr7zw.transliterationlib.api.wrapper.util.Keybind;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class KeybindingsImpl implements Keybindings{

	@Override
	public void registerKeybinding(Keybind keybind) {
		ClientRegistry.registerKeyBinding(keybind.getHandler(KeyBinding.class));
	}

}
