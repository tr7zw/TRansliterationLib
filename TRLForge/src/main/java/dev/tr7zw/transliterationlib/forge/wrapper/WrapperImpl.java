package dev.tr7zw.transliterationlib.forge.wrapper;

import java.util.function.BiConsumer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
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
import dev.tr7zw.transliterationlib.forge.RenderPhaseAlternative;
import dev.tr7zw.transliterationlib.forge.wrapper.item.TRLItemStack;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLMatrixStack;
import dev.tr7zw.transliterationlib.forge.wrapper.util.TRLVertexConsumerProvider;
import me.shedaniel.clothconfig2.api.AbstractConfigEntry;
import me.shedaniel.clothconfig2.gui.entries.EnumListEntry;
import me.shedaniel.clothconfig2.gui.entries.IntegerSliderEntry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.FilledMapItem;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.storage.MapData;

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
		return RenderType.makeType("text", DefaultVertexFormats.POSITION_COLOR_TEX_LIGHTMAP, 7, 256, false, true,
				RenderType.State.getBuilder().texture(new RenderState.TextureState(texture, false, false))
						.alpha(RenderPhaseAlternative.ONE_TENTH_ALPHA)
						.transparency(RenderPhaseAlternative.TRANSLUCENT_TRANSPARENCY)
						.lightmap(RenderPhaseAlternative.ENABLE_LIGHTMAP).cull(RenderPhaseAlternative.DISABLE_CULLING)
						.build(false));
	}
	
	@Override
	public void renderFirstPersonMap(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
			ItemStack stack, boolean small, boolean lefthanded) {
		com.mojang.blaze3d.matrix.MatrixStack matrixStackIn = ((TRLMatrixStack)matrices).handle();
		IRenderTypeBuffer bufferIn = ((TRLVertexConsumerProvider)vertexConsumers).handle();
		Minecraft client = Minecraft.getInstance();

		if (small) {
			matrixStackIn.rotate(Vector3f.YP.rotationDegrees(160.0f));
			matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180.0f));
			matrixStackIn.scale(0.38f, 0.38f, 0.38f);
			
			matrixStackIn.translate(-0.1, -1.2, 0.0);
			matrixStackIn.scale(0.0098125f, 0.0098125f, 0.0098125f);
		} else {
			if(lefthanded) {
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(160.0f));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(150.0f));
				matrixStackIn.scale(0.38f, 0.38f, 0.38f);
				
				matrixStackIn.translate(+0.5, -1.3, 0.0);
			} else {
				matrixStackIn.rotate(Vector3f.YP.rotationDegrees(160.0f));
				matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(210.0f));
				matrixStackIn.scale(0.38f, 0.38f, 0.38f);
				
				matrixStackIn.translate(-1.0, -1.8, 0.0);
			}

			matrixStackIn.scale(0.0138125f, 0.0138125f, 0.0138125f);
		}
	      MapData mapdata = FilledMapItem.getMapData(((TRLItemStack) stack).handle(), client.world);
	      IVertexBuilder ivertexbuilder = bufferIn.getBuffer(mapdata == null ? MAP_BACKGROUND : MAP_BACKGROUND_CHECKERBOARD);
	      Matrix4f matrix4f = matrixStackIn.getLast().getMatrix();
	      ivertexbuilder.pos(matrix4f, -7.0F, 135.0F, 0.0F).color(255, 255, 255, 255).tex(0.0F, 1.0F).lightmap(light).endVertex();
	      ivertexbuilder.pos(matrix4f, 135.0F, 135.0F, 0.0F).color(255, 255, 255, 255).tex(1.0F, 1.0F).lightmap(light).endVertex();
	      ivertexbuilder.pos(matrix4f, 135.0F, -7.0F, 0.0F).color(255, 255, 255, 255).tex(1.0F, 0.0F).lightmap(light).endVertex();
	      ivertexbuilder.pos(matrix4f, -7.0F, -7.0F, 0.0F).color(255, 255, 255, 255).tex(0.0F, 0.0F).lightmap(light).endVertex();
	      if (mapdata != null) {
	    	  client.gameRenderer.getMapItemRenderer().renderMap(matrixStackIn, bufferIn, mapdata, false, light);
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
