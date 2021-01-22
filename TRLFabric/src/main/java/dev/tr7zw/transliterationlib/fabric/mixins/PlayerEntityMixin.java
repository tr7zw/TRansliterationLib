package dev.tr7zw.transliterationlib.fabric.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import dev.tr7zw.transliterationlib.api.TRansliterationLib;
import dev.tr7zw.transliterationlib.api.event.PlayerEvents;
import dev.tr7zw.transliterationlib.api.wrapper.entity.Player;
import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

	private Player player = TRansliterationLib.transliteration.creationWrapper().getPlayer().of(this);
	
	@Inject(method = "tick", at = @At("RETURN"))
	public void tick(CallbackInfo info) {
		PlayerEvents.PLAYER_TICK_END.invoker().onTick(player, info);
	}
	
}
