package me.prolux.marvel.datagen;

import me.prolux.marvel.block.ModBlocks;
import me.prolux.marvel.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class MarvelModelProvider extends FabricModelProvider {
    public MarvelModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_VIBRANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_REINFORCED_STICK, Models.HANDHELD);

        itemModelGenerator.register(ModItems.VIBRANIUM_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MJOLNIR, Models.HANDHELD_MACE);
    }
}