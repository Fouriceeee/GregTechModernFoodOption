package com.ironsword.gtmfo.common;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;

import com.ironsword.gtmfo.GTMFOConfigHolder;
import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.data.*;
import com.ironsword.gtmfo.common.data.machine.GTMFOMachines;
import com.ironsword.gtmfo.common.data.machine.GTMFOMultiMachines;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import com.ironsword.gtmfo.common.data.material.GTMFOMaterials;
import com.ironsword.gtmfo.common.data.recipe.GTMFORecipeTypes;
import com.ironsword.gtmfo.common.registry.GTMFORecipeSerializers;
import com.ironsword.gtmfo.common.registry.GTMFORegistries;
import com.ironsword.gtmfo.data.GTMFODataGen;
import com.ironsword.gtmfo.data.GTMFOProviderTypes;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import java.lang.reflect.Field;

@Mod.EventBusSubscriber(modid = GregTechModernFoodOption.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    private static final Logger LOGGER = LogUtils.getLogger();

    public CommonProxy() {
        init();
    }

    public static void init() {
        @SuppressWarnings("removal")
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        GTMFOProviderTypes.init();
        GTMFODataGen.initPre();

        GTMFOConfigHolder.init();

        GTMFOCreativeModeTabs.init();
        GTMFOBlocks.init();
        GTMFOItems.init();

        bus.addGenericListener(MachineDefinition.class, CommonProxy::registerMachines);
        bus.addGenericListener(GTRecipeType.class, CommonProxy::registerRecipeTypes);

        GTMFODataGen.init();

        GTMFORegistries.REGISTRATE.registerRegistrate();

        GTMFOEffects.init(bus);
        GTMFORecipeSerializers.init(bus);
    }

    public static void registerMachines(GTCEuAPI.RegisterEvent<ResourceLocation, MachineDefinition> event) {
        GTMFOMachines.init();
        GTMFOMultiMachines.init();
        GTMFODataGen.initMachineLang();
    }

    public static void registerRecipeTypes(GTCEuAPI.RegisterEvent<ResourceLocation, GTRecipeType> event) {
        GTMFORecipeTypes.init();
    }

    @SubscribeEvent
    public static void registerMaterials(MaterialEvent event) {
        GTMFOFluids.init();
        GTMFOMaterials.init();
        GTMFODataGen.initMaterialLang();
    }

    @SubscribeEvent
    public static void modifyMaterials(PostMaterialEvent event) {
        GTMFOToolTypes.addRollingPinToMaterials();
    }

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        // event.enqueueWork(()->craftingReusable(GTItems.SHAPE_MOLD_CYLINDER.getId()));
    }

    private static void craftingReusable(ResourceLocation rl) {
        Item item = ForgeRegistries.ITEMS.getValue(rl);
        if (item == null || item == Items.AIR) {
            LOGGER.error("Item {} is not found", rl);
            return;
        }
        try {
            // f_41378_ is just Item#craftingRemainingItem
            Field field = ObfuscationReflectionHelper.findField(Item.class, "f_41378_");
            field.set(item, item);
            LOGGER.debug("Successfully set item {} reusable in crafting recipes", rl);
        } catch (Throwable t) {
            LOGGER.error("Failed to make item {} reusable", rl, t);
        }
    }
}
