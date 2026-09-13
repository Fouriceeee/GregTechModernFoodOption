package com.ironsword.gtmfo.common.machine.multiblock.primitive;

import com.gregtechceu.gtceu.api.capability.recipe.ItemRecipeCapability;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.api.recipe.GTRecipe;
import com.gregtechceu.gtceu.api.recipe.content.Content;

import com.lowdragmc.lowdraglib.syncdata.annotation.DescSynced;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PrimitiveBakingOvenRecipeLogic extends RecipeLogic {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            PrimitiveBakingOvenRecipeLogic.class, RecipeLogic.MANAGED_FIELD_HOLDER);

    @Persisted
    @DescSynced
    private int fuel;
    @Persisted
    @DescSynced
    private int burnTime;

    @Persisted
    @DescSynced
    private int[] progresses = new int[4];
    @Persisted
    @DescSynced
    private int[] durations = new int[4];

    public PrimitiveBakingOvenRecipeLogic(PrimitiveBakingOvenMachine machine) {
        super(machine);
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    public PrimitiveBakingOvenMachine getMachine() {
        return (PrimitiveBakingOvenMachine) super.getMachine();
    }

    @Override
    public void resetRecipeLogic() {
        super.resetRecipeLogic();
        resetAllProgress();
        fuel = 0;
        burnTime = 0;
    }

    @Override
    public void serverTick() {
        if (fuel > 0) {
            //has fuel, decline fuel and process every slot
            fuel--;
            processAllSlots();
        } else if (hasRecipe()) {
            //no fuel and has recipe to process, try consuming fuel
            if(consumeFuel()){
                //consume fuel successfully, then process every slot
                processAllSlots();
            }else{
                //no available fuel, the reset all progress
                resetAllProgress();
            }
        } else {
            //no fuel and no recipe, just reset all progress
            resetAllProgress();
        }
    }

    private void processAllSlots(){
        setStatus(Status.WORKING);
        for (int slot = 0; slot < 4; slot++) {
            process(slot);
        }
    }

    private void resetAllProgress() {
        setStatus(Status.IDLE);
        Arrays.fill(progresses, 0);
        Arrays.fill(durations, 0);
    }

    private boolean hasRecipe() {
        for (int slot = 0; slot < 4; slot++) {
            if (findRecipe(slot) != null) return true;
        }
        return false;
    }

    private boolean consumeFuel() {
        NotifiableItemStackHandler fuelHandler = getMachine().fuelItems;
        ItemStack fuel = fuelHandler.getStackInSlot(0);
        if (fuel.isEmpty()) return false;
        int burn = ForgeHooks.getBurnTime(fuel, RecipeType.SMELTING);
        if (burn <= 0) return false;

        ItemStack remain = fuel.getCraftingRemainingItem();
        fuelHandler.extractItemInternal(0, 1, false);
        if (!remain.isEmpty()) {
            fuelHandler.insertItemInternal(0, remain, false);
        }
        this.fuel = burn;
        burnTime = burn;

        return true;
    }

    private void process(int slot) {
        GTRecipe recipe = findRecipe(slot);
        if (recipe == null) {
            //no recipe is found, reset duration and process
            durations[slot] = 0;
            progresses[slot] = 0;
            return;
        }
        if (durations[slot] != recipe.duration) {
            //find new recipe, reset progress to 0
            durations[slot] = recipe.duration;
            progresses[slot] = 0;
        }
        if(progresses[slot] < durations[slot]){
            progresses[slot]++;
        }
        if(progresses[slot] >= durations[slot]){
            finishSlot(slot,recipe);
            durations[slot] = 0;
            progresses[slot] = 0;
        }
    }

    @Nullable
    private GTRecipe findRecipe(int slot) {
        Iterator<GTRecipe> iterator = machine.getRecipeType().searchRecipe(machine,
                recipe -> canProcess(slot, recipe));
        return iterator.hasNext() ? iterator.next() : null;
    }

    private boolean canProcess(int slot, GTRecipe recipe) {
        ItemStack input = getMachine().importItems.getStackInSlot(slot);
        if (input.isEmpty()) return false;

        List<Content> inputContents = recipe.getInputContents(ItemRecipeCapability.CAP);
        if (inputContents.size() != 1) return false;
        Ingredient ingredient = ItemRecipeCapability.CAP.of(inputContents.get(0).content);
        if (ingredient == null || !ingredient.test(input)) return false;
        if (input.getCount() < ingredientCount(ingredient)) return false;

        List<Content> outputContents = recipe.getOutputContents(ItemRecipeCapability.CAP);
        if (outputContents.size() != 1) return false;
        ItemStack result = outputStack(outputContents.get(0));
        return !result.isEmpty() && canOutput(slot, result);
    }

    private void finishSlot(int slot, GTRecipe recipe) {
        Ingredient ingredient = ItemRecipeCapability.CAP
                .of(recipe.getInputContents(ItemRecipeCapability.CAP).get(0).content);
        ItemStack result = outputStack(recipe.getOutputContents(ItemRecipeCapability.CAP).get(0));
        getMachine().importItems.extractItemInternal(slot, ingredient == null ? 1 : ingredientCount(ingredient), false);
        if (!result.isEmpty()) {
            getMachine().exportItems.insertItemInternal(slot, result, false);
        }
    }

    private boolean canOutput(int slot, ItemStack result) {
        ItemStack output = getMachine().exportItems.getStackInSlot(slot);
        if (output.isEmpty()) return true;
        if (!ItemStack.isSameItemSameTags(output, result)) return false;
        int limit = Math.min(output.getMaxStackSize(), getMachine().exportItems.getSlotLimit(slot));
        return output.getCount() + result.getCount() <= limit;
    }

    private static int ingredientCount(Ingredient ingredient) {
        ItemStack[] items = ingredient.getItems();
        return items.length == 0 ? 1 : Math.max(1, items[0].getCount());
    }

    private static ItemStack outputStack(Content content) {
        Ingredient ingredient = ItemRecipeCapability.CAP.of(content.content);
        if (ingredient == null) return ItemStack.EMPTY;
        ItemStack[] items = ingredient.getItems();
        return items.length == 0 ? ItemStack.EMPTY : items[0].copy();
    }

    public double getSlotProgressPercent(int slot) {
        return durations[slot] == 0 ? 0.0 : progresses[slot] / (durations[slot] * 1.0);
    }

    public double getFuelPercent() {
        return burnTime == 0 ? 0.0 : fuel / (burnTime * 1.0);
    }
}
