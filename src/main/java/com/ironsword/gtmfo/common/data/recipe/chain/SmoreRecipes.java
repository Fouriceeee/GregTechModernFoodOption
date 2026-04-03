package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import com.ironsword.gtmfo.common.data.recipe.GTMFORecipeTypes;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.List;
import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class SmoreRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        smore(provider);
        marshmallow(provider);
        milkChocolate(provider);
        grahamCracker(provider);
    }

    private static void smore(Consumer<FinishedRecipe> provider){
        List<ItemEntry<? extends Item>> smoreLists = List.of(
                GTMFOItems.GRAHAM_CRACKER,
                GTMFOItems.SMORE_1,
                GTMFOItems.SMORE_2,
                GTMFOItems.SMORE_4,
                GTMFOItems.SMORE_8,
                GTMFOItems.SMORE_16,
                GTMFOItems.SMORE_32,
                GTMFOItems.SMORE_64,
                GTMFOItems.SMOGUS_1,
                GTMFOItems.SMOGUS_2,
                GTMFOItems.SMOGUS_4,
                GTMFOItems.SMOGUS_HEART
        );
        int eut = 1920;
        int duration = 25;

        for (int i = 0; i < smoreLists.size() - 1 ;i++){
            GTRecipeTypes.FORMING_PRESS_RECIPES.recipeBuilder(smoreLists.get(i+1).getId())
                    .inputItems(
                            smoreLists.get(i).asStack(2),
                            GTMFOItems.MARSHMALLOW.asStack(),
                            GTMFOItems.MILK_CHOCOLATE_HOT.asStack())
                    .outputItems(smoreLists.get(i+1))
                    .EUt(eut).duration(duration).save(provider);
        }
    }

    private static void milkChocolate(Consumer<FinishedRecipe> provider){
        GTMFORecipeTypes.MICROWAVE_RECIPES.recipeBuilder(id("chocolate_hot_1"))
                .inputItems(GTMFOItems.MILK_CHOCOLATE.asStack())
                .outputItems(GTMFOItems.MILK_CHOCOLATE_HOT.asStack())
                .EUt(120).duration(100).save(provider);

        GTRecipeTypes.BLAST_RECIPES.recipeBuilder(id("chocolate_hot_2"))
                .inputItems(GTMFOItems.MILK_CHOCOLATE.asStack())
                .outputItems(GTMFOItems.MILK_CHOCOLATE_HOT.asStack())
                .blastFurnaceTemp(600)
                .EUt(120).duration(100).save(provider);
    }

    private static void grahamCracker(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("graham_cracker_dough"))
                .inputItems(Items.SUGAR)
                .inputItems(TagPrefix.dust,GTMaterials.Wheat,3)
                .inputItems(TagPrefix.dust,GTMaterials.SodiumBicarbonate)
                .inputFluids(
                        GTMFOFluids.Butter.getFluid(2000),
                        GTMaterials.Milk.getFluid(500))
                .outputItems(GTMFOItems.GRAHAM_CRACKER_DOUGH.asStack(10))
                .EUt(80).duration(200).save(provider);

        GTMFORecipeTypes.BAKING_OVEN_RECIPES.recipeBuilder(id("graham_cracker_dough_hot"))
                .inputItems(GTMFOItems.GRAHAM_CRACKER_DOUGH.asStack())
                .outputItems(GTMFOItems.GRAHAM_CRACKER_DOUGH_HOT.asStack())
                .EUt(30).duration(400).save(provider);

        GTRecipeTypes.BENDER_RECIPES.recipeBuilder(id("graham_cracker_dough_chunk_hot"))
                .inputItems(GTMFOItems.GRAHAM_CRACKER_DOUGH_HOT.asStack())
                .circuitMeta(1)
                .outputItems(GTMFOItems.GRAHAM_CRACKER_DOUGH_CHUNK_HOT.asStack())
                .EUt(45).duration(80).save(provider);

        GTMFORecipeTypes.SLICER_RECIPES.recipeBuilder(id("graham_cracker_hot"))
                .inputItems(GTMFOItems.GRAHAM_CRACKER_DOUGH_CHUNK_HOT.asStack())
                .notConsumable(GTMFOItems.SLICER_BLADE_FLAT.asStack())
                .outputItems(GTMFOItems.GRAHAM_CRACKER_HOT.asStack(9))
                .EUt(60).duration(200).save(provider);

        GTRecipeTypes.VACUUM_RECIPES.recipeBuilder(id("graham_cracker_ungraded"))
                .inputItems(GTMFOItems.GRAHAM_CRACKER_HOT.asStack())
                .outputItems(GTMFOItems.GRAHAM_CRACKER_UNGRADED.asStack())
                .EUt(60).duration(20).save(provider);

        GTRecipeTypes.ASSEMBLER_RECIPES.recipeBuilder(id("graham_cracker"))
                .inputItems(GTMFOItems.GRAHAM_CRACKER_UNGRADED.asStack())
                .notConsumable(GTItems.SENSOR_LV.asStack())
                .chancedOutput(GTMFOItems.GRAHAM_CRACKER.asStack(),7500,100)
                .outputItems(GTMFOItems.GRAHAM_CRACKER.asStack())
                .EUt(30).duration(40).save(provider);
    }

    private static void marshmallow(Consumer<FinishedRecipe> provider){
        List<Item> gelatinStacks = List.of(
                Items.BONE,
                Items.LEATHER,
                Items.PORKCHOP,
                Items.BEEF,
                Items.CHICKEN,
                Items.RABBIT,
                Items.MUTTON);

        for (Item item:gelatinStacks){
            GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("gelatin_from_"+item.toString()))
                    .inputItems(new ItemStack(item))
                    .outputItems(GTMFOItems.GELATIN.asStack())
                    .EUt(120).duration(100).save(provider);
        }


        GTRecipeTypes.MIXER_RECIPES.recipeBuilder("sweetened_diluted_cane_syrup_mixture")
                .inputItems(Items.SUGAR.getDefaultInstance())
                .inputFluids(GTMaterials.Water.getFluid(5000))
                .inputFluids(GTMFOFluids.CaneSyrup.getFluid(5000))
                .circuitMeta(1)
                .outputFluids(GTMFOFluids.SweetenedDilutedCaneSyrupMixture.getFluid(10000))
                .EUt(120).duration(260).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("marshmallow_syrup_mixture"))
                .inputItems(GTMFOItems.GELATIN.asStack(2))
                .inputFluids(GTMFOFluids.Albumen.getFluid(500))
                .inputFluids(GTMFOFluids.SweetenedDilutedCaneSyrupMixture.getFluid(5000))
                .circuitMeta(2)
                .outputFluids(GTMFOFluids.MarshmallowSyrupMixture.getFluid(5500))
                .EUt(120).duration(300).save(provider);

        GTRecipeTypes.FLUID_HEATER_RECIPES.recipeBuilder(id("marshmallow_foam"))
                .inputFluids(GTMFOFluids.MarshmallowSyrupMixture.getFluid(1000))
                .circuitMeta(1)
                .outputFluids(GTMFOFluids.MarshmallowFoam.getFluid(5000))
                .EUt(30).duration(300).save(provider);

        GTRecipeTypes.FLUID_SOLIDFICATION_RECIPES.recipeBuilder(id("marshmallow_matter"))
                .inputFluids(GTMFOFluids.MarshmallowFoam.getFluid(1000))
                .notConsumable(GTItems.SHAPE_MOLD_BALL.asStack())
                .outputItems(GTMFOItems.MARSHMALLOW_MATTER.asStack())
                .EUt(60).duration(100).save(provider);

        GTRecipeTypes.EXTRUDER_RECIPES.recipeBuilder(id("marshmallow"))
                .inputItems(GTMFOItems.MARSHMALLOW_MATTER.asStack(2))
                .notConsumable(GTItems.SHAPE_EXTRUDER_ROD)
                .outputItems(GTMFOItems.MARSHMALLOW.asStack(2))
                .EUt(90).duration(40).save(provider);

    }
}
