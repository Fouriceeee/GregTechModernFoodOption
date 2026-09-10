package com.ironsword.gtmfo.common.data.recipe.chain;

import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.ironsword.gtmfo.common.data.GTMFOItems;
import com.ironsword.gtmfo.common.data.material.GTMFOFluids;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;
import static com.ironsword.gtmfo.GregTechModernFoodOption.id;

public class PurpleDrinkRecipes {
    public static void init(Consumer<FinishedRecipe> provider){
        EtirpsRecipes(provider);
        CoughSyrupRecipes(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("purple_drink"))
                .inputFluids(
                        GTMFOFluids.Etirps.getFluid(1000),
                        GTMFOFluids.CoughSyrup.getFluid(1000)
                )
                .inputItems(GTMFOItems.APPLE_CANDY_CRUSHED)
                .outputFluids(GTMFOFluids.PurpleDrink.getFluid(1000))
                .EUt(480).duration(40).save(provider);
        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("purple_drink_bottle"))
                .inputFluids(GTMFOFluids.PurpleDrink.getFluid(500))
                .inputItems(Items.GLASS_BOTTLE)
                .outputItems(GTItems.BOTTLE_PURPLE_DRINK)
                .EUt(30).duration(20).save(provider);


    }

    private static void EtirpsRecipes(Consumer<FinishedRecipe> provider){
        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("lemon_lime_solution"))
                .inputFluids(
                        GTMFOFluids.LemonExtract.getFluid(500),
                        GTMFOFluids.LimeExtract.getFluid(500)
                )
                .outputFluids(GTMFOFluids.LemonLimeSolution.getFluid(1000))
                .EUt(30).duration(100).save(provider);

        GTRecipeTypes.CENTRIFUGE_RECIPES.recipeBuilder(id("lemon_lime_sludge"))
                .inputFluids(GTMFOFluids.LemonLimeSolution.getFluid(1500))
                .outputFluids(GTMFOFluids.LemonLimeSludge.getFluid(1000))
                .EUt(30).duration(140).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("lemon_lime_soda_syrup"))
                .inputItems(Items.SUGAR,9)
                .inputFluids(GTMFOFluids.LemonLimeSludge.getFluid(500))
                .outputFluids(GTMFOFluids.LemonLimeSodaSyrup.getFluid(500))
                .EUt(60).duration(40).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("etirps"))
                .inputFluids(
                        GTMFOFluids.CarbonatedWater.getFluid(1000),
                        GTMFOFluids.LemonLimeSodaSyrup.getFluid(1000)
                )
                .outputFluids(GTMFOFluids.Etirps.getFluid(2000))
                .EUt(60).duration(20).save(provider);

        GTRecipeTypes.CANNER_RECIPES.recipeBuilder(id("etirps_can"))
                .inputFluids(GTMFOFluids.Etirps.getFluid(500))
                .inputItems(GTMFOItems.CAN.asStack())
                .outputItems(GTMFOItems.ETIRPS.asStack())
                .EUt(30).duration(20).save(provider);
    }

    private static void CoughSyrupRecipes(Consumer<FinishedRecipe> provider){

        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("isopropyl_chloride"))
                .inputFluids(
                        GTMaterials.HydrochloricAcid.getFluid(1000),
                        GTMaterials.Propene.getFluid(1000))
                .outputFluids(GTMFOFluids.IsopropylChloride.getFluid(1000))
                .EUt(30).duration(200).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("aniline"))
                .inputFluids(
                        GTMaterials.Hydrogen.getFluid(6000),
                        GTMaterials.Nitrobenzene.getFluid(1000))
                .notConsumable(TagPrefix.dust,GTMaterials.Zinc)
                .outputFluids(
                        GTMFOFluids.Aniline.getFluid(1000),
                        GTMaterials.Water.getFluid(2000))
                .EUt(30).duration(100).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("diphenylamine"))
                .inputFluids(
                        GTMFOFluids.Aniline.getFluid(2000),
                        GTMaterials.HydrofluoricAcid.getFluid(1000))
                .outputItems(GTMFOItems.DIPHENYLAMINE,24)
                .outputItems(TagPrefix.dust, GTMaterials.AmmoniumChloride, 2)
                .EUt(480).duration(120).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("phenothiazine"))
                .inputItems(GTMFOItems.DIPHENYLAMINE,24)
                .inputItems(TagPrefix.dust,GTMaterials.Sulfur,2)
                .outputItems(GTMFOItems.PHENOTHIAZINE,23)
                .outputFluids(GTMaterials.HydrogenSulfide.getFluid(1000))
                .EUt(120).duration(120).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("x_phenothiazine_ii_propyl_chloride"))
                .inputFluids(GTMFOFluids.IsopropylChloride.getFluid(1000))
                .inputItems(GTMFOItems.PHENOTHIAZINE,23)
                .outputFluids(GTMFOFluids.XPhenothiazineIIPropylChloride.getFluid(1000))
                .EUt(240).duration(120).save(provider);
        GTRecipeTypes.CHEMICAL_RECIPES.recipeBuilder(id("promethazine"))
                .inputFluids(
                        GTMaterials.Dimethylamine.getFluid(1000),
                        GTMFOFluids.XPhenothiazineIIPropylChloride.getFluid(1000))
                .notConsumable(TagPrefix.dust,GTMaterials.Copper)
                .outputItems(GTMFOItems.PROMETHAZINE,40)
                .outputFluids(GTMaterials.HydrochloricAcid.getFluid(1000))
                .EUt(8000).duration(120).save(provider);

        GTRecipeTypes.MACERATOR_RECIPES.recipeBuilder(id("poppy_crushed"))
                .inputItems(Items.POPPY)
                .outputItems(GTMFOItems.POPPY_CRUSHED)
                .EUt(4).duration(20).save(provider);
        GTRecipeTypes.EXTRACTOR_RECIPES.recipeBuilder(id("codeine"))
                .inputItems(GTMFOItems.POPPY_CRUSHED,30)
                .outputItems(GTMFOItems.CODEINE,42)
                .EUt(1920).duration(600).save(provider);

        GTRecipeTypes.MIXER_RECIPES.recipeBuilder(id("cough_syrup"))
                .inputItems(GTMFOItems.PROMETHAZINE,40)
                .inputItems(GTMFOItems.CODEINE,42)
                .inputFluids(GTMaterials.Water,1000)
                .outputFluids(GTMFOFluids.CoughSyrup.getFluid(1000))
                .EUt(60).duration(60).save(provider);

    }
}
