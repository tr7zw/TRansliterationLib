package dev.tr7zw.transliterationlib.api.wrapper.util;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.CancellationException;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

public class WrappedCallbackInfoReturnable<T extends HandleHolder<?>> {

	private final CallbackInfoReturnable callback;
	private T value;
	
	public WrappedCallbackInfoReturnable(CallbackInfoReturnable callback){
		this.callback = callback;
	}
	
	public void setReturnValue(T returnValue) throws CancellationException {
		callback.setReturnValue(returnValue.getHandler());
		value = returnValue;
    }
	
    public T getReturnValue() {
        return value;
    }
    
    public void cancel() {
    	callback.cancel();
    }
    
    public boolean isCanceled() {
    	return callback.isCancelled();
    }
	
}
