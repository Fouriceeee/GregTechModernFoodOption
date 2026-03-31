package com.ironsword.gregtechmodernfoodoption.common.data.machine;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOCreativeModeTabs;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipeTypes;
import com.ironsword.gregtechmodernfoodoption.data.CNLangProvider;
import com.mojang.datafixers.util.Pair;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.gregtechceu.gtceu.api.GTValues.VLVT;
import static com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries.REGISTRATE;
import static net.minecraft.ChatFormatting.*;

public class GTMFOMachines {
    public static final String[] VLVH_CN = new String[] {
            "超低压",
            "基础",
            AQUA + "进阶",
            GOLD + "进阶",
            DARK_PURPLE + "进阶",
            BLUE + "精英",
            LIGHT_PURPLE + "精英",
            RED + "精英",
            DARK_AQUA + "终极",
            DARK_RED + "史诗",
            GREEN + "史诗",
            DARK_GREEN + "史诗",
            YELLOW + "史诗",
            BLUE.toString() + BOLD + "传奇",
            RED.toString() + BOLD + "MAX" };

    public static final Map<String, Pair<String,String>> JEILangPairMap = new HashMap<>();
    public static final Map<String, String> CNLangMap = new HashMap<>();

    static {
        REGISTRATE.creativeModeTab(()-> GTMFOCreativeModeTabs.MAIN_TAB);
    }

    public static MachineDefinition[] SLICER = GTMachineUtils.registerSimpleMachines(REGISTRATE,"slicer", GTMFORecipeTypes.SLICER_RECIPES);
    public static MachineDefinition[] CUISINE_ASSEMBLER = GTMachineUtils.registerSimpleMachines(REGISTRATE,"cuisine_assembler",GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES);
    public static MachineDefinition[] MICROWAVE = GTMachineUtils.registerSimpleMachines(REGISTRATE,"microwave",GTMFORecipeTypes.MICROWAVE_RECIPES);
    public static MachineDefinition[] MULTICOOKER = GTMachineUtils.registerSimpleMachines(REGISTRATE,"multicooker",GTMFORecipeTypes.MULTICOOKER_RECIPES);


    public static void addJEILang(String name, String enLang, String cnLang){
        JEILangPairMap.put("gtceu."+name,Pair.of(enLang,cnLang));
    }

    public static void addTieredLang(String name, String enLang, String cnLang){
        addJEILang(name,enLang,cnLang);
        for (int tier:GTMachineUtils.ELECTRIC_TIERS){
            CNLangMap.put("block."+ GregTechModernFoodOption.MODID+ "." +GTValues.VN[tier].toLowerCase(Locale.ROOT) + "_" + name,"%s%s %s".formatted(VLVH_CN[tier], cnLang, VLVT[tier]));
        }
    }

    public static void init(){
        addTieredLang("slicer","Slicer","食材切片机");
        addTieredLang("cuisine_assembler","Cuisine Assembler","菜肴组装机");
        addTieredLang("microwave","Microwave","微波炉");
        addTieredLang("multicooker","Multicooker","多功能烹饪机");
    }

    public static void initENLang(RegistrateLangProvider provider){
        JEILangPairMap.forEach((key, value)->provider.add(key,value.getFirst()));
    }

    public static void initCNLang(CNLangProvider provider){
        JEILangPairMap.forEach((key, value)->provider.add(key,value.getSecond()));
        CNLangMap.forEach(provider::add);
    }
}
