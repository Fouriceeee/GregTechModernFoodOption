package com.ironsword.gtmfo.api.item;

import com.gregtechceu.gtceu.api.item.ComponentItem;
import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.ironsword.gtmfo.api.item.component.GTMFOFoodStats;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ExComponentItem extends ComponentItem {
    protected ExComponentItem(Properties properties) {
        super(properties);
    }

    public static ExComponentItem create(Item.Properties properties){
        return new ExComponentItem(properties);
    }

    @Override
    public int getUseDuration(ItemStack pStack) {
        for (IItemComponent component : components){
            if (component instanceof GTMFOFoodStats foodStats){
                return foodStats.getEatingDuration();
            }
        }
        return super.getUseDuration(pStack);
    }
}
