package com.ironsword.gtmfo.api.item;

import com.ironsword.gtmfo.api.item.component.GTMFOFoodStats;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlaceableFoodItem extends BlockItem {
    protected final GTMFOFoodStats foodStats;

    public PlaceableFoodItem(Block block, Properties properties, GTMFOFoodStats foodStats) {
        super(block, properties);
        this.foodStats = foodStats;
    }

    @Override
    public @Nullable FoodProperties getFoodProperties(ItemStack stack, @Nullable LivingEntity entity) {
        return foodStats.getFoodProperties(stack,entity);
    }

    @Override
    public boolean isEdible() {
        return true;
    }

    @Override
    public SoundEvent getEatingSound() {
        return foodStats.getEatingSound();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return foodStats.getUseAnimation(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack,level,tooltip,flag);
        foodStats.appendHoverText(stack,level,tooltip,flag);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
        return foodStats.finishUsingItem(stack,level,livingEntity);
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return foodStats.getEatingDuration();
    }
}
