package me.prolux.marvel.item;

import me.prolux.marvel.Marvel;
import me.prolux.marvel.item.custom.VibraniumHammer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    // Ingredients
    public static final RegistryKey<Item> VIBRANIUM_INGOT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_ingot"));
    public static final Item VIBRANIUM_INGOT = registerItem(new Item(new Item.Settings().registryKey(VIBRANIUM_INGOT_KEY)), VIBRANIUM_INGOT_KEY);

    public static final RegistryKey<Item> RAW_VIBRANIUM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "raw_vibranium"));
    public static final Item RAW_VIBRANIUM = registerItem(new Item(new Item.Settings().registryKey(RAW_VIBRANIUM_KEY)), RAW_VIBRANIUM_KEY);  // color of Vibranium Hex = 14244d | darker Hex = 091124






    // Tools
    public static final RegistryKey<Item> VIBRANIUM_HAMMER_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_hammer"));
    public static final Item VIBRANIUM_HAMMER = registerItem(new VibraniumHammer(ModToolMaterials.VIBRANIUM_TOOL_MATERIAL, 7, -3.4f, new Item.Settings().registryKey(VIBRANIUM_HAMMER_KEY)), VIBRANIUM_HAMMER_KEY);

    public static final RegistryKey<Item> VIBRANIUM_SWORD_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_sword"));
    public static final Item VIBRANIUM_SWORD = registerItem(new SwordItem(ModToolMaterials.VIBRANIUM_TOOL_MATERIAL, 7, -3.4f, new Item.Settings().registryKey(VIBRANIUM_SWORD_KEY)), VIBRANIUM_SWORD_KEY);



    private static Item registerItem(Item item, RegistryKey<Item> registryKey) {
        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static void registerModItems() {
        Marvel.LOGGER.info("Registering Mod Items for '" + Marvel.MOD_ID + "' mod...");
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.MARVEL_ITEM_GROUP_KEY).register(entries -> {
            entries.add(VIBRANIUM_INGOT);
            entries.add(RAW_VIBRANIUM);
            entries.add(VIBRANIUM_HAMMER);
            entries.add(VIBRANIUM_SWORD);
        });
    }
}
