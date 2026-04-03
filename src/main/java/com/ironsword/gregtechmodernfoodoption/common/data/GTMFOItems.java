package com.ironsword.gregtechmodernfoodoption.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.ironsword.gregtechmodernfoodoption.api.item.ExComponentItem;
import com.ironsword.gregtechmodernfoodoption.api.item.component.BlockItemComponent;
import com.ironsword.gregtechmodernfoodoption.api.item.component.GTMFOFoodStats;
import com.ironsword.gregtechmodernfoodoption.data.GTMFOProviderTypes;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries.REGISTRATE;

//@SuppressWarnings("unused")
public class GTMFOItems {
    private static final String CN = "占位文本";

    static{
        REGISTRATE.creativeModeTab(()-> GTMFOCreativeModeTabs.MAIN_TAB);
    }

    private static <T extends ComponentItem> NonNullConsumer<T> attach(IItemComponent... components) {
        return item -> item.attachComponents(components);
    }

    private static ItemEntry<Item> item(String id,String enLang,String cnLang){
        return REGISTRATE.item(id,Item::new)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .defaultModel()
                .register();
    }

    private static ItemEntry<Item> item(String id,String enLang,String cnLang,Item.Properties properties){
        return REGISTRATE.item(id,Item::new)
                .lang(enLang)
                .initialProperties(()->properties)
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .defaultModel()
                .register();
    }

    private static ItemEntry<Item> item(String id, String enLang, String cnLang, String path){
        return REGISTRATE.item(id,Item::new)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .model((ctx,prov)->
                        prov.generated(ctx::getEntry,prov.modLoc("item/"+path)))
                .register();
    }

    private static ItemEntry<Item> item(String id, String enLang, String cnLang, String path, Item.Properties properties){
        return REGISTRATE.item(id,Item::new)
                .lang(enLang)
                .initialProperties(()->properties)
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .model((ctx,prov)->
                        prov.generated(ctx::getEntry,prov.modLoc("item/"+path)))
                .register();
    }

    private static ItemEntry<ExComponentItem> foodItem(String id, String enLang, String cnLang, GTMFOFoodStats foodStats){
        return REGISTRATE.item(id,ExComponentItem::create)
                .lang(enLang)
                .onRegister(attach(foodStats))
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .defaultModel()
                .register();
    }

    private static ItemEntry<ExComponentItem> foodItem(String id, String enLang, String cnLang, GTMFOFoodStats foodStats, Item.Properties properties){
        return REGISTRATE.item(id,ExComponentItem::create)
                .lang(enLang)
                .initialProperties(()->properties)
                .onRegister(attach(foodStats))
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .defaultModel()
                .register();
    }

    private static ItemEntry<ExComponentItem> foodItem(String id, String enLang, String cnLang, String path, GTMFOFoodStats foodStats){
        return REGISTRATE.item(id,ExComponentItem::create)
                .lang(enLang)
                .onRegister(attach(foodStats))
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .model((ctx,prov)->
                        prov.generated(ctx::getEntry,prov.modLoc("item/"+path)))
                .register();
    }

    private static ItemEntry<ExComponentItem> foodItem(String id, String enLang, String cnLang, String path, GTMFOFoodStats foodStats, Item.Properties properties){
        return REGISTRATE.item(id,ExComponentItem::create)
                .lang(enLang)
                .initialProperties(()->properties)
                .onRegister(attach(foodStats))
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .model((ctx,prov)->
                        prov.generated(ctx::getEntry,prov.modLoc("item/"+path)))
                .register();
    }

    private static ItemEntry<ExComponentItem> smore(int number, String enLang, String cnLang, GTMFOFoodStats foodStats, boolean blockModel){
        return REGISTRATE.item("smore_"+number,ExComponentItem::create)
                .lang(enLang)
                //.properties(p->p.stacksTo(64/number))
                .onRegister(attach(foodStats))
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .model((ctx,prov)->{
                    if (blockModel){
                        prov.withExistingParent("item/smore_"+number,prov.modLoc("block/smore/"+number));
                    }
                    else {
                        prov.generated(ctx::getEntry,prov.modLoc("item/smore/"+number));
                    }})
                .register();
    }

    private static ItemEntry<ExComponentItem> smogus(String id, String enLang, String cnLang, String path, GTMFOFoodStats foodStats, Supplier<? extends Block> block){
        return REGISTRATE.item(id,ExComponentItem::create)
                .lang(enLang)
                .onRegister(attach(foodStats,new BlockItemComponent(block)))
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .model((ctx,prov)->prov.generated(ctx::getEntry,prov.modLoc("item/"+path)))
                .register();
    }



    private static final Item.Properties STACK_1 = new Item.Properties().stacksTo(1);
    private static final Item.Properties STACK_16 = new Item.Properties().stacksTo(16);

    //container
    public static final ItemEntry<Item> BAKING_TRAY           = item("baking_tray"          ,"Baking Tray"             ,"烤盘"        ,"container/baking_tray"   );
    public static final ItemEntry<Item> CAN                   = item("can"                  ,"Can"                     ,"易拉罐"      ,"container/can"           );
    public static final ItemEntry<Item> CERAMIC_BOWL          = item("ceramic_bowl"         ,"Ceramic Bowl"            ,"瓷碗"        ,"container/bowl"          );
    public static final ItemEntry<Item> CERAMIC_BOWL_DIRTY    = item("ceramic_bowl_dirty"   ,"Dirty Bowl"              ,"脏碗"        ,"container/bowl_dirty"    );
    public static final ItemEntry<Item> CERAMIC_BOWL_UNFIRED  = item("ceramic_bowl_unfired" ,"Unfired Bone China Bowl" ,"未烧制骨瓷碗","container/bowl_unfired"  );
    public static final ItemEntry<Item> CERAMIC_PLATE         = item("ceramic_plate"        ,"Ceramic Plate"           ,"瓷盘"        ,"container/plate"         );
    public static final ItemEntry<Item> CERAMIC_PLATE_DIRTY   = item("ceramic_plate_dirty"  ,"Dirty Plate"             ,"脏盘子"      ,"container/plate_dirty"   );
    public static final ItemEntry<Item> CERAMIC_PLATE_UNFIRED = item("ceramic_plate_unfired","Unfired Bone China Plate","未烧制骨瓷盘","container/plate_unfired" );
    public static final ItemEntry<Item> CUP_EMPTY             = item("cup_empty"            ,"Empty Cup"               ,"空杯"        ,"container/cup_empty"     );
    public static final ItemEntry<Item> CUP_UNFIRED           = item("cup_unfired"          ,"Unfired Cup"             ,"未烧制杯子"  ,"container/cup_unfired"   );
    public static final ItemEntry<Item> PAPER_BAG             = item("paper_bag"            ,"Paper Bag"               ,"纸袋"        ,"container/bag"           );
    public static final ItemEntry<Item> PAPER_BAG_USED        = item("paper_bag_used"       ,"Used Paper Bag"          ,"用过的纸袋"  ,"container/bag_used"      );
    public static final ItemEntry<Item> PLASTIC_BOTTLE        = item("plastic_bottle"       ,"Plastic Bottle"          ,"塑料瓶"      ,"container/plastic_bottle");
    //kebab
    public static final ItemEntry<Item> SKEWER            = item("skewer"           ,"Skewer"           ,"铁签"            ,"kebab/skewer"     );
    //potato
    public static final ItemEntry<Item> CHIPS_BAG_EMPTY            = item("chips_bag_empty"           ,"Empty Chip Bag"               ,"空薯片袋"      ,"potato/chips_bag_empty"           );


    //apple
    public static final ItemEntry<Item>            APPLE_CORED         =     item("apple_cored"        ,"Cored Apple"        ,"去核苹果","apple/cored"        );
    public static final ItemEntry<ExComponentItem> APPLE_SLICE         = foodItem("apple_slice"        ,"Apple Slice"        ,"苹果片"  ,"apple/slice"        ,Foods.APPLE_SLICE);
    public static final ItemEntry<ExComponentItem> APPLE_TUNGSTENSTEEL = foodItem("apple_tungstensteel","Tungstensteel Apple","钨钢苹果","apple/tungstensteel",Foods.APPLE_TUNGSTENSTEEL);

    public static final ItemEntry<ExComponentItem> APPLE_CANDY         = foodItem("apple_candy"        ,"Apple Candy"        ,"苹果糖"    ,"apple/candy"        ,Foods.APPLE_CANDY);
    public static final ItemEntry<Item>            APPLE_CANDY_HOT     =     item("apple_candy_hot"    ,"Hot Apple Candy"    ,"热苹果糖"  ,"apple/candy_hot"    );
    public static final ItemEntry<Item>            APPLE_CANDY_PLATE   =     item("apple_candy_plate"  ,"Apple Candy Sheet"  ,"苹果糖片"  ,"apple/candy_plate"  );
    public static final ItemEntry<Item>            APPLE_CANDY_RESIN   =     item("apple_candy_resin"  ,"Apple Candy Resin"  ,"苹果糖糖坯","apple/candy_resin"  );
    public static final ItemEntry<Item>            APPLE_CANDY_CRUSHED =     item("apple_candy_crushed","Crushed Apple Candy","苹果糖碎"  ,"apple/candy_crushed");

    //berry
//    public static final ItemEntry<ExComponentItem> BLACKBERRY    = foodItem("blackberry"   ,"Blackberry"   ,"黑莓"    ,"berry/blackberry"   ,Foods.BERRY     );
//    public static final ItemEntry<ExComponentItem> BLUEBERRY     = foodItem("blueberry"    ,"Blueberry"    ,"蓝莓"    ,"berry/blueberry"    ,Foods.BERRY     );
//    public static final ItemEntry<ExComponentItem> CRANBERRY     = foodItem("cranberry"    ,"Cranberry"    ,"蔓越莓"  ,"berry/cranberry"    ,Foods.BERRY     );
//    public static final ItemEntry<ExComponentItem> ELDERBERRY    = foodItem("elderberry"   ,"Elderberry"   ,"接骨木莓","berry/elderberry"   ,Foods.ELDERBERRY);
//    public static final ItemEntry<ExComponentItem> LINGONBERRY   = foodItem("lingonberry"  ,"Lingonberry"  ,"越橘"    ,"berry/lingonberry"  ,Foods.BERRY     );
//    public static final ItemEntry<ExComponentItem> RASPBERRY     = foodItem("raspberry"    ,"Raspberry"    ,"树莓"    ,"berry/raspberry"    ,Foods.BERRY     );
//    public static final ItemEntry<ExComponentItem> STRAWBERRY    = foodItem("strawberry"   ,"Strawberry"   ,"草莓"    ,"berry/strawberry"   ,Foods.BERRY     );
//    public static final ItemEntry<ExComponentItem> BLACK_CURRANT = foodItem("black_currant","Black Currant","黑加仑"  ,"berry/black_currant",Foods.BERRY     );
//    public static final ItemEntry<ExComponentItem> RED_CURRANT   = foodItem("red_currant"  ,"Red Currant"  ,"红加仑"  ,"berry/red_currant"  ,Foods.BERRY     );
//    public static final ItemEntry<ExComponentItem> WHITE_CURRANT = foodItem("white_currant","White Currant","白加仑"  ,"berry/white_currant",Foods.BERRY     );

