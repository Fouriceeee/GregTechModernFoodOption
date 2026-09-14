package com.ironsword.gtmfo.common.data.recipe;

import com.gregtechceu.gtceu.api.machine.MetaMachine;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.OverclockingLogic;
import com.gregtechceu.gtceu.api.recipe.content.ContentModifier;
import com.gregtechceu.gtceu.api.recipe.modifier.ModifierFunction;
import com.gregtechceu.gtceu.api.recipe.modifier.ParallelLogic;
import com.gregtechceu.gtceu.api.recipe.modifier.RecipeModifier;

import net.minecraft.MethodsReturnNonnullByDefault;

import com.ironsword.gtmfo.common.machine.multiblock.electric.ElectricBakingOvenMachine;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class GTMFORecipeModifiers {

    /**
     * Recipe modifier for the <b>Electric Baking Oven</b>.
     * <p>
     * The parallel amount is capped at {@code 8 × repeatLayers} of the structure, then the recipe is overclocked
     * via {@link OverclockingLogic#NON_PERFECT_OVERCLOCK} and finally its contents are multiplied by the parallels.
     */
    public static @NotNull ModifierFunction electricBakingOvenParallel(MetaMachine machine, GTRecipe recipe) {
        if (!(machine instanceof ElectricBakingOvenMachine bakingOven)) {
            return RecipeModifier.nullWrongType(ElectricBakingOvenMachine.class, machine);
        }

        int maxParallel = bakingOven.getRepeatLayers() * 8;
        int parallels = ParallelLogic.getParallelAmount(machine, recipe, maxParallel);
        if (parallels == 0) return ModifierFunction.NULL;

        var ocModifier = OverclockingLogic.NON_PERFECT_OVERCLOCK.getModifier(machine, recipe,
                bakingOven.getOverclockVoltage());
        var parallelModifier = ModifierFunction.builder()
                .modifyAllContents(ContentModifier.multiplier(parallels))
                .parallels(parallels)
                .build();

        return ocModifier.andThen(parallelModifier);
    }
}
