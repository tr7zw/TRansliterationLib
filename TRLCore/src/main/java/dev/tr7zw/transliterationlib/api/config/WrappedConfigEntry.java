package dev.tr7zw.transliterationlib.api.config;

import dev.tr7zw.transliterationlib.api.wrapper.NMSWrapper;

public interface WrappedConfigEntry extends NMSWrapper{

	public <T extends Enum<?>> T getEnumValue(Class<T> targetEnum);
	public int getIntValue();
	
}
