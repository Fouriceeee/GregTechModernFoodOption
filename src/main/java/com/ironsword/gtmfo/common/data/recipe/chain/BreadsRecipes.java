package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.recipe.GTMFORecipeTypes;
import com.ironsword.gtmfo.common.data.recipe.RecipeUtils;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class BreadsRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        bbb(provider);
        cake(provider);
        burger(provider);
        sandwich(provider);


    }

    //bun,bread, and baguette
    private static void bbb(Consumer<FinishedRecipe> provider){
        //wooden
        VanillaRecipeHelper.addShapedRecipe(provider,id("wooden_form_bun"),
                GTMFOItems.WOODEN_FORM_BUN.asStack(),
                "   ",
                "kM ",
                "   ",
                'M', GTItems.WOODEN_FORM_EMPTY.asStack());
        VanillaRecipeHelper.addShapedRecipe(provider,id("wooden_form_bread"),
                GTMFOItems.WOODEN_FORM_BREAD.asStack(),
                " k ",
                " M ",
                "   ",
                'M', GTItems.WOODEN_FORM_EMPTY.asStack());
        VanillaRecipeHelper.addShapedRecipe(provider,id("wooden_form_baguette"),
                GTMFOItems.WOODEN_FORM_BAGUETTE.asStack(),
                "  k",
                " M ",
                "   ",
                'M', GTItems.WOODEN_FORM_EMPTY.asStack());

        //unbaked
        VanillaRecipeHelper.addShapedRecipe(provider,id("bun_dough_by_hand"),
                GTMFOItems.BUN_UNBAKED.asStack(),
                " D ",
                " M ",
                'D', CustomTags.DOUGHS,
                'M', GTMFOItems.WOODEN_FORM_BUN.asStack());
        GTRecipeTypes.FORMING_PRESS_RECIPES.recipeBuilder(id("bun_dough"))
                .inputItems(CustomTags.DOUGHS,2)
                .notConsumable(GTMFOItems.WOODEN_FORM_BUN)
                .outputItems(GTMFOItems.BUN_UNBAKED,3)
                .EUt(20).duration(100).save(provider);

        VanillaRecipeHelper.addShapedRecipe(provider,id("bread_dough_by_hand"),
                GTMFOItems.BREAD_UNBAKED.asStack(),
                "D D",
                " M ",
                'D', CustomTags.DOUGHS,
                'M', GTMFOItems.WOODEN_FORM_BREAD.asStack());
        GTRecipeTypes.FORMING_PRESS_RECIPES.recipeBuilder(id("bread_dough"))
                .inputItems(CustomTags.DOUGHS,3)
                .notConsumable(GTMFOItems.WOODEN_FORM_BREAD)
                .outputItems(GTMFOItems.BREAD_UNBAKED,3)
                .EUt(20).duration(100).save(provider);

        VanillaRecipeHelper.addShapedRecipe(provider,id("baguette_dough_by_hand"),
                GTMFOItems.BAGUETTE_UNCOOKED.asStack(),
                "DDD",
                " M ",
                'D', CustomTags.DOUGHS,
                'M', GTMFOItems.WOODEN_FORM_BAGUETTE.asStack());
        GTRecipeTypes.FORMING_PRESS_RECIPES.recipeBuilder(id("baguette_dough"))
                .inputItems(CustomTags.DOUGHS,2)
                .notConsumable(GTMFOItems.WOODEN_FORM_BAGUETTE)
                .outputItems(GTMFOItems.BAGUETTE_UNCOOKED)
                .EUt(20).duration(100).save(provider);

        //baked
        //TODO: baking oven recipe
        RecipeUtils.addFoodSmeltingRecipe(provider,"bun",
                GTMFOItems.BUN_UNBAKED.asStack(),
                GTMFOItems.BUN.asStack(),
                0.35f);
        RecipeUtils.addFoodSmeltingRecipe(provider,"bread",
                GTMFOItems.BREAD_UNBAKED.asStack(),
                Items.BREAD.getDefaultInstance(),
                0.35f);
        RecipeUtils.addFoodSmeltingRecipe(provider,"baguette",
                GTMFOItems.BAGUETTE_UNCOOKED.asStack(),
                GTMFOItems.BAGUETTE.asStack(),
                0.35f);

        //slice
        VanillaRecipeHelper.addShapedRecipe(provider,id("bun_sliced_by_hand"),
                GTMFOItems.BUN_SLICED.asStack(),
                "Bk", 'B',GTMFOItems.BUN.asStack());
        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("bun_sliced"))
                .inputItems(GTMFOItems.BUN)
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .circuitMeta(1)
                .outputItems(GTMFOItems.BUN_SLICED)
                .EUt(18).duration(30).save(provider);

        VanillaRecipeHelper.addShapedRecipe(provider,id("bread_sliced_by_hand"),
                GTMFOItems.BREAD_SLICED.asStack(),
                "Bk", 'B',Items.BREAD.getDefaultInstance());
        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("bread_sliced"))
                .inputItems(Items.BREAD)
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .circuitMeta(1)
                .outputItems(GTMFOItems.BREAD_SLICED)
                .EUt(18).duration(30).save(provider);

        VanillaRecipeHelper.addShapedRecipe(provider,id("baguette_sliced_by_hand"),
                GTMFOItems.BAGUETTE_SLICED.asStack(),
                "Bk", 'B',GTMFOItems.BAGUETTE.asStack());
        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("baguette_sliced"))
                .inputItems(GTMFOItems.BAGUETTE)
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .circuitMeta(1)
                .outputItems(GTMFOItems.BAGUETTE_SLICED)
                .EUt(18).duration(30).save(provider);

        //TODO: baking oven recipe
        VanillaRecipeHelper.addShapedRecipe(provider,id("bread_slice_by_hand"),
                GTMFOItems.BREAD_SLICE.asStack(4),
                "k",
                "B",
                'B',Items.BREAD.getDefaultInstance());
        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("bread_slice"))
                .inputItems(Items.BREAD)
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT)
                .circuitMeta(2)
                .outputItems(GTMFOItems.BREAD_SLICE,8)
                .EUt(18).duration(30).save(provider);
        RecipeUtils.addFoodSmeltingRecipe(provider,"toast",GTMFOItems.BREAD_SLICE.asStack(),GTMFOItems.TOAST.asStack(),0.35f);
    }

    private static void cake(Consumer<FinishedRecipe> provider){

    }
    private static void burger(Consumer<FinishedRecipe> provider){

    }
    private static void sandwich(Consumer<FinishedRecipe> provider){

    }


    public static void remove(Consumer<ResourceLocation> consumer){
        consumer.accept(GTCEu.id("smelting/dough_to_bread"));
        consumer.accept(GTCEu.id("smoking/dough_to_bread"));
        consumer.accept(GTCEu.id("campfire/dough_to_bread"));
    }
}
