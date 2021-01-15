package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLEntity;
import lombok.Getter;

@Getter
public class SingletonWrapper implements Wrapper {

	private Entity entity = new TRLEntity();

}
