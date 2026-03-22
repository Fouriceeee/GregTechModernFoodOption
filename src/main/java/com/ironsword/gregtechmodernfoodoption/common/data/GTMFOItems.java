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
    static ItemEntry<Item> PAPER_BAG = item("bag","container/bag");
    static ItemEntry<Item> PAPER_BAG_USED = item("bag_used","container/bag_used");
    static ItemEntry<Item> CUP_EMPTY = item("cup_empty","container/cup_empty");
    static ItemEntry<Item> CUP_UNFIRED = item("cup_unfired","container/cup_unfired");
    static ItemEntry<Item> PAPER_CONE = item("paper_cone","container/paper_cone");
    static ItemEntry<Item> PLASTIC_BOTTLE = item("plastic_bottle","container/plastic_bottle");
    static ItemEntry<Item> PLATE = item("plate","container/plate");
    static ItemEntry<Item> PLATE_DIRTY = item("plate_dirty","container/plate_dirty");
    static ItemEntry<Item> PLATE_UNFIRED = item("plate_unfired","container/plate_unfired");
    static ItemEntry<Item> CERAMIC_BOWL = item("ceramic_bowl","container/ceramic_bowl");
    static ItemEntry<Item> CERAMIC_BOWL_DIRTY = item("ceramic_bowl_dirty","container/ceramic_bowl_dirty");
    static ItemEntry<Item> CERAMIC_BOWL_UNFIRED = item("ceramic_bowl_unfired","container/ceramic_bowl_unfired");
    static ItemEntry<Item> BAKING_TRAY = item("baking_tray","container/baking_tray");
    static ItemEntry<Item> CAN = item("can","container/can");

    //corn
    static ItemEntry<Item> FLAVORED_POPCORN_FLAKE = item("flavored_flake","corn/flavored_flake");
    static ItemEntry<Item> CORN_COB = item("cob","corn/cob");
    static ItemEntry<Item> DRIED_CORN_EAR = item("dried_ear","corn/dried_ear");
    static ItemEntry<Item> CORN_EAR = item("corn_ear","corn/ear");
    static ItemEntry<Item> CORN_KERNEL = item("corn_kernel","corn/kernel");
    static ItemEntry<Item> CORN_KERNEL_ACCEPTABLE = item("corn_kernel_acceptable","corn/kernel_acceptable");

    //dewarflask
    static ItemEntry<Item> DEWAR_FLASK = item("dewar_flask","dewar_flask/new");
    static ItemEntry<Item> USED_DEWAR_FLASK = item("used_dewar_flask","dewar_flask/used");
    static ItemEntry<Item> LEACHED_DEWAR_FLASK_CASING = item("leached_dewar_flask_casing","dewar_flask/casing_leached");
    static ItemEntry<Item> DEWAR_FLASK_CAP = item("dewar_flask_cap","dewar_flask/cap");
    static ItemEntry<Item> DEWAR_FLASK_CASING = item("dewar_flask_casing","dewar_flask/casing");

    static ItemEntry<Item> CORED_APPLE = item("cored_apple");

    //sliceblade
    static ItemEntry<Item> SLICER_BLADE_FLAT = item("slicer_blade_flat","slicer_blade/flat");
    static ItemEntry<Item> SLICER_BLADE_STRIPES = item("slicer_blade_stripes","slicer_blade/stripes");
    static ItemEntry<Item> SLICER_BLADE_OCTAGONAL = item("slicer_blade_octagonal","slicer_blade/octagonal");

    //potato
    static ItemEntry<Item> POTATO_PEELED = item("potato_peeled","potato/peeled");
    static ItemEntry<Item> POTATO_STRIP = item("potato_strip","potato/strip");
    static ItemEntry<Item> POTATO_STRIP_BLANCHED = item("potato_strip_blanched","potato/strip_blanched");
    static ItemEntry<Item> POTATO_STRIP_FRIED = item("potato_strip_fried","potato/strip_fried");
    static ItemEntry<Item> POTATO_SLICE = item("potato_slice","potato/slice");
    static ItemEntry<Item> POTATO_SLICE_FRIED = item("potato_slice_fried","potato/slice_fried");
    static ItemEntry<Item> POTATO_SLICE_BATCH_FRIED = item("potato_slice_batch_fried","potato/slice_batch_fried");
    static ItemEntry<Item> POTATO_SLICE_OILY = item("potato_slice_oily","potato/slice_oily");
    static ItemEntry<Item> POTATO_SLICE_HOT = item("potato_slice_hot","potato/slice_hot");
    static ItemEntry<Item> POTATO_SLICE_REDUCED_FAT = item("potato_slice_reduced_fat","potato/slice_reduced_fat");
    static ItemEntry<Item> FRENCH_FRIES = item("french_fries","potato/french_fries");
    static ItemEntry<Item> CHIPS_BAG_PARTIALLY_FILLED = item("chips_bag_partially_filled","potato/chips_bag_partially_filled");
    static ItemEntry<Item> CHIPS_SYALS = item("chips_syals","potato/chips_syals");
    static ItemEntry<Item> CHIPS_BAG = item("chips_bag","potato/chips_bag");
    static ItemEntry<Item> CHIPS_KETTLE = item("chips_kettle","potato/chips_kettle");
    static ItemEntry<Item> CHIPS_NAQUADAH = item("chips_naquadah","potato/chips_naquadah");
    static ItemEntry<Item> CHIPS_REDUCED_FAT = item("chips_reduced_fat","potato/chips_reduced_fat");
    static ItemEntry<Item> CHIPS_VINEGAR = item("chips_vinegar","potato/chips_vinegar");
    static ItemEntry<Item> POTATO_ON_A_STICK = item("potato_on_a_stick","potato/stick");

    //structural_mesh
    static ItemEntry<Item> CARROT_STRUCTURAL_MESH = item("carrot_structural_mesh","structural_mesh/carrot");
    static ItemEntry<Item> APPLE_STRUCTURAL_MESH = item("apple_structural_mesh","structural_mesh/apple");

    //pizza
    static ItemEntry<Item> PIZZA_CHEESE = item("pizza_cheese","pizza/cheese");
    static ItemEntry<Item> PIZZA_CHEESE_RAW = item("pizza_cheese_raw","pizza/cheese_raw");
    static ItemEntry<Item> PIZZA_VEGGIE = item("pizza_veggie","pizza/veggie");
    static ItemEntry<Item> PIZZA_VEGGIE_RAW = item("pizza_veggie_raw","pizza/veggie_raw");
    static ItemEntry<Item> PIZZA_MINCE_MEAT = item("pizza_mince_meat","pizza/mince_meat");
    static ItemEntry<Item> PIZZA_MINCE_MEAT_RAW = item("pizza_mince_meat_raw","pizza/mince_meat_raw");
    static ItemEntry<Item> PIZZA_OLIVE_MUSHROOM = item("pizza_olive_mushroom","pizza/olive_mushroom");
    static ItemEntry<Item> PIZZA_OLIVE_MUSHROOM_RAW = item("pizza_olive_mushroom_raw","pizza/olive_mushroom_raw");

    static ItemEntry<Item> PIE_CRUST = item("pie_crust");

    //crop
    static ItemEntry<Item> ARTICHOKE = item("artichoke","crop/artichoke");
    static ItemEntry<Item> BLACK_PEPPER = item("black_pepper","crop/black_pepper");
    static ItemEntry<Item> CARROT_SLICE = item("carrot_slice","crop/carrot_slice");
    //static ItemEntry<Item> COFFEE_CHERRY = item("coffee_cherry","crop/coffee");
    static ItemEntry<Item> COTTON = item("cotton","crop/cotton");
    static ItemEntry<Item> CUCUMBER = item("cucumber","crop/cucumber");
    static ItemEntry<Item> CUCUMBER_SLICE = item("cucumber_slice","crop/cucumber_slice");
    static ItemEntry<Item> EGGPLANT = item("eggplant","crop/eggplant");
    static ItemEntry<Item> EGGPLANT_SLICE = item("eggplant_slice","crop/eggplant_slice");
    static ItemEntry<Item> MUSHROOM_SLICE = item("mushroom_slice","crop/mushroom_slice");
    static ItemEntry<Item> OLIVE = item("olive","crop/olive");
    static ItemEntry<Item> OLIVE_SLICE = item("olive_slice","crop/olive_slice");
    static ItemEntry<Item> ONION = item("onion","crop/onion");
    static ItemEntry<Item> ONION_SLICE = item("onion","crop/onion_slice");
    static ItemEntry<Item> PEA_POD = item("pea_pod","crop/pea_pod");
    static ItemEntry<Item> RICE = item("rice","crop/rice");
    static ItemEntry<Item> SOYBEAN = item("soybean","crop/soybean");
    static ItemEntry<Item> TOMATO = item("tomato","crop/tomato");
    static ItemEntry<Item> TOMATO_SLICE = item("tomato_slice","crop/tomato_slice");

    //seed
    static ItemEntry<Item> SEED_UNKNOWN = item("seed_unknown","seed/unknown");
    static ItemEntry<Item> SEED_ARTICHOKE = item("seed_artichoke","seed/artichoke");
    static ItemEntry<Item> SEED_BASIL = item("seed_basil","seed/basil");
    static ItemEntry<Item> SEED_BEAN = item("seed_bean","seed/bean");
    static ItemEntry<Item> SEED_COFFEE = item("seed_coffee","seed/coffee");
    static ItemEntry<Item> SEED_COTTON = item("seed_cotton","seed/cotton");
    static ItemEntry<Item> SEED_CUCUMBER = item("seed_cucumber","seed/cucumber");
    static ItemEntry<Item> SEED_EGGPLANT = item("seed_eggplant","seed/eggplant");
    static ItemEntry<Item> SEED_GARLIC = item("seed_garlic","seed/garlic");
    static ItemEntry<Item> SEED_GRAPE = item("seed_grape","seed/grape");
    static ItemEntry<Item> SEED_HORSERADISH = item("seed_horseradish","seed/horseradish");
    static ItemEntry<Item> SEED_ONION = item("seed_onion","seed/onion");
    static ItemEntry<Item> SEED_OREGANO = item("seed_oregano","seed/oregano");
    static ItemEntry<Item> SEED_PEA = item("seed_pea","seed/pea");
    static ItemEntry<Item> SEED_SOY = item("seed_soy","seed/soy");
    static ItemEntry<Item> SEED_TOMATO = item("seed_tomato","seed/tomato");
    static ItemEntry<Item> SEED_WHITE_GRAPE = item("seed_white_grape","seed/white_grape");

    static ItemEntry<Item> BEEF_SLICE = item("beef_slice");
    static ItemEntry<Item> MOLD_CHEDDAR_CURD = item("mold_cheddar_curd");
    static ItemEntry<Item> MOLD_AGED_CHEDDAR = item("mold_aged_cheddar");
    static ItemEntry<Item> MOZZARELLA_SLICE = item("mozzarella_slice");
    static ItemEntry<Item> MOZZARELLA_BALL = item("mozzarella_ball");
    static ItemEntry<Item> RICOTTA_PIECE = item("ricotta_piece");
    static ItemEntry<Item> CHEDDAR_BLOCK = item("cheddar_block");

    static ItemEntry<Item> UNCOOKED_BACON = item("bacon_uncooked");

    //gorgonzola_wheel
    static ItemEntry<Item> GORGONZOLA_WHEEL = item("gorgonzola_wheel","gorgonzola/wheel");
    static ItemEntry<Item> GORGONZOLA_WHEEL_SALTED = item("gorgonzola_wheel_salted","gorgonzola/salted");
    static ItemEntry<Item> GORGONZOLA_WHEEL_SLIGHTLY_AGED = item("gorgonzola_wheel_slightly_aged","gorgonzola/slightly_aged");
    static ItemEntry<Item> GORGONZOLA_WHEEL_PUNCTURED = item("gorgonzola_wheel_punctured","gorgonzola/punctured");
    static ItemEntry<Item> GORGONZOLA_WHEEL_FULLY_CURED = item("gorgonzola_wheel_fully_cured","gorgonzola/fully_cured");
    static ItemEntry<Item> GORGONZOLA_TRIANGULAR_SLICE = item("gorgonzola_triangular_slice","gorgonzola/triangular_slice");

    static ItemEntry<Item> BANANA_PEEL = item("banana_peel");
    static ItemEntry<Item> SCRAP_MEAT = item("scrap_meat");
    static ItemEntry<Item> GELATIN = item("gelatin");
    static ItemEntry<Item> ROASTED_COCOA_BEANS = item("roasted_beans");
    static ItemEntry<Item> COCOA_NIBS = item("cocoa_nibs");

    //kebab
    static ItemEntry<Item> SKEWER = item("skewer","kebab/skewer");
    static ItemEntry<Item> KEBAB_SOLTANI = item("kebab_soltani","kebab/soltani");
    static ItemEntry<Item> KEBAB_BARG = item("kebab_barg","kebab/barg");
    static ItemEntry<Item> KEBAB_BARG_COOKED = item("kebab_barg_cooked","kebab/barg_cooked");
    static ItemEntry<Item> KEBAB_CARROT = item("kebab_carrot","kebab/carrot");
    static ItemEntry<Item> KEBAB_CARROT_COOKED = item("kebab_carrot_cooked","kebab/carrot_cooked");
    static ItemEntry<Item> KEBAB_CHUM = item("kebab_chum","kebab/chum");
    static ItemEntry<Item> KEBAB_CHUM_COOKED = item("kebab_chum_cooked","kebab/chum_cooked");
    static ItemEntry<Item> KEBAB_FAT = item("kebab_fat","kebab/fat");
    static ItemEntry<Item> KEBAB_FAT_COOKED = item("kebab_fat_cooked","kebab/fat_cooked");
    static ItemEntry<Item> KEBAB_KUBIDEH = item("kebab_kubideh","kebab/kubideh");
    static ItemEntry<Item> KEBAB_KUBIDEH_COOKED = item("kebab_kubideh_cooked","kebab/kubideh_cooked");
    static ItemEntry<Item> KEBAB_MEAT = item("kebab_meat","kebab/meat");
    static ItemEntry<Item> KEBAB_MEAT_COOKED = item("kebab_meat_cooked","kebab/meat_cooked");
    static ItemEntry<Item> KEBAB_ONION = item("kebab_onion","kebab/onion");
    static ItemEntry<Item> KEBAB_ONION_COOKED = item("kebab_onion_cooked","kebab/onion_cooked");
    static ItemEntry<Item> KEBAB_TOMATO = item("kebab_tomato","kebab/tomato");
    static ItemEntry<Item> KEBAB_TOMATO_COOKED = item("kebab_tomato_cooked","kebab/tomato_cooked");

    static ItemEntry<Item> BEANS_WITH_SAUCE = item("beans_with_sauce");
    static ItemEntry<Item> UNCOOKED_SAUSAGE_ROLL = item("uncooked_sausage_roll");
    static ItemEntry<Item> GARLIC_BULB = item("garlic_bulb");
    static ItemEntry<Item> HORSERADISH = item("horseradish");
    static ItemEntry<Item> BASIL = item("basil");
    static ItemEntry<Item> OREGANO = item("oregano");


    static ItemEntry<Item> IV_BAG = item("iv_bag");

    //dough
    static ItemEntry<Item> DOUGH = item("dough","dough/dough");
    static ItemEntry<Item> DOUGH_FLAT = item("flat_dough","dough/flat");
    static ItemEntry<Item> DOUGH_SUGARY = item("sugary_dough","dough/sugary");
    static ItemEntry<Item> DOUGH_PASTA = item("pasta_dough","dough/pasta");
    static ItemEntry<Item> DOUGH_EGG_PASTA = item("egg_pasta_dough","dough/egg_pasta");
    static ItemEntry<Item> DOUGH_PREMIXED_PASTA = item("premixed_pasta_dough","dough/premixed_pasta");

    //pasta
    static ItemEntry<Item> DITALINI = item("ditalini","pasta/ditalini");
    static ItemEntry<Item> DITALINI_RAW = item("ditalini_raw","pasta/raw/ditalini");
    static ItemEntry<Item> DITALINI_DRIED = item("ditalini_dried","pasta/dried/ditalini");
    static ItemEntry<Item> RIGATONI = item("rigatoni","pasta/rigatoni");
    static ItemEntry<Item> RIGATONI_RAW = item("rigatoni_raw","pasta/raw/rigatoni");
    static ItemEntry<Item> RIGATONI_DRIED = item("rigatoni_dried","pasta/dried/rigatoni");
    static ItemEntry<Item> SPAGHETTI = item("spaghetti","pasta/spaghetti");
    static ItemEntry<Item> SPAGHETTI_RAW = item("spaghetti_raw","pasta/raw/spaghetti");
    static ItemEntry<Item> SPAGHETTI_DRIED = item("spaghetti_dried","pasta/dried/spaghetti");
    static ItemEntry<Item> TAGLIATELLE = item("tagliatelle","pasta/tagliatelle");
    static ItemEntry<Item> TAGLIATELLE_RAW = item("tagliatelle_raw","pasta/raw/tagliatelle");
    static ItemEntry<Item> TAGLIATELLE_DRIED = item("tagliatelle_dried","pasta/dried/tagliatelle");
    static ItemEntry<Item> TORTELLINI = item("tortellini","pasta/tortellini");
    static ItemEntry<Item> LASAGNA_CHUM = item("lasagna_chum","pasta/lasagna/chum");
    static ItemEntry<Item> LASAGNA_CHUM_RAW = item("lasagna_chum_raw","pasta/lasagna/chum_raw");
    static ItemEntry<Item> LASAGNA_CHUM_COOKED = item("lasagna_chum_cooked","pasta/lasagna/chum_cooked");
    static ItemEntry<Item> LASAGNA_NAPOLETANA = item("lasagna_napoletana","pasta/lasagna/napoletana");
    static ItemEntry<Item> LASAGNA_NAPOLETANA_RAW = item("lasagna_napoletana_raw","pasta/lasagna/napoletana_raw");
    static ItemEntry<Item> LASAGNA_NAPOLETANA_COOKED = item("lasagna_napoletana_cooked","pasta/lasagna/napoletana_cooked");
    static ItemEntry<Item> LASAGNA_PESTO = item("lasagna_pesto","pasta/lasagna/pesto");
    static ItemEntry<Item> LASAGNA_PESTO_RAW = item("lasagna_pesto_raw","pasta/lasagna/pesto_raw");
    static ItemEntry<Item> LASAGNA_PESTO_COOKED = item("lasagna_pesto_cooked","pasta/lasagna/pesto_cooked");

    static ItemEntry<Item> PORCHETTA = item("porchetta");
    static ItemEntry<Item> PORCHETTA_SLICE = item("porchetta_slice");

    //parmigiano
    static ItemEntry<Item> CHEESE_FORM = item("cheese_form","parmigiano/cheese_form");
    static ItemEntry<Item> PARMIGIANO_BRINED = item("parmigiano_brined","parmigiano/brined");
    static ItemEntry<Item> PARMIGIANO_BRINED_ROLL = item("parmigiano_brined_roll","parmigiano/brined_roll");
    static ItemEntry<Item> PARMIGIANO_AGED_ROLL = item("parmigiano_aged_roll","parmigiano/aged_roll");
    static ItemEntry<Item> PARMIGIANO_CURDLING = item("parmigiano_curdling","parmigiano/curdling");

    static ItemEntry<Item> SEASONED_PORK = item("seasoned_pork");

    static ItemEntry<Item> PELMENI = item("pelmeni");
    static ItemEntry<Item> PELMENI_SEASONED = item("pelmeni_seasoned");
    static ItemEntry<Item> PELMENI_UNCOOKED = item("pelmeni_uncooked");
    static ItemEntry<Item> PELMENI_SEASONED_UNCOOKED = item("pelmeni_seasoned_uncooked");

    //fruit
    static ItemEntry<Item> APRICOT = item("apricot","fruit/apricot");
    static ItemEntry<Item> BANANA = item("banana","fruit/banana");
    static ItemEntry<Item> BANANA_PEELED = item("banana_peeled","fruit/banana_peeled");
    static ItemEntry<Item> COCONUT = item("coconut","fruit/coconut");
    static ItemEntry<Item> GRAPES= item("grapes","fruit/grapes");
    static ItemEntry<Item> LEMON = item("lemon","fruit/lemon");
    static ItemEntry<Item> LIME = item("lime","fruit/lime");
    static ItemEntry<Item> MANGO = item("mango","fruit/mango");
    static ItemEntry<Item> NUTMEG = item("nutmeg","fruit/nutmeg");
    static ItemEntry<Item> ORANGE= item("orange","fruit/orange");
    static ItemEntry<Item> WHITE_GRAPES= item("white_grapes","fruit/white_grapes");

    static ItemEntry<Item> POPCORN_BAG = item("popcorn_bag");
    static ItemEntry<Item> MINERAL_WATER = item("mineral_water");

    static ItemEntry<Item> SPARKLING_WATER = item("sparkling_water");
    static ItemEntry<Item> ETIRPS = item("etirps");
    static ItemEntry<Item> ETIRPS_CRANBERRY = item("etirps_cranberry");
    static ItemEntry<Item> BACON = item("bacon");
    static ItemEntry<Item> TUNGSTENSTEEL_APPLE = item("tungstensteel_apple");
    static ItemEntry<Item> CAKE_BOTTOM = item("cake_bottom");
    static ItemEntry<Item> CAKE_BOTTOM_BAKED = item("cake_bottom_baked");

    //sandwich
    static ItemEntry<Item> SANDWICH_BACON = item("sandwich_bacon","sandwich/bacon");
    static ItemEntry<Item> SANDWICH_BACON_LARGE = item("sandwich_bacon_large","sandwich/bacon_large");
    static ItemEntry<Item> SANDWICH_CHEESE = item("sandwich_cheese","sandwich/cheese");
    static ItemEntry<Item> SANDWICH_CHEESE_LARGE = item("sandwich_cheese_large","sandwich/cheese_large");
    static ItemEntry<Item> SANDWICH_STEAK = item("sandwich_steak","sandwich/steak");
    static ItemEntry<Item> SANDWICH_STEAK_LARGE = item("sandwich_steak_large","sandwich/steak_large");
    static ItemEntry<Item> SANDWICH_TOAST = item("sandwich_toast","sandwich/toast");
    static ItemEntry<Item> SANDWICH_VEGGIE = item("sandwich_veggie","sandwich/veggie");
    static ItemEntry<Item> SANDWICH_VEGGIE_LARGE = item("sandwich_veggie_large","sandwich/veggie_large");
    static ItemEntry<Item> SANDWICH_VIBRANT = item("sandwich_vibrant","sandwich/vibrant");



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

    //juice
    static ItemEntry<Item> APPLE_JUICE = item("apple_juice","juice/apple");
    static ItemEntry<Item> ORANGE_JUICE = item("orange_juice","juice/orange");

    //ice_cream
    static ItemEntry<Item> ICE_CREAM = item("ice_cream","ice_cream/plain");
    static ItemEntry<Item> ICE_CREAM_BACON = item("ice_cream_bacon","ice_cream/bacon");
    static ItemEntry<Item> ICE_CREAM_BANANA = item("ice_cream_banana","ice_cream/banana");
    static ItemEntry<Item> ICE_CREAM_BEAR = item("ice_cream_bear","ice_cream/bear");
    static ItemEntry<Item> ICE_CREAM_CHIP = item("ice_cream_chip","ice_cream/chip");
    static ItemEntry<Item> ICE_CREAM_CHOCOLATE = item("ice_cream_chocolate","ice_cream/chocolate");
    static ItemEntry<Item> ICE_CREAM_CHORUS = item("ice_cream_chorus","ice_cream/chorus");
    static ItemEntry<Item> ICE_CREAM_CHUM = item("ice_cream_chum","ice_cream/chum");
    static ItemEntry<Item> ICE_CREAM_LEMON = item("ice_cream_lemon","ice_cream/lemon");
    static ItemEntry<Item> ICE_CREAM_MELON = item("ice_cream_melon","ice_cream/melon");
    static ItemEntry<Item> ICE_CREAM_RAINBOW = item("ice_cream_rainbow","ice_cream/rainbow");
    static ItemEntry<Item> ICE_CREAM_VANILLA = item("ice_cream_vanilla","ice_cream/vanilla");

    static ItemEntry<Item> CHOCOLATE = item("chocolate");
    static ItemEntry<Item> GRAHAM_CRACKER = item("graham_cracker");
    static ItemEntry<Item> MARSHMALLOW = item("marshmallow");

    //smore
    static ItemEntry<Item> SMORE_ONE = item("smore_one","smore/one");
    static ItemEntry<Item> SMORE_TWO = item("smore_two","smore/two");
    static ItemEntry<Item> SMORE_FOUR = item("smore_four","smore/four");
    static ItemEntry<Item> SMORE_EIGHT = item("smore_eight","smore/eight");
    static ItemEntry<Item> SMORE_SIXTEEN = item("smore_sixteen","smore/sixteen");
    static ItemEntry<Item> SMORE_THIRTY_TWO = item("smore_thirty_two","smore/thirty_two");
    static ItemEntry<Item> SMORE_SIXTY_FOUR = item("smore_sixty_four","smore/sixty_four");
    static ItemEntry<Item> SMOGUS = item("smogus","smore/gusone");
    static ItemEntry<Item> SMOGUS_TWO = item("smogus_two","smore/gustwo");
    static ItemEntry<Item> SMOGUS_FOUR = item("smogus_four","smore/gusfour");
    static ItemEntry<Item> SMOGUS_HEART = item("smogus_heart","smore/smogus_heart");

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

    //sorbet
    static ItemEntry<Item> SORBET = item("sorbet","sorbet/plain");
    static ItemEntry<Item> SORBET_APPLE = item("sorbet_apple","sorbet/apple");
    static ItemEntry<Item> SORBET_APRICOT = item("sorbet_apricot","sorbet/apricot");
    static ItemEntry<Item> SORBET_CHORUS = item("sorbet_chorus","sorbet/chorus");
    static ItemEntry<Item> SORBET_GRAPE = item("sorbet_grape","sorbet/grape");
    static ItemEntry<Item> SORBET_LIME = item("sorbet_lime","sorbet/lime");
    static ItemEntry<Item> SORBET_VIBRANT = item("sorbet_vibrant","sorbet/vibrant");

    static ItemEntry<Item> FERMENTED_CHORUS = item("fermented_chorus");
    static ItemEntry<Item> FERMENTED_CHORUS_PIE = item("fermented_chorus_pie");

    // 175-189 left blank for organic circuits

    static ItemEntry<Item> SPRINKLER = item("sprinkler");

    //shape
    static ItemEntry<Item> PASTA_DIE_BLANK = item("pasta_die_blank","shape/pasta/blank");
    static ItemEntry<Item> PASTA_DIE_DITALINI = item("pasta_die_ditalini","shape/pasta/ditalini");
    static ItemEntry<Item> PASTA_DIE_LASAGNA = item("pasta_die_lasagna","shape/pasta/lasagna");
    static ItemEntry<Item> PASTA_DIE_RIGATONI = item("pasta_die_rigatoni","shape/pasta/rigatoni");
    static ItemEntry<Item> PASTA_DIE_SPAGHETTI = item("pasta_die_spaghetti","shape/pasta/spaghetti");
    static ItemEntry<Item> PASTA_DIE_TAGLIATELLE = item("pasta_die_tagliatelle","shape/pasta/tagliatelle");

    //utility
    static ItemEntry<Item> KITCHEN_RECIPE = item("kitchen_recipe","utility/kitchen_recipe");

    static ItemEntry<Item> GUMMY_BEAR = item("gummy_bear");

    static ItemEntry<Item> BRICK_ADOBE = item("brick_adobe","brick_adobe");
    static ItemEntry<Item> BRICK_MUB = item("brick_mud","brick_mud");


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
