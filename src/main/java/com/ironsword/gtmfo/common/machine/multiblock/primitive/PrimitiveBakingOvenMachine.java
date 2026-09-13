package com.ironsword.gtmfo.common.machine.multiblock.primitive;

import com.gregtechceu.gtceu.api.capability.recipe.IO;
import com.gregtechceu.gtceu.api.gui.GuiTextures;
import com.gregtechceu.gtceu.api.gui.UITemplate;
import com.gregtechceu.gtceu.api.gui.widget.SlotWidget;
import com.gregtechceu.gtceu.api.machine.IMachineBlockEntity;
import com.gregtechceu.gtceu.api.machine.feature.IUIMachine;
import com.gregtechceu.gtceu.api.machine.trait.NotifiableItemStackHandler;
import com.gregtechceu.gtceu.api.machine.trait.RecipeLogic;
import com.gregtechceu.gtceu.common.machine.multiblock.primitive.PrimitiveWorkableMachine;
import com.ironsword.gtmfo.common.data.GTMFOGuiTextures;

import com.lowdragmc.lowdraglib.gui.modular.ModularUI;
import com.lowdragmc.lowdraglib.gui.texture.ProgressTexture;
import com.lowdragmc.lowdraglib.gui.widget.ImageWidget;
import com.lowdragmc.lowdraglib.gui.widget.LabelWidget;
import com.lowdragmc.lowdraglib.gui.widget.ProgressWidget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * A primitive oven that burns vanilla furnace fuel to bake up to four items at once.
 * <p>
 * The machine itself only owns its inventories and its GUI; all baking behaviour lives in
 * {@link PrimitiveBakingOvenRecipeLogic}.
 */
@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class PrimitiveBakingOvenMachine extends PrimitiveWorkableMachine implements IUIMachine {

    protected static final ManagedFieldHolder MANAGED_FIELD_HOLDER = new ManagedFieldHolder(
            PrimitiveBakingOvenMachine.class, PrimitiveWorkableMachine.MANAGED_FIELD_HOLDER);

    @Persisted
    public final NotifiableItemStackHandler fuelItems;

    public PrimitiveBakingOvenMachine(IMachineBlockEntity holder, Object... args) {
        super(holder, args);
        this.fuelItems = createFuelItemHandler();
    }

    @Override
    public ManagedFieldHolder getFieldHolder() {
        return MANAGED_FIELD_HOLDER;
    }

    @Override
    protected RecipeLogic createRecipeLogic(Object... args) {
        return new PrimitiveBakingOvenRecipeLogic(this);
    }

    @Override
    public PrimitiveBakingOvenRecipeLogic getRecipeLogic() {
        return (PrimitiveBakingOvenRecipeLogic) super.getRecipeLogic();
    }

    @Override
    protected NotifiableItemStackHandler createImportItemHandler(Object... args) {
        return new NotifiableItemStackHandler(this, 4, IO.IN, IO.NONE);
    }

    @Override
    protected NotifiableItemStackHandler createExportItemHandler(Object... args) {
        return new NotifiableItemStackHandler(this, 4, IO.OUT, IO.NONE);
    }

    protected NotifiableItemStackHandler createFuelItemHandler() {
        return new NotifiableItemStackHandler(this, 1, IO.NONE)
                .setFilter(stack -> ForgeHooks.getBurnTime(stack, RecipeType.SMELTING) > 0);
    }

    @Override
    public void onMachineRemoved() {
        super.onMachineRemoved();
        clearInventory(fuelItems.storage);
    }

    public double getProgressPercent(int slot) {
        return getRecipeLogic().getSlotProgressPercent(slot);
    }

    public double getFuelPercent() {
        return getRecipeLogic().getFuelPercent();
    }

    @Override
    public ModularUI createUI(Player entityPlayer) {
        ModularUI ui = new ModularUI(176, 166, this, entityPlayer)
                .background(GuiTextures.PRIMITIVE_BACKGROUND)
                .widget(new LabelWidget(5, 5, getBlockState().getBlock().getDescriptionId()));

        // Fuel: a vertical flame bar sitting on top of the fuel slot.
        ui.widget(new ProgressWidget(this::getFuelPercent, 6, 20, 18, 18)
                .setProgressTexture(
                        GTMFOGuiTextures.PRIMITIVE_BAKING_OVEN_FUEL_BAR.getSubTexture(0, 0, 1, 0.5),
                        GTMFOGuiTextures.PRIMITIVE_BAKING_OVEN_FUEL_BAR.getSubTexture(0, 0.5, 1, 0.5))
                .setFillDirection(ProgressTexture.FillDirection.DOWN_TO_UP));
        ui.widget(new SlotWidget(fuelItems.storage, 0, 6, 38, true, true)
                .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT));

        // Four independent input slots with a heat bar to the right of each, the matching output slots
        // on the far right.
        int[] slotX = { 30, 54, 30, 54 };
        int[] slotY = { 20, 20, 38, 38 };
        int[] heatX = { 46, 70, 46, 70 };
        for (int slot = 0; slot < 4; slot++) {
            ui.widget(new SlotWidget(importItems.storage, slot, slotX[slot], slotY[slot], true, true)
                    .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT));
            ui.widget(new SlotWidget(exportItems.storage, slot, 110 + (slot % 2) * 18, 20 + (slot / 2) * 18, true, false)
                    .setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT));
        }
        for (int slot = 0; slot < 4; slot++) {
            final int heatSlot = slot;
            ui.widget(new ProgressWidget(() -> getProgressPercent(heatSlot), heatX[slot], slotY[slot], 10, 18)
                    .setProgressTexture(
                            GTMFOGuiTextures.PRIMITIVE_BAKING_OVEN_HEAT_BAR.getSubTexture(0, 0, 1, 0.5),
                            GTMFOGuiTextures.PRIMITIVE_BAKING_OVEN_HEAT_BAR.getSubTexture(0, 0.5, 1, 0.5))
                    .setFillDirection(ProgressTexture.FillDirection.DOWN_TO_UP));
        }

        ui.widget(new ImageWidget(84,30,20,15,GuiTextures.PRIMITIVE_BLAST_FURNACE_PROGRESS_BAR.getSubTexture(0,0,1,0.5)));
        ui.widget(UITemplate.bindPlayerInventory(entityPlayer.getInventory(), GuiTextures.PRIMITIVE_SLOT, 7, 84, true));
        return ui;
    }
}
