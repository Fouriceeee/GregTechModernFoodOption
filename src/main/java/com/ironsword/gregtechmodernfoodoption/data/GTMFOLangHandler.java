package com.ironsword.gregtechmodernfoodoption.data;

import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOMaterials;
import com.mojang.datafixers.util.Pair;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import java.util.HashMap;
import java.util.Map;


public class GTMFOLangHandler extends com.gregtechceu.gtceu.data.lang.LangHandler{


    public static void initENLang(RegistrateLangProvider provider){
        GTMFOMaterials.LANG_MAP.forEach((key,value)->provider.add(key,value.getFirst()));
    }

    public static void initCNLang(CNLangProvider provider){
        GTMFOMaterials.LANG_MAP.forEach((key,value)->provider.add(key,value.getSecond()));
    }


}
