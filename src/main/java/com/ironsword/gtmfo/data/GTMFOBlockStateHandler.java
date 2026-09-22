package com.ironsword.gtmfo.data;

import com.gregtechceu.gtceu.api.registry.registrate.provider.GTBlockstateProvider;

import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;

public class GTMFOBlockStateHandler {

    private static final ResourceLocation CUTOUT = ResourceLocation.withDefaultNamespace("cutout");

    public static void init(GTBlockstateProvider provider) {
        bushBlock(provider);
    }

    private static void bushBlock(GTBlockstateProvider provider) {
        BlockModelProvider models = provider.models();
        final ModelFile BLOCK = models.getExistingFile(ResourceLocation.withDefaultNamespace("block/block"));

        // down（长在泥土上的完整方块）
        models.getBuilder("block/parent/fruit_bush/down").parent(BLOCK)
                .element().cube("#bush").end()
                .element().allFaces((dir, face) -> face.texture("#overlay")
                        .tintindex(0).cullface(dir))
                .end()
                .renderType(CUTOUT);

        // up
        models.getBuilder("block/parent/fruit_bush/up").parent(BLOCK)
                .element().from(2, 0, 2).to(14, 4, 14)
                .face(Direction.NORTH).uvs(2, 6, 14, 10).texture("#bush").end()
                .face(Direction.EAST).uvs(2, 6, 14, 10).texture("#bush").end()
                .face(Direction.SOUTH).uvs(2, 6, 14, 10).texture("#bush").end()
                .face(Direction.WEST).uvs(2, 6, 14, 10).texture("#bush").end()
                .face(Direction.UP).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.DOWN).uvs(2, 2, 14, 14).texture("#bush").end()
                .end()
                .element().from(2, 0, 2).to(14, 4, 14)
                .face(Direction.NORTH).uvs(2, 6, 14, 10).texture("#overlay").tintindex(0).end()
                .face(Direction.EAST).uvs(2, 6, 14, 10).texture("#overlay").tintindex(0).end()
                .face(Direction.SOUTH).uvs(2, 6, 14, 10).texture("#overlay").tintindex(0).end()
                .face(Direction.WEST).uvs(2, 6, 14, 10).texture("#overlay").tintindex(0).end()
                .face(Direction.UP).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.DOWN).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .end()
                .renderType(CUTOUT);

        // north
        models.getBuilder("block/parent/fruit_bush/north").parent(BLOCK)
                .element().from(2, 2, 0).to(14, 14, 4)
                .face(Direction.NORTH).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.EAST).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.SOUTH).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.WEST).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.UP).uvs(2, 6, 14, 10).texture("#bush").end()
                .face(Direction.DOWN).uvs(2, 6, 14, 10).texture("#bush").end()
                .end()
                .element().from(2, 2, 0).to(14, 14, 4)
                .face(Direction.NORTH).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.EAST).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.SOUTH).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.WEST).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.UP).uvs(2, 6, 14, 10).texture("#overlay").tintindex(0).end()
                .face(Direction.DOWN).uvs(2, 6, 14, 10).texture("#overlay").tintindex(0).end()
                .end()
                .renderType(CUTOUT);

        // south
        models.getBuilder("block/parent/fruit_bush/south").parent(BLOCK)
                .element().from(2, 2, 12).to(14, 14, 16)
                .face(Direction.NORTH).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.EAST).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.SOUTH).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.WEST).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.UP).uvs(2, 6, 14, 10).texture("#bush").end()
                .face(Direction.DOWN).uvs(2, 6, 14, 10).texture("#bush").end()
                .end()
                .element().from(2, 2, 12).to(14, 14, 16)
                .face(Direction.NORTH).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.EAST).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.SOUTH).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.WEST).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.UP).uvs(2, 6, 14, 10).texture("#overlay").tintindex(0).end()
                .face(Direction.DOWN).uvs(2, 6, 14, 10).texture("#overlay").tintindex(0).end()
                .end()
                .renderType(CUTOUT);

        // east
        models.getBuilder("block/parent/fruit_bush/east").parent(BLOCK)
                .element().from(12, 2, 2).to(16, 14, 14)
                .face(Direction.NORTH).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.EAST).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.SOUTH).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.WEST).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.UP).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.DOWN).uvs(6, 2, 10, 14).texture("#bush").end()
                .end()
                .element().from(12, 2, 2).to(16, 14, 14)
                .face(Direction.NORTH).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.EAST).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.SOUTH).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.WEST).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.UP).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.DOWN).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .end()
                .renderType(CUTOUT);

        // west
        models.getBuilder("block/parent/fruit_bush/west").parent(BLOCK)
                .element().from(0, 2, 2).to(4, 14, 14)
                .face(Direction.NORTH).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.EAST).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.SOUTH).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.WEST).uvs(2, 2, 14, 14).texture("#bush").end()
                .face(Direction.UP).uvs(6, 2, 10, 14).texture("#bush").end()
                .face(Direction.DOWN).uvs(6, 2, 10, 14).texture("#bush").end()
                .end()
                .element().from(0, 2, 2).to(4, 14, 14)
                .face(Direction.NORTH).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.EAST).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.SOUTH).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.WEST).uvs(2, 2, 14, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.UP).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .face(Direction.DOWN).uvs(6, 2, 10, 14).texture("#overlay").tintindex(0).end()
                .end()
                .renderType(CUTOUT);
    }
}
