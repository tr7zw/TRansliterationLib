package dev.tr7zw.transliterationlib.api.wrapper;

import dev.tr7zw.transliterationlib.api.config.WrappedConfigEntry;
import dev.tr7zw.transliterationlib.api.wrapper.item.ItemStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.MatrixStack;
import dev.tr7zw.transliterationlib.api.wrapper.util.VertexConsumerProvider;

public interface OldWrapper {

	public WrappedScreen wrapScreen(Object screen);
	
	public WrappedText wrapText(Object text);
	
	public WrappedText getTranslateableText(String text);
	
	public WrappedConfigEntry getWrappedConfigEntry(Object clazz);
	
	public WrappedKeybind createKeyBind(String name, int key, String namespace);
	
	public WrappedWorld wrapWorld(Object world);
	
	public WrappedEntity wrapEntity(Object entity);
	
	public WrappedEntityTrackerUpdate wrapEntityTrackerUpdatePacket(Object packet);
	
	public void renderFirstPersonMap(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light,
			ItemStack stack, boolean small, boolean lefthanded);
	
	public boolean isChargedCrossbow(ItemStack item);
	
}
