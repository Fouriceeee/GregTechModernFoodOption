package com.ironsword.gregtechmodernfoodoption.common.data.material;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTElements;
import com.mojang.datafixers.util.Pair;

import static com.gregtechceu.gtceu.common.data.GTMaterials.*;

public class GTMFOFluids {

    public static final Material LEMON_EXTRACT  = fluid("lemon_extract" ,0xfce80a,"Lemon Extract","柠檬提取液");
    public static final Material LIME_EXTRACT   = fluid("lime_extract"  ,0x85f218,"Lime Extract" ,"酸橙提取液");
    public static final Material ORANGE_EXTRACT = fluid("orange_extract",0xff6100,"Orange Juice" ,"橙汁"      );
    public static final Material APPLE_EXTRACT  = fluid("apple_extract" ,0xe9ba58,"Apple Juice"  ,"苹果汁"    );

    public static final Material CANE_SYRUP          = fluid("cane_syrup"         ,0xf2f1dc,"Cane Syrup"         ,"甘蔗糖浆"      );
    public static final Material CANE_SYRUP_UNHEATED = fluid("cane_syrup_unheated",0xf0efe4,"Unheated Cane Syrup","未加热甘蔗糖浆");

    public static final Material ISOPROPYL_CHLORIDE = builder("isopropyl_chloride","Isopropyl Chloride","异丙基氯")
                    .components(Carbon,3, Hydrogen,7, Chlorine,1)
                    .formula("(CH3)2CHCl",true)
                    .buildAndRegister();

    public static final Material CHLOROAURIC_ACID = builder("chloroauric_acid","Chloroauric Acid","氯金酸")
                    .components(Hydrogen,1, Gold,1, Chlorine,4)
                    .buildAndRegister();

    private static Material fluid(String id, int color, String enLang, String cnLang){
        GTMFOMaterials.addLang(id,enLang,cnLang);
        return new Material.Builder(GTCEu.id(id)).color(color).fluid().buildAndRegister();
    }

    private static Material.Builder builder(String id, String enLang, String cnLang){
        GTMFOMaterials.addLang(id,enLang,cnLang);
        return new Material.Builder(GTCEu.id(id)).fluid();
    }

    private static Material.Builder builder(String id, int color, String enLang, String cnLang){
        GTMFOMaterials.addLang(id,enLang,cnLang);
        return new Material.Builder(GTCEu.id(id)).color(color).fluid();
    }

    public static void init(){
    }
}
