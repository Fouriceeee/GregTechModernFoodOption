package com.ironsword.gregtechmodernfoodoption.data;

import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOEffects;
import com.ironsword.gregtechmodernfoodoption.common.data.machine.GTMFOMachines;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOMaterials;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;
import com.tterrag.registrate.providers.ProviderType;

public class GTMFODataGen {
    public static void initPre(){

    }

    public static void init(){

    }

    public static void initMaterialLang(){
        GTMFORegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, GTMFOMaterials::initENLang);
        GTMFORegistries.REGISTRATE.addDataGenerator(GTMFOProviderTypes.CNLANG, GTMFOMaterials::initCNLang);
    }

    public static void initMachineLang(){
        GTMFORegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, GTMFOMachines::initENLang);
        GTMFORegistries.REGISTRATE.addDataGenerator(GTMFOProviderTypes.CNLANG, GTMFOMachines::initCNLang);
    }

    public static void initEffectLang(){
        GTMFORegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, GTMFOEffects::initENLang);
        GTMFORegistries.REGISTRATE.addDataGenerator(GTMFOProviderTypes.CNLANG, GTMFOEffects::initCNLang);
    }

}
