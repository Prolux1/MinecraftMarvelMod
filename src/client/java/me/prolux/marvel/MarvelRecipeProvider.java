package me.prolux.marvel;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import me.prolux.marvel.block.ModBlocks;
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

                // Raw Vibranium -> Vibranium Ingot in standard furnace
                offerSmelting(
                        List.of(ModItems.RAW_VIBRANIUM), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3f, // Experience
                        1600, // Cooking time
                        "raw_vibranium_to_vibranium_ingot" // group
                );

                // Raw Vibranium -> Vibranium Ingot in blast furnace
                offerBlasting(
                        List.of(ModItems.RAW_VIBRANIUM), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3f, // Experience
                        800, // Cooking time (usually half of smelting time for blasting)
                        "raw_vibranium_to_vibranium_ingot" // group
                );

                // 9 Vibranium Ingots -> 1 Block of Vibranium
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.VIBRANIUM_BLOCK, 1)
                        .pattern("###")
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModItems.VIBRANIUM_INGOT) // '#' means a Vibranium Ingot
                        .group("vibranium_conversion")
                        .criterion(hasItem(ModItems.VIBRANIUM_INGOT), conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .offerTo(exporter);

                // 1 Block of Vibranium -> 9 Vibranium Ingots
                createShapeless(RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT, 9)
                        .input(ModBlocks.VIBRANIUM_BLOCK)
                        .group("vibranium_conversion")
                        .criterion(hasItem(ModBlocks.VIBRANIUM_BLOCK), conditionsFromItem(ModBlocks.VIBRANIUM_BLOCK))  // Create an advancement that gives you the recipe
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "MarvelRecipeProvider";
    }
}
