package com.ironsword.gtmfo.common.data;

import com.gregtechceu.gtceu.api.data.tag.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class GTMFOTags {

    public static final TagKey<Item> BERRY = TagUtil.createItemTag("berry");
    public static final TagKey<Item> BERRY_SWEET = TagUtil.createItemTag("berry/sweet");
    public static final TagKey<Item> BERRY_TART = TagUtil.createItemTag("berry/tart");
    public static final TagKey<Item> POISONOUS_BERRY = TagUtil.createItemTag("poisonous_berry");
}
