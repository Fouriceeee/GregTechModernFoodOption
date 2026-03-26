package com.ironsword.gregtechmodernfoodoption.common.data;

import com.ironsword.gregtechmodernfoodoption.api.item.component.GTMFOFoodStats;
import net.minecraft.world.food.FoodProperties;

public class GTMFOFoodValues {
    private static FoodProperties food(int foodLevel,float saturation){
        return new FoodProperties.Builder().nutrition(foodLevel).saturationMod(saturation).build();
    }


//    public static final GTMFOFoodStats OLIVE = new GTMFOFoodStats(2,0.5f)
//            .eatingDuration(64)
//            .nutrients(0,0,0,0,1f);
//
//    public static final GTMFOFoodStats TOMATO = new GTMFOFoodStats(3,0.5f)
//            .eatingDuration(72)
//            .nutrients(0,1f,0,0,0);
//
//    public static final GTMFOFoodStats ONION = new GTMFOFoodStats(3,0.33f)
//            .eatingDuration(128)
//            .nutrients(0,0,0,0,1f);
//
//    public static final GTMFOFoodStats CUCUMBER = new GTMFOFoodStats(2,0.5f)
//            .eatingDuration(64)
//            .nutrients(0,0,0,0,1f);
}
