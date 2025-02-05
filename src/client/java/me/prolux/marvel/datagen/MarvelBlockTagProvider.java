package me.prolux.marvel.datagen;

import me.prolux.marvel.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class MarvelBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public MarvelBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
        ;

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_WOODEN_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
        ;
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
        ;
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
        ;
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
        ;
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .add(ModBlocks.VIBRANIUM_BLOCK)
                .add(ModBlocks.DEEPSLATE_VIBRANIUM_ORE)
        ;
    }
}