package com.ironsword.gtmfo.common.data.recipe;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.chemical.material.Material;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.item.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class MaterialHelper {

    public static ItemStack dust(Material material) {
        return ChemicalHelper.get(TagPrefix.dust, material);
    }

    public static ItemStack dust(Material material, int count) {
        return ChemicalHelper.get(TagPrefix.dust, material, count);
    }
}
