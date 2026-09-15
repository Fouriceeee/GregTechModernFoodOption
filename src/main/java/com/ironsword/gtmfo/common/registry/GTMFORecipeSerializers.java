package com.ironsword.gtmfo.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.recipe.NonConsumingShapedRecipe;

public class GTMFORecipeSerializers {

    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister
            .create(Registries.RECIPE_SERIALIZER, GregTechModernFoodOption.MODID);

    public static final RegistryObject<RecipeSerializer<?>> NON_CONSUMABLE_SHAPED = RECIPE_SERIALIZERS
            .register("non_consuming_shaped", () -> NonConsumingShapedRecipe.SERIALIZER);

    public static void init(IEventBus bus) {
        RECIPE_SERIALIZERS.register(bus);
    }
}
