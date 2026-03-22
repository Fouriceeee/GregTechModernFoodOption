package com.ironsword.gregtechmodernfoodoption.mixin;

import com.ironsword.gregtechmodernfoodoption.api.mixin.IContainerItem;
import com.ironsword.gregtechmodernfoodoption.api.mixin.IEatingDuration;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMixin {
    @Inject(
            method = "getUseDuration",
            at =@At("HEAD"),
            cancellable = true)
    private void injectGetUseDuration(ItemStack pStack, CallbackInfoReturnable<Integer> cir){
        if (pStack.getItem().isEdible()) {
            cir.setReturnValue(((IEatingDuration)pStack.getFoodProperties(null)).getEatingDuration());
        } else {
            cir.setReturnValue(0);
        }
    }

    @Inject(
            method = "finishUsingItem",
            at = @At("HEAD"),
            cancellable = true
    )
    private void injectFinishUsingItem(ItemStack pStack, Level pLevel, LivingEntity pLivingEntity,CallbackInfoReturnable<ItemStack> cir){
        if (pStack.isEdible()){
            Player player = pLivingEntity instanceof  Player ? (Player) pLivingEntity : null;
            ItemStack container = ((IContainerItem)pStack.getFoodProperties(null)).getContainerItem().get();
            ItemStack stack1 = pLivingEntity.eat(pLevel,pStack);

            if (player == null || !player.getAbilities().instabuild){
                if (stack1.isEmpty()){
                    cir.setReturnValue(container);
                }

                if (player != null){
                    if (!player.getInventory().add(container)){
                        player.drop(container,true);
                    }
                }
            }

            cir.setReturnValue(stack1);

        }else {
            cir.setReturnValue(pStack);
        }

    }
}
