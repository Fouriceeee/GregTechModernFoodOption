package com.ironsword.gtmfo.common.data;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.ironsword.gtmfo.api.item.ExComponentItem;
import com.ironsword.gtmfo.api.item.component.BlockItemComponent;
import com.ironsword.gtmfo.api.item.component.GTMFOFoodStats;
import com.ironsword.gtmfo.common.data.builder.ExComponentItemBuilder;
import com.ironsword.gtmfo.common.data.builder.ItemBuilder;
import com.ironsword.gtmfo.data.CNLangProvider;
import com.ironsword.gtmfo.data.GTMFOProviderTypes;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateItemModelProvider;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import static com.ironsword.gtmfo.common.registry.GTMFORegistries.REGISTRATE;

//@SuppressWarnings("unused")
public class GTMFOItems {
    private static final String TEMP = "temp";

    static{
        REGISTRATE.creativeModeTab(()-> GTMFOCreativeModeTabs.MAIN_TAB);
    }

    private static final Item.Properties STACK_1 = new Item.Properties().stacksTo(1);
    private static final Item.Properties STACK_16 = new Item.Properties().stacksTo(16);

    //container
    public static final ItemEntry<Item> BAKING_TRAY           = item("baking_tray").texture("container/baking_tray").en("Baking Tray").cn("烤盘").register();
    public static final ItemEntry<Item> CAN                   = item("can").texture("container/can").en("Can").cn("易拉罐").register();
    public static final ItemEntry<Item> CERAMIC_BOWL          = item("ceramic_bowl").texture("container/bowl").en("Ceramic Bowl").cn("瓷碗").register();
    public static final ItemEntry<Item> CERAMIC_BOWL_DIRTY    = item("ceramic_bowl_dirty").texture("container/bowl_dirty").en("Dirty Bowl").cn("脏碗").register();
    public static final ItemEntry<Item> CERAMIC_BOWL_UNFIRED  = item("ceramic_bowl_unfired").texture("container/bowl_unfired").en("Unfired Bone China Bowl").cn("未烧制骨瓷碗").register();
    public static final ItemEntry<Item> CERAMIC_PLATE         = item("ceramic_plate").texture("container/plate").en("Ceramic Plate").cn("瓷盘").register();
    public static final ItemEntry<Item> CERAMIC_PLATE_DIRTY   = item("ceramic_plate_dirty").texture("container/plate_dirty").en("Dirty Plate").cn("脏盘子").register();
    public static final ItemEntry<Item> CERAMIC_PLATE_UNFIRED = item("ceramic_plate_unfired").texture("container/plate_unfired").en("Unfired Bone China Plate").cn("未烧制骨瓷盘").register();
    public static final ItemEntry<Item> CUP_EMPTY             = item("cup_empty").texture("container/cup_empty").en("Empty Cup").cn("空杯").register();
    public static final ItemEntry<Item> CUP_UNFIRED           = item("cup_unfired").texture("container/cup_unfired").en("Unfired Cup").cn("未烧制杯子").register();
    public static final ItemEntry<Item> PAPER_BAG             = item("paper_bag").texture("container/bag").en("Paper Bag").cn("纸袋").register();
    public static final ItemEntry<Item> PAPER_BAG_USED        = item("paper_bag_used").texture("container/bag_used").en("Used Paper Bag").cn("用过的纸袋").register();
    public static final ItemEntry<Item> PLASTIC_BOTTLE        = item("plastic_bottle").texture("container/plastic_bottle").en("Plastic Bottle").cn("塑料瓶").register();

    //kebab
    public static final ItemEntry<Item> SKEWER            = item("skewer").texture("kebab/skewer").en("Skewer").cn("铁签").register();
    //potato
    public static final ItemEntry<Item> CHIPS_BAG_EMPTY            = item("chips_bag_empty").texture("potato/chips_bag_empty").en("Empty Chip Bag").cn("空薯片袋").register();


    //apple
    public static final ItemEntry<Item>
            APPLE_CANDY_HOT = item("apple_candy_hot").texture("apple/candy_hot").en("Hot Apple Candy").cn("热苹果糖").register(),
            APPLE_CANDY_PLATE = item("apple_candy_plate").texture("apple/candy_plate").en("Apple Candy Sheet").cn("苹果糖片").register(),
            APPLE_CANDY_RESIN = item("apple_candy_resin").texture("apple/candy_resin").en("Apple Candy Resin").cn("苹果糖糖坯").register(),
            APPLE_CANDY_CRUSHED = item("apple_candy_crushed").texture("apple/candy_crushed").en("Crushed Apple Candy").cn("苹果糖碎").register();

    public static final ItemEntry<ExComponentItem>
            APPLE_CORED = ex("apple_cored").texture("apple/cored").en("Cored Apple").cn("去核苹果").attach(Foods.APPLE_CORED).register(),
            APPLE_SLICE = ex("apple_slice").texture("apple/slice").en("Apple Slice").cn("苹果片").attach(Foods.APPLE_SLICE).register(),
            APPLE_CANDY = ex("apple_candy").texture("apple/candy").en("Apple Candy").cn("苹果糖").attach(Foods.APPLE_CANDY).register(),
            APPLE_TUNGSTENSTEEL = ex("apple_tungstensteel").texture("apple/tungstensteel").en("Tungstensteel Apple").cn("钨钢苹果").attach(Foods.APPLE_TUNGSTENSTEEL).register();



