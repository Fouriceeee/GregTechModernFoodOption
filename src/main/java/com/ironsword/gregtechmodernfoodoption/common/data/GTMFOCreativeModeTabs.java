package com.ironsword.gregtechmodernfoodoption.common.data;

import com.gregtechceu.gtceu.common.data.GTCreativeModeTabs;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.common.data.machine.GTMFOMachines;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Items;

import static com.gregtechceu.gtceu.common.registry.GTRegistration.REGISTRATE;

public class GTMFOCreativeModeTabs {
    public static RegistryEntry<CreativeModeTab> MAIN_TAB = GTMFORegistries.REGISTRATE.defaultCreativeTab(
            GregTechModernFoodOption.MODID,
            builder -> builder
                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator(GregTechModernFoodOption.MODID,GTMFORegistries.REGISTRATE))
                    .icon(GTMFOItems.CHIPS_BAG::asStack)
                    .title(Component.literal("GregTech Modern Food Option"))
                    .build()
    ).register();

//    public static RegistryEntry<CreativeModeTab> BLOCK_TAB = GTMFORegistries.REGISTRATE.defaultCreativeTab(
//            GregTechModernFoodOption.MODID+"_block",
//            builder -> builder
//                    .displayItems(new GTCreativeModeTabs.RegistrateDisplayItemsGenerator("blocks",GTMFORegistries.REGISTRATE))
//                    .icon(()->GTMFOMachines.SLICE[1].asStack())
//                    .title(Component.literal("GregTech Modern Food Option: Block"))
//                    .build()
//    ).register();

    public static void init() {}
}
