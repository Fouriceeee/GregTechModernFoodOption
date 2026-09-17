package com.ironsword.gtmfo.common.data;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.block.FruitBushBlock;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;

public class GTMFOModels {

    public static <T extends FruitBushBlock> NonNullBiConsumer<DataGenContext<Block,T>, RegistrateBlockstateProvider> fruitBushModel(ResourceLocation flowerOverlay, ResourceLocation fruitOverlay){
        return (ctx, prov)->{
            prov.getVariantBuilder(ctx.getEntry())
                    .forAllStates(state -> {
                        int age = state.getValue(FruitBushBlock.AGE);
                        Direction direction = state.getValue(FruitBushBlock.FACING);

                        ModelFile parent = prov.models().getExistingFile(GregTechModernFoodOption.id("block/parent/fruit_bush/%s".formatted(direction.getName())));
                        ModelBuilder<?> model = prov.models().getBuilder("block/fruit_bush/%s/stage_%d/%s".formatted(ctx.getName(),age,direction.getName())).parent(parent);
                        model.texture("bush",GregTechModernFoodOption.id("block/fruit_bush/bush"));
                        model.texture("particle",GregTechModernFoodOption.id("block/fruit_bush/bush"));
                        model.texture("overlay",switch (age){
                            case 1 -> flowerOverlay;
                            case 2 -> fruitOverlay;
                            default -> GregTechModernFoodOption.id("block/fruit_bush/blank");
                        });


                        return ConfiguredModel.builder().modelFile(model).build();
                    });
        };
    }

}