    //bread
//    public static final ItemEntry<Item>            WOODEN_FORM_BUN      =     item("wooden_form_bun"     ,"Bun Wooden Form"     ,"木制圆面包模具"  ,"bread/wooden_form_bun"     ,STACK_1);
//    public static final ItemEntry<Item>            WOODEN_FORM_BREAD    =     item("wooden_form_bread"   ,"Bread Wooden Form"   ,"木制面包模具"    ,"bread/wooden_form_bread"   ,STACK_1);
//    public static final ItemEntry<Item>            WOODEN_FORM_BAGUETTE =     item("wooden_form_baguette","Baguette Wooden Form","木制法棍面包模具","bread/wooden_form_baguette",STACK_1);
//    public static final ItemEntry<Item>            BUN_UNBAKED          =     item("bun_unbaked"         ,"Unbaked Bun"         ,"圆面包坯"        ,"bread/bun_unbaked"         );
//    public static final ItemEntry<Item>            BREAD_UNBAKED        =     item("bread_unbaked"       ,"Unbaked Bread"       ,"面包坯"          ,"bread/bread_unbaked"       );
//    public static final ItemEntry<Item>            BAGUETTE_UNCOOKED    =     item("baguette_unbaked"    ,"Unbaked Baguette"    ,"法棍面包坯"      ,"bread/baguette_unbaked"    );
//    public static final ItemEntry<ExComponentItem> BUN                  = foodItem("bun"                 ,"Bun"                 ,"圆面包"          ,"bread/bun"                 ,Foods.BUN);
//    public static final ItemEntry<ExComponentItem> BUN_PRESLICED        = foodItem("bun_presliced"       ,"Pre-Sliced Bun"      ,"切好的圆面包"    ,"bread/bun_presliced"       ,Foods.BUN_PRESLICED);
//    public static final ItemEntry<ExComponentItem> BREAD_PRESLICED      = foodItem("bread_presliced"     ,"Pre-Sliced Bread"    ,"切好的面包"      ,"bread/bread_presliced"     ,Foods.BREAD_PRESLICED);
//    public static final ItemEntry<ExComponentItem> BREAD_SLICE          = foodItem("bread_slice"         ,"Bread Slice"         ,"面包片"          ,"bread/bread_slice"         ,Foods.BREAD_SLICE);
//    public static final ItemEntry<ExComponentItem> TOAST                = foodItem("toast"               ,"Toast"               ,"吐司"            ,"bread/toast"               ,Foods.TOAST);
//    public static final ItemEntry<ExComponentItem> BAGUETTE             = foodItem("baguette"            ,"Baguette"            ,"法棍面包"        ,"bread/baguette"            ,Foods.BAGUETTE);
//    public static final ItemEntry<ExComponentItem> BAGUETTE_PRESLICED   = foodItem("baguette_presliced"  ,"Pre-Sliced Baguette" ,"切好的法棍面包"  ,"bread/baguette_presliced"  ,Foods.BAGUETTE_PRESLICED);

    //burger
//    public static final ItemEntry<ExComponentItem> BURGER_BACON  = foodItem("burger_bacon" ,"Bacon Burger" ,"培根汉堡","burger/bacon" ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> BURGER_CHEESE = foodItem("burger_cheese","Cheese Burger","芝士汉堡","burger/cheese",Foods.BURGER_CHEESE);
//    public static final ItemEntry<ExComponentItem> BURGER_CHUM   = foodItem("burger_chum"  ,"Chum Burger"  ,"海霸堡"  ,"burger/chum"  ,Foods.BURGER_CHUM);
//    public static final ItemEntry<ExComponentItem> BURGER_STEAK  = foodItem("burger_steak" ,"Steak Burger" ,"牛肉汉堡","burger/steak" ,Foods.BURGER_STEAK);
//    public static final ItemEntry<ExComponentItem> BURGER_VEGGIE = foodItem("burger_veggie","Veggie Burger","蔬菜汉堡","burger/veggie",Foods.BURGER_VEGGIE);

    //caplet
//    public static final ItemEntry<Item> CAPLET_CAP           = item("caplet_cap"          ,"Caplet Cap"             ,"囊帽"            ,"caplet/cap"          );
//    public static final ItemEntry<Item> CAPLET_BODY          = item("caplet_body"         ,"Caplet Body"            ,"囊体"            ,"caplet/body"         );
//    public static final ItemEntry<ExComponentItem> CAPLET_GEL           = foodItem("caplet_gel"          ,"Gel Caplet"             ,"明胶胶囊"        ,"caplet/gel"          ,Foods.CAPLET_GEL);
//    public static final ItemEntry<ExComponentItem> CAPLET_PARACETAMOL   = foodItem("caplet_paracetamol"  ,"Paracetamol Caplet"     ,"对乙酰氨基酚胶囊","caplet/paracetamol"  ,Foods.CAPLET_PARACETAMOL);
//    public static final ItemEntry<ExComponentItem> CAPLET_PLUTONIUM_241 = foodItem("caplet_plutonium_241","Plutonium-241 Caplet"   ,"钚-241胶囊"      ,"caplet/plutonium_241",Foods.CAPLET_PLUTONIUM_241);
//    public static final ItemEntry<ExComponentItem> CAPLET_CHORUS        = foodItem("caplet_chorus"       ,"Fermented Chorus Caplet","发酵紫颂果胶囊"  ,"caplet/chorus"       ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> CAPLET_VIBRANT       = foodItem("caplet_vibrant"      ,"Vibrant Caplet"         ,"Vibrant Caplet"  ,"caplet/vibrant"      ,Foods.EMPTY);

    //cheese
//    public static final ItemEntry<Item>            CHEDDAR_BLOCK     =     item("cheddar_block"    ,"Cheddar Block"    ,"块状切达奶酪"          ,"cheese/cheddar_block"    );
//    public static final ItemEntry<ExComponentItem> CHEDDAR_SLICE     = foodItem("cheddar_slice"    ,"Cheddar Slice"    ,"切达奶酪片"            ,"cheese/cheddar_slice"    ,Foods.CHEDDAR_SLICE);
//    public static final ItemEntry<Item>            CHEDDAR_AGED_MOLD =     item("cheddar_aged_mold","Aged Cheddar Mold","装有熟化切达奶酪的模具","cheese/cheddar_aged_mold");
//    public static final ItemEntry<Item>            CHEDDAR_CURD_MOLD =     item("cheddar_curd_mold","Cheddar Curd Mold","装有切达奶酪凝乳的模具","cheese/cheddar_curd_mold");
    public static final ItemEntry<Item>            MOZZARELLA_SLICE  =     item("mozzarella_slice" ,"Mozzarella Slice" ,"马苏里拉奶酪片"        ,"cheese/mozzarella_slice" );
    public static final ItemEntry<ExComponentItem> MOZZARELLA_BALL   = foodItem("mozzarella_ball"  ,"Mozzarella Ball"  ,"马苏里拉奶酪球"        ,"cheese/mozzarella_ball"  ,Foods.MOZZARELLA_BALL);
//    public static final ItemEntry<Item>            RICOTTA_PIECE     =     item("ricotta_piece"    ,"Ricotta Piece"    ,"里科塔奶酪凝块"        ,"cheese/ricotta_piece"    );
//    public static final ItemEntry<Item>            GORGONZOLA_WHEEL               =     item("gorgonzola_wheel"              ,"Gorgonzola Wheel"              ,"戈贡佐拉奶酪轮"        ,"cheese/gorgonzola_wheel"              );
//    public static final ItemEntry<Item>            GORGONZOLA_WHEEL_SALTED        =     item("gorgonzola_wheel_salted"       ,"Salted Gorgonzola Wheel"       ,"加盐戈贡佐拉奶酪轮"    ,"cheese/gorgonzola_wheel_salted"       );
//    public static final ItemEntry<Item>            GORGONZOLA_WHEEL_SLIGHTLY_AGED =     item("gorgonzola_wheel_slightly_aged","Slightly Aged Gorgonzola Wheel","初步熟化戈贡佐拉奶酪轮","cheese/gorgonzola_wheel_slightly_aged");
//    public static final ItemEntry<Item>            GORGONZOLA_WHEEL_PUNCTURED     =     item("gorgonzola_wheel_punctured"    ,"Punctured Gorgonzola Wheel"    ,"扎孔戈贡佐拉奶酪轮"    ,"cheese/gorgonzola_wheel_punctured"    );
//    public static final ItemEntry<Item>            GORGONZOLA_WHEEL_FULLY_CURED   =     item("gorgonzola_wheel_fully_cured"  ,"Fully Cured Gorgonzola Wheel"  ,"硬化戈贡佐拉奶酪轮"    ,"cheese/gorgonzola_wheel_fully_cured"  );
//    public static final ItemEntry<ExComponentItem> GORGONZOLA_TRIANGULAR_SLICE    = foodItem("gorgonzola_triangular_slice"   ,"Gorgonzola Triangular Slice"   ,"戈贡佐拉奶酪三角"      ,"cheese/gorgonzola_triangular_slice"   ,Foods.GORGONZOLA_TRIANGULAR);
//    public static final ItemEntry<Item>            PARMIGIANO_CHEESE_FORM = item("parmigiano_cheese_form","Stainless Steel Cheese Form"                ,"不锈钢奶酪模具"                           ,"cheese/parmigiano_cheese_form");
//    public static final ItemEntry<Item>            PARMIGIANO_BRINED      = item("parmigiano_brined"     ,"Brined Parmigiano-Reggiano in Cheese Form"  ,"装有盐渍帕马森-雷加诺奶酪的奶酪模具"      ,"cheese/parmigiano_brined"     );
//    public static final ItemEntry<Item>            PARMIGIANO_BRINED_ROLL = item("parmigiano_brined_roll","Brined Parmigiano-Reggiano Roll"            ,"盐渍帕马森-雷加诺奶酪卷"                  ,"cheese/parmigiano_brined_roll");
//    public static final ItemEntry<Item>            PARMIGIANO_AGED_ROLL   = item("parmigiano_aged_roll"  ,"Aged Parmigiano-Reggiano Roll"              ,"熟化帕马森-雷加诺奶酪卷"                  ,"cheese/parmigiano_aged_roll"  );
//    public static final ItemEntry<Item>            PARMIGIANO_CURDLING    = item("parmigiano_curdling"   ,"Curdling Parmigiano-Reggiano in Cheese Form","装有半凝固帕马森-雷加诺奶酪乳液的奶酪模具","cheese/parmigiano_curdling"   );

