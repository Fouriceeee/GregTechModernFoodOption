package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import com.ironsword.gtmfo.common.data.recipe.GTMFORecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class CoreChain {
    public static void init(Consumer<FinishedRecipe> provider){
        zestChain(provider);
        caneSyrupChain(provider);
        generalChemicals(provider);
        sliceBlades(provider);
        liquidFoodExtracts(provider);
        slicingRecipes(provider);
        drink(provider);
        misc(provider);
    }

    public static void zestChain(Consumer<FinishedRecipe> provider){
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("lemon")
//                .inputItems(GTMFOItems.LEMON.asStack())
//                .outputItems(TagPrefix.dust,GTMFOMaterials.ZEST)
//                .outputFluids(GTMFOFluids.LEMON_EXTRACT.getFluid(100))
//                .EUt(5)
//                .duration(100)
//                .save(provider);
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("lime")
//                .inputItems(GTMFOItems.LIME.asStack())
//                .outputItems(TagPrefix.dust,GTMFOMaterials.ZEST)
//                .outputFluids(GTMFOFluids.LIME_EXTRACT.getFluid(100))
//                .EUt(5)
//                .duration(100)
//                .save(provider);
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("orange")
//                .inputItems(GTMFOItems.ORANGE.asStack())
//                .outputItems(TagPrefix.dust,GTMFOMaterials.ZEST)
//                .outputFluids(GTMFOFluids.ORANGE_EXTRACT.getFluid(100))
//                .EUt(5)
//                .duration(100)
//                .save(provider);
//
//        VanillaRecipeHelper.addShapelessRecipe(
//                provider,
//                GregTechModernFoodOption.id("zest_from_lemon"),
//                ChemicalHelper.get(TagPrefix.dust,GTMFOMaterials.ZEST),
//                GTMFOItems.LEMON.asStack(),
//                GTMFOItems.LEMON.asStack(),
//                GTMFOItems.LEMON.asStack(),
//                GTMFOItems.LEMON.asStack());
//        VanillaRecipeHelper.addShapelessRecipe(
//                provider,
//                GregTechModernFoodOption.id("zest_from_lime"),
//                ChemicalHelper.get(TagPrefix.dust,GTMFOMaterials.ZEST),
//                GTMFOItems.LIME.asStack(),
//                GTMFOItems.LIME.asStack(),
//                GTMFOItems.LIME.asStack(),
//                GTMFOItems.LIME.asStack());
//        VanillaRecipeHelper.addShapelessRecipe(
//                provider,
//                GregTechModernFoodOption.id("zest_from_orange"),
//                ChemicalHelper.get(TagPrefix.dust,GTMFOMaterials.ZEST),
//                GTMFOItems.ORANGE.asStack(),
//                GTMFOItems.ORANGE.asStack(),
//                GTMFOItems.ORANGE.asStack(),
//                GTMFOItems.ORANGE.asStack());
    }

    public static void caneSyrupChain(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("cane_syrup_unheated")
                .inputItems(Items.SUGAR,24)
                .inputFluids(GTMaterials.Water.getFluid(2000))
                .circuitMeta(2)
                .outputFluids(GTMFOFluids.CaneSyrupUnheated.getFluid(2000))
                .EUt(80)
                .duration(260)
                .save(provider);

        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder("cane_syrup")
                .inputFluids(GTMFOFluids.CaneSyrupUnheated.getFluid(1000))
                .circuitMeta(2)
                .outputFluids(GTMFOFluids.CaneSyrup.getFluid(1000))
                .EUt(120)
                .duration(80)
                .save(provider);
    }

    public static void generalChemicals(Consumer<FinishedRecipe> provider){
//        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("isopropyl_chloride")
//                .inputFluids(
//                        GTMaterials.HydrochloricAcid.getFluid(1000),
//                        GTMaterials.Propene.getFluid(1000))
//                .outputFluids(GTMFOFluids.ISOPROPYL_CHLORIDE.getFluid(1000))
//                .EUt(30)
//                .duration(200)
//                .save(provider);
//
//        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("chloroauric_acid")
//                .inputItems(ChemicalHelper.get(TagPrefix.dust,GTMaterials.Gold,2))
//                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(8000))
//                .outputFluids(GTMFOFluids.CHLOROAURIC_ACID.getFluid(2000),GTMaterials.Hydrogen.getFluid(3000))
//                .EUt(480)
//                .duration(300)
//                .save(provider);
    }

    public static void sliceBlades(Consumer<FinishedRecipe> provider){
        VanillaRecipeHelper.addShapedRecipe(provider, id("slicer_flat"),
                GTMFOItems.SLICER_BLADE_FLAT.asStack(),
                "hPS", " M ", "fPs",
                'P', ChemicalHelper.get(TagPrefix.plate,GTMaterials.Iron),
                'S', ChemicalHelper.get(TagPrefix.screw,GTMaterials.Iron),
                'M', GTItems.SHAPE_EXTRUDER_BLOCK);
        VanillaRecipeHelper.addShapedRecipe(provider,id("slicer_stripes"),
                GTMFOItems.SLICER_BLADE_STRIPES.asStack(),
                "hPS", "PMP", "fPs",
                'P', ChemicalHelper.get(TagPrefix.plate,GTMaterials.Iron),
                'S', ChemicalHelper.get(TagPrefix.screw,GTMaterials.Iron),
                'M', GTItems.SHAPE_EXTRUDER_BLOCK);
        VanillaRecipeHelper.addShapedRecipe(provider,id("slicer_octagonal"),
                GTMFOItems.SLICER_BLADE_OCTAGONAL.asStack(),
                "PhP", "fMS", "PsP",
                'P', ChemicalHelper.get(TagPrefix.plate,GTMaterials.Iron),
                'S', ChemicalHelper.get(TagPrefix.screw,GTMaterials.Iron),
                'M', GTItems.SHAPE_EXTRUDER_BLOCK);
    }

    public static void liquidFoodExtracts(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("frying_oil"))
                .inputFluids(GTMaterials.SeedOil.getFluid(16))
                .outputFluids(GTMFOFluids.FryingOil.getFluid(16))
                .circuitMeta(1)
                .EUt(12).duration(10).save(provider);
        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("frying_oil_hot_2"))
                .inputFluids(GTMaterials.SeedOil.getFluid(16))
                .outputFluids(GTMFOFluids.FryingOilHot.getFluid(16))
                .circuitMeta(2)
                .EUt(60).duration(25).save(provider);
        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("frying_oil_hot_1"))
                .inputFluids(GTMFOFluids.FryingOil.getFluid(16))
                .outputFluids(GTMFOFluids.FryingOilHot.getFluid(16))
                .circuitMeta(1)
                .EUt(18).duration(15).save(provider);

        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("tomato_sauce"))
                .inputItems(GTMFOItems.TOMATO_SLICE.asStack())
                .outputFluids(GTMFOFluids.TomatoSauce.getFluid(100))
                .EUt(2).duration(10).save(provider);
