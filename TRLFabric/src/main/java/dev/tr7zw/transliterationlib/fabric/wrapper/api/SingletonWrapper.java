package dev.tr7zw.transliterationlib.fabric.wrapper.api;

import dev.tr7zw.transliterationlib.api.wrapper.api.Wrapper;
import dev.tr7zw.transliterationlib.api.wrapper.entity.ClientPlayer;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Entity;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import dev.tr7zw.transliterationlib.api.wrapper.util.Identifier;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLClientPlayer;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLEntity;
import dev.tr7zw.transliterationlib.fabric.wrapper.entity.TRLPlayer;
import dev.tr7zw.transliterationlib.fabric.wrapper.util.TRLIdentifier;
import lombok.Getter;

@Getter
public class SingletonWrapper implements Wrapper {

	private final Entity entity = new TRLEntity<>();
	private final Identifier identifier = new TRLIdentifier();
	private final ClientPlayer clientPlayer = new TRLClientPlayer<>();
	private final Player player = new TRLPlayer<>();

}
