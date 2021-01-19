package dev.tr7zw.transliterationlib.api.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

public interface Identifier extends HandleHolder<Identifier> {

	public String getNamespace();
	public String getId();
	
}
