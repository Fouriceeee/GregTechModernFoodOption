package com.ironsword.gregtechmodernfoodoption.common.data.machine;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.data.RotationState;
import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.machine.MultiblockMachineDefinition;
import com.gregtechceu.gtceu.api.machine.multiblock.PartAbility;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.FactoryBlockPattern;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.common.data.GTBlocks;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOBlocks;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipeTypes;

import static com.gregtechceu.gtceu.api.pattern.util.RelativeDirection.*;
import static com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries.REGISTRATE;

public class GTMFOMultiMachines {

    public static final MultiblockMachineDefinition ELECTRIC_BAKING_OVEN = REGISTRATE
            .multiblock("electric_baking_oven", WorkableElectricMultiblockMachine::new)
            .langValue("Electric Baking Oven")
            .rotationState(RotationState.ALL)
            .recipeType(GTMFORecipeTypes.BAKING_OVEN_RECIPES)
            .appearanceBlock(GTMFOBlocks.BISMUTH_BRONZE_CASING)
            .pattern(definition-> FactoryBlockPattern.start(BACK, UP, RIGHT)
                    .aisle("XXXX", "YXXX", "XXXX", "####")
                    .aisle("XXXX", "GFFX", "GOOX", "XXXX").setRepeatable(2, 14)
                    .aisle("XXXX", "XXXX", "XXXX", "####")
                    .where('X', Predicates.blocks(GTMFOBlocks.BISMUTH_BRONZE_CASING.get()).setMinGlobalLimited(10).or(Predicates.autoAbilities(definition.getRecipeTypes())))
                    .where('F', Predicates.blocks(ChemicalHelper.getBlock(TagPrefix.frameGt,GTMaterials.Steel)))
                    .where('G', Predicates.blocks(GTBlocks.CASING_TEMPERED_GLASS.get()))
                    .where('#', Predicates.any())
                    .where('O', Predicates.air())
                    .where('Y', Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .build())
            .workableCasingModel(
                    GregTechModernFoodOption.id("block/bismuth_bronze_casing"),
                    GTCEu.id("block/machines/baking_oven"))
            .register();

    public static final MultiblockMachineDefinition STEAM_BAKING_OVEN = REGISTRATE
            .multiblock("steam_baking_oven", WorkableElectricMultiblockMachine::new)
            .langValue("Steam Baking Oven")
            .rotationState(RotationState.ALL)
            .recipeType(GTMFORecipeTypes.BAKING_OVEN_RECIPES)
            .appearanceBlock(GTBlocks.CASING_BRONZE_BRICKS)
            .pattern(definition->FactoryBlockPattern.start()
                    .aisle("XXXX", "XGGX", "XXXX")
                    .aisle("XXXX", "GFFG", "XFFX")
                    .aisle("XXXX", "GFFG", "XFFX")
                    .aisle("XXXX", "YGGX", "XXXX")
                    .where('X',Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get())
                            .or(Predicates.abilities(PartAbility.STEAM_IMPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM_EXPORT_ITEMS).setPreviewCount(1))
                            .or(Predicates.abilities(PartAbility.STEAM).setExactLimit(1)))
                    .where('F',Predicates.blocks(ChemicalHelper.getBlock(TagPrefix.frameGt,GTMaterials.Steel)))
                    .where('G',Predicates.blocks(GTBlocks.CASING_BRONZE_BRICKS.get(),GTBlocks.CASING_TEMPERED_GLASS.get()))
                    .where('Y',Predicates.controller(Predicates.blocks(definition.getBlock())))
                    .build())
            .workableCasingModel(
                    GTCEu.id("block/casings/solid/machine_casing_bronze_plated_bricks"),
                    GTCEu.id("block/machines/baking_oven"))
            .register();

    public static void init(){
        GTMFOMachines.addJEILang("baking_oven","Baking Oven","烤炉");
        GTMFOMachines.CNLangMap.put("block."+GregTechModernFoodOption.MODID+".electric_baking_oven","电力烤炉");
        GTMFOMachines.CNLangMap.put("block."+GregTechModernFoodOption.MODID+".steam_baking_oven","蒸汽烤炉");
    }
}
