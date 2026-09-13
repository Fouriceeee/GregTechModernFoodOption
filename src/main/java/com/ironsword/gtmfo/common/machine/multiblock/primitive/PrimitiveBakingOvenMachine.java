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
import com.lowdragmc.lowdraglib.gui.widget.Widget;
import com.lowdragmc.lowdraglib.syncdata.annotation.Persisted;
import com.lowdragmc.lowdraglib.syncdata.field.ManagedFieldHolder;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.common.ForgeHooks;
import javax.annotation.ParametersAreNonnullByDefault;

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
        return new ModularUI(176, 166, this, entityPlayer)
                .background(GuiTextures.PRIMITIVE_BACKGROUND)
                .widget(new LabelWidget(5, 5, getBlockState().getBlock().getDescriptionId()))
                //fuel
                .widget(new ProgressWidget(this::getFuelPercent, 7, 24, 18, 18)
                        .setProgressTexture(
                                GTMFOGuiTextures.PRIMITIVE_BAKING_OVEN_FUEL_BAR.getSubTexture(0, 0, 1, 0.5),
                                GTMFOGuiTextures.PRIMITIVE_BAKING_OVEN_FUEL_BAR.getSubTexture(0, 0.5, 1, 0.5))
                        .setFillDirection(ProgressTexture.FillDirection.DOWN_TO_UP))
                .widget(new SlotWidget(fuelItems.storage, 0, 7, 42, true, true).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                //input
                .widget(new SlotWidget(importItems.storage,0,31,24,true,true).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                .widget(new SlotWidget(importItems.storage,1,55,24,true,true).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                .widget(new SlotWidget(importItems.storage,2,31,42,true,true).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                .widget(new SlotWidget(importItems.storage,3,55,42,true,true).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                //output
                .widget(new SlotWidget(exportItems.storage,0,115,24,true,false).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                .widget(new SlotWidget(exportItems.storage,1,133,24,true,false).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                .widget(new SlotWidget(exportItems.storage,2,115,42,true,false).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                .widget(new SlotWidget(exportItems.storage,3,133,42,true,false).setBackgroundTexture(GuiTextures.PRIMITIVE_SLOT))
                //heat bar
                .widget(heatWidget(0,49,24))
                .widget(heatWidget(1,73,24))
                .widget(heatWidget(2,49,42))
                .widget(heatWidget(3,73,42))
                .widget(new ImageWidget(87,34,20,15,GuiTextures.PRIMITIVE_BLAST_FURNACE_PROGRESS_BAR.getSubTexture(0,0,1,0.5)))
                .widget(UITemplate.bindPlayerInventory(entityPlayer.getInventory(), GuiTextures.PRIMITIVE_SLOT, 7, 84, true));
    }

    private Widget heatWidget(int slot, int x, int y){
        return new ProgressWidget(() -> getProgressPercent(slot), x, y, 6, 18)
                .setProgressTexture(
                        GTMFOGuiTextures.PRIMITIVE_BAKING_OVEN_HEAT_BAR.getSubTexture(0, 0, 1, 0.5),
                        GTMFOGuiTextures.PRIMITIVE_BAKING_OVEN_HEAT_BAR.getSubTexture(0, 0.5, 1, 0.5))
                .setFillDirection(ProgressTexture.FillDirection.DOWN_TO_UP);
    }
}
