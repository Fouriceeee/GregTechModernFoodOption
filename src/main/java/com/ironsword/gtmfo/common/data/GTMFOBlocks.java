package com.ironsword.gtmfo.common.data;

import com.gregtechceu.gtceu.api.addon.events.MaterialCasingCollectionEvent;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;

import com.ironsword.gtmfo.common.block.FruitBushBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelBuilder;

import com.ironsword.gtmfo.GregTechModernFoodOption;
import com.ironsword.gtmfo.common.block.PizzaBlock;
import com.ironsword.gtmfo.common.block.SmogusBlock;
import com.ironsword.gtmfo.common.block.SmoreBlock;
import com.ironsword.gtmfo.data.GTMFOProviderTypes;
import com.tterrag.registrate.util.entry.BlockEntry;

import java.util.function.Supplier;

import static com.ironsword.gtmfo.common.registry.GTMFORegistries.REGISTRATE;

public class GTMFOBlocks {

    static {
        REGISTRATE.creativeModeTab(() -> GTMFOCreativeModeTabs.MAIN_TAB);
    }

    private static final ResourceLocation BUSH_FLOWER_OVERLAY = GregTechModernFoodOption.id("block/fruit_bush/flower");
    private static final ResourceLocation BUSH_BERRY_OVERLAY = GregTechModernFoodOption.id("block/fruit_bush/berry");
    private static final ResourceLocation BUSH_CURRANT_OVERLAY = GregTechModernFoodOption.id("block/fruit_bush/currant");

    public static final BlockEntry<FruitBushBlock> BLACKBERRY_BUSH = fruitBush("blackberry_bush", "Blackberry Bush", "黑莓灌木",
            GTMFOItems.BLACKBERRY::asItem, BUSH_BERRY_OVERLAY, 0xFFF0F5, 0x55406B);

    public static final BlockEntry<FruitBushBlock> BLUEBERRY_BUSH = fruitBush("blueberry_bush", "Blueberry Bush", "蓝莓灌木",
            GTMFOItems.BLUEBERRY::asItem, BUSH_BERRY_OVERLAY, 0xF5F5FF, 0x6B93E3);

    public static final BlockEntry<FruitBushBlock> CRANBERRY_BUSH = fruitBush("cranberry_bush", "Cranberry Bush", "蔓越莓灌木",
            GTMFOItems.CRANBERRY::asItem, BUSH_BERRY_OVERLAY, 0xF5F5FF, 0xAC3232);

    public static final BlockEntry<FruitBushBlock> ELDERBERRY_BUSH = fruitBush("elderberry_bush", "Elderberry Bush", "接骨木莓灌木",
            GTMFOItems.ELDERBERRY::asItem, BUSH_BERRY_OVERLAY, 0xFFF0F5, 0x242A38);

    public static final BlockEntry<FruitBushBlock> LINGONBERRY_BUSH = fruitBush("lingonberry_bush", "Lingonberry Bush", "越橘灌木",
            GTMFOItems.LINGONBERRY::asItem, BUSH_BERRY_OVERLAY, 0xFFF0F5, 0xC0041C);

    public static final BlockEntry<FruitBushBlock> RASPBERRY_BUSH = fruitBush("raspberry_bush", "Raspberry Bush", "树莓灌木",
            GTMFOItems.RASPBERRY::asItem, BUSH_BERRY_OVERLAY, 0xFFF0F5, 0xF2637B);

    public static final BlockEntry<FruitBushBlock> STRAWBERRY_BUSH = fruitBush("strawberry_bush", "Strawberry Bush", "草莓灌木",
            GTMFOItems.STRAWBERRY::asItem, BUSH_BERRY_OVERLAY, 0xFFF0F5, 0xE0403C);

    public static final BlockEntry<FruitBushBlock> BLACK_CURRANT_BUSH = fruitBush("black_currant_bush", "Black Currant Bush", "黑加仑灌木",
            GTMFOItems.BLACK_CURRANT::asItem, BUSH_CURRANT_OVERLAY, 0xFFF0F5, 0x55406B);

    public static final BlockEntry<FruitBushBlock> RED_CURRANT_BUSH = fruitBush("red_currant_bush", "Red Currant Bush", "红加仑灌木",
            GTMFOItems.RED_CURRANT::asItem, BUSH_CURRANT_OVERLAY, 0xFFF0F5, 0xE0403C);

    public static final BlockEntry<FruitBushBlock> WHITE_CURRANT_BUSH = fruitBush("white_currant_bush", "White Currant Bush", "白加仑灌木",
            GTMFOItems.WHITE_CURRANT::asItem, BUSH_CURRANT_OVERLAY, 0xFFF0F5, 0xFCF7B8);


