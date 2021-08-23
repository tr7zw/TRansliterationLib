package dev.tr7zw.transliterationlib.forge.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;

public class TRLIdentifier
    extends AbstractWrapper<
        net.minecraft.resources.ResourceLocation,
        TRLIdentifier,
        dev.tr7zw.transliterationlib.api.wrapper.util.Identifier>
    implements dev.tr7zw.transliterationlib.api.wrapper.util.Identifier {

  @Override
  public java.lang.String getId() {
    return handle().getPath();
  }

  @Override
  public java.lang.String getNamespace() {
    return handle().getNamespace();
  }
}
