package dev.tr7zw.transliterationlib.api.wrapper.entity;

import dev.tr7zw.transliterationlib.api.annotations.AddToWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.internal.InternalEntity;

@AddToWrapper
public interface Entity extends InternalEntity{

	public Entity of(Object handle);
	public Object getHandler();
	
}
