package com.ironsword.gtmfo.common.data.builder;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.ironsword.gtmfo.data.GTMFOProviderTypes;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;

import static com.ironsword.gtmfo.common.registry.GTMFORegistries.REGISTRATE;

public class ItemBuilder {
    private final String _Id;

    private @Nullable Item.Properties _Properties = null;
    private @Nullable TagKey<Item>[] _Tags = null;
    private @Nullable String _EnLang = null;
    private @Nullable String _CnLang = null;
    private @Nullable String _Texture = null;

    public ItemBuilder(String id) {
        _Id = id;
    }

    public ItemBuilder stack(int count){
        _Properties = new Item.Properties().stacksTo(count);
        return this;
    }

    public ItemBuilder en(String lang) {
        _EnLang = lang;
        return this;
    }

    public ItemBuilder cn(String lang) {
        _CnLang = lang;
        return this;
    }

    public ItemBuilder texture(String path) {
        _Texture = path;
        return this;
    }

    @SafeVarargs
    public final ItemBuilder tag(TagKey<Item>... tags){
        _Tags = tags;
        return this;
    }

    public ItemEntry<Item> register() {
        return build().register();
    }

    public com.tterrag.registrate.builders.ItemBuilder<Item, GTRegistrate> build(){
        var builder = REGISTRATE.item(_Id, Item::new);

        //properties
        if (_Properties != null)
            builder.initialProperties(()-> _Properties);

        //data
        if (_Tags != null)
            builder.tag(_Tags);
        if (_EnLang != null)
            builder.lang(_EnLang);
        if (_CnLang != null)
            builder.setData(GTMFOProviderTypes.CNLANG, (ctx,prov)->prov.add(ctx.get().getDescriptionId(),_CnLang));
        if (_Texture != null)
            builder.model((ctx,prov)->prov.generated(ctx::getEntry,prov.modLoc("item/"+_Texture)));
        else
            builder.defaultModel();

        return builder;
    }
}
