package com.ironsword.gtmfo.common.data;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.block.FruitBushBlock;
import com.ironsword.gtmfo.common.worldgen.feature.configurations.FruitBushConfiguration;
import com.tterrag.registrate.util.entry.BlockEntry;

public class GTMFOConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("blueberry_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKBERRY_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("blackberry_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RASPBERRY_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("raspberry_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("strawberry_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_CURRANT_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("red_currant_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACK_CURRANT_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("black_currant_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_CURRANT_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("white_currant_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LINGONBERRY_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("lingonberry_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELDERBERRY_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("elderberry_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CRANBERRY_BUSH = ResourceKey.create(
            Registries.CONFIGURED_FEATURE, GregTechModernFoodOption.id("cranberry_bush"));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> ctx) {
        FeatureUtils.register(ctx, BLUEBERRY_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.BLUEBERRY_BUSH, 3, 1.2, 0.7, 0.5, 0.5));
        FeatureUtils.register(ctx, BLACKBERRY_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.BLACKBERRY_BUSH, 3, 1.2, 0.5, 0.4, 0.5));
        FeatureUtils.register(ctx, RASPBERRY_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.RASPBERRY_BUSH, 3, 1.2, 0.5, 0.5, 0.4));
        FeatureUtils.register(ctx, STRAWBERRY_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.STRAWBERRY_BUSH, 3, 1.2, 0.7, 0.8, 0.5));
        FeatureUtils.register(ctx, RED_CURRANT_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.RED_CURRANT_BUSH, 3, 0.9, 0.3, 0.75, 0.5));
        FeatureUtils.register(ctx, BLACK_CURRANT_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.BLACK_CURRANT_BUSH, 3, 0.9, 0.3, 0.75, 0.5));
        FeatureUtils.register(ctx, WHITE_CURRANT_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.WHITE_CURRANT_BUSH, 3, 0.9, 0.3, 0.75, 0.5));
        FeatureUtils.register(ctx, LINGONBERRY_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.LINGONBERRY_BUSH, 3, 0.9, 0.25, 0.7, 0.6));
        FeatureUtils.register(ctx, ELDERBERRY_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.ELDERBERRY_BUSH, 3, 0.9, 0.2, 0.4, 0.6));
        FeatureUtils.register(ctx, CRANBERRY_BUSH, GTMFOFeatures.FRUIT_BUSH.get(),
                configuration(GTMFOBlocks.CRANBERRY_BUSH, 3, 1.2, 0.2, 0.4, 0.6));
    }

    private static FruitBushConfiguration configuration(BlockEntry<FruitBushBlock> bush, int maxAmount,
                                                        double commonality, double optimalTemperature,
                                                        double optimalRainfall, double range) {
        Holder<Block> block = BuiltInRegistries.BLOCK.getHolderOrThrow(
                ResourceKey.create(Registries.BLOCK, bush.getId()));
        return new FruitBushConfiguration(block, maxAmount, commonality, optimalTemperature, optimalRainfall, range);
    }
}
