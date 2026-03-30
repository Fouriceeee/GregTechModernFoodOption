package com.ironsword.gregtechmodernfoodoption.common.data.machine;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOCreativeModeTabs;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipeTypes;
import com.ironsword.gregtechmodernfoodoption.data.CNLangProvider;
import com.mojang.datafixers.util.Pair;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import java.util.HashMap;
import java.util.Map;

import static com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries.REGISTRATE;

public class GTMFOMachines {
    public static final Map<String, Pair<String,String>> LANG = new HashMap<>();


    static {
        REGISTRATE.creativeModeTab(()-> GTMFOCreativeModeTabs.MAIN_TAB);
    }

    public static MachineDefinition[] SLICE = GTMachineUtils.registerSimpleMachines(REGISTRATE,"slicer", GTMFORecipeTypes.SLICER_RECIPES);
    public static MachineDefinition[] CUISINE_ASSEMBLER = GTMachineUtils.registerSimpleMachines(REGISTRATE,"cuisine_assembler",GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES);
    public static MachineDefinition[] MICROWAVE = GTMachineUtils.registerSimpleMachines(REGISTRATE,"microwave",GTMFORecipeTypes.MICROWAVE_RECIPES);
    public static MachineDefinition[] MULTICOOKER = GTMachineUtils.registerSimpleMachines(REGISTRATE,"multicooker",GTMFORecipeTypes.MULTICOOKER_RECIPES);


    public static void addLang(String id,String enLang,String cnLang){
        LANG.put("gtceu."+id,Pair.of(enLang,cnLang));
    }

    public static void init(){
        addLang("slicer"           ,"Slicer"           ,"食材切片机"  );
        addLang("cuisine_assembler","Cuisine Assembler","菜肴组装机"  );
        addLang("microwave"        ,"Microwave"        ,"微波炉"      );
        addLang("multicooker"      ,"Multicooker"      ,"多功能烹饪机");
    }

    public static void initENLang(RegistrateLangProvider provider){
        LANG.forEach((key,value)->provider.add(key,value.getFirst()));
    }

    public static void initCNLang(CNLangProvider provider){
        LANG.forEach((key,value)->provider.add(key,value.getSecond()));
    }
}
