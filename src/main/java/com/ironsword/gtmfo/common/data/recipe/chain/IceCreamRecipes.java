package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidStack;

import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import com.ironsword.gtmfo.common.data.material.GTMFOMaterials;
import com.ironsword.gtmfo.common.data.recipe.MaterialHelper;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class IceCreamRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        // milk
        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("pasteurized_milk_1"))
                .circuitMeta(1)
                .inputFluids(GTMaterials.Milk.getFluid(4000))
                .outputFluids(GTMFOFluids.PasteurizedMilk.getFluid(4000))
                .EUt(16).duration(800).save(provider);

        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("pasteurized_milk_2"))
                .circuitMeta(2)
                .inputFluids(GTMaterials.Milk.getFluid(4000))
                .outputFluids(GTMFOFluids.PasteurizedMilk.getFluid(4000))
                .EUt(256).duration(40).save(provider);

        GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(id("skimmed_milk_and_cream"))
                .inputFluids(GTMFOFluids.PasteurizedMilk.getFluid(1000))
                .outputFluids(
                        GTMFOFluids.SkimmedMilk.getFluid(800),
                        GTMFOFluids.Cream.getFluid(200))
                .EUt(24).duration(100).save(provider);

        // basic ice-cream
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("milk_colloid"))
                .inputFluids(
                        GTMaterials.Milk.getFluid(500),
                        GTMFOFluids.SoyLecithin.getFluid(10))
                .inputItems(MaterialHelper.dust(GTMaterials.Sugar))
                .outputFluids(GTMFOFluids.MilkColloid.getFluid(500))
                .EUt(24).duration(160).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("ice_cream_mixture"))
                .inputFluids(
                        GTMFOFluids.MilkColloid.getFluid(500),
                        GTMFOFluids.Cream.getFluid(500))
                .outputFluids(GTMFOFluids.IceCreamMixture.getFluid(1000))
                .EUt(24).duration(200).save(provider);

        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES.recipeBuilder(id("ice_cream_plain"))
                .inputFluids(GTMFOFluids.IceCreamMixture.getFluid(144))
                .notConsumable(GTItems.SHAPE_MOLD_BALL.asStack())
                .outputItems(GTMFOItems.ICE_CREAM.asStack())
                .EUt(7).duration(70).save(provider);

        // flavor ice-cream
        flavor(provider, "ice_cream_chum", GTMFOItems.CHUM, GTMFOItems.ICE_CREAM_CHUM);
        flavor(provider, "ice_cream_chocolate", GTMFOFluids.MoltenMilkChocolate, 72, GTMFOItems.ICE_CREAM_CHOCOLATE);
        flavor(provider, "ice_cream_vanilla", MaterialHelper.dust(GTMFOMaterials.Vanillin),
                GTMFOItems.ICE_CREAM_VANILLA);
        flavor(provider, "ice_cream_banana", GTMFOItems.BANANA_PEELED, GTMFOItems.ICE_CREAM_BANANA);
        flavor(provider, "ice_cream_bacon", GTMFOItems.BACON, GTMFOItems.ICE_CREAM_BACON);
        flavor(provider, "ice_cream_bear", GTMFOItems.MEAT_INGOT_COOKED, GTMFOItems.ICE_CREAM_BEAR);
        flavor(provider, "ice_cream_melon", GTMFOFluids.MelonExtract, 50, GTMFOItems.ICE_CREAM_MELON);
        flavor(provider, "ice_cream_lemon", GTMFOFluids.LemonExtract, 25, GTMFOItems.ICE_CREAM_LEMON);
        flavor(provider, "ice_cream_chip", GTMFOItems.POTATO_SLICE_FRIED.asStack(3), GTMFOItems.ICE_CREAM_CHIP);
        flavor(provider, "ice_cream_rainbow", GTMFOFluids.RainbowSap, 25, GTMFOItems.ICE_CREAM_RAINBOW);

        // basic sorbet
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("sorbet_plain"))
                .circuitMeta(1)
                .inputItems(MaterialHelper.dust(GTMaterials.Ice, 4))
                .inputItems(MaterialHelper.dustTiny(GTMaterials.Sugar))
                .outputItems(GTMFOItems.SORBET, 4)
                .EUt(30).duration(200).save(provider);

        // flavor sorbet
        sorbet(provider, "sorbet_apple", GTMFOItems.SORBET_APPLE, GTMFOFluids.AppleExtract.getFluid(50));
        sorbet(provider, "sorbet_apricot", GTMFOItems.SORBET_APRICOT, GTMFOFluids.ApricotExtract.getFluid(40),
                GTMFOFluids.LemonExtract.getFluid(10));
        sorbet(provider, "sorbet_grape", GTMFOItems.SORBET_GRAPE, GTMFOFluids.GrapeExtract.getFluid(50));
        sorbet(provider, "sorbet_lime", GTMFOItems.SORBET_LIME, GTMFOFluids.LimeExtract.getFluid(50));
        // TODO: chorus chain
        sorbet(provider, "sorbet_chorus", GTMFOItems.SORBET_CHORUS, GTMFOFluids.ChorusExtract.getFluid(40),
                GTMFOFluids.LemonExtract.getFluid(10));
        // sorbet(provider,"sorbet_vibrant",GTMFOItems.SORBET_VIBRANT,GTMFOFluids..getFluid(40),GTMFOFluids.LemonExtract.getFluid(10));
    }

    private static void flavor(Consumer<FinishedRecipe> provider, String id, ItemStack inputItem,
                               ItemLike outputItem) {
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id(id))
                .inputItems(GTMFOItems.ICE_CREAM, 4)
                .inputItems(inputItem)
                .outputItems(outputItem, 4)
                .EUt(24).duration(120).save(provider);
    }

    private static void flavor(Consumer<FinishedRecipe> provider, String id, ItemLike inputItem,
                               ItemLike outputItem) {
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id(id))
                .inputItems(GTMFOItems.ICE_CREAM, 4)
                .inputItems(inputItem)
                .outputItems(outputItem, 4)
                .EUt(24).duration(120).save(provider);
    }

    private static void flavor(Consumer<FinishedRecipe> provider, String id, Material fluid, int amount,
                               ItemLike outputItem) {
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id(id))
                .inputItems(GTMFOItems.ICE_CREAM, 4)
                .inputFluids(fluid, amount)
                .outputItems(outputItem, 4)
                .EUt(24).duration(120).save(provider);
    }

    private static void sorbet(Consumer<FinishedRecipe> provider, String id, ItemLike outputItem,
                               FluidStack... fluids) {
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id(id))
                .inputItems(MaterialHelper.dust(GTMaterials.Ice, 4))
                .inputItems(MaterialHelper.dustTiny(GTMaterials.Sugar))
                .inputFluids(fluids)
                .outputItems(outputItem, 4)
                .EUt(30).duration(200).save(provider);
    }
}
