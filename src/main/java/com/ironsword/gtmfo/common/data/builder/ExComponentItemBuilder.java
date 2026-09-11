package com.ironsword.gtmfo.common.data.builder;

import com.gregtechceu.gtceu.api.item.component.IItemComponent;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.ironsword.gtmfo.api.item.ExComponentItem;
import com.ironsword.gtmfo.data.GTMFOProviderTypes;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;

import static com.ironsword.gtmfo.common.registry.GTMFORegistries.REGISTRATE;

public abstract class ExComponentItemBuilder<A extends Item, T extends ExComponentItemBuilder<A,T>> extends ItemBuilder<A,T> {
    protected List<IItemComponent> _Components = new ArrayList<>();

    public ExComponentItemBuilder(String id) {
        super(id);
    }

    protected T attach(IItemComponent component){
        _Components.add(component);
        return self();
    }

    public static ExComponentItemBuilder<ExComponentItem, ?> createExComponentItemBuilder(String id){
        return new Impl(id);
    }

    private static final class Impl extends ExComponentItemBuilder<ExComponentItem, Impl>{

        public Impl(String id) {
            super(id);
        }

        @Override
        protected Impl self() {
            return this;
        }

        @Override
        public com.tterrag.registrate.builders.ItemBuilder<ExComponentItem, GTRegistrate> build() {
            var builder = REGISTRATE.item(_Id, ExComponentItem::create);

            if (_Properties !=null)
                builder.initialProperties(()-> _Properties);

            if (!_Components.isEmpty()){
                builder.onRegister(item -> item.setComponents(_Components));
            }

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
        public ItemEntry<ExComponentItem> register() {
            return build().register();
        }
    }
}
