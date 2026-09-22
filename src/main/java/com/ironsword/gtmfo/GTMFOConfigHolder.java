package com.ironsword.gtmfo;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.format.ConfigFormats;

@Config(id = GregTechModernFoodOption.MODID)
public class GTMFOConfigHolder {

    public static GTMFOConfigHolder INSTANCE;
    private static final Object LOCK = new Object();

    public static void init() {
        synchronized (LOCK) {
            if (INSTANCE == null) {
                INSTANCE = Configuration.registerConfig(GTMFOConfigHolder.class, ConfigFormats.yaml())
                        .getConfigInstance();
            }
        }
    }

    @Configurable
    @Configurable.Comment({ "Config options for world generation" })
    public WorldGenConfigs worldgen = new WorldGenConfigs();

    public static class WorldGenConfigs {

        @Configurable
        @Configurable.Comment({ "Whether fruit bushes generate naturally in the world.",
                "Default: true" })
        public boolean enableFruitBushes = true;

    }
}
