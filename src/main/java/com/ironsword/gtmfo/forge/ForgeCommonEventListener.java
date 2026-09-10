package com.ironsword.gtmfo.forge;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.data.GTMFOEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GregTechModernFoodOption.MODID, bus =  Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommonEventListener {

    @SubscribeEvent
    public static void onLivingEntityFall(LivingFallEvent event){
        LivingEntity entity = event.getEntity();
        if (entity.hasEffect(GTMFOEffects.FLY.get())){
            event.setDamageMultiplier(0);
        }
    }

//    @SubscribeEvent
//    public static void onEffectAdded(MobEffectEvent.Added event){
//        if (event.getEffectInstance().getEffect().equals(GTMFOEffects.CREATIVE_FLY.get()) && event.getEntity() instanceof Player player){
//            Abilities abilities =  player.getAbilities();
//            abilities.flying = true;
//        }
//    }
//
//    @SubscribeEvent
//    public static void onEffectRemoved(MobEffectEvent.Remove event){
//        if (event.getEffectInstance().getEffect().equals(GTMFOEffects.CREATIVE_FLY.get()) && event.getEntity() instanceof Player player){
//            Abilities abilities = player.getAbilities();
//            if (!abilities.instabuild && !player.isSpectator()){
//                abilities.mayfly = false;
//            }
//        }
//    }
//
//    @SubscribeEvent
//    public static void onEffectExpired(MobEffectEvent.Expired event){
//        if (event.getEffectInstance().getEffect().equals(GTMFOEffects.CREATIVE_FLY.get()) && event.getEntity() instanceof Player player){
//            Abilities abilities = player.getAbilities();
//            if (!abilities.instabuild && !player.isSpectator()){
//                abilities.mayfly = false;
//            }
//        }
//    }

}
