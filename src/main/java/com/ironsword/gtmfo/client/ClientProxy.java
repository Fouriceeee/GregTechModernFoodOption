package com.ironsword.gtmfo.client;

import com.ironsword.gtmfo.common.CommonProxy;
import com.ironsword.gtmfo.common.block.FruitBushBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ClientProxy extends CommonProxy {

    public ClientProxy() {
        super();
        init();
    }

    public static void init() {}

    @SubscribeEvent
    public void onRegisterBlockColors(RegisterColorHandlersEvent.Block event){
        event.register(
                ((pState, pLevel, pPos, pTintIndex) -> ((FruitBushBlock) pState.getBlock()).getOverlayColor(pState.getValue(FruitBushBlock.AGE))),
                ForgeRegistries.BLOCKS.getValues().stream().filter(FruitBushBlock.class::isInstance).toArray(Block[]::new)
        );
    }

    @SubscribeEvent
    public void onRegisterItemColors(RegisterColorHandlersEvent.Item event){
        event.register(
                ((pStack, pTintIndex) -> ((FruitBushBlock)((BlockItem)pStack.getItem()).getBlock()).getFruitColor()),
                ForgeRegistries.BLOCKS.getValues().stream().filter(FruitBushBlock.class::isInstance).toArray(Block[]::new)
        );
    }
}
