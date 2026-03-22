package com.ironsword.gregtechmodernfoodoption.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;

public class GTMFOCreativeModeTabs {
    public static RegistryEntry<CreativeModeTab> MAIN_TAB = GTMFORegistries.REGISTRATE.defaultCreativeTab(
            GregTechModernFoodOption.MODID,
            builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(GregTechModernFoodOption.MODID,GTMFORegistries.REGISTRATE))
                    .icon(Items.WHEAT::getDefaultInstance)
                    .title(Component.literal("GregTech Modern Food Option"))
                    .build()
    ).register();

//    public static RegistryEntry<CreativeModeTab> MATERIAL_TAB = GTMFORegistries.REGISTRATE.defaultCreativeTab(
//            GregTechModernFoodOption.MODID+"_material",
//            builder -> builder
//                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(GregTechModernFoodOption.MODID,GTMFORegistries.REGISTRATE))
//                    .icon(GTMFOItems.KITCHEN_RECIPE::asStack)
//                    .title(Component.literal("GregTech Modern Food Option : Material"))
//                    .build()
//    ).register();

    public static void init() {}
}
