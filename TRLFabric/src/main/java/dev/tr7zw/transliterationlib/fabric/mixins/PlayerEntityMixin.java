package dev.tr7zw.transliterationlib.fabric.mixins;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;

import net.minecraft.entity.player.PlayerEntity;

@Mixin(PlayerEntity.class)
public class PlayerEntityMixin {

	/*@Inject(method = "tick", at = @At("RETURN"))
	public void tick(CallbackInfo info) {
		if(shouldFixateBody()) { // Bring first person blocking to the third person, fix eating/drinking
			this.bodyYaw = headYaw;
			this.prevBodyYaw = prevHeadYaw;
		}
	}*/
	
}
