package com.ironsword.gtmfo.api.capability;

import it.unimi.dsi.fastutil.objects.Object2FloatArrayMap;
import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import lombok.Getter;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.INBTSerializable;

public class NutrientsTracker implements INBTSerializable<CompoundTag> {
    @Getter
    private final Object2FloatMap<String> nutrients = new Object2FloatArrayMap<>();

    private final Player player;

    public NutrientsTracker(Player player) {
        this.player = player;
    }

    public void tick(){

    }

    public void gain(float dairy, float fruit, float grain, float protein, float vegetable){
        if (dairy > 0) {
            nutrients.put("dairy", dairy);
        }
        if (fruit > 0) {
            nutrients.put("fruit", fruit);
        }
        if (grain > 0) {
            nutrients.put("grain", grain);
        }
        if (protein > 0) {
            nutrients.put("protein", protein);
        }
        if (vegetable > 0) {
            nutrients.put("vegetable", vegetable);
        }
    }

    public void gain(String name, float amount){
        if (Nutrients.LIST.contains(name)){
            if (nutrients.getOrDefault(name,0)+amount>0){
                nutrients.put(name,nutrients.getFloat(name)+amount);
            }else{
                nutrients.removeFloat(name);
            }
        }
    }

    public void remove(String name){
        nutrients.removeFloat(name);
    }

    @Override
    public CompoundTag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        CompoundTag tag1 = new CompoundTag();

        nutrients.forEach((key,value)->{
            if (value > 0){
                tag1.putFloat(key,value);
            }
        });

        tag.put("nutrients",tag1);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag nbt) {
        if (nbt.contains("nutrients")){
            CompoundTag tag = nbt.getCompound("nutrients");
            nutrients.clear();
            for (String key: tag.getAllKeys()){
                nutrients.put(key, tag.getFloat(key));
            }
        }
    }
}
