package com.ironsword.gregtechmodernfoodoption.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.FoodStats;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.ironsword.gregtechmodernfoodoption.api.item.component.GTMFOFoodStats;
import com.ironsword.gregtechmodernfoodoption.api.mixin.IContainerItem;
import com.ironsword.gregtechmodernfoodoption.api.mixin.IEatingDuration;
import com.ironsword.gregtechmodernfoodoption.api.mixin.INutrients;
import com.ironsword.gregtechmodernfoodoption.data.GTMFOProviderTypes;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import static com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries.REGISTRATE;

@SuppressWarnings("unused")
@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class GTMFOItems {
    private static final String CN = "占位文本";

    static {
        REGISTRATE.creativeModeTab(()-> GTMFOCreativeModeTabs.MAIN_TAB);
    }

    private static <T extends ComponentItem> NonNullConsumer<T> attach(IItemComponent... components) {
        return item -> item.attachComponents(components);
    }

//    private static FoodStats food(int nutrition, float saturation) {
//        return new FoodStats(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build());
//    }
//    private static ItemEntry<ComponentItem> testFoodItem(String id, int nutrition, float saturation) {
//        return REGISTRATE.item(id, ComponentItem::create)
//                .defaultLang()
//                .model((ctx,prov)->
//                    prov.generated(ctx::getEntry,prov.modLoc("item/crop/%s".formatted(ctx.getName())))
//                )
//                .onRegister(attach(food(nutrition, saturation)))
//                .register();
//    }

//    private static NonNullBiConsumer<DataGenContext<Item, ComponentItem>, RegistrateItemModelProvider> itemModel(String path) {
//        return (ctx,prov)->
//                prov.generated(ctx::getEntry,prov.modLoc("item/"+path));
//
//    }

//    private static ItemEntry<ComponentItem> testNFI(String id, GTMFOFoodStats foodStats){
//        return REGISTRATE.item(id,ComponentItem::create)
//                .defaultLang()
//                .model((ctx,prov)->
//                        prov.generated(ctx::getEntry,prov.modLoc("item/crop/"+ctx.getName()))
//                )
//                .onRegister(attach(foodStats))
//                .register();
//    }

    private static ItemEntry<Item> item(String id){
        return REGISTRATE.item(id,Item::new).defaultLang().defaultModel().register();
    }

    private static ItemEntry<Item> item(String id,String path){
        return REGISTRATE.item(id,Item::new).defaultLang()
                .model((ctx,prov)->
                        prov.generated(ctx::getEntry,prov.modLoc("item/"+path))
                )
                .register();
    }

    private static ItemEntry<Item> item(String id,String enLang,String cnLang){
        return REGISTRATE.item(id,Item::new)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .defaultModel()
                .register();
    }

    private static ItemEntry<Item> item(String id,  String enLang, String cnLang, String path){
        return REGISTRATE.item(id,Item::new)
                .lang(enLang)
                .setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->
                        prov.add(ctx.get().getDescriptionId(),cnLang))
                .model((ctx,prov)->
                        prov.generated(ctx::getEntry,prov.modLoc("item/"+path)))
                .register();
    }

    //apple_candy
    static ItemEntry<Item> APPLE_HARD_CANDY         = item("apple_hard_candy",        "Apple Hard Candy",        "苹果硬糖",    "apple_candy/hard");
    static ItemEntry<Item> APPLE_HARD_CANDY_HOT     = item("apple_hard_candy_hot",    "Hot Apple Hard Candy",    "热苹果硬糖",  "apple_candy/hot");
    static ItemEntry<Item> APPLE_HARD_CANDY_PLATE   = item("apple_hard_candy_plate",  "Apple Hard Candy Sheet",  "苹果硬糖片",  "apple_candy/plate");
    static ItemEntry<Item> APPLE_HARD_CANDY_RESIN   = item("apple_hard_candy_resin",  "Apple Hard Candy Resin",  "苹果硬糖糖坯","apple_candy/resin");
    static ItemEntry<Item> APPLE_HARD_CANDY_CRUSHED = item("apple_hard_candy_crushed","Crushed Apple Hard Candy","苹果硬糖碎",  "apple_candy/crushed");

    //berry
    static ItemEntry<Item> BLACKBERRY    = item("blackberry",   "Blackberry",   "黑莓",    "berry/blackberry");
    static ItemEntry<Item> BLUEBERRY     = item("blueberry",    "Blueberry",    "蓝莓",    "berry/blueberry");
    static ItemEntry<Item> CRANBERRY     = item("cranberry",    "Cranberry",    "蔓越莓",  "berry/cranberry");
    static ItemEntry<Item> ELDERBERRY    = item("elderberry",   "Elderberry",   "接骨木莓","berry/elderberry");
    static ItemEntry<Item> LINGONBERRY   = item("lingonberry",  "Lingonberry",  "越橘",    "berry/lingonberry");
    static ItemEntry<Item> RASPBERRY     = item("raspberry",    "Raspberry",    "树莓",    "berry/raspberry");
    static ItemEntry<Item> STRAWBERRY    = item("strawberry",   "Strawberry",   "草莓",    "berry/strawberry");
    static ItemEntry<Item> BLACK_CURRANT = item("black_currant","Black Currant","黑加仑",  "berry/black_currant");
    static ItemEntry<Item> RED_CURRANT   = item("red_currant",  "Red Currant",  "红加仑",  "berry/red_currant");
    static ItemEntry<Item> WHITE_CURRANT = item("white_currant","White Currant","白加仑",  "berry/white_currant");

    //bread
    static ItemEntry<Item> WOODEN_FORM_BUN      = item("wooden_form_bun",     "Bun Wooden Form",     "木制圆面包模具",  "bread/wooden_form_bun");
    static ItemEntry<Item> WOODEN_FORM_BREAD    = item("wooden_form_bread",   "Bread Wooden Form",   "木制面包模具",    "bread/wooden_form_bread");
    static ItemEntry<Item> WOODEN_FORM_BAGUETTE = item("wooden_form_baguette","Baguette Wooden Form","木制法棍面包模具","bread/wooden_form_baguette");
    static ItemEntry<Item> BUN                  = item("bun",                 "Bun",                 "圆面包",          "bread/bun");
    static ItemEntry<Item> BUN_UNBAKED          = item("bun_unbaked",         "Unbaked Bun",         "圆面包坯",        "bread/bun_unbaked");
    static ItemEntry<Item> BUN_PRESLICED        = item("bun_presliced",       "Pre-Sliced Bun",      "切好的圆面包",    "bread/bun_presliced");
    static ItemEntry<Item> BREAD_UNBAKED        = item("bread_unbaked",       "Unbaked Bread",       "面包坯",          "bread/bread_unbaked");
    static ItemEntry<Item> BREAD_PRESLICED      = item("bread_presliced",     "Pre-Sliced Bread",    "切好的面包",      "bread/bread_presliced");
    static ItemEntry<Item> BREAD_SLICE          = item("bread_slice",         "Bread Slice",         "面包片",          "bread/bread_slice");
    static ItemEntry<Item> TOAST                = item("toast",               "Toast",               "吐司",            "bread/toast");
    static ItemEntry<Item> BAGUETTE             = item("baguette",            "Baguette",            "法棍面包",        "bread/baguette");
    static ItemEntry<Item> BAGUETTE_UNCOOKED    = item("baguette_unbaked",    "Unbaked Baguette",    "法棍面包坯",      "bread/baguette_unbaked");
    static ItemEntry<Item> BAGUETTE_PRESLICED   = item("baguette_presliced",  "Pre-Sliced Baguette", "切好的法棍面包",  "bread/baguette_presliced");

    //burger
    static ItemEntry<Item> BURGER_CHEESE = item("burger_cheese","Cheese Burger","芝士汉堡","burger/cheese");
    static ItemEntry<Item> BURGER_CHUM   = item("burger_chum",  "Chum Burger",  "海霸堡",  "burger/chum");
    static ItemEntry<Item> BURGER_MEAT   = item("burger_meat",  "Meat Burger",  "牛肉汉堡","burger/meat");
    static ItemEntry<Item> BURGER_VEGGIE = item("burger_veggie","Veggie Burger","蔬菜汉堡","burger/veggie");

    //caplet
    static ItemEntry<Item> CAPLET_CAP           = item("caplet_cap",          "Caplet Cap",             "囊帽",                   "caplet/cap");
    static ItemEntry<Item> CAPLET_BODY          = item("caplet_body",         "Caplet Body",            "囊体",                   "caplet/body");
    static ItemEntry<Item> CAPLET_GEL           = item("caplet_gel",          "Gel Caplet",             "明胶胶囊",               "caplet/gel");
    static ItemEntry<Item> CAPLET_PARACETAMOL   = item("caplet_paracetamol",  "Paracetamol Caplet",     "对乙酰氨基酚胶囊",       "caplet/paracetamol");
    static ItemEntry<Item> CAPLET_PLUTONIUM_241 = item("caplet_plutonium_241","Plutonium-241 Caplet",   "钚-241胶囊",             "caplet/plutonium_241");
    static ItemEntry<Item> CAPLET_CHORUS        = item("caplet_chorus",       "Fermented Chorus Caplet","Fermented Chorus Caplet","caplet/chorus");
    static ItemEntry<Item> CAPLET_VIBRANT       = item("caplet_vibrant",      "Vibrant Caplet",         "Vibrant Caplet",         "caplet/vibrant");

    //coffee
    static ItemEntry<Item> COFFEE_CHERRY                = item("coffee_cherry",               "Coffee Cherry",               "咖啡果",        "coffee/cherry");
    static ItemEntry<Item> COFFEE_CHERRY_LARGE          = item("coffee_cherry_large",         "Large Coffee Cherry",         "大咖啡果",      "coffee/cherry_large");
    static ItemEntry<Item> COFFEE_CHERRY_SMALL          = item("coffee_cherry_small",         "Small Coffee Cherry",         "小咖啡果",      "coffee/cherry_small");
    static ItemEntry<Item> COFFEE_BEANS_RAW_LARGE       = item("coffee_beans_raw_large",      "Large Raw Coffee Beans",      "大粒生咖啡豆",  "coffee/raw_large");
    static ItemEntry<Item> COFFEE_BEANS_RAW_SMALL       = item("coffee_beans_raw_small",      "Small Raw Coffee Beans",      "小粒生咖啡豆",  "coffee/raw_small");
    static ItemEntry<Item> COFFEE_BEANS_FERMENTED_LARGE = item("coffee_beans_fermented_large","Large Fermented Coffee Beans","发酵大粒咖啡豆","coffee/fermented_large");
    static ItemEntry<Item> COFFEE_BEANS_FERMENTED_SMALL = item("coffee_beans_fermented_small","Small Fermented Coffee Beans","发酵小粒咖啡豆","coffee/fermented_small");
    static ItemEntry<Item> COFFEE_BEANS_DRIED_LARGE     = item("coffee_beans_dried_large",    "Large Dried Coffee Beans",    "烘干大粒咖啡豆","coffee/dried_large");
    static ItemEntry<Item> COFFEE_BEANS_DRIED_SMALL     = item("coffee_beans_dried_small",    "Small Dried Coffee Beans",    "烘干小粒咖啡豆","coffee/dried_small");
    static ItemEntry<Item> COFFEE_BEANS_HULLED_LARGE    = item("coffee_beans_hulled_large",   "Large Hulled Coffee Beans",   "去壳大粒咖啡豆","coffee/hulled_large");
    static ItemEntry<Item> COFFEE_BEANS_HULLED_SMALL    = item("coffee_beans_hulled_small",   "Small Hulled Coffee Beans",   "去壳小粒咖啡豆","coffee/hulled_small");
    static ItemEntry<Item> COFFEE_BEANS_ROASTED_LARGE   = item("coffee_beans_roasted_large",  "Large Roasted Coffee Beans",  "烘焙大粒咖啡豆","coffee/roasted_large");
    static ItemEntry<Item> COFFEE_BEANS_ROASTED_SMALL   = item("coffee_beans_roasted_small",  "Small Roasted Coffee Beans",  "烘焙小粒咖啡豆","coffee/roasted_small");

    //container
    static ItemEntry<Item> BAKING_TRAY           = item("baking_tray",          "Baking Tray",             "烤盘",        "container/baking_tray");
    static ItemEntry<Item> CAN                   = item("can",                  "Can",                     "易拉罐",      "container/can");
    static ItemEntry<Item> CERAMIC_BOWL          = item("ceramic_bowl",         "Ceramic Bowl",            "瓷碗",        "container/bowl");
    static ItemEntry<Item> CERAMIC_BOWL_DIRTY    = item("ceramic_bowl_dirty",   "Dirty Bowl",              "脏碗",        "container/bowl_dirty");
    static ItemEntry<Item> CERAMIC_BOWL_UNFIRED  = item("ceramic_bowl_unfired", "Unfired Bone China Bowl", "未烧制骨瓷碗","container/bowl_unfired");
    static ItemEntry<Item> CERAMIC_PLATE         = item("ceramic_plate",        "Ceramic Plate",           "瓷盘",        "container/plate");
    static ItemEntry<Item> CERAMIC_PLATE_DIRTY   = item("ceramic_plate_dirty",  "Dirty Plate",             "脏盘子",      "container/plate_dirty");
    static ItemEntry<Item> CERAMIC_PLATE_UNFIRED = item("ceramic_plate_unfired","Unfired Bone China Plate","未烧制骨瓷盘","container/plate_unfired");
    static ItemEntry<Item> CUP_EMPTY             = item("cup_empty",            "Empty Cup",               "空杯",        "container/cup_empty");
    static ItemEntry<Item> CUP_UNFIRED           = item("cup_unfired",          "Unfired Cup",             "未烧制杯子",  "container/cup_unfired");
    static ItemEntry<Item> PAPER_BAG             = item("paper_bag",            "Paper Bag",               "纸袋",        "container/bag");
    static ItemEntry<Item> PAPER_BAG_USED        = item("paper_bag_used",       "Used Paper Bag",          "用过的纸袋",  "container/bag_used");
    static ItemEntry<Item> PLASTIC_BOTTLE        = item("plastic_bottle",       "Plastic Bottle",          "塑料瓶",      "container/plastic_bottle");

    //corn
    static ItemEntry<Item> FLAVORED_POPCORN_FLAKE = item("flavored_flake"        ,"Flavored Popcorn Flake","调味爆米花粒","corn/flavored_flake"   );
    static ItemEntry<Item> CORN_COB               = item("corn_cob"              ,"Corn Cob"              ,"玉米芯"      ,"corn/cob"              );
    static ItemEntry<Item> CORN_EAR               = item("corn_ear"              ,"Corn Ear"              ,"玉米穗"      ,"corn/ear"              );
    static ItemEntry<Item> CORN_EAR_DRIED         = item("corn_ear_dried"        ,"Dried Corn Ear"        ,"烘干玉米穗"  ,"corn/ear_dried"        );
    static ItemEntry<Item> CORN_KERNEL            = item("corn_kernel"           ,"Corn Kernel"           ,"玉米粒"      ,"corn/kernel"           );
    static ItemEntry<Item> CORN_KERNEL_ACCEPTABLE = item("corn_kernel_acceptable","Acceptable Corn Kernel","合格级玉米粒","corn/kernel_acceptable");

    //crop
    static ItemEntry<Item> ARTICHOKE      = item("artichoke"     ,"Artichoke Heart"  ,"洋蓟心"  ,"crop/artichoke"     );
    static ItemEntry<Item> BLACK_PEPPER   = item("black_pepper"  ,"Black Peppercorns","黑胡椒籽","crop/black_pepper"  );
    static ItemEntry<Item> CARROT_SLICE   = item("carrot_slice"  ,"Carrot Slice"     ,"胡萝卜片","crop/carrot_slice"  );
    //static ItemEntry<Item> COFFEE_CHERRY= item("coffee_cherry" ,"Coffee Cherry"    ,"咖啡果"  ,"crop/coffee"        );
    static ItemEntry<Item> COTTON         = item("cotton"        ,"Cotton"           ,"棉花"    ,"crop/cotton"        );
    static ItemEntry<Item> CUCUMBER       = item("cucumber"      ,"Cucumber"         ,"黄瓜"    ,"crop/cucumber"      );
    static ItemEntry<Item> CUCUMBER_SLICE = item("cucumber_slice","Cucumber Slice"   ,"黄瓜片"  ,"crop/cucumber_slice");
    static ItemEntry<Item> EGGPLANT       = item("eggplant"      ,"Eggplant"         ,"茄子"    ,"crop/eggplant"      );
    static ItemEntry<Item> EGGPLANT_SLICE = item("eggplant_slice","Eggplant Slice"   ,"茄子片"  ,"crop/eggplant_slice");
    static ItemEntry<Item> MUSHROOM_SLICE = item("mushroom_slice","Mushroom Slice"   ,"蘑菇片"  ,"crop/mushroom_slice");
    static ItemEntry<Item> OLIVE          = item("olive"         ,"Olive"            ,"橄榄"    ,"crop/olive"         );
    static ItemEntry<Item> OLIVE_SLICE    = item("olive_slice"   ,"Olive Slice"      ,"橄榄片"  ,"crop/olive_slice"   );
    static ItemEntry<Item> ONION          = item("onion"         ,"Onion"            ,"洋葱"    ,"crop/onion"         );
    static ItemEntry<Item> ONION_SLICE    = item("onion"         ,"Onion Slice"      ,"洋葱片"  ,"crop/onion_slice"   );
    static ItemEntry<Item> PEA_POD        = item("pea_pod"       ,"Pea Pod"          ,"豌豆荚"  ,"crop/pea_pod"       );
    static ItemEntry<Item> RICE           = item("rice"          ,"Rice"             ,"大米"    ,"crop/rice"          );
    static ItemEntry<Item> SOYBEAN        = item("soybean"       ,"Soybean"          ,"大豆"    ,"crop/soybean"       );
    static ItemEntry<Item> TOMATO         = item("tomato"        ,"Tomato"           ,"番茄"    ,"crop/tomato"        );
    static ItemEntry<Item> TOMATO_SLICE   = item("tomato_slice"  ,"Tomato Slice"     ,"番茄片"  ,"crop/tomato_slice"  );

    //dewar_flask
    static ItemEntry<Item> DEWAR_FLASK                = item("dewar_flask"               ,"Dewar Flask"               ,"保温杯",          "dewar_flask/new");
    static ItemEntry<Item> DEWAR_FLASK_USED           = item("dewar_flask_used"          ,"Used Dewar Flask"          ,"使用过的保温杯",  "dewar_flask/used");
    static ItemEntry<Item> DEWAR_FLASK_CAP            = item("dewar_flask_cap"           ,"Dewar Flask Cap"           ,"保温杯盖",        "dewar_flask/cap");
    static ItemEntry<Item> DEWAR_FLASK_CASING         = item("dewar_flask_casing"        ,"Dewar Flask Casing"        ,"保温杯身",        "dewar_flask/casing");
    static ItemEntry<Item> DEWAR_FLASK_CASING_LEACHED = item("dewar_flask_casing_leached","Leached Dewar Flask Casing","使用过的保温杯身","dewar_flask/casing_leached");

    //dough
    static ItemEntry<Item> DOUGH                = item("dough"               ,"Dough"               ,"面团"        ,"dough/dough"         );
    static ItemEntry<Item> DOUGH_FLAT           = item("flat_dough"          ,"Flat Dough"          ,"扁平面团"    ,"dough/flat"          );
    static ItemEntry<Item> DOUGH_SUGARY         = item("sugary_dough"        ,"Sugary Dough"        ,"甜面团"      ,"dough/sugary"        );
    static ItemEntry<Item> DOUGH_PASTA          = item("pasta_dough"         ,"Pasta Dough"         ,"意面面团"    ,"dough/pasta"         );
    static ItemEntry<Item> DOUGH_EGG_PASTA      = item("egg_pasta_dough"     ,"Egg Pasta Dough"     ,"蛋液意面面团","dough/egg_pasta"     );
    static ItemEntry<Item> DOUGH_PREMIXED_PASTA = item("premixed_pasta_dough","Premixed Pasta Dough","预拌意面面团","dough/premixed_pasta");

    //fruit
    static ItemEntry<Item> APRICOT       = item("apricot"      ,"Apricot"      ,"杏子"    ,"fruit/apricot"      );
    static ItemEntry<Item> BANANA        = item("banana"       ,"Banana"       ,"香蕉"    ,"fruit/banana"       );
    static ItemEntry<Item> BANANA_PEELED = item("banana_peeled","Peeled Banana","去皮香蕉","fruit/banana_peeled");
    static ItemEntry<Item> COCONUT       = item("coconut"      ,"Coconut"      ,"椰子"    ,"fruit/coconut"      );
    static ItemEntry<Item> GRAPES        = item("grapes"       ,"Grapes"       ,"葡萄"    ,"fruit/grapes"       );
    static ItemEntry<Item> LEMON         = item("lemon"        ,"Lemon"        ,"柠檬"    ,"fruit/lemon"        );
    static ItemEntry<Item> LIME          = item("lime"         ,"Lime"         ,"酸橙"    ,"fruit/lime"         );
    static ItemEntry<Item> MANGO         = item("mango"        ,"Mango"        ,"芒果"    ,"fruit/mango"        );
    static ItemEntry<Item> NUTMEG        = item("nutmeg"       ,"Nutmeg Seeds" ,"肉桂果"  ,"fruit/nutmeg"       );
    static ItemEntry<Item> ORANGE        = item("orange"       ,"Orange"       ,"橙子"    ,"fruit/orange"       );
    static ItemEntry<Item> WHITE_GRAPES  = item("white_grapes" ,"White Grapes" ,"白葡萄"  ,"fruit/white_grapes" );

    //gorgonzola
    static ItemEntry<Item> GORGONZOLA_WHEEL               = item("gorgonzola_wheel"              ,"Gorgonzola Wheel"              ,"戈贡佐拉奶酪轮"        ,"gorgonzola/wheel"           );
    static ItemEntry<Item> GORGONZOLA_WHEEL_SALTED        = item("gorgonzola_wheel_salted"       ,"Salted Gorgonzola Wheel"       ,"加盐戈贡佐拉奶酪轮"    ,"gorgonzola/salted"          );
    static ItemEntry<Item> GORGONZOLA_WHEEL_SLIGHTLY_AGED = item("gorgonzola_wheel_slightly_aged","Slightly Aged Gorgonzola Wheel","初步熟化戈贡佐拉奶酪轮","gorgonzola/slightly_aged"   );
    static ItemEntry<Item> GORGONZOLA_WHEEL_PUNCTURED     = item("gorgonzola_wheel_punctured"    ,"Punctured Gorgonzola Wheel"    ,"扎孔戈贡佐拉奶酪轮"    ,"gorgonzola/punctured"       );
    static ItemEntry<Item> GORGONZOLA_WHEEL_FULLY_CURED   = item("gorgonzola_wheel_fully_cured"  ,"Fully Cured Gorgonzola Wheel"  ,"硬化戈贡佐拉奶酪轮"    ,"gorgonzola/fully_cured"     );
    static ItemEntry<Item> GORGONZOLA_TRIANGULAR_SLICE    = item("gorgonzola_triangular_slice"   ,"Gorgonzola Triangular Slice"   ,"戈贡佐拉奶酪三角"      ,"gorgonzola/triangular_slice");

    //ice_cream
    static ItemEntry<Item> ICE_CREAM           = item("ice_cream"          ,"Plain Ice Cream"      ,"原味冰淇淋"      ,"ice_cream/plain"    );
    static ItemEntry<Item> ICE_CREAM_BACON     = item("ice_cream_bacon"    ,"Bacon Ice Cream"      ,"培根冰淇淋"      ,"ice_cream/bacon"    );
    static ItemEntry<Item> ICE_CREAM_BANANA    = item("ice_cream_banana"   ,"Banana Ice Cream"     ,"香蕉冰淇淋"      ,"ice_cream/banana"   );
    static ItemEntry<Item> ICE_CREAM_BEAR      = item("ice_cream_bear"     ,"Bear Ice Cream"       ,"熊先生冰淇淋"    ,"ice_cream/bear"     );
    static ItemEntry<Item> ICE_CREAM_CHIP      = item("ice_cream_chip"     ,"Potato Chip Ice Cream","薯片冰淇淋"      ,"ice_cream/chip"     );
    static ItemEntry<Item> ICE_CREAM_CHOCOLATE = item("ice_cream_chocolate","Chocolate Ice Cream"  ,"巧克力冰淇淋"    ,"ice_cream/chocolate");
    static ItemEntry<Item> ICE_CREAM_CHORUS    = item("ice_cream_chorus"   ,"Chorus Ice Cream"     ,"Chorus Ice Cream","ice_cream/chorus"   );
    static ItemEntry<Item> ICE_CREAM_CHUM      = item("ice_cream_chum"     ,"Chum Ice Cream"       ,"海霸冰淇淋"      ,"ice_cream/chum"     );
    static ItemEntry<Item> ICE_CREAM_LEMON     = item("ice_cream_lemon"    ,"Lemon Ice Cream"      ,"柠檬冰淇淋"      ,"ice_cream/lemon"    );
    static ItemEntry<Item> ICE_CREAM_MELON     = item("ice_cream_melon"    ,"Melon Ice Cream"      ,"西瓜冰淇淋"      ,"ice_cream/melon"    );
    static ItemEntry<Item> ICE_CREAM_RAINBOW   = item("ice_cream_rainbow"  ,"Rainbow Ice Cream"    ,"彩虹冰淇淋"      ,"ice_cream/rainbow"  );
    static ItemEntry<Item> ICE_CREAM_VANILLA   = item("ice_cream_vanilla"  ,"Vanilla Ice Cream"    ,"香草冰淇淋"      ,"ice_cream/vanilla"  );

    //juice
    static ItemEntry<Item> APPLE_JUICE  = item("apple_juice" ,"Apple Juice" ,"苹果汁","juice/apple" );
    static ItemEntry<Item> ORANGE_JUICE = item("orange_juice","Orange Juice","橙汁"  ,"juice/orange");

    //kebab
    static ItemEntry<Item> SKEWER            = item("skewer"           ,"Skewer"           ,"铁签"            ,"kebab/skewer"     );
    static ItemEntry<Item> KEBAB_BARG        = item("kebab_barg"       ,"Barg Kebab"       ,"伊朗叶子肉烤串"  ,"kebab/barg"       );
    static ItemEntry<Item> KEBAB_BARG_RAW    = item("kebab_barg_raw"   ,"Raw Barg Kebab"   ,"生伊朗叶子肉烤串","kebab/barg_raw"   );
    static ItemEntry<Item> KEBAB_CARROT      = item("kebab_carrot"     ,"Carrot Kebab"     ,"烤胡萝卜串"      ,"kebab/carrot"     );
    static ItemEntry<Item> KEBAB_CARROT_RAW  = item("kebab_carrot_raw" ,"Raw Carrot Kebab" ,"生胡萝卜串"      ,"kebab/carrot_raw" );
    static ItemEntry<Item> KEBAB_CHUM        = item("kebab_chum"       ,"Chum Kebab"       ,"烤海霸串"        ,"kebab/chum"       );
    static ItemEntry<Item> KEBAB_CHUM_RAW    = item("kebab_chum_raw"   ,"Raw Chum Kebab"   ,"生海霸串"        ,"kebab/chum_raw"   );
    static ItemEntry<Item> KEBAB_FAT         = item("kebab_fat"        ,"TailFat Kebab"    ,"烤肥尾串"        ,"kebab/fat"        );
    static ItemEntry<Item> KEBAB_FAT_RAW     = item("kebab_fat_raw"    ,"Raw TailFat Kebab","生肥尾串"        ,"kebab/fat_raw"    );
    static ItemEntry<Item> KEBAB_KUBIDEH     = item("kebab_kubideh"    ,"Kubideh Kebab"    ,"伊朗碎肉烤串"    ,"kebab/kubideh"    );
    static ItemEntry<Item> KEBAB_KUBIDEH_RAW = item("kebab_kubideh_raw","Raw Kubideh Kebab","生伊朗碎肉烤串"  ,"kebab/kubideh_raw");
    static ItemEntry<Item> KEBAB_MEAT        = item("kebab_meat"       ,"Meat Kebab"       ,"烤肉串"          ,"kebab/meat"       );
    static ItemEntry<Item> KEBAB_MEAT_RAW    = item("kebab_meat_raw"   ,"Raw Meat Kebab"   ,"生肉串"          ,"kebab/meat_raw"   );
    static ItemEntry<Item> KEBAB_ONION       = item("kebab_onion"      ,"Onion Kebab"      ,"烤洋葱串"        ,"kebab/onion"      );
    static ItemEntry<Item> KEBAB_ONION_RAW   = item("kebab_onion_raw"  ,"Raw Onion Kebab"  ,"生洋葱串"        ,"kebab/onion_raw"  );
    static ItemEntry<Item> KEBAB_TOMATO      = item("kebab_tomato"     ,"Tomato Kebab"     ,"烤番茄串"        ,"kebab/tomato"     );
    static ItemEntry<Item> KEBAB_TOMATO_RAW  = item("kebab_tomato_raw" ,"Raw Tomato Kebab" ,"生番茄串"        ,"kebab/tomato_raw" );
    static ItemEntry<Item> KEBAB_SOLTANI     = item("kebab_soltani"    ,"Kebab e Soltani!" ,"苏丹烤肉"        ,"kebab/soltani"    );

    //parmigiano
    static ItemEntry<Item> CHEESE_FORM            = item("cheese_form"           ,"Stainless Steel Cheese Form"                ,"不锈钢奶酪模具"                           ,"parmigiano/cheese_form");
    static ItemEntry<Item> PARMIGIANO_BRINED      = item("parmigiano_brined"     ,"Brined Parmigiano-Reggiano in Cheese Form"  ,"装有盐渍帕马森-雷加诺奶酪的奶酪模具"      ,"parmigiano/brined"     );
    static ItemEntry<Item> PARMIGIANO_BRINED_ROLL = item("parmigiano_brined_roll","Brined Parmigiano-Reggiano Roll"            ,"盐渍帕马森-雷加诺奶酪卷"                  ,"parmigiano/brined_roll");
    static ItemEntry<Item> PARMIGIANO_AGED_ROLL   = item("parmigiano_aged_roll"  ,"Aged Parmigiano-Reggiano Roll"              ,"熟化帕马森-雷加诺奶酪卷"                  ,"parmigiano/aged_roll"  );
    static ItemEntry<Item> PARMIGIANO_CURDLING    = item("parmigiano_curdling"   ,"Curdling Parmigiano-Reggiano in Cheese Form","装有半凝固帕马森-雷加诺奶酪乳液的奶酪模具","parmigiano/curdling"   );

    //pasta
    static ItemEntry<Item> DITALINI          = item("ditalini"         ,"Ditalini"         ,"意式手指面"    ,"pasta/ditalini"         );
    static ItemEntry<Item> DITALINI_RAW      = item("ditalini_raw"     ,"Raw Ditalini"     ,"生意式手指面"  ,"pasta/raw/ditalini"     );
    static ItemEntry<Item> DITALINI_DRIED    = item("ditalini_dried"   ,"Dried Ditalini"   ,"干意式手指面"  ,"pasta/dried/ditalini"   );
    static ItemEntry<Item> RIGATONI          = item("rigatoni"         ,"Rigatoni"         ,"意式粗通心粉"  ,"pasta/rigatoni"         );
    static ItemEntry<Item> RIGATONI_RAW      = item("rigatoni_raw"     ,"Raw Rigatoni"     ,"生意式粗通心粉","pasta/raw/rigatoni"     );
    static ItemEntry<Item> RIGATONI_DRIED    = item("rigatoni_dried"   ,"Dried Rigatoni"   ,"干意式粗通心粉","pasta/dried/rigatoni"   );
    static ItemEntry<Item> SPAGHETTI         = item("spaghetti"        ,"Spaghetti"        ,"意式直面"      ,"pasta/spaghetti"        );
    static ItemEntry<Item> SPAGHETTI_RAW     = item("spaghetti_raw"    ,"Raw Spaghetti"    ,"生意式直面"    ,"pasta/raw/spaghetti"    );
    static ItemEntry<Item> SPAGHETTI_DRIED   = item("spaghetti_dried"  ,"Dried Spaghetti"  ,"干意式直面"    ,"pasta/dried/spaghetti"  );
    static ItemEntry<Item> TAGLIATELLE       = item("tagliatelle"      ,"Tagliatelle"      ,"意式干面"      ,"pasta/tagliatelle"      );
    static ItemEntry<Item> TAGLIATELLE_RAW   = item("tagliatelle_raw"  ,"Raw Tagliatelle"  ,"生意式干面"    ,"pasta/raw/tagliatelle"  );
    static ItemEntry<Item> TAGLIATELLE_DRIED = item("tagliatelle_dried","Dried Tagliatelle","干意式干面"    ,"pasta/dried/tagliatelle");
    static ItemEntry<Item> TORTELLINI        = item("tortellini"       ,"Tortellini"       ,"意式馄饨"      ,"pasta/tortellini"       );
    static ItemEntry<Item> LASAGNA_RAW               = item("lasagna_raw"              ,"Raw Lasagna"                              ,"生意式千层面"                      ,"pasta/raw/lasagna"              );
    static ItemEntry<Item> LASAGNA_DRIED             = item("lasagna_dried"            ,"Dried Lasagna"                            ,"干意式千层面"                      ,"pasta/dried/lasagna"            );
    static ItemEntry<Item> LASAGNA_CHUM              = item("lasagna_chum"             ,"Chum Lasagna"                             ,"海霸意式千层面"                    ,"pasta/lasagna/chum"             );
    static ItemEntry<Item> LASAGNA_CHUM_RAW          = item("lasagna_chum_raw"         ,"Unbaked Chum Lasagna in Baking Tray"      ,"装有未烘烤海霸意式千层面的烤盘"    ,"pasta/lasagna/chum_raw"         );
    static ItemEntry<Item> LASAGNA_CHUM_COOKED       = item("lasagna_chum_cooked"      ,"Baked Chum Lasagna in Baking Tray"        ,"装有海霸意式千层面的烤盘"          ,"pasta/lasagna/chum_cooked"      );
    static ItemEntry<Item> LASAGNA_NAPOLETANA        = item("lasagna_napoletana"       ,"Lasagna Napoletana"                       ,"那不勒斯风味千层面"                ,"pasta/lasagna/napoletana"       );
    static ItemEntry<Item> LASAGNA_NAPOLETANA_RAW    = item("lasagna_napoletana_raw"   ,"Unbaked Napoletana Lasagna in Baking Tray","装有未烘烤那不勒斯风味千层面的烤盘","pasta/lasagna/napoletana_raw"   );
    static ItemEntry<Item> LASAGNA_NAPOLETANA_COOKED = item("lasagna_napoletana_cooked","Baked Napoletana Lasagna in Baking Tray"  ,"装有那不勒斯风味千层面的烤盘"      ,"pasta/lasagna/napoletana_cooked");
    static ItemEntry<Item> LASAGNA_PESTO             = item("lasagna_pesto"            ,"Lasagna al pesto"                         ,"青酱千层面"                        ,"pasta/lasagna/pesto"            );
    static ItemEntry<Item> LASAGNA_PESTO_RAW         = item("lasagna_pesto_raw"        ,"Unbaked Pesto Lasagna in Baking Tray"     ,"装有未烘烤青酱千层面的烤盘"        ,"pasta/lasagna/pesto_raw"        );
    static ItemEntry<Item> LASAGNA_PESTO_COOKED      = item("lasagna_pesto_cooked"     ,"Baked Pesto Lasagna in Baking Tray"       ,"装有青酱千层面的烤盘"              ,"pasta/lasagna/pesto_cooked"     );

    //pizza
    static ItemEntry<Item> PIZZA_CHEESE         = item("pizza_cheese"        ,"Cheese Pizza"                ,"芝士披萨"      ,"pizza/cheese"        );
    static ItemEntry<Item> PIZZA_CHEESE_RAW     = item("pizza_cheese_raw"    ,"Raw Cheese Pizza"            ,"生芝士披萨"    ,"pizza/cheese_raw"    );
    static ItemEntry<Item> PIZZA_VEGGIE         = item("pizza_veggie"        ,"Olive and Mushroom Pizza"    ,"橄榄蘑菇披萨"  ,"pizza/veggie"        );
    static ItemEntry<Item> PIZZA_VEGGIE_RAW     = item("pizza_veggie_raw"    ,"Raw Olive and Mushroom Pizza","生橄榄蘑菇披萨","pizza/veggie_raw"    );
    static ItemEntry<Item> PIZZA_MINCE_MEAT     = item("pizza_mince_meat"    ,"Mince Meat Pizza"            ,"肉末披萨"      ,"pizza/mince_meat"    );
    static ItemEntry<Item> PIZZA_MINCE_MEAT_RAW = item("pizza_mince_meat_raw","Raw Mince Meat Pizza"        ,"生肉末披萨"    ,"pizza/mince_meat_raw");

    //potato
    static ItemEntry<Item> POTATO_PEELED            = item("potato_peeled"           ,"Peeled Potato"            ,"去皮马铃薯"        ,"potato/peeled"           );
    static ItemEntry<Item> POTATO_STRIP             = item("potato_strip"            ,"Potato Strip"             ,"马铃薯条"          ,"potato/strip"            );
    static ItemEntry<Item> POTATO_STRIP_BLANCHED    = item("potato_strip_blanched"   ,"Blanched Potato Strip"    ,"过油马铃薯条"      ,"potato/strip_blanched"   );
    static ItemEntry<Item> POTATO_STRIP_FRIED       = item("potato_strip_fried"      ,"Fried Potato Strip"       ,"炸马铃薯条"        ,"potato/strip_fried"      );
    static ItemEntry<Item> POTATO_SLICE             = item("potato_slice"            ,"Potato Slice"             ,"马铃薯片"          ,"potato/slice"            );
    static ItemEntry<Item> POTATO_SLICE_FRIED       = item("potato_slice_fried"      ,"Fried Potato Slice"       ,"炸马铃薯片"        ,"potato/slice_fried"      );
    static ItemEntry<Item> POTATO_SLICE_BATCH_FRIED = item("potato_slice_batch_fried","Batch-Fried Potato Slice" ,"分批油炸的马铃薯片","potato/slice_batch_fried");
    static ItemEntry<Item> POTATO_SLICE_OILY        = item("potato_slice_oily"       ,"Oily Potato Slice"        ,"油腻马铃薯片"      ,"potato/slice_oily"       );
    static ItemEntry<Item> POTATO_SLICE_HOT         = item("potato_slice_hot"        ,"Hot Potato Slice"         ,"热马铃薯片"        ,"potato/slice_hot"        );
    static ItemEntry<Item> POTATO_SLICE_REDUCED_FAT = item("potato_slice_reduced_fat","Reduced Fat Potato Chip"  ,"减脂薯片"          ,"potato/slice_reduced_fat");
    static ItemEntry<Item> POTATO_ON_A_STICK        = item("potato_on_a_stick"       ,"Roasted Potato on a Stick","烤马铃薯棒"        ,"potato/stick"            );
    static ItemEntry<Item> FRENCH_FRIES             = item("french_fries"            ,"Fish'n'Chips"             ,"炸鱼薯条"          ,"potato/french_fries"     );
    static ItemEntry<Item> CHIPS_BAG_PARTIALLY_FILLED = item("chips_bag_partially_filled","Partially Filled Bag of Chips","未装满的薯片袋","potato/chips_bag_partially_filled");
    static ItemEntry<Item> CHIPS_SYALS                = item("chips_syals"               ,"Syals"                        ,"事乐薯片"      ,"potato/chips_syals"               );
    static ItemEntry<Item> CHIPS_BAG                  = item("chips_bag"                 ,"Bag O' Chips"                 ,"袋装薯片"      ,"potato/chips_bag"                 );
    static ItemEntry<Item> CHIPS_KETTLE               = item("chips_kettle"              ,"Kettle Chips"                 ,"手作薯片"      ,"potato/chips_kettle"              );
    static ItemEntry<Item> CHIPS_NAQUADAH             = item("chips_naquadah"            ,"Naquadah Chips"               ,"硅岩薯片"      ,"potato/chips_naquadah"            );
    static ItemEntry<Item> CHIPS_REDUCED_FAT          = item("chips_reduced_fat"         ,"Bay Salmon Reduced Fat Chips" ,"湾鲑牌减脂薯片","potato/chips_reduced_fat"         );
    static ItemEntry<Item> CHIPS_VINEGAR              = item("chips_vinegar"             ,"Vinegar Chips"                ,"醋味薯片"      ,"potato/chips_vinegar"             );

    //sandwich
    static ItemEntry<Item> SANDWICH_BACON        = item("sandwich_bacon"       ,"Bacon Sandwich"       ,"培根三明治"      ,"sandwich/bacon"       );
    static ItemEntry<Item> SANDWICH_BACON_LARGE  = item("sandwich_bacon_large" ,"Large Bacon Sandwich" ,"大号培根三明治"  ,"sandwich/bacon_large" );
    static ItemEntry<Item> SANDWICH_CHEESE       = item("sandwich_cheese"      ,"Cheese Sandwich"      ,"芝士三明治"      ,"sandwich/cheese"      );
    static ItemEntry<Item> SANDWICH_CHEESE_LARGE = item("sandwich_cheese_large","Large Cheese Sandwich","大号芝士三明治"  ,"sandwich/cheese_large");
    static ItemEntry<Item> SANDWICH_STEAK        = item("sandwich_steak"       ,"Steak Sandwich"       ,"牛肉三明治"      ,"sandwich/steak"       );
    static ItemEntry<Item> SANDWICH_STEAK_LARGE  = item("sandwich_steak_large" ,"Large Steak Sandwich" ,"大号牛肉三明治"  ,"sandwich/steak_large" );
    static ItemEntry<Item> SANDWICH_VEGGIE       = item("sandwich_veggie"      ,"Veggie Sandwich"      ,"蔬菜三明治"      ,"sandwich/veggie"      );
    static ItemEntry<Item> SANDWICH_VEGGIE_LARGE = item("sandwich_veggie_large","Large Veggie Sandwich","大号蔬菜三明治"  ,"sandwich/veggie_large");
    static ItemEntry<Item> SANDWICH_TOAST        = item("sandwich_toast"       ,"Toast Sandwich"       ,"吐司三明治"      ,"sandwich/toast"       );
    static ItemEntry<Item> SANDWICH_VIBRANT      = item("sandwich_vibrant"     ,"Vibrant Sandwich"     ,"Vibrant Sandwich","sandwich/vibrant"     );

    //seed
    static ItemEntry<Item> SEED_UNKNOWN     = item("seed_unknown"    ,"Undetermined GTMFO Seeds","不明GTMFO种子","seed/unknown"    );
    static ItemEntry<Item> SEED_ARTICHOKE   = item("seed_artichoke"  ,"Artichoke Seeds"         ,"洋蓟种子"     ,"seed/artichoke"  );
    static ItemEntry<Item> SEED_BASIL       = item("seed_basil"      ,"Basil Seeds"             ,"罗勒种子"     ,"seed/basil"      );
    static ItemEntry<Item> SEED_BEAN        = item("seed_bean"       ,"Beans"                   ,"菜豆"         ,"seed/bean"       );
    static ItemEntry<Item> SEED_COFFEE      = item("seed_coffee"     ,"Coffee Seed"             ,"咖啡种子"     ,"seed/coffee"     );
    static ItemEntry<Item> SEED_COTTON      = item("seed_cotton"     ,"Cotton Seeds"            ,"棉花种子"     ,"seed/cotton"     );
    static ItemEntry<Item> SEED_CUCUMBER    = item("seed_cucumber"   ,"Cucumber Seeds"          ,"黄瓜种子"     ,"seed/cucumber"   );
    static ItemEntry<Item> SEED_EGGPLANT    = item("seed_eggplant"   ,"Eggplant Seeds"          ,"茄子种子"     ,"seed/eggplant"   );
    static ItemEntry<Item> SEED_GARLIC      = item("seed_garlic"     ,"Garlic Clove"            ,"大蒜瓣"       ,"seed/garlic"     );
    static ItemEntry<Item> SEED_GRAPE       = item("seed_grape"      ,"Grape Seeds"             ,"葡萄种子"     ,"seed/grape"      );
    static ItemEntry<Item> SEED_HORSERADISH = item("seed_horseradish","Horseradish Seeds"       ,"辣根种子"     ,"seed/horseradish");
    static ItemEntry<Item> SEED_ONION       = item("seed_onion"      ,"Onion Seeds"             ,"洋葱种子"     ,"seed/onion"      );
    static ItemEntry<Item> SEED_OREGANO     = item("seed_oregano"    ,"Oregano Seeds"           ,"牛至种子"     ,"seed/oregano"    );
    static ItemEntry<Item> SEED_PEA         = item("seed_pea"        ,"Peas"                    ,"豌豆"         ,"seed/pea"        );
    static ItemEntry<Item> SEED_SOY         = item("seed_soy"        ,"Soybean Seeds"           ,"大豆种子"     ,"seed/soy"        );
    static ItemEntry<Item> SEED_TOMATO      = item("seed_tomato"     ,"Tomato Seeds"            ,"番茄种子"     ,"seed/tomato"     );
    static ItemEntry<Item> SEED_WHITE_GRAPE = item("seed_white_grape","White Grape Seeds"       ,"白葡萄种子"   ,"seed/white_grape");

    //shape
    static ItemEntry<Item> SHAPE_PASTA_BLANK       = item("shape_pasta_blank"      ,"Blank Pasta Extruder Shape"      ,"空青铜模板"              ,"shape/pasta/blank"      );
    static ItemEntry<Item> SHAPE_PASTA_DITALINI    = item("shape_pasta_ditalini"   ,"Ditalini Pasta Extruder Shape"   ,"青铜模头（意式手指面）"  ,"shape/pasta/ditalini"   );
    static ItemEntry<Item> SHAPE_PASTA_LASAGNA     = item("shape_pasta_lasagna"    ,"Lasagna Pasta Extruder Shape"    ,"青铜模头（意式千层面）"  ,"shape/pasta/lasagna"    );
    static ItemEntry<Item> SHAPE_PASTA_RIGATONI    = item("shape_pasta_rigatoni"   ,"Rigatoni Pasta Extruder Shape"   ,"青铜模头（意式粗通心粉）","shape/pasta/rigatoni"   );
    static ItemEntry<Item> SHAPE_PASTA_SPAGHETTI   = item("shape_pasta_spaghetti"  ,"Spaghetti Pasta Extruder Shape"  ,"青铜模头（意式直面）"    ,"shape/pasta/spaghetti"  );
    static ItemEntry<Item> SHAPE_PASTA_TAGLIATELLE = item("shape_pasta_tagliatelle","Tagliatelle Pasta Extruder Shape","青铜模头（意式干面）"    ,"shape/pasta/tagliatelle");

    //slicer_blade
    static ItemEntry<Item> SLICER_BLADE_FLAT      = item("slicer_blade_flat"     ,"Slicer Blade (Flat)"   ,"切片机刀片（切片）"  ,"slicer_blade/flat"     );
    static ItemEntry<Item> SLICER_BLADE_STRIPES   = item("slicer_blade_stripes"  ,"Slicer Blade (Stripes)","切片机刀片（切条）"  ,"slicer_blade/stripes"  );
    static ItemEntry<Item> SLICER_BLADE_OCTAGONAL = item("slicer_blade_octagonal","Slicer Blade (Eights)" ,"切片机刀片（八等分）","slicer_blade/octagonal");

    //smore
    static ItemEntry<Item> SMORE_ONE        = item("smore_one"       ,"S'more S'mingot"                          ,"巧克力棉花糖夹心饼干"        ,"smore/one"       );
    static ItemEntry<Item> SMORE_TWO        = item("smore_two"       ,"MoreS'more DoubleS'mingot"                ,"双层巧克力棉花糖夹心饼干"    ,"smore/two"       );
    static ItemEntry<Item> SMORE_FOUR       = item("smore_four"      ,"FourS'more QuadS'mingot"                  ,"四层巧克力棉花糖夹心饼干"    ,"smore/four"      );
    static ItemEntry<Item> SMORE_EIGHT      = item("smore_eight"     ,"EightS'more OctoS'mingot"                 ,"八层巧克力棉花糖夹心饼干"    ,"smore/eight"     );
    static ItemEntry<Item> SMORE_SIXTEEN    = item("smore_sixteen"   ,"SixteenS'more HexadecaS'mingot"           ,"十六层巧克力棉花糖夹心饼干"  ,"smore/sixteen"   );
    static ItemEntry<Item> SMORE_THIRTY_TWO = item("smore_thirty_two","Half-stack-o'-S'more TriacontadyoS'mingot","三十二层巧克力棉花糖夹心饼干","smore/thirty_two");
    static ItemEntry<Item> SMORE_SIXTY_FOUR = item("smore_sixty_four","Stack-o'-S'more HexecontatessaraS'mingot" ,"六十四层巧克力棉花糖夹心饼干","smore/sixty_four");
    static ItemEntry<Item> SMOGUS       = item("smogus"      ,"S'mogus S'mingot"          ,"牛奶巧克力棉花糖夹心内鬼饼干"    ,"smore/gusone"      );
    static ItemEntry<Item> SMOGUS_TWO   = item("smogus_two"  ,"MultiS'mogus GrandS'mingot","多重牛奶巧克力棉花糖夹心内鬼饼干","smore/gustwo"      );
    static ItemEntry<Item> SMOGUS_FOUR  = item("smogus_four" ,"AllS'mogus OmniS'mingot"   ,"全能牛奶巧克力棉花糖夹心内鬼饼干","smore/gusfour"     );
    static ItemEntry<Item> SMOGUS_HEART = item("smogus_heart","Heart of the S'mogus"      ,"夹心内鬼饼干之心"                ,"smore/smogus_heart");

    //sorbet
    static ItemEntry<Item> SORBET         = item("sorbet"        ,"Plain Sorbet"  ,"原味雪葩"      ,"sorbet/plain"  );
    static ItemEntry<Item> SORBET_APPLE   = item("sorbet_apple"  ,"Apple Sorbet"  ,"苹果雪葩"      ,"sorbet/apple"  );
    static ItemEntry<Item> SORBET_APRICOT = item("sorbet_apricot","Apricot Sorbet","杏子雪葩"      ,"sorbet/apricot");
    static ItemEntry<Item> SORBET_CHORUS  = item("sorbet_chorus" ,"Chorus Sorbet" ,"Chorus Sorbet" ,"sorbet/chorus" );
    static ItemEntry<Item> SORBET_GRAPE   = item("sorbet_grape"  ,"Grape Sorbet"  ,"葡萄雪葩"      ,"sorbet/grape"  );
    static ItemEntry<Item> SORBET_LIME    = item("sorbet_lime"   ,"Lime Sorbet"   ,"酸柠雪葩"      ,"sorbet/lime"   );
    static ItemEntry<Item> SORBET_VIBRANT = item("sorbet_vibrant","Vibrant Sorbet","Vibrant Sorbet","sorbet/vibrant");

    //structural_mesh
    static ItemEntry<Item> APPLE_STRUCTURAL_MESH  = item("apple_structural_mesh" ,"Apple Structural Mesh" ,"苹果纤维骨架"  ,"structural_mesh/apple" );
    static ItemEntry<Item> CARROT_STRUCTURAL_MESH = item("carrot_structural_mesh","Carrot Structural Mesh","胡萝卜纤维骨架","structural_mesh/carrot");

    static ItemEntry<Item> PIE_CRUST = item("pie_crust");

    static ItemEntry<Item> BEEF_SLICE = item("beef_slice");
    static ItemEntry<Item> MOLD_CHEDDAR_CURD = item("mold_cheddar_curd");
    static ItemEntry<Item> MOLD_AGED_CHEDDAR = item("mold_aged_cheddar");
    static ItemEntry<Item> MOZZARELLA_SLICE = item("mozzarella_slice");
    static ItemEntry<Item> MOZZARELLA_BALL = item("mozzarella_ball");
    static ItemEntry<Item> RICOTTA_PIECE = item("ricotta_piece");
    static ItemEntry<Item> CHEDDAR_BLOCK = item("cheddar_block");

    static ItemEntry<Item> UNCOOKED_BACON = item("bacon_uncooked");

    static ItemEntry<Item> BANANA_PEEL = item("banana_peel");
    static ItemEntry<Item> SCRAP_MEAT = item("scrap_meat");
    static ItemEntry<Item> GELATIN = item("gelatin");
    static ItemEntry<Item> ROASTED_COCOA_BEANS = item("roasted_beans");
    static ItemEntry<Item> COCOA_NIBS = item("cocoa_nibs");

    static ItemEntry<Item> BEANS_WITH_SAUCE = item("beans_with_sauce");
    static ItemEntry<Item> UNCOOKED_SAUSAGE_ROLL = item("uncooked_sausage_roll");
    static ItemEntry<Item> GARLIC_BULB = item("garlic_bulb");
    static ItemEntry<Item> HORSERADISH = item("horseradish");
    static ItemEntry<Item> BASIL = item("basil");
    static ItemEntry<Item> OREGANO = item("oregano");

    static ItemEntry<Item> IV_BAG = item("iv_bag");

    static ItemEntry<Item> PORCHETTA = item("porchetta");
    static ItemEntry<Item> PORCHETTA_SLICE = item("porchetta_slice");

    static ItemEntry<Item> SEASONED_PORK = item("seasoned_pork");

    static ItemEntry<Item> PELMENI = item("pelmeni");
    static ItemEntry<Item> PELMENI_SEASONED = item("pelmeni_seasoned");
    static ItemEntry<Item> PELMENI_UNCOOKED = item("pelmeni_uncooked");
    static ItemEntry<Item> PELMENI_SEASONED_UNCOOKED = item("pelmeni_seasoned_uncooked");

    static ItemEntry<Item> POPCORN_BAG = item("popcorn_bag");
    static ItemEntry<Item> MINERAL_WATER = item("mineral_water");

    static ItemEntry<Item> SPARKLING_WATER = item("sparkling_water");
    static ItemEntry<Item> ETIRPS = item("etirps");
    static ItemEntry<Item> ETIRPS_CRANBERRY = item("etirps_cranberry");
    static ItemEntry<Item> BACON = item("bacon");
    static ItemEntry<Item> TUNGSTENSTEEL_APPLE = item("tungstensteel_apple");
    static ItemEntry<Item> CAKE_BOTTOM = item("cake_bottom");
    static ItemEntry<Item> CAKE_BOTTOM_BAKED = item("cake_bottom_baked");

    static ItemEntry<Item> CHEDDAR_SLICE = item("cheddar_slice");
    static ItemEntry<Item> ROTTEN_FISH = item("rotten_fish");
    static ItemEntry<Item> ROTTEN_MEAT = item("rotten_meat");
    static ItemEntry<Item> CHUM = item("chum");
    static ItemEntry<Item> CHUM_BUCKET = item("chum_bucket");
    static ItemEntry<Item> CHUM_ON_A_STICK = item("chum_on_a_stick");
    static ItemEntry<Item> VODKA = item("vodka");
    static ItemEntry<Item> LENINADE = item("leninade");
    static ItemEntry<Item> MUSHROOM_STEW_HOT = item("mushroom_stew_hot");
    static ItemEntry<Item> BEETROOT_SOUP_HOT = item("beetroot_soup_hot");
    static ItemEntry<Item> RABBIT_STEW_HOT = item("rabbit_stew_hot");
    static ItemEntry<Item> APPLE_SLICE = item("apple_slice");

    static ItemEntry<Item> CHOCOLATE = item("chocolate");
    static ItemEntry<Item> GRAHAM_CRACKER = item("graham_cracker");
    static ItemEntry<Item> MARSHMALLOW = item("marshmallow");



    //coffee
    static ItemEntry<Item> COFFEE = item("coffee","coffee/normal");
    static ItemEntry<Item> COFFEE_ENERGIZED = item("coffee_energized","coffee/energized");

    static ItemEntry<Item> MUSHY_PEAS = item("mushy_peas");
    static ItemEntry<Item> FISH_AND_CHIPS = item("fish_and_chips");
    static ItemEntry<Item> FULL_BREAKFAST = item("full_breakfast");
    static ItemEntry<Item> SHEPHERDS_PIE = item("shepherds_pie");
    static ItemEntry<Item> SAUSAGE = item("sausage");
    static ItemEntry<Item> SAUSAGE_ROLL = item("sausage_roll");
    static ItemEntry<Item> BAKED_BEANS = item("baked_beans");
    static ItemEntry<Item> BEANS_ON_TOAST = item("beans_on_toast");
    static ItemEntry<Item> FRIED_FISH = item("fried_fish");
    static ItemEntry<Item> BEER = item("beer");
    static ItemEntry<Item> NILK = item("nilk");



    static ItemEntry<Item> BRUSCHETTA = item("bruschetta");
    static ItemEntry<Item> CAPONATA = item("caponata");
    static ItemEntry<Item> CARBONARA = item("carbonara");
    static ItemEntry<Item> CARCIOFI_ALLA_ROMANA = item("carciofi_alla_romana");
    static ItemEntry<Item> FETTUCCINE_ALFREDO = item("fettuccine_alfredo");
    static ItemEntry<Item> PARMIGIANA = item("parmigiana");

    static ItemEntry<Item> PASTA_E_FAGIOLI = item("pasta_e_fagioli");
    static ItemEntry<Item> PASTA_ALLA_NORMA = item("pasta_alla_norma");
    static ItemEntry<Item> PASTA_AL_POMODORO = item("pasta_al_pomodoro");
    static ItemEntry<Item> PASTA_ALL_AMOGUS = item("pasta_all_amogus");
    static ItemEntry<Item> POLENTA = item("polenta");
    static ItemEntry<Item> RAFANATA = item("rafanata");
    static ItemEntry<Item> RISOTTO = item("risotto");
    static ItemEntry<Item> SPAGHETTI_ALLASSASSINA = item("spaghetti_all_assassina");
    static ItemEntry<Item> TAGLIATELLE_AL_RAGU = item("tagliatelle_al_ragu");
    static ItemEntry<Item> TORTELLINI_IN_BRODO = item("tortellini_in_brodo");
    static ItemEntry<Item> VITELLO_TONNATO = item("vitello_tonnato");
    static ItemEntry<Item> WHITE_WINE = item("white_wine");
    static ItemEntry<Item> RED_WINE = item("red_wine");
    static ItemEntry<Item> EMERGENCY_RATIONS = item("emergency_rations");



    static ItemEntry<Item> BERRY_MEDLEY = item("berry_medley");
    static ItemEntry<Item> ANTAF = item("antaf");



    static ItemEntry<Item> FERMENTED_CHORUS = item("fermented_chorus");
    static ItemEntry<Item> FERMENTED_CHORUS_PIE = item("fermented_chorus_pie");

    // 175-189 left blank for organic circuits

    static ItemEntry<Item> SPRINKLER = item("sprinkler");



    //utility
    static ItemEntry<Item> KITCHEN_RECIPE = item("kitchen_recipe","utility/kitchen_recipe");

    static ItemEntry<Item> GUMMY_BEAR = item("gummy_bear");

    static ItemEntry<Item> BRICK_ADOBE = item("brick_adobe","brick_adobe");
    static ItemEntry<Item> BRICK_MUB = item("brick_mud","brick_mud");

    static ItemEntry<Item> COFFEE_FILTER = item("coffee_filter","Coffee Filter","咖啡滤纸");
    static ItemEntry<Item> CORED_APPLE = item("cored_apple");


    @NonFinal
    static ItemEntry<Item> TEST_ITEM;
    @NonFinal
    static ItemEntry<Item> TEST_ITEM_2;

    public static void init() {
        TEST_ITEM_2 = item("test_item_2");

        FoodProperties properties = new FoodProperties.Builder().nutrition(2).saturationMod(0.5f).build();
        ((IEatingDuration)properties).setEatingDuration(64);
        ((INutrients)properties).addNutrients(1,1,1,1,1);
        ((IContainerItem)properties).setContainerItem(TEST_ITEM_2::asStack);
        TEST_ITEM = REGISTRATE.item("test_item",Item::new)
                .defaultModel()
                .defaultLang()
                .initialProperties(()->new Item.Properties().food(properties))
                .register();

    }

}