    //coffee
//    public static final ItemEntry<Item> COFFEE_CHERRY                = item("coffee_cherry",               "Coffee Cherry",               "咖啡果",        "coffee/cherry");
//    public static final ItemEntry<Item> COFFEE_CHERRY_LARGE          = item("coffee_cherry_large",         "Large Coffee Cherry",         "大咖啡果",      "coffee/cherry_large");
//    public static final ItemEntry<Item> COFFEE_CHERRY_SMALL          = item("coffee_cherry_small",         "Small Coffee Cherry",         "小咖啡果",      "coffee/cherry_small");
//    public static final ItemEntry<Item> COFFEE_BEANS_RAW_LARGE       = item("coffee_beans_raw_large",      "Large Raw Coffee Beans",      "大粒生咖啡豆",  "coffee/raw_large");
//    public static final ItemEntry<Item> COFFEE_BEANS_RAW_SMALL       = item("coffee_beans_raw_small",      "Small Raw Coffee Beans",      "小粒生咖啡豆",  "coffee/raw_small");
//    public static final ItemEntry<Item> COFFEE_BEANS_FERMENTED_LARGE = item("coffee_beans_fermented_large","Large Fermented Coffee Beans","发酵大粒咖啡豆","coffee/fermented_large");
//    public static final ItemEntry<Item> COFFEE_BEANS_FERMENTED_SMALL = item("coffee_beans_fermented_small","Small Fermented Coffee Beans","发酵小粒咖啡豆","coffee/fermented_small");
//    public static final ItemEntry<Item> COFFEE_BEANS_DRIED_LARGE     = item("coffee_beans_dried_large",    "Large Dried Coffee Beans",    "烘干大粒咖啡豆","coffee/dried_large");
//    public static final ItemEntry<Item> COFFEE_BEANS_DRIED_SMALL     = item("coffee_beans_dried_small",    "Small Dried Coffee Beans",    "烘干小粒咖啡豆","coffee/dried_small");
//    public static final ItemEntry<Item> COFFEE_BEANS_HULLED_LARGE    = item("coffee_beans_hulled_large",   "Large Hulled Coffee Beans",   "去壳大粒咖啡豆","coffee/hulled_large");
//    public static final ItemEntry<Item> COFFEE_BEANS_HULLED_SMALL    = item("coffee_beans_hulled_small",   "Small Hulled Coffee Beans",   "去壳小粒咖啡豆","coffee/hulled_small");
//    public static final ItemEntry<Item> COFFEE_BEANS_ROASTED_LARGE   = item("coffee_beans_roasted_large",  "Large Roasted Coffee Beans",  "烘焙大粒咖啡豆","coffee/roasted_large");
//    public static final ItemEntry<Item> COFFEE_BEANS_ROASTED_SMALL   = item("coffee_beans_roasted_small",  "Small Roasted Coffee Beans",  "烘焙小粒咖啡豆","coffee/roasted_small");
//    public static final ItemEntry<ExComponentItem> COFFEE           = foodItem("coffee"          ,"Coffee Cup"          ,"咖啡"    ,"coffee/normal"   ,Foods.COFFEE);
//    public static final ItemEntry<ExComponentItem> COFFEE_ENERGIZED = foodItem("coffee_energized","Energized Coffee Cup","提神咖啡","coffee/energized",Foods.COFFEE_ENERGIZING);



    //corn
//    public static final ItemEntry<Item> CORN_COB               = item("corn_cob"              ,"Corn Cob"              ,"玉米芯"      ,"corn/cob"              );
//    public static final ItemEntry<Item> CORN_EAR               = item("corn_ear"              ,"Corn Ear"              ,"玉米穗"      ,"corn/ear"              );
//    public static final ItemEntry<Item> CORN_EAR_DRIED         = item("corn_ear_dried"        ,"Dried Corn Ear"        ,"烘干玉米穗"  ,"corn/ear_dried"        );
//    public static final ItemEntry<Item> CORN_KERNEL            = item("corn_kernel"           ,"Corn Kernel"           ,"玉米粒"      ,"corn/kernel"           );
//    public static final ItemEntry<Item> CORN_KERNEL_ACCEPTABLE = item("corn_kernel_acceptable","Acceptable Corn Kernel","合格级玉米粒","corn/kernel_acceptable");
//    public static final ItemEntry<Item> FLAVORED_POPCORN_FLAKE = item("flavored_flake"        ,"Flavored Popcorn Flake","调味爆米花粒","corn/flavored_flake"   );
//    public static final ItemEntry<ExComponentItem> POPCORN_BAG = foodItem("popcorn_bag"           ,"Popcorn Bag"           ,"袋装爆米花"  ,"corn/popcorn_bag"      ,Foods.EMPTY);

    //crop
//    public static final ItemEntry<Item> ARTICHOKE      = item("artichoke"     ,"Artichoke Heart"  ,"洋蓟心"  ,"crop/artichoke"     );
//    public static final ItemEntry<Item> BASIL          = item("basil"         ,"Basil Leaf"       ,"罗勒叶"  ,"crop/basil"         );
//    public static final ItemEntry<Item> BLACK_PEPPER   = item("black_pepper"  ,"Black Peppercorns","黑胡椒籽","crop/black_pepper"  );
//    public static final ItemEntry<Item> CARROT_SLICE   = item("carrot_slice"  ,"Carrot Slice"     ,"胡萝卜片","crop/carrot_slice"  );
//    public static final ItemEntry<Item> COTTON         = item("cotton"        ,"Cotton"           ,"棉花"    ,"crop/cotton"        );
//    public static final ItemEntry<Item> CUCUMBER       = item("cucumber"      ,"Cucumber"         ,"黄瓜"    ,"crop/cucumber"      );
//    public static final ItemEntry<Item> CUCUMBER_SLICE = item("cucumber_slice","Cucumber Slice"   ,"黄瓜片"  ,"crop/cucumber_slice");
//    public static final ItemEntry<Item> EGGPLANT       = item("eggplant"      ,"Eggplant"         ,"茄子"    ,"crop/eggplant"      );
//    public static final ItemEntry<Item> EGGPLANT_SLICE = item("eggplant_slice","Eggplant Slice"   ,"茄子片"  ,"crop/eggplant_slice");
//    public static final ItemEntry<Item> GARLIC         = item("garlic"        ,"Garlic Bulb"      ,"大蒜头"  ,"crop/garlic"        );
//    public static final ItemEntry<Item> HORSERADISH    = item("horseradish"   ,"Horseradish"      ,"辣根"    ,"crop/horseradish"   );
    public static final ItemEntry<Item> MUSHROOM_SLICE = item("mushroom_slice","Mushroom Slice"   ,"蘑菇片"  ,"crop/mushroom_slice");
    public static final ItemEntry<Item> OLIVE          = item("olive"         ,"Olive"            ,"橄榄"    ,"crop/olive"         );
    public static final ItemEntry<Item> OLIVE_SLICE    = item("olive_slice"   ,"Olive Slice"      ,"橄榄片"  ,"crop/olive_slice"   );
//    public static final ItemEntry<Item> ONION          = item("onion"         ,"Onion"            ,"洋葱"    ,"crop/onion"         );
//    public static final ItemEntry<Item> ONION_SLICE    = item("onion"         ,"Onion Slice"      ,"洋葱片"  ,"crop/onion_slice"   );
//    public static final ItemEntry<Item> OREGANO        = item("oregano"       ,"Oregano Leaf"     ,"牛至叶"  ,"crop/oregano"       );
//    public static final ItemEntry<Item> PEA_POD        = item("pea_pod"       ,"Pea Pod"          ,"豌豆荚"  ,"crop/pea_pod"       );
//    public static final ItemEntry<Item> RICE           = item("rice"          ,"Rice"             ,"大米"    ,"crop/rice"          );
//    public static final ItemEntry<Item> SOYBEAN        = item("soybean"       ,"Soybean"          ,"大豆"    ,"crop/soybean"       );
    public static final ItemEntry<Item> TOMATO         = item("tomato"        ,"Tomato"           ,"番茄"    ,"crop/tomato"        );
    public static final ItemEntry<Item> TOMATO_SLICE   = item("tomato_slice"  ,"Tomato Slice"     ,"番茄片"  ,"crop/tomato_slice"  );

    //public static final ItemEntry<Item> COFFEE_CHERRY= item("coffee_cherry" ,"Coffee Cherry"    ,"咖啡果"  ,"crop/coffee"        );

    //dewar_flask
//    public static final ItemEntry<Item> DEWAR_FLASK                = item("dewar_flask"               ,"Dewar Flask"               ,"保温杯",          "dewar_flask/new");
//    public static final ItemEntry<Item> DEWAR_FLASK_USED           = item("dewar_flask_used"          ,"Used Dewar Flask"          ,"使用过的保温杯",  "dewar_flask/used");
//    public static final ItemEntry<Item> DEWAR_FLASK_CAP            = item("dewar_flask_cap"           ,"Dewar Flask Cap"           ,"保温杯盖",        "dewar_flask/cap");
//    public static final ItemEntry<Item> DEWAR_FLASK_CASING         = item("dewar_flask_casing"        ,"Dewar Flask Casing"        ,"保温杯身",        "dewar_flask/casing");
//    public static final ItemEntry<Item> DEWAR_FLASK_CASING_LEACHED = item("dewar_flask_casing_leached","Leached Dewar Flask Casing","使用过的保温杯身","dewar_flask/casing_leached");

