package com.ironsword.gregtechmodernfoodoption.common.data.recipe;

import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain.CoreChain;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class GTMFORecipes {

    public static void init(Consumer<FinishedRecipe> provider){
        //VanillaRecipeHelper.addSmeltingRecipe(provider,);

        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder("test_recipe_1")
                .inputItems(Items.APPLE)
                .notConsumable(GTMFOItems.SLICER_BLADE_OCTAGONAL)
                .outputItems(new ItemStack(GTMFOItems.APPLE_SLICE,8))
                .save(provider);

        CoreChain.init(provider);
    }
}
