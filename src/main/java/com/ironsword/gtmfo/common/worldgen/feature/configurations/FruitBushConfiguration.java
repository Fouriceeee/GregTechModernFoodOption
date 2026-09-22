package com.ironsword.gtmfo.common.worldgen.feature.configurations;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import com.ironsword.gtmfo.common.block.FruitBushBlock;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.function.Function;

public record FruitBushConfiguration(Holder<Block> bush, int maxAmount, double commonality, double optimalTemp,
                                     double optimalRain, double range)
        implements FeatureConfiguration {

    public static final Codec<FruitBushConfiguration> CODEC = RecordCodecBuilder
            .<FruitBushConfiguration>create(instance -> instance.group(
                    BuiltInRegistries.BLOCK.holderByNameCodec().fieldOf("bush").forGetter(FruitBushConfiguration::bush),
                    Codec.intRange(1, 64).fieldOf("max_amount").forGetter(FruitBushConfiguration::maxAmount),
                    Codec.DOUBLE.fieldOf("commonality").forGetter(FruitBushConfiguration::commonality),
                    Codec.DOUBLE.fieldOf("optimal_temp").forGetter(FruitBushConfiguration::optimalTemp),
                    Codec.DOUBLE.fieldOf("optimal_rain").forGetter(FruitBushConfiguration::optimalRain),
                    Codec.DOUBLE.fieldOf("range").forGetter(FruitBushConfiguration::range))
                    .apply(instance, FruitBushConfiguration::new))
            .comapFlatMap(configuration -> configuration.bush().value() instanceof FruitBushBlock ?
                    DataResult.success(configuration) :
                    DataResult.error(() -> "Bush " + BuiltInRegistries.BLOCK.getKey(configuration.bush().value()) +
                            " is not a fruit bush block"),
                    Function.identity());
}
