package com.ironsword.gtmfo.common.data;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.effect.GTMFOEffect;
import com.ironsword.gtmfo.data.CNLangProvider;
import com.ironsword.gtmfo.data.GTMFODataGen;
import com.mojang.datafixers.util.Pair;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class GTMFOEffects {
    public static final Map<String, Pair<String,String>> EffectLangMap = new HashMap<>();

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GregTechModernFoodOption.MODID);

    //WIP
    public static final RegistryObject<MobEffect> FLY     = register("fly"    ,MobEffectCategory.BENEFICIAL,0,"Fly"            ,"飞行");
    public static final RegistryObject<MobEffect> SNOW    = register("snow"   ,MobEffectCategory.NEUTRAL   ,0,"Snow-Protected" ,"霜之守护");
    public static final RegistryObject<MobEffect> VENTING = register("venting",MobEffectCategory.NEUTRAL   ,0,"Venting"        ,"风口传送");
    public static final RegistryObject<MobEffect> CHORUS  = register("chorus" ,MobEffectCategory.NEUTRAL   ,0,"Enhanced Chorus","Enhanced Chorus");

    private static RegistryObject<MobEffect> register(String name, MobEffectCategory category, int color, String enLang, String cnLang){
        EffectLangMap.put(GregTechModernFoodOption.langKey("effect",name),Pair.of(enLang,cnLang));
        return EFFECTS.register(name,()->new GTMFOEffect(category,color));
    }

    public static void init(IEventBus bus){
        EFFECTS.register(bus);
        GTMFODataGen.initEffectLang();
    }

    public static void initENLang(RegistrateLangProvider provider){
        EffectLangMap.forEach((key,value)->provider.add(key,value.getFirst()));
    }

    public static void initCNLang(CNLangProvider provider){
        EffectLangMap.forEach((key,value)->provider.add(key,value.getSecond()));
    }
}
