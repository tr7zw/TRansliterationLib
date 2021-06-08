package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.annotations.SimpleWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

@SimpleWrapper(yarn = "net.minecraft.client.render.VertexConsumerProvider", mcp = "net.minecraft.client.renderer.IRenderTypeBuffer")
public interface VertexConsumerProvider extends HandleHolder<VertexConsumerProvider> {

}
