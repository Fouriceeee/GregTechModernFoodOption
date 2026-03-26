package com.ironsword.gregtechmodernfoodoption.common.data;

import com.gregtechceu.gtceu.api.addon.events.MaterialCasingCollectionEvent;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.common.block.PizzaBlock;
import com.ironsword.gregtechmodernfoodoption.data.GTMFOProviderTypes;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;

import java.util.function.Supplier;

import static com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries.REGISTRATE;

public class GTMFOBlocks {

    static {
        REGISTRATE.creativeModeTab(()->GTMFOCreativeModeTabs.MAIN_TAB);
    }

    private static BlockEntry<Block> createBrickCasingBlock(String id, String enLang, String cnLang){
        return REGISTRATE.block(id, Block::new)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx, prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .defaultBlockstate()
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .simpleItem()
                .register();
    }

    private static BlockEntry<Block> createCasingBlock(String id, String enLang, String cnLang){
        return REGISTRATE.block(id, Block::new)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx, prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .defaultBlockstate()
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .simpleItem()
                .register();
    }

    private static BlockEntry<PizzaBlock> pizza(String id, Supplier<Item> slice, String topTexturePath, String layerTexturePath){
        return REGISTRATE.block(id, properties -> new PizzaBlock(properties,slice))
                .initialProperties(()->Blocks.CAKE)
                //.addLayer(()-> RenderType::cutout)
                .blockstate((ctx,prov)->{
                    prov.getVariantBuilder(ctx.getEntry()).forAllStates((state)->{
                        int slices = state.getValue(PizzaBlock.SLICES);
                        ModelBuilder<?> model = prov.models().withExistingParent(
                                        "block/"+id+"_slice"+slices,
                                        GregTechModernFoodOption.id("block/pizza/pizza_slice"+slices))
                                .texture("particle",GregTechModernFoodOption.id(topTexturePath))
                                .texture("top",GregTechModernFoodOption.id(topTexturePath))
                                .texture("layer",GregTechModernFoodOption.id(layerTexturePath));
                        return ConfiguredModel.builder().modelFile(model).build();
                    });
                })
                .item().model((ctx,prov)->{
                    prov.withExistingParent(ctx.getName(),GregTechModernFoodOption.id("block/"+id+"_slice4"));
                }).build().register();
    }


    public static final BlockEntry<Block> ADOBE_BRICKS            = createBrickCasingBlock("adobe_bricks"           ,"Adobe Bricks"           ,"土坯砖块"    );
    public static final BlockEntry<Block> REINFORCED_ADOBE_BRICKS = createBrickCasingBlock("reinforced_adobe_bricks","Reinforced Adobe Bricks","加固土坯砖块");
    public static final BlockEntry<Block> PORCELAIN_TILE          = createBrickCasingBlock("porcelain_tile"         ,"Porcelain Tile"         ,"瓷砖"        );
    public static final BlockEntry<Block> DARK_PORCELAIN_TILE     = createBrickCasingBlock("dark_porcelain_tile"    ,"Dark Porcelain Tile"    ,"暗色瓷砖"    );

    public static final BlockEntry<Block> BISMUTH_BRONZE_CASING = createCasingBlock("bismuth_bronze_casing","Food-Safe Bismuth Bronze Casing","食品级铋青铜机器方块");

    public static final BlockEntry<PizzaBlock> PIZZA_CHEESE_BLOCK = pizza("pizza_cheese_block",GTMFOItems.PIZZA_CHEESE_SLICE,"block/pizza/top_2","block/pizza/cheese");
    public static final BlockEntry<PizzaBlock> PIZZA_MINCE_MEAT_BLOCK = pizza("pizza_mince_meat_block",GTMFOItems.PIZZA_MEAT_SLICE,"block/pizza/top_1","block/pizza/mince_meat");
    public static final BlockEntry<PizzaBlock> PIZZA_VEGGIE_BLOCK = pizza("pizza_veggie_block",GTMFOItems.PIZZA_VEGGIE_SLICE,"block/pizza/top_2","block/pizza/veggie");

    public static void collectMaterialCasings(MaterialCasingCollectionEvent event){
        event.add(GTMaterials.BismuthBronze,BISMUTH_BRONZE_CASING);
    }

    public static void init(){}
}