//
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("olive_oil")
//                .inputItems(GTMFOItems.OLIVE.asStack())
//                .outputFluids(GTMFOFluids.OLIVE_OIL.getFluid(100))
//                .EUt(27).duration(60).save(provider);
//
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("melon_extract")
//                .inputItems(Items.MELON_SLICE.getDefaultInstance())
//                .outputFluids(GTMFOFluids.MELON_EXTRACT.getFluid(100))
//                .EUt(2).duration(10).save(provider);
//
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("cranberry_extract")
//                .inputItems(GTMFOItems.CRANBERRY.asStack())
//                .outputFluids(GTMFOFluids.CRANBERRY_EXTRACT.getFluid(25))
//                .circuitMeta(1)
//                .EUt(2).duration(10).save(provider);
//
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("grape_extract")
//                .inputItems(GTMFOItems.GRAPES.asStack())
//                .outputFluids(GTMFOFluids.GRAPE_EXTRACT.getFluid(25))
//                .circuitMeta(1)
//                .EUt(2).duration(10).save(provider);
//
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("grape_extract_2")
//                .inputItems(GTMFOItems.WHITE_GRAPES.asStack())
//                .outputFluids(GTMFOFluids.GRAPE_EXTRACT.getFluid(25))
//                .circuitMeta(1)
//                .EUt(2).duration(10).save(provider);
//
//        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("apricot_extract")
//                .inputItems(GTMFOItems.APRICOT.asStack())
//                .outputFluids(GTMFOFluids.APRICOT_EXTRACT.getFluid(100))
//                .circuitMeta(1)
//                .EUt(8).duration(40).save(provider);
//

