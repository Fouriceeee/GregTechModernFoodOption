package com.ironsword.gregtechmodernfoodoption.common.data;

import com.ironsword.gregtechmodernfoodoption.api.item.component.GTMFOFoodStats;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

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
    public static final GTMFOFoodStats APPLE_HARD_CANDY      = builder( 1    , 1f    , 0     , 0.5f  , 0     , 0     , 0     ).eatDuration(24).effect(MobEffects.REGENERATION,1200,0.5f).build();

    //berry
    public static final GTMFOFoodStats BERRY                 =    food( 1    , 0.5f  , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ELDERBERRY            = builder( 1    , 0.5f  , 0     , 1f    , 0     , 0     , 0     ).effect(MobEffects.CONFUSION,400,0.05f).effect(MobEffects.POISON,200,0.10f).build();
    public static final GTMFOFoodStats BERRY_MEDLEY          =    food( 5    , 0.5f  , 0     , 1f    , 0     , 0     , 0     );

    //bread
    public static final GTMFOFoodStats BUN                   =    food( 1    , 1f    , 25    , 0     , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats BUN_PRESLICED         =    food( 0    , 0     , 20    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats BREAD_PRESLICED       =    food( 1    , 1f    , 20    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats BAGUETTE              =    food( 2    , 1f    , 40    , 0     , 0     , 1f    , 0     , 0     );
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
    public static final GTMFOFoodStats CAPLET_PLUTONIUM_241  =    food( 0    , 1f    , 1     , 0     , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats CAPLET_CHORUS         =    food( 0    , 1f    , 1     , 0     , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats CAPLET_VIBRANT        =    food( 0    , 1f    , 1     , 0     , 0     , 0     , 0     , 0     );

    public static final GTMFOFoodStats OLIVE                 =    food( 2    , 0.5f  , 64    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats OLIVE_SLICE           =    food( 1    , 1f    , 32    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats MUSHROOM_SLICE        =    food( 1    , 1f    , 32    , 0     , 0     , 0     , 0.5f  , 1f    );
    public static final GTMFOFoodStats TOMATO                =    food( 3    , 0.5f  , 72    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ONION                 =    food( 3    , 0.33f , 128   , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats CUCUMBER              =    food( 2    , 0.5f  , 64    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats PORCHETTA             =    food( 7    , 0.7f  , 50    , 0     , 0     , 0     , 0.5f  , 0.1f  );
    public static final GTMFOFoodStats POPCORN_BAG           =    food( 5    , 0.4f  , 32    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats MINERAL_WATER         =    food( 0    , 0     , 32    , 0     , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats SPARKLING_WATER       =    food( 1    , 1f    , 32    , 0     , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats LEMON                 =    food( 1    , 0.5f  , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats LIME                  =    food( 1    , 0.5f  , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ETIRPS                =    food( 0    , 0     , 32    , 0     , 0.5f  , 0     , 0     , 0     );
    public static final GTMFOFoodStats BACON                 =    food( 2    , 0.8f  , 24    , 0     , 0     , 0     , 1f    , 0     );
    public static final GTMFOFoodStats FRENCH_FRIES          =    food( 3    , 0     , 20    , 0     , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats SYALS                 =    food( 1    , 0.25f , 32    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats CHIPS_BAG             =    food( 2    , 0.5f  , 32    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats CHIPS_KETTLE          =    food( 3    , 0.5f  , 32    , 0     , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats CHIPS_REDUCED_FAT     =    food( 2    , 1.5f  , 32    , 0     , 0     , 1.5f  , 0     , 0     );
    public static final GTMFOFoodStats POTATO_STICK          =    food( 3    , 0.8f  , 12    , 0     , 0     , 1f    , 0     , 0     );

    public static final GTMFOFoodStats TUNGSTENSTEEL_APPLE   =    food( 3    , 1f    , 80    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats CAKE_BOTTOM           =    food( 2    , 0.5f  , 60    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats CAKE_BOTTOM_BAKED     =    food( 3    , 0.5f  , 60    , 0     , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats PIZZA_CHEESE          =    food( 10   , 0.8f  , 50    , 1f    , 0     , 1f    , 0     , 1f    );
    public static final GTMFOFoodStats PIZZA_VEGGIE          =    food( 10   , 0.7f  , 50    , 0     , 0     , 1f    , 0     , 2f    );
    public static final GTMFOFoodStats PIZZA_MEAT            =    food( 11   , 0.8f  , 50    , 0     , 0     , 1f    , 1f    , 1f    );
    public static final GTMFOFoodStats SANDWICH_VEGGIE       =    food( 6    , 0.6f  , 40    , 0     , 0     , 1f    , 0     , 1f    );
    public static final GTMFOFoodStats SANDWICH_CHEESE       =    food( 6    , 0.6f  , 40    , 1f    , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats SANDWICH_BACON        =    food( 6    , 0.7f  , 40    , 0     , 0     , 1f    , 1f    , 0     );
    public static final GTMFOFoodStats SANDWICH_STEAK        =    food( 7    , 0.7f  , 40    , 0     , 0     , 1f    , 1f    , 0     );
    public static final GTMFOFoodStats SANDWICH_TOAST        =    food( 6    , 0.5f  , 32    , 0     , 0     , 1.5f  , 0     , 0     );
    public static final GTMFOFoodStats SANDWICH_VEGGIE_LARGE =    food( 9    , 0.6f  , 60    , 0     , 0     , 1f    , 0     , 2f    );
    public static final GTMFOFoodStats SANDWICH_CHEESE_LARGE =    food( 11   , 0.6f  , 60    , 2f    , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats SANDWICH_BACON_LARGE  =    food( 10   , 0.7f  , 60    , 0     , 0     , 1f    , 2f    , 0     );
    public static final GTMFOFoodStats SANDWICH_STEAK_LARGE  =    food( 13   , 0.7f  , 60    , 0     , 0     , 1f    , 2f    , 0     );

    public static final GTMFOFoodStats CHEDDAR_SLICE         =    food( 2    , 0.2f  , 20    , 2f    , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats MOZZARELLA_BALL       =    food( 3    , 0.6f  , 32    , 2f    , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats GORGONZOLA_TRIANGULAR =    food( 3    , 0.5f  , 32    , 2f    , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats ROTTEN_FISH           =    food( 1    , 0     , 100   , 0     , 0     , 0     , 0.5f  , 0     );
    public static final GTMFOFoodStats ROTTEN_MEAT           =    food( 1    , 0     , 100   , 0     , 0     , 0     , 0.5f  , 0     );
    public static final GTMFOFoodStats CHUM                  =    food( 3    , 0     , 32    , 0     , 0     , 0     , 0.5f  , 0     );
    public static final GTMFOFoodStats CHUM_STICK            =    food( 3    , 0     , 16    , 0     , 0     , 0     , 0.75f , 0     );
    public static final GTMFOFoodStats BANANA                =    food( 2    , 1f    , 60    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ORANGE                =    food( 2    , 1f    , 50    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats GRAPES                =    food( 1    , 1f    , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats WHITE_GRAPES          =    food( 1    , 1f    , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats MANGO                 =    food( 2    , 1f    , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats APRICOT               =    food( 2    , 1f    , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats BANANA_PEELED         =    food( 2    , 1f    , 12    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats VODKA                 =    food( 2    , 0     , 32    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats LENINADE              =    food( 3    , 1f    , 32    , 0     , 1f    , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats HOT_MUSHROOM_STEW     =    food( 8    , 1f    , 60    , 0.5f  , 0     , 0.5f  , 0.5f  , 1f    );
    public static final GTMFOFoodStats HOT_BEETROOT_SOUP     =    food( 7    , 1f    , 60    , 0     , 0     , 0.5f  , 0     , 1.5f  );
    public static final GTMFOFoodStats HOT_RABBIT_STEW       =    food( 9    , 0.9f  , 60    , 0     , 0     , 1f    , 1.5f  , 1f    );
    public static final GTMFOFoodStats KEBAB_KUBIDEH         =    food( 6    , 0.8f  , 32    , 0     , 0     , 0.5f  , 1f    , 0.75f );
    public static final GTMFOFoodStats KEBAB_BARG            =    food( 6    , 0.5f  , 32    , 0     , 0.25f , 0.5f  , 1f    , 0.5f  );
    public static final GTMFOFoodStats KEBAB_SOLTANI         =    food( 16   , 1.1f  , 32    , 0     , 1f    , 1f    , 1.5f  , 1f    );
    public static final GTMFOFoodStats KEBAB_ONION           =    food( 5    , 0.3f  , 32    , 0     , 0     , 0     , 0     , 1.25f );
    public static final GTMFOFoodStats KEBAB_TOMATO          =    food( 5    , 0.3f  , 32    , 0     , 1.25f , 0     , 0     , 0     );
    public static final GTMFOFoodStats KEBAB_CHUM            =    food( 6    , 0.3f  , 12    , 0     , 0     , 0.5f  , 0.5f  , 0     );
    public static final GTMFOFoodStats KEBAB_CHUM_BUCKET     =    food( 16   , 2f    , 60    , 0     , 1f    , 1.5f  , 1.5f  , 1f    );
    public static final GTMFOFoodStats KEBAB_CARROT          =    food( 4    , 0.5f  , 32    , 0     , 0     , 0     , 0     , 1.25f );
    public static final GTMFOFoodStats KEBAB_FAT             =    food( 4    , 0.3f  , 32    , 0     , 0     , 0     , 0.5f  , 0     );
    public static final GTMFOFoodStats KEBAB_MEAT            =    food( 3    , 0.6f  , 32    , 0     , 0     , 0.25f , 1f    , 0     );
    public static final GTMFOFoodStats TOMATO_SLICE          =    food( 1    , 0     , 32    , 0     , 0.75f , 0     , 0     , 0     );
    public static final GTMFOFoodStats ONION_SLICE           =    food( 1    , 0     , 32    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats CUCUMBER_SLICE        =    food( 1    , 0     , 32    , 0     , 0     , 0     , 0     , 0.75f );
    public static final GTMFOFoodStats CARROT_SLICE          =    food( 1    , 0     , 32    , 0     , 0     , 0     , 0     , 0.75f );
    public static final GTMFOFoodStats APPLE_SLICE           =    food( 1    , 0.1f  , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats EGGPLANT_SLICE        =    food( 1    , 0     , 32    , 0     , 0     , 0     , 0     , 0.75f );
    public static final GTMFOFoodStats APPLE_JUICE           =    food( 3    , 0.2f  , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ORANGE_JUICE          =    food( 3    , 0.2f  , 32    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ICE_CREAM_PLAIN       =    food( 4    , 0.25f , 32    , 1f    , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats ICE_CREAM_CHUM        =    food( 5    , 0.33f , 32    , 1f    , 0     , 0     , 1f    , 0     );
    public static final GTMFOFoodStats ICE_CREAM_BANANA      =    food( 6    , 0.33f , 32    , 1f    , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ICE_CREAM_BACON       =    food( 6    , 0.33f , 32    , 1f    , 0     , 0     , 1f    , 0     );
    public static final GTMFOFoodStats ICE_CREAM_VANILLA     =    food( 9    , 0.25f , 32    , 1f    , 0     , 0     , 0     , 0.25f );
    public static final GTMFOFoodStats ICE_CREAM_BEAR        =    food( 7    , 0.33f , 32    , 1f    , 0     , 0     , 1f    , 0     );
    public static final GTMFOFoodStats ICE_CREAM_MELON       =    food( 5    , 0.33f , 32    , 1f    , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ICE_CREAM_CHOCOLATE   =    food( 9    , 0.25f , 32    , 1f    , 0     , 0     , 0.25f , 0.25f );
    public static final GTMFOFoodStats ICE_CREAM_LEMON       =    food( 6    , 0.33f , 32    , 1f    , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats ICE_CREAM_CHIP        =    food( 8    , 0.33f , 32    , 1f    , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats ICE_CREAM_RAINBOW     =    food( 6    , 0.33f , 32    , 1.25f , 0.25f , 0     , 0     , 0.25f );
    public static final GTMFOFoodStats MILK_CHOCOLATE        =    food( 4    , 1.25f , 32    , 1f    , 0     , 0     , 0     , 0.5f  );
    public static final GTMFOFoodStats GRAHAM_CRACKER        =    food( 1    , 1f    , 32    , 0     , 0     , 1.5f  , 0.25f , 0     );
    public static final GTMFOFoodStats SMORE_1               =    food( 8    , 1.5f  , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_2               =    food( 20   , 3.8f  , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_4               =    food( 44,8.61363636364f, 32, 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_8               =    food( 92   , 18.2f , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_16              =    food( 188  , 37.4f , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_32              =    food( 380  , 75.8f , 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMORE_64              =    food( 764  , 152.6f, 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMOGUS                =    food( 1532 , 306.2f, 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMOGUS_2              =    food( 3068 , 613.4f, 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats SMOGUS_4              =    food( 6140 ,1227.8f, 32    , 0.5f  , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats MARSHMALLOW           =    food( 1    , 1f    , 32    , 0     , 0     , 0.5f  , 0.5f  , 0     );
    public static final GTMFOFoodStats COFFEE                =    food( 8    , 0.4f  , 32    , 0     , 0.5f  , 0.5f  , 0.5f  , 0     );
    public static final GTMFOFoodStats COFFEE_ENERGIZING     =    food( 8    , 0.6f  , 32    , 0     , 0.5f  , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats MUSHY_PEAS            =    food( 3    , 1f    , 32    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats BREAD_SLICE           =    food( 1    , 0.5f  , 32    , 0     , 0     , 1f    , 0     , 0     );
    public static final GTMFOFoodStats TOAST                 =    food( 2    , 0.5f  , 32    , 0     , 0     , 1.5f  , 0     , 0     );
    public static final GTMFOFoodStats FISH_AND_CHIPS        =    food( 7    , 0.6f  , 32    , 0     , 0     , 1f    , 1f    , 0.25f );
    public static final GTMFOFoodStats FULL_BREAKFAST        =    food( 10   , 1.2f  , 32    , 0     , 1f    , 1f    , 1.5f  , 1f    );
    public static final GTMFOFoodStats SHEPHERDS_PIE         =    food( 9    , 1f    , 32    , 0     , 0     , 1f    , 1f    , 1f    );
    public static final GTMFOFoodStats SAUSAGE_ROLL          =    food( 7    , 0.7f  , 32    , 0     , 0     , 0.75f , 1f    , 0     );
    public static final GTMFOFoodStats BAKED_BEANS           =    food( 4    , 1f    , 32    , 0     , 0.5f  , 0     , 0.5f  , 0     );
    public static final GTMFOFoodStats BEANS_ON_TOAST        =    food( 7    , 0.8f  , 32    , 0     , 0.25f , 0.75f , 0.5f  , 0     );
    public static final GTMFOFoodStats FRIED_FISH            =    food( 4    , 0.3f  , 32    , 0     , 0     , 0.5f  , 1f    , 0     );
    public static final GTMFOFoodStats BEER                  =    food( 2    , 0.5f  , 32    , 0     , 0     , 0.5f  , 0     , 0     );
    public static final GTMFOFoodStats SAUSAGE               =    food( 4    , 0.7f  , 32    , 0     , 0     , 0.25f , 1f    , 0     );
    public static final GTMFOFoodStats NILK                  =    food( 6    , 4f    , 32    , 3f    , 0     , 0     , 1f    , 0     );

    public static final GTMFOFoodStats BRUSCHETTA            =    food( 6    , 0.5f  , 32    , 0     , 1f    , 1f    , 0.5f  , 1f    );
    public static final GTMFOFoodStats CAPONATA              =    food( 6    , 0.9f  , 32    , 0     , 0     , 0     , 0     , 2f    );
    public static final GTMFOFoodStats CARBONARA             =    food( 9    , 0.8f  , 32    , 0.5f  , 0     , 1f    , 1f    , 0     );
    public static final GTMFOFoodStats CARCIOFI_ALLA_ROMANA  =    food( 8    , 1.3f  , 32    , 0     , 0     , 0     , 0.5f  , 1.5f  );
    public static final GTMFOFoodStats FETTUCCINE_ALFREDO    =    food( 8    , 0.4f  , 20    , 0.75f , 0     , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats PARMIGIANA            =    food( 8    , 1.1f  , 32    , 1f    , 0.5f  , 0     , 0.25f , 1f    );
    public static final GTMFOFoodStats PASTA_E_FAGIOLI       =    food( 4    , 2.5f  , 32    , 0     , 0     , 1f    , 1.5f  , 1.5f  );
    public static final GTMFOFoodStats PASTA_ALLA_NORMA      =    food( 12   , 0.7f  , 128   , 0     , 1f    , 1f    , 0     , 1.25f );
    public static final GTMFOFoodStats PASTA_AL_POMODORO     =    food( 5    , 0.5f  , 32    , 0     , 1.25f , 1f    , 0     , 0.75f );
    public static final GTMFOFoodStats POLENTA               =    food( 6    , 0.4f  , 32    , 0     , 0.75f , 0.75f , 0.75f , 0     );
    public static final GTMFOFoodStats RAFANATA              =    food( 7    , 1f    , 32    , 0     , 0     , 1f    , 0.5f  , 0.75f );
    public static final GTMFOFoodStats RISOTTO               =    food( 10   , 0.8f  , 32    , 1f    , 0.25f , 1f    , 0.75f , 0.75f );
    public static final GTMFOFoodStats SPAGHETTI_ALLASSASSINA=    food( 6    , 0.8f  , 32    , 0     , 0.75f , 1f    , 0     , 0     );
    public static final GTMFOFoodStats TAGLIATELLE_AL_RAGU   =    food( 14   , 0.7f  , 32    , 0.75f , 0.5f  , 0     , 1.25f , 1f    );
    public static final GTMFOFoodStats TORTELLINI_IN_BRODO   =    food( 10   , 0.5f  , 32    , 0     , 0     , 0     , 1.75f , 1.75f );
    public static final GTMFOFoodStats VITELLO_TONNATO       =    food( 10   , 1f    , 32    , 0     , 0     , 0     , 2.5f  , 1.5f  );
    public static final GTMFOFoodStats LASAGNA_CHUM          =    food( 9    , 0.7f  , 32    , 0.5f  , 0.5f  , 1f    , 0.5f  , 0     );
    public static final GTMFOFoodStats LASAGNA_NAPOLETANA    =    food( 11   , 0.7f  , 32    , 0.5f  , 0.75f , 1f    , 1f    , 0.25f );
    public static final GTMFOFoodStats LASAGNA_PESTO         =    food( 15   , 0.7f  , 32    , 1f    , 0     , 1f    , 1f    , 0.25f );
    public static final GTMFOFoodStats PASTA_ALLAMOGUS       =    food( 5    , 0.1f  , 32    , 0     , 0.75f , 1f    , 0     , 0.5f  );
    public static final GTMFOFoodStats PORCHETTA_SLICE       =    food( 2    , 0.7f  , 32    , 0     , 0     , 0     , 1f    , 0.25f );
    public static final GTMFOFoodStats WHITE_WINE            =    food( 6    , 0.7f  , 96    , 0     , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats RED_WINE              =    food( 4    , 0.7f  , 96    , 0     , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats EMERGENCY_RATIONS     =    food( 5    , 1.0f  , 32    , 0     , 0.5f  , 0     , 1f    , 0.5f  );

    public static final GTMFOFoodStats ETIRPS_CRANBERRY      =    food( 3    , 0.3f  , 32    , 0     , 0.5f  , 0     , 0     , 0     );
    public static final GTMFOFoodStats PELMENI               =    food( 5    , 0.5f  , 32    , 0     , 0     , 1f    , 1f    , 0.125f);
    public static final GTMFOFoodStats PELMENI_SEASONED      =    food( 7    , 1f    , 24    , 0.5f  , 0     , 1f    , 1f    , 1f    );
    public static final GTMFOFoodStats ANTAF                 =    food( 5    , 0.5f  , 32    , 0     , 0.5f  , 0     , 0     , 0     );
    public static final GTMFOFoodStats SORBET_PLAIN          =    food( 0    , 0     , 12    , 0     , 0     , 0     , 0     , 0     );
    public static final GTMFOFoodStats SORBET_APPLE          =    food( 4    , 0.5f  , 12    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats SORBET_APRICOT        =    food( 4    , 0.5f  , 12    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats SORBET_GRAPE          =    food( 4    , 0.5f  , 12    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats SORBET_LIME           =    food( 4    , 0.5f  , 12    , 0     , 1f    , 0     , 0     , 0     );
    public static final GTMFOFoodStats SORBET_CHORUS         =    food( 4    , 0.5f  , 12    , 0     , 0     , 0     , 0     , 1f    );
    public static final GTMFOFoodStats SORBET_VIBRANT        =    food( 0    , 0     , 12    , 0     , 2f    , 0     , 0     , 2f    );
    public static final GTMFOFoodStats FERMENTED_CHORUS      =    food( 2    , 0.5f  , 60    , 0     , 0     , 0     , 0     , 2f    );
    public static final GTMFOFoodStats FERMENTED_CHORUS_PIE  =    food( 6    , 1f    , 32    , 0     , 0     , 2f    , 0     , 2f    );
    public static final GTMFOFoodStats CHIPS_NAQUADAH        =    food( 2    , 0.5f  , 32    , 0     , 0     , 1f    , 0     , 1f    );

    public static final GTMFOFoodStats SANDWICH_VIBRANT      =    food( 7    , 0.8f  , 40    , 0     , 1f    , 1f    , 1f    , 0     );








}











