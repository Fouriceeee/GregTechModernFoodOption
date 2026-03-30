package com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.gregtechceu.gtceu.data.recipe.builder.CampfireRecipeBuilder;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOFluids;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption.id;

public class PotatoRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
//        GTRecipeType dehydratorRecipes =  GTRecipeTypes.get("dehydrator");
//        if (dehydratorRecipes == null){
//            dehydratorRecipes = GTRecipeTypes.CHEMICAL_RECIPES;
//        }

        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("potato_peeled"))
                .inputItems(Items.POTATO)
                .inputFluids(GTMaterials.Water.getFluid(500))
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .outputItems(GTMFOItems.POTATO_PEELED)
                .EUt(8).duration(40).save(provider);
        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("potato_slice"))
                .inputItems(GTMFOItems.POTATO_PEELED)
                .inputFluids(GTMaterials.Water.getFluid(200))
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .outputItems(GTMFOItems.POTATO_SLICE.asStack(10))
                .EUt(20).duration(80).save(provider);
        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("potato_strip"))
                .inputItems(GTMFOItems.POTATO_SLICE)
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .outputItems(GTMFOItems.POTATO_STRIP.asStack(10))
                .EUt(20).duration(80).save(provider);
        GTRecipeTypes.FORGE_HAMMER_RECIPES.recipeBuilder(id("potato_mashed"))
                .inputItems(GTMFOItems.POTATO_PEELED.asStack())
                .outputItems(GTMFOItems.POTATO_MASHED.asStack())
                .EUt(60).duration(40).save(provider);


//        dehydratorRecipes.recipeBuilder(id("potato_slice_dried"))
//                .inputItems(GTMFOItems.POTATO_SLICE.asStack(40))
//                .inputFluids(GTMFOFluids.FRYING_OIL.getFluid(500))
//                .outputItems(GTMFOItems.POTATO_SLICE_FRIED.asStack(38))
//                .outputFluids(GTMFOFluids.FRYING_OIL.getFluid(450))
//                .EUt(30).duration(400).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("potato_slice_dried"))
                .inputItems(GTMFOItems.POTATO_SLICE.asStack(40))
                .inputFluids(GTMFOFluids.FryingOil.getFluid(500))
                .outputItems(GTMFOItems.POTATO_SLICE_FRIED.asStack(38))
                .outputFluids(GTMFOFluids.FryingOil.getFluid(450))
                .EUt(30).duration(400).save(provider);
        GTRecipeTypes.CHEMICAL_BATH_RECIPES.recipeBuilder(id("potato_slice_batched_fried"))
                .inputItems(GTMFOItems.POTATO_SLICE.asStack(40))
                .inputFluids(GTMFOFluids.FryingOil.getFluid(500))
                .outputItems(GTMFOItems.POTATO_SLICE_BATCH_FRIED.asStack(38))
                .EUt(30).duration(400).save(provider);
        GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(id("potato_slice_oily"))
                .inputItems(GTMFOItems.POTATO_SLICE_BATCH_FRIED.asStack(5))
                .outputItems(GTMFOItems.POTATO_SLICE_OILY.asStack(5))
                .outputFluids(GTMFOFluids.FryingOil.getFluid(20))
                .EUt(50).duration(200).save(provider);
        GTRecipeTypes.THERMAL_CENTRIFUGE_RECIPES.recipeBuilder(id("potato_slice_hot"))
                .inputItems(GTMFOItems.POTATO_SLICE_BATCH_FRIED.asStack(5))
                .outputItems(GTMFOItems.POTATO_SLICE_HOT.asStack(5))
                .EUt(160).duration(500).save(provider);