    //dough
    public static final ItemEntry<Item> DOUGH                = item("dough"               ,"Dough"               ,"面团"        ,"dough/dough"         );
    public static final ItemEntry<Item> DOUGH_FLAT           = item("flat_dough"          ,"Flat Dough"          ,"扁平面团"    ,"dough/flat"          );
    public static final ItemEntry<Item> DOUGH_SUGARY         = item("sugary_dough"        ,"Sugary Dough"        ,"甜面团"      ,"dough/sugary"        );
    public static final ItemEntry<Item> PASTA_DOUGH          = item("pasta_dough"         ,"Pasta Dough"         ,"意面面团"    ,"dough/pasta"         );
    public static final ItemEntry<Item> PASTA_DOUGH_EGG      = item("pasta_dough_egg"     ,"Egg Pasta Dough"     ,"蛋液意面面团","dough/pasta_egg"     );
    public static final ItemEntry<Item> PASTA_DOUGH_PREMIXED = item("pasta_dough_premixed","Premixed Pasta Dough","预拌意面面团","dough/pasta_premixed");

    //drink
//    public static final ItemEntry<ExComponentItem> ANTAF            = foodItem("antaf"           ,"Antaf™"         ,"Antaf™"     ,"drink/antaf"           ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> BEER             = foodItem("beer"            ,"Beer"            ,"啤酒"        ,"drink/beer"            ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> COAC             = foodItem("coac"            ,"Coac"            ,"乐可"        ,"drink/coac"            ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> ETIRPS           = foodItem("etirps"          ,"Etirps™"        ,"碧雪™"      ,"drink/etirps"          ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> ETIRPS_CRANBERRY = foodItem("etirps_cranberry","Etirps Cranberry","蔓越莓味碧雪","drink/etirps_cranberry",Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> GREEN_ISLAND     = foodItem("green_island"    ,"Green Island™"  ,"绿岛啤酒™"  ,"drink/green_island"    ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> JUICE_APPLE      = foodItem("juice_apple"     ,"Apple Juice"     ,"苹果汁"      ,"drink/juice_apple"     ,Foods.JUICE);
//    public static final ItemEntry<ExComponentItem> JUICE_ORANGE     = foodItem("juice_orange"    ,"Orange Juice"    ,"橙汁"        ,"drink/juice_orange"    ,Foods.JUICE);
//    public static final ItemEntry<ExComponentItem> LENINADE         = foodItem("leninade"        ,"Leninade"        ,"列宁檬汁"    ,"drink/leninade"        ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> MINERAL_WATER    = foodItem("mineral_water"   ,"Mineral Water"   ,"矿泉水"      ,"drink/mineral_water"   ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> NILK             = foodItem("nilk"            ,"Nilk"            ,"硅岩风味乳"  ,"drink/nilk"            ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> RED_WINE         = foodItem("red_wine"        ,"Red Wine"        ,"红葡萄酒"    ,"drink/red_wine"        ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> SEPIP            = foodItem("sepip"           ,"Sepip"           ,"事百"        ,"drink/sepip"           ,Foods.ETIRPS);
//    public static final ItemEntry<ExComponentItem> SPARKLING_WATER  = foodItem("sparkling_water" ,"Sparkling Water" ,"气泡水"      ,"drink/sparkling_water" ,Foods.SPARKLING_WATER);
//    public static final ItemEntry<ExComponentItem> VODKA            = foodItem("vodka"           ,"Vodka"           ,"伏特加"      ,"drink/vodka"           ,Foods.VODKA);
//    public static final ItemEntry<ExComponentItem> WHITE_WINE       = foodItem("white_wine"      ,"White Wine"      ,"白葡萄酒"    ,"drink/white_wine"      ,Foods.EMPTY);

    //food_chinese
//    public static final ItemEntry<Item> JIAOZI     = item("jiaozi"    ,"Jiaozi"    ,"饺子"  ,"food_chinese/jiaozi"    );
//    public static final ItemEntry<Item> JIAOZI_RAW = item("jiaozi_raw","Raw Jiaozi","生饺子","food_chinese/jiaozi_raw");

    //food_italian
//    public static final ItemEntry<Item> BRUSCHETTA             = item("bruschetta"             ,"Bruschetta"             ,"意式烤面包片"      ,"food_italian/bruschetta"             );
//    public static final ItemEntry<Item> CAPONATA               = item("caponata"               ,"Caponata"               ,"意式酸甜茄子"      ,"food_italian/caponata"               );
//    public static final ItemEntry<Item> CARBONARA              = item("carbonara"              ,"Carbonara"              ,"培根蛋酱意面"      ,"food_italian/carbonara"              );
//    public static final ItemEntry<Item> FETTUCCINE_ALFREDO     = item("fettuccine_alfredo"     ,"Fettuccine Alfredo"     ,"阿尔弗雷多芝士宽面","food_italian/fettuccine_alfredo"     );
//    public static final ItemEntry<Item> CARCIOFI_ALLA_ROMANA   = item("carciofi_alla_romana"   ,"Carciofi alla Romana"   ,"罗马风味烤洋蓟"    ,"food_italian/carciofi_alla_romana"   );
//    public static final ItemEntry<Item> PARMIGIANA             = item("parmigiana"             ,"Parmigiana"             ,"意式焗烤千层茄子"  ,"food_italian/parmigiana"             );
//    public static final ItemEntry<Item> PASTA_E_FAGIOLI        = item("pasta_e_fagioli"        ,"Pasta e fagioli"        ,"意面豆汤"          ,"food_italian/pasta_e_fagioli"        );
//    public static final ItemEntry<Item> PASTA_ALLA_NORMA       = item("pasta_alla_norma"       ,"Pasta alla Norma"       ,"诺玛红酱茄子通心粉","food_italian/pasta_alla_norma"       );
//    public static final ItemEntry<Item> PASTA_AL_POMODORO      = item("pasta_al_pomodoro"      ,"Pasta al pomodoro"      ,"番茄意面"          ,"food_italian/pasta_al_pomodoro"      );
//    public static final ItemEntry<Item> PASTA_ALL_AMOGUS       = item("pasta_all_amogus"       ,"Pasta all'Amogus"       ,"内鬼意面"          ,"food_italian/pasta_all_amogus"       );
//    public static final ItemEntry<Item> POLENTA                = item("polenta"                ,"Polenta"                ,"意式玉米糊"        ,"food_italian/polenta"                );
//    public static final ItemEntry<Item> PORCHETTA              = item("porchetta"              ,"Porchetta"              ,"意式脆皮烤五花肉"  ,"food_italian/porchetta"              );
//    public static final ItemEntry<Item> PORCHETTA_SLICE        = item("porchetta_slice"        ,"Porchetta Slice"        ,"意式脆皮烤五花肉片","food_italian/porchetta_slice"        );
//    public static final ItemEntry<Item> RAFANATA               = item("rafanata"               ,"Rafanata"               ,"意式辣根蛋饼"      ,"food_italian/rafanata"               );
//    public static final ItemEntry<Item> RISOTTO                = item("risotto"                ,"Risotto"                ,"意式烩饭"          ,"food_italian/risotto"                );
//    public static final ItemEntry<Item> SPAGHETTI_ALLASSASSINA = item("spaghetti_all_assassina","Spaghetti all'assassina","刺客意面"          ,"food_italian/spaghetti_all_assassina");
//    public static final ItemEntry<Item> TAGLIATELLE_AL_RAGU    = item("tagliatelle_al_ragu"    ,"Tagliatelle al ragu"    ,"意式番茄肉酱面"    ,"food_italian/tagliatelle_al_ragu"    );
//    public static final ItemEntry<Item> TORTELLINI_IN_BRODO    = item("tortellini_in_brodo"    ,"Tortellini in brodo"    ,"意式肉汤馄饨"      ,"food_italian/tortellini_in_brodo"    );
//    public static final ItemEntry<Item> VITELLO_TONNATO        = item("vitello_tonnato"        ,"Vitello Tonnato"        ,"意式鱼香小牛肉"    ,"food_italian/vitello_tonnato"        );

    //food_russian
//    public static final ItemEntry<Item> PELMENI                   = item("pelmeni"                  ,"Pelmeni"                  ,"俄式饺子"      ,"food_russian/pelmeni"                  );
//    public static final ItemEntry<Item> PELMENI_SEASONED          = item("pelmeni_seasoned"         ,"Seasoned Pelmeni"         ,"调味俄式饺子"  ,"food_russian/pelmeni_seasoned"         );
//    public static final ItemEntry<Item> PELMENI_UNCOOKED          = item("pelmeni_uncooked"         ,"Uncooked Pelmeni"         ,"生俄式饺子"    ,"food_russian/pelmeni_uncooked"         );
//    public static final ItemEntry<Item> PELMENI_SEASONED_UNCOOKED = item("pelmeni_seasoned_uncooked","Seasoned Uncooked Pelmeni","调味生俄式饺子","food_russian/pelmeni_seasoned_uncooked");

    //fruit
//    public static final ItemEntry<Item> APRICOT       = item("apricot"      ,"Apricot"      ,"杏子"    ,"fruit/apricot"      );
//    public static final ItemEntry<Item> BANANA        = item("banana"       ,"Banana"       ,"香蕉"    ,"fruit/banana"       );
//    public static final ItemEntry<Item> BANANA_PEELED = item("banana_peeled","Peeled Banana","去皮香蕉","fruit/banana_peeled");
//    public static final ItemEntry<Item> COCONUT       = item("coconut"      ,"Coconut"      ,"椰子"    ,"fruit/coconut"      );
//    public static final ItemEntry<Item> GRAPES        = item("grapes"       ,"Grapes"       ,"葡萄"    ,"fruit/grapes"       );
//    public static final ItemEntry<Item> LEMON         = item("lemon"        ,"Lemon"        ,"柠檬"    ,"fruit/lemon"        );
//    public static final ItemEntry<Item> LIME          = item("lime"         ,"Lime"         ,"酸橙"    ,"fruit/lime"         );
//    public static final ItemEntry<Item> MANGO         = item("mango"        ,"Mango"        ,"芒果"    ,"fruit/mango"        );
//    public static final ItemEntry<Item> NUTMEG        = item("nutmeg"       ,"Nutmeg Seeds" ,"肉桂果"  ,"fruit/nutmeg"       );
//    public static final ItemEntry<Item> ORANGE        = item("orange"       ,"Orange"       ,"橙子"    ,"fruit/orange"       );
//    public static final ItemEntry<Item> WHITE_GRAPES  = item("white_grapes" ,"White Grapes" ,"白葡萄"  ,"fruit/white_grapes" );

