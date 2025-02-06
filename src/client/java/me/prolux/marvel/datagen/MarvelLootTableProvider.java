package me.prolux.marvel.datagen;

import me.prolux.marvel.block.ModBlocks;
import me.prolux.marvel.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MarvelLootTableProvider extends FabricBlockLootTableProvider {
    public MarvelLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.VIBRANIUM_BLOCK);
        addDrop(ModBlocks.URU_BLOCK);

        addDrop(ModBlocks.DEEPSLATE_VIBRANIUM_ORE, oreDrops(ModBlocks.DEEPSLATE_VIBRANIUM_ORE, ModItems.RAW_VIBRANIUM));
    }
}
