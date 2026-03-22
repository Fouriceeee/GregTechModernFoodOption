package com.ironsword.gregtechmodernfoodoption.api.item.component;

import com.gregtechceu.gtceu.api.item.component.FoodStats;
import it.unimi.dsi.fastutil.objects.Object2FloatArrayMap;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

public class GTMFOFoodStats extends FoodStats {
    protected Object2FloatMap<String> nutrients = new Object2FloatArrayMap<>();
    protected int eatingDuration = 32;

    public GTMFOFoodStats(FoodProperties properties, boolean isDrink, boolean hasPotionEffects, @Nullable Supplier<ItemStack> containerItem) {
        super(properties, isDrink, hasPotionEffects, containerItem);
    }

    public GTMFOFoodStats(int foodLevel,float saturation) {
        this(new FoodProperties.Builder().nutrition(foodLevel).saturationMod(saturation).build(), false, false, null);
    }

    public GTMFOFoodStats eatingDuration(int duration) {
        this.eatingDuration = duration;
        return this;
    }

    public GTMFOFoodStats nutrients(float dairy, float fruit, float grain, float protein, float vegetable){
        if (dairy > 0) {
            this.nutrients.put("dairy", dairy);
        }
        if (fruit > 0) {
            this.nutrients.put("fruit", fruit);
        }
        if (grain > 0) {
            this.nutrients.put("grain", grain);
        }
        if (protein > 0) {
            this.nutrients.put("protein", protein);
        }
        if (vegetable > 0) {
            this.nutrients.put("vegetable", vegetable);
        }
        return this;
    }


}
