package com.ironsword.gtmfo.common.data;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import com.ironsword.gtmfo.GregTechModernFoodOption;

public class GTMFOBiomeModifiers {

    public static final ResourceKey<BiomeModifier> FRUIT_BUSH_MODIFIER = ResourceKey.create(
            ForgeRegistries.Keys.BIOME_MODIFIERS, GregTechModernFoodOption.id("fruit_bush"));

    public static void bootstrap(BootstapContext<BiomeModifier> ctx) {
        HolderGetter<Biome> biomeLookup = ctx.lookup(Registries.BIOME);
        HolderGetter<PlacedFeature> placedFeatures = ctx.lookup(Registries.PLACED_FEATURE);

        ctx.register(FRUIT_BUSH_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomeLookup.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.BLUEBERRY_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.BLACKBERRY_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.RASPBERRY_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.STRAWBERRY_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.RED_CURRANT_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.BLACK_CURRANT_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.WHITE_CURRANT_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.LINGONBERRY_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.ELDERBERRY_BUSH),
                        placedFeatures.getOrThrow(GTMFOPlacedFeatures.CRANBERRY_BUSH)),
                GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}
