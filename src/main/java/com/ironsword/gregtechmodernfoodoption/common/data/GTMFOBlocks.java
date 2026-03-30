package com.ironsword.gregtechmodernfoodoption.common.data;

import com.gregtechceu.gtceu.api.addon.events.MaterialCasingCollectionEvent;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.common.block.PizzaBlock;
import com.ironsword.gregtechmodernfoodoption.common.block.SmogusBlock;
import com.ironsword.gregtechmodernfoodoption.common.block.SmoreBlock;
import com.ironsword.gregtechmodernfoodoption.data.GTMFOProviderTypes;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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

    private static BlockEntry<PizzaBlock> pizza(String id, String topTexturePath, String layerTexturePath, String itemTexture ,String enLang, String cnLang){
        return REGISTRATE.block(id, PizzaBlock::new)
                .initialProperties(()->Blocks.CAKE)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
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
                //TODO: rewrite loots
                .loot((table,block)->table.dropOther(block, Items.AIR))
                .item().model((ctx,prov)-> prov.generated(ctx::getEntry,prov.modLoc(itemTexture))).build()
                .register();
    }

    private static BlockEntry<SmoreBlock> smore(String id, int height,int number ,String enLang, String cnLang){
        return REGISTRATE.block(id, p->new SmoreBlock(p,height))
                .initialProperties(()->Blocks.CAKE)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .blockstate((ctx,prov)->
                        //ConfiguredModel.builder().modelFile(prov.models().getExistingFile(GregTechModernFoodOption.id("block/smore/"+number))).build()
                        prov.getVariantBuilder(ctx.getEntry())
                                .partialState().setModels(
                                        ConfiguredModel.builder().modelFile(prov.models().getExistingFile(GregTechModernFoodOption.id("block/smore/"+number))).build())
                )
                .register();
    }


//    public static final BlockEntry<Block> ADOBE_BRICKS            = createBrickCasingBlock("adobe_bricks"           ,"Adobe Bricks"           ,"土坯砖块"    );
//    public static final BlockEntry<Block> REINFORCED_ADOBE_BRICKS = createBrickCasingBlock("reinforced_adobe_bricks","Reinforced Adobe Bricks","加固土坯砖块");
//    public static final BlockEntry<Block> PORCELAIN_TILE          = createBrickCasingBlock("porcelain_tile"         ,"Porcelain Tile"         ,"瓷砖"        );
//    public static final BlockEntry<Block> DARK_PORCELAIN_TILE     = createBrickCasingBlock("dark_porcelain_tile"    ,"Dark Porcelain Tile"    ,"暗色瓷砖"    );

    public static final BlockEntry<Block> BISMUTH_BRONZE_CASING = createCasingBlock("bismuth_bronze_casing","Food-Safe Bismuth Bronze Casing","食品级铋青铜机器方块");

    public static final BlockEntry<PizzaBlock> PIZZA_CHEESE = pizza("pizza_cheese","block/pizza/top_2","block/pizza/cheese","item/pizza/cheese","Cheese Pizza"            ,"芝士披萨"    );
    public static final BlockEntry<PizzaBlock> PIZZA_MEAT   = pizza("pizza_meat"  ,"block/pizza/top_1","block/pizza/meat"  ,"item/pizza/meat"  ,"Mince Meat Pizza"        ,"肉末披萨"    );
    public static final BlockEntry<PizzaBlock> PIZZA_VEGGIE = pizza("pizza_veggie","block/pizza/top_2","block/pizza/veggie","item/pizza/veggie","Olive and Mushroom Pizza","橄榄蘑菇披萨");

//    public static final BlockEntry<SmoreBlock> SMORE_1 = smore("smore_block_1",0,1,"S1","S1");
//    public static final BlockEntry<SmoreBlock> SMORE_64 = smore("smore_block_64",5,64,"S1","S1");

    public static final BlockEntry<SmogusBlock> SMOGUS_1 = REGISTRATE.block("smogus_block_1", p->new SmogusBlock(p,0))
            .initialProperties(() -> Blocks.CAKE)
            .lang("S'mogus S'mingot")
            .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                    prov.add(ctx.get().getDescriptionId(),"牛奶巧克力棉花糖夹心内鬼饼干"))
            .blockstate((ctx,prov)->
                            prov.getVariantBuilder(ctx.getEntry())
                                    .partialState().setModels(
                                            ConfiguredModel.builder().modelFile(prov.models().getExistingFile(GregTechModernFoodOption.id("block/smore/sus1"))).build())
                    )
            .register();

    public static final BlockEntry<SmogusBlock> SMOGUS_2 = REGISTRATE.block("smogus_block_2", p->new SmogusBlock(p,1))
            .initialProperties(() -> Blocks.CAKE)
            .lang("MultiS'mogus GrandS'mingot")
            .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                    prov.add(ctx.get().getDescriptionId(),"多重牛奶巧克力棉花糖夹心内鬼饼干"))
            .blockstate((ctx,prov)->
                    prov.getVariantBuilder(ctx.getEntry())
                            .partialState().setModels(
                                    ConfiguredModel.builder().modelFile(prov.models().getExistingFile(GregTechModernFoodOption.id("block/smore/sus2"))).build())
            )
            .register();

    public static final BlockEntry<SmogusBlock> SMOGUS_4 = REGISTRATE.block("smogus_block_4", p->new SmogusBlock(p,2))
            .initialProperties(() -> Blocks.CAKE)
            .lang("AllS'mogus OmniS'mingot")
            .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                    prov.add(ctx.get().getDescriptionId(),"全能牛奶巧克力棉花糖夹心内鬼饼干"))
            .blockstate((ctx,prov)->
                    prov.getVariantBuilder(ctx.getEntry())
                            .partialState().setModels(
                                    ConfiguredModel.builder().modelFile(prov.models().getExistingFile(GregTechModernFoodOption.id("block/smore/sus4"))).build())
            )
            .register();

    public static final BlockEntry<SmogusBlock> SMOGUS_HEART = REGISTRATE.block("smogus_heart_block", p->new SmogusBlock(p,3))
            .initialProperties(() -> Blocks.CAKE)
            .lang("Heart of the S'mogus")
            .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                    prov.add(ctx.get().getDescriptionId(),"夹心内鬼饼干之心"))
            .blockstate((ctx,prov)->
                    prov.getVariantBuilder(ctx.getEntry())
                            .partialState().setModels(
                                    ConfiguredModel.builder().modelFile(prov.models().getExistingFile(GregTechModernFoodOption.id("block/smore/heart"))).build())
            )
            .register();

    public static void collectMaterialCasings(MaterialCasingCollectionEvent event){
        event.add(GTMaterials.BismuthBronze,BISMUTH_BRONZE_CASING);
    }

    public static void init(){}
}
