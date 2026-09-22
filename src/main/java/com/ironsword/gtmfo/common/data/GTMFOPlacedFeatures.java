package com.ironsword.gtmfo.common.data;

import com.ironsword.gtmfo.GregTechModernFoodOption;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class GTMFOPlacedFeatures {

    public static final ResourceKey<PlacedFeature> BLUEBERRY_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("blueberry_bush"));
    public static final ResourceKey<PlacedFeature> BLACKBERRY_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("blackberry_bush"));
    public static final ResourceKey<PlacedFeature> RASPBERRY_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("raspberry_bush"));
    public static final ResourceKey<PlacedFeature> STRAWBERRY_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("strawberry_bush"));
    public static final ResourceKey<PlacedFeature> RED_CURRANT_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("red_currant_bush"));
    public static final ResourceKey<PlacedFeature> BLACK_CURRANT_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("black_currant_bush"));
    public static final ResourceKey<PlacedFeature> WHITE_CURRANT_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("white_currant_bush"));
    public static final ResourceKey<PlacedFeature> LINGONBERRY_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("lingonberry_bush"));
    public static final ResourceKey<PlacedFeature> ELDERBERRY_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("elderberry_bush"));
    public static final ResourceKey<PlacedFeature> CRANBERRY_BUSH = ResourceKey.create(Registries.PLACED_FEATURE,
            GregTechModernFoodOption.id("cranberry_bush"));

    public static void bootstrap(BootstapContext<PlacedFeature> ctx) {
        HolderGetter<ConfiguredFeature<?, ?>> featureLookup = ctx.lookup(Registries.CONFIGURED_FEATURE);

        register(ctx, featureLookup, BLUEBERRY_BUSH, GTMFOConfiguredFeatures.BLUEBERRY_BUSH);
        register(ctx, featureLookup, BLACKBERRY_BUSH, GTMFOConfiguredFeatures.BLACKBERRY_BUSH);
        register(ctx, featureLookup, RASPBERRY_BUSH, GTMFOConfiguredFeatures.RASPBERRY_BUSH);
        register(ctx, featureLookup, STRAWBERRY_BUSH, GTMFOConfiguredFeatures.STRAWBERRY_BUSH);
        register(ctx, featureLookup, RED_CURRANT_BUSH, GTMFOConfiguredFeatures.RED_CURRANT_BUSH);
        register(ctx, featureLookup, BLACK_CURRANT_BUSH, GTMFOConfiguredFeatures.BLACK_CURRANT_BUSH);
        register(ctx, featureLookup, WHITE_CURRANT_BUSH, GTMFOConfiguredFeatures.WHITE_CURRANT_BUSH);
        register(ctx, featureLookup, LINGONBERRY_BUSH, GTMFOConfiguredFeatures.LINGONBERRY_BUSH);
        register(ctx, featureLookup, ELDERBERRY_BUSH, GTMFOConfiguredFeatures.ELDERBERRY_BUSH);
        register(ctx, featureLookup, CRANBERRY_BUSH, GTMFOConfiguredFeatures.CRANBERRY_BUSH);
    }

    private static void register(BootstapContext<PlacedFeature> ctx,
                                 HolderGetter<ConfiguredFeature<?, ?>> featureLookup,
                                 ResourceKey<PlacedFeature> placedFeature,
                                 ResourceKey<ConfiguredFeature<?, ?>> configuredFeature) {
        PlacementUtils.register(ctx, placedFeature, featureLookup.getOrThrow(configuredFeature),
                CountPlacement.of(1),
                BiomeFilter.biome());
    }
}
