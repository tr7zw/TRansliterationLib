package dev.tr7zw.transliterationlib.forge.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.item.Hand;

public class TRLHand implements Hand{

	public static TRLHand mainHand = new TRLHand(net.minecraft.util.Hand.MAIN_HAND);
	public static TRLHand offHand = new TRLHand(net.minecraft.util.Hand.OFF_HAND);
	
	private final net.minecraft.util.Hand handle;
	
	private TRLHand(net.minecraft.util.Hand hand) {
		this.handle = hand;
	}
	
	@Override
	public Hand getMainHand() {
		return mainHand;
	}

	@Override
	public Hand getOffHand() {
		return offHand;
	}
	
	@Override
	public Object getHandler() {
		return handle;
	}

	@Override
	public <H> H getHandler(Class<H> clazz) {
		return (H) handle;
	}

	@Override
	public Hand of(Object handler) {
		if(handler == net.minecraft.util.Hand.MAIN_HAND) {
			return mainHand;
		}else {
			return offHand;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((handle == null) ? 0 : handle.hashCode());
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
		TRLHand other = (TRLHand) obj;
		if (handle != other.handle)
			return false;
		return true;
	}

	@Override
	public boolean isNull() {
		return handle == null;
	}

	
}
