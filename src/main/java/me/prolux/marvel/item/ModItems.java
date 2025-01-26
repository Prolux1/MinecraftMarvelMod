package me.prolux.marvel.item;

import me.prolux.marvel.Marvel;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final RegistryKey<Item> VIBRANIUM_INGOT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_ingot"));
    public static final Item VIBRANIUM_INGOT = registerItem(new Item(new Item.Settings().registryKey(VIBRANIUM_INGOT_KEY)), VIBRANIUM_INGOT_KEY);

    public static final RegistryKey<Item> RAW_VIBRANIUM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "raw_vibranium"));
    public static final Item RAW_VIBRANIUM = registerItem(new Item(new Item.Settings().registryKey(RAW_VIBRANIUM_KEY)), RAW_VIBRANIUM_KEY);

    private static Item registerItem(Item item, RegistryKey<Item> registryKey) {
        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static void registerModItems() {
        Marvel.LOGGER.info("Registering Mod Items for '" + Marvel.MOD_ID + "' mod...");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(VIBRANIUM_INGOT);
            entries.add(RAW_VIBRANIUM);
        });
    }
}
