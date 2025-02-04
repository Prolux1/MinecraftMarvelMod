package me.prolux.marvel.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import me.prolux.marvel.block.ModBlocks;
import me.prolux.marvel.item.ModItems;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
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

                // Raw Vibranium -> Vibranium Ingot (in standard furnace)
                offerSmelting(
                        List.of(ModItems.RAW_VIBRANIUM), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3.0F, // Experience
                        1600, // Cooking time
                        "raw_vibranium_to_vibranium_ingot" // group
                );

                // Raw Vibranium -> Vibranium Ingot (in blast furnace)
                offerBlasting(
                        List.of(ModItems.RAW_VIBRANIUM), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3.0F, // Experience
                        800, // Cooking time (usually half of smelting time for blasting)
                        "raw_vibranium_to_vibranium_ingot" // group
                );

                // 1 Deepslate Vibranium Ore -> 1 Raw Vibranium (in standard furnace)
                offerSmelting(
                        List.of(ModBlocks.DEEPSLATE_VIBRANIUM_ORE), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3.0F, // Experience
                        1600, // Cooking time
                        "deepslate_vibranium_ore_to_vibranium_ingot" // group
                );

                // 1 Deepslate Vibranium Ore -> 1 Raw Vibranium (in blast furnace)
                offerBlasting(
                        List.of(ModBlocks.DEEPSLATE_VIBRANIUM_ORE), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3.0F, // Experience
                        800, // Cooking time (usually half of smelting time for blasting)
                        "deepslate_vibranium_ore_to_vibranium_ingot" // group
                );

                // Conversion between Vibranium Block -> Vibranium Ingot -> Vibranium Nugget
                offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        ModItems.VIBRANIUM_INGOT,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.VIBRANIUM_BLOCK,
                        "vibranium_block",
                        null,
                        "vibranium_ingot_from_vibranium_block",
                        null
                );
                offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        ModItems.VIBRANIUM_NUGGET,
                        RecipeCategory.MISC, ModItems.VIBRANIUM_INGOT,
                        "vibranium_ingot_from_nuggets",
                        null,
                        "vibranium_nugget",
                        null
                );




                // Vibranium Reinforced Stick recipe
                createShaped(RecipeCategory.MISC, ModItems.VIBRANIUM_REINFORCED_STICK, 1)
                        .pattern(" o ")
                        .pattern("olo")
                        .pattern(" o ")
                        .input('o', ModItems.VIBRANIUM_NUGGET)
                        .input('l', Items.STICK)
                        .group("vibranium_reinforced_stick")
                        .criterion(hasItem(ModItems.VIBRANIUM_NUGGET), conditionsFromItem(ModItems.VIBRANIUM_NUGGET))
                        .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                        .offerTo(exporter);


                // Vibranium Hammer recipe
                createShaped(RecipeCategory.TOOLS, ModItems.VIBRANIUM_HAMMER, 1)
                        .pattern("BBB")
                        .pattern(" l ")
                        .pattern(" l ")
                        .input('B', ModBlocks.VIBRANIUM_BLOCK)
                        .input('l', ModItems.VIBRANIUM_REINFORCED_STICK)
                        .group("vibranium_hammer")
                        .criterion(hasItem(ModBlocks.VIBRANIUM_BLOCK), conditionsFromItem(ModBlocks.VIBRANIUM_BLOCK))
                        .criterion(hasItem(ModItems.VIBRANIUM_REINFORCED_STICK), conditionsFromItem(ModItems.VIBRANIUM_REINFORCED_STICK))
                        .offerTo(exporter);



            }
        };
    }

    @Override
    public String getName() {
        return "MarvelRecipeProvider";
    }
}
