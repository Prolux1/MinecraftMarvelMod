package me.prolux.marvel.block;

import me.prolux.marvel.Marvel;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final RegistryKey<Block> VIBRANIUM_BLOCK_KEY = RegistryKey.of(
            RegistryKeys.BLOCK,
            Identifier.of(Marvel.MOD_ID, "vibranium_block")
    );
    public static final Block VIBRANIUM_BLOCK = registerBlock(
            new Block(AbstractBlock.Settings.create().strength(100f, 2400f).requiresTool().registryKey(VIBRANIUM_BLOCK_KEY).sounds(BlockSoundGroup.NETHERITE)),
            VIBRANIUM_BLOCK_KEY,
            true
    );


    public static Block registerBlock(Block block, RegistryKey<Block> blockKey, boolean shouldRegisterItem) {
        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    public static void registerModBlocks() {
        Marvel.LOGGER.info("Registering Mod Blocks for '" + Marvel.MOD_ID + "' mod...");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(VIBRANIUM_BLOCK.asItem());
        });
    }
}
