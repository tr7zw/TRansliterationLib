package dev.tr7zw.transliterationlib.forge.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;

public class TRLVector3i
    extends AbstractWrapper<
        net.minecraft.util.math.vector.Vector3i,
        TRLVector3i,
        dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i>
    implements dev.tr7zw.transliterationlib.api.wrapper.util.Vector3i {

  @Override
  public int getZ() {
    return handle().getZ();
  }

  @Override
  public int getX() {
    return handle().getX();
  }

  @Override
  public int getY() {
    return handle().getY();
  }
}
