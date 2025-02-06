package me.prolux.marvel.block;

import me.prolux.marvel.Marvel;
import me.prolux.marvel.block.custom.DeepslateVibraniumOre;
import me.prolux.marvel.item.ModItemGroups;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final RegistryKey<Block> VIBRANIUM_BLOCK_KEY = registerKey("vibranium_block");
    public static final Block VIBRANIUM_BLOCK = registerBlock(
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.LAPIS_BLUE)
                            .strength(100.0F, 2400.0F)
                            .requiresTool()
                            .registryKey(VIBRANIUM_BLOCK_KEY)
                            .sounds(BlockSoundGroup.NETHERITE)
            ),
            VIBRANIUM_BLOCK_KEY,
            true
    );

    public static final RegistryKey<Block> DEEPSLATE_VIBRANIUM_ORE_KEY = registerKey("deepslate_vibranium_ore");
    public static final Block DEEPSLATE_VIBRANIUM_ORE = registerBlock(
            new DeepslateVibraniumOre(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DEEPSLATE_GRAY)
                            .strength(60.0F, 2400.0F)
                            .requiresTool()
                            .registryKey(DEEPSLATE_VIBRANIUM_ORE_KEY)
                            .sounds(BlockSoundGroup.DEEPSLATE)
            ),
            DEEPSLATE_VIBRANIUM_ORE_KEY,
            true
    );




    public static final RegistryKey<Block> URU_BLOCK_KEY = registerKey("uru_block");
    public static final Block URU_BLOCK = registerBlock(
            new Block(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.IRON_GRAY)
                            .strength(150.0F, 3600.0F)
                            .requiresTool()
                            .registryKey(URU_BLOCK_KEY)
                            .sounds(BlockSoundGroup.METAL)
            ),
            URU_BLOCK_KEY,
            true
    );

    public static final RegistryKey<Block> END_URU_ORE_KEY = registerKey("end_uru_ore");
    public static final Block END_URU_ORE = registerBlock(
            new DeepslateVibraniumOre(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.PALE_YELLOW)
                            .strength(90.0F, 3600.0F)
                            .requiresTool()
                            .registryKey(END_URU_ORE_KEY)
            ),
            END_URU_ORE_KEY,
            true
    );

    private static RegistryKey<Block> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Marvel.MOD_ID, name));
    }


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
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.MARVEL_ITEM_GROUP_KEY).register(entries -> {
            entries.add(VIBRANIUM_BLOCK.asItem());
            entries.add(DEEPSLATE_VIBRANIUM_ORE.asItem());

            entries.add(URU_BLOCK.asItem());
            entries.add(END_URU_ORE.asItem());
        });
    }
}
