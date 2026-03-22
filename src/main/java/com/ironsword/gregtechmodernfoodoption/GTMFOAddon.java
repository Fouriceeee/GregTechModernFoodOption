package com.ironsword.gregtechmodernfoodoption;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOTagPrefixes;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;

@GTAddon
public class GTMFOAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return GTMFORegistries.REGISTRATE;
    }

    @Override
    public void initializeAddon() {

    }

    @Override
    public void registerTagPrefixes() {
        GTMFOTagPrefixes.init();
    }

    @Override
    public String addonModId() {
        return GregTechModernFoodOption.MODID;
    }
}
