package dev.tr7zw.transliterationlib.api.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.api.HandleHolder;

public interface UseAction extends HandleHolder<UseAction> {

	public UseAction getNone();
	public UseAction getEat();
	public UseAction getDrink();
	public UseAction getBlock();
	public UseAction getBow();
	public UseAction getSpear();
	public UseAction getCrossbow();
	
	public UseAction of(Object handle);
	
}
