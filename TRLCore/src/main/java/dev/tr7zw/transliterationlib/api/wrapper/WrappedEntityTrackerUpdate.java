package dev.tr7zw.transliterationlib.api.wrapper;

import java.util.function.BiConsumer;

public interface WrappedEntityTrackerUpdate extends NMSWrapper {

	public int id();
	
	public boolean hasTrackedValues();
	
	public void forEach(BiConsumer<Integer, Object> handler);
	
}
