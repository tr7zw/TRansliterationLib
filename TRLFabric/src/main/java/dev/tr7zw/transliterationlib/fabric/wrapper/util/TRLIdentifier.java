package dev.tr7zw.transliterationlib.fabric.wrapper.util;

import dev.tr7zw.transliterationlib.api.wrapper.api.AbstractWrapper;
import net.minecraft.util.Identifier;

public class TRLIdentifier
		extends AbstractWrapper<Identifier, TRLIdentifier, dev.tr7zw.transliterationlib.api.wrapper.util.Identifier>
		implements dev.tr7zw.transliterationlib.api.wrapper.util.Identifier {

	@Override
	public String getNamespace() {
		return handle().getNamespace();
	}

	@Override
	public String getId() {
		return handle().getPath();
	}

}
