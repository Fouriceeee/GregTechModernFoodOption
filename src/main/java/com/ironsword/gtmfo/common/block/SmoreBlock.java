package com.ironsword.gtmfo.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SmoreBlock extends Block {
    public static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(5.5, 0, 3.5, 10.5, 4, 12.5),
            Block.box(5.5, 0, 3.5, 10.5, 8, 12.5),
            Block.box(5.5, 0, 3.5, 10.5, 14, 12.5),
            Block.box(5.5, 0, 3.5, 10.5, 15, 12.5),
            Block.box(5.5, 0, 3.5, 10.5, 15.5, 12.5),
            Block.box(5.5, 0, 3.5, 10.5, 46, 12.5)
    };
    public final int height;


    public SmoreBlock(Properties pProperties,int height) {
        super(pProperties);
        this.height = height;
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPES[height];
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {
        return pDirection == Direction.DOWN && !pState.canSurvive(pLevel, pPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return pLevel.getBlockState(pPos.below()).isSolid();
    }
}
