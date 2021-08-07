package dev.tr7zw.transliterationlib.forge.wrapper;

import java.util.function.BiConsumer;
import java.util.function.Function;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;

import dev.tr7zw.transliterationlib.api.config.WrappedConfigEntry;
import dev.tr7zw.transliterationlib.api.wrapper.OldWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.WrappedEntityTrackerUpdate;
import dev.tr7zw.transliterationlib.api.wrapper.WrappedScreen;
import dev.tr7zw.transliterationlib.api.wrapper.WrappedText;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider;
import dev.tr7zw.transliterationlib.forge.wrapper.item.TRLItemStack;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLMatrixStack;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVertexConsumerProvider;
import me.shedaniel.clothconfig2.api.AbstractConfigEntry;
import me.shedaniel.clothconfig2.gui.entries.EnumListEntry;
import me.shedaniel.clothconfig2.gui.entries.IntegerSliderEntry;
import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;

public class WrapperImpl implements OldWrapper{

	@Override
	public WrappedScreen wrapScreen(Object screen) {
		return new WrappedScreen() {
			
			private Screen handler = (Screen) screen;
			
			@Override
			public Screen getHandler() {
				return handler;
			}
		};
	}

	@Override
	public WrappedText wrapText(Object text) {
		return new WrappedText() {
			
			private TextComponent handler = (TextComponent) text;
			
			@Override
			public Object getHandler() {
				return handler;
			}
		};
	}

	@Override
	public WrappedText getTranslateableText(String text) {
		return wrapText(new TranslatableComponent(text));
	}

	@Override
	public WrappedConfigEntry getWrappedConfigEntry(Object entry) {
		return new WrappedConfigEntry() {
			
			private AbstractConfigEntry<?> handler = (AbstractConfigEntry<?>) entry;
			
			@Override
			public Object getHandler() {
				return handler;
			}

			@SuppressWarnings("unchecked")
			@Override
			public <T extends Enum<?>> T getEnumValue(Class<T> targetEnum) {
				return ((EnumListEntry<T>)handler).getValue();
			}

			@Override
			public int getIntValue() {
				return ((IntegerSliderEntry)handler).getValue();
			}
		};
	}

	private static final RenderType MAP_BACKGROUND = getTextNoCull(new ResourceLocation("textures/map/map_background.png"));
	private static final RenderType MAP_BACKGROUND_CHECKERBOARD = getTextNoCull(new ResourceLocation("textures/map/map_background_checkerboard.png"));
	
	private static RenderType getTextNoCull(ResourceLocation texture) {
		return textNoCull.apply(texture);
	}
	
	private static final Function<ResourceLocation, RenderType> textNoCull = Util.memoize(texture -> net.minecraft.client.renderer.RenderType.create("text", DefaultVertexFormat.POSITION_COLOR_TEX_LIGHTMAP,
			VertexFormat.Mode.QUADS, 256, false, true,
			RenderType.CompositeState.builder().setShaderState(RenderStateShard.RENDERTYPE_TEXT_SHADER)
					.setTextureState(new RenderStateShard.TextureStateShard(texture, false, false)).setTransparencyState(RenderStateShard.TRANSLUCENT_TRANSPARENCY)
					.setLightmapState(RenderStateShard.LIGHTMAP).setCullState(RenderStateShard.NO_CULL).createCompositeState(false)));
	
	@Override
	public void renderFirstPersonMap(MatrixStack matricesWrapped, VertexConsumerProvider vertexConsumersWrapped, int light,
			ItemStack stack, boolean small, boolean lefthanded) {
		PoseStack matrices = ((TRLMatrixStack)matricesWrapped).handle();
		MultiBufferSource vertexConsumers = ((TRLVertexConsumerProvider)vertexConsumersWrapped).handle();
		Minecraft client = Minecraft.getInstance();

		if (small) {
			matrices.mulPose(Vector3f.YP.rotationDegrees(160.0f));
			matrices.mulPose(Vector3f.ZP.rotationDegrees(180.0f));
			matrices.scale(0.38f, 0.38f, 0.38f);
			
			matrices.translate(-0.1, -1.2, 0.0);
			matrices.scale(0.0098125f, 0.0098125f, 0.0098125f);
		} else {
			if(lefthanded) {
				matrices.mulPose(Vector3f.YP.rotationDegrees(160.0f));
				matrices.mulPose(Vector3f.ZP.rotationDegrees(150.0f));
				matrices.scale(0.38f, 0.38f, 0.38f);
				
				matrices.translate(+0.5, -1.3, 0.0);
			} else {
				matrices.mulPose(Vector3f.YP.rotationDegrees(160.0f));
				matrices.mulPose(Vector3f.ZP.rotationDegrees(210.0f));
				matrices.scale(0.38f, 0.38f, 0.38f);
				
				matrices.translate(-1.0, -1.8, 0.0);
			}

			matrices.scale(0.0138125f, 0.0138125f, 0.0138125f);
		}
		Integer integer = MapItem.getMapId(((TRLItemStack) stack).handle());
		MapItemSavedData mapState = MapItem.getSavedData(((TRLItemStack) stack).handle(), client.level);
		com.mojang.blaze3d.vertex.VertexConsumer vertexConsumer = vertexConsumers
				.getBuffer(mapState == null ? MAP_BACKGROUND : MAP_BACKGROUND_CHECKERBOARD);
		Matrix4f matrix4f = matrices.last().pose();
		vertexConsumer.vertex(matrix4f, -7.0f, 135.0f, 0.0f).color(255, 255, 255, 255).uv(0.0f, 1.0f).uv2(light)
				.endVertex();
		vertexConsumer.vertex(matrix4f, 135.0f, 135.0f, 0.0f).color(255, 255, 255, 255).uv(1.0f, 1.0f).uv2(light)
				.endVertex();
		vertexConsumer.vertex(matrix4f, 135.0f, -7.0f, 0.0f).color(255, 255, 255, 255).uv(1.0f, 0.0f).uv2(light)
				.endVertex();
		vertexConsumer.vertex(matrix4f, -7.0f, -7.0f, 0.0f).color(255, 255, 255, 255).uv(0.0f, 0.0f).uv2(light)
				.endVertex();
		if (mapState != null) {
			client.gameRenderer.getMapRenderer().render(matrices, vertexConsumers, integer, mapState, false, light);
		}
	}
	
	@Override
	public boolean isChargedCrossbow(ItemStack item) {
		return CrossbowItem.isCharged(((TRLItemStack)item).handle());
	}

	@Override
	public WrappedEntityTrackerUpdate wrapEntityTrackerUpdatePacket(Object packet) {
		return new WrappedEntityTrackerUpdate() {
			
			private ClientboundSetEntityDataPacket sPacket = (ClientboundSetEntityDataPacket) packet;
			
			@Override
			public Object getHandler() {
				return sPacket;
			}
			
			@Override
			public int id() {
				return sPacket.getId();
			}
			
			@Override
			public boolean hasTrackedValues() {
				return sPacket.getUnpackedData() != null;
			}
			
			@Override
			public void forEach(BiConsumer<Integer, Object> handler) {
				sPacket.getUnpackedData().forEach(entry -> {
					handler.accept(entry.getAccessor().getId(), entry.getValue());
				});
			}
		};
	}
	
}
