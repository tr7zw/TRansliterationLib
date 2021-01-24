package dev.tr7zw.transliterationlib.fabric.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.item.UseAction;

public class TRLUseAction implements UseAction {
	
	public static final UseAction NONE = new TRLUseAction(net.minecraft.util.UseAction.NONE);
	public static final UseAction EAT = new TRLUseAction(net.minecraft.util.UseAction.EAT);
	public static final UseAction DRINK = new TRLUseAction(net.minecraft.util.UseAction.DRINK);
	public static final UseAction BLOCK = new TRLUseAction(net.minecraft.util.UseAction.BLOCK);
	public static final UseAction BOW = new TRLUseAction(net.minecraft.util.UseAction.BOW);
	public static final UseAction SPEAR = new TRLUseAction(net.minecraft.util.UseAction.SPEAR);
	public static final UseAction CROSSBOW = new TRLUseAction(net.minecraft.util.UseAction.CROSSBOW);
	
	private final net.minecraft.util.UseAction handle;
	
	private TRLUseAction(net.minecraft.util.UseAction action) {
		handle = action;
	}
	
	@Override
	public Object getHandler() {
		return handle;
	}

	@Override
	public UseAction of(Object handler) {
		if(handler == net.minecraft.util.UseAction.BLOCK)return BLOCK;
		if(handler == net.minecraft.util.UseAction.EAT)return EAT;
		if(handler == net.minecraft.util.UseAction.DRINK)return DRINK;
		if(handler == net.minecraft.util.UseAction.BOW)return BOW;
		if(handler == net.minecraft.util.UseAction.SPEAR)return SPEAR;
		if(handler == net.minecraft.util.UseAction.CROSSBOW)return CROSSBOW;
		return NONE;
	}

	@Override
	public UseAction getNone() {
		return NONE;
	}

	@Override
	public UseAction getEat() {
		return EAT;
	}

	@Override
	public UseAction getDrink() {
		return DRINK;
	}

	@Override
	public UseAction getBlock() {
		return BLOCK;
	}

	@Override
	public UseAction getBow() {
		return BOW;
	}

	@Override
	public UseAction getSpear() {
		return SPEAR;
	}

	@Override
	public UseAction getCrossbow() {
		return CROSSBOW;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <H> H getHandler(Class<H> clazz) {
		return (H) this.handle;
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
		TRLUseAction other = (TRLUseAction) obj;
		if (handle != other.handle)
			return false;
		return true;
	}
}
