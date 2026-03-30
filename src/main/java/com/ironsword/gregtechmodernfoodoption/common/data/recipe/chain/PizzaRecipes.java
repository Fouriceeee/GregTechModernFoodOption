package com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain;

import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOBlocks;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOFluids;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption.id;

public class PizzaRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        VanillaRecipeHelper.addShapedRecipe(provider,id("pizza_cheese"),
                GTMFOBlocks.PIZZA_CHEESE.asStack(),
                "SS","SS",
                'S', GTMFOItems.PIZZA_CHEESE_SLICE.asStack());

        VanillaRecipeHelper.addShapedRecipe(provider,id("pizza_meat"),
                GTMFOBlocks.PIZZA_MEAT.asStack(),
                "SS","SS",
                'S', GTMFOItems.PIZZA_MEAT_SLICE.asStack());

        VanillaRecipeHelper.addShapedRecipe(provider,id("pizza_veggie"),
                GTMFOBlocks.PIZZA_VEGGIE.asStack(),
                "SS","SS",
                'S', GTMFOItems.PIZZA_VEGGIE_SLICE.asStack());

        VanillaRecipeHelper.addShapelessRecipe(provider,id("pizza_cheese_slice"),
                GTMFOItems.PIZZA_CHEESE_SLICE.asStack(4),
                GTMFOBlocks.PIZZA_CHEESE.asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider,id("pizza_meat_slice"),
                GTMFOItems.PIZZA_MEAT_SLICE.asStack(4),
                GTMFOBlocks.PIZZA_MEAT.asStack());
        VanillaRecipeHelper.addShapelessRecipe(provider,id("pizza_veggie_slice"),
                GTMFOItems.PIZZA_VEGGIE_SLICE.asStack(4),
                GTMFOBlocks.PIZZA_VEGGIE.asStack());

        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("pizza_cheese"))
                .inputItems(
                        GTMFOItems.DOUGH_FLAT.asStack(),
                        GTMFOItems.MOZZARELLA_SLICE.asStack(8))
                .circuitMeta(1)
                .inputFluids(GTMFOFluids.TomatoSauce.getFluid(600))
                .outputItems(GTMFOItems.PIZZA_CHEESE_RAW.asStack())
                .EUt(30).duration(400).save(provider);

        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("pizza_meat"))
                .inputItems(
                        GTMFOItems.DOUGH_FLAT.asStack(),
                        GTMFOItems.MOZZARELLA_SLICE.asStack(4),
                        GTMFOItems.MINCE_MEAT.asStack(10))
                .circuitMeta(3)
                .inputFluids(GTMFOFluids.TomatoSauce.getFluid(450))
                .outputItems(GTMFOItems.PIZZA_MEAT_RAW.asStack())
                .EUt(30).duration(400).save(provider);

        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("pizza_veggie"))
                .inputItems(
                        GTMFOItems.DOUGH_FLAT.asStack(),
                        GTMFOItems.MOZZARELLA_SLICE.asStack(3),
                        GTMFOItems.MUSHROOM_SLICE.asStack(8),
                        GTMFOItems.OLIVE_SLICE.asStack(8))
                .circuitMeta(2)
                .inputFluids(GTMFOFluids.TomatoSauce.getFluid(300))
                .outputItems(GTMFOItems.PIZZA_VEGGIE_RAW.asStack())
                .EUt(30).duration(400).save(provider);

        GTMFORecipeTypes.BAKING_OVEN_RECIPES.recipeBuilder(id("pizza_cheese"))
                .inputItems(GTMFOItems.PIZZA_CHEESE_RAW.asStack())
                .outputItems(GTMFOBlocks.PIZZA_CHEESE.asStack())
                .EUt(60).duration(1400).save(provider);

        GTMFORecipeTypes.BAKING_OVEN_RECIPES.recipeBuilder(id("pizza_meat"))
                .inputItems(GTMFOItems.PIZZA_MEAT_RAW.asStack())
                .outputItems(GTMFOBlocks.PIZZA_MEAT.asStack())
                .EUt(60).duration(1600).save(provider);

        GTMFORecipeTypes.BAKING_OVEN_RECIPES.recipeBuilder(id("pizza_veggie"))
                .inputItems(GTMFOItems.PIZZA_VEGGIE_RAW.asStack())
                .outputItems(GTMFOBlocks.PIZZA_VEGGIE.asStack())
                .EUt(60).duration(1200).save(provider);
    }
}
