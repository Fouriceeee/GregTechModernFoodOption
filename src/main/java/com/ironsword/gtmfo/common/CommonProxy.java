package com.ironsword.gtmfo.common;

import com.gregtechceu.gtceu.api.GTCEuAPI;
import com.gregtechceu.gtceu.api.data.chemical.material.event.MaterialEvent;
import com.gregtechceu.gtceu.api.data.chemical.material.event.PostMaterialEvent;
import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
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
import java.util.Set;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("removal")
// @Mod.EventBusSubscriber(modid = GregTechModernFoodOption.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonProxy {

    private static final Logger LOGGER = LogUtils.getLogger();

    public CommonProxy() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);
        init();
    }

    public static void init() {
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
        GTMFOFeatures.init(bus);
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
    public void registerMaterials(MaterialEvent event) {
        GTMFOFluids.init();
        GTMFOMaterials.init();
        GTMFODataGen.initMaterialLang();
    }

    @SubscribeEvent
    public void modifyMaterials(PostMaterialEvent event) {
        GTMFOToolTypes.addRollingPinToMaterials();
    }

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        // event.enqueueWork(()->craftingReusable(GTItems.SHAPE_MOLD_CYLINDER.getId()));
    }

    @SubscribeEvent
    public void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper helper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> registries = event.getLookupProvider();

        if (event.includeServer()) {
            generator.addProvider(true, new DatapackBuiltinEntriesProvider(
                    packOutput,
                    registries,
                    new RegistrySetBuilder()
                            .add(Registries.CONFIGURED_FEATURE, GTMFOConfiguredFeatures::bootstrap)
                            .add(Registries.PLACED_FEATURE, GTMFOPlacedFeatures::bootstrap)
                            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, GTMFOBiomeModifiers::bootstrap),
                    Set.of(GregTechModernFoodOption.MODID)));
        }
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
