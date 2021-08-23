package dev.tr7zw.transliterationlib.forge.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;

public class TRLKeybind
    extends AbstractWrapper<
        net.minecraft.client.KeyMapping,
        TRLKeybind,
        dev.tr7zw.transliterationlib.api.wrapper.util.Keybind>
    implements dev.tr7zw.transliterationlib.api.wrapper.util.Keybind {

  @Override
  public boolean isPressed() {
    return handle().isDown();
  }
}
