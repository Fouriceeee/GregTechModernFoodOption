package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class CapletRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("gelatin_solution"))
                .inputItems(GTMFOItems.GELATIN,8)
                .inputFluids(GTMaterials.Water,1000)
                .outputFluids(GTMFOFluids.GelatinSolution.getFluid(1000))
                .EUt(480).duration(200).save(provider);

        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES.recipeBuilder(id("caplet_body"))
                .inputFluids(GTMFOFluids.GelatinSolution,108)
                .notConsumable(GTItems.SHAPE_MOLD_BALL)
                .outputItems(GTMFOItems.CAPLET_BODY,16)
                .EUt(120).duration(100).save(provider);
        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES.recipeBuilder(id("caplet_cap"))
                .inputFluids(GTMFOFluids.GelatinSolution,72)
                .notConsumable(GTItems.SHAPE_MOLD_BOTTLE)
                .outputItems(GTMFOItems.CAPLET_CAP)
                .EUt(120).duration(100).save(provider);
        GTRecipeTypes.FORMING_PRESS_RECIPES.recipeBuilder(id("caplet_gel"))
                .inputItems(GTMFOItems.CAPLET_BODY)
                .inputItems(GTMFOItems.CAPLET_CAP)
                .circuitMeta(1)
                .outputItems(GTMFOItems.CAPLET_GEL)
                .EUt(30).duration(100).save(provider);

        //TODO: caplet recipes
    }
}
