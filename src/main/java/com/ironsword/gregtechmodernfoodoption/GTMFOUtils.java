package com.ironsword.gregtechmodernfoodoption;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class GTMFOUtils {
    public static int averageRGB(float divisor, int... inputs) {
        int red = 0;
        int green = 0;
        int blue = 0;

        for (int input : inputs) {
            red += (input - (input % ((int) Math.pow(256, 2)))) >> 16 % 256; // Make sure to account for opacity
            green += ((input - (input % 256)) >> 8) % 256; // Removes the last chunk, shifts it out, and removes the first chunk
            blue += input % 256;
        }

        int result = (int) (blue / divisor);
        result += (int) (green / divisor) << 8;
        result += (int) (red / divisor) << 16;

        return result;
    }

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
