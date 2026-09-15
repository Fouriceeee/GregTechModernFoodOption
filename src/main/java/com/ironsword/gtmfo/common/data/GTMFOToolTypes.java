package com.ironsword.gtmfo.common.data;

import com.gregtechceu.gtceu.api.GTValues;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.chemical.material.properties.PropertyKey;
import com.gregtechceu.gtceu.api.item.tool.GTToolType;
import com.gregtechceu.gtceu.api.item.tool.GTToolType.ToolItemTagType;
import com.gregtechceu.gtceu.common.data.GTMaterials;

import com.ironsword.gtmfo.GregTechModernFoodOption;

public class GTMFOToolTypes {

    // GTM already has the lang entries of rolling pin
    public static final GTToolType ROLLING_PIN = GTToolType.builder("rolling_pin")
            .toolTag(ToolItemTagType.CRAFTING, GTMFOTags.CRAFTING_ROLLING_PINS)
            .toolTag(ToolItemTagType.MATCH, GTMFOTags.ROLLING_PINS)
            .toolStats(b -> b.crafting().damagePerCraftingAction(1)
                    .cannotAttack().attackSpeed(-2.4F))
            .modelLocation(GregTechModernFoodOption.id("item/tool/rolling_pin"))
            .materialAmount(2 * GTValues.M)
            .build();

    public static void addRollingPinToMaterials() {
        GTMaterials.Wood.getProperty(PropertyKey.TOOL).addTypes(ROLLING_PIN);
        GTMaterials.Rubber.getProperty(PropertyKey.TOOL).addTypes(ROLLING_PIN);
        GTMaterials.Polyethylene.getProperty(PropertyKey.TOOL).addTypes(ROLLING_PIN);
        GTMaterials.Polytetrafluoroethylene.getProperty(PropertyKey.TOOL).addTypes(ROLLING_PIN);
    }
}
