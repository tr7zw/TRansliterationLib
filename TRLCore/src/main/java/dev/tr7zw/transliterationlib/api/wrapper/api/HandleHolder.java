package dev.tr7zw.transliterationlib.api.wrapper.api;

public interface HandleHolder<O> {

	public Object getHandler();
	public <H> H getHandler(Class<H> clazz);
	public O of(Object handler);
	public boolean isNull();
	
}