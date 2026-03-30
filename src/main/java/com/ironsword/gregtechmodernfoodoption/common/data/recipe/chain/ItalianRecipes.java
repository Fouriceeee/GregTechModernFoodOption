package com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOFluids;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption.id;

public class ItalianRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        pastaRecipes(provider);
        italianRecipes(provider);
    }

    private static void pastaRecipes(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(id("pasta_dough_premixed"))
                .inputItems(TagPrefix.dust,GTMaterials.Wheat)
                .inputFluids(GTMaterials.Water.getFluid(16))
                .circuitMeta(4)
                .outputItems(GTMFOItems.PASTA_DOUGH_PREMIXED.asStack())
                .EUt(120).duration(30).save(provider);
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("pasta_dough_egg"))
                .inputItems(GTMFOItems.PASTA_DOUGH_PREMIXED.asStack())
                .inputFluids(GTMFOFluids.Egg.getFluid(400))
                .inputFluids(GTMaterials.Air.getFluid(600))
                .circuitMeta(1)
                .outputItems(GTMFOItems.PASTA_DOUGH_EGG.asStack(2))
                .EUt(120).duration(600).save(provider);
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("pasta_dough"))
                .inputItems(GTMFOItems.PASTA_DOUGH_PREMIXED.asStack())
                .inputFluids(GTMaterials.Air.getFluid(600))
                .circuitMeta(2)
                .outputItems(GTMFOItems.PASTA_DOUGH.asStack())
                .EUt(30).duration(600).save(provider);

        //GTFO easy recipe WIP

        GTRecipeTypes.BENDER_RECIPES.recipeBuilder(id("shape_pasta_blank"))
                .inputItems(TagPrefix.plate,GTMaterials.Bronze,4)
                .circuitMeta(4)
                .outputItems(GTMFOItems.SHAPE_PASTA_BLANK.asStack())
                .EUt(24).duration(200).save(provider);

        VanillaRecipeHelper.addShapedRecipe(provider,id("shape_pasta_tagliatelle"),
                GTMFOItems.SHAPE_PASTA_TAGLIATELLE.asStack(),
                "f  ",
                " S ",
                "   ",
                'S', GTMFOItems.SHAPE_PASTA_BLANK.asStack());
        VanillaRecipeHelper.addShapedRecipe(provider,id("shape_pasta_spaghetti"),
                GTMFOItems.SHAPE_PASTA_SPAGHETTI.asStack(),
                " f ",
                " S ",
                "   ",
                'S', GTMFOItems.SHAPE_PASTA_BLANK.asStack());
        VanillaRecipeHelper.addShapedRecipe(provider,id("shape_pasta_lasagna"),
                GTMFOItems.SHAPE_PASTA_LASAGNA.asStack(),
                "  f",
                " S ",
                "   ",
                'S', GTMFOItems.SHAPE_PASTA_BLANK.asStack());
        VanillaRecipeHelper.addShapedRecipe(provider,id("shape_pasta_rigatoni"),
                GTMFOItems.SHAPE_PASTA_RIGATONI.asStack(),
                "   ",
                "fS ",
                "   ",
                'S', GTMFOItems.SHAPE_PASTA_BLANK.asStack());
        VanillaRecipeHelper.addShapedRecipe(provider,id("shape_pasta_ditalini"),
                GTMFOItems.SHAPE_PASTA_DITALINI.asStack(),
                "   ",
                " Sf",
                "   ",
                'S', GTMFOItems.SHAPE_PASTA_BLANK.asStack());

        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder(id("tagliatelle_raw"))
                .inputItems(GTMFOItems.PASTA_DOUGH_EGG.asStack())
                .notConsumable(GTMFOItems.SHAPE_PASTA_TAGLIATELLE.asStack())
                .outputItems(GTMFOItems.TAGLIATELLE_RAW.asStack())
                .EUt(16).duration(300).save(provider);
        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder(id("spaghetti_raw"))
                .inputItems(GTMFOItems.PASTA_DOUGH.asStack())
                .notConsumable(GTMFOItems.SHAPE_PASTA_SPAGHETTI.asStack())
                .outputItems(GTMFOItems.SPAGHETTI_RAW.asStack())
                .EUt(16).duration(300).save(provider);
        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder(id("lasagna_raw"))
                .inputItems(GTMFOItems.PASTA_DOUGH.asStack())
                .notConsumable(GTMFOItems.SHAPE_PASTA_LASAGNA.asStack())
                .outputItems(GTMFOItems.LASAGNA_RAW.asStack())
                .EUt(16).duration(300).save(provider);
        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder(id("rigatoni_raw"))
                .inputItems(GTMFOItems.PASTA_DOUGH.asStack())
                .notConsumable(GTMFOItems.SHAPE_PASTA_RIGATONI.asStack())
                .outputItems(GTMFOItems.RIGATONI_RAW.asStack())
                .EUt(16).duration(300).save(provider);
        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder(id("ditalini_raw"))
                .inputItems(GTMFOItems.PASTA_DOUGH.asStack())
                .notConsumable(GTMFOItems.SHAPE_PASTA_DITALINI.asStack())
                .outputItems(GTMFOItems.DITALINI_RAW.asStack())
                .EUt(16).duration(300).save(provider);

        GTRecipeTypes.FURNACE_RECIPES.recipeBuilder(id("tagliatelle_dried"))
                .inputItems(GTMFOItems.TAGLIATELLE_RAW.asStack())
                .outputItems(GTMFOItems.TAGLIATELLE_DRIED.asStack())
                .EUt(16).duration(200).save(provider);
        GTRecipeTypes.FURNACE_RECIPES.recipeBuilder(id("spaghetti_dried"))
                .inputItems(GTMFOItems.SPAGHETTI_RAW.asStack())
                .outputItems(GTMFOItems.SPAGHETTI_DRIED.asStack())
                .EUt(16).duration(200).save(provider);
        GTRecipeTypes.FURNACE_RECIPES.recipeBuilder(id("lasagna_dried"))
                .inputItems(GTMFOItems.LASAGNA_RAW.asStack())
                .outputItems(GTMFOItems.LASAGNA_DRIED.asStack())
                .EUt(16).duration(200).save(provider);
        GTRecipeTypes.FURNACE_RECIPES.recipeBuilder(id("rigatoni_dried"))
                .inputItems(GTMFOItems.RIGATONI_RAW.asStack())
                .outputItems(GTMFOItems.RIGATONI_DRIED.asStack())
                .EUt(16).duration(200).save(provider);
        GTRecipeTypes.FURNACE_RECIPES.recipeBuilder(id("ditalini_dried"))
                .inputItems(GTMFOItems.DITALINI_RAW.asStack())
                .outputItems(GTMFOItems.DITALINI_DRIED.asStack())
                .EUt(16).duration(200).save(provider);

        GTRecipeTypes.CHEMICAL_BATH_RECIPES.recipeBuilder(id("tagliatelle"))
                .inputItems(GTMFOItems.TAGLIATELLE_DRIED.asStack())
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(GTMFOItems.TAGLIATELLE.asStack())
                .EUt(16).duration(600).save(provider);
        GTRecipeTypes.CHEMICAL_BATH_RECIPES.recipeBuilder(id("spaghetti"))
                .inputItems(GTMFOItems.SPAGHETTI_DRIED.asStack())
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(GTMFOItems.SPAGHETTI.asStack())
                .EUt(16).duration(600).save(provider);
        GTRecipeTypes.CHEMICAL_BATH_RECIPES.recipeBuilder(id("rigatoni"))
                .inputItems(GTMFOItems.RIGATONI_DRIED.asStack())
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(GTMFOItems.RIGATONI.asStack())
                .EUt(16).duration(600).save(provider);
        GTRecipeTypes.CHEMICAL_BATH_RECIPES.recipeBuilder(id("ditalini"))
                .inputItems(GTMFOItems.DITALINI_DRIED.asStack())
                .inputFluids(GTMaterials.Water.getFluid(1000))
                .outputItems(GTMFOItems.DITALINI.asStack())
                .EUt(16).duration(600).save(provider);

        //GTFO easy recipe WIP
    }

    private static void italianRecipes(Consumer<FinishedRecipe> provider){

    }
}
