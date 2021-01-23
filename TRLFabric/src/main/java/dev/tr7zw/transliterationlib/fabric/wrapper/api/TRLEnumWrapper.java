package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.EnumWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.item.Arm;
import dev.tr7zw.transliterationlib.api.wrapper.item.Hand;
import dev.tr7zw.transliterationlib.api.wrapper.item.Items;
import dev.tr7zw.transliterationlib.api.wrapper.item.UseAction;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLArm;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLHand;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLItems;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLUseAction;
import lombok.Getter;

@Getter
public class TRLEnumWrapper implements EnumWrapper {

	private final UseAction useAction = TRLUseAction.NONE;
	private final Items items = new TRLItems();
	private final Arm arm = TRLArm.RIGHT;
	private final Hand hand = TRLHand.mainHand;

}
