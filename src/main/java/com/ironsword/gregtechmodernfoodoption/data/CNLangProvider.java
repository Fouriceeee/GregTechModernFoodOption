package com.ironsword.gregtechmodernfoodoption.data;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.providers.RegistrateProvider;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.LogicalSide;

public class CNLangProvider extends LanguageProvider implements RegistrateProvider {
    private final AbstractRegistrate<?> owner;

    public CNLangProvider(AbstractRegistrate<?> owner, PackOutput output) {
        super(output, owner.getModid(), "zh_cn");
        this.owner = owner;
    }

    @Override
    protected void addTranslations() {
        owner.genData(GTMFOProviderTypes.CNLANG,this);
    }

    @Override
    public LogicalSide getSide() {
        return LogicalSide.CLIENT;
    }
}