    private static BlockEntry<FruitBushBlock> fruitBush(String name, String enLang, String cnLang,
                                                        Supplier<Item> fruitItem, ResourceLocation fruitOverlay, int flowerColor, int fruitColor) {
        return REGISTRATE.block(name,
                        p -> new FruitBushBlock(p, fruitItem, flowerColor, fruitColor))
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG,
                        (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), cnLang))
                .initialProperties(() -> Blocks.SWEET_BERRY_BUSH)
                .blockstate(GTMFOModels.fruitBushModel(BUSH_FLOWER_OVERLAY, fruitOverlay))
                .item(BlockItem::new).model((ctx, prov) -> prov.withExistingParent("item/%s".formatted(ctx.getName()),
                        prov.modLoc("block/fruit_bush/%s/stage_2/down".formatted(ctx.getName()))))
                .build()
                .register();
    }

    // public static final BlockEntry<Block> ADOBE_BRICKS = createBrickCasingBlock("adobe_bricks" ,"Adobe Bricks"
    // ,"土坯砖块" );
    // public static final BlockEntry<Block> REINFORCED_ADOBE_BRICKS =
    // createBrickCasingBlock("reinforced_adobe_bricks","Reinforced Adobe Bricks","加固土坯砖块");
    // public static final BlockEntry<Block> PORCELAIN_TILE = createBrickCasingBlock("porcelain_tile" ,"Porcelain Tile"
    // ,"瓷砖" );
    // public static final BlockEntry<Block> DARK_PORCELAIN_TILE = createBrickCasingBlock("dark_porcelain_tile" ,"Dark
    // Porcelain Tile" ,"暗色瓷砖" );

    public static final BlockEntry<Block> BISMUTH_BRONZE_CASING = createCasingBlock("bismuth_bronze_casing",
            "Food-Safe Bismuth Bronze Casing", "食品级铋青铜机器方块");

    public static final BlockEntry<PizzaBlock> PIZZA_CHEESE = pizza("pizza_cheese", "block/pizza/top_2",
            "block/pizza/cheese", "item/pizza/cheese", "Cheese Pizza", "芝士披萨");
    public static final BlockEntry<PizzaBlock> PIZZA_MEAT = pizza("pizza_meat", "block/pizza/top_1", "block/pizza/meat",
            "item/pizza/meat", "Mince Meat Pizza", "肉末披萨");
    public static final BlockEntry<PizzaBlock> PIZZA_VEGGIE = pizza("pizza_veggie", "block/pizza/top_2",
            "block/pizza/veggie", "item/pizza/veggie", "Olive and Mushroom Pizza", "橄榄蘑菇披萨");

    // public static final BlockEntry<SmoreBlock> SMORE_1 = smore("smore_block_1",0,1,"S1","S1");
    // public static final BlockEntry<SmoreBlock> SMORE_64 = smore("smore_block_64",5,64,"S1","S1");

    public static final BlockEntry<SmogusBlock> SMOGUS_1 = REGISTRATE
            .block("smogus_block_1", p -> new SmogusBlock(p, 0))
            .initialProperties(() -> Blocks.CAKE)
            .lang("S'mogus S'mingot")
            .setData(GTMFOProviderTypes.CNLANG, (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), "牛奶巧克力棉花糖夹心内鬼饼干"))
            .blockstate((ctx, prov) -> prov.getVariantBuilder(ctx.getEntry())
                    .partialState().setModels(
                            ConfiguredModel.builder()
                                    .modelFile(prov.models()
                                            .getExistingFile(GregTechModernFoodOption.id("block/smore/sus1")))
                                    .build()))
            .register();

    public static final BlockEntry<SmogusBlock> SMOGUS_2 = REGISTRATE
            .block("smogus_block_2", p -> new SmogusBlock(p, 1))
            .initialProperties(() -> Blocks.CAKE)
            .lang("MultiS'mogus GrandS'mingot")
            .setData(GTMFOProviderTypes.CNLANG,
                    (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), "多重牛奶巧克力棉花糖夹心内鬼饼干"))
            .blockstate((ctx, prov) -> prov.getVariantBuilder(ctx.getEntry())
                    .partialState().setModels(
                            ConfiguredModel.builder()
                                    .modelFile(prov.models()
                                            .getExistingFile(GregTechModernFoodOption.id("block/smore/sus2")))
                                    .build()))
            .register();

    public static final BlockEntry<SmogusBlock> SMOGUS_4 = REGISTRATE
            .block("smogus_block_4", p -> new SmogusBlock(p, 2))
            .initialProperties(() -> Blocks.CAKE)
            .lang("AllS'mogus OmniS'mingot")
            .setData(GTMFOProviderTypes.CNLANG,
                    (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), "全能牛奶巧克力棉花糖夹心内鬼饼干"))
            .blockstate((ctx, prov) -> prov.getVariantBuilder(ctx.getEntry())
                    .partialState().setModels(
                            ConfiguredModel.builder()
                                    .modelFile(prov.models()
                                            .getExistingFile(GregTechModernFoodOption.id("block/smore/sus4")))
                                    .build()))
            .register();

    public static final BlockEntry<SmogusBlock> SMOGUS_HEART = REGISTRATE
            .block("smogus_heart_block", p -> new SmogusBlock(p, 3))
            .initialProperties(() -> Blocks.CAKE)
            .lang("Heart of the S'mogus")
            .setData(GTMFOProviderTypes.CNLANG, (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), "夹心内鬼饼干之心"))
            .blockstate((ctx, prov) -> prov.getVariantBuilder(ctx.getEntry())
                    .partialState().setModels(
                            ConfiguredModel.builder()
                                    .modelFile(prov.models()
                                            .getExistingFile(GregTechModernFoodOption.id("block/smore/heart")))
                                    .build()))
            .register();

    public static void collectMaterialCasings(MaterialCasingCollectionEvent event) {
        event.add(GTMaterials.BismuthBronze, BISMUTH_BRONZE_CASING);
    }

    private static BlockEntry<Block> createBrickCasingBlock(String id, String enLang, String cnLang) {
        return REGISTRATE.block(id, Block::new)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), cnLang))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .defaultBlockstate()
                .tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .simpleItem()
                .register();
    }

    private static BlockEntry<Block> createCasingBlock(String id, String enLang, String cnLang) {
        return REGISTRATE.block(id, Block::new)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), cnLang))
                .initialProperties(() -> Blocks.IRON_BLOCK)
                .properties(p -> p.isValidSpawn((state, level, pos, ent) -> false))
                .defaultBlockstate()
                .tag(CustomTags.MINEABLE_WITH_CONFIG_VALID_PICKAXE_WRENCH)
                .simpleItem()
                .register();
    }

    private static BlockEntry<PizzaBlock> pizza(String id, String topTexturePath, String layerTexturePath,
                                                String itemTexture, String enLang, String cnLang) {
        return REGISTRATE.block(id, PizzaBlock::new)
                .initialProperties(() -> Blocks.CAKE)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), cnLang))
                // .addLayer(()-> RenderType::cutout)
                .blockstate((ctx, prov) -> {
                    prov.getVariantBuilder(ctx.getEntry()).forAllStates((state) -> {
                        int slices = state.getValue(PizzaBlock.SLICES);
                        ModelBuilder<?> model = prov.models().withExistingParent(
                                        "block/" + id + "_slice" + slices,
                                        GregTechModernFoodOption.id("block/pizza/pizza_slice" + slices))
                                .texture("particle", GregTechModernFoodOption.id(topTexturePath))
                                .texture("top", GregTechModernFoodOption.id(topTexturePath))
                                .texture("layer", GregTechModernFoodOption.id(layerTexturePath));
                        return ConfiguredModel.builder().modelFile(model).build();
                    });
                })
                // TODO: rewrite loots
                .loot((table, block) -> table.dropOther(block, Items.AIR))
                .item().model((ctx, prov) -> prov.generated(ctx::getEntry, prov.modLoc(itemTexture))).build()
                .register();
    }

    private static BlockEntry<SmoreBlock> smore(String id, int height, int number, String enLang, String cnLang) {
        return REGISTRATE.block(id, p -> new SmoreBlock(p, height))
                .initialProperties(() -> Blocks.CAKE)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx, prov) -> prov.add(ctx.get().getDescriptionId(), cnLang))
                .blockstate((ctx, prov) ->
                        // ConfiguredModel.builder().modelFile(prov.models().getExistingFile(GregTechModernFoodOption.id("block/smore/"+number))).build()
                        prov.getVariantBuilder(ctx.getEntry())
                                .partialState().setModels(
                                        ConfiguredModel.builder()
                                                .modelFile(prov.models()
                                                        .getExistingFile(GregTechModernFoodOption.id("block/smore/" + number)))
                                                .build()))
                .register();
    }

    public static void init() {}
}
