package com.ironsword.gregtechmodernfoodoption.common;

import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.api.capability.forge.GTMFOCapability;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOCreativeModeTabs;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOMaterialItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOMaterials;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOMaterialIconSets;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;
import com.ironsword.gregtechmodernfoodoption.data.GTMFOProviderTypes;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = GregTechModernFoodOption.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    public CommonProxy(){
        init();
    }

    public static void init(){
        @SuppressWarnings("removal")
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        GTMFOProviderTypes.init();

        GTMFOMaterialIconSets.init();

        GTMFOCreativeModeTabs.init();
        GTMFOItems.init();
        GTMFOMaterialItems.init();

        GTMFORegistries.REGISTRATE.registerRegistrate();
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        GTMFOCapability.register(event);
    }

    @SubscribeEvent
    public static void registerMaterials(MaterialEvent event){
        GTMFOMaterials.init();
    }
}
