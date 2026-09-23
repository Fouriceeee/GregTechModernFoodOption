package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidStack;

import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import com.ironsword.gtmfo.common.data.recipe.GTMFORecipeTypes;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class FruitRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        extractRecipes(provider);
        chorusRecipes(provider);
    }

    private static void extractRecipes(Consumer<FinishedRecipe> provider) {
        extract(provider, "lemon_extract", GTMFOItems.LEMON, GTMFOFluids.LemonExtract);
        extract(provider, "lime_extract", GTMFOItems.LIME, GTMFOFluids.LimeExtract);
        extract(provider, "orange_extract", GTMFOItems.ORANGE, GTMFOFluids.OrangeExtract);
        extract(provider, "cranberry_extract", GTMFOItems.CRANBERRY, GTMFOFluids.CranberryExtract);
        extract(provider, "melon_extract", Items.MELON_SLICE, GTMFOFluids.MelonExtract);

        extract(provider, "grape_extract", GTMFOItems.GRAPES, GTMFOFluids.GrapeExtract);
        extract(provider, "grape_extract_from_white_grape", GTMFOItems.WHITE_GRAPES, GTMFOFluids.GrapeExtract);
        extract(provider, "apricot_extract", GTMFOItems.APRICOT, GTMFOFluids.ApricotExtract);

        extract(provider, "chorus_extract", Items.CHORUS_FRUIT.getDefaultInstance(),
                GTMFOFluids.ChorusExtract.getFluid(50), 16, 200);
        extract(provider, "chorus_extract_from_popped_chorus", Items.POPPED_CHORUS_FRUIT.getDefaultInstance(),
                GTMFOFluids.ChorusExtract.getFluid(100), 16, 100);
    }

    private static void extract(Consumer<FinishedRecipe> provider, String id, ItemLike input, Material output) {
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id(id))
                .inputItems(input)
                .outputFluids(output.getFluid(100))
                .EUt(5).duration(100).save(provider);
    }

    private static void extract(Consumer<FinishedRecipe> provider, String id, ItemStack input, FluidStack output,
                                long eut, int duration) {
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id(id))
                .inputItems(input)
                .outputFluids(output)
                .EUt(eut).duration(duration).save(provider);
    }

    private static void chorusRecipes(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("ender_pearl_solution"))
                .inputItems(TagPrefix.dust, GTMaterials.EnderPearl)
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputFluids(GTMFOFluids.EnderPearlSolution.getFluid(1000))
                .EUt(7).duration(200).save(provider);
        GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(id("ender_sugar_solution"))
                .inputFluids(GTMFOFluids.EnderPearlSolution.getFluid(1000))
                .outputFluids(GTMFOFluids.EnderSugarSolution.getFluid(1000))
                .chancedOutput(TagPrefix.dust, GTMaterials.Potassium, 3, 3000, 1000)
                .chancedOutput(GTMaterials.Nitrogen.getFluid(3000), 1000, 1500)
                .EUt(30).duration(500).save(provider);
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("vibrant_extract"))
                .inputFluids(
                        GTMFOFluids.EnderSugarSolution.getFluid(1000),
                        GTMFOFluids.ChorusExtractFermented.getFluid(25))
                .outputFluids(GTMFOFluids.VibrantExtract.getFluid(1000))
                .EUt(480).duration(400).save(provider);

        GTRecipeTypes.FERMENTING_RECIPES.recipeBuilder(id("fermented_chorus_from_chorus_fruit"))
                .notConsumableFluid(GTMFOFluids.LacticAcidBacteria.getFluid(1))
                .inputItems(Items.CHORUS_FRUIT)
                .outputItems(GTMFOItems.FERMENTED_CHORUS)
                .EUt(2).duration(1000).save(provider);
        GTRecipeTypes.FERMENTING_RECIPES.recipeBuilder(id("fermented_chorus_from_popped_chorus_fruit"))
                .notConsumableFluid(GTMFOFluids.LacticAcidBacteria.getFluid(1))
                .inputItems(Items.POPPED_CHORUS_FRUIT)
                .outputItems(GTMFOItems.FERMENTED_CHORUS)
                .EUt(2).duration(800).save(provider);

        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("fermented_chorus_extract"))
                .inputItems(GTMFOItems.FERMENTED_CHORUS)
                .outputFluids(GTMFOFluids.ChorusExtractFermented.getFluid(50))
                .EUt(16).duration(200).save(provider);

        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("fermented_chorus_pie"))
                .inputItems(GTMFOItems.PIE_CRUST)
                .inputFluids(GTMFOFluids.ChorusExtractFermented.getFluid(25))
                .outputItems(GTMFOItems.FERMENTED_CHORUS_PIE)
                .EUt(16).duration(300).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("antaf"))
                .inputItems(Items.SUGAR, 9)
                .inputFluids(
                        GTMFOFluids.ChorusExtractFermented.getFluid(50),
                        GTMFOFluids.CarbonatedWater.getFluid(1000))
                .outputFluids(GTMFOFluids.Antaf.getFluid(2000))
                .EUt(60).duration(20).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("antaf_canned"))
                .inputItems(GTMFOItems.CAN)
                .inputFluids(GTMFOFluids.Antaf.getFluid(500))
                .outputItems(GTMFOItems.ANTAF)
                .EUt(30).duration(20).save(provider);
    }
}
