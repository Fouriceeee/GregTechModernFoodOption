package com.ironsword.gtmfo.common.recipe;

import com.lowdragmc.lowdraglib.utils.NBTToJsonConverter;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.minecraftforge.registries.ForgeRegistries;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class NonConsumingShapedRecipeBuilder {

    private final ResourceLocation id;
    private final ItemStack result;
    private final List<String> pattern = new ArrayList<>();
    private final Map<Character, Ingredient> keys = new LinkedHashMap<>();

    @Nullable
    private Ingredient nonConsumingIngredient;
    @Nullable
    private Character keepSymbol;

    private String group = "";
    private CraftingBookCategory category = CraftingBookCategory.MISC;
    private boolean showNotification = true;

    private NonConsumingShapedRecipeBuilder(ResourceLocation id, ItemStack result) {
        this.id = id;
        this.result = result.copy();
    }

    public static NonConsumingShapedRecipeBuilder of(ResourceLocation id, ItemStack result) {
        return new NonConsumingShapedRecipeBuilder(id, result);
    }

    public static NonConsumingShapedRecipeBuilder of(ResourceLocation id, ItemLike result) {
        return new NonConsumingShapedRecipeBuilder(id, new ItemStack(result));
    }

    public static NonConsumingShapedRecipeBuilder of(ResourceLocation id, ItemStack result, int count) {
        ItemStack stack = result.copy();
        stack.setCount(count);
        return new NonConsumingShapedRecipeBuilder(id, stack);
    }

    public NonConsumingShapedRecipeBuilder pattern(String... rows) {
        this.pattern.addAll(List.of(rows));
        return this;
    }

    public NonConsumingShapedRecipeBuilder define(char symbol, Ingredient ingredient) {
        this.keys.put(symbol, ingredient);
        return this;
    }

    public NonConsumingShapedRecipeBuilder define(char symbol, TagKey<Item> tag) {
        return define(symbol, Ingredient.of(tag));
    }

    public NonConsumingShapedRecipeBuilder define(char symbol, ItemStack stack) {
        return define(symbol, stack.hasTag() ? StrictNBTIngredient.of(stack) : Ingredient.of(stack));
    }

    public NonConsumingShapedRecipeBuilder define(char symbol, ItemLike itemLike) {
        return define(symbol, Ingredient.of(itemLike));
    }

    public NonConsumingShapedRecipeBuilder nonConsuming(char symbol) {
        this.keepSymbol = symbol;
        this.nonConsumingIngredient = null;
        return this;
    }

    public NonConsumingShapedRecipeBuilder nonConsuming(Ingredient ingredient) {
        this.nonConsumingIngredient = ingredient;
        this.keepSymbol = null;
        return this;
    }

    public NonConsumingShapedRecipeBuilder nonConsuming(TagKey<Item> tag) {
        return nonConsuming(Ingredient.of(tag));
    }

    public NonConsumingShapedRecipeBuilder nonConsuming(ItemLike itemLike) {
        return nonConsuming(Ingredient.of(itemLike));
    }

    public NonConsumingShapedRecipeBuilder group(String group) {
        this.group = group;
        return this;
    }

    public NonConsumingShapedRecipeBuilder category(CraftingBookCategory category) {
        this.category = category;
        return this;
    }

    public NonConsumingShapedRecipeBuilder showNotification(boolean showNotification) {
        this.showNotification = showNotification;
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer) {
        Ingredient keep = resolveKeepIngredient();
        validate(keep);

        consumer.accept(new FinishedRecipe() {

            @Override
            public void serializeRecipeData(JsonObject json) {
                if (!group.isEmpty()) {
                    json.addProperty("group", group);
                }
                json.addProperty("category", category.getSerializedName());

                JsonArray patternJson = new JsonArray();
                pattern.forEach(patternJson::add);
                json.add("pattern", patternJson);

                JsonObject keyJson = new JsonObject();
                keys.forEach((symbol, ingredient) -> keyJson.add(String.valueOf(symbol), ingredient.toJson()));
                json.add("key", keyJson);

                json.add("result", resultToJson(result));
                json.add("non_consuming", keep.toJson());

                if (!showNotification) {
                    json.addProperty("show_notification", false);
                }
            }

            @Override
            public ResourceLocation getId() {
                return id;
            }

            @Override
            public RecipeSerializer<?> getType() {
                return NonConsumingShapedRecipe.SERIALIZER;
            }

            @Nullable
            @Override
            public JsonObject serializeAdvancement() {
                return null;
            }

            @Nullable
            @Override
            public ResourceLocation getAdvancementId() {
                return null;
            }
        });
    }

    private Ingredient resolveKeepIngredient() {
        if (keepSymbol == null) {
            return nonConsumingIngredient;
        }
        Ingredient fromSymbol = keys.get(keepSymbol);
        if (fromSymbol == null) {
            throw new IllegalStateException(id + ": keep symbol '" + keepSymbol + "' has not been defined");
        }
        return fromSymbol;
    }

    private void validate(Ingredient keep) {
        if (result.isEmpty()) {
            throw new IllegalStateException(id + ": result is empty");
        }
        if (pattern.isEmpty()) {
            throw new IllegalStateException(id + ": no pattern has been set");
        }
        if (keep == null) {
            throw new IllegalStateException(id + ": no keep ingredient has been set");
        }

        int width = pattern.get(0).length();
        for (String row : pattern) {
            if (row.length() != width) {
                throw new IllegalStateException(id + ": pattern rows have different lengths");
            }
            for (char symbol : row.toCharArray()) {
                if (symbol != ' ' && !keys.containsKey(symbol)) {
                    throw new IllegalStateException(id + ": symbol '" + symbol + "' has not been defined");
                }
            }
        }
    }

    private static JsonObject resultToJson(ItemStack stack) {
        JsonObject json = new JsonObject();
        json.addProperty("item", ForgeRegistries.ITEMS.getKey(stack.getItem()).toString());
        if (stack.getCount() > 1) {
            json.addProperty("count", stack.getCount());
        }
        if (stack.hasTag()) {
            json.add("nbt", NBTToJsonConverter.getObject(stack.getTag()));
        }
        return json;
    }
}
