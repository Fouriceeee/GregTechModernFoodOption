package com.ironsword.gregtechmodernfoodoption;

import com.gregtechceu.gtceu.api.addon.GTAddon;
import com.gregtechceu.gtceu.api.addon.IGTAddon;
import com.gregtechceu.gtceu.api.addon.events.MaterialCasingCollectionEvent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOBlocks;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipes;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;
import net.minecraft.data.recipes.FinishedRecipe;

import java.util.function.Consumer;

@GTAddon
public class GTMFOAddon implements IGTAddon {
    @Override
    public GTRegistrate getRegistrate() {
        return GTMFORegistries.REGISTRATE;
    }

    @Override
    public void initializeAddon() {

    }

    @Override
    public void collectMaterialCasings(MaterialCasingCollectionEvent event) {
        GTMFOBlocks.collectMaterialCasings(event);
    }

    @Override
    public void addRecipes(Consumer<FinishedRecipe> provider) {
        GTMFORecipes.init(provider);
    }

    @Override
    public String addonModId() {
        return GregTechModernFoodOption.MODID;
    }
}
