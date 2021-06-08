package dev.tr7zw.transliterationlib.fabric.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;

public class TRLMatrixStack
    extends AbstractWrapper<
        net.minecraft.client.util.math.MatrixStack,
        TRLMatrixStack,
        dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack>
    implements dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack {

  @Override
  public void push() {
    handle().push();
  }

  @Override
  public void pop() {
    handle().pop();
  }

  @Override
  public void translate(double arg0, double arg1, double arg2) {
    handle().translate(arg0, arg1, arg2);
  }

  @Override
  public void multiply(dev.tr7zw.transliterationlib.api.wrapper.util.Quaternion arg0) {
    handle()
        .multiply(((dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLQuaternion) arg0).handle());
  }
}
