package com.ironsword.gregtechmodernfoodoption.common.data;

import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.common.effect.GTMFOEffect;
import com.ironsword.gregtechmodernfoodoption.data.CNLangProvider;
import com.ironsword.gregtechmodernfoodoption.data.GTMFODataGen;
import com.mojang.datafixers.util.Pair;
import com.tterrag.registrate.providers.RegistrateLangProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class GTMFOEffects {
    public static final Map<String, Pair<String,String>> EffectLangMap = new HashMap<>();

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GregTechModernFoodOption.MODID);

    public static final RegistryObject<MobEffect> CREATIVE_FLY = register("creative_fly",MobEffectCategory.BENEFICIAL,0,"Creative Fly","创造飞行");

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
