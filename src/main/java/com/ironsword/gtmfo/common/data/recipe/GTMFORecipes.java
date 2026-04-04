package com.ironsword.gtmfo.common.data.recipe;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import com.ironsword.gtmfo.common.data.recipe.chain.*;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class GTMFORecipes {

    public static void init(Consumer<FinishedRecipe> provider){
        AppleRecipes.init(provider);
        BerryRecipes.init(provider);
        CoreChain.init(provider);
        PotatoRecipes.init(provider);
        PizzaRecipes.init(provider);
        KebabRecipes.init(provider);
        ItalianRecipes.init(provider);
        SmoreRecipes.init(provider);


        cheeseRecipes(provider);
        doughRecipes(provider);

        GTMFOMachineRecipes.init(provider);

    }

    private static void cheeseRecipes(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("milk_hot"))
                .inputFluids(GTMaterials.Milk.getFluid(100))
                .outputFluids(GTMFOFluids.HotMilk.getFluid(100))
                .EUt(16).duration(20).save(provider);

        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES.recipeBuilder(id("mozzarella_ball"))
                .notConsumable(GTItems.SHAPE_MOLD_BALL.asStack())
                .inputFluids(GTMFOFluids.HotMilk.getFluid(1000))
                .outputItems(GTMFOItems.MOZZARELLA_BALL)
                .EUt(20).duration(200).save(provider);

        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder(id("mozzarella_slice"))
                .inputItems(GTMFOItems.MOZZARELLA_BALL.asStack())
                .notConsumable(GTItems.SHAPE_EXTRUDER_PLATE.asStack())
                .outputItems(GTMFOItems.MOZZARELLA_SLICE,9)
                .EUt(16).duration(400).save(provider);
    }

    private static void doughRecipes(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.FORGE_HAMMER_RECIPES.recipeBuilder(id("dough_flat"))
                .inputItems(GTItems.DOUGH.asStack())
                .outputItems(GTMFOItems.DOUGH_FLAT)
                .EUt(60).duration(40)
                .save(provider);
    }

}
