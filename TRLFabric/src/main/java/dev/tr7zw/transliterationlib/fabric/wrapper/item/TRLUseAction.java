package dev.tr7zw.transliterationlib.fabric.wrapper.item;

import dev.tr7zw.transliterationlib.api.wrapper.item.UseAction;

public class TRLUseAction implements UseAction {
	
	private final UseAction NONE = new TRLUseAction(net.minecraft.util.UseAction.NONE);
	private final UseAction EAT = new TRLUseAction(net.minecraft.util.UseAction.EAT);
	private final UseAction DRINK = new TRLUseAction(net.minecraft.util.UseAction.DRINK);
	private final UseAction BLOCK = new TRLUseAction(net.minecraft.util.UseAction.BLOCK);
	private final UseAction BOW = new TRLUseAction(net.minecraft.util.UseAction.BOW);
	private final UseAction SPEAR = new TRLUseAction(net.minecraft.util.UseAction.SPEAR);
	private final UseAction CROSSBOW = new TRLUseAction(net.minecraft.util.UseAction.CROSSBOW);
	
	private final net.minecraft.util.UseAction handle;

	public TRLUseAction() {
		handle = null;
	}
	
	public TRLUseAction(net.minecraft.util.UseAction action) {
		handle = action;
	}
	
	@Override
	public Object getHandler() {
		return handle;
	}

	@Override
	public UseAction of(Object handler) {
		return new TRLUseAction(handle);
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
	
}
