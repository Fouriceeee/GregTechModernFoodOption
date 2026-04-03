package com.ironsword.gtmfo.mixin;

import com.ironsword.gtmfo.api.mixin.IContainerItem;
import com.ironsword.gtmfo.api.mixin.IEatingDuration;
import com.ironsword.gtmfo.api.mixin.INutrients;
import it.unimi.dsi.fastutil.objects.Object2FloatArrayMap;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
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
public abstract class FoodPropertiesMixin implements IEatingDuration, IContainerItem, INutrients {
    @Shadow @Final private boolean fastFood;

    @Unique
    private int eatingDuration = 32;

    @Unique
    @Nonnull
    private Supplier<ItemStack> containerItem = ()->ItemStack.EMPTY;

    @Unique
    private Object2FloatMap<String> nutrients = new Object2FloatArrayMap<>();

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

    @Unique
    @Override
    public Object2FloatMap<String> getNutrients() {
        return nutrients;
    }

    @Unique
    @Override
    public void addNutrients(float dairy, float fruit, float grain, float protein, float vegetable) {
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
    }
}
