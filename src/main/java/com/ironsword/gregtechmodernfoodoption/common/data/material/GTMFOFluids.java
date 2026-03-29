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
    public static final Material MELON_EXTRACT  = fluid("melon_extract" ,0xfc7996,"Melon Extract","西瓜提取液");
    public static final Material GRAPE_EXTRACT  = fluid("grape_extract" ,0xa83351,"Grape Extract","葡萄汁"    );

    public static final Material APRICOT_EXTRACT = fluid("apricot_extract",0xe3de9d,"Apricot Extract","杏子提取液");

    public static final Material CRANBERRY_EXTRACT  = fluid("cranberry_extract" ,0x8C0D22,"Cranberry Extract","蔓越莓提取液");

    public static final Material CANE_SYRUP          = fluid("cane_syrup"         ,0xf2f1dc,"Cane Syrup"         ,"甘蔗糖浆"      );
    public static final Material CANE_SYRUP_UNHEATED = fluid("cane_syrup_unheated",0xf0efe4,"Unheated Cane Syrup","未加热甘蔗糖浆");

    public static final Material ISOPROPYL_CHLORIDE = builder("isopropyl_chloride","Isopropyl Chloride","异丙基氯")
                    .components(Carbon,3, Hydrogen,7, Chlorine,1)
                    .formula("(CH3)2CHCl",true)
                    .buildAndRegister();

    public static final Material CHLOROAURIC_ACID = builder("chloroauric_acid","Chloroauric Acid","氯金酸")
                    .components(Hydrogen,1, Gold,1, Chlorine,4)
                    .buildAndRegister();

    public static final Material FRYING_OIL     = fluid("frying_oil"    ,0xffe3a1,"Frying Oil"    ,"煎炸油"  );
    public static final Material FRYING_OIL_HOT = fluid("frying_oil_hot",0xffd166,"Hot Frying Oil","热煎炸油");

    public static final Material TOMATO_SAUCE = fluid("tomato_sauce",0xfc2217,"Tomato Sauce","番茄酱");
    public static final Material OLIVE_OIL    = fluid("olive_oil"   ,0xd1db5a,"Olive Oil"   ,"橄榄油");

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
