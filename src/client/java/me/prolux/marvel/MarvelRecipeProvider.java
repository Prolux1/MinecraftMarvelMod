package me.prolux.marvel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import me.prolux.marvel.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

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
                // RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);


                offerSmelting(
                        List.of(ModItems.RAW_VIBRANIUM), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3f, // Experience
                        1600, // Cooking time
                        "raw_vibranium_to_vibranium_ingot" // group
                );

                offerBlasting(
                        List.of(ModItems.RAW_VIBRANIUM), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3f, // Experience
                        800, // Cooking time (usually half of smelting time for blasting)
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
