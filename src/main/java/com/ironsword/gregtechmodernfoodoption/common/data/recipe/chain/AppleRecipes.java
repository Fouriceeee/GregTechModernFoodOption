package com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOFluids;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;
import static com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption.id;

public class AppleRecipes {

    public static void init(Consumer<FinishedRecipe> provider){
        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("apple_cored"))
                .inputItems(Items.APPLE.getDefaultInstance())
                .notConsumable(GTMFOItems.SLICER_BLADE_PITTER.asStack())
                .outputItems(GTMFOItems.APPLE_CORED.asStack())
                .EUt(60).duration(200).save(provider);
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("apple_extract"))
                .inputItems(GTMFOItems.APPLE_CORED.asStack())
                .outputFluids(GTMFOFluids.AppleExtract.getFluid(500))
                .EUt(30).duration(30).save(provider);
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("apple_candy_syrup"))
                .inputFluids(
                        GTMFOFluids.AppleExtract.getFluid(1000),
                        GTMFOFluids.CaneSyrup.getFluid(1000))
                .inputItems(Tags.Items.DYES_LIME,5)
                .outputFluids(GTMFOFluids.AppleCandySyrup.getFluid(2000))
                .EUt(120).duration(60).save(provider);
        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES.recipeBuilder(id("apple_candy_resin"))
                .inputFluids(GTMFOFluids.AppleCandySyrup.getFluid(1000))
                .notConsumable(GTItems.SHAPE_MOLD_BLOCK.asStack())
                .outputItems(GTMFOItems.APPLE_CANDY_RESIN.asStack())
                .EUt(120).duration(60).save(provider);
        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("apple_candy_plate"))
                .inputItems(GTMFOItems.APPLE_CANDY_RESIN.asStack())
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT.asStack())
                .outputItems(GTMFOItems.APPLE_CANDY_PLATE.asStack(9))
                .EUt(120).duration(60).save(provider);
        GTRecipeTypes.BENDER_RECIPES.recipeBuilder(id("apple_candy_hot"))
                .inputItems(GTMFOItems.APPLE_CANDY_PLATE.asStack())
                .circuitMeta(1)
                .outputItems(GTMFOItems.APPLE_CANDY_HOT.asStack())
                .EUt(24).duration(64).save(provider);
        GTRecipeTypes.VACUUM_RECIPES.recipeBuilder(id("apple_candy"))
                .inputItems(GTMFOItems.APPLE_CANDY_HOT.asStack())
                .outputItems(GTMFOItems.APPLE_CANDY.asStack())
                .EUt(5).duration(200).save(provider);

        GTRecipeTypes.FORGE_HAMMER_RECIPES.recipeBuilder(id("apple_candy_crushed_1"))
                .inputItems(GTMFOItems.APPLE_CANDY.asStack())
                .outputItems(GTMFOItems.APPLE_CANDY_CRUSHED.asStack())
                .EUt(30).duration(20).save(provider);
        GTRecipeTypes.MACERATOR_RECIPES.recipeBuilder(id("apple_candy_crushed_2"))
                .inputItems(GTMFOItems.APPLE_CANDY.asStack())
                .outputItems(GTMFOItems.APPLE_CANDY_CRUSHED.asStack(2))
                .EUt(480).duration(200).save(provider);

    }
}
