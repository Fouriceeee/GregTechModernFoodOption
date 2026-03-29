package com.ironsword.gregtechmodernfoodoption.common.data.recipe;

import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOBlocks;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOFluids;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain.CoreChain;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class GTMFORecipes {

    public static void init(Consumer<FinishedRecipe> provider){
        CoreChain.init(provider);
        cheeseRecipes(provider);
        doughRecipes(provider);
        pizzaRecipes(provider);
    }

    private static void cheeseRecipes(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder("mozzarella_slice")
                .inputItems(GTMFOItems.MOZZARELLA_BALL.asStack())
                .notConsumable(GTItems.SHAPE_EXTRUDER_PLATE.asStack())
                .outputItems(GTMFOItems.MOZZARELLA_SLICE,9)
                .EUt(16).duration(400).save(provider);
    }

    private static void doughRecipes(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.FORGE_HAMMER_RECIPES.recipeBuilder("dough_flat")
                .inputItems(GTItems.DOUGH.asStack())
                .outputItems(GTMFOItems.DOUGH_FLAT)
                .EUt(60).duration(40)
                .save(provider);
    }

    private static void pizzaRecipes(Consumer<FinishedRecipe> provider){
        VanillaRecipeHelper.addShapedRecipe(provider,"pizza_cheese",
                GTMFOBlocks.PIZZA_CHEESE.asStack(),
                "SS","SS",
                'S', GTMFOItems.PIZZA_CHEESE_SLICE.asStack());

        VanillaRecipeHelper.addShapedRecipe(provider,"pizza_meat",
                GTMFOBlocks.PIZZA_MEAT.asStack(),
                "SS","SS",
                'S', GTMFOItems.PIZZA_MEAT_SLICE.asStack());

        VanillaRecipeHelper.addShapedRecipe(provider,"pizza_veggie",
                GTMFOBlocks.PIZZA_VEGGIE.asStack(),
                "SS","SS",
                'S', GTMFOItems.PIZZA_VEGGIE_SLICE.asStack());

        VanillaRecipeHelper.addShapelessRecipe(provider,"pizza_cheese_slice",
                GTMFOItems.PIZZA_CHEESE_SLICE.asStack(4),
                GTMFOBlocks.PIZZA_CHEESE.asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider,"pizza_meat_slice",
                GTMFOItems.PIZZA_MEAT_SLICE.asStack(4),
                GTMFOBlocks.PIZZA_MEAT.asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider,"pizza_veggie_slice",
                GTMFOItems.PIZZA_VEGGIE_SLICE.asStack(4),
                GTMFOBlocks.PIZZA_VEGGIE.asStack());

        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder("pizza_cheese")
                .inputItems(
                        GTMFOItems.DOUGH_FLAT.asStack(),
                        GTMFOItems.MOZZARELLA_SLICE.asStack(8))
                .circuitMeta(1)
                .inputFluids(GTMFOFluids.TOMATO_SAUCE.getFluid(600))
                .outputItems(GTMFOItems.PIZZA_CHEESE_RAW.asStack())
                .EUt(30).duration(400).save(provider);

        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder("pizza_meat")
                .inputItems(
                        GTMFOItems.DOUGH_FLAT.asStack(),
                        GTMFOItems.MOZZARELLA_SLICE.asStack(4),
                        GTMFOItems.MINCE_MEAT_COOKED.asStack(10))
                .circuitMeta(3)
                .inputFluids(GTMFOFluids.TOMATO_SAUCE.getFluid(450))
                .outputItems(GTMFOItems.PIZZA_MEAT_RAW.asStack())
                .EUt(30).duration(400).save(provider);

        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder("pizza_veggie")
                .inputItems(
                        GTMFOItems.DOUGH_FLAT.asStack(),
                        GTMFOItems.MOZZARELLA_SLICE.asStack(3),
                        GTMFOItems.MUSHROOM_SLICE.asStack(8),
                        GTMFOItems.OLIVE_SLICE.asStack(8))
                .circuitMeta(2)
                .inputFluids(GTMFOFluids.TOMATO_SAUCE.getFluid(300))
                .outputItems(GTMFOItems.PIZZA_VEGGIE_RAW.asStack())
                .EUt(30).duration(400).save(provider);

        GTMFORecipeTypes.BAKING_OVEN_RECIPES.recipeBuilder("pizza_cheese")
                .inputItems(GTMFOItems.PIZZA_CHEESE_RAW.asStack())
                .outputItems(GTMFOBlocks.PIZZA_CHEESE.asStack())
                .EUt(60).duration(1400).save(provider);

        GTMFORecipeTypes.BAKING_OVEN_RECIPES.recipeBuilder("pizza_meat")
                .inputItems(GTMFOItems.PIZZA_MEAT_RAW.asStack())
                .outputItems(GTMFOBlocks.PIZZA_MEAT.asStack())
                .EUt(60).duration(1600).save(provider);

        GTMFORecipeTypes.BAKING_OVEN_RECIPES.recipeBuilder("pizza_veggie")
                .inputItems(GTMFOItems.PIZZA_VEGGIE_RAW.asStack())
                .outputItems(GTMFOBlocks.PIZZA_VEGGIE.asStack())
                .EUt(60).duration(1200).save(provider);
    }
}
