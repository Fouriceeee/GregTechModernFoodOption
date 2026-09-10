package com.ironsword.gtmfo.api.item.component;

import com.google.common.collect.Lists;
import com.gregtechceu.gtceu.api.item.component.FoodStats;
import com.mojang.datafixers.util.Pair;
import lombok.Getter;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class GTMFOFoodStats extends FoodStats {
    @Getter
    protected int eatingDuration = 32;

    public GTMFOFoodStats(FoodProperties properties, int eatingDuration, boolean isDrink, @Nullable Supplier<ItemStack> containerItem) {
        super(properties, isDrink, containerItem);
        this.eatingDuration = eatingDuration;
    }

    public static class Builder{
        private int foodLevel;
        private float saturation;
        private int eatingDuration = 32;

        private boolean isMeat = false;
        private boolean isDrink = false;
        private boolean canAlwaysEat = false;
        private @Nullable Supplier<ItemStack> containerItem = null;

        private List<Pair<Supplier<MobEffectInstance>, Float>> effects = Lists.newArrayList();

        public Builder(int foodLevel, float saturation) {
            this.foodLevel = foodLevel;
            this.saturation = saturation;
        }

        public Builder(int foodLevel, float saturation, int eatingDuration) {
            this.foodLevel = foodLevel;
            this.saturation = saturation;
            this.eatingDuration = eatingDuration;
        }

        public Builder eatDuration(int duration){
            this.eatingDuration = duration;
            return this;
        }

        public Builder meat(){
            this.isMeat = true;
            return this;
        }

        public Builder drink(){
            this.isDrink = true;
            return this;
        }

        public Builder alwaysEat(){
            this.canAlwaysEat = true;
            return this;
        }

        public Builder item(@NotNull Supplier<ItemStack> containerItem){
            this.containerItem = containerItem;
            return this;
        }

        public Builder effect(Supplier<MobEffectInstance> effectInstance, float chance){
            this.effects.add(Pair.of(effectInstance,chance));
            return this;
        }

        public Builder effect(MobEffect mobEffect, int duration, int amplifier ,  float chance){
            return this.effect(()->new MobEffectInstance(mobEffect,duration,amplifier),chance);
        }

        public GTMFOFoodStats build(){
            FoodProperties.Builder propertyBuilder = new FoodProperties.Builder().nutrition(foodLevel).saturationMod(saturation);
            if (isMeat){
                propertyBuilder.meat();
            }
            if (canAlwaysEat){
                propertyBuilder.alwaysEat();
            }
            if (!effects.isEmpty()){
                effects.forEach((pair)-> propertyBuilder.effect(pair.getFirst(), pair.getSecond()));
            }

            return new GTMFOFoodStats(propertyBuilder.build(),eatingDuration,isDrink,containerItem);
        }
    }
}
