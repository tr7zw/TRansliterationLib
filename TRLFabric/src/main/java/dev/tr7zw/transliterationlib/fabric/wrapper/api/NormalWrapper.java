package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLEntity;

public class NormalWrapper implements Wrapper {

	@Override
	public Entity getEntity() {
		return new TRLEntity();
	}

}
