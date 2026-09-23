package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.fluids.FluidStack;

import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class FruitRecipes {

    public static void init(Consumer<FinishedRecipe> provider) {
        extractRecipes(provider);
    }

    private static void extractRecipes(Consumer<FinishedRecipe> provider) {
        extract(provider, "lemon_extract", GTMFOItems.LEMON, GTMFOFluids.LemonExtract);
        extract(provider, "lime_extract", GTMFOItems.LIME, GTMFOFluids.LimeExtract);
        extract(provider, "orange_extract", GTMFOItems.ORANGE, GTMFOFluids.OrangeExtract);
        extract(provider, "cranberry_extract", GTMFOItems.CRANBERRY, GTMFOFluids.CranberryExtract);
        extract(provider, "melon_extract", Items.MELON_SLICE, GTMFOFluids.MelonExtract);

        extract(provider, "grape_extract", GTMFOItems.GRAPES, GTMFOFluids.GrapeExtract);
        extract(provider, "grape_extract_from_white_grape", GTMFOItems.WHITE_GRAPES, GTMFOFluids.GrapeExtract);
        extract(provider, "apricot_extract", GTMFOItems.APRICOT, GTMFOFluids.ApricotExtract);

        extract(provider, "chorus_extract", Items.CHORUS_FRUIT.getDefaultInstance(),
                GTMFOFluids.ChorusExtract.getFluid(50), 16, 200);
        extract(provider, "chorus_extract_from_popped_chorus", Items.POPPED_CHORUS_FRUIT.getDefaultInstance(),
                GTMFOFluids.ChorusExtract.getFluid(100), 16, 200);
    }

    private static void extract(Consumer<FinishedRecipe> provider, String id, ItemLike input, Material output) {
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id(id))
                .inputItems(input)
                .outputFluids(output.getFluid(100))
                .EUt(5).duration(100).save(provider);
    }

    private static void extract(Consumer<FinishedRecipe> provider, String id, ItemStack input, FluidStack output,
                                long eut, int duration) {
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id(id))
                .inputItems(input)
                .outputFluids(output)
                .EUt(eut).duration(duration).save(provider);
    }
}
