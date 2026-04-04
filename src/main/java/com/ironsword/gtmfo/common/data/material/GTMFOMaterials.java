package com.ironsword.gtmfo.common.data.material;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialIconSet;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.ironsword.gtmfo.GTMFOUtils;
import com.ironsword.gtmfo.data.CNLangProvider;
import com.mojang.datafixers.util.Pair;
import com.tterrag.registrate.providers.RegistrateLangProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GTMFOMaterials {

    public static final Map<String, Pair<String,String>> LANG_MAP = new HashMap<>();

    public static Material Zest = simpleDust("zest",0xd8ff4a,"Zest", "碎橙皮");
    public static Material SodiumCyanide = dust("sodium_cyanide", 0x7575ae,"Sodium Cyanide","氰化钠");

    private static TagPrefix[] without(TagPrefix tagPrefix){
        return TagPrefix.values().stream().filter(prefix->!prefix.equals(tagPrefix)).toArray(TagPrefix[]::new);
    }

    private static TagPrefix[] exclude(TagPrefix... tagPrefixes){
        var prefixes = List.of(tagPrefixes);
        return TagPrefix.values().stream().filter(prefix->!prefixes.contains(prefix)).toArray(TagPrefix[]::new);
    }

    static void addLang(String id,String enLang,String cnLang){
        LANG_MAP.put("material.gtceu."+id,Pair.of(enLang,cnLang));
    }

    private static Material simpleDust(String id,int color,String enLang,String cnLang){
        addLang(id,enLang,cnLang);
        return new Material.Builder(GTCEu.id(id)).color(color).dust().iconSet(MaterialIconSet.DULL).flags(MaterialFlags.DISABLE_MATERIAL_RECIPES).ignoredTagPrefixes(TagPrefix.dustSmall,TagPrefix.dustTiny).buildAndRegister();
    }

    private static Material dust(String id,int color,String enLang,String cnLang){
        addLang(id,enLang,cnLang);
        return new Material.Builder(GTCEu.id(id)).color(color).dust().iconSet(MaterialIconSet.DULL).buildAndRegister();
    }

    public static void init(){
        GTMaterials.BismuthBronze.addFlags(MaterialFlags.GENERATE_FRAME);
    }

    public static void initENLang(RegistrateLangProvider provider){
        LANG_MAP.forEach((key,value)->provider.add(key,value.getFirst()));
    }

    public static void initCNLang(CNLangProvider provider){
        LANG_MAP.forEach((key,value)->provider.add(key,value.getSecond()));
    }
}
