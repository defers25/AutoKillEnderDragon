package com.example.autokilldragon.mixin;

import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Set dragon health to zero on the logical server before its vanilla tick.
 * Vanilla's dragon death sequence handles the portal, XP, and fight state.
 */
@Mixin(EnderDragonEntity.class)
public abstract class EnderDragonEntityMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    private void autokilldragon$onTick(CallbackInfo ci) {
        EnderDragonEntity dragon = (EnderDragonEntity) (Object) this;
        if (!dragon.getWorld().isClient && dragon.getHealth() > 0.0F) {
            dragon.setHealth(0.0F);
        }
    }
}