    //ice_cream
//    public static final ItemEntry<Item> ICE_CREAM           = item("ice_cream"          ,"Plain Ice Cream"      ,"原味冰淇淋"  ,"ice_cream/plain"    );
//    public static final ItemEntry<Item> ICE_CREAM_BACON     = item("ice_cream_bacon"    ,"Bacon Ice Cream"      ,"培根冰淇淋"  ,"ice_cream/bacon"    );
//    public static final ItemEntry<Item> ICE_CREAM_BANANA    = item("ice_cream_banana"   ,"Banana Ice Cream"     ,"香蕉冰淇淋"  ,"ice_cream/banana"   );
//    public static final ItemEntry<Item> ICE_CREAM_BEAR      = item("ice_cream_bear"     ,"Bear Ice Cream"       ,"熊先生冰淇淋","ice_cream/bear"     );
//    public static final ItemEntry<Item> ICE_CREAM_CHIP      = item("ice_cream_chip"     ,"Potato Chip Ice Cream","薯片冰淇淋"  ,"ice_cream/chip"     );
//    public static final ItemEntry<Item> ICE_CREAM_CHOCOLATE = item("ice_cream_chocolate","Chocolate Ice Cream"  ,"巧克力冰淇淋","ice_cream/chocolate");
//    public static final ItemEntry<Item> ICE_CREAM_CHORUS    = item("ice_cream_chorus"   ,"Chorus Ice Cream"     ,"紫颂果冰淇淋","ice_cream/chorus"   );
//    public static final ItemEntry<Item> ICE_CREAM_CHUM      = item("ice_cream_chum"     ,"Chum Ice Cream"       ,"海霸冰淇淋"  ,"ice_cream/chum"     );
//    public static final ItemEntry<Item> ICE_CREAM_LEMON     = item("ice_cream_lemon"    ,"Lemon Ice Cream"      ,"柠檬冰淇淋"  ,"ice_cream/lemon"    );
//    public static final ItemEntry<Item> ICE_CREAM_MELON     = item("ice_cream_melon"    ,"Melon Ice Cream"      ,"西瓜冰淇淋"  ,"ice_cream/melon"    );
//    public static final ItemEntry<Item> ICE_CREAM_RAINBOW   = item("ice_cream_rainbow"  ,"Rainbow Ice Cream"    ,"彩虹冰淇淋"  ,"ice_cream/rainbow"  );
//    public static final ItemEntry<Item> ICE_CREAM_VANILLA   = item("ice_cream_vanilla"  ,"Vanilla Ice Cream"    ,"香草冰淇淋"  ,"ice_cream/vanilla"  );

    //kebab

//    public static final ItemEntry<Item> KEBAB_BARG        = item("kebab_barg"       ,"Barg Kebab"       ,"伊朗叶子肉烤串"  ,"kebab/barg"       );
//    public static final ItemEntry<Item> KEBAB_BARG_RAW    = item("kebab_barg_raw"   ,"Raw Barg Kebab"   ,"生伊朗叶子肉烤串","kebab/barg_raw"   );
//    public static final ItemEntry<Item> KEBAB_CARROT      = item("kebab_carrot"     ,"Carrot Kebab"     ,"烤胡萝卜串"      ,"kebab/carrot"     );
//    public static final ItemEntry<Item> KEBAB_CARROT_RAW  = item("kebab_carrot_raw" ,"Raw Carrot Kebab" ,"生胡萝卜串"      ,"kebab/carrot_raw" );
//    public static final ItemEntry<Item> KEBAB_CHUM        = item("kebab_chum"       ,"Chum Kebab"       ,"烤海霸串"        ,"kebab/chum"       );
//    public static final ItemEntry<Item> KEBAB_CHUM_RAW    = item("kebab_chum_raw"   ,"Raw Chum Kebab"   ,"生海霸串"        ,"kebab/chum_raw"   );
//    public static final ItemEntry<Item> KEBAB_FAT         = item("kebab_fat"        ,"TailFat Kebab"    ,"烤肥尾串"        ,"kebab/fat"        );
//    public static final ItemEntry<Item> KEBAB_FAT_RAW     = item("kebab_fat_raw"    ,"Raw TailFat Kebab","生肥尾串"        ,"kebab/fat_raw"    );
//    public static final ItemEntry<Item> KEBAB_KUBIDEH     = item("kebab_kubideh"    ,"Kubideh Kebab"    ,"伊朗碎肉烤串"    ,"kebab/kubideh"    );
//    public static final ItemEntry<Item> KEBAB_KUBIDEH_RAW = item("kebab_kubideh_raw","Raw Kubideh Kebab","生伊朗碎肉烤串"  ,"kebab/kubideh_raw");
//    public static final ItemEntry<Item> KEBAB_MEAT        = item("kebab_meat"       ,"Meat Kebab"       ,"烤肉串"          ,"kebab/meat"       );
//    public static final ItemEntry<Item> KEBAB_MEAT_RAW    = item("kebab_meat_raw"   ,"Raw Meat Kebab"   ,"生肉串"          ,"kebab/meat_raw"   );
//    public static final ItemEntry<Item> KEBAB_ONION       = item("kebab_onion"      ,"Onion Kebab"      ,"烤洋葱串"        ,"kebab/onion"      );
//    public static final ItemEntry<Item> KEBAB_ONION_RAW   = item("kebab_onion_raw"  ,"Raw Onion Kebab"  ,"生洋葱串"        ,"kebab/onion_raw"  );
//    public static final ItemEntry<Item> KEBAB_TOMATO      = item("kebab_tomato"     ,"Tomato Kebab"     ,"烤番茄串"        ,"kebab/tomato"     );
//    public static final ItemEntry<Item> KEBAB_TOMATO_RAW  = item("kebab_tomato_raw" ,"Raw Tomato Kebab" ,"生番茄串"        ,"kebab/tomato_raw" );
//    public static final ItemEntry<Item> KEBAB_SOLTANI     = item("kebab_soltani"    ,"Kebab e Soltani!" ,"苏丹烤肉"        ,"kebab/soltani"    );


    //pasta
//    public static final ItemEntry<Item> DITALINI          = item("ditalini"         ,"Ditalini"         ,"意式手指面"    ,"pasta/ditalini"         );
//    public static final ItemEntry<Item> DITALINI_RAW      = item("ditalini_raw"     ,"Raw Ditalini"     ,"生意式手指面"  ,"pasta/ditalini_raw"     );
//    public static final ItemEntry<Item> DITALINI_DRIED    = item("ditalini_dried"   ,"Dried Ditalini"   ,"干意式手指面"  ,"pasta/ditalini_dried"   );
//    public static final ItemEntry<Item> RIGATONI          = item("rigatoni"         ,"Rigatoni"         ,"意式粗通心粉"  ,"pasta/rigatoni"         );
//    public static final ItemEntry<Item> RIGATONI_RAW      = item("rigatoni_raw"     ,"Raw Rigatoni"     ,"生意式粗通心粉","pasta/rigatoni_raw"     );
//    public static final ItemEntry<Item> RIGATONI_DRIED    = item("rigatoni_dried"   ,"Dried Rigatoni"   ,"干意式粗通心粉","pasta/rigatoni_dried"   );
//    public static final ItemEntry<Item> SPAGHETTI         = item("spaghetti"        ,"Spaghetti"        ,"意式直面"      ,"pasta/spaghetti"        );
//    public static final ItemEntry<Item> SPAGHETTI_RAW     = item("spaghetti_raw"    ,"Raw Spaghetti"    ,"生意式直面"    ,"pasta/spaghetti_raw"    );
//    public static final ItemEntry<Item> SPAGHETTI_DRIED   = item("spaghetti_dried"  ,"Dried Spaghetti"  ,"干意式直面"    ,"pasta/spaghetti_dried"  );
//    public static final ItemEntry<Item> TAGLIATELLE       = item("tagliatelle"      ,"Tagliatelle"      ,"意式干面"      ,"pasta/tagliatelle"      );
//    public static final ItemEntry<Item> TAGLIATELLE_RAW   = item("tagliatelle_raw"  ,"Raw Tagliatelle"  ,"生意式干面"    ,"pasta/tagliatelle_raw"  );
//    public static final ItemEntry<Item> TAGLIATELLE_DRIED = item("tagliatelle_dried","Dried Tagliatelle","干意式干面"    ,"pasta/tagliatelle_dried");
//    public static final ItemEntry<Item> TORTELLINI        = item("tortellini"       ,"Tortellini"       ,"意式馄饨"      ,"pasta/tortellini"       );
//    public static final ItemEntry<Item> LASAGNA_RAW               = item("lasagna_raw"              ,"Raw Lasagna"                              ,"生意式千层面"                      ,"pasta/lasagna_raw"              );
//    public static final ItemEntry<Item> LASAGNA_DRIED             = item("lasagna_dried"            ,"Dried Lasagna"                            ,"干意式千层面"                      ,"pasta/lasagna_dried"            );
//    public static final ItemEntry<Item> LASAGNA_CHUM              = item("lasagna_chum"             ,"Chum Lasagna"                             ,"海霸意式千层面"                    ,"pasta/lasagna_chum"             );
//    public static final ItemEntry<Item> LASAGNA_CHUM_RAW          = item("lasagna_chum_raw"         ,"Unbaked Chum Lasagna in Baking Tray"      ,"装有未烘烤海霸意式千层面的烤盘"    ,"pasta/lasagna_chum_raw"         );
//    public static final ItemEntry<Item> LASAGNA_CHUM_COOKED       = item("lasagna_chum_cooked"      ,"Baked Chum Lasagna in Baking Tray"        ,"装有海霸意式千层面的烤盘"          ,"pasta/lasagna_chum_cooked"      );
//    public static final ItemEntry<Item> LASAGNA_NAPOLETANA        = item("lasagna_napoletana"       ,"Lasagna Napoletana"                       ,"那不勒斯风味千层面"                ,"pasta/lasagna_napoletana"       );
//    public static final ItemEntry<Item> LASAGNA_NAPOLETANA_RAW    = item("lasagna_napoletana_raw"   ,"Unbaked Napoletana Lasagna in Baking Tray","装有未烘烤那不勒斯风味千层面的烤盘","pasta/lasagna_napoletana_raw"   );
//    public static final ItemEntry<Item> LASAGNA_NAPOLETANA_COOKED = item("lasagna_napoletana_cooked","Baked Napoletana Lasagna in Baking Tray"  ,"装有那不勒斯风味千层面的烤盘"      ,"pasta/lasagna_napoletana_cooked");
//    public static final ItemEntry<Item> LASAGNA_PESTO             = item("lasagna_pesto"            ,"Lasagna al pesto"                         ,"青酱千层面"                        ,"pasta/lasagna_pesto"            );
//    public static final ItemEntry<Item> LASAGNA_PESTO_RAW         = item("lasagna_pesto_raw"        ,"Unbaked Pesto Lasagna in Baking Tray"     ,"装有未烘烤青酱千层面的烤盘"        ,"pasta/lasagna_pesto_raw"        );
//    public static final ItemEntry<Item> LASAGNA_PESTO_COOKED      = item("lasagna_pesto_cooked"     ,"Baked Pesto Lasagna in Baking Tray"       ,"装有青酱千层面的烤盘"              ,"pasta/lasagna_pesto_cooked"     );

