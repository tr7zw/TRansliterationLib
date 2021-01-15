package dev.tr7zw.transliterationlib.api.wrapper.api;

public interface HandleHolder<O extends HandleHolder<?>> {

	public Object getHandler();
	public <H> H getHandler(Class<H> clazz);
	public O of(Object handler);
	
}