package com.ironsword.gregtechmodernfoodoption.api.item.component;

import com.google.common.collect.Lists;
import com.gregtechceu.gtceu.api.item.component.FoodStats;
import com.ironsword.gregtechmodernfoodoption.api.capability.NutrientsTracker;
import com.ironsword.gregtechmodernfoodoption.api.capability.forge.GTMFOCapability;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.Object2FloatArrayMap;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import lombok.Getter;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class GTMFOFoodStats extends FoodStats {
    protected Object2FloatMap<String> nutrients = new Object2FloatArrayMap<>();
    @Getter
    protected int eatingDuration = 32;

    public GTMFOFoodStats(FoodProperties properties, int eatingDuration,boolean isDrink, @Nullable Supplier<ItemStack> containerItem) {
        super(properties, isDrink, containerItem);
        this.eatingDuration = eatingDuration;
    }

    private GTMFOFoodStats nutrients(float dairy, float fruit, float grain, float protein, float vegetable){
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

    @Override
    public ItemStack finishUsingItem(ItemStack food, Level level, LivingEntity livingEntity) {
        Player player = livingEntity instanceof Player ? (Player) livingEntity : null;
        if (player != null){
            final NutrientsTracker tracker = GTMFOCapability.getNutrientsTracker(player);
            if (tracker != null){
                nutrients.forEach(tracker::gain);
            }
        }
        return super.finishUsingItem(food, level, livingEntity);
    }

    public static class Builder{
        private int foodLevel;
        private float saturation;
        private int eatingDuration = 32;
        private float dairy;
        private float fruit;
        private float grain;
        private float protein;
        private float vegetable;

        private boolean isMeat = false;
        private boolean isDrink = false;
        private boolean canAlwaysEat = false;
        private @Nullable Supplier<ItemStack> containerItem = null;

        private List<Pair<Supplier<MobEffectInstance>, Float>> effects = Lists.newArrayList();

        public Builder(int foodLevel, float saturation, int eatingDuration, float dairy, float fruit, float grain, float protein, float vegetable) {
            this.foodLevel = foodLevel;
            this.saturation = saturation;
            this.eatingDuration = eatingDuration;
            this.dairy = dairy;
            this.fruit = fruit;
            this.grain = grain;
            this.protein = protein;
            this.vegetable = vegetable;
        }

        public Builder(int foodLevel, float saturation, float dairy, float fruit, float grain, float protein, float vegetable) {
            this.foodLevel = foodLevel;
            this.saturation = saturation;
            this.dairy = dairy;
            this.fruit = fruit;
            this.grain = grain;
            this.protein = protein;
            this.vegetable = vegetable;
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

        public Builder effect(MobEffect mobEffect, int duration, float chance){
            return this.effect(()->new MobEffectInstance(mobEffect,duration,0),chance);
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

            return new GTMFOFoodStats(propertyBuilder.build(),eatingDuration,isDrink,containerItem).nutrients(dairy,fruit,grain,protein,vegetable);
        }
    }
}
