package com.ironsword.gtmfo.common.data.builder;

import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.ironsword.gtmfo.data.GTMFOProviderTypes;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import javax.annotation.Nullable;

import static com.ironsword.gtmfo.common.registry.GTMFORegistries.REGISTRATE;

public abstract class ItemBuilder<A extends Item,T extends ItemBuilder<A,T>> {
    protected final String _Id;
    protected @Nullable Item.Properties _Properties = null;

    protected @Nullable String _EnLang = null;
    protected @Nullable String _CnLang = null;
    protected @Nullable String _Texture = null;
    protected @Nullable TagKey<Item>[] _Tags = null;

    public ItemBuilder(String id){
        _Id = id;
    }

    public T stack(int count){
        _Properties = new Item.Properties().stacksTo(count);
        return self();
    }

    public T en(String en){
        _EnLang = en;
        return self();
    }

    public T cn(String cn){
        _CnLang = cn;
        return self();
    }

    public T texture(String path){
        _Texture = path;
        return self();
    }

    @SafeVarargs
    public final T tags(TagKey<Item>... tags){
        _Tags = tags;
        return self();
    }

    protected abstract T self();

    public abstract com.tterrag.registrate.builders.ItemBuilder<A, GTRegistrate> build();

    public abstract ItemEntry<A> register();

    public static ItemBuilder<Item, ?> createItemBuilder(String id){
        return new Impl(id);
    }

    private static final class Impl extends ItemBuilder<Item, Impl> {
        public Impl(String id) {
            super(id);
        }

        @Override
        protected Impl self() {
            return this;
        }

        @Override
        public com.tterrag.registrate.builders.ItemBuilder<Item, GTRegistrate> build() {
            var builder = REGISTRATE.item(_Id, Item::new);

            if (_Properties !=null)
                builder.initialProperties(()-> _Properties);

            if (_EnLang !=null)
                builder.lang(_EnLang);
            else
                builder.defaultLang();

            if (_CnLang !=null)
                builder.setData(GTMFOProviderTypes.CNLANG, (ctx, prov)->prov.add(ctx.get().getDescriptionId(), _CnLang));

            if (_Texture !=null)
                builder.model((ctx,prov)->prov.generated(ctx::getEntry,prov.modLoc("item/"+ _Texture)));
            else
                builder.defaultModel();

            if (_Tags != null)
                builder.tag(_Tags);

            return builder;
        }

        @Override
        public ItemEntry<Item> register() {
            return build().register();
        }
    }
}