    //pizza
    public static final ItemEntry<Item> PIZZA_CHEESE_RAW     = item("pizza_cheese_raw"    ,"Raw Cheese Pizza"              ,"生芝士披萨"    ,"pizza/cheese_raw"  );
    public static final ItemEntry<Item> PIZZA_CHEESE_SLICE   = item("pizza_cheese_slice"  ,"Cheese Pizza Slice"            ,"芝士披萨片"    ,"pizza/cheese_slice");
    public static final ItemEntry<Item> PIZZA_VEGGIE_RAW     = item("pizza_veggie_raw"    ,"Raw Olive and Mushroom Pizza"  ,"生橄榄蘑菇披萨","pizza/veggie_raw"  );
    public static final ItemEntry<Item> PIZZA_VEGGIE_SLICE   = item("pizza_veggie_slice"  ,"Olive and Mushroom Pizza Slice","橄榄蘑菇披萨片","pizza/veggie_slice");
    public static final ItemEntry<Item> PIZZA_MEAT_RAW       = item("pizza_meat_raw"      ,"Raw Mince Meat Pizza"          ,"生肉末披萨"    ,"pizza/meat_raw"    );
    public static final ItemEntry<Item> PIZZA_MEAT_SLICE     = item("pizza_meat_slice"    ,"Mince Meat Pizza Slice"        ,"肉末披萨片"    ,"pizza/meat_slice"  );

    //potato
    public static final ItemEntry<Item> POTATO_PEELED            = item("potato_peeled"           ,"Peeled Potato"            ,"去皮马铃薯"        ,"potato/peeled"           );
    public static final ItemEntry<Item> POTATO_MASHED            = item("potato_mashed"           ,"Mashed Potato"            ,"土豆泥"            ,"potato/mashed"           );
    public static final ItemEntry<Item> POTATO_STRIP             = item("potato_strip"            ,"Potato Strip"             ,"马铃薯条"          ,"potato/strip"            );
    public static final ItemEntry<Item> POTATO_STRIP_BLANCHED    = item("potato_strip_blanched"   ,"Blanched Potato Strip"    ,"过油马铃薯条"      ,"potato/strip_blanched"   );
    public static final ItemEntry<Item> POTATO_STRIP_FRIED       = item("potato_strip_fried"      ,"Fried Potato Strip"       ,"炸马铃薯条"        ,"potato/strip_fried"      );
    public static final ItemEntry<Item> POTATO_SLICE             = item("potato_slice"            ,"Potato Slice"             ,"马铃薯片"          ,"potato/slice"            );
    public static final ItemEntry<Item> POTATO_SLICE_FRIED       = item("potato_slice_fried"      ,"Fried Potato Slice"       ,"炸马铃薯片"        ,"potato/slice_fried"      );
    public static final ItemEntry<Item> POTATO_SLICE_BATCH_FRIED = item("potato_slice_batch_fried","Batch-Fried Potato Slice" ,"分批油炸的马铃薯片","potato/slice_batch_fried");
    public static final ItemEntry<Item> POTATO_SLICE_OILY        = item("potato_slice_oily"       ,"Oily Potato Slice"        ,"油腻马铃薯片"      ,"potato/slice_oily"       );
    public static final ItemEntry<Item> POTATO_SLICE_HOT         = item("potato_slice_hot"        ,"Hot Potato Slice"         ,"热马铃薯片"        ,"potato/slice_hot"        );
    public static final ItemEntry<Item> POTATO_SLICE_REDUCED_FAT = item("potato_slice_reduced_fat","Reduced Fat Potato Chip"  ,"减脂薯片"          ,"potato/slice_reduced_fat");
    public static final ItemEntry<Item> POTATO_SLICE_NAQUADAH    = item("potato_slice_naquadah"   ,"Naquadah Potato Slice"    ,"硅岩油炸薯片"      ,"potato/slice_naquadah"   );
    public static final ItemEntry<Item> POTATO_STICK             = item("potato_stick"            ,"Potato on a Stick"        ,"马铃薯棒"          ,"potato/stick"            );
    public static final ItemEntry<ExComponentItem> POTATO_STICK_ROASTED     = foodItem("potato_stick_roasted","Roasted Potato on a Stick","烤马铃薯棒","potato/stick_roasted",Foods.POTATO_STICK_ROASTED);
    public static final ItemEntry<ExComponentItem> FRENCH_FRIES             = foodItem("french_fries"        ,"French Fries"             ,"薯条"      ,"potato/french_fries" ,Foods.FRENCH_FRIES);
    public static final ItemEntry<ExComponentItem> CHIPS_SYALS                = foodItem("chips_syals"               ,"Syals"                        ,"事乐薯片"      ,"potato/chips_syals"      ,Foods.CHIPS_SYALS);
    public static final ItemEntry<ExComponentItem> CHIPS_BAG                  = foodItem("chips_bag"                 ,"Bag O' Chips"                 ,"袋装薯片"      ,"potato/chips_bag"        ,Foods.CHIPS_BAG);
    public static final ItemEntry<ExComponentItem> CHIPS_KETTLE               = foodItem("chips_kettle"              ,"Kettle Chips"                 ,"手作薯片"      ,"potato/chips_kettle"     ,Foods.CHIPS_KETTLE);
    public static final ItemEntry<ExComponentItem> CHIPS_NAQUADAH             = foodItem("chips_naquadah"            ,"Naquadah Chips"               ,"硅岩薯片"      ,"potato/chips_naquadah"   ,Foods.CHIPS_NAQUADAH);
    public static final ItemEntry<ExComponentItem> CHIPS_REDUCED_FAT          = foodItem("chips_reduced_fat"         ,"Bay Salmon Reduced Fat Chips" ,"湾鲑牌减脂薯片","potato/chips_reduced_fat",Foods.CHIPS_REDUCED_FAT);
    //public static final ItemEntry<Item> CHIPS_VINEGAR              = item("chips_vinegar"             ,"Vinegar Chips"                ,"醋味薯片"      ,"potato/chips_vinegar"             );

    //sandwich
//    public static final ItemEntry<Item> SANDWICH_BACON        = item("sandwich_bacon"       ,"Bacon Sandwich"       ,"培根三明治"      ,"sandwich/bacon"       );
//    public static final ItemEntry<Item> SANDWICH_BACON_LARGE  = item("sandwich_bacon_large" ,"Large Bacon Sandwich" ,"大号培根三明治"  ,"sandwich/bacon_large" );
//    public static final ItemEntry<Item> SANDWICH_CHEESE       = item("sandwich_cheese"      ,"Cheese Sandwich"      ,"芝士三明治"      ,"sandwich/cheese"      );
//    public static final ItemEntry<Item> SANDWICH_CHEESE_LARGE = item("sandwich_cheese_large","Large Cheese Sandwich","大号芝士三明治"  ,"sandwich/cheese_large");
//    public static final ItemEntry<Item> SANDWICH_STEAK        = item("sandwich_steak"       ,"Steak Sandwich"       ,"牛肉三明治"      ,"sandwich/steak"       );
//    public static final ItemEntry<Item> SANDWICH_STEAK_LARGE  = item("sandwich_steak_large" ,"Large Steak Sandwich" ,"大号牛肉三明治"  ,"sandwich/steak_large" );
//    public static final ItemEntry<Item> SANDWICH_VEGGIE       = item("sandwich_veggie"      ,"Veggie Sandwich"      ,"蔬菜三明治"      ,"sandwich/veggie"      );
//    public static final ItemEntry<Item> SANDWICH_VEGGIE_LARGE = item("sandwich_veggie_large","Large Veggie Sandwich","大号蔬菜三明治"  ,"sandwich/veggie_large");
//    public static final ItemEntry<Item> SANDWICH_TOAST        = item("sandwich_toast"       ,"Toast Sandwich"       ,"吐司三明治"      ,"sandwich/toast"       );
//    public static final ItemEntry<Item> SANDWICH_VIBRANT      = item("sandwich_vibrant"     ,"Vibrant Sandwich"     ,"Vibrant Sandwich","sandwich/vibrant"     );

