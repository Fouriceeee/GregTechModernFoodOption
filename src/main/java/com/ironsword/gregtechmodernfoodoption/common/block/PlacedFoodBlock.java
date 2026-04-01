package com.ironsword.gregtechmodernfoodoption.common.block;

import com.ironsword.gregtechmodernfoodoption.GTMFOUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PlacedFoodBlock extends HorizontalDirectionalBlock {
    protected final VoxelShape[] shapes;

    protected PlacedFoodBlock(Properties pProperties,VoxelShape[] shapes) {
        super(pProperties);
        this.shapes = shapes;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)){
            case EAST -> shapes[1];
            case SOUTH -> shapes[2];
            case WEST -> shapes[3];
            default -> shapes[0];
        };
    }
}
