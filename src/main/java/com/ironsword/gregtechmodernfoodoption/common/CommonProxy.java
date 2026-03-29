package com.ironsword.gregtechmodernfoodoption.common;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.ironsword.gregtechmodernfoodoption.GTMFOConfigHolder;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.api.capability.forge.GTMFOCapability;
import com.ironsword.gregtechmodernfoodoption.common.data.Foods;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOBlocks;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOCreativeModeTabs;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.machine.GTMFOMachines;
import com.ironsword.gregtechmodernfoodoption.common.data.machine.GTMFOMultiMachines;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOFluids;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOMaterials;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipeTypes;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;
import com.ironsword.gregtechmodernfoodoption.data.GTMFODataGen;
import com.ironsword.gregtechmodernfoodoption.data.GTMFOProviderTypes;
import net.minecraft.resources.ResourceLocation;
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

        GTMFOConfigHolder.init();

        GTMFOCreativeModeTabs.init();
        GTMFOBlocks.init();
        //Foods.init();
        GTMFOItems.init();

        GTMFODataGen.init();

        bus.addGenericListener(MachineDefinition.class,CommonProxy::registerMachines);
        bus.addGenericListener(GTRecipeType.class,CommonProxy::registerRecipeTypes);

        GTMFORegistries.REGISTRATE.registerRegistrate();
    }

    public static void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event){
        GTMFOMachines.init();
        GTMFOMultiMachines.init();
    }

    public static void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event){
        GTMFORecipeTypes.init();
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        GTMFOCapability.register(event);
    }

    @SubscribeEvent
    public static void registerMaterials(MaterialEvent event){
        GTMFOFluids.init();
        GTMFOMaterials.init();
        GTMFODataGen.initMaterialLang();
    }
}
