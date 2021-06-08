package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.util.math.Quaternion", mcp = "net.minecraft.util.math.vector.Quaternion")
public interface Quaternion extends HandleHolder<Quaternion> {

}
