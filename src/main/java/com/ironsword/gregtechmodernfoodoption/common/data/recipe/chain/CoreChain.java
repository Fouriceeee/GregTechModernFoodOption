package com.ironsword.gregtechmodernfoodoption.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.stack.MaterialEntry;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOBlocks;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOItems;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOFluids;
import com.ironsword.gregtechmodernfoodoption.common.data.material.GTMFOMaterials;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.fluids.FluidStack;

import java.util.function.Consumer;

public class CoreChain {
    public static void init(Consumer<FinishedRecipe> provider){
        zestChain(provider);
        caneSyrupChain(provider);
        generalChemicals(provider);
    }

    public static void zestChain(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("lemon")
                .inputItems(GTMFOItems.LEMON.asStack())
                .outputItems(TagPrefix.dust,GTMFOMaterials.ZEST)
                .outputFluids(GTMFOFluids.LEMON_EXTRACT.getFluid(100))
                .EUt(5)
                .duration(100)
                .save(provider);
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("lime")
                .inputItems(GTMFOItems.LIME.asStack())
                .outputItems(TagPrefix.dust,GTMFOMaterials.ZEST)
                .outputFluids(GTMFOFluids.LIME_EXTRACT.getFluid(100))
                .EUt(5)
                .duration(100)
                .save(provider);
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder("orange")
                .inputItems(GTMFOItems.ORANGE.asStack())
                .outputItems(TagPrefix.dust,GTMFOMaterials.ZEST)
                .outputFluids(GTMFOFluids.ORANGE_EXTRACT.getFluid(100))
                .EUt(5)
                .duration(100)
                .save(provider);

        VanillaRecipeHelper.addShapelessRecipe(
                provider,
                GregTechModernFoodOption.id("zest_from_lemon"),
                ChemicalHelper.get(TagPrefix.dust,GTMFOMaterials.ZEST),
                GTMFOItems.LEMON.asStack(),
                GTMFOItems.LEMON.asStack(),
                GTMFOItems.LEMON.asStack(),
                GTMFOItems.LEMON.asStack());
        VanillaRecipeHelper.addShapelessRecipe(
                provider,
                GregTechModernFoodOption.id("zest_from_lime"),
                ChemicalHelper.get(TagPrefix.dust,GTMFOMaterials.ZEST),
                GTMFOItems.LIME.asStack(),
                GTMFOItems.LIME.asStack(),
                GTMFOItems.LIME.asStack(),
                GTMFOItems.LIME.asStack());
        VanillaRecipeHelper.addShapelessRecipe(
                provider,
                GregTechModernFoodOption.id("zest_from_orange"),
                ChemicalHelper.get(TagPrefix.dust,GTMFOMaterials.ZEST),
                GTMFOItems.ORANGE.asStack(),
                GTMFOItems.ORANGE.asStack(),
                GTMFOItems.ORANGE.asStack(),
                GTMFOItems.ORANGE.asStack());
    }

    public static void caneSyrupChain(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("cane_syrup_unheated")
                .inputItems(new ItemStack(Items.SUGAR,24))
                .inputFluids(new FluidStack(Fluids.WATER,2000))
                .circuitMeta(2)
                .outputFluids(GTMFOFluids.CANE_SYRUP_UNHEATED.getFluid(2000))
                .EUt(80)
                .duration(260)
                .save(provider);

        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder("cane_syrup")
                .inputFluids(GTMFOFluids.CANE_SYRUP_UNHEATED.getFluid(1000))
                .circuitMeta(2)
                .outputFluids(GTMFOFluids.CANE_SYRUP.getFluid(1000))
                .EUt(120)
                .duration(80)
                .save(provider);
    }

    public static void generalChemicals(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("isopropyl_chloride")
                .inputFluids(
                        GTMaterials.HydrochloricAcid.getFluid(1000),
                        GTMaterials.Propene.getFluid(1000))
                .outputFluids(GTMFOFluids.ISOPROPYL_CHLORIDE.getFluid(1000))
                .EUt(30)
                .duration(200)
                .save(provider);

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder("chloroauric_acid")
                .inputItems(ChemicalHelper.get(TagPrefix.dust,GTMaterials.Gold,2))
                .inputFluids(GTMaterials.HydrochloricAcid.getFluid(8000))
                .outputFluids(GTMFOFluids.CHLOROAURIC_ACID.getFluid(2000),GTMaterials.Hydrogen.getFluid(3000))
                .EUt(480)
                .duration(300)
                .save(provider);
    }
}
