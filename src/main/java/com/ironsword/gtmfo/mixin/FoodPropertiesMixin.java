package com.ironsword.gtmfo.mixin;

import com.ironsword.gtmfo.api.mixin.IContainerItem;
import com.ironsword.gtmfo.api.mixin.IEatingDuration;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

@Mixin(FoodProperties.class)
@SuppressWarnings({"AddedMixinMembersNamePattern"})
public abstract class FoodPropertiesMixin implements IEatingDuration, IContainerItem {
    @Shadow @Final private boolean fastFood;

    @Unique
    private int eatingDuration = 32;

    @Unique
    @Nonnull
    private Supplier<ItemStack> containerItem = ()->ItemStack.EMPTY;

    @Unique
    @Override
    public int getEatingDuration(){return fastFood ? 16 : eatingDuration;}

    @Unique
    @Override
    public void setEatingDuration(int duration) {
        this.eatingDuration = duration;
    }

    @Unique
    @Override
    public @NotNull Supplier<ItemStack> getContainerItem() {
        return containerItem;
    }

    @Unique
    @Override
    public void setContainerItem(@NotNull Supplier<ItemStack> containerItem) {
        this.containerItem = containerItem;
    }
}
