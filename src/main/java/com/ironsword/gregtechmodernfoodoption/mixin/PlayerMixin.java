package com.ironsword.gregtechmodernfoodoption.mixin;

import com.ironsword.gregtechmodernfoodoption.api.capability.Nutrients;
import com.ironsword.gregtechmodernfoodoption.api.capability.NutrientsTracker;
import com.ironsword.gregtechmodernfoodoption.api.capability.forge.GTMFOCapability;
import com.ironsword.gregtechmodernfoodoption.api.mixin.INutrients;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin{
    @Inject(
            method = "eat",
            at = @At("HEAD")
    )
    private void injectEat(Level pLevel, ItemStack pFood, CallbackInfoReturnable<ItemStack> cir){
        NutrientsTracker tracker = GTMFOCapability.getNutrientsTracker((Player) (Object)this);
        if (tracker != null){
            ((INutrients)pFood.getFoodProperties(null)).getNutrients().forEach(tracker::gain);
        }
    }
}
