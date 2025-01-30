package me.prolux.marvel.util;

import me.prolux.marvel.Marvel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_VIBRANIUM_TOOL = TagKey.of(RegistryKeys.BLOCK, Identifier.of(Marvel.MOD_ID, "incorrect_for_vibranium_tool"));
    }

    public static class Items {
        public static final TagKey<Item> VIBRANIUM_TOOL_MATERIALS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_tool_materials"));
    }
}