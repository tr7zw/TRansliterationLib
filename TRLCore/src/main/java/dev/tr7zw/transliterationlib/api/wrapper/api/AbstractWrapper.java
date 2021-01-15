package dev.tr7zw.transliterationlib.api.wrapper.api;

public abstract class AbstractWrapper<T, I extends AbstractWrapper<T, I, J>, J extends HandleHolder<?>> implements NativeWrapper<T, I, J> {

	private T handler;

	@Override
	public T getHandler() {
		return handler;
	}
	
	@Override
	public <H> H getHandler(Class<H> clazz) {
		return (H) handler;
	}

	@Override
	public I ofTyped(T handler) {
		this.handler = handler;
		return (I) this;
	}

	public T handle() {
		return handler;
	}

	@Override
	public J of(Object handler) {
		this.handler = (T) handler;
		return (J) this;
	}

}