package com.ironsword.gtmfo.api.mixin;

import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public interface IContainerItem {
    void setContainerItem(Supplier<ItemStack> supplier);

    Supplier<ItemStack> getContainerItem();
}
