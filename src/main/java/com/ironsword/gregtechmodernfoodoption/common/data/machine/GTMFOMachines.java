package com.ironsword.gregtechmodernfoodoption.common.data.machine;

import com.gregtechceu.gtceu.api.machine.MachineDefinition;
import com.gregtechceu.gtceu.common.data.machines.GTMachineUtils;
import com.ironsword.gregtechmodernfoodoption.common.data.recipe.GTMFORecipeTypes;

import static com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries.REGISTRATE;

public class GTMFOMachines {

    public static MachineDefinition[] SLICE = GTMachineUtils.registerSimpleMachines(REGISTRATE,"slicer", GTMFORecipeTypes.SLICER_RECIPES);
    public static MachineDefinition[] CUISINE_ASSEMBLER = GTMachineUtils.registerSimpleMachines(REGISTRATE,"cuisine_assembler",GTMFORecipeTypes.CUISINE_ASSEMBLER_RECIPES);
    public static MachineDefinition[] MICROWAVE = GTMachineUtils.registerSimpleMachines(REGISTRATE,"microwave",GTMFORecipeTypes.MICROWAVE_RECIPES);
    public static MachineDefinition[] MULTICOOKER = GTMachineUtils.registerSimpleMachines(REGISTRATE,"multicooker",GTMFORecipeTypes.MULTICOOKER_RECIPES);

    public static void init(){}
}