//
//        GTRecipeTypes.CANNER_RECIPES.recipeBuilder("orange_extract")
//                .inputItems(GTMFOItems.JUICE_ORANGE.asStack())
//                .outputItems(Items.GLASS_BOTTLE)
//                .outputFluids(GTMFOFluids.ORANGE_EXTRACT.getFluid(100))
//                .EUt(12).duration(30).save(provider);
//
//        GTRecipeTypes.CANNER_RECIPES.recipeBuilder("orange_juice")
//                .inputItems(Items.GLASS_BOTTLE)
//                .inputFluids(GTMFOFluids.ORANGE_EXTRACT.getFluid(100))
//                .outputItems(GTMFOItems.JUICE_ORANGE.asStack())
//                .EUt(12).duration(30).save(provider);

        //this is a temporary recipe
//        GTRecipeTypes.DISTILLATION_RECIPES.recipeBuilder("apple_extract")
//                .inputFluids(GTMFOFluids.APPLE_EXTRACT.getFluid(1000))
//                .outputFluids(GTMaterials.Biomass.getFluid(200))
//                .outputFluids(GTMaterials.AceticAcid.getFluid(10))
//                .outputFluids(GTMaterials.Water.getFluid(1000))
//                .outputFluids(GTMaterials.HydrogenCyanide.getFluid(10))
//                .outputItems(TagPrefix.dust,GTMaterials.Sugar)
//                .save(provider);
//
//        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("sodium_cyanide")
//                .inputFluids(GTMaterials.HydrogenCyanide.getFluid(1000))
//                .inputItems(TagPrefix.dust,GTMaterials.SodiumHydroxide,3)
//                .outputItems(TagPrefix.dust,GTMFOMaterials.SodiumCyanide,3)
//                .outputFluids(GTMaterials.Water.getFluid(1000))
//                .EUt(30).duration(80).save(provider);
    }

    private static void slicingRecipes(Consumer<FinishedRecipe> provider){


        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("olive_slice"))
                .inputItems(GTMFOItems.OLIVE)
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .outputItems(GTMFOItems.OLIVE_SLICE,8)
                .EUt(18).duration(30).save(provider);

        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("mushroom_slice"))
                .inputItems(Items.BROWN_MUSHROOM)
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .outputItems(GTMFOItems.MUSHROOM_SLICE,8)
                .EUt(18).duration(30).save(provider);

        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("tomato_slice"))
                .inputItems(GTMFOItems.TOMATO)
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .outputItems(GTMFOItems.TOMATO_SLICE,8)
                .EUt(18).duration(30).save(provider);
    }

    private static void drink(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("carbonated_water"))
                .inputFluids(
                        GTMaterials.Water.getFluid(1000),
                        GTMaterials.CarbonDioxide.getFluid(100))
                .outputFluids(GTMFOFluids.CarbonatedWater.getFluid(1050))
                .EUt(120).duration(60).save(provider);
    }

    private static void misc(Consumer<FinishedRecipe> provider) {
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("egg"))
                .inputItems(Items.EGG.getDefaultInstance())
                .outputFluids(GTMFOFluids.Egg.getFluid(200))
                .EUt(24).duration(60).save(provider);

        GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(id("egg_separation"))
                .inputFluids(GTMFOFluids.Egg.getFluid(200))
                .outputFluids(GTMFOFluids.Albumen.getFluid(100))
                .outputFluids(GTMFOFluids.Yolk.getFluid(100))
                .EUt(16).duration(60).save(provider);

        GTRecipeTypes.FERMENTING_RECIPES.recipeBuilder(id("butter"))
                .inputFluids(GTMaterials.Milk.getFluid(10000))
                .outputFluids(GTMFOFluids.Butter.getFluid(9000))
                .EUt(15).duration(1200).save(provider);
    }














}
