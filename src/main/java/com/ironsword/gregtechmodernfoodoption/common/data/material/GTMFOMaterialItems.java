package com.ironsword.gregtechmodernfoodoption.common.data.material;


import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.info.MaterialFlags;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.api.item.TagPrefixItem;
import com.gregtechceu.gtceu.api.registry.registrate.GTRegistrate;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.ironsword.gregtechmodernfoodoption.common.data.GTMFOCreativeModeTabs;
import com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries;
import com.tterrag.registrate.providers.ProviderType;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.nullness.NonNullBiConsumer;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import net.minecraft.world.item.Item;

import static com.ironsword.gregtechmodernfoodoption.common.registry.GTMFORegistries.REGISTRATE;

@FieldDefaults(level = AccessLevel.PUBLIC, makeFinal = true)
public class GTMFOMaterialItems {
//    static {
//        REGISTRATE.creativeModeTab(()-> GTMFOCreativeModeTabs.MATERIAL_TAB);
//    }


    //static ItemEntry<Item> FAT = test(TagPrefix.crushed, GTMFOMaterials.FAT, GTMFORegistries.REGISTRATE);

    public static void init(){

    }

//    public static ItemEntry<Item> test(TagPrefix tagPrefix, Material material, GTRegistrate registrate){
//        return registrate
//                .item(tagPrefix.idPattern().formatted(material.getName()),
//                        properties -> tagPrefix.itemConstructor()
//                                .create(material.hasFlag(MaterialFlags.FIRE_RESISTANT) ? properties.fireResistant() :
//                                        properties, tagPrefix, material))
//                .setData(ProviderType.LANG, NonNullBiConsumer.noop())
//                .transform(GTItems.unificationItem(tagPrefix, material))
//                .properties(p -> p.stacksTo(tagPrefix.maxStackSize()))
//                .model(NonNullBiConsumer.noop())
//                .color(() -> () -> TagPrefixItem.tintColor(material))
//                .onRegister(GTItems::cauldronInteraction)
//                .register();
//    }

}
