package com.ironsword.gtmfo.common.block;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class WoodBlock extends RotatedPillarBlock {
    protected final Supplier<? extends RotatedPillarBlock> stripedWood;

    public WoodBlock(Properties pProperties, Supplier<? extends RotatedPillarBlock> stripedWood) {
        super(pProperties);
        this.stripedWood = stripedWood;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction,
                                                     boolean simulate) {
        if (toolAction == ToolActions.AXE_STRIP) {
            return stripedWood.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS,
                    state.getValue(RotatedPillarBlock.AXIS));
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