    //seed
//    public static final ItemEntry<Item> SEED_UNKNOWN     = item("seed_unknown"    ,"Undetermined GTMFO Seeds","不明GTMFO种子","seed/unknown"    );
//    public static final ItemEntry<Item> SEED_ARTICHOKE   = item("seed_artichoke"  ,"Artichoke Seeds"         ,"洋蓟种子"     ,"seed/artichoke"  );
//    public static final ItemEntry<Item> SEED_BASIL       = item("seed_basil"      ,"Basil Seeds"             ,"罗勒种子"     ,"seed/basil"      );
//    public static final ItemEntry<Item> SEED_BEAN        = item("seed_bean"       ,"Beans"                   ,"菜豆"         ,"seed/bean"       );
//    public static final ItemEntry<Item> SEED_COFFEE      = item("seed_coffee"     ,"Coffee Seed"             ,"咖啡种子"     ,"seed/coffee"     );
//    public static final ItemEntry<Item> SEED_COTTON      = item("seed_cotton"     ,"Cotton Seeds"            ,"棉花种子"     ,"seed/cotton"     );
//    public static final ItemEntry<Item> SEED_CUCUMBER    = item("seed_cucumber"   ,"Cucumber Seeds"          ,"黄瓜种子"     ,"seed/cucumber"   );
//    public static final ItemEntry<Item> SEED_EGGPLANT    = item("seed_eggplant"   ,"Eggplant Seeds"          ,"茄子种子"     ,"seed/eggplant"   );
//    public static final ItemEntry<Item> SEED_GARLIC      = item("seed_garlic"     ,"Garlic Clove"            ,"大蒜瓣"       ,"seed/garlic"     );
//    public static final ItemEntry<Item> SEED_GRAPE       = item("seed_grape"      ,"Grape Seeds"             ,"葡萄种子"     ,"seed/grape"      );
//    public static final ItemEntry<Item> SEED_HORSERADISH = item("seed_horseradish","Horseradish Seeds"       ,"辣根种子"     ,"seed/horseradish");
//    public static final ItemEntry<Item> SEED_ONION       = item("seed_onion"      ,"Onion Seeds"             ,"洋葱种子"     ,"seed/onion"      );
//    public static final ItemEntry<Item> SEED_OREGANO     = item("seed_oregano"    ,"Oregano Seeds"           ,"牛至种子"     ,"seed/oregano"    );
//    public static final ItemEntry<Item> SEED_PEA         = item("seed_pea"        ,"Peas"                    ,"豌豆"         ,"seed/pea"        );
//    public static final ItemEntry<Item> SEED_SOY         = item("seed_soy"        ,"Soybean Seeds"           ,"大豆种子"     ,"seed/soy"        );
//    public static final ItemEntry<Item> SEED_TOMATO      = item("seed_tomato"     ,"Tomato Seeds"            ,"番茄种子"     ,"seed/tomato"     );
//    public static final ItemEntry<Item> SEED_WHITE_GRAPE = item("seed_white_grape","White Grape Seeds"       ,"白葡萄种子"   ,"seed/white_grape");

    //shape
//    public static final ItemEntry<Item> SHAPE_PASTA_BLANK       = item("shape_pasta_blank"      ,"Blank Pasta Extruder Shape"      ,"空青铜模板"              ,"shape/pasta/blank"      );
//    public static final ItemEntry<Item> SHAPE_PASTA_DITALINI    = item("shape_pasta_ditalini"   ,"Ditalini Pasta Extruder Shape"   ,"青铜模头（意式手指面）"  ,"shape/pasta/ditalini"   );
//    public static final ItemEntry<Item> SHAPE_PASTA_LASAGNA     = item("shape_pasta_lasagna"    ,"Lasagna Pasta Extruder Shape"    ,"青铜模头（意式千层面）"  ,"shape/pasta/lasagna"    );
//    public static final ItemEntry<Item> SHAPE_PASTA_RIGATONI    = item("shape_pasta_rigatoni"   ,"Rigatoni Pasta Extruder Shape"   ,"青铜模头（意式粗通心粉）","shape/pasta/rigatoni"   );
//    public static final ItemEntry<Item> SHAPE_PASTA_SPAGHETTI   = item("shape_pasta_spaghetti"  ,"Spaghetti Pasta Extruder Shape"  ,"青铜模头（意式直面）"    ,"shape/pasta/spaghetti"  );
//    public static final ItemEntry<Item> SHAPE_PASTA_TAGLIATELLE = item("shape_pasta_tagliatelle","Tagliatelle Pasta Extruder Shape","青铜模头（意式干面）"    ,"shape/pasta/tagliatelle");

    //slicer_blade
    public static final ItemEntry<Item> SLICER_BLADE_FLAT      = item("slicer_blade_flat"     ,"Slicer Blade (Flat)"   ,"切片机刀片（切片）"  ,"slicer_blade/flat"     );
    public static final ItemEntry<Item> SLICER_BLADE_STRIPES   = item("slicer_blade_stripes"  ,"Slicer Blade (Stripes)","切片机刀片（切条）"  ,"slicer_blade/stripes"  );
    public static final ItemEntry<Item> SLICER_BLADE_OCTAGONAL = item("slicer_blade_octagonal","Slicer Blade (Eights)" ,"切片机刀片（八等分）","slicer_blade/octagonal");
    public static final ItemEntry<Item> SLICER_BLADE_PITTER    = item("slicer_blade_pitter"   ,"Slicer Blade (Pitter)" ,"切片机刀片（去核）"  ,"slicer_blade/pitter");

    //smore
    public static final ItemEntry<ExComponentItem> SMORE_1  = smore(1 ,"S'more S'mingot"                          ,"巧克力棉花糖夹心饼干"        ,Foods.SMORE_1,false);
    public static final ItemEntry<ExComponentItem> SMORE_2  = smore(2 ,"MoreS'more DoubleS'mingot"                ,"双层巧克力棉花糖夹心饼干"    ,Foods.SMORE_2,false);
    public static final ItemEntry<ExComponentItem> SMORE_4  = smore(4 ,"FourS'more QuadS'mingot"                  ,"四层巧克力棉花糖夹心饼干"    ,Foods.SMORE_4,false);
    public static final ItemEntry<ExComponentItem> SMORE_8  = smore(8 ,"EightS'more OctoS'mingot"                 ,"八层巧克力棉花糖夹心饼干"    ,Foods.SMORE_8 ,true);
    public static final ItemEntry<ExComponentItem> SMORE_16 = smore(16,"SixteenS'more HexadecaS'mingot"           ,"十六层巧克力棉花糖夹心饼干"  ,Foods.SMORE_16,true);
    public static final ItemEntry<ExComponentItem> SMORE_32 = smore(32,"Half-stack-o'-S'more TriacontadyoS'mingot","三十二层巧克力棉花糖夹心饼干",Foods.SMORE_32,true);
    public static final ItemEntry<ExComponentItem> SMORE_64 = smore(64,"Stack-o'-S'more HexecontatessaraS'mingot" ,"六十四层巧克力棉花糖夹心饼干",Foods.SMORE_64,true);
    public static final ItemEntry<ExComponentItem> SMOGUS_1     = smogus("smogus_1"    ,"S'mogus S'mingot"          ,"牛奶巧克力棉花糖夹心内鬼饼干"    ,"smore/sus1"        ,Foods.SMOGUS, GTMFOBlocks.SMOGUS_1);
    public static final ItemEntry<ExComponentItem> SMOGUS_2     = smogus("smogus_2"    ,"MultiS'mogus GrandS'mingot","多重牛奶巧克力棉花糖夹心内鬼饼干","smore/sus2"        ,Foods.SMOGUS_2,GTMFOBlocks.SMOGUS_2);
    public static final ItemEntry<ExComponentItem> SMOGUS_4     = smogus("smogus_4"    ,"AllS'mogus OmniS'mingot"   ,"全能牛奶巧克力棉花糖夹心内鬼饼干","smore/sus4"        ,Foods.SMOGUS_4,GTMFOBlocks.SMOGUS_4);
    public static final ItemEntry<ExComponentItem> SMOGUS_HEART = smogus("smogus_heart","Heart of the S'mogus"      ,"夹心内鬼饼干之心"                ,"smore/smogus_heart",Foods.EMPTY,GTMFOBlocks.SMOGUS_HEART);



    public static final ItemEntry<Item> MILK_CHOCOLATE     = item("milk_chocolate"    ,"Milk Chocolate"    ,"牛奶巧克力"  ,"smore/milk_chocolate"    );
    public static final ItemEntry<Item> MILK_CHOCOLATE_HOT = item("milk_chocolate_hot","Hot Milk Chocolate","热牛奶巧克力","smore/milk_chocolate_hot");
    public static final ItemEntry<Item> MARSHMALLOW_MATTER = item("marshmallow_matter","Marshmallow Matter","棉花软糖糖胶","smore/marshmallow_matter");

    public static final ItemEntry<Item> GRAHAM_CRACKER                 = item("graham_cracker"                ,"Graham Cracker"                ,"全麦饼干"      ,"smore/graham_cracker/graham_cracker" );
    public static final ItemEntry<Item> GRAHAM_CRACKER_HOT             = item("graham_cracker_hot"            ,"Hot Graham Cracker"            ,"热全麦饼干"    ,"smore/graham_cracker/hot"            );
    public static final ItemEntry<Item> GRAHAM_CRACKER_UNGRADED        = item("graham_cracker_ungraded"       ,"Ungraded Graham Cracker"       ,"未筛选全麦饼干","smore/graham_cracker/ungraded"       );
    public static final ItemEntry<Item> GRAHAM_CRACKER_BROKEN          = item("graham_cracker_broken"         ,"Broken Graham Cracker"         ,"断裂全麦饼干"  ,"smore/graham_cracker/broken"         );
    public static final ItemEntry<Item> GRAHAM_CRACKER_DOUGH           = item("graham_cracker_dough"          ,"Graham Cracker Dough"          ,"全麦饼干面团"  ,"smore/graham_cracker/dough"          );
    public static final ItemEntry<Item> GRAHAM_CRACKER_DOUGH_HOT       = item("graham_cracker_dough_hot"      ,"Hot Graham Cracker Dough"      ,"热全麦饼干面团","smore/graham_cracker/dough_hot"      );
    public static final ItemEntry<Item> GRAHAM_CRACKER_DOUGH_CHUNK_HOT = item("graham_cracker_dough_chunk_hot","Hot Graham Cracker Dough Chunk","热全麦饼干坯"  ,"smore/graham_cracker/dough_chunk_hot");
    //sorbet
//    public static final ItemEntry<ExComponentItem> SORBET         = foodItem("sorbet"        ,"Plain Sorbet"  ,"原味雪葩"      ,"sorbet/plain"  ,Foods.SORBET_PLAIN);
//    public static final ItemEntry<ExComponentItem> SORBET_APPLE   = foodItem("sorbet_apple"  ,"Apple Sorbet"  ,"苹果雪葩"      ,"sorbet/apple"  ,Foods.SORBET_FRUIT);
//    public static final ItemEntry<ExComponentItem> SORBET_APRICOT = foodItem("sorbet_apricot","Apricot Sorbet","杏子雪葩"      ,"sorbet/apricot",Foods.SORBET_FRUIT);
//    public static final ItemEntry<ExComponentItem> SORBET_CHORUS  = foodItem("sorbet_chorus" ,"Chorus Sorbet" ,"紫颂果雪葩"    ,"sorbet/chorus" ,Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> SORBET_GRAPE   = foodItem("sorbet_grape"  ,"Grape Sorbet"  ,"葡萄雪葩"      ,"sorbet/grape"  ,Foods.SORBET_FRUIT);
//    public static final ItemEntry<ExComponentItem> SORBET_LIME    = foodItem("sorbet_lime"   ,"Lime Sorbet"   ,"酸柠雪葩"      ,"sorbet/lime"   ,Foods.SORBET_FRUIT);
//    public static final ItemEntry<ExComponentItem> SORBET_VIBRANT = foodItem("sorbet_vibrant","Vibrant Sorbet","Vibrant Sorbet","sorbet/vibrant",Foods.EMPTY);

