package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.recipe.ingredient.FluidContainerIngredient;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.recipe.GTMFORecipeTypes;
import com.ironsword.gtmfo.common.data.recipe.RecipeUtils;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.gregtechceu.gtceu.api.GTValues.LV;
import static com.gregtechceu.gtceu.api.GTValues.VA;
import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class BreadsRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        bbb(provider);
        cake(provider);
        cookie(provider);
        burger(provider);
        sandwich(provider);
        pumpkinPie(provider);


    }

    //bun, bread, and baguette
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
                " k ",
                " M ",
                "   ",
                'M', GTMFOItems.WOODEN_FORM_BREAD.asStack());

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
        VanillaRecipeHelper.addShapelessRecipe(provider,id("dough_sugary_by_hand"),
                GTMFOItems.DOUGH_SUGARY.asStack(2),
                Items.SUGAR.getDefaultInstance(),GTItems.DOUGH.asStack(2));
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("dough_sugary"))
                .inputItems(Items.SUGAR)
                .inputItems(GTItems.DOUGH)
                .outputItems(GTMFOItems.DOUGH_SUGARY)
                .EUt(7).duration(32).save(provider);
        VanillaRecipeHelper.addShapedRecipe(provider,id("cake_bottom_by_hand"),
                GTMFOItems.CAKE_BOTTOM.asStack(),
                "D D","DMD",
                'D',GTMFOItems.CAKE_BOTTOM.asStack(),
                'M',GTItems.SHAPE_MOLD_CYLINDER.asStack());
        GTRecipeTypes.FORMING_PRESS_RECIPES.recipeBuilder(id("cake_bottom"))
                .inputItems(GTMFOItems.DOUGH_SUGARY,4)
                .notConsumable(GTItems.SHAPE_MOLD_CYLINDER)
                .outputItems(GTMFOItems.CAKE_BOTTOM)
                .EUt(30).duration(100).save(provider);

        //TODO: baking oven recipe
        RecipeUtils.addFoodSmeltingRecipe(provider,"cake_bottom_baked",GTMFOItems.CAKE_BOTTOM.asStack(),GTMFOItems.CAKE_BOTTOM_BAKED.asStack(),0.35f);

        VanillaRecipeHelper.addShapedRecipe(provider,id("cake_by_hand"),Items.CAKE.getDefaultInstance(),
                "SES","EBE","MMM",
                'S',Items.SUGAR.getDefaultInstance(),
                'E',Items.EGG.getDefaultInstance(),
                'B',GTMFOItems.CAKE_BOTTOM_BAKED.asStack(),
                'M',new FluidContainerIngredient(GTMaterials.Milk.getFluidTag(), 1000));
        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("cake"))
                .inputItems(Items.SUGAR)
                .inputItems(Items.EGG)
                .inputItems(GTMFOItems.CAKE_BOTTOM_BAKED)
                .inputFluids(GTMaterials.Milk,3000)
                .outputItems(Items.CAKE)
                .EUt(7).duration(100).save(provider);
    }

    private static void cookie(Consumer<FinishedRecipe> provider){
        VanillaRecipeHelper.addShapelessRecipe(provider, id("cookie_by_hand"), new ItemStack(Items.COOKIE, 4),
                GTMFOItems.COCOA_NIBS.asStack(), GTMFOItems.DOUGH_SUGARY.asStack(), 'r');

        GTRecipeTypes.FORMING_PRESS_RECIPES.recipeBuilder(id("cookie"))
                .inputItems(GTMFOItems.DOUGH_SUGARY)
                .inputItems(GTMFOItems.COCOA_NIBS,2)
                .notConsumable(GTItems.SHAPE_MOLD_CYLINDER)
                .outputItems(Items.COOKIE,8)
                .EUt(30).duration(200).save(provider);
    }

    private static void burger(Consumer<FinishedRecipe> provider){
        VanillaRecipeHelper.addShapelessRecipe(provider,id("burger_veggie_by_hand"),GTMFOItems.BURGER_VEGGIE.asStack(),
                GTMFOItems.BUN_SLICED.asStack(),
                GTMFOItems.CUCUMBER_SLICE.asStack(),GTMFOItems.CUCUMBER_SLICE.asStack(),
                GTMFOItems.TOMATO_SLICE.asStack(),GTMFOItems.TOMATO_SLICE.asStack(),
                GTMFOItems.ONION_SLICE.asStack(),GTMFOItems.ONION_SLICE.asStack());
        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("burger_veggie"))
                .inputItems(GTMFOItems.BUN_SLICED)
                .inputItems(GTMFOItems.CUCUMBER_SLICE)
                .inputItems(GTMFOItems.TOMATO_SLICE)
                .inputItems(GTMFOItems.ONION_SLICE)
                .outputItems(GTMFOItems.BURGER_VEGGIE)
                .EUt(24).duration(50).save(provider);

        VanillaRecipeHelper.addShapelessRecipe(provider,id("burger_cheese_by_hand"),GTMFOItems.BURGER_CHEESE.asStack(),
                GTMFOItems.BUN_SLICED.asStack(),
                GTMFOItems.CHEDDAR_SLICE.asStack(),GTMFOItems.CHEDDAR_SLICE.asStack(),
                GTMFOItems.CHEDDAR_SLICE.asStack(),GTMFOItems.CHEDDAR_SLICE.asStack());
        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("burger_cheese"))
                .inputItems(GTMFOItems.BUN_SLICED)
                .inputItems(GTMFOItems.CHEDDAR_SLICE,2)
                .outputItems(GTMFOItems.BURGER_CHEESE)
                .EUt(24).duration(50).save(provider);

        VanillaRecipeHelper.addShapelessRecipe(provider,id("burger_bacon_by_hand"),GTMFOItems.BURGER_BACON.asStack(),
                GTMFOItems.BUN_SLICED.asStack(),
                GTMFOItems.BACON.asStack(),GTMFOItems.BACON.asStack());
        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("burger_bacon"))
                .inputItems(GTMFOItems.BUN_SLICED)
                .inputItems(GTMFOItems.BACON)
                .outputItems(GTMFOItems.BURGER_BACON)
                .EUt(24).duration(50).save(provider);

        VanillaRecipeHelper.addShapelessRecipe(provider,id("burger_steak_by_hand"),GTMFOItems.BURGER_STEAK.asStack(),
                GTMFOItems.BUN_SLICED.asStack(),
                GTMFOItems.MEAT_INGOT_COOKED.asStack(),GTMFOItems.MEAT_INGOT_COOKED.asStack());
        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("burger_steak"))
                .inputItems(GTMFOItems.BUN_SLICED)
                .inputItems(GTMFOItems.MEAT_INGOT_COOKED)
                .outputItems(GTMFOItems.BURGER_STEAK)
                .EUt(24).duration(50).save(provider);

        VanillaRecipeHelper.addShapelessRecipe(provider,id("burger_chum_by_hand"),GTMFOItems.BURGER_CHUM.asStack(),
                GTMFOItems.BUN_SLICED.asStack(),
                GTMFOItems.CHUM.asStack(),GTMFOItems.CHUM.asStack());
        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("burger_chum"))
                .inputItems(GTMFOItems.BUN_SLICED)
                .inputItems(GTMFOItems.CHUM)
                .outputItems(GTMFOItems.BURGER_CHUM)
                .EUt(24).duration(50).save(provider);

    }

    private static void sandwich(Consumer<FinishedRecipe> provider){

    }

    private static void pumpkinPie(Consumer<FinishedRecipe> provider){
        VanillaRecipeHelper.addShapelessRecipe(provider,id("pie_crust_by_hand"),GTMFOItems.PIE_CRUST.asStack(),
                GTMFOItems.DOUGH_SUGARY.asStack(),'r');
        VanillaRecipeHelper.addShapelessRecipe(provider,id("pumpkin_pie_by_hand"),Items.PUMPKIN_PIE.getDefaultInstance(),
                GTMFOItems.PIE_CRUST.asStack(),Items.PUMPKIN.getDefaultInstance(),Items.SUGAR.getDefaultInstance());
    }


    public static void remove(Consumer<ResourceLocation> consumer){
        consumer.accept(GTCEu.id("smelting/dough_to_bread"));
        consumer.accept(GTCEu.id("smoking/dough_to_bread"));
        consumer.accept(GTCEu.id("campfire/dough_to_bread"));

        consumer.accept(GTCEu.id("cake"));

        consumer.accept(GTCEu.id("shapeless/cookie"));
        consumer.accept(GTCEu.id("shapeless/cookie_from_dough"));

        consumer.accept(GTCEu.id("forming_press/cookie"));

        consumer.accept(GTCEu.id("shapeless/pumpkin_pie_from_dough"));
    }
}
