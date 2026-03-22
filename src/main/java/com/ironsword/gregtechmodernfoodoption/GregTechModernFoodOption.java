package com.ironsword.gregtechmodernfoodoption;

import com.ironsword.gregtechmodernfoodoption.client.ClientProxy;
import com.ironsword.gregtechmodernfoodoption.common.CommonProxy;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GregTechModernFoodOption.MODID)
public class GregTechModernFoodOption {
    public static final String MODID = "gregtechmodernfoodoption";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GregTechModernFoodOption(FMLJavaModLoadingContext context)
    {
        @SuppressWarnings("removal")
        var bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.register(this);

        DistExecutor.unsafeRunForDist(()-> ClientProxy::new,()->CommonProxy::new);
    }

    public static ResourceLocation id(String path){
        return ResourceLocation.tryBuild(MODID,path);
    }
}
