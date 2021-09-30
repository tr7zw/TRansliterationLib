package dev.tr7zw.transliterationlib.fabric.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;

public class TRLMatrixStack
    extends AbstractWrapper<
        com.mojang.blaze3d.vertex.PoseStack,
        TRLMatrixStack,
        dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack>
    implements dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack {

  @Override
  public void push() {
    handle().pushPose();
  }

  @Override
  public void pop() {
    handle().popPose();
  }

  @Override
  public void translate(double arg0, double arg1, double arg2) {
    handle().translate(arg0, arg1, arg2);
  }

  @Override
  public void multiply(dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion arg0) {
    handle()
        .mulPose(((dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLQuaternion) arg0).handle());
  }
}
