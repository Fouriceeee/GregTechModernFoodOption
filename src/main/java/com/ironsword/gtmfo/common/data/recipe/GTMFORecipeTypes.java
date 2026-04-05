package com.ironsword.gtmfo.common.data.recipe;

import com.gregtechceu.gtceu.GTCEu;
import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.recipe.GTRecipeType;
import com.gregtechceu.gtceu.common.data.GTRecipeTypes;
import com.gregtechceu.gtceu.common.data.GTSoundEntries;
import com.gregtechceu.gtceu.data.recipe.builder.GTRecipeBuilder;
import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.data.GTMFOGuiTextures;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.lowdragmc.lowdraglib.gui.texture.ProgressTexture.FillDirection.LEFT_TO_RIGHT;


public class GTMFORecipeTypes {

    public static final GTRecipeType SLICER_RECIPES = GTRecipeTypes.register("slicer",GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(3,2,1,1)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.CUT)
            .setSlotOverlay(false,false,false, GTMFOGuiTextures.SLICER_INPUT_OVERLAY)
            .setSlotOverlay(false,false,true,GTMFOGuiTextures.SLICER_CUTTER_OVERLAY)
            .setSlotOverlay(true,false,false,GTMFOGuiTextures.SLICER_OUTPUT_OVERLAY)
            .setSlotOverlay(true,false,true, GuiTextures.DUST_OVERLAY)
            .setProgressBar(GTMFOGuiTextures.PROGRESS_BAR_SLICER, LEFT_TO_RIGHT)
            //.onRecipeBuild(gtmfoID())
            ;

    public static final GTRecipeType CUISINE_ASSEMBLER_RECIPES = GTRecipeTypes.register("cuisine_assembler",GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(6,2,3,1)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ASSEMBLER)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT);

    public static final GTRecipeType MICROWAVE_RECIPES = GTRecipeTypes.register("microwave",GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(1,1,0,0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.ARC)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW, LEFT_TO_RIGHT);

    public static final GTRecipeType MULTICOOKER_RECIPES = GTRecipeTypes.register("multicooker",GTRecipeTypes.ELECTRIC)
            .setMaxIOSize(6,3,3,2)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.MIXER)
            .setSlotOverlay(false,true,GuiTextures.HEATING_OVERLAY_1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT);


    //multi_block
    public static final GTRecipeType BAKING_OVEN_RECIPES = GTRecipeTypes.register("baking_oven",GTRecipeTypes.MULTIBLOCK)
            .setMaxIOSize(1,1,0,0)
            .setEUIO(IO.IN)
            .setSound(GTSoundEntries.FURNACE)
            .setSlotOverlay(false,false,true,GuiTextures.FURNACE_OVERLAY_1)
            .setProgressBar(GuiTextures.PROGRESS_BAR_ARROW_MULTIPLE, LEFT_TO_RIGHT);

    private static BiConsumer<GTRecipeBuilder, Consumer<FinishedRecipe>> gtmfoID(){
        return (builder,consumer)->{
            ResourceLocation rl = builder.id;
            if (rl.getNamespace().equals(GTCEu.MOD_ID)){
                builder.id(GregTechModernFoodOption.id(rl.getPath()));
            }};
    }

    public static void init(){
    }
}
