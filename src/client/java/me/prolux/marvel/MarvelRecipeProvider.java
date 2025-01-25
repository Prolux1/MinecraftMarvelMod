package me.prolux.marvel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import me.prolux.marvel.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class MarvelRecipeProvider extends FabricRecipeProvider {
    public MarvelRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);


                offerSmelting(
                        List.of(ModItems.RAW_VIBRANIUM), // Inputs
                        RecipeCategory.FOOD, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3, // Experience
                        1600, // Cooking time
                        "raw_vibranium_to_vibranium_ingot" // group
                );
            }
        };
    }

    @Override
    public String getName() {
        return "MarvelRecipeProvider";
    }
}
