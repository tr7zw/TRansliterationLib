package dev.tr7zw.transliterationlib.api.wrapper.api;

public interface NativeWrapper<T, I extends NativeWrapper<T, I, J>, J extends HandleHolder<?>> extends HandleHolder<J> {

	/**
	 * Get backing Object
	 * 
	 * @return
	 */
	public T getHandler();
	
	public I ofTyped(T handler);
	public J of(Object handler);
	
	public boolean isNull();
	
}