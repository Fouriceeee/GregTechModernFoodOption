package com.ironsword.gtmfo.data;

import com.tterrag.registrate.providers.ProviderType;

public class GTMFOProviderTypes {
    public static final ProviderType<CNLangProvider> CNLANG = ProviderType.register("cnlang",(p, e)-> new CNLangProvider(p,e.getGenerator().getPackOutput()));

    public static void init(){}
}
