package com.ironsword.gregtechmodernfoodoption.forge;

import com.ironsword.gregtechmodernfoodoption.GregTechModernFoodOption;
import com.ironsword.gregtechmodernfoodoption.api.capability.NutrientsTracker;
import com.ironsword.gregtechmodernfoodoption.api.capability.forge.GTMFOCapability;
import com.ironsword.gregtechmodernfoodoption.common.command.NutrientCommands;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Mod.EventBusSubscriber(modid = GregTechModernFoodOption.MODID, bus =  Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeCommonEventListener {

    @SubscribeEvent
    public static void registerPlayerCapabilities(AttachCapabilitiesEvent<Entity> event){
        if (event.getObject() instanceof Player player){
            final NutrientsTracker tracker = new NutrientsTracker(player);
            event.addCapability(GregTechModernFoodOption.id("nutrients_tracker"), new ICapabilitySerializable<CompoundTag>() {
                @Override
                public CompoundTag serializeNBT() {
                    return tracker.serializeNBT();
                }
                @Override
                public void deserializeNBT(CompoundTag nbt) {
                    tracker.deserializeNBT(nbt);
                }

                @Override
                public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
                    return GTMFOCapability.CAPABILITY_NUTRIENTS_TRACKER.orEmpty(cap,LazyOptional.of(()->tracker));
                }
            });
        }

    }

    @SubscribeEvent
    public static void registerCommands(RegisterCommandsEvent event){
        NutrientCommands.register(event.getDispatcher(),event.getBuildContext());
    }

}
