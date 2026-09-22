package com.ironsword.gtmfo.common.data;

import com.gregtechceu.gtceu.api.data.tag.TagUtil;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

import com.tterrag.registrate.providers.RegistrateTagsProvider;

public class GTMFOTags {

    // food
    public static final TagKey<Item> BERRY = TagUtil.createItemTag("berry");
    public static final TagKey<Item> BERRY_SWEET = TagUtil.createItemTag("berry/sweet");
    public static final TagKey<Item> BERRY_TART = TagUtil.createItemTag("berry/tart");
    public static final TagKey<Item> POISONOUS_BERRY = TagUtil.createItemTag("poisonous_berry");

    public static final TagKey<Item> MEAT = TagUtil.createItemTag("meat");

    // tool
    public static final TagKey<Item> ROLLING_PINS = TagUtil.createItemTag("tools/rolling_pins");
    public static final TagKey<Item> CRAFTING_ROLLING_PINS = TagUtil.createItemTag("tools/crafting_rolling_pins");

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static void initItemTags(RegistrateTagsProvider<Item> provider) {
        provider.addTag(MEAT)
                .add(
                        ForgeRegistries.ITEMS.getResourceKey(Items.BEEF).get(),
                        ForgeRegistries.ITEMS.getResourceKey(Items.CHICKEN).get(),
                        ForgeRegistries.ITEMS.getResourceKey(Items.PORKCHOP).get(),
                        ForgeRegistries.ITEMS.getResourceKey(Items.MUTTON).get(),
                        ForgeRegistries.ITEMS.getResourceKey(Items.RABBIT).get(),
                        ForgeRegistries.ITEMS.getResourceKey(Items.COD).get(),
                        ForgeRegistries.ITEMS.getResourceKey(Items.SALMON).get(),
                        ForgeRegistries.ITEMS.getResourceKey(Items.PUFFERFISH).get(),
                        ForgeRegistries.ITEMS.getResourceKey(Items.TROPICAL_FISH).get());
    }
}
