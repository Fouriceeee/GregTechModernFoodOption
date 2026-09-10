package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class FruitRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        ExtractRecipes(provider);
    }

    private static void ExtractRecipes(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("lemon_extract"))
                .inputItems(GTMFOItems.LEMON.asStack())
                .outputFluids(GTMFOFluids.LemonExtract.getFluid(100))
                .EUt(5).duration(100).save(provider);
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("lime_extract"))
                .inputItems(GTMFOItems.LIME.asStack())
                .outputFluids(GTMFOFluids.LimeExtract.getFluid(100))
                .EUt(5).duration(100).save(provider);
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("orange_extract"))
                .inputItems(GTMFOItems.ORANGE.asStack())
                .outputFluids(GTMFOFluids.OrangeExtract.getFluid(100))
                .EUt(5).duration(100).save(provider);
    }
}
