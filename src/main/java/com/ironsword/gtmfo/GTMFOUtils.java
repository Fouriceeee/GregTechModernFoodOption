package com.ironsword.gtmfo;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GTMFOUtils {
    public static final VoxelShape[] EMPTY_SHAPES = {
      Block.box(0,0,0,0,0,0),
      Block.box(0,0,0,0,0,0),
      Block.box(0,0,0,0,0,0),
      Block.box(0,0,0,0,0,0)
    };

    public static VoxelShape[] createHorizontalShapes(final VoxelShape northShape){
        return EMPTY_SHAPES;
    }
}
