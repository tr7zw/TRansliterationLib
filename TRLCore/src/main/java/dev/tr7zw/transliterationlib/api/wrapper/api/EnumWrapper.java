package dev.tr7zw.transliterationlib.api.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.item.Hand;
import dev.tr7zw.transliterationlib.api.wrapper.item.Items;
import dev.tr7zw.transliterationlib.api.wrapper.item.UseAction;

public interface EnumWrapper {

	public UseAction getUseAction();
	public Items getItems();
	public Arm getArm();
	public Hand getHand();
	
}
