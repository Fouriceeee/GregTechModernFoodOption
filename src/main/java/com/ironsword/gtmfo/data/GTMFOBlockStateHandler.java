package com.ironsword.gtmfo.data;

import com.gregtechceu.gtceu.api.registry.registrate.provider.GTBlockstateProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.loaders.CompositeModelBuilder;

public class GTMFOBlockStateHandler {
    public static void init(GTBlockstateProvider provider){
        bushBlock(provider);
    }

    private static void bushBlock(GTBlockstateProvider provider){
        BlockModelProvider models = provider.models();
        final ModelFile BLOCK = models.getExistingFile(ResourceLocation.withDefaultNamespace("block/block"));

        // down
        BlockModelBuilder down = models.getBuilder("block/bush/parent/down_body").parent(BLOCK)
                .element().cube("#bush").end();
        BlockModelBuilder down_overlay = models.getBuilder("block/bush/parent/down_overlay").parent(BLOCK)
                .element().cube("#overlay").end();
        models.getBuilder("block/bush/parent/down").customLoader(CompositeModelBuilder::begin)
                .child("body",down)
                .child("overlay",down_overlay)
                .end();

        // up
        BlockModelBuilder up = models.getBuilder("block/bush/parent/up_body")
                .element().from(2,0,2).to(14,4,14)
                .face(Direction.NORTH).uvs(2,6,14,10).texture("#bush").end()
                .face(Direction.EAST).uvs(2,6,14,10).texture("#bush").end()
                .face(Direction.SOUTH).uvs(2,6,14,10).texture("#bush").end()
                .face(Direction.WEST).uvs(2,6,14,10).texture("#bush").end()
                .face(Direction.UP).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.DOWN).uvs(2,2,14,14).texture("#bush").end()
                .end();
        BlockModelBuilder up_overlay = models.getBuilder("block/bush/parent/up_overlay")
                .element().from(2,0,2).to(14,4,14)
                .face(Direction.NORTH).uvs(2,6,14,10).texture("#overlay").end()
                .face(Direction.EAST).uvs(2,6,14,10).texture("#overlay").end()
                .face(Direction.SOUTH).uvs(2,6,14,10).texture("#overlay").end()
                .face(Direction.WEST).uvs(2,6,14,10).texture("#overlay").end()
                .face(Direction.UP).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.DOWN).uvs(2,2,14,14).texture("#overlay").end()
                .end();
        models.getBuilder("block/bush/parent/up").customLoader(CompositeModelBuilder::begin)
                .child("body",up)
                .child("overlay",up_overlay)
                .end();

        // north
        BlockModelBuilder north = models.getBuilder("block/bush/parent/north_body")
                .element().from(2,2,0).to(14,14,4)
                .face(Direction.NORTH).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.EAST).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.SOUTH).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.WEST).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.UP).uvs(2,6,14,10).texture("#bush").end()
                .face(Direction.DOWN).uvs(2,6,14,10).texture("#bush").end()
                .end();
        BlockModelBuilder north_overlay = models.getBuilder("block/bush/parent/north_overlay")
                .element().from(2,2,0).to(14,14,4)
                .face(Direction.NORTH).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.EAST).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.SOUTH).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.WEST).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.UP).uvs(2,6,14,10).texture("#overlay").end()
                .face(Direction.DOWN).uvs(2,6,14,10).texture("#overlay").end()
                .end();
        models.getBuilder("block/bush/parent/north").customLoader(CompositeModelBuilder::begin)
                .child("body",north)
                .child("overlay",north_overlay);

        // south
        BlockModelBuilder south = models.getBuilder("block/bush/parent/south_body")
                .element().from(2,2,12).to(14,14,16)
                .face(Direction.NORTH).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.EAST).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.SOUTH).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.WEST).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.UP).uvs(2,6,14,10).texture("#bush").end()
                .face(Direction.DOWN).uvs(2,6,14,10).texture("#bush").end()
                .end();
        BlockModelBuilder south_overlay = models.getBuilder("block/bush/parent/south_overlay")
                .element().from(2,2,12).to(14,14,16)
                .face(Direction.NORTH).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.EAST).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.SOUTH).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.WEST).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.UP).uvs(2,6,14,10).texture("#overlay").end()
                .face(Direction.DOWN).uvs(2,6,14,10).texture("#overlay").end()
                .end();
        models.getBuilder("block/bush/parent/south").customLoader(CompositeModelBuilder::begin)
                .child("body",south)
                .child("overlay",south_overlay);

        // east
        BlockModelBuilder east = models.getBuilder("block/bush/parent/east_body")
                .element().from(12,2,2).to(16,14,14)
                .face(Direction.NORTH).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.EAST).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.SOUTH).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.WEST).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.UP).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.DOWN).uvs(6,2,10,14).texture("#bush").end()
                .end();
        BlockModelBuilder east_overlay = models.getBuilder("block/bush/parent/east_overlay")
                .element().from(12,2,2).to(16,14,14)
                .face(Direction.NORTH).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.EAST).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.SOUTH).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.WEST).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.UP).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.DOWN).uvs(6,2,10,14).texture("#overlay").end()
                .end();
        models.getBuilder("block/bush/parent/east").customLoader(CompositeModelBuilder::begin)
                .child("body",east)
                .child("overlay",east_overlay);

        // west
        BlockModelBuilder west = models.getBuilder("block/bush/parent/west_body")
                .element().from(0,2,2).to(4,14,14)
                .face(Direction.NORTH).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.EAST).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.SOUTH).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.WEST).uvs(2,2,14,14).texture("#bush").end()
                .face(Direction.UP).uvs(6,2,10,14).texture("#bush").end()
                .face(Direction.DOWN).uvs(6,2,10,14).texture("#bush").end()
                .end();
        BlockModelBuilder west_overlay = models.getBuilder("block/bush/parent/west_overlay")
                .element().from(0,2,2).to(4,14,14)
                .face(Direction.NORTH).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.EAST).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.SOUTH).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.WEST).uvs(2,2,14,14).texture("#overlay").end()
                .face(Direction.UP).uvs(6,2,10,14).texture("#overlay").end()
                .face(Direction.DOWN).uvs(6,2,10,14).texture("#overlay").end()
                .end();
        models.getBuilder("block/bush/parent/west").customLoader(CompositeModelBuilder::begin)
                .child("body",west)
                .child("overlay",west_overlay);
    }
}
