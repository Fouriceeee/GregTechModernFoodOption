package com.ironsword.gtmfo.common.data.material;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;

public class GTMFOFluids {

    public static final Material LEMON_EXTRACT  = fluid("lemon_extract" ,0xfce80a,"Lemon Extract","柠檬提取液");
    public static final Material LIME_EXTRACT   = fluid("lime_extract"  ,0x85f218,"Lime Extract" ,"酸橙提取液");
    public static final Material ORANGE_EXTRACT = fluid("orange_extract",0xff6100,"Orange Juice" ,"橙汁"      );
    public static final Material AppleExtract   = fluid("apple_extract" ,0xe9ba58,"Apple Juice"  ,"苹果汁"    );
    public static final Material MELON_EXTRACT  = fluid("melon_extract" ,0xfc7996,"Melon Extract","西瓜提取液");
    public static final Material GRAPE_EXTRACT  = fluid("grape_extract" ,0xa83351,"Grape Extract","葡萄汁"    );
//
//    public static final Material APRICOT_EXTRACT = fluid("apricot_extract",0xe3de9d,"Apricot Extract","杏子提取液");
//
//    public static final Material CRANBERRY_EXTRACT  = fluid("cranberry_extract" ,0x8C0D22,"Cranberry Extract","蔓越莓提取液");
//
    public static final Material CaneSyrup         = fluid("cane_syrup"         ,0xf2f1dc,"Cane Syrup"         ,"甘蔗糖浆"      );
    public static final Material CaneSyrupUnheated = fluid("cane_syrup_unheated",0xf0efe4,"Unheated Cane Syrup","未加热甘蔗糖浆");

//    public static final Material ISOPROPYL_CHLORIDE = builder("isopropyl_chloride","Isopropyl Chloride","异丙基氯")
//                    .components(Carbon,3, Hydrogen,7, Chlorine,1)
//                    .formula("(CH3)2CHCl",true)
//                    .buildAndRegister();
//
//    public static final Material CHLOROAURIC_ACID = builder("chloroauric_acid","Chloroauric Acid","氯金酸")
//                    .components(Hydrogen,1, Gold,1, Chlorine,4)
//                    .buildAndRegister();

    public static final Material FryingOil = fluid("frying_oil"    ,0xffe3a1,"Frying Oil"    ,"煎炸油"  );
    public static final Material FryingOilHot = fluid("frying_oil_hot",0xffd166,"Hot Frying Oil","热煎炸油");

    public static final Material TomatoSauce = fluid("tomato_sauce",0xfc2217,"Tomato Sauce","番茄酱");
    public static final Material OliveOil = fluid("olive_oil",0xd1db5a,"Olive Oil","橄榄油");
    public static final Material HotMilk = fluid("hot_milk",0xfffbf0,"Hot Milk","热牛奶");
    public static final Material Egg          = fluid("egg"         ,0xFFFF0F,"Egg"         ,"蛋"    );
    public static final Material Albumen      = fluid("albumen"     ,0xfffef7,"Albumen"     ,"蛋清"  );
    public static final Material Yolk         = fluid("yolk"        ,0xffdf00,"Yolk"        ,"蛋黄"  );
    public static final Material Butter       = fluid("butter"      ,0xffef82,"Butter"      ,"黄油"  );

    public static final Material SweetenedDilutedCaneSyrupMixture = fluid("sweetened_diluted_cane_syrup_mixture",0xdedcc8,"Sweetened Diluted Cane Syrup Mixture","稀释加糖甘蔗糖浆混合物");
    public static final Material MarshmallowSyrupMixture = fluid("marshmallow_syrup_mixture",0xe6e0dc,"Marshmallow Syrup Mixture","棉花软糖糖浆混合物");
    public static final Material MarshmallowFoam = fluid("marshmallow_foam",0xe6e0dc,"Marshmallow Foam","发泡棉花软糖糖浆");

    public static final Material AppleCandySyrup = fluid("apple_candy_syrup",0xe7f5ae,"Apple Candy Syrup","苹果糖浆");

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
