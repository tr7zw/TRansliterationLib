package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.EnumWrapper;
import dev.tr7zw.transliterationlib.api.wrapper.item.UseAction;
import dev.tr7zw.transliterationlib.fabric.wrapper.item.TRLUseAction;
import lombok.Getter;

@Getter
public class TRLEnumWrapper implements EnumWrapper {

	private final UseAction useAction = new TRLUseAction();

}
