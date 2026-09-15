package com.ironsword.gtmfo.common.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.tool.ToolHelper;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.GTMFOToolTypes;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import com.ironsword.gtmfo.common.data.recipe.chain.*;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class GTMFORecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        AppleRecipes.init(provider);
        BerryRecipes.init(provider);
        BreadRecipes.init(provider);
        CapletRecipes.init(provider);
        CoreChain.init(provider);
        FruitRecipes.init(provider);
        PotatoRecipes.init(provider);
        PizzaRecipes.init(provider);
        PurpleDrinkRecipes.init(provider);
        KebabRecipes.init(provider);
        ItalianRecipes.init(provider);
        SmoreRecipes.init(provider);

        cheeseRecipes(provider);
        rollingPinRecipes(provider);

        GTMFOMachineRecipes.init(provider);

        // VanillaRecipeHelper.addShapelessRecipe(provider,id("test_recipe"),Items.DIAMOND.getDefaultInstance(),GTMFOItems.TEST.asStack(),Items.COAL.getDefaultInstance());
    }

    public static void remove(Consumer<ResourceLocation> consumer) {
        BreadRecipes.remove(consumer);
    }

    private static void cheeseRecipes(Consumer<FinishedRecipe> provider) {
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
                .outputItems(GTMFOItems.MOZZARELLA_SLICE, 9)
                .EUt(16).duration(400).save(provider);
    }

    private static void rollingPinRecipes(Consumer<FinishedRecipe> provider) {
        VanillaRecipeHelper.addShapedRecipe(provider, id("wood_rolling_pin"),
                ToolHelper.get(GTMFOToolTypes.ROLLING_PIN, GTMaterials.Wood),
                "  R",
                " P ",
                "R f",
                'P', ItemTags.PLANKS,
                'R', Items.STICK.getDefaultInstance());
        VanillaRecipeHelper.addShapedRecipe(provider, id("rubber_rolling_pin"),
                ToolHelper.get(GTMFOToolTypes.ROLLING_PIN, GTMaterials.Rubber),
                "  R",
                " P ",
                "R f",
                'P', ChemicalHelper.get(TagPrefix.ingot, GTMaterials.Rubber),
                'R', Items.STICK.getDefaultInstance());
        VanillaRecipeHelper.addShapedRecipe(provider, id("polyethylene_rolling_pin"),
                ToolHelper.get(GTMFOToolTypes.ROLLING_PIN, GTMaterials.Polyethylene),
                "  R",
                " P ",
                "R f",
                'P', ChemicalHelper.get(TagPrefix.ingot, GTMaterials.Polyethylene),
                'R', Items.STICK.getDefaultInstance());
        VanillaRecipeHelper.addShapedRecipe(provider, id("polytetrafluoroethylene_rolling_pin"),
                ToolHelper.get(GTMFOToolTypes.ROLLING_PIN, GTMaterials.Polytetrafluoroethylene),
                "  R",
                " P ",
                "R f",
                'P', ChemicalHelper.get(TagPrefix.ingot, GTMaterials.Polytetrafluoroethylene),
                'R', Items.STICK.getDefaultInstance());
    }
}
