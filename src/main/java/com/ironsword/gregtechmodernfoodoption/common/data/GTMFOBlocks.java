package com.ironsword.gregtechmodernfoodoption.common.data;

import com.gregtechceu.gtceu.api.addon.events.MaterialCasingCollectionEvent;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import com.gregtechceu.gtceu.data.recipe.CustomTags;
import com.ironsword.gregtechmodernfoodoption.data.GTMFOProviderTypes;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

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


    public static final BlockEntry<Block> ADOBE_BRICKS            = createBrickCasingBlock("adobe_bricks"           ,"Adobe Bricks"           ,"土坯砖块"    );
    public static final BlockEntry<Block> REINFORCED_ADOBE_BRICKS = createBrickCasingBlock("reinforced_adobe_bricks","Reinforced Adobe Bricks","加固土坯砖块");
    public static final BlockEntry<Block> PORCELAIN_TILE          = createBrickCasingBlock("porcelain_tile"         ,"Porcelain Tile"         ,"瓷砖"        );
    public static final BlockEntry<Block> DARK_PORCELAIN_TILE     = createBrickCasingBlock("dark_porcelain_tile"    ,"Dark Porcelain Tile"    ,"暗色瓷砖"    );

    public static final BlockEntry<Block> BISMUTH_BRONZE_CASING = createCasingBlock("bismuth_bronze_casing","Food-Safe Bismuth Bronze Casing","食品级铋青铜机器方块");


    public static void collectMaterialCasings(MaterialCasingCollectionEvent event){
        event.add(GTMaterials.BismuthBronze,BISMUTH_BRONZE_CASING);
    }

    public static void init(){}
}
