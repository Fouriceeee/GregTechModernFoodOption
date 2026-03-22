package com.ironsword.gregtechmodernfoodoption.common.data.material;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class GTMFOMaterials {

    static Material COFFEE_GROUNDS = new Material.Builder(GTCEu.id("coffee_grounds"))
            .color(0x1a1612)
            .iconSet(MaterialIconSet.DULL)
            .dust()
            .flags(MaterialFlags.DISABLE_MATERIAL_RECIPES)
            .ignoredTagPrefixes(without(TagPrefix.dust))
            .buildAndRegister();

    //coffee
//    static Material COFFEE_ROASTED = coffee("coffee_roasted",0x1a1612);
//    static Material COFFEE_GRADED = coffee("coffee_graded",0x635c55);
//    static Material COFFEE_HULLED = coffee("coffee_hulled",0x7d4b16);
//    static Material COFFEE_DRIED = coffee("coffee_dried",0x8c6842);
//    static Material COFFEE_WET = coffee("coffee_wet",0x756452);
//    static Material COFFEE_BASIC = coffeeUnsorted("coffee_basic",0x3b220d);


    static Material FAT = new Material.Builder(GTCEu.id("fat"))
            .color(0xFFF200)
            .iconSet(GTMFOMaterialIconSets.ORGANIC)
            .ingot()
            .flags(MaterialFlags.DISABLE_MATERIAL_RECIPES)
            .ignoredTagPrefixes(without(TagPrefix.ingot))
            .buildAndRegister();

//    private static Material coffee(String id,int color){
//        return new Material.Builder(GTCEu.id(id))
//                .color(color)
//                .iconSet(GTMFOMaterialIconSets.OLD)
//                .flags(MaterialFlags.DISABLE_MATERIAL_RECIPES,GTMFOMaterialFlags.COFFEE)
//                .buildAndRegister();
//    }
//
//    private static Material coffeeUnsorted(String id,int color){
//        return new Material.Builder(GTCEu.id(id))
//                .color(color)
//                .iconSet(GTMFOMaterialIconSets.OLD)
//                .flags(MaterialFlags.DISABLE_MATERIAL_RECIPES,GTMFOMaterialFlags.COFFEE,GTMFOMaterialFlags.COFFEE_UNSORTED)
//                .buildAndRegister();
//    }

    private static TagPrefix[] without(TagPrefix tagPrefix){
        return TagPrefix.values().stream().filter(prefix->!prefix.equals(tagPrefix)).toArray(TagPrefix[]::new);
    }

    public static void init(){
    }
}
