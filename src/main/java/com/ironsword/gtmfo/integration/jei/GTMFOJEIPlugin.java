package com.ironsword.gtmfo.integration.jei;

import net.minecraft.resources.ResourceLocation;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.data.machine.GTMFOMultiMachines;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class GTMFOJEIPlugin implements IModPlugin {

    @NotNull
    @Override
    public ResourceLocation getPluginUid() {
        return GregTechModernFoodOption.id("jei_plugin");
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(GTMFOMultiMachines.PRIMITIVE_BAKING_OVEN.asStack(), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(GTMFOMultiMachines.STEAM_BAKING_OVEN.asStack(), RecipeTypes.SMOKING);
        registration.addRecipeCatalyst(GTMFOMultiMachines.ELECTRIC_BAKING_OVEN.asStack(), RecipeTypes.SMOKING);
    }
}
