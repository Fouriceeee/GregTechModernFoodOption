package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.data.recipe.VanillaRecipeHelper;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.GTMFOTags;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import com.ironsword.gtmfo.common.data.recipe.GTMFORecipeTypes;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

import static com.ironsword.gtmfo.GregTechModernFoodOption.id;


public class BerryRecipes {
    public static void init(Consumer<FinishedRecipe> provider){

        //berry_medley
        VanillaRecipeHelper.addShapelessRecipe(provider,id("berry_medley"),
                GTMFOItems.BERRY_MEDLEY.asStack(),
                GTMFOTags.BERRY,GTMFOTags.BERRY,GTMFOTags.BERRY,GTMFOTags.BERRY,Items.BOWL);
        GTMFORecipeTypes.MULTICOOKER_RECIPES.recipeBuilder(id("berry_jam"))
                .inputItems(GTMFOTags.BERRY)
                .inputItems(Items.SUGAR.getDefaultInstance())
                .inputFluids(GTMFOFluids.LemonExtract.getFluid(150))
                .outputFluids(GTMFOFluids.BerryJam.getFluid(250))
                .EUt(16).duration(240).save(provider);
        GTMFORecipeTypes.MULTICOOKER_RECIPES.recipeBuilder(id("elderberry_jam"))
                .inputItems(GTMFOItems.ELDERBERRY.asStack())
                .inputItems(Items.SUGAR.getDefaultInstance())
                .inputFluids(GTMFOFluids.LemonExtract.getFluid(150))
                .outputFluids(GTMFOFluids.ElderberryJam.getFluid(250))
                .EUt(16).duration(240).save(provider);
        GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES.recipeBuilder(id("berry_medley"))
                .inputItems(GTMFOTags.BERRY_SWEET)
                .inputItems(GTMFOTags.BERRY_TART)
                .inputFluids(GTMFOFluids.BerryJam.getFluid(50))
                .inputItems(Items.BOWL.getDefaultInstance())
                .outputItems(GTMFOItems.BERRY_MEDLEY.asStack())
                .EUt(8).duration(20).save(provider);

        //cranberry_etirps
        GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(id("cranberry_sludge"))
                .inputFluids(GTMFOFluids.CranberryExtract.getFluid(1500))
                .outputFluids(GTMFOFluids.CranberrySludge.getFluid(1000))
                .EUt(30).duration(140).save(provider);
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("cranberry_soda_syrup"))
                .inputItems(Items.SUGAR,6)
                .inputFluids(GTMFOFluids.CranberrySludge.getFluid(500))
                .outputFluids(GTMFOFluids.CranberrySodaSyrup.getFluid(500))
                .EUt(60).duration(40).save(provider);
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("cranberry_etirps"))
                .inputFluids(
                        GTMFOFluids.CarbonatedWater.getFluid(1000),
                        GTMFOFluids.CranberrySodaSyrup.getFluid(1000))
                .outputFluids(GTMFOFluids.CranberryEtirps.getFluid(2000))
                .EUt(60).duration(20).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("cranberry_etirps"))
                .inputFluids(GTMFOFluids.CranberryEtirps.getFluid(500))
                .inputItems(GTMFOItems.CAN)
                .outputItems(GTMFOItems.ETIRPS_CRANBERRY)
                .EUt(30).duration(20).save(provider);

    }
}
