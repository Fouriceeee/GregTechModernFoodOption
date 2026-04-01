package com.ironsword.gregtechmodernfoodoption.api.phy;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BoxBuilder {
    protected double x,y,z,X,Y,Z;

    public BoxBuilder(double x, double y, double z, double X, double Y, double Z){
        this.x = x;
        this.y = y;
        this.z = z;
        this.X = X;
        this.Y = Y;
        this.Z = Z;
    }

    protected BoxBuilder(){}

    public static BoxBuilder box(){return new BoxBuilder();}

    public BoxBuilder from(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
        return this;
    }

    public BoxBuilder to(double X, double Y, double Z){
        this.X = X;
        this.Y = Y;
        this.Z = Z;
        return this;
    }

    public BoxBuilder rotate(Direction direction){
        if (direction.equals(Direction.EAST)){
            return new BoxBuilder(16 - Z, y, x, 16 - z, Y, X);
        }else if (direction.equals(Direction.SOUTH)){
            return new BoxBuilder(16 - X, y, 16 - Z, 16 - x, Y, 16 - z);
        }else if (direction.equals(Direction.WEST)){
            return new BoxBuilder(z, y, 16 - X, Z, Y, 16 - x);
        }
        return this;
    }

    public BoxBuilder flip(Direction.Axis axis){
        if (axis.equals(Direction.Axis.X)){
            double t = x;
            x = X;
            X = t;
        }else if (axis.equals(Direction.Axis.Y)){
            double t = y;
            y = Y;
            Y = t;
        }else if (axis.equals(Direction.Axis.Z)){
            double t = z;
            z = Z;
            Z = t;
        }
        return this;
    }

    public VoxelShape build(){
        return Block.box(x,y,z,X,Y,Z);
    }

    public VoxelShape[] buildBoxes(){
        return new VoxelShape[]{
                this.build(),
                this.rotate(Direction.EAST).build(),
                this.rotate(Direction.SOUTH).build(),
                this.rotate(Direction.WEST).build()};
    }

}