//        dehydratorRecipes.recipeBuilder(id("potato_slice_reduced_fat"))
//                .inputItems(GTMFOItems.POTATO_SLICE_HOT.asStack(10))
//                .outputItems(GTMFOItems.POTATO_SLICE_REDUCED_FAT.asStack(10))
//                .outputFluids(GTMFOFluids.FRYING_OIL.getFluid(60))
//                .EUt(30).duration(400).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("potato_slice_reduced_fat"))
                .inputItems(GTMFOItems.POTATO_SLICE_HOT.asStack(10))
                .outputItems(GTMFOItems.POTATO_SLICE_REDUCED_FAT.asStack(10))
                .outputFluids(GTMFOFluids.FryingOil.getFluid(60))
                .EUt(30).duration(400).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("potato_slice_naquadah"))
                .inputItems(GTMFOItems.POTATO_SLICE_HOT.asStack(40))
                .inputFluids(GTMaterials.Naquadah.getFluid(10))
                .outputItems(GTMFOItems.POTATO_SLICE_NAQUADAH.asStack(40))
                .EUt(GTValues.VA[GTValues.LuV]).duration(800).save(provider);


        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(id("chips_bag_empty"))
                .inputItems(TagPrefix.foil,GTMaterials.Aluminium)
                .inputFluids(GTMaterials.Polyethylene.getFluid(10))
                .outputItems(GTMFOItems.CHIPS_BAG_EMPTY.asStack())
                .EUt(20).duration(32).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("chips_syals"))
                .inputItems(
                        GTMFOItems.CHIPS_BAG_EMPTY.asStack(),
                        GTMFOItems.POTATO_SLICE_FRIED.asStack(20))
                .inputFluids(GTMaterials.Nitrogen.getFluid(500))
                .outputItems(GTMFOItems.CHIPS_SYALS.asStack())
                .EUt(16).duration(120).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("chips_bag"))
                .inputItems(
                        GTMFOItems.CHIPS_BAG_EMPTY.asStack(),
                        GTMFOItems.POTATO_SLICE_FRIED.asStack(40))
                .outputItems(GTMFOItems.CHIPS_BAG.asStack())
                .EUt(16).duration(100).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("chips_kettle"))
                .inputItems(
                        GTMFOItems.CHIPS_BAG_EMPTY.asStack(),
                        GTMFOItems.POTATO_SLICE_OILY.asStack(40))
                .outputItems(GTMFOItems.CHIPS_KETTLE.asStack())
                .EUt(16).duration(100).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("chips_reduced_fat"))
                .inputItems(
                        GTMFOItems.CHIPS_BAG_EMPTY.asStack(),
                        GTMFOItems.POTATO_SLICE_REDUCED_FAT.asStack(40))
                .outputItems(GTMFOItems.CHIPS_REDUCED_FAT.asStack())
                .EUt(16).duration(100).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("chips_naquadah"))
                .inputItems(
                        GTMFOItems.CHIPS_BAG_EMPTY.asStack(),
                        GTMFOItems.POTATO_SLICE_NAQUADAH.asStack(40))
                .outputItems(GTMFOItems.CHIPS_NAQUADAH.asStack())
                .EUt(64).duration(100).save(provider);


        GTRecipeTypes.CHEMICAL_BATH_RECIPES.recipeBuilder(id("potato_strip_blanched"))
                .inputItems(GTMFOItems.POTATO_STRIP.asStack(40))
                .inputFluids(GTMFOFluids.FryingOil.getFluid(700))
                .outputItems(GTMFOItems.POTATO_STRIP_BLANCHED.asStack(40))
                .EUt(60).duration(1000).save(provider);
        GTRecipeTypes.CHEMICAL_BATH_RECIPES.recipeBuilder(id("potato_strip_fried"))
                .inputItems(GTMFOItems.POTATO_STRIP_BLANCHED.asStack(40))
                .inputFluids(GTMFOFluids.FryingOilHot.getFluid(500))
                .outputItems(GTMFOItems.POTATO_STRIP_FRIED.asStack(40))
                .EUt(60).duration(1000).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("french_fries"))
                .inputItems(
                        GTMFOItems.PAPER_BAG.asStack(),
                        GTMFOItems.POTATO_STRIP_FRIED.asStack(64))
                .outputItems(GTMFOItems.FRENCH_FRIES.asStack())
                .EUt(10).duration(160).save(provider);
        GTRecipeTypes.CHEMICAL_BATH_RECIPES.recipeBuilder(id("paper_bag"))
                .inputItems(GTMFOItems.PAPER_BAG_USED.asStack())
                .inputFluids(GTMaterials.Water.getFluid(100))
                .outputItems(GTMFOItems.PAPER_BAG.asStack())
                .EUt(30).duration(180).save(provider);


        VanillaRecipeHelper.addShapelessRecipe(provider,id("potato_stick"),
                GTMFOItems.POTATO_STICK.asStack(),
                Items.POTATO.getDefaultInstance(),
                Items.STICK.getDefaultInstance());

        new CampfireRecipeBuilder(id("potato_stick_roasted"))
                .input(GTMFOItems.POTATO_STICK.asStack())
                .output(GTMFOItems.POTATO_STICK_ROASTED.asStack())
                .cookingTime(600)
                .experience(0.35f)
                .save(provider);

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(id("potato_stick_roasted"))
                .inputItems(
                        Items.STICK.getDefaultInstance(),
                        Items.BAKED_POTATO.getDefaultInstance())
                .outputItems(GTMFOItems.POTATO_STICK_ROASTED.asStack())
                .EUt(4).duration(5).save(provider);
    }
}
