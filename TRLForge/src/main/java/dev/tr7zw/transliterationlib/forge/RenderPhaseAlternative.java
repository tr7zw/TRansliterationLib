package dev.tr7zw.transliterationlib.forge;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.renderer.RenderState.AlphaState;
import net.minecraft.client.renderer.RenderState.CullState;
import net.minecraft.client.renderer.RenderState.LightmapState;
import net.minecraft.client.renderer.RenderState.TransparencyState;

public class RenderPhaseAlternative {

	public static final CullState DISABLE_CULLING = new CullState(false);

	public static final LightmapState ENABLE_LIGHTMAP = new LightmapState(true);

	public static final TransparencyState TRANSLUCENT_TRANSPARENCY = new TransparencyState("translucent_transparency", () -> {
		RenderSystem.enableBlend();
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA,
				GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
				GlStateManager.SourceFactor.ONE,
				GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
	}, () -> {
		RenderSystem.disableBlend();
		RenderSystem.defaultBlendFunc();
	});

	public static final AlphaState ONE_TENTH_ALPHA = new AlphaState(0.003921569f);

	
}
