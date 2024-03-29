package dev.tr7zw.transliterationlib.fabric.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;

public class TRLVector3d
    extends AbstractWrapper<
        net.minecraft.world.phys.Vec3,
        TRLVector3d,
        dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d>
    implements dev.tr7zw.transliterationlib.api.wrapper.util.Vector3d {

  @Override
  public double getZ() {
    return handle().z;
  }

  @Override
  public double getX() {
    return handle().x;
  }

  @Override
  public double getY() {
    return handle().y;
  }
}
