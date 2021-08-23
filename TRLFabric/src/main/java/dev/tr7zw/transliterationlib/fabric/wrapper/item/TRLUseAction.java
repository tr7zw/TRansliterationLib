package dev.tr7zw.transliterationlib.fabric.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.item.UseAction;
import net.minecraft.world.item.UseAnim;

public class TRLUseAction implements UseAction {
	
	public static final UseAction NONE = new TRLUseAction(UseAnim.NONE);
	public static final UseAction EAT = new TRLUseAction(UseAnim.EAT);
	public static final UseAction DRINK = new TRLUseAction(UseAnim.DRINK);
	public static final UseAction BLOCK = new TRLUseAction(UseAnim.BLOCK);
	public static final UseAction BOW = new TRLUseAction(UseAnim.BOW);
	public static final UseAction SPEAR = new TRLUseAction(UseAnim.SPEAR);
	public static final UseAction CROSSBOW = new TRLUseAction(UseAnim.CROSSBOW);
	
	private final UseAnim handle;
	
	private TRLUseAction(UseAnim action) {
		handle = action;
	}
	
	@Override
	public Object getHandler() {
		return handle;
	}

	@Override
	public UseAction of(Object handler) {
		if(handler == UseAnim.BLOCK)return BLOCK;
		if(handler == UseAnim.EAT)return EAT;
		if(handler == UseAnim.DRINK)return DRINK;
		if(handler == UseAnim.BOW)return BOW;
		if(handler == UseAnim.SPEAR)return SPEAR;
		if(handler == UseAnim.CROSSBOW)return CROSSBOW;
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
	
	@Override
	public boolean isNull() {
		return handle == null;
	}

	
}