    //berry
    public static final ItemEntry<ExComponentItem> BLACKBERRY = ex("blackberry").texture("berry/blackberry").en("Blackberry").cn("黑莓").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_TART).register();
    public static final ItemEntry<ExComponentItem> BLUEBERRY = ex("blueberry").texture("berry/blueberry").en("Blueberry").cn("蓝莓").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_SWEET).register();
    public static final ItemEntry<ExComponentItem> CRANBERRY = ex("cranberry").texture("berry/cranberry").en("Cranberry").cn("蔓越莓").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_SWEET).register();
    public static final ItemEntry<ExComponentItem> ELDERBERRY = ex("elderberry").texture("berry/elderberry").en("Elderberry").cn("接骨木莓").attach(Foods.BERRY_POISONOUS).tags(GTMFOTags.POISONOUS_BERRY).register();
    public static final ItemEntry<ExComponentItem> LINGONBERRY = ex("lingonberry").texture("berry/lingonberry").en("Lingonberry").cn("越橘").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_TART).register();
    public static final ItemEntry<ExComponentItem> RASPBERRY = ex("raspberry").texture("berry/raspberry").en("Raspberry").cn("树莓").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_SWEET).register();
    public static final ItemEntry<ExComponentItem> STRAWBERRY = ex("strawberry").texture("berry/strawberry").en("Strawberry").cn("草莓").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_SWEET).register();
    public static final ItemEntry<ExComponentItem> BLACK_CURRANT = ex("black_currant").texture("berry/black_currant").en("Black Currant").cn("黑加仑").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_TART).register();
    public static final ItemEntry<ExComponentItem> RED_CURRANT = ex("red_currant").texture("berry/red_currant").en("Red Currant").cn("红加仑").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_TART).register();
    public static final ItemEntry<ExComponentItem> WHITE_CURRANT = ex("white_currant").texture("berry/white_currant").en("White Currant").cn("白加仑").attach(Foods.BERRY).tags(GTMFOTags.BERRY, GTMFOTags.BERRY_TART).register();
    public static final ItemEntry<ExComponentItem> BERRY_MEDLEY  = ex("berry_medley").texture("berry/medley").en("Berry Medley").cn("什锦浆果").attach(Foods.BERRY_MEDLEY).register();

    //bread
    public static final ItemEntry<Item>
            WOODEN_FORM_BUN      = item("wooden_form_bun").stack(1).texture("bread/wooden_form_bun").en("Bun Wooden Form").cn("木制圆面包模具").register(),
            WOODEN_FORM_BREAD    = item("wooden_form_bread").stack(1).texture("bread/wooden_form_bread").en("Bread Wooden Form").cn("木制面包模具").register(),
            WOODEN_FORM_BAGUETTE = item("wooden_form_baguette").stack(1).texture("bread/wooden_form_baguette").en("Baguette Wooden Form").cn("木制法棍面包模具").register(),
            BUN_UNBAKED          = item("bun_unbaked").texture("bread/bun_unbaked").en("Unbaked Bun").cn("圆面包坯").register(),
            BREAD_UNBAKED        = item("bread_unbaked").texture("bread/bread_unbaked").en("Unbaked Bread").cn("面包坯").register(),
            BAGUETTE_UNBAKED = item("baguette_unbaked").texture("bread/baguette_unbaked").en("Unbaked Baguette").cn("法棍面包坯").register();

    public static final ItemEntry<ExComponentItem>
            BUN                  = ex("bun").texture("bread/bun").en("Bun").cn("圆面包").attach(Foods.BUN).register(),
            BUN_SLICED           = ex("bun_sliced").texture("bread/bun_sliced").en("Pre-Sliced Bun").cn("切好的圆面包").attach(Foods.BUN_SLICED).register(),
            BREAD_SLICED         = ex("bread_sliced").texture("bread/bread_sliced").en("Pre-Sliced Bread").cn("切好的面包").attach(Foods.BREAD_SLICED).register(),
            BREAD_SLICE          = ex("bread_slice").texture("bread/bread_slice").en("Bread Slice").cn("面包片").attach(Foods.BREAD_SLICE).register(),
            TOAST                = ex("toast").texture("bread/toast").en("Toast").cn("吐司").attach(Foods.TOAST).register(),
            BAGUETTE             = ex("baguette").texture("bread/baguette").en("Baguette").cn("法棍面包").attach(Foods.BAGUETTE).register(),
            BAGUETTE_SLICED      = ex("baguette_sliced").texture("bread/baguette_sliced").en("Pre-Sliced Baguette").cn("切好的法棍面包").attach(Foods.BAGUETTE_SLICED).register();

    //burger
    public static final ItemEntry<ExComponentItem>
            BURGER_BACON  = ex("burger_bacon").texture("burger/bacon").en("Bacon Burger").cn("培根汉堡").attach(Foods.BURGER_MEAT).register(),
            BURGER_CHEESE = ex("burger_cheese").texture("burger/cheese").en("Cheese Burger").cn("芝士汉堡").attach(Foods.BURGER_CHEESE).register(),
            BURGER_CHUM   = ex("burger_chum").texture("burger/chum").en("Chum Burger").cn("海霸堡").attach(Foods.BURGER_CHUM).register(),
            BURGER_STEAK  = ex("burger_steak").texture("burger/steak").en("Steak Burger").cn("牛肉汉堡").attach(Foods.BURGER_MEAT).register(),
            BURGER_VEGGIE = ex("burger_veggie").texture("burger/veggie").en("Veggie Burger").cn("蔬菜汉堡").attach(Foods.BURGER_VEGGIE).register();

    //TODO:caplet
    public static final ItemEntry<Item> CAPLET_CAP           = item("caplet_cap").texture("caplet/cap").en("Caplet Cap").cn("囊帽").register();
    public static final ItemEntry<Item> CAPLET_BODY          = item("caplet_body").texture("caplet/body").en("Caplet Body").cn("囊体").register();
    public static final ItemEntry<ExComponentItem>
            CAPLET_GEL           = ex("caplet_gel").texture("caplet/gel").en("Gel Caplet").cn("明胶胶囊").attach(Foods.CAPLET_GEL).register(),
            CAPLET_PARACETAMOL   = ex("caplet_paracetamol").texture("caplet/paracetamol").en("Paracetamol Caplet").cn("对乙酰氨基酚胶囊").attach(Foods.CAPLET_PARACETAMOL).register(),
            CAPLET_PLUTONIUM_241 = ex("caplet_plutonium_241").texture("caplet/plutonium_241").en("Plutonium-241 Caplet").cn("钚-241胶囊").attach(Foods.CAPLET_PLUTONIUM_241).register(),
            CAPLET_CHORUS        = ex("caplet_chorus").texture("caplet/chorus").en("Fermented Chorus Caplet").cn("发酵紫颂果胶囊").attach(Foods.CAPLET_GEL).register(),
            CAPLET_VIBRANT       = ex("caplet_vibrant").texture("caplet/vibrant").en("Vibrant Caplet").cn("Vibrant Caplet").attach(Foods.CAPLET_GEL).register();

    //cheese
    public static final ItemEntry<Item>            CHEDDAR_BLOCK     = item("cheddar_block").texture("cheese/cheddar_block").en("Cheddar Block").cn("块状切达奶酪").register();
    public static final ItemEntry<ExComponentItem> CHEDDAR_SLICE     = ex("cheddar_slice").texture("cheese/cheddar_slice").en("Cheddar Slice").cn("切达奶酪片").attach(Foods.CHEDDAR_SLICE).register();
    public static final ItemEntry<Item>            CHEDDAR_AGED_MOLD = item("cheddar_aged_mold").texture("cheese/cheddar_aged_mold").en("Aged Cheddar Mold").cn("装有熟化切达奶酪的模具").register();
    public static final ItemEntry<Item>            CHEDDAR_CURD_MOLD = item("cheddar_curd_mold").texture("cheese/cheddar_curd_mold").en("Cheddar Curd Mold").cn("装有切达奶酪凝乳的模具").register();
    public static final ItemEntry<Item>            MOZZARELLA_SLICE  = item("mozzarella_slice").texture("cheese/mozzarella_slice").en("Mozzarella Slice").cn("马苏里拉奶酪片").register();
    public static final ItemEntry<ExComponentItem> MOZZARELLA_BALL   = ex("mozzarella_ball").texture("cheese/mozzarella_ball").en("Mozzarella Ball").cn("马苏里拉奶酪球").attach(Foods.MOZZARELLA_BALL).register();
    public static final ItemEntry<Item>            RICOTTA_PIECE     = item("ricotta_piece").texture("cheese/ricotta_piece").en("Ricotta Piece").cn("里科塔奶酪凝块").register();
    public static final ItemEntry<Item>            GORGONZOLA_WHEEL               = item("gorgonzola_wheel").texture("cheese/gorgonzola_wheel").en("Gorgonzola Wheel").cn("戈贡佐拉奶酪轮").register();
    public static final ItemEntry<Item>            GORGONZOLA_WHEEL_SALTED        = item("gorgonzola_wheel_salted").texture("cheese/gorgonzola_wheel_salted").en("Salted Gorgonzola Wheel").cn("加盐戈贡佐拉奶酪轮").register();
    public static final ItemEntry<Item>            GORGONZOLA_WHEEL_SLIGHTLY_AGED = item("gorgonzola_wheel_slightly_aged").texture("cheese/gorgonzola_wheel_slightly_aged").en("Slightly Aged Gorgonzola Wheel").cn("初步熟化戈贡佐拉奶酪轮").register();
    public static final ItemEntry<Item>            GORGONZOLA_WHEEL_PUNCTURED     = item("gorgonzola_wheel_punctured").texture("cheese/gorgonzola_wheel_punctured").en("Punctured Gorgonzola Wheel").cn("扎孔戈贡佐拉奶酪轮").register();
    public static final ItemEntry<Item>            GORGONZOLA_WHEEL_FULLY_CURED   = item("gorgonzola_wheel_fully_cured").texture("cheese/gorgonzola_wheel_fully_cured").en("Fully Cured Gorgonzola Wheel").cn("硬化戈贡佐拉奶酪轮").register();
    public static final ItemEntry<ExComponentItem> GORGONZOLA_TRIANGULAR_SLICE    = ex("gorgonzola_triangular_slice").texture("cheese/gorgonzola_triangular_slice").en("Gorgonzola Triangular Slice").cn("戈贡佐拉奶酪三角").attach(Foods.GORGONZOLA_TRIANGULAR).register();
    public static final ItemEntry<Item>            PARMIGIANO_CHEESE_FORM = item("parmigiano_cheese_form").texture("cheese/parmigiano_cheese_form").en("Stainless Steel Cheese Form").cn("不锈钢奶酪模具").register();
    public static final ItemEntry<Item>            PARMIGIANO_BRINED      = item("parmigiano_brined").texture("cheese/parmigiano_brined").en("Brined Parmigiano-Reggiano in Cheese Form").cn("装有盐渍帕马森-雷加诺奶酪的奶酪模具").register();
    public static final ItemEntry<Item>            PARMIGIANO_BRINED_ROLL = item("parmigiano_brined_roll").texture("cheese/parmigiano_brined_roll").en("Brined Parmigiano-Reggiano Roll").cn("盐渍帕马森-雷加诺奶酪卷").register();
    public static final ItemEntry<Item>            PARMIGIANO_AGED_ROLL   = item("parmigiano_aged_roll").texture("cheese/parmigiano_aged_roll").en("Aged Parmigiano-Reggiano Roll").cn("熟化帕马森-雷加诺奶酪卷").register();
    public static final ItemEntry<Item>            PARMIGIANO_CURDLING    = item("parmigiano_curdling").texture("cheese/parmigiano_curdling").en("Curdling Parmigiano-Reggiano in Cheese Form").cn("装有半凝固帕马森-雷加诺奶酪乳液的奶酪模具").register();

    //cocoa
    public static final ItemEntry<Item> COCOA_BEANS_ROASTED = item("cocoa_beans_roasted").texture("cocoa/roasted").en("Roasted Cocoa Beans").cn("烘焙可可豆").register();
    public static final ItemEntry<Item> COCOA_BEANS_HULLED  = item("cocoa_beans_hulled").texture("cocoa/hulled").en("Hulled Cocoa Beans").cn("去壳可可豆").register();
    public static final ItemEntry<Item> COCOA_SHELL         = item("cocoa_shell").texture("cocoa/shell").en("Cocoa Shell").cn("可可壳").register();
    public static final ItemEntry<Item> COCOA_NIBS          = item("cocoa_nibs").texture("cocoa/nibs").en("Ground Cocoa Nibs").cn("可可碎").register();

    //coffee
    public static final ItemEntry<Item> COFFEE_CHERRY                = item("coffee_cherry").texture("coffee/cherry").en("Coffee Cherry").cn("咖啡果").register();
    //public static final ItemEntry<Item> COFFEE_SEED                  = item("coffee_seed"                 ,"Coffee Seed"                 ,"咖啡种子"      ,"coffee/seed"           );
    public static final ItemEntry<Item> COFFEE_CHERRY_LARGE          = item("coffee_cherry_large").texture("coffee/cherry_large").en("Large Coffee Cherry").cn("大咖啡果").register();
    public static final ItemEntry<Item> COFFEE_CHERRY_SMALL          = item("coffee_cherry_small").texture("coffee/cherry_small").en("Small Coffee Cherry").cn("小咖啡果").register();
    public static final ItemEntry<Item> COFFEE_BEANS_RAW_LARGE       = item("coffee_beans_raw_large").texture("coffee/raw_large").en("Large Raw Coffee Beans").cn("大粒生咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_RAW_SMALL       = item("coffee_beans_raw_small").texture("coffee/raw_small").en("Small Raw Coffee Beans").cn("小粒生咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_FERMENTED_LARGE = item("coffee_beans_fermented_large").texture("coffee/fermented_large").en("Large Fermented Coffee Beans").cn("发酵大粒咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_FERMENTED_SMALL = item("coffee_beans_fermented_small").texture("coffee/fermented_small").en("Small Fermented Coffee Beans").cn("发酵小粒咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_DRIED_LARGE     = item("coffee_beans_dried_large").texture("coffee/dried_large").en("Large Dried Coffee Beans").cn("烘干大粒咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_DRIED_SMALL     = item("coffee_beans_dried_small").texture("coffee/dried_small").en("Small Dried Coffee Beans").cn("烘干小粒咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_HULLED_LARGE    = item("coffee_beans_hulled_large").texture("coffee/hulled_large").en("Large Hulled Coffee Beans").cn("去壳大粒咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_HULLED_SMALL    = item("coffee_beans_hulled_small").texture("coffee/hulled_small").en("Small Hulled Coffee Beans").cn("去壳小粒咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_ROASTED_LARGE   = item("coffee_beans_roasted_large").texture("coffee/roasted_large").en("Large Roasted Coffee Beans").cn("烘焙大粒咖啡豆").register();
    public static final ItemEntry<Item> COFFEE_BEANS_ROASTED_SMALL   = item("coffee_beans_roasted_small").texture("coffee/roasted_small").en("Small Roasted Coffee Beans").cn("烘焙小粒咖啡豆").register();
    public static final ItemEntry<ExComponentItem> COFFEE           = ex("coffee").texture("coffee/normal").en("Coffee Cup").cn("咖啡").attach(Foods.COFFEE).register();
    public static final ItemEntry<ExComponentItem> COFFEE_ENERGIZED = ex("coffee_energized").texture("coffee/energized").en("Energized Coffee Cup").cn("提神咖啡").attach(Foods.COFFEE_ENERGIZING).register();

    //corn
    public static final ItemEntry<Item> CORN_COB               = item("corn_cob").texture("corn/cob").en("Corn Cob").cn("玉米芯").register();
    public static final ItemEntry<Item> CORN_EAR               = item("corn_ear").texture("corn/ear").en("Corn Ear").cn("玉米穗").register();
    //public static final ItemEntry<Item> CORN_EAR_DRIED         = item("corn_ear_dried"        ,"Dried Corn Ear"        ,"烘干玉米穗"  ,"corn/ear_dried"        );
    public static final ItemEntry<Item> CORN_KERNEL            = item("corn_kernel").texture("corn/kernel").en("Corn Kernel").cn("玉米粒").register();
    //public static final ItemEntry<Item> CORN_KERNEL_ACCEPTABLE = item("corn_kernel_acceptable","Acceptable Corn Kernel","合格级玉米粒","corn/kernel_acceptable");
    public static final ItemEntry<Item> FLAVORED_POPCORN_FLAKE = item("flavored_flake").texture("corn/flavored_flake").en("Flavored Popcorn Flake").cn("调味爆米花粒").register();
    public static final ItemEntry<ExComponentItem> POPCORN_BAG = ex("popcorn_bag").texture("corn/popcorn_bag").en("Popcorn Bag").cn("袋装爆米花").attach(Foods.EMPTY).register();

    //crop
    public static final ItemEntry<Item> ARTICHOKE      = item("artichoke").texture("crop/artichoke").en("Artichoke Heart").cn("洋蓟心").register();
    public static final ItemEntry<Item> BASIL          = item("basil").texture("crop/basil").en("Basil Leaf").cn("罗勒叶").register();
    public static final ItemEntry<Item> BLACK_PEPPER   = item("black_pepper").texture("crop/black_pepper").en("Black Peppercorns").cn("黑胡椒籽").register();
    public static final ItemEntry<Item> CARROT_SLICE   = item("carrot_slice").texture("crop/carrot_slice").en("Carrot Slice").cn("胡萝卜片").register();
    public static final ItemEntry<Item> COTTON         = item("cotton").texture("crop/cotton").en("Cotton").cn("棉花").register();
    public static final ItemEntry<Item> CUCUMBER       = item("cucumber").texture("crop/cucumber").en("Cucumber").cn("黄瓜").register();
    public static final ItemEntry<Item> CUCUMBER_SLICE = item("cucumber_slice").texture("crop/cucumber_slice").en("Cucumber Slice").cn("黄瓜片").register();
    public static final ItemEntry<Item> EGGPLANT       = item("eggplant").texture("crop/eggplant").en("Eggplant").cn("茄子").register();
    public static final ItemEntry<Item> EGGPLANT_SLICE = item("eggplant_slice").texture("crop/eggplant_slice").en("Eggplant Slice").cn("茄子片").register();
    public static final ItemEntry<Item> GARLIC_PURPLE  = item("garlic_purple").texture("crop/garlic_purple").en("Purple Garlic").cn("紫大蒜").register();
    public static final ItemEntry<Item> GARLIC_WHITE   = item("garlic_white").texture("crop/garlic_white").en("White Garlic").cn("白大蒜").register();
    public static final ItemEntry<Item> HOP            = item("hop").texture("crop/hop").en("Hop").cn("啤酒花").register();
    public static final ItemEntry<Item> HORSERADISH    = item("horseradish").texture("crop/horseradish").en("Horseradish").cn("辣根").register();
    public static final ItemEntry<Item> LETTUCE        = item("lettuce").texture("crop/lettuce").en("Lettuce").cn("生菜").register();
    public static final ItemEntry<Item> LETTUCE_LEAF   = item("lettuce_leaf").texture("crop/lettuce_leaf").en("Lettuce Leaf").cn("生菜叶").register();
    public static final ItemEntry<Item> MUSHROOM_SLICE = item("mushroom_slice").texture("crop/mushroom_slice").en("Mushroom Slice").cn("蘑菇片").register();
    public static final ItemEntry<Item> OLIVE          = item("olive").texture("crop/olive").en("Olive").cn("橄榄").register();
    public static final ItemEntry<Item> OLIVE_SLICE    = item("olive_slice").texture("crop/olive_slice").en("Olive Slice").cn("橄榄片").register();
    public static final ItemEntry<Item> ONION          = item("onion").texture("crop/onion").en("Onion").cn("洋葱").register();
    public static final ItemEntry<Item> ONION_SLICE    = item("onion").texture("crop/onion_slice").en("Onion Slice").cn("洋葱片").register();
    public static final ItemEntry<Item> OREGANO        = item("oregano").texture("crop/oregano").en("Oregano Leaf").cn("牛至叶").register();
    public static final ItemEntry<Item> PEA_POD        = item("pea_pod").texture("crop/pea_pod").en("Pea Pod").cn("豌豆荚").register();
    public static final ItemEntry<Item> RICE           = item("rice").texture("crop/rice").en("Rice").cn("大米").register();
    public static final ItemEntry<Item> SOYBEAN        = item("soybean").texture("crop/soybean").en("Soybean").cn("大豆").register();
    public static final ItemEntry<Item> SOYBEAN_POD    = item("soybean_pod").texture("crop/soybean_pod").en("Soybean Pod").cn("大豆荚").register();
    public static final ItemEntry<Item> TOMATO         = item("tomato").texture("crop/tomato").en("Tomato").cn("番茄").register();
    public static final ItemEntry<Item> TOMATO_SLICE   = item("tomato_slice").texture("crop/tomato_slice").en("Tomato Slice").cn("番茄片").register();

    //dewar_flask
    public static final ItemEntry<Item> DEWAR_FLASK                = item("dewar_flask").texture("dewar_flask/new").en("Dewar Flask").cn("保温杯").register();
    public static final ItemEntry<Item> DEWAR_FLASK_USED           = item("dewar_flask_used").texture("dewar_flask/used").en("Used Dewar Flask").cn("使用过的保温杯").register();
    public static final ItemEntry<Item> DEWAR_FLASK_CAP            = item("dewar_flask_cap").texture("dewar_flask/cap").en("Dewar Flask Cap").cn("保温杯盖").register();
    public static final ItemEntry<Item> DEWAR_FLASK_CASING         = item("dewar_flask_casing").texture("dewar_flask/casing").en("Dewar Flask Casing").cn("保温杯身").register();
    public static final ItemEntry<Item> DEWAR_FLASK_CASING_LEACHED = item("dewar_flask_casing_leached").texture("dewar_flask/casing_leached").en("Leached Dewar Flask Casing").cn("使用过的保温杯身").register();

    //dough
    public static final ItemEntry<Item> DOUGH                = item("dough").texture("dough/dough").en("Dough").cn("面团").register();
    public static final ItemEntry<Item> DOUGH_FLAT           = item("flat_dough").texture("dough/flat").en("Flat Dough").cn("扁平面团").register();
    public static final ItemEntry<Item> DOUGH_SUGARY         = item("sugary_dough").texture("dough/sugary").en("Sugary Dough").cn("甜面团").register();
    public static final ItemEntry<Item> PASTA_DOUGH          = item("pasta_dough").texture("dough/pasta").en("Pasta Dough").cn("意面面团").register();
    public static final ItemEntry<Item> PASTA_DOUGH_EGG      = item("pasta_dough_egg").texture("dough/pasta_egg").en("Egg Pasta Dough").cn("蛋液意面面团").register();
    public static final ItemEntry<Item> PASTA_DOUGH_PREMIXED = item("pasta_dough_premixed").texture("dough/pasta_premixed").en("Premixed Pasta Dough").cn("预拌意面面团").register();

    //drink
    public static final ItemEntry<ExComponentItem> ANTAF            = ex("antaf").texture("drink/antaf").en("Antaf™").cn("Antaf™").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> BEER             = ex("beer").texture("drink/beer").en("Beer").cn("啤酒").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> COAC             = ex("coac").texture("drink/coac").en("Coac").cn("乐可").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> ETIRPS           = ex("etirps").texture("drink/etirps").en("Etirps™").cn("碧雪™").attach(Foods.ETIRPS).register();
    public static final ItemEntry<ExComponentItem> ETIRPS_CRANBERRY = ex("etirps_cranberry").texture("drink/etirps_cranberry").en("Etirps Cranberry").cn("蔓越莓味碧雪").attach(Foods.ETIRPS_CRANBERRY).register();
    public static final ItemEntry<ExComponentItem> GREEN_ISLAND     = ex("green_island").texture("drink/green_island").en("Green Island™").cn("绿岛啤酒™").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> JUICE_APPLE      = ex("juice_apple").texture("drink/juice_apple").en("Apple Juice").cn("苹果汁").attach(Foods.JUICE).register();
    public static final ItemEntry<ExComponentItem> JUICE_ORANGE     = ex("juice_orange").texture("drink/juice_orange").en("Orange Juice").cn("橙汁").attach(Foods.JUICE).register();
    public static final ItemEntry<ExComponentItem> LENINADE         = ex("leninade").texture("drink/leninade").en("Leninade").cn("列宁檬汁").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> MINERAL_WATER    = ex("mineral_water").texture("drink/mineral_water").en("Mineral Water").cn("矿泉水").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> NILK             = ex("nilk").texture("drink/nilk").en("Nilk").cn("硅岩风味乳").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> RED_WINE         = ex("red_wine").texture("drink/red_wine").en("Red Wine").cn("红葡萄酒").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> SEPIP            = ex("sepip").texture("drink/sepip").en("Sepip").cn("事百").attach(Foods.ETIRPS).register();
    public static final ItemEntry<ExComponentItem> SPARKLING_WATER  = ex("sparkling_water").texture("drink/sparkling_water").en("Sparkling Water").cn("气泡水").attach(Foods.SPARKLING_WATER).register();
    public static final ItemEntry<ExComponentItem> VODKA            = ex("vodka").texture("drink/vodka").en("Vodka").cn("伏特加").attach(Foods.VODKA).register();
    public static final ItemEntry<ExComponentItem> WHITE_WINE       = ex("white_wine").texture("drink/white_wine").en("White Wine").cn("白葡萄酒").attach(Foods.EMPTY).register();

    //food_chinese
    public static final ItemEntry<Item> JIAOZI     = item("jiaozi").texture("food_chinese/jiaozi").en("Jiaozi").cn("饺子").register();
    public static final ItemEntry<Item> JIAOZI_RAW = item("jiaozi_raw").texture("food_chinese/jiaozi_raw").en("Raw Jiaozi").cn("生饺子").register();

    //food_italian
    public static final ItemEntry<Item> BRUSCHETTA             = item("bruschetta").texture("food_italian/bruschetta").en("Bruschetta").cn("意式烤面包片").register();
    public static final ItemEntry<Item> CAPONATA               = item("caponata").texture("food_italian/caponata").en("Caponata").cn("意式酸甜茄子").register();
    public static final ItemEntry<Item> CARBONARA              = item("carbonara").texture("food_italian/carbonara").en("Carbonara").cn("培根蛋酱意面").register();
    public static final ItemEntry<Item> FETTUCCINE_ALFREDO     = item("fettuccine_alfredo").texture("food_italian/fettuccine_alfredo").en("Fettuccine Alfredo").cn("阿尔弗雷多芝士宽面").register();
    public static final ItemEntry<Item> CARCIOFI_ALLA_ROMANA   = item("carciofi_alla_romana").texture("food_italian/carciofi_alla_romana").en("Carciofi alla Romana").cn("罗马风味烤洋蓟").register();
    public static final ItemEntry<Item> PARMIGIANA             = item("parmigiana").texture("food_italian/parmigiana").en("Parmigiana").cn("意式焗烤千层茄子").register();
    public static final ItemEntry<Item> PASTA_E_FAGIOLI        = item("pasta_e_fagioli").texture("food_italian/pasta_e_fagioli").en("Pasta e fagioli").cn("意面豆汤").register();
    public static final ItemEntry<Item> PASTA_ALLA_NORMA       = item("pasta_alla_norma").texture("food_italian/pasta_alla_norma").en("Pasta alla Norma").cn("诺玛红酱茄子通心粉").register();
    public static final ItemEntry<Item> PASTA_AL_POMODORO      = item("pasta_al_pomodoro").texture("food_italian/pasta_al_pomodoro").en("Pasta al pomodoro").cn("番茄意面").register();
    public static final ItemEntry<Item> PASTA_ALL_AMOGUS       = item("pasta_all_amogus").texture("food_italian/pasta_all_amogus").en("Pasta all'Amogus").cn("内鬼意面").register();
    public static final ItemEntry<Item> POLENTA                = item("polenta").texture("food_italian/polenta").en("Polenta").cn("意式玉米糊").register();
    public static final ItemEntry<Item> PORCHETTA              = item("porchetta").texture("food_italian/porchetta").en("Porchetta").cn("意式脆皮烤五花肉").register();
    public static final ItemEntry<Item> PORCHETTA_SLICE        = item("porchetta_slice").texture("food_italian/porchetta_slice").en("Porchetta Slice").cn("意式脆皮烤五花肉片").register();
    public static final ItemEntry<Item> RAFANATA               = item("rafanata").texture("food_italian/rafanata").en("Rafanata").cn("意式辣根蛋饼").register();
    public static final ItemEntry<Item> RISOTTO                = item("risotto").texture("food_italian/risotto").en("Risotto").cn("意式烩饭").register();
    public static final ItemEntry<Item> SPAGHETTI_ALLASSASSINA = item("spaghetti_all_assassina").texture("food_italian/spaghetti_all_assassina").en("Spaghetti all'assassina").cn("刺客意面").register();
    public static final ItemEntry<Item> TAGLIATELLE_AL_RAGU    = item("tagliatelle_al_ragu").texture("food_italian/tagliatelle_al_ragu").en("Tagliatelle al ragu").cn("意式番茄肉酱面").register();
    public static final ItemEntry<Item> TORTELLINI_IN_BRODO    = item("tortellini_in_brodo").texture("food_italian/tortellini_in_brodo").en("Tortellini in brodo").cn("意式肉汤馄饨").register();
    public static final ItemEntry<Item> VITELLO_TONNATO        = item("vitello_tonnato").texture("food_italian/vitello_tonnato").en("Vitello Tonnato").cn("意式鱼香小牛肉").register();

    //food_russian
    public static final ItemEntry<Item> PELMENI                   = item("pelmeni").texture("food_russian/pelmeni").en("Pelmeni").cn("俄式饺子").register();
    public static final ItemEntry<Item> PELMENI_SEASONED          = item("pelmeni_seasoned").texture("food_russian/pelmeni_seasoned").en("Seasoned Pelmeni").cn("调味俄式饺子").register();
    public static final ItemEntry<Item> PELMENI_UNCOOKED          = item("pelmeni_uncooked").texture("food_russian/pelmeni_uncooked").en("Uncooked Pelmeni").cn("生俄式饺子").register();
    public static final ItemEntry<Item> PELMENI_SEASONED_UNCOOKED = item("pelmeni_seasoned_uncooked").texture("food_russian/pelmeni_seasoned_uncooked").en("Seasoned Uncooked Pelmeni").cn("调味生俄式饺子").register();

    //fruit
    public static final ItemEntry<Item> APRICOT       = item("apricot").texture("fruit/apricot").en("Apricot").cn("杏子").register();
    public static final ItemEntry<Item> BANANA        = item("banana").texture("fruit/banana").en("Banana").cn("香蕉").register();
    public static final ItemEntry<Item> BANANA_PEELED = item("banana_peeled").texture("fruit/banana_peeled").en("Peeled Banana").cn("去皮香蕉").register();
    public static final ItemEntry<Item> COCONUT       = item("coconut").texture("fruit/coconut").en("Coconut").cn("椰子").register();
    public static final ItemEntry<Item> GRAPES        = item("grapes").texture("fruit/grapes").en("Grapes").cn("葡萄").register();
    public static final ItemEntry<Item> LEMON         = item("lemon").texture("fruit/lemon").en("Lemon").cn("柠檬").register();
    public static final ItemEntry<Item> LIME          = item("lime").texture("fruit/lime").en("Lime").cn("酸橙").register();
    public static final ItemEntry<Item> MANGO         = item("mango").texture("fruit/mango").en("Mango").cn("芒果").register();
    public static final ItemEntry<Item> NUTMEG        = item("nutmeg").texture("fruit/nutmeg").en("Nutmeg Seeds").cn("肉桂果").register();
    public static final ItemEntry<Item> ORANGE        = item("orange").texture("fruit/orange").en("Orange").cn("橙子").register();
    public static final ItemEntry<Item> WHITE_GRAPES  = item("white_grapes").texture("fruit/white_grapes").en("White Grapes").cn("白葡萄").register();

    //ice_cream
    public static final ItemEntry<Item> ICE_CREAM           = item("ice_cream").texture("ice_cream/plain").en("Plain Ice Cream").cn("原味冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_BACON     = item("ice_cream_bacon").texture("ice_cream/bacon").en("Bacon Ice Cream").cn("培根冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_BANANA    = item("ice_cream_banana").texture("ice_cream/banana").en("Banana Ice Cream").cn("香蕉冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_BEAR      = item("ice_cream_bear").texture("ice_cream/bear").en("Bear Ice Cream").cn("熊先生冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_CHIP      = item("ice_cream_chip").texture("ice_cream/chip").en("Potato Chip Ice Cream").cn("薯片冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_CHOCOLATE = item("ice_cream_chocolate").texture("ice_cream/chocolate").en("Chocolate Ice Cream").cn("巧克力冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_CHORUS    = item("ice_cream_chorus").texture("ice_cream/chorus").en("Chorus Ice Cream").cn("紫颂果冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_CHUM      = item("ice_cream_chum").texture("ice_cream/chum").en("Chum Ice Cream").cn("海霸冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_LEMON     = item("ice_cream_lemon").texture("ice_cream/lemon").en("Lemon Ice Cream").cn("柠檬冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_MELON     = item("ice_cream_melon").texture("ice_cream/melon").en("Melon Ice Cream").cn("西瓜冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_RAINBOW   = item("ice_cream_rainbow").texture("ice_cream/rainbow").en("Rainbow Ice Cream").cn("彩虹冰淇淋").register();
    public static final ItemEntry<Item> ICE_CREAM_VANILLA   = item("ice_cream_vanilla").texture("ice_cream/vanilla").en("Vanilla Ice Cream").cn("香草冰淇淋").register();

    //kebab
    public static final ItemEntry<Item> KEBAB_BARG        = item("kebab_barg").texture("kebab/barg").en("Barg Kebab").cn("伊朗叶子肉烤串").register();
    public static final ItemEntry<Item> KEBAB_BARG_RAW    = item("kebab_barg_raw").texture("kebab/barg_raw").en("Raw Barg Kebab").cn("生伊朗叶子肉烤串").register();
    public static final ItemEntry<Item> KEBAB_CARROT      = item("kebab_carrot").texture("kebab/carrot").en("Carrot Kebab").cn("烤胡萝卜串").register();
    public static final ItemEntry<Item> KEBAB_CARROT_RAW  = item("kebab_carrot_raw").texture("kebab/carrot_raw").en("Raw Carrot Kebab").cn("生胡萝卜串").register();
    public static final ItemEntry<Item> KEBAB_CHUM        = item("kebab_chum").texture("kebab/chum").en("Chum Kebab").cn("烤海霸串").register();
    public static final ItemEntry<Item> KEBAB_CHUM_RAW    = item("kebab_chum_raw").texture("kebab/chum_raw").en("Raw Chum Kebab").cn("生海霸串").register();
    public static final ItemEntry<Item> KEBAB_FAT         = item("kebab_fat").texture("kebab/fat").en("TailFat Kebab").cn("烤肥尾串").register();
    public static final ItemEntry<Item> KEBAB_FAT_RAW     = item("kebab_fat_raw").texture("kebab/fat_raw").en("Raw TailFat Kebab").cn("生肥尾串").register();
    public static final ItemEntry<Item> KEBAB_KUBIDEH     = item("kebab_kubideh").texture("kebab/kubideh").en("Kubideh Kebab").cn("伊朗碎肉烤串").register();
    public static final ItemEntry<Item> KEBAB_KUBIDEH_RAW = item("kebab_kubideh_raw").texture("kebab/kubideh_raw").en("Raw Kubideh Kebab").cn("生伊朗碎肉烤串").register();
    public static final ItemEntry<Item> KEBAB_MEAT        = item("kebab_meat").texture("kebab/meat").en("Meat Kebab").cn("烤肉串").register();
    public static final ItemEntry<Item> KEBAB_MEAT_RAW    = item("kebab_meat_raw").texture("kebab/meat_raw").en("Raw Meat Kebab").cn("生肉串").register();
    public static final ItemEntry<Item> KEBAB_ONION       = item("kebab_onion").texture("kebab/onion").en("Onion Kebab").cn("烤洋葱串").register();
    public static final ItemEntry<Item> KEBAB_ONION_RAW   = item("kebab_onion_raw").texture("kebab/onion_raw").en("Raw Onion Kebab").cn("生洋葱串").register();
    public static final ItemEntry<Item> KEBAB_TOMATO      = item("kebab_tomato").texture("kebab/tomato").en("Tomato Kebab").cn("烤番茄串").register();
    public static final ItemEntry<Item> KEBAB_TOMATO_RAW  = item("kebab_tomato_raw").texture("kebab/tomato_raw").en("Raw Tomato Kebab").cn("生番茄串").register();
    public static final ItemEntry<Item> KEBAB_SOLTANI     = item("kebab_soltani").texture("kebab/soltani").en("Kebab e Soltani!").cn("苏丹烤肉").register();

    //pasta
    public static final ItemEntry<Item> DITALINI          = item("ditalini").texture("pasta/ditalini").en("Ditalini").cn("意式手指面").register();
    public static final ItemEntry<Item> DITALINI_RAW      = item("ditalini_raw").texture("pasta/ditalini_raw").en("Raw Ditalini").cn("生意式手指面").register();
    public static final ItemEntry<Item> DITALINI_DRIED    = item("ditalini_dried").texture("pasta/ditalini_dried").en("Dried Ditalini").cn("干意式手指面").register();
    public static final ItemEntry<Item> RIGATONI          = item("rigatoni").texture("pasta/rigatoni").en("Rigatoni").cn("意式粗通心粉").register();
    public static final ItemEntry<Item> RIGATONI_RAW      = item("rigatoni_raw").texture("pasta/rigatoni_raw").en("Raw Rigatoni").cn("生意式粗通心粉").register();
    public static final ItemEntry<Item> RIGATONI_DRIED    = item("rigatoni_dried").texture("pasta/rigatoni_dried").en("Dried Rigatoni").cn("干意式粗通心粉").register();
    public static final ItemEntry<Item> SPAGHETTI         = item("spaghetti").texture("pasta/spaghetti").en("Spaghetti").cn("意式直面").register();
    public static final ItemEntry<Item> SPAGHETTI_RAW     = item("spaghetti_raw").texture("pasta/spaghetti_raw").en("Raw Spaghetti").cn("生意式直面").register();
    public static final ItemEntry<Item> SPAGHETTI_DRIED   = item("spaghetti_dried").texture("pasta/spaghetti_dried").en("Dried Spaghetti").cn("干意式直面").register();
    public static final ItemEntry<Item> TAGLIATELLE       = item("tagliatelle").texture("pasta/tagliatelle").en("Tagliatelle").cn("意式干面").register();
    public static final ItemEntry<Item> TAGLIATELLE_RAW   = item("tagliatelle_raw").texture("pasta/tagliatelle_raw").en("Raw Tagliatelle").cn("生意式干面").register();
    public static final ItemEntry<Item> TAGLIATELLE_DRIED = item("tagliatelle_dried").texture("pasta/tagliatelle_dried").en("Dried Tagliatelle").cn("干意式干面").register();
    public static final ItemEntry<Item> TORTELLINI        = item("tortellini").texture("pasta/tortellini").en("Tortellini").cn("意式馄饨").register();
    public static final ItemEntry<Item> LASAGNA_RAW               = item("lasagna_raw").texture("pasta/lasagna_raw").en("Raw Lasagna").cn("生意式千层面").register();
    public static final ItemEntry<Item> LASAGNA_DRIED             = item("lasagna_dried").texture("pasta/lasagna_dried").en("Dried Lasagna").cn("干意式千层面").register();
    public static final ItemEntry<Item> LASAGNA_CHUM              = item("lasagna_chum").texture("pasta/lasagna_chum").en("Chum Lasagna").cn("海霸意式千层面").register();
    public static final ItemEntry<Item> LASAGNA_CHUM_RAW          = item("lasagna_chum_raw").texture("pasta/lasagna_chum_raw").en("Unbaked Chum Lasagna in Baking Tray").cn("装有未烘烤海霸意式千层面的烤盘").register();
    public static final ItemEntry<Item> LASAGNA_CHUM_COOKED       = item("lasagna_chum_cooked").texture("pasta/lasagna_chum_cooked").en("Baked Chum Lasagna in Baking Tray").cn("装有海霸意式千层面的烤盘").register();
    public static final ItemEntry<Item> LASAGNA_NAPOLETANA        = item("lasagna_napoletana").texture("pasta/lasagna_napoletana").en("Lasagna Napoletana").cn("那不勒斯风味千层面").register();
    public static final ItemEntry<Item> LASAGNA_NAPOLETANA_RAW    = item("lasagna_napoletana_raw").texture("pasta/lasagna_napoletana_raw").en("Unbaked Napoletana Lasagna in Baking Tray").cn("装有未烘烤那不勒斯风味千层面的烤盘").register();
    public static final ItemEntry<Item> LASAGNA_NAPOLETANA_COOKED = item("lasagna_napoletana_cooked").texture("pasta/lasagna_napoletana_cooked").en("Baked Napoletana Lasagna in Baking Tray").cn("装有那不勒斯风味千层面的烤盘").register();
    public static final ItemEntry<Item> LASAGNA_PESTO             = item("lasagna_pesto").texture("pasta/lasagna_pesto").en("Lasagna al pesto").cn("青酱千层面").register();
    public static final ItemEntry<Item> LASAGNA_PESTO_RAW         = item("lasagna_pesto_raw").texture("pasta/lasagna_pesto_raw").en("Unbaked Pesto Lasagna in Baking Tray").cn("装有未烘烤青酱千层面的烤盘").register();
    public static final ItemEntry<Item> LASAGNA_PESTO_COOKED      = item("lasagna_pesto_cooked").texture("pasta/lasagna_pesto_cooked").en("Baked Pesto Lasagna in Baking Tray").cn("装有青酱千层面的烤盘").register();

    //pizza
    public static final ItemEntry<Item> PIZZA_CHEESE_RAW     = item("pizza_cheese_raw").texture("pizza/cheese_raw").en("Raw Cheese Pizza").cn("生芝士披萨").register();
    public static final ItemEntry<Item> PIZZA_CHEESE_SLICE   = item("pizza_cheese_slice").texture("pizza/cheese_slice").en("Cheese Pizza Slice").cn("芝士披萨片").register();
    public static final ItemEntry<Item> PIZZA_VEGGIE_RAW     = item("pizza_veggie_raw").texture("pizza/veggie_raw").en("Raw Olive and Mushroom Pizza").cn("生橄榄蘑菇披萨").register();
    public static final ItemEntry<Item> PIZZA_VEGGIE_SLICE   = item("pizza_veggie_slice").texture("pizza/veggie_slice").en("Olive and Mushroom Pizza Slice").cn("橄榄蘑菇披萨片").register();
    public static final ItemEntry<Item> PIZZA_MEAT_RAW       = item("pizza_meat_raw").texture("pizza/meat_raw").en("Raw Mince Meat Pizza").cn("生肉末披萨").register();
    public static final ItemEntry<Item> PIZZA_MEAT_SLICE     = item("pizza_meat_slice").texture("pizza/meat_slice").en("Mince Meat Pizza Slice").cn("肉末披萨片").register();

    //potato
    public static final ItemEntry<Item> POTATO_PEELED            = item("potato_peeled").texture("potato/peeled").en("Peeled Potato").cn("去皮马铃薯").register();
    public static final ItemEntry<Item> POTATO_MASHED            = item("potato_mashed").texture("potato/mashed").en("Mashed Potato").cn("土豆泥").register();
    public static final ItemEntry<Item> POTATO_STRIP             = item("potato_strip").texture("potato/strip").en("Potato Strip").cn("马铃薯条").register();
    public static final ItemEntry<Item> POTATO_STRIP_BLANCHED    = item("potato_strip_blanched").texture("potato/strip_blanched").en("Blanched Potato Strip").cn("过油马铃薯条").register();
    public static final ItemEntry<Item> POTATO_STRIP_FRIED       = item("potato_strip_fried").texture("potato/strip_fried").en("Fried Potato Strip").cn("炸马铃薯条").register();
    public static final ItemEntry<Item> POTATO_SLICE             = item("potato_slice").texture("potato/slice").en("Potato Slice").cn("马铃薯片").register();
    public static final ItemEntry<Item> POTATO_SLICE_FRIED       = item("potato_slice_fried").texture("potato/slice_fried").en("Fried Potato Slice").cn("炸马铃薯片").register();
    public static final ItemEntry<Item> POTATO_SLICE_BATCH_FRIED = item("potato_slice_batch_fried").texture("potato/slice_batch_fried").en("Batch-Fried Potato Slice").cn("分批油炸的马铃薯片").register();
    public static final ItemEntry<Item> POTATO_SLICE_OILY        = item("potato_slice_oily").texture("potato/slice_oily").en("Oily Potato Slice").cn("油腻马铃薯片").register();
    public static final ItemEntry<Item> POTATO_SLICE_HOT         = item("potato_slice_hot").texture("potato/slice_hot").en("Hot Potato Slice").cn("热马铃薯片").register();
    public static final ItemEntry<Item> POTATO_SLICE_REDUCED_FAT = item("potato_slice_reduced_fat").texture("potato/slice_reduced_fat").en("Reduced Fat Potato Chip").cn("减脂薯片").register();
    public static final ItemEntry<Item> POTATO_SLICE_NAQUADAH    = item("potato_slice_naquadah").texture("potato/slice_naquadah").en("Naquadah Potato Slice").cn("硅岩油炸薯片").register();
    public static final ItemEntry<Item> POTATO_STICK             = item("potato_stick").texture("potato/stick").en("Potato on a Stick").cn("马铃薯棒").register();
    public static final ItemEntry<ExComponentItem> POTATO_STICK_ROASTED     = ex("potato_stick_roasted").texture("potato/stick_roasted").en("Roasted Potato on a Stick").cn("烤马铃薯棒").attach(Foods.POTATO_STICK_ROASTED).register();
    public static final ItemEntry<ExComponentItem> FRENCH_FRIES             = ex("french_fries").texture("potato/french_fries").en("French Fries").cn("薯条").attach(Foods.FRENCH_FRIES).register();
    public static final ItemEntry<ExComponentItem> CHIPS_SYALS                = ex("chips_syals").texture("potato/chips_syals").en("Syals").cn("事乐薯片").attach(Foods.CHIPS_SYALS).register();
    public static final ItemEntry<ExComponentItem> CHIPS_BAG                  = ex("chips_bag").texture("potato/chips_bag").en("Bag O' Chips").cn("袋装薯片").attach(Foods.CHIPS_BAG).register();
    public static final ItemEntry<ExComponentItem> CHIPS_KETTLE               = ex("chips_kettle").texture("potato/chips_kettle").en("Kettle Chips").cn("手作薯片").attach(Foods.CHIPS_KETTLE).register();
    public static final ItemEntry<ExComponentItem> CHIPS_NAQUADAH             = ex("chips_naquadah").texture("potato/chips_naquadah").en("Naquadah Chips").cn("硅岩薯片").attach(Foods.CHIPS_NAQUADAH).register();
    public static final ItemEntry<ExComponentItem> CHIPS_REDUCED_FAT          = ex("chips_reduced_fat").texture("potato/chips_reduced_fat").en("Bay Salmon Reduced Fat Chips").cn("湾鲑牌减脂薯片").attach(Foods.CHIPS_REDUCED_FAT).register();
    public static final ItemEntry<Item> CHIPS_VINEGAR              = item("chips_vinegar").texture("potato/chips_vinegar").en("Vinegar Chips").cn("醋味薯片").register();

    //sandwich
    public static final ItemEntry<Item> SANDWICH_BACON        = item("sandwich_bacon").texture("sandwich/bacon").en("Bacon Sandwich").cn("培根三明治").register();
    public static final ItemEntry<Item> SANDWICH_BACON_LARGE  = item("sandwich_bacon_large").texture("sandwich/bacon_large").en("Large Bacon Sandwich").cn("大号培根三明治").register();
    public static final ItemEntry<Item> SANDWICH_CHEESE       = item("sandwich_cheese").texture("sandwich/cheese").en("Cheese Sandwich").cn("芝士三明治").register();
    public static final ItemEntry<Item> SANDWICH_CHEESE_LARGE = item("sandwich_cheese_large").texture("sandwich/cheese_large").en("Large Cheese Sandwich").cn("大号芝士三明治").register();
    public static final ItemEntry<Item> SANDWICH_STEAK        = item("sandwich_steak").texture("sandwich/steak").en("Steak Sandwich").cn("牛肉三明治").register();
    public static final ItemEntry<Item> SANDWICH_STEAK_LARGE  = item("sandwich_steak_large").texture("sandwich/steak_large").en("Large Steak Sandwich").cn("大号牛肉三明治").register();
    public static final ItemEntry<Item> SANDWICH_VEGGIE       = item("sandwich_veggie").texture("sandwich/veggie").en("Veggie Sandwich").cn("蔬菜三明治").register();
    public static final ItemEntry<Item> SANDWICH_VEGGIE_LARGE = item("sandwich_veggie_large").texture("sandwich/veggie_large").en("Large Veggie Sandwich").cn("大号蔬菜三明治").register();
    public static final ItemEntry<Item> SANDWICH_TOAST        = item("sandwich_toast").texture("sandwich/toast").en("Toast Sandwich").cn("吐司三明治").register();
    public static final ItemEntry<Item> SANDWICH_VIBRANT      = item("sandwich_vibrant").texture("sandwich/vibrant").en("Vibrant Sandwich").cn("Vibrant Sandwich").register();

    //seed
    public static final ItemEntry<Item> SEED_UNKNOWN       = item("seed_unknown").texture("seed/unknown").en("Undetermined GTMFO Seeds").cn("不明GTMFO种子").register();
    public static final ItemEntry<Item> SEED_ARTICHOKE     = item("seed_artichoke").texture("seed/artichoke").en("Artichoke Seeds").cn("洋蓟种子").register();
    public static final ItemEntry<Item> SEED_BASIL         = item("seed_basil").texture("seed/basil").en("Basil Seeds").cn("罗勒种子").register();
    public static final ItemEntry<Item> SEED_BEAN          = item("seed_bean").texture("seed/bean").en("Beans").cn("菜豆").register();
    public static final ItemEntry<Item> SEED_COFFEE        = item("seed_coffee").texture("seed/coffee").en("Coffee Seed").cn("咖啡种子").register();
    public static final ItemEntry<Item> SEED_COTTON        = item("seed_cotton").texture("seed/cotton").en("Cotton Seeds").cn("棉花种子").register();
    public static final ItemEntry<Item> SEED_CUCUMBER      = item("seed_cucumber").texture("seed/cucumber").en("Cucumber Seeds").cn("黄瓜种子").register();
    public static final ItemEntry<Item> SEED_EGGPLANT      = item("seed_eggplant").texture("seed/eggplant").en("Eggplant Seeds").cn("茄子种子").register();
    public static final ItemEntry<Item> SEED_GARLIC_PURPLE = item("seed_garlic_purple").texture("seed/garlic_purple").en("Purple Garlic Clove").cn("紫大蒜瓣").register();
    public static final ItemEntry<Item> SEED_GARLIC_WHITE  = item("seed_garlic_white").texture("seed/garlic_white").en("White Garlic Clove").cn("白大蒜瓣").register();
    public static final ItemEntry<Item> SEED_GRAPE         = item("seed_grape").texture("seed/grape").en("Grape Seeds").cn("葡萄种子").register();
    public static final ItemEntry<Item> SEED_HORSERADISH   = item("seed_horseradish").texture("seed/horseradish").en("Horseradish Seeds").cn("辣根种子").register();
    public static final ItemEntry<Item> SEED_ONION         = item("seed_onion").texture("seed/onion").en("Onion Seeds").cn("洋葱种子").register();
    public static final ItemEntry<Item> SEED_OREGANO       = item("seed_oregano").texture("seed/oregano").en("Oregano Seeds").cn("牛至种子").register();
    public static final ItemEntry<Item> SEED_PEA           = item("seed_pea").texture("seed/pea").en("Peas").cn("豌豆").register();
    public static final ItemEntry<Item> SEED_SOY           = item("seed_soy").texture("seed/soy").en("Soybean Seeds").cn("大豆种子").register();
    public static final ItemEntry<Item> SEED_TOMATO        = item("seed_tomato").texture("seed/tomato").en("Tomato Seeds").cn("番茄种子").register();
    public static final ItemEntry<Item> SEED_WHITE_GRAPE   = item("seed_white_grape").texture("seed/white_grape").en("White Grape Seeds").cn("白葡萄种子").register();

    //shape
    public static final ItemEntry<Item> SHAPE_PASTA_BLANK       = item("shape_pasta_blank").texture("shape/pasta/blank").en("Blank Pasta Extruder Shape").cn("空青铜模板").register();
    public static final ItemEntry<Item> SHAPE_PASTA_DITALINI    = item("shape_pasta_ditalini").texture("shape/pasta/ditalini").en("Ditalini Pasta Extruder Shape").cn("青铜模头（意式手指面）").register();
    public static final ItemEntry<Item> SHAPE_PASTA_LASAGNA     = item("shape_pasta_lasagna").texture("shape/pasta/lasagna").en("Lasagna Pasta Extruder Shape").cn("青铜模头（意式千层面）").register();
    public static final ItemEntry<Item> SHAPE_PASTA_RIGATONI    = item("shape_pasta_rigatoni").texture("shape/pasta/rigatoni").en("Rigatoni Pasta Extruder Shape").cn("青铜模头（意式粗通心粉）").register();
    public static final ItemEntry<Item> SHAPE_PASTA_SPAGHETTI   = item("shape_pasta_spaghetti").texture("shape/pasta/spaghetti").en("Spaghetti Pasta Extruder Shape").cn("青铜模头（意式直面）").register();
    public static final ItemEntry<Item> SHAPE_PASTA_TAGLIATELLE = item("shape_pasta_tagliatelle").texture("shape/pasta/tagliatelle").en("Tagliatelle Pasta Extruder Shape").cn("青铜模头（意式干面）").register();

    //slicer_blade
    public static final ItemEntry<Item> SLICER_BLADE_FLAT      = item("slicer_blade_flat").texture("slicer_blade/flat").en("Slicer Blade (Flat)").cn("切片机刀片（切片）").register();
    public static final ItemEntry<Item> SLICER_BLADE_STRIPES   = item("slicer_blade_stripes").texture("slicer_blade/stripes").en("Slicer Blade (Stripes)").cn("切片机刀片（切条）").register();
    public static final ItemEntry<Item> SLICER_BLADE_OCTAGONAL = item("slicer_blade_octagonal").texture("slicer_blade/octagonal").en("Slicer Blade (Eights)").cn("切片机刀片（八等分）").register();
    public static final ItemEntry<Item> SLICER_BLADE_PITTER    = item("slicer_blade_pitter").texture("slicer_blade/pitter").en("Slicer Blade (Pitter)").cn("切片机刀片（去核）").register();

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



    public static final ItemEntry<Item> MILK_CHOCOLATE     = item("milk_chocolate").texture("smore/milk_chocolate").en("Milk Chocolate").cn("牛奶巧克力").register();
    public static final ItemEntry<Item> MILK_CHOCOLATE_HOT = item("milk_chocolate_hot").texture("smore/milk_chocolate_hot").en("Hot Milk Chocolate").cn("热牛奶巧克力").register();
    public static final ItemEntry<Item> MARSHMALLOW_MATTER = item("marshmallow_matter").texture("smore/marshmallow_matter").en("Marshmallow Matter").cn("棉花软糖糖胶").register();

    public static final ItemEntry<Item> GRAHAM_CRACKER                 = item("graham_cracker").texture("smore/graham_cracker/graham_cracker").en("Graham Cracker").cn("全麦饼干").register();
    public static final ItemEntry<Item> GRAHAM_CRACKER_HOT             = item("graham_cracker_hot").texture("smore/graham_cracker/hot").en("Hot Graham Cracker").cn("热全麦饼干").register();
    public static final ItemEntry<Item> GRAHAM_CRACKER_UNGRADED        = item("graham_cracker_ungraded").texture("smore/graham_cracker/ungraded").en("Ungraded Graham Cracker").cn("未筛选全麦饼干").register();
    public static final ItemEntry<Item> GRAHAM_CRACKER_BROKEN          = item("graham_cracker_broken").texture("smore/graham_cracker/broken").en("Broken Graham Cracker").cn("断裂全麦饼干").register();
    public static final ItemEntry<Item> GRAHAM_CRACKER_DOUGH           = item("graham_cracker_dough").texture("smore/graham_cracker/dough").en("Graham Cracker Dough").cn("全麦饼干面团").register();
    public static final ItemEntry<Item> GRAHAM_CRACKER_DOUGH_HOT       = item("graham_cracker_dough_hot").texture("smore/graham_cracker/dough_hot").en("Hot Graham Cracker Dough").cn("热全麦饼干面团").register();
    public static final ItemEntry<Item> GRAHAM_CRACKER_DOUGH_CHUNK_HOT = item("graham_cracker_dough_chunk_hot").texture("smore/graham_cracker/dough_chunk_hot").en("Hot Graham Cracker Dough Chunk").cn("热全麦饼干坯").register();
    //sorbet
    public static final ItemEntry<ExComponentItem> SORBET         = ex("sorbet").texture("sorbet/plain").en("Plain Sorbet").cn("原味雪葩").attach(Foods.SORBET_PLAIN).register();
    public static final ItemEntry<ExComponentItem> SORBET_APPLE   = ex("sorbet_apple").texture("sorbet/apple").en("Apple Sorbet").cn("苹果雪葩").attach(Foods.SORBET_FRUIT).register();
    public static final ItemEntry<ExComponentItem> SORBET_APRICOT = ex("sorbet_apricot").texture("sorbet/apricot").en("Apricot Sorbet").cn("杏子雪葩").attach(Foods.SORBET_FRUIT).register();
    public static final ItemEntry<ExComponentItem> SORBET_CHORUS  = ex("sorbet_chorus").texture("sorbet/chorus").en("Chorus Sorbet").cn("紫颂果雪葩").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> SORBET_GRAPE   = ex("sorbet_grape").texture("sorbet/grape").en("Grape Sorbet").cn("葡萄雪葩").attach(Foods.SORBET_FRUIT).register();
    public static final ItemEntry<ExComponentItem> SORBET_LIME    = ex("sorbet_lime").texture("sorbet/lime").en("Lime Sorbet").cn("酸柠雪葩").attach(Foods.SORBET_FRUIT).register();
    public static final ItemEntry<ExComponentItem> SORBET_VIBRANT = ex("sorbet_vibrant").texture("sorbet/vibrant").en("Vibrant Sorbet").cn("Vibrant Sorbet").attach(Foods.EMPTY).register();

    //structural_mesh
    public static final ItemEntry<Item> APPLE_STRUCTURAL_MESH  = item("apple_structural_mesh").texture("structural_mesh/apple").en("Apple Structural Mesh").cn("苹果纤维骨架").register();
    public static final ItemEntry<Item> CARROT_STRUCTURAL_MESH = item("carrot_structural_mesh").texture("structural_mesh/carrot").en("Carrot Structural Mesh").cn("胡萝卜纤维骨架").register();

    //utility
    public static final ItemEntry<Item> KITCHEN_RECIPE = item("kitchen_recipe").texture("utility/kitchen_recipe").en("Kitchen Recipe").cn("厨房配方").register();
//    public static ItemEntry<ExComponentItem> TEST_ITEM;
//    public static ItemEntry<ExComponentItem> TEST_ITEM_2;


    //unsorted
    public static final ItemEntry<Item> ANIMAL_FAT          = item("animal_fat").en("Animal Fat").cn("动物脂肪").register();
    public static final ItemEntry<Item> BACON     = item("bacon").en("Bacon").cn("培根").register();
    public static final ItemEntry<Item> BACON_RAW = item("bacon_raw").en("Uncooked Bacon").cn("生培根").register();
    public static final ItemEntry<Item> BAKED_BEANS = item("baked_beans").en("Baked Beans").cn("焗豆").register();
    public static final ItemEntry<Item> BANANA_PEEL = item("banana_peel").en("Banana Peel").cn("香蕉皮").register();
    public static final ItemEntry<Item> BEANS_ON_TOAST = item("beans_on_toast").en("Beans on Toast").cn("焗豆吐司").register();
    public static final ItemEntry<Item> BEANS_WITH_SAUCE = item("beans_with_sauce").en("Beans with Sauce").cn("番茄酱豆").register();
    public static final ItemEntry<Item> BEEF_SLICE         = item("beef_slice").en("Beef Slice").cn("生牛肉片").register();
    public static final ItemEntry<Item> BEEF_SLICE_ROASTED = item("beef_slice_roasted").en("Roasted Beef Slice").cn("熟牛肉片").register();

    public static final ItemEntry<Item> BRICK_ADOBE = item("brick_adobe").en("Adobe Brick").cn("土坯砖").register();
    public static final ItemEntry<Item> BRICK_MUB   = item("brick_mud").en("Mud Brick").cn("泥砖").register();
    public static final ItemEntry<Item> CAKE_BOTTOM       = item("cake_bottom").en("Cake Bottom").cn("蛋糕底").register();
    public static final ItemEntry<Item> CAKE_BOTTOM_BAKED = item("cake_bottom_baked").en("Baked Cake Bottom").cn("烤蛋糕底").register();
    public static final ItemEntry<Item> CERAMIC_CLAY = item("ceramic_clay").en("Ceramic Clay").cn("瓷土").register();

    public static final ItemEntry<ExComponentItem> CHUM        = ex("chum").en("Chum").cn("海霸糊").attach(Foods.CHUM).register();
    public static final ItemEntry<ExComponentItem> CHUM_BUCKET = ex("chum_bucket").en("Chum Bucket Kebab Mix").cn("烤海霸拌桶").attach(Foods.EMPTY).register();
    public static final ItemEntry<ExComponentItem> CHUM_STICK  = ex("chum_stick").stack(16).en("Chum on a Stick").cn("海霸糊棒").attach(Foods.CHUM_STICK).register();

    public static final ItemEntry<Item> COFFEE_FILTER = item("coffee_filter").en("Coffee Filter").cn("咖啡滤纸").register();
    public static final ItemEntry<Item> EMERGENCY_RATIONS = item("emergency_rations").en("Emergency Rations").cn("应急配给").register();
    public static final ItemEntry<Item> FERMENTED_CHORUS     = item("fermented_chorus").en("Fermented Chorus").cn("发酵紫颂果").register();
    public static final ItemEntry<Item> FERMENTED_CHORUS_PIE = item("fermented_chorus_pie").en("Fermented Chorus Pie").cn("发酵紫颂果派").register();
    public static final ItemEntry<Item> FISH_AND_CHIPS = item("fish_and_chips").en("Fish'n'Chips").cn("炸鱼薯条").register();
    public static final ItemEntry<Item> FRIED_FISH     = item("fried_fish").en("Fried Fish").cn("炸鱼").register();
    public static final ItemEntry<Item> FULL_BREAKFAST = item("full_breakfast").en("Full Breakfast").cn("全英早餐").register();
    public static final ItemEntry<Item> GELATIN = item("gelatin").en("Gelatin").cn("明胶").register();

    public static final ItemEntry<Item> GUMMY_BEAR = item("gummy_bear").en("Gummy Bear").cn("小熊软糖").register();
    public static final ItemEntry<ExComponentItem> HOT_BEETROOT_SOUP = ex("hot_beetroot_soup").stack(1).en("Hot Beetroot Soup").cn("热甜菜汤").attach(Foods.HOT_BEETROOT_SOUP).register();
    public static final ItemEntry<ExComponentItem> HOT_MUSHROOM_STEW = ex("hot_mushroom_stew").stack(1).en("Hot Mushroom Stew").cn("热蘑菇煲").attach(Foods.HOT_MUSHROOM_STEW).register();
    public static final ItemEntry<ExComponentItem> HOT_RABBIT_STEW   = ex("hot_rabbit_stew").stack(1).en("Hot Rabbit Stew").cn("热兔肉煲").attach(Foods.HOT_RABBIT_STEW).register();
    public static final ItemEntry<Item> IV_BAG = item("iv_bag").en("IV Bag").cn("静脉注射(IV)袋").register();
    public static final ItemEntry<Item> MARSHMALLOW               = item("marshmallow").en("Marshmallow").cn("棉花软糖").register();
    public static final ItemEntry<Item> MARSHMALLOW_STICK         = item("marshmallow_stick").en("Marshmallow on a Stick").cn("棉花软糖串").register();
    public static final ItemEntry<Item> MARSHMALLOW_STICK_ROASTED = item("marshmallow_stick_roasted").en("Roasted Marshmallow").cn("烤棉花软糖").register();
    public static final ItemEntry<Item> MINCE_MEAT        = item("mince_meat").en("Mince Meat").cn("肉末").register();
    public static final ItemEntry<Item> MINCE_MEAT_COOKED = item("mince_meat_cooked").en("Cooked Mince Meat").cn("熟肉末").register();
    public static final ItemEntry<Item> MEAT_INGOT        = item("meat_ingot").en("Meat Ingot").cn("肉锭").register();
    public static final ItemEntry<Item> MEAT_INGOT_COOKED = item("meat_ingot_cooked").en("Cooked Meat Ingot").cn("熟肉锭").register();
    public static final ItemEntry<Item> MUSHY_PEAS = item("mushy_peas").en("Mushy Peas").cn("豌豆糊").register();
    public static final ItemEntry<Item> PIE_CRUST = item("pie_crust").en("Pie Crust").cn("馅饼皮").register();
    public static final ItemEntry<Item> RICE_COOKED = item("rice_cooked").en("Cooked Rice").cn("熟米饭").register();
    public static final ItemEntry<Item> ROTTEN_FISH = item("rotten_fish").en("Rotten Fish").cn("臭鱼").register();
    public static final ItemEntry<Item> ROTTEN_MEAT = item("rotten_meat").en("Rotten Meat").cn("臭肉").register();
    public static final ItemEntry<Item> SAUSAGE          = item("sausage").en("Sausage").cn("香肠").register();
    public static final ItemEntry<Item> SAUSAGE_RAW      = item("sausage_raw").en("Raw Sausage").cn("生香肠").register();
    public static final ItemEntry<Item> SAUSAGE_ROLL     = item("sausage_roll").en("Sausage Roll").cn("香肠卷").register();
    public static final ItemEntry<Item> SAUSAGE_ROLL_RAW = item("sausage_roll_raw").en("Uncooked Sausage Roll").cn("生香肠卷").register();
    public static final ItemEntry<Item> SCRAP_MEAT = item("scrap_meat").en("Scrap Meat").cn("废肉").register();
    public static final ItemEntry<Item> SEASONED_PORK = item("seasoned_pork").en("Seasoned Pork").cn("调味猪肉").register();
    public static final ItemEntry<Item> SHEPHERDS_PIE = item("shepherds_pie").en("Shepherd's Pie").cn("牧羊人派").register();
    public static final ItemEntry<Item> SPRINKLER = item("sprinkler").en("Sprinkler").cn("洒水器").register();

    public static void init() {
    }


    private static <T extends ComponentItem> NonNullConsumer<T> attach(IItemComponent... components) {
        return item -> item.attachComponents(components);
    }

    private static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, CNLangProvider> cn(String cnLang){
        return (ctx,prov)->prov.add(ctx.get().getDescriptionId(),cnLang);
    }

    private static <T extends Item> NonNullBiConsumer<DataGenContext<Item, T>, RegistrateItemModelProvider> itemModel(String path){
        return (ctx,prov)->prov.generated(ctx::getEntry,prov.modLoc("item/"+path));
    }

//    private static ItemBuilder item(String id){
//        return new ItemBuilder(id);
//    }

    private static ItemBuilder<Item,?> item(String id){
        return ItemBuilder.createItemBuilder(id);
    }

    private static ExComponentItemBuilder<ExComponentItem, ?> ex(String id){
        return ExComponentItemBuilder.createExComponentItemBuilder(id);
    }

    private static ItemEntry<ExComponentItem> smore(int number, String enLang, String cnLang, GTMFOFoodStats foodStats, boolean blockModel){
        return REGISTRATE.item("smore_"+number,ExComponentItem::create)
                .lang(enLang)
                //.properties(p->p.stacksTo(64/number))
                .onRegister(attach(foodStats))
                .setData(GTMFOProviderTypes.CNLANG, cn(cnLang))
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
                .setData(GTMFOProviderTypes.CNLANG, cn(cnLang))
                .model((ctx,prov)->prov.generated(ctx::getEntry,prov.modLoc("item/"+path)))
                .register();
    }
}
