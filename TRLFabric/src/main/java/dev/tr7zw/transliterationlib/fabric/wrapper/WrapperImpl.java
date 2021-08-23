package dev.tr7zw.transliterationlib.fabric.wrapper;

import java.util.function.BiConsumer;
import java.util.function.Function;

import dev.tr7zw.transliterationlib.api.config.WrappedConfigEntry;
import dev.tr7zw.transliterationlib.api.wrapper.OldWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.WrappedEntityTrackerUpdate;
import dev.tr7zw.transliterationlib.api.wrapper.WrappedScreen;
import dev.tr7zw.transliterationlib.api.wrapper.WrappedText;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItemStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLMatrixStack;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLVertexConsumerProvider;
import me.shedaniel.clothconfig2.api.AbstractConfigEntry;
import me.shedaniel.clothconfig2.gui.entries.EnumListEntry;
import me.shedaniel.clothconfig2.gui.entries.IntegerSliderEntry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayer.MultiPhaseParameters;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.map.MapState;
import net.minecraft.network.packet.s2c.play.EntityTrackerUpdateS2CPacket;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.Matrix4f;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

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
			
			private Text handler = (Text) text;
			
			@Override
			public Object getHandler() {
				return handler;
			}
		};
	}

	@Override
	public WrappedText getTranslateableText(String text) {
		return wrapText(new TranslatableText(text));
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

	private static final Function<Identifier, RenderLayer> textNoCull = Util.memoize(texture -> RenderLayer.of("text", VertexFormats.POSITION_COLOR_TEXTURE_LIGHT,
			VertexFormat.DrawMode.QUADS, 256, false, true,
			MultiPhaseParameters.builder().shader(RenderPhase.TEXT_SHADER)
					.texture(new RenderPhase.Texture(texture, false, false)).transparency(RenderPhase.TRANSLUCENT_TRANSPARENCY)
					.lightmap(RenderPhase.ENABLE_LIGHTMAP).cull(RenderPhase.DISABLE_CULLING).build(false)));
	
	private static final RenderLayer MAP_BACKGROUND = getTextNoCull(
			(Identifier) new Identifier("textures/map/map_background.png"));
	private static final RenderLayer MAP_BACKGROUND_CHECKERBOARD = getTextNoCull(
			(Identifier) new Identifier("textures/map/map_background_checkerboard.png"));
	

	private static RenderLayer getTextNoCull(Identifier texture) {
		return textNoCull.apply(texture);
	}

	
	// custom render
	@Override
	public void renderFirstPersonMap(MatrixStack matricesWrapped, VertexConsumerProvider vertexConsumersWrapped, int light,
			ItemStack stack, boolean small, boolean lefthanded) {
		net.minecraft.client.util.math.MatrixStack matrices = ((TRLMatrixStack)matricesWrapped).handle();
		net.minecraft.client.render.VertexConsumerProvider vertexConsumers = ((TRLVertexConsumerProvider)vertexConsumersWrapped).handle();
		MinecraftClient client = MinecraftClient.getInstance();

		if (small) {
			matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(160.0f));
			matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(180.0f));
			matrices.scale(0.38f, 0.38f, 0.38f);
			
			matrices.translate(-0.1, -1.2, 0.0);
			matrices.scale(0.0098125f, 0.0098125f, 0.0098125f);
		} else {
			if(lefthanded) {
				matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(160.0f));
				matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(150.0f));
				matrices.scale(0.38f, 0.38f, 0.38f);
				
				matrices.translate(+0.5, -1.3, 0.0);
			} else {
				matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(160.0f));
				matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(210.0f));
				matrices.scale(0.38f, 0.38f, 0.38f);
				
				matrices.translate(-1.0, -1.8, 0.0);
			}

			matrices.scale(0.0138125f, 0.0138125f, 0.0138125f);
		}
		Integer integer = FilledMapItem.getMapId(((TRLItemStack) stack).handle());
		MapState mapState = FilledMapItem.getOrCreateMapState(((TRLItemStack) stack).handle(), (World) client.world);
		VertexConsumer vertexConsumer = vertexConsumers
				.getBuffer(mapState == null ? MAP_BACKGROUND : MAP_BACKGROUND_CHECKERBOARD);
		Matrix4f matrix4f = matrices.peek().getModel();
		vertexConsumer.vertex(matrix4f, -7.0f, 135.0f, 0.0f).color(255, 255, 255, 255).texture(0.0f, 1.0f).light(light)
				.next();
		vertexConsumer.vertex(matrix4f, 135.0f, 135.0f, 0.0f).color(255, 255, 255, 255).texture(1.0f, 1.0f).light(light)
				.next();
		vertexConsumer.vertex(matrix4f, 135.0f, -7.0f, 0.0f).color(255, 255, 255, 255).texture(1.0f, 0.0f).light(light)
				.next();
		vertexConsumer.vertex(matrix4f, -7.0f, -7.0f, 0.0f).color(255, 255, 255, 255).texture(0.0f, 0.0f).light(light)
				.next();
		if (mapState != null) {
			client.gameRenderer.getMapRenderer().draw(matrices, vertexConsumers, integer, mapState, false, light);
		}
	}

	@Override
	public boolean isChargedCrossbow(ItemStack item) {
		return CrossbowItem.isCharged(((TRLItemStack)item).handle());
	}

	@Override
	public WrappedEntityTrackerUpdate wrapEntityTrackerUpdatePacket(Object packet) {
		return new WrappedEntityTrackerUpdate() {
			
			private EntityTrackerUpdateS2CPacket etuPacket = (EntityTrackerUpdateS2CPacket) packet;
			
			@Override
			public Object getHandler() {
				return etuPacket;
			}

			@Override
			public int id() {
				return etuPacket.id();
			}

			@Override
			public boolean hasTrackedValues() {
				return etuPacket.getTrackedValues() != null;
			}

			@Override
			public void forEach(BiConsumer<Integer, Object> handler) {
				etuPacket.getTrackedValues().forEach(entry -> {
					handler.accept(entry.getData().getId(), entry.get());
				});
			}
		};
	}
	
}
