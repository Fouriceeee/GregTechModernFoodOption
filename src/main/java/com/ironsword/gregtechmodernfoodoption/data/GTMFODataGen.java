package com.ironsword.gregtechmodernfoodoption.data;

import com.gregtechceu.gtceu.api.registry.GTRegistries;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;
import com.tterrag.registrate.providers.ProviderType;

public class GTMFODataGen {
    public static void initPre(){

    }

    public static void init(){

    }

    public static void initMaterialLang(){
        GTMFORegistries.REGISTRATE.addDataGenerator(ProviderType.LANG, GTMFOLangHandler::initENLang);
        GTMFORegistries.REGISTRATE.addDataGenerator(GTMFOProviderTypes.CNLANG, GTMFOLangHandler::initCNLang);
    }
}
