package dev.tr7zw.transliterationlib.api.event;

import dev.tr7zw.transliterationlib.api.event.api.TREvent;
import dev.tr7zw.transliterationlib.api.event.api.TREventFactory;

public class APIEvent {

	public static final TREvent<Runnable> LOADED = TREventFactory.createArrayBacked(Runnable.class, callbacks -> () -> {
		for (Runnable callback : callbacks) {
			callback.run();
		}
	});
	
}
