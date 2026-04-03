package com.ironsword.gtmfo.api.capability.forge;

import com.ironsword.gtmfo.api.capability.NutrientsTracker;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import org.jetbrains.annotations.NotNull;

public class GTMFOCapability {

    public static final Capability<NutrientsTracker> CAPABILITY_NUTRIENTS_TRACKER = CapabilityManager.get(new CapabilityToken<>() {});

    public static NutrientsTracker getNutrientsTracker(@NotNull Player player){
        return player.getCapability(CAPABILITY_NUTRIENTS_TRACKER,null).resolve().orElse(null);
    }

    public static void register(RegisterCapabilitiesEvent event){
        event.register(NutrientsTracker.class);
    }
}
