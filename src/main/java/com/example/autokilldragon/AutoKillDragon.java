package com.example.autokilldragon;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;

public class AutoKillDragon implements ModInitializer {
    @Override
    public void onInitialize() {
        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if (entity instanceof EnderDragonEntity dragon && dragon.getHealth() > 0.0F) {
                dragon.setHealth(0.0F);
            }
        });
    }
}
