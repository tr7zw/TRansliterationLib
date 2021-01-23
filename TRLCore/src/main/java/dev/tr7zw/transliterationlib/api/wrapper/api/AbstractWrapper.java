package dev.tr7zw.transliterationlib.api.wrapper.api;

public abstract class AbstractWrapper<T, I extends AbstractWrapper<T, I, J>, J extends HandleHolder<J>> implements NativeWrapper<T, I, J> {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((handler == null) ? 0 : handler.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractWrapper other = (AbstractWrapper) obj;
		if (handler == null) {
			if (other.handler != null)
				return false;
		} else if (!handler.equals(other.handler))
			return false;
		return true;
	}
	
	

}