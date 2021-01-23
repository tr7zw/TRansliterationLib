package dev.tr7zw.transliterationlib.api.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

public interface Hand extends HandleHolder<Hand>{

	public Hand getMainHand();
	public Hand getOffHand();
	
}
