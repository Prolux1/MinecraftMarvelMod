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

                // Raw Vibranium -> Vibranium Ingot (in standard furnace and blast furnace)
                offerSmeltingAndBlasting(
                        List.of(ModItems.RAW_VIBRANIUM), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3.0F, // Experience
                        1600, // Cooking time
                        "raw_vibranium_to_vibranium_ingot" // group
                );

                // 1 Deepslate Vibranium Ore -> 1 Raw Vibranium (in standard furnace and blast furnace)
                offerSmeltingAndBlasting(
                        List.of(ModBlocks.DEEPSLATE_VIBRANIUM_ORE), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.VIBRANIUM_INGOT, // Output
                        3.0F, // Experience
                        1600, // Cooking time
                        "deepslate_vibranium_ore_to_vibranium_ingot" // group
                );

                // Raw Uru -> Uru Ingot (in standard furnace and blast furnace)
                offerSmeltingAndBlasting(
                        List.of(ModItems.RAW_URU), // Inputs
                        RecipeCategory.MISC, // Category
                        ModItems.URU_INGOT, // Output
                        4.5F, // Experience
                        2400, // Cooking time
                        "raw_uru_to_uru_ingot" // group
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

                // Conversion between Uru Block -> Uru Ingot -> Uru Nugget
                offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        ModItems.URU_INGOT,
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.URU_BLOCK,
                        "uru_block",
                        null,
                        "uru_ingot_from_uru_block",
                        null
                );
                offerReversibleCompactingRecipes(
                        RecipeCategory.MISC,
                        ModItems.URU_NUGGET,
                        RecipeCategory.MISC,
                        ModItems.URU_INGOT,
                        "uru_ingot_from_nuggets",
                        null,
                        "uru_nugget",
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

                // Uru Core recipe
                createShaped(RecipeCategory.MISC, ModItems.URU_CORE, 1)
                        .pattern(" u ")
                        .pattern("u u")
                        .pattern(" u ")
                        .input('u', ModItems.URU_INGOT)
                        .group("uru_core")
                        .criterion(hasItem(ModItems.URU_INGOT), conditionsFromItem(ModItems.URU_INGOT))
                        .offerTo(exporter);

                // Mjollnir recipe
                createShaped(RecipeCategory.COMBAT, ModItems.MJOLNIR, 1)
                        .pattern("BCB")
                        .pattern(" l ")
                        .pattern(" l ")
                        .input('B', ModBlocks.URU_BLOCK)
                        .input('C', ModItems.STORM_CORE)
                        .input('l', ModItems.VIBRANIUM_REINFORCED_STICK)
                        .group("mjolnir")
                        .criterion(hasItem(ModBlocks.URU_BLOCK), conditionsFromItem(ModBlocks.URU_BLOCK))
                        .criterion(hasItem(ModItems.STORM_CORE), conditionsFromItem(ModItems.STORM_CORE))
                        .criterion(hasItem(ModItems.VIBRANIUM_REINFORCED_STICK), conditionsFromItem(ModItems.VIBRANIUM_REINFORCED_STICK))
                        .offerTo(exporter);

                // Captain America's Shield Recipe
                createShaped(RecipeCategory.COMBAT, ModItems.CAPTAIN_AMERICAS_SHIELD, 1)
                        .pattern(" V ")
                        .pattern("VNV")
                        .pattern(" V ")
                        .input('V', ModItems.VIBRANIUM_INGOT)
                        .input('N', Items.NETHER_STAR)
                        .group("captain_americas_shield")
                        .criterion(hasItem(ModItems.VIBRANIUM_INGOT), conditionsFromItem(ModItems.VIBRANIUM_INGOT))
                        .criterion(hasItem(Items.NETHER_STAR), conditionsFromItem(Items.NETHER_STAR))
                        .offerTo(exporter);
            }

            private void offerSmeltingAndBlasting(java.util.List<net.minecraft.item.ItemConvertible> inputs,
                                                  net.minecraft.recipe.book.RecipeCategory category,
                                                  net.minecraft.item.ItemConvertible output,
                                                  float experience, int cookingTime, String group) {
                offerSmelting(inputs, category, output, experience, cookingTime, group);
                offerBlasting(inputs, category, output, experience, cookingTime / 2, group);
            }
        };
    }

    @Override
    public String getName() {
        return "MarvelRecipeProvider";
    }
}
