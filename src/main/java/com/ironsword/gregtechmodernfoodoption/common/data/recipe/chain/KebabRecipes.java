package com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

import static com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption.id;

public class KebabRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.LATHE_RECIPES.recipeBuilder(id("skewer_1"))
                .inputItems(TagPrefix.rod, GTMaterials.StainlessSteel)
                .outputItems(GTMFOItems.SKEWER.asStack(8))
                .EUt(40).duration(120).save(provider);
        GTRecipeTypes.LATHE_RECIPES.recipeBuilder(id("skewer_2"))
                .inputItems(TagPrefix.rodLong, GTMaterials.StainlessSteel)
                .outputItems(GTMFOItems.SKEWER.asStack(16))
                .EUt(40).duration(25).save(provider);
    }
}
