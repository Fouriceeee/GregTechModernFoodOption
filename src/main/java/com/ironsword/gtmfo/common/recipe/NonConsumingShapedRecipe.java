package com.ironsword.gtmfo.common.recipe;

import com.gregtechceu.gtceu.core.mixins.ShapedRecipeAccessor;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.inventory.CraftingContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class NonConsumingShapedRecipe extends ShapedRecipe {

    public static final RecipeSerializer<NonConsumingShapedRecipe> SERIALIZER = new Serializer();

    private final Ingredient nonConsumingIngredient;

    public NonConsumingShapedRecipe(ResourceLocation pId, String pGroup, CraftingBookCategory pCategory, int pWidth,
                                    int pHeight, NonNullList<Ingredient> pRecipeItems, ItemStack pResult,
                                    boolean pShowNotification, Ingredient nonConsumingIngredient) {
        super(pId, pGroup, pCategory, pWidth, pHeight, pRecipeItems, pResult, pShowNotification);
        this.nonConsumingIngredient = nonConsumingIngredient;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingContainer pContainer) {
        NonNullList<ItemStack> remainingItems = super.getRemainingItems(pContainer);
        for (int i = 0; i < remainingItems.size(); i++) {
            ItemStack stack = pContainer.getItem(i);
            if (stack.isEmpty() || !nonConsumingIngredient.test(stack)) continue;

            ItemStack keptStack = stack.copy();
            keptStack.setCount(1);
            remainingItems.set(i, keptStack);
        }
        return remainingItems;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    public static class Serializer implements RecipeSerializer<NonConsumingShapedRecipe> {

        @Override
        public NonConsumingShapedRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            String group = GsonHelper.getAsString(json, "group", "");
            CraftingBookCategory category = CraftingBookCategory.CODEC
                    .byName(GsonHelper.getAsString(json, "category", null), CraftingBookCategory.MISC);
            Map<String, Ingredient> key = ShapedRecipeAccessor
                    .callKeyFromJson(GsonHelper.getAsJsonObject(json, "key"));
            String[] pattern = ShapedRecipeAccessor
                    .callPatternFromJson(GsonHelper.getAsJsonArray(json, "pattern"));
            int width = pattern[0].length();
            int height = pattern.length;
            NonNullList<Ingredient> recipeItems = ShapedRecipeAccessor.callDissolvePattern(pattern, key, width,
                    height);
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
            boolean showNotification = GsonHelper.getAsBoolean(json, "show_notification", true);
            JsonElement nonConsumingIngredientJson = GsonHelper.getNonNull(json, "non_consuming");
            Ingredient nonConsumingIngredient = Ingredient.fromJson(nonConsumingIngredientJson);
            return new NonConsumingShapedRecipe(recipeId, group, category, width, height, recipeItems, result,
                    showNotification, nonConsumingIngredient);
        }

        @Override
        public NonConsumingShapedRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            int width = buffer.readVarInt();
            int height = buffer.readVarInt();
            String group = buffer.readUtf();
            CraftingBookCategory category = buffer.readEnum(CraftingBookCategory.class);
            NonNullList<Ingredient> recipeItems = NonNullList.withSize(width * height, Ingredient.EMPTY);
            recipeItems.replaceAll(ignored -> Ingredient.fromNetwork(buffer));
            ItemStack result = buffer.readItem();
            boolean showNotification = buffer.readBoolean();
            Ingredient nonConsumingIngredient = Ingredient.fromNetwork(buffer);
            return new NonConsumingShapedRecipe(recipeId, group, category, width, height, recipeItems, result,
                    showNotification, nonConsumingIngredient);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, NonConsumingShapedRecipe recipe) {
            buffer.writeVarInt(recipe.getWidth());
            buffer.writeVarInt(recipe.getHeight());
            buffer.writeUtf(recipe.getGroup());
            buffer.writeEnum(recipe.category());
            for (Ingredient ingredient : recipe.getIngredients()) {
                ingredient.toNetwork(buffer);
            }
            buffer.writeItem(((ShapedRecipeAccessor) recipe).getResult());
            buffer.writeBoolean(recipe.showNotification());
            recipe.nonConsumingIngredient.toNetwork(buffer);
        }
    }
}
