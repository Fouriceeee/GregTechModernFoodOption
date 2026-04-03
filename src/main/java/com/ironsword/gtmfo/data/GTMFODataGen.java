package com.ironsword.gtmfo.data;

import com.ironsword.gtmfo.common.data.GTMFOEffects;
import com.ironsword.gtmfo.common.data.machine.GTMFOMachines;
import com.ironsword.gtmfo.common.data.material.GTMFOMaterials;
import com.ironsword.gtmfo.common.registry.GTMFORegistries;
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
