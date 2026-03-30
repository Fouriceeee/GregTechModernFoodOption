package com.ironsword.gregtechmodernfoodoption.common.data.recipe;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOBlocks;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOFluids;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain.CoreChain;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain.KebabRecipes;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain.PizzaRecipes;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain.PotatoRecipes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption.id;

public class GTMFORecipes {

    public static void init(Consumer<FinishedRecipe> provider){
        CoreChain.init(provider);
        PotatoRecipes.init(provider);
        PizzaRecipes.init(provider);
        KebabRecipes.init(provider);

        cheeseRecipes(provider);
        doughRecipes(provider);

    }

    private static void cheeseRecipes(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("milk_hot"))
                .inputFluids(GTMaterials.Milk.getFluid(100))
                .outputFluids(GTMFOFluids.MilkHot.getFluid(100))
                .EUt(16).duration(20).save(provider);

        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES.recipeBuilder(id("mozzarella_ball"))
                .notConsumable(GTItems.SHAPE_MOLD_BALL.asStack())
                .inputFluids(GTMFOFluids.MilkHot.getFluid(1000))
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
