package com.ironsword.gtmfo.common.data;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.block.BerryBushBlock;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.fml.common.Mod;

public class GTMFOModels {

    public static <T extends BerryBushBlock> NonNullBiConsumer<DataGenContext<Block,T>, RegistrateBlockstateProvider> berryBushModel(){
        return (ctx, prov)->{
            prov.getVariantBuilder(ctx.getEntry())
                    .forAllStates(state -> {
                        int age = state.getValue(BerryBushBlock.AGE);
                        Direction direction = state.getValue(BerryBushBlock.FACING);

                        ModelFile parent = prov.models().getExistingFile(GregTechModernFoodOption.id("block/bush/parent/%s".formatted(direction.getName())));
                        ModelBuilder<?> model = prov.models().getBuilder("block/%s/stage_%d/%s".formatted(ctx.getName(),age,direction.getName())).parent(parent);
                        model.texture("bush",GregTechModernFoodOption.id("block/bush/bush"));
                        model.texture("overlay",GregTechModernFoodOption.id("block/bush/%s".formatted(switch (age){
                            case 1 -> "flower";
                            case 2 -> "berry";
                            default -> "blank";
                        })));


                        return ConfiguredModel.builder().modelFile(model).build();
                    });
        };
    }

}
