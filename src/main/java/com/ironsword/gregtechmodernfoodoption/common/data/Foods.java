package com.ironsword.gregtechmodernfoodoption.common.data;

import com.ironsword.gregtechmodernfoodoption.api.item.component.GTMFOFoodStats;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public class Foods {

    private static GTMFOFoodStats    food(int foodLevel,float saturation,float dairy, float fruit, float grain, float protein, float vegetable){
        return new GTMFOFoodStats.Builder(foodLevel,saturation,dairy,fruit,grain,protein,vegetable).build();
    }

    private static GTMFOFoodStats    food(int foodLevel,float saturation,int eatingDuration,float dairy, float fruit, float grain, float protein, float vegetable){
        return new GTMFOFoodStats.Builder(foodLevel,saturation,eatingDuration,dairy,fruit,grain,protein,vegetable).build();
    }

    private static GTMFOFoodStats.Builder builder(int foodLevel,float saturation, float dairy, float fruit, float grain, float protein, float vegetable){
        return new GTMFOFoodStats.Builder(foodLevel,saturation,dairy,fruit,grain,protein,vegetable);
    }

    private static Supplier<MobEffectInstance> effect(MobEffect mobEffect,int duration){
        return ()->new MobEffectInstance(mobEffect,duration,0);
    }

    private static Supplier<MobEffectInstance> effect(MobEffect mobEffect,int duration,int amplifier){
        return ()->new MobEffectInstance(mobEffect,duration,amplifier);
    }

    public static final GTMFOFoodStats EMPTY = food(0,0f,0,0,0,0,0);

    //apple_candy
    public static final GTMFOFoodStats APPLE_SLICE           =    food( 1    , 0.1f  , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats APPLE_TUNGSTENSTEEL   = builder( 3    , 1f    , 0     , 1f    , 0     , 0     , 0     ).eatDuration(80).effect(MobEffects.MOVEMENT_SPEED,1200,2,1f).effect(MobEffects.DAMAGE_RESISTANCE,1200,3,1f).effect(MobEffects.NIGHT_VISION,3600,2,0.6f).effect(MobEffects.HARM,1,1,1f).build();
    public static final GTMFOFoodStats APPLE_HARD_CANDY      = builder( 1    , 1f    , 0     , 0.5f  , 0     , 0     , 0     ).eatDuration(24).effect(MobEffects.REGENERATION,1200,0,0.5f).build();

    //berry
    public static final GTMFOFoodStats BERRY                 =    food( 1    , 0.5f  , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ELDERBERRY            = builder( 1    , 0.5f  , 0     , 1f    , 0     , 0     , 0     ).effect(MobEffects.CONFUSION,400,0,0.05f).effect(MobEffects.POISON,200,0,0.10f).build();
    public static final GTMFOFoodStats BERRY_MEDLEY          =    food( 5    , 0.5f  , 0     , 1f    , 0     , 0     , 0     );

    //bread
    public static final GTMFOFoodStats BUN                   =    food( 1    , 1f    , 25    , 0     , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats BUN_PRESLICED         =    food( 0    , 0     , 20    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats BREAD_PRESLICED       =    food( 1    , 1f    , 20    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats BAGUETTE              = builder( 2    , 1f    , 0     , 0     , 1f    , 0     , 0     ).eatDuration(40).effect(MobEffects.DIG_SPEED,1200,0,0.5f).build();
    public static final GTMFOFoodStats BAGUETTE_PRESLICED    =    food( 1    , 1f    , 20    , 0     , 0     , 0.5f  , 0     , 0     );

    //burger
    public static final GTMFOFoodStats BURGER_VEGGIE         =    food( 4    , 0.6f  , 32    , 0     , 0     , 1f    , 0     , 1f    );
    public static final GTMFOFoodStats BURGER_CHEESE         =    food( 4    , 0.6f  , 32    , 1f    , 0     , 1f    , 0     , 0     );
    //public static final GTMFOFoodStats BURGER_BACON          =    food( 4    , 0.7f  , 32    , 0     , 0     , 1f    , 1f    , 0     );
    public static final GTMFOFoodStats BURGER_STEAK          =    food( 4    , 0.7f  , 32    , 0     , 0     , 1f    , 1f    , 0     );
    public static final GTMFOFoodStats BURGER_CHUM           = builder( 4    , 1f    , 0     , 0     , 1f    , 0.5f  , 0     ).effect(MobEffects.CONFUSION,500,10,0.01f).build();

    //caplet
    public static final GTMFOFoodStats CAPLET_GEL            = builder( 0    , 1f    , 0     , 0     , 0     , 0     , 0     ).eatDuration(1).build();
    public static final GTMFOFoodStats CAPLET_PARACETAMOL    = builder( 0    , 1f    , 0     , 0     , 0     , 0     , 0     ).eatDuration(1).effect(MobEffects.REGENERATION,400,0,1f).build();
    public static final GTMFOFoodStats CAPLET_PLUTONIUM_241  = builder( 0    , 1f    , 0     , 0     , 0     , 0     , 0     ).eatDuration(1).effect(MobEffects.POISON,7000,0,1f).build();
    //public static final GTMFOFoodStats CAPLET_CHORUS         =    food( 0    , 1f    , 1     , 0     , 0     , 0     , 0     , 0     );
    //public static final GTMFOFoodStats CAPLET_VIBRANT        =    food( 0    , 1f    , 1     , 0     , 0     , 0     , 0     , 0     );

    //cheese
    public static final GTMFOFoodStats CHEDDAR_SLICE         =    food( 2    , 0.2f  , 20    , 2f    , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats MOZZARELLA_BALL       =    food( 3    , 0.6f  , 32    , 2f    , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats GORGONZOLA_TRIANGULAR =    food( 3    , 0.5f  , 32    , 2f    , 0     , 0     , 0     , 0     );

    //coffee
    public static final GTMFOFoodStats COFFEE                = builder( 8    , 0.4f  , 0     , 0.5f  , 0.5f  , 0.5f  , 0     ).effect(MobEffects.REGENERATION,60,1,1f).effect(MobEffects.MOVEMENT_SPEED,1800,2,1f).item(GTMFOItems.CUP_EMPTY::asStack).build();
    public static final GTMFOFoodStats COFFEE_ENERGIZING     = builder( 8    , 0.6f  , 0     , 0.5f  , 1f    , 0.5f  , 0     ).effect(MobEffects.REGENERATION,200,3,1f).effect(MobEffects.MOVEMENT_SPEED,2400,3,1f).effect(MobEffects.DAMAGE_BOOST,500,1,1f).effect(MobEffects.DAMAGE_RESISTANCE,500,1,1f).item(GTMFOItems.CUP_EMPTY::asStack).build();

    //corn
    //public static final GTMFOFoodStats POPCORN_BAG           = builder( 5    , 0.4f  , 0     , 0     , 0.5f  , 0     , 0     ).alwaysEat().effect().item(GTMFOItems.PAPER_BAG::asStack).build();

    //crop
    public static final GTMFOFoodStats CARROT_SLICE          =    food( 1    , 0     , 32    , 0     , 0     , 0     , 0     , 0.75f );
    public static final GTMFOFoodStats CUCUMBER              =    food( 2    , 0.5f  , 64    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats CUCUMBER_SLICE        =    food( 1    , 0     , 32    , 0     , 0     , 0     , 0     , 0.75f );
    public static final GTMFOFoodStats EGGPLANT_SLICE        =    food( 1    , 0     , 32    , 0     , 0     , 0     , 0     , 0.75f );
    public static final GTMFOFoodStats MUSHROOM_SLICE        =    food( 1    , 1f    , 32    , 0     , 0     , 0     , 0.5f  , 1f    );
    public static final GTMFOFoodStats OLIVE                 =    food( 2    , 0.5f  , 64    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats OLIVE_SLICE           =    food( 1    , 1f    , 32    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats ONION                 =    food( 3    , 0.33f , 128   , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats ONION_SLICE           =    food( 1    , 0     , 32    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats TOMATO                =    food( 3    , 0.5f  , 72    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats TOMATO_SLICE          =    food( 1    , 0     , 32    , 0     , 0.75f , 0     , 0     , 0     );

    //potato
    public static final GTMFOFoodStats CHIPS_SYALS           = builder( 1    , 0.25f , 0     , 0     , 0.5f  , 0     , 0     ).effect(MobEffects.LEVITATION,300,1,1f).item(GTMFOItems.CHIPS_BAG_EMPTY::asStack).build();
    public static final GTMFOFoodStats CHIPS_BAG             = builder( 2    , 0.5f  , 0     , 0     , 0.5f  , 0     , 0     ).effect(MobEffects.DIG_SPEED,600,1,1f).item(GTMFOItems.CHIPS_BAG_EMPTY::asStack).build();
    public static final GTMFOFoodStats CHIPS_KETTLE          = builder( 3    , 0.5f  , 0     , 0     , 1f    , 0     , 0     ).effect(MobEffects.DIG_SPEED,900,1,1f).item(GTMFOItems.CHIPS_BAG_EMPTY::asStack).build();
    public static final GTMFOFoodStats CHIPS_REDUCED_FAT     = builder( 2    , 1.5f  , 0     , 0     , 1.5f  , 0     , 0     ).eatDuration(20).effect(MobEffects.DIG_SPEED,1200,1,1f).effect(MobEffects.DIG_SPEED,1200,2,0.5f).item(GTMFOItems.CHIPS_BAG_EMPTY::asStack).build();
    public static final GTMFOFoodStats CHIPS_NAQUADAH        = builder( 2    , 0.5f  , 0     , 0     , 1f    , 0     , 1f    ).alwaysEat().effect(MobEffects.BLINDNESS,500,0,1f).item(GTMFOItems.CHIPS_BAG_EMPTY::asStack).build();
    public static final GTMFOFoodStats FRENCH_FRIES          = builder( 3    , 0     , 0     , 0     , 1f    , 0     , 0     ).eatDuration(20).effect(MobEffects.DAMAGE_BOOST,1200,1,1f).item(GTMFOItems.PAPER_BAG_USED::asStack).build();
    public static final GTMFOFoodStats POTATO_STICK_ROASTED  = builder( 3    , 0.8f  , 0     , 0     , 1f    , 0     , 0     ).eatDuration(12).item(Items.STICK::getDefaultInstance).build();



    public static final GTMFOFoodStats PORCHETTA             =    food( 7    , 0.7f  , 50    , 0     , 0     , 0     , 0.5f  , 0.1f  );

    //public static final GTMFOFoodStats MINERAL_WATER         =    food( 0    , 0     , 32    , 0     , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats SPARKLING_WATER       = builder( 1    , 1f    , 0     , 0     , 0     , 0     , 0     ).drink().effect(MobEffects.MOVEMENT_SPEED,600,1,1f).item(GTMFOItems.PLASTIC_BOTTLE::asStack).build();
    public static final GTMFOFoodStats LEMON                 =    food( 1    , 0.5f  , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats LIME                  =    food( 1    , 0.5f  , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ETIRPS                = builder( 0    , 0     , 0     , 0.5f  , 0     , 0     , 0     ).drink().alwaysEat().effect(MobEffects.MOVEMENT_SPEED,1200,2,1f).build();
    public static final GTMFOFoodStats BACON                 =    food( 2    , 0.8f  , 24    , 0     , 0     , 0     , 1f    , 0     );

    public static final GTMFOFoodStats CAKE_BOTTOM           = builder( 2    , 0.5f  , 0     , 0     , 0.5f  , 0     , 0     ).eatDuration(60).effect(MobEffects.POISON,200,1,0.2f).build();
    public static final GTMFOFoodStats CAKE_BOTTOM_BAKED     =    food( 3    , 0.5f  , 60    , 0     , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats PIZZA_CHEESE          = builder( 10   , 0.8f  , 1f    , 0     , 1f    , 0     , 1f    ).eatDuration(50).effect(MobEffects.DIG_SPEED,2000,2,1f).build();
    //public static final GTMFOFoodStats PIZZA_VEGGIE          = builder( 10   , 0.7f  , 0     , 0     , 1f    , 0     , 2f    ).eatDuration(50).build();
    public static final GTMFOFoodStats PIZZA_MEAT            = builder( 11   , 0.8f  , 0     , 0     , 1f    , 1f    , 1f    ).eatDuration(50).effect(MobEffects.DAMAGE_BOOST,2000,2,1f).build();
    public static final GTMFOFoodStats SANDWICH_VEGGIE       =    food( 6    , 0.6f  , 40    , 0     , 0     , 1f    , 0     , 1f    );
    public static final GTMFOFoodStats SANDWICH_CHEESE       =    food( 6    , 0.6f  , 40    , 1f    , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats SANDWICH_BACON        =    food( 6    , 0.7f  , 40    , 0     , 0     , 1f    , 1f    , 0     );
    public static final GTMFOFoodStats SANDWICH_STEAK        =    food( 7    , 0.7f  , 40    , 0     , 0     , 1f    , 1f    , 0     );
    public static final GTMFOFoodStats SANDWICH_TOAST        =    food( 6    , 0.5f  , 32    , 0     , 0     , 1.5f  , 0     , 0     );
    public static final GTMFOFoodStats SANDWICH_VEGGIE_LARGE =    food( 9    , 0.6f  , 60    , 0     , 0     , 1f    , 0     , 2f    );
    public static final GTMFOFoodStats SANDWICH_CHEESE_LARGE =    food( 11   , 0.6f  , 60    , 2f    , 0     , 1f    , 0     , 0     );
    //public static final GTMFOFoodStats SANDWICH_BACON_LARGE  =    food( 10   , 0.7f  , 60    , 0     , 0     , 1f    , 2f    , 0     );
    public static final GTMFOFoodStats SANDWICH_STEAK_LARGE  =    food( 13   , 0.7f  , 60    , 0     , 0     , 1f    , 2f    , 0     );

    public static final GTMFOFoodStats ROTTEN_MEAT           = builder( 1    , 0     , 0     , 0     , 0     , 0.5f  , 0     ).alwaysEat().eatDuration(100).effect(MobEffects.POISON,500,1,1f).build();
    public static final GTMFOFoodStats CHUM                  = builder( 3    , 0     , 0     , 0     , 0     , 0.5f  , 0     ).alwaysEat().effect(MobEffects.CONFUSION,500,10,0.01f).build();
    public static final GTMFOFoodStats CHUM_STICK            = builder( 3    , 0     , 0     , 0     , 0     , 0.75f , 0     ).eatDuration(16).alwaysEat().effect(MobEffects.CONFUSION,500,10,0.01f).item(Items.STICK::getDefaultInstance).build();
    public static final GTMFOFoodStats BANANA                =    food( 2    , 1f    , 60    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ORANGE                =    food( 2    , 1f    , 50    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats GRAPES                =    food( 1    , 1f    , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats WHITE_GRAPES          =    food( 1    , 1f    , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats MANGO                 =    food( 2    , 1f    , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats APRICOT               =    food( 2    , 1f    , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats BANANA_PEELED         =    food( 2    , 1f    , 12    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats VODKA                 = builder( 2    , 0     , 0     , 0     , 0.5f  , 0     , 0     ).drink().effect(MobEffects.CONFUSION,500,1,0.4f).item(Items.GLASS_BOTTLE::getDefaultInstance).build();
    public static final GTMFOFoodStats LENINADE              = builder( 3    , 1f    , 0     , 1f    , 0.5f  , 0     , 0     ).drink().effect(MobEffects.CONFUSION,2000,2,0.3f).effect(MobEffects.MOVEMENT_SPEED,2000,2,1f).item(Items.GLASS_BOTTLE::getDefaultInstance).build();
    public static final GTMFOFoodStats HOT_MUSHROOM_STEW     = builder( 8    , 1f    , 0.5f  , 0     , 0.5f  , 0.5f  , 1f    ).eatDuration(60).item(Items.BOWL::getDefaultInstance).build();
    public static final GTMFOFoodStats HOT_BEETROOT_SOUP     = builder( 7    , 1f    , 0     , 0     , 0.5f  , 0     , 1.5f  ).eatDuration(60).item(Items.BOWL::getDefaultInstance).build();
    public static final GTMFOFoodStats HOT_RABBIT_STEW       = builder( 9    , 0.9f  , 0     , 0     , 1f    , 1.5f  , 1f    ).eatDuration(60).item(Items.BOWL::getDefaultInstance).build();
    public static final GTMFOFoodStats KEBAB_KUBIDEH         = builder( 6    , 0.8f  , 0     , 0     , 0.5f  , 1f    , 0.75f ).eatDuration(12).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_BARG            = builder( 6    , 0.5f  , 0     , 0.25f , 0.5f  , 1f    , 0.5f  ).eatDuration(12).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_SOLTANI         = builder( 16   , 1.1f  , 0     , 1f    , 1f    , 1.5f  , 1f    ).eatDuration(12).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_ONION           = builder( 5    , 0.3f  , 0     , 0     , 0     , 0     , 1.25f ).eatDuration(12).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_TOMATO          = builder( 5    , 0.3f  , 0     , 1.25f , 0     , 0     , 0     ).eatDuration(12).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_CARROT          = builder( 4    , 0.5f  , 0     , 0     , 0     , 0     , 1.25f ).eatDuration(12).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_FAT             = builder( 4    , 0.3f  , 0     , 0     , 0     , 0.5f  , 0     ).eatDuration(12).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_MEAT            = builder( 3    , 0.6f  , 0     , 0     , 0.25f , 1f    , 0     ).eatDuration(12).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_CHUM            = builder( 6    , 0.3f  , 0     , 0     , 0.5f  , 0.5f  , 0     ).eatDuration(12).alwaysEat().effect(MobEffects.CONFUSION,100,10,0.1f).item(GTMFOItems.SKEWER::asStack).build();
    public static final GTMFOFoodStats KEBAB_CHUM_BUCKET     = builder( 16   , 2f    , 0     , 1f    , 1.5f  , 1.5f  , 1f    ).eatDuration(60).alwaysEat().effect(MobEffects.CONFUSION,1000,10,0.5f).effect(MobEffects.UNLUCK,1000,11,0.5f).effect(MobEffects.MOVEMENT_SPEED,1000,3,0.5f).effect(MobEffects.HEALTH_BOOST,1000,3,0.5f).item(Items.BUCKET::getDefaultInstance).build();


    public static final GTMFOFoodStats JUICE                 = builder( 3    , 0.2f  , 0     , 1f    , 0     , 0     , 0     ).alwaysEat().drink().effect(MobEffects.MOVEMENT_SPEED,500,1,0.45f).item(Items.GLASS_BOTTLE::getDefaultInstance).build();
    public static final GTMFOFoodStats ICE_CREAM_PLAIN       = builder( 4    , 0.25f , 1f    , 0     , 0     , 0     , 0     ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_CHUM        = builder( 5    , 0.33f , 1f    , 0     , 0     , 1f    , 0     ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_BANANA      = builder( 6    , 0.33f , 1f    , 1f    , 0     , 0     , 0     ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_BACON       = builder( 6    , 0.33f , 1f    , 0     , 0     , 1f    , 0     ).alwaysEat().build();
    //public static final GTMFOFoodStats ICE_CREAM_VANILLA     = builder( 9    , 0.25f , 1f    , 0     , 0     , 0     , 0.25f ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_BEAR        = builder( 7    , 0.33f , 1f    , 0     , 0     , 1f    , 0     ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_MELON       = builder( 5    , 0.33f , 1f    , 1f    , 0     , 0     , 0     ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_CHOCOLATE   = builder( 9    , 0.25f , 1f    , 0     , 0     , 0.25f , 0.25f ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_LEMON       = builder( 6    , 0.33f , 1f    , 1f    , 0     , 0     , 0     ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_CHIP        = builder( 8    , 0.33f , 1f    , 0     , 0.5f  , 0     , 0     ).alwaysEat().build();
    public static final GTMFOFoodStats ICE_CREAM_RAINBOW     = builder( 6    , 0.33f , 1.25f , 0.25f , 0     , 0     , 0.25f ).alwaysEat().effect(MobEffects.NIGHT_VISION,2000,0,0.5f).build();
    public static final GTMFOFoodStats MILK_CHOCOLATE        =    food( 4    , 1.25f , 32    , 1f    , 0     , 0     , 0     , 0.5f  );
    public static final GTMFOFoodStats GRAHAM_CRACKER        =    food( 1    , 1f    , 32    , 0     , 0     , 1.5f  , 0.25f , 0     );
    public static final GTMFOFoodStats SMORE_1               =    food( 8    , 1.5f  , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_2               =    food( 20   , 3.8f  , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_4               =    food( 44,8.61363636364f, 32, 0.5f  , 0     , 1f    , 0.5f  , 0     );

    // TODO:smore_8 to smogus_4 are wip
    public static final GTMFOFoodStats SMORE_8               =    food( 92   , 18.2f , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_16              =    food( 188  , 37.4f , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_32              =    food( 380  , 75.8f , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_64              =    food( 764  , 152.6f, 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMOGUS                =    food( 1532 , 306.2f, 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMOGUS_2              =    food( 3068 , 613.4f, 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMOGUS_4              =    food( 6140 ,1227.8f, 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );

    public static final GTMFOFoodStats MARSHMALLOW           =    food( 1    , 1f    , 32    , 0     , 0     , 0.5f  , 0.5f  , 0     );

    public static final GTMFOFoodStats MUSHY_PEAS            =    food( 3    , 1f    , 32    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats BREAD_SLICE           =    food( 1    , 0.5f  , 32    , 0     , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats TOAST                 =    food( 2    , 0.5f  , 32    , 0     , 0     , 1.5f  , 0     , 0     );
    public static final GTMFOFoodStats FISH_AND_CHIPS        =    food( 7    , 0.6f  , 32    , 0     , 0     , 1f    , 1f    , 0.25f );
    public static final GTMFOFoodStats FULL_BREAKFAST        =    food( 10   , 1.2f  , 32    , 0     , 1f    , 1f    , 1.5f  , 1f    );
    public static final GTMFOFoodStats SHEPHERDS_PIE         =    food( 9    , 1f    , 32    , 0     , 0     , 1f    , 1f    , 1f    );
    public static final GTMFOFoodStats SAUSAGE_ROLL          = builder( 7    , 0.7f  , 0     , 0     , 0.75f , 1f    , 0     ).effect(MobEffects.ABSORPTION,1000,0,0.5f).build();
    public static final GTMFOFoodStats BAKED_BEANS           =    food( 4    , 1f    , 32    , 0     , 0.5f  , 0     , 0.5f  , 0     );
    public static final GTMFOFoodStats BEANS_ON_TOAST        = builder( 7    , 0.8f  , 0     , 0.25f , 0.75f , 0.5f  , 0     ).effect(MobEffects.SATURATION,10,0,0.2f).build();
    public static final GTMFOFoodStats FRIED_FISH            =    food( 4    , 0.3f  , 32    , 0     , 0     , 0.5f  , 1f    , 0     );
    public static final GTMFOFoodStats BEER                  = builder( 2    , 0.5f  , 0     , 0     , 0.5f  , 0     , 0     ).drink().alwaysEat().effect(MobEffects.CONFUSION,500,0,0.4f).item(Items.GLASS_BOTTLE::getDefaultInstance).build();
    public static final GTMFOFoodStats SAUSAGE               =    food( 4    , 0.7f  , 32    , 0     , 0     , 0.25f , 1f    , 0     );
    public static final GTMFOFoodStats NILK                  = builder( 6    , 4f    , 3f    , 0     , 0     , 1f    , 0     ).drink().alwaysEat().effect(MobEffects.CONFUSION,1000,0,0.8f).effect(MobEffects.REGENERATION,200,2,0.6f).item(Items.GLASS_BOTTLE::getDefaultInstance).build();

    //public static final GTMFOFoodStats BRUSCHETTA            =    food( 6    , 0.5f  , 32    , 0     , 1f    , 1f    , 0.5f  , 1f    );
    //public static final GTMFOFoodStats CAPONATA              =    food( 6    , 0.9f  , 32    , 0     , 0     , 0     , 0     , 2f    );
    public static final GTMFOFoodStats CARBONARA             = builder( 9    , 0.8f  , 0.5f  , 0     , 1f    , 1f    , 0     ).effect(MobEffects.HEALTH_BOOST,2000,0,0.75f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats CARCIOFI_ALLA_ROMANA  = builder( 8    , 1.3f  , 0     , 0     , 0     , 0.5f  , 1.5f  ).effect(MobEffects.DAMAGE_BOOST,2000,1,0.95f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats FETTUCCINE_ALFREDO    = builder( 8    , 0.4f  , 0.75f , 0     , 1f    , 0.5f  , 0     ).eatDuration(20).effect(MobEffects.DAMAGE_RESISTANCE,2000,1,0.8f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats PARMIGIANA            = builder( 8    , 1.1f  , 1f    , 0.5f  , 0     , 0.25f , 1f    ).effect(MobEffects.REGENERATION,500,0,0.75f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats PASTA_E_FAGIOLI       = builder( 4    , 2.5f  , 0     , 0     , 1f    , 1.5f  , 1.5f  ).effect(MobEffects.DIG_SPEED,6000,2,0.75f).item(GTMFOItems.CERAMIC_BOWL_DIRTY::asStack).build();
    public static final GTMFOFoodStats PASTA_ALLA_NORMA      = builder( 12   , 0.7f  , 0     , 1f    , 1f    , 0     , 1.25f ).eatDuration(128).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    //public static final GTMFOFoodStats PASTA_AL_POMODORO     =    food( 5    , 0.5f  , 32    , 0     , 1.25f , 1f    , 0     , 0.75f );
    public static final GTMFOFoodStats POLENTA               = builder( 6    , 0.4f  , 0     , 0.75f , 0.75f , 0.75f , 0     ).effect(MobEffects.SATURATION,20,0,0.5f).item(GTMFOItems.CERAMIC_BOWL_DIRTY::asStack).build();
    public static final GTMFOFoodStats RAFANATA              = builder( 7    , 1f    , 0     , 0     , 1f    , 0.5f  , 0.75f ).effect(MobEffects.JUMP,1000,0,0.8f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats RISOTTO               = builder( 10   , 0.8f  , 1f    , 0.25f , 1f    , 0.75f , 0.75f ).effect(MobEffects.MOVEMENT_SPEED,10000,1,1f).item(GTMFOItems.CERAMIC_BOWL_DIRTY::asStack).build();
    public static final GTMFOFoodStats SPAGHETTI_ALLASSASSINA= builder( 6    , 0.8f  , 0     , 0.75f , 1f    , 0     , 0     ).effect(MobEffects.DAMAGE_BOOST,60,10,0.6f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats TAGLIATELLE_AL_RAGU   = builder( 14   , 0.7f  , 0.75f , 0.5f  , 0     , 1.25f , 1f    ).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats TORTELLINI_IN_BRODO   = builder( 10   , 0.5f  , 0     , 0     , 0     , 1.75f , 1.75f ).item(GTMFOItems.CERAMIC_BOWL_DIRTY::asStack).build();
    //public static final GTMFOFoodStats VITELLO_TONNATO       =    food( 10   , 1f    , 32    , 0     , 0     , 0     , 2.5f  , 1.5f  );
    public static final GTMFOFoodStats LASAGNA_CHUM          = builder( 9    , 0.7f  , 0.5f  , 0.5f  , 1f    , 0.5f  , 0     ).eatDuration(64).effect(MobEffects.LUCK,6000,0,0.8f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats LASAGNA_NAPOLETANA    = builder( 11   , 0.7f  , 0.5f  , 0.75f , 1f    , 1f    , 0.25f ).eatDuration(64).effect(MobEffects.NIGHT_VISION,6000,0,0.9f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    public static final GTMFOFoodStats LASAGNA_PESTO         = builder( 15   , 0.7f  , 1f    , 0     , 1f    , 1f    , 0.25f ).eatDuration(64).effect(MobEffects.FIRE_RESISTANCE,6000,0,1f).item(GTMFOItems.CERAMIC_PLATE_DIRTY::asStack).build();
    //public static final GTMFOFoodStats PASTA_ALLAMOGUS       =    food( 5    , 0.1f  , 32    , 0     , 0.75f , 1f    , 0     , 0.5f  );
    public static final GTMFOFoodStats PORCHETTA_SLICE       = builder( 2    , 0.7f  , 0     , 0     , 0     , 1f    , 0.25f ).eatDuration(5).build();
    public static final GTMFOFoodStats WHITE_WINE            = builder( 6    , 0.7f  , 0     , 0     , 0     , 0     , 0     ).drink().alwaysEat().eatDuration(96).effect(MobEffects.CONFUSION,600,0,0.4f).effect(MobEffects.ABSORPTION,1200,1,0.6f).item(Items.GLASS_BOTTLE::getDefaultInstance).build();
    public static final GTMFOFoodStats RED_WINE              = builder( 4    , 0.7f  , 0     , 0     , 0     , 0     , 0     ).drink().alwaysEat().eatDuration(96).effect(MobEffects.CONFUSION,600,0,0.4f).effect(MobEffects.ABSORPTION,1200,1,0.6f).item(Items.GLASS_BOTTLE::getDefaultInstance).build();
    public static final GTMFOFoodStats EMERGENCY_RATIONS     = builder( 5    , 1.0f  , 0     , 0.5f  , 0     , 1f    , 0.5f  ).alwaysEat().eatDuration(60).effect(MobEffects.CONFUSION,400,0,0.1f).build();

    public static final GTMFOFoodStats ETIRPS_CRANBERRY      = builder( 3    , 0.3f  , 0     , 0.5f  , 0     , 0     , 0     ).drink().alwaysEat().effect(MobEffects.MOVEMENT_SPEED,2400,2,1f).effect(MobEffects.REGENERATION,200,1,0.8f).item(GTMFOItems.PLASTIC_BOTTLE::asStack).build();
    public static final GTMFOFoodStats PELMENI               =    food( 5    , 0.5f  , 32    , 0     , 0     , 1f    , 1f    , 0.125f);
    public static final GTMFOFoodStats PELMENI_SEASONED      =    food( 7    , 1f    , 24    , 0.5f  , 0     , 1f    , 1f    , 1f    );
    public static final GTMFOFoodStats ANTAF                 = builder( 5    , 0.5f  , 0     , 0.5f  , 0     , 0     , 0     ).drink().alwaysEat().item(GTMFOItems.PLASTIC_BOTTLE::asStack).build();
    public static final GTMFOFoodStats SORBET_PLAIN          = builder( 0    , 0     , 0     , 0     , 0     , 0     , 0     ).alwaysEat().eatDuration(12).build();
    public static final GTMFOFoodStats SORBET_FRUIT          = builder( 4    , 0.5f  , 0     , 1f    , 0     , 0     , 0     ).alwaysEat().eatDuration(12).build();
    //public static final GTMFOFoodStats SORBET_CHORUS         = builder( 4    , 0.5f  , 0     , 0     , 0     , 0     , 1f    ).alwaysEat().eatDuration(12).build();
    //public static final GTMFOFoodStats SORBET_VIBRANT        =    food( 0    , 0     , 12    , 0     , 2f    , 0     , 0     , 2f    );
//    public static final GTMFOFoodStats FERMENTED_CHORUS      =    food( 2    , 0.5f  , 60    , 0     , 0     , 0     , 0     , 2f    );
//    public static final GTMFOFoodStats FERMENTED_CHORUS_PIE  =    food( 6    , 1f    , 32    , 0     , 0     , 2f    , 0     , 2f    );


    //public static final GTMFOFoodStats SANDWICH_VIBRANT      =    food( 7    , 0.8f  , 40    , 0     , 1f    , 1f    , 1f    , 0     );





    public static void init(){}


}











