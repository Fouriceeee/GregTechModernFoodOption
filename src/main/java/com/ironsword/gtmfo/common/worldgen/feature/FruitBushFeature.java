package com.ironsword.gtmfo.common.worldgen.feature;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.SectionPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.synth.SimplexNoise;

import com.ironsword.gtmfo.GTMFOConfigHolder;
import com.ironsword.gtmfo.common.block.FruitBushBlock;
import com.ironsword.gtmfo.common.worldgen.feature.configurations.FruitBushConfiguration;
import com.mojang.logging.LogUtils;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FruitBushFeature extends Feature<FruitBushConfiguration> {

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final double PERLIN_SCALE = 0.04;

    private static final List<Direction> ATTACH_FACES = List.of(Direction.UP, Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST);

    private static final Map<Long, SimplexNoise> NOISE_CACHE = new ConcurrentHashMap<>();

    public FruitBushFeature() {
        super(FruitBushConfiguration.CODEC);
    }

    @Override
    public boolean place(@NotNull FeaturePlaceContext<FruitBushConfiguration> context) {
        if (!GTMFOConfigHolder.INSTANCE.worldgen.enableFruitBushes) {
            return false;
        }
        WorldGenLevel level = context.level();
        if (level.getLevel().getChunkSource().getGenerator() instanceof FlatLevelSource) {
            return false;
        }

        FruitBushConfiguration config = context.config();
        if (!(config.bush().value() instanceof FruitBushBlock bush)) {
            LOGGER.warn("Skipping fruit bush feature, {} is not a fruit bush block", config.bush());
            return false;
        }

        RandomSource random = context.random();
        BlockPos origin = context.origin();
        int chunkX = SectionPos.blockToSectionCoord(origin.getX());
        int chunkZ = SectionPos.blockToSectionCoord(origin.getZ());
        long worldSeed = level.getSeed();

        int featureCount = getAmountInChunk(config, level, worldSeed, chunkX, chunkZ);
        if (featureCount <= 0) {
            return false;
        }

        boolean placed = false;
        for (int i = 0; i < featureCount; i++) {
            int x = (chunkX << 4) + random.nextInt(16);
            int z = (chunkZ << 4) + random.nextInt(16);
            int y = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
            if (generate(level, random, bush, new BlockPos(x, y, z))) {
                placed = true;
            } else {
                featureCount--;
            }
        }
        return placed;
    }

    private static int getAmountInChunk(FruitBushConfiguration config, WorldGenLevel level, long worldSeed, int chunkX,
                                        int chunkZ) {
        BlockPos biomePos = new BlockPos((chunkX << 4) + 8, level.getSeaLevel(), (chunkZ << 4) + 8);
        Biome biome = level.getBiome(biomePos).value();
        double habitation = config.range() - Math.sqrt(
                Math.pow(biome.getBaseTemperature() - config.optimalTemp(), 2) +
                        Math.pow(biome.getModifiedClimateSettings().downfall() - config.optimalRain(), 2));
        if (habitation <= 0) {
            return 0;
        }
        double perlinCutoff = 1 - habitation * config.commonality();
        if (getRandomStrength(config, worldSeed, chunkX, chunkZ) <= perlinCutoff) {
            return 0;
        }
        return (int) Math.ceil(config.maxAmount() * (1 - perlinCutoff));
    }

    private static double getRandomStrength(FruitBushConfiguration config, long worldSeed, int chunkX, int chunkZ) {
        long seed = worldSeed + BuiltInRegistries.BLOCK.getKey(config.bush().value()).hashCode();
        SimplexNoise noise = NOISE_CACHE.computeIfAbsent(seed,
                value -> new SimplexNoise(RandomSource.create(value)));
        return noise.getValue(chunkX * PERLIN_SCALE, chunkZ * PERLIN_SCALE);
    }

    private static boolean generate(WorldGenLevel level, RandomSource random, FruitBushBlock bush, BlockPos pos) {
        BlockState baseState = bushState(random, bush, Direction.DOWN);
        if (!canGrowAt(level, pos, baseState)) {
            return false;
        }
        // place bush
        level.setBlock(pos, baseState, Block.UPDATE_ALL);

        List<Direction> availableFaces = new ArrayList<>(ATTACH_FACES);
        // place 1-3 sub-bushes on the faces of the bush
        for (int i = 0, attachments = 1 + random.nextInt(3); i < attachments; i++) {
            Direction face = availableFaces.remove(random.nextInt(availableFaces.size()));
            BlockPos attachPos = face == Direction.UP ? pos.above() : pos.relative(face.getOpposite());
            BlockState attachState = bushState(random, bush, face);
            if (canGrowAt(level, attachPos, attachState)) {
                level.setBlock(attachPos, attachState, Block.UPDATE_ALL);
            }
        }
        return true;
    }

    private static boolean canGrowAt(WorldGenLevel level, BlockPos pos, BlockState state) {
        if (pos.getY() < level.getMinBuildHeight() || pos.getY() >= level.getMinBuildHeight() + level.getHeight()) {
            return false;
        }
        BlockState current = level.getBlockState(pos);
        if (!current.isAir() && !current.is(Blocks.SNOW) && !current.is(Blocks.VINE)) {
            return false;
        }
        return state.canSurvive(level, pos);
    }

    private static BlockState bushState(RandomSource random, FruitBushBlock bush, Direction facing) {
        return bush.defaultBlockState()
                .setValue(FruitBushBlock.AGE, random.nextInt(FruitBushBlock.MAX_AGE + 1))
                .setValue(DirectionalBlock.FACING, facing);
    }
}
