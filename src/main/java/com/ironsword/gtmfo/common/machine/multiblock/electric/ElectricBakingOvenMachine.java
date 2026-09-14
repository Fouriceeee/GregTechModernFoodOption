package com.ironsword.gtmfo.common.machine.multiblock.electric;

import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.multiblock.WorkableElectricMultiblockMachine;
import com.gregtechceu.gtceu.api.pattern.Predicates;
import com.gregtechceu.gtceu.api.pattern.TraceabilityPredicate;

import com.lowdragmc.lowdraglib.utils.BlockInfo;

import net.minecraft.MethodsReturnNonnullByDefault;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class ElectricBakingOvenMachine extends WorkableElectricMultiblockMachine {

    /** Amount of repeated layers of the structure, same as the original GTFO's size: repeat count - 1 */
    private int repeatLayers = 1;

    public ElectricBakingOvenMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
    }

    /**
     * Indicator predicate used to measure the length of the structure.
     * <p>
     * It matches the air position inside the repeatable slice, so it is incremented once per repeated layer.
     */
    public static TraceabilityPredicate lengthIndicator() {
        return Predicates.custom(state -> {
            if (!state.getWorld().isEmptyBlock(state.getPos())) return false;
            state.getMatchContext().increment("length", 1);
            return true;
        }, () -> new BlockInfo[] { BlockInfo.EMPTY });
    }

    @Override
    public void onStructureFormed() {
        super.onStructureFormed();
        this.repeatLayers = Math.max(1, getMultiblockState().getMatchContext().getInt("length") - 1);
    }

    @Override
    public void onStructureInvalid() {
        super.onStructureInvalid();
        this.repeatLayers = 1;
    }

    public int getRepeatLayers() {
        return repeatLayers;
    }
}
