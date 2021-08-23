package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.util.math.Quaternion", mcp = "com.mojang.math.Quaternion")
public interface Quaternion extends HandleHolder<Quaternion> {

}