    //structural_mesh
//    public static final ItemEntry<Item> APPLE_STRUCTURAL_MESH  = item("apple_structural_mesh" ,"Apple Structural Mesh" ,"苹果纤维骨架"  ,"structural_mesh/apple" );
//    public static final ItemEntry<Item> CARROT_STRUCTURAL_MESH = item("carrot_structural_mesh","Carrot Structural Mesh","胡萝卜纤维骨架","structural_mesh/carrot");

    //utility
//    public static final ItemEntry<Item> KITCHEN_RECIPE = item("kitchen_recipe","utility/kitchen_recipe");
//    public static ItemEntry<ExComponentItem> TEST_ITEM;
//    public static ItemEntry<ExComponentItem> TEST_ITEM_2;

//    public static final ItemEntry<Item> ANIMAL_FAT          = item("animal_fat" ,"Animal Fat" ,"动物脂肪");

//    public static final ItemEntry<Item> BACON     = item("bacon"    ,"Bacon"         ,"培根"  );
//    public static final ItemEntry<Item> BACON_RAW = item("bacon_raw","Uncooked Bacon","生培根");
//    public static final ItemEntry<Item> BAKED_BEANS = item("baked_beans","Baked Beans","焗豆");
//    public static final ItemEntry<Item> BANANA_PEEL = item("banana_peel","Banana Peel","香蕉皮");
//    public static final ItemEntry<Item> BEANS_ON_TOAST = item("beans_on_toast","Beans on Toast","焗豆吐司");
//    public static final ItemEntry<Item> BEANS_WITH_SAUCE = item("beans_with_sauce","Beans with Sauce","番茄酱豆");
//    public static final ItemEntry<Item> BEEF_SLICE         = item("beef_slice"        ,"Beef Slice"        ,"生牛肉片");
//    public static final ItemEntry<Item> BEEF_SLICE_ROASTED = item("beef_slice_roasted","Roasted Beef Slice","熟牛肉片");
//    public static final ItemEntry<Item> BERRY_MEDLEY = item("berry_medley","Berry Medley","什锦浆果");
//    public static final ItemEntry<Item> BRICK_ADOBE = item("brick_adobe","Adobe Brick","土坯砖");
//    public static final ItemEntry<Item> BRICK_MUB   = item("brick_mud"  ,"Mud Brick"  ,"泥砖"  );
//    public static final ItemEntry<Item> CAKE_BOTTOM       = item("cake_bottom"      ,"Cake Bottom"      ,"蛋糕底"  );
//    public static final ItemEntry<Item> CAKE_BOTTOM_BAKED = item("cake_bottom_baked","Baked Cake Bottom","烤蛋糕底");

//    public static final ItemEntry<ExComponentItem> CHUM        = foodItem("chum"       ,"Chum"                 ,"海霸糊"    ,Foods.CHUM);
//    public static final ItemEntry<ExComponentItem> CHUM_BUCKET = foodItem("chum_bucket","Chum Bucket Kebab Mix","烤海霸拌桶",Foods.EMPTY);
//    public static final ItemEntry<ExComponentItem> CHUM_STICK  = foodItem("chum_stick" ,"Chum on a Stick"      ,"海霸糊棒"  ,Foods.CHUM_STICK,STACK_16);
//    public static final ItemEntry<Item> COCOA_BEANS_ROASTED = item("cocoa_beans_roasted","Roasted Cocoa Beans","烘焙可可豆");
//    public static final ItemEntry<Item> COCOA_NIBS          = item("cocoa_nibs"         ,"Ground Cocoa Nibs"  ,"可可粉"    );
//    public static final ItemEntry<Item> COFFEE_FILTER = item("coffee_filter","Coffee Filter","咖啡滤纸");
//    public static final ItemEntry<Item> EMERGENCY_RATIONS = item("emergency_rations","Emergency Rations","应急配给");
//    public static final ItemEntry<Item> FERMENTED_CHORUS     = item("fermented_chorus"    ,"Fermented Chorus"    ,"发酵紫颂果"  );
//    public static final ItemEntry<Item> FERMENTED_CHORUS_PIE = item("fermented_chorus_pie","Fermented Chorus Pie","发酵紫颂果派");
//    public static final ItemEntry<Item> FISH_AND_CHIPS = item("fish_and_chips","Fish'n'Chips","炸鱼薯条");
//    public static final ItemEntry<Item> FRIED_FISH     = item("fried_fish"    ,"Fried Fish"  ,"炸鱼"    );
//    public static final ItemEntry<Item> FULL_BREAKFAST = item("full_breakfast","Full Breakfast","全英早餐");
    public static final ItemEntry<Item> GELATIN = item("gelatin","Gelatin","明胶");

//    public static final ItemEntry<Item> GUMMY_BEAR = item("gummy_bear","Gummy Bear","小熊软糖");
//    public static final ItemEntry<ExComponentItem> HOT_BEETROOT_SOUP = foodItem("hot_beetroot_soup","Hot Beetroot Soup","热甜菜汤",Foods.HOT_BEETROOT_SOUP,STACK_1);
//    public static final ItemEntry<ExComponentItem> HOT_MUSHROOM_STEW = foodItem("hot_mushroom_stew","Hot Mushroom Stew","热蘑菇煲",Foods.HOT_MUSHROOM_STEW,STACK_1);
//    public static final ItemEntry<ExComponentItem> HOT_RABBIT_STEW   = foodItem("hot_rabbit_stew"  ,"Hot Rabbit Stew"  ,"热兔肉煲",Foods.HOT_RABBIT_STEW  ,STACK_1);
//    public static final ItemEntry<Item> IV_BAG = item("iv_bag","IV Bag","静脉注射(IV)袋");
    public static final ItemEntry<Item> MARSHMALLOW               = item("marshmallow"              ,"Marshmallow"           ,"棉花软糖"  );
//    public static final ItemEntry<Item> MARSHMALLOW_STICK         = item("marshmallow_stick"        ,"Marshmallow on a Stick","棉花软糖串");
//    public static final ItemEntry<Item> MARSHMALLOW_STICK_ROASTED = item("marshmallow_stick_roasted","Roasted Marshmallow"   ,"烤棉花软糖");
    public static final ItemEntry<Item> MINCE_MEAT        = item("mince_meat"       ,"Mince Meat"       ,"肉末"  );
    public static final ItemEntry<Item> MINCE_MEAT_COOKED = item("mince_meat_cooked","Cooked Mince Meat","熟肉末");
//    public static final ItemEntry<Item> MEAT_INGOT        = item("meat_ingot"       ,"Meat Ingot"       ,"肉锭"  );
//    public static final ItemEntry<Item> MEAT_INGOT_COOKED = item("meat_ingot_cooked","Cooked Meat Ingot","熟肉锭");
//    public static final ItemEntry<Item> MUSHY_PEAS = item("mushy_peas","Mushy Peas","豌豆糊");
//    public static final ItemEntry<Item> PIE_CRUST = item("pie_crust","Pie Crust","馅饼皮");
//    public static final ItemEntry<Item> RICE_COOKED = item("rice_cooked","Cooked Rice","熟米饭");
//    public static final ItemEntry<Item> ROTTEN_FISH = item("rotten_fish","Rotten Fish","臭鱼");
//    public static final ItemEntry<Item> ROTTEN_MEAT = item("rotten_meat","Rotten Meat","臭肉");
//    public static final ItemEntry<Item> SAUSAGE          = item("sausage"         ,"Sausage"              ,"香肠"    );
//    public static final ItemEntry<Item> SAUSAGE_RAW      = item("sausage_raw"     ,"Raw Sausage"          ,"生香肠"  );
//    public static final ItemEntry<Item> SAUSAGE_ROLL     = item("sausage_roll"    ,"Sausage Roll"         ,"香肠卷"  );
//    public static final ItemEntry<Item> SAUSAGE_ROLL_RAW = item("sausage_roll_raw","Uncooked Sausage Roll","生香肠卷");
//    public static final ItemEntry<Item> SCRAP_MEAT = item("scrap_meat","Scrap Meat","废肉");
//    public static final ItemEntry<Item> SEASONED_PORK = item("seasoned_pork","Seasoned Pork","调味猪肉");
//    public static final ItemEntry<Item> SHEPHERDS_PIE = item("shepherds_pie","Shepherd's Pie","牧羊人派");
//    public static final ItemEntry<Item> SPRINKLER = item("sprinkler","Sprinkler","洒水器");

    // 175-189 left blank for organic circuits

    public static void init() {
//        TEST_ITEM = REGISTRATE.item("test_item",ExComponentItem::create)
//                .model((ctx,provider) ->
//                        provider.generated(ctx::getEntry, provider.modLoc("item/utility/test_item")))
//                .onRegister(attach(new BlockItemComponent(GTMFOBlocks.SMORE_1::get)))
//                .register();
//
//        TEST_ITEM_2 = REGISTRATE.item("test_item_2",ExComponentItem::create)
//                .model((ctx,provider) ->
//                        provider.generated(ctx::getEntry, provider.modLoc("item/utility/test_item_2")))
//                .onRegister(attach(
//                        new BlockItemComponent(GTMFOBlocks.SMORE_64::get),Foods.BACON))
//                .register();
    }

}
