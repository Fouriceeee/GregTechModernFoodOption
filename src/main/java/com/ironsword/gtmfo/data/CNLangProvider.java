package com.ironsword.gtmfo.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.LogicalSide;

import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.providers.RegistrateProvider;

public class CNLangProvider extends LanguageProvider implements RegistrateProvider {

    private final AbstractRegistrate<?> owner;

    public CNLangProvider(AbstractRegistrate<?> owner, PackOutput output) {
        super(output, owner.getModid(), "zh_cn");
        this.owner = owner;
    }

    @Override
    protected void addTranslations() {
        owner.genData(GTMFOProviderTypes.CNLANG, this);
    }

    @Override
    public LogicalSide getSide() {
        return LogicalSide.CLIENT;
    }
}
