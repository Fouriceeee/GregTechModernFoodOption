package com.ironsword.gtmfo.common.data;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.worldgen.feature.FruitBushFeature;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class GTMFOFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE,
            GregTechModernFoodOption.MODID);

    public static final RegistryObject<FruitBushFeature> FRUIT_BUSH = FEATURES.register("fruit_bush",
            FruitBushFeature::new);

    public static void init(IEventBus bus) {
        FEATURES.register(bus);
    }
}
