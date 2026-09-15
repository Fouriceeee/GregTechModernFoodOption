package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidContainerIngredient;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.GTMFOTags;
import com.ironsword.gtmfo.common.data.recipe.MaterialHelper;
import com.ironsword.gtmfo.common.data.recipe.RecipeUtils;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.tags.ItemTags;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class MiscRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        meat(provider);
    }

    private static void meat(Consumer<FinishedRecipe> provider){
        VanillaRecipeHelper.addShapelessRecipe(provider, id("meat_dust_by_hand"),
                MaterialHelper.dust(GTMaterials.Meat),
                GTMFOTags.MEAT, CustomTags.MORTARS);

        VanillaRecipeHelper.addShapedFluidContainerRecipe(provider,true,id("tough_meat_by_hand"),
                GTMFOItems.TOUGH_MEAT.asStack(),
                "AB ", "BC ",
                'A', ChemicalHelper.get(TagPrefix.dust, GTMaterials.Wheat),
                'B',ChemicalHelper.get(TagPrefix.dust,GTMaterials.Meat),
                'C', new FluidContainerIngredient(GTMaterials.Water.getFluidTag(), 1000));
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("tough_meat"))
                .inputItems(TagPrefix.dust,GTMaterials.Meat)
                .inputItems(TagPrefix.dust,GTMaterials.Wheat)
                .inputFluids(GTMaterials.Water.getFluid(500))
                .outputItems(GTMFOItems.TOUGH_MEAT,2)
                .duration(90).EUt(16).save(provider);
        RecipeUtils.addFoodSmeltingRecipe(provider,"meat_ingot_cooked_by_tough_meat",
                GTMFOItems.TOUGH_MEAT.asStack(),
                GTMFOItems.MEAT_INGOT_COOKED.asStack(),
                0.35f);

        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder(id("meat_ingot"))
                .inputItems(TagPrefix.dust,GTMaterials.Meat)
                .notConsumable(GTItems.SHAPE_EXTRUDER_INGOT)
                .outputItems(GTMFOItems.MEAT_INGOT)
                .duration(20).EUt(28).save(provider);
        RecipeUtils.addFoodSmeltingRecipe(provider,"meat_ingot_cooked",
                GTMFOItems.MEAT_INGOT.asStack(),
                GTMFOItems.MEAT_INGOT_COOKED.asStack(),
                0.35f);
    }
}
