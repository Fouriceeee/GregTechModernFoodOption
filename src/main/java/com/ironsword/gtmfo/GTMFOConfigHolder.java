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
                INSTANCE = Configuration.registerConfig(GTMFOConfigHolder.class, ConfigFormats.yaml()).getConfigInstance();
            }
        }
    }

    @Configurable
    public DevConfigs devConfigs  = new DevConfigs();


    public static class DevConfigs{
        @Configurable
        public boolean nutrientMode = false;
    }
}
