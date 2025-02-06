package me.prolux.marvel.item;

import me.prolux.marvel.Marvel;
import me.prolux.marvel.item.custom.Mjolnir;
import me.prolux.marvel.item.custom.UruCore;
import me.prolux.marvel.item.custom.VibraniumHammer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.Item;
import net.minecraft.item.MaceItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    // Ingredients for Vibranium
    public static final RegistryKey<Item> VIBRANIUM_INGOT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_ingot"));
    public static final Item VIBRANIUM_INGOT = registerItem(new Item(new Item.Settings().registryKey(VIBRANIUM_INGOT_KEY)), VIBRANIUM_INGOT_KEY);

    public static final RegistryKey<Item> RAW_VIBRANIUM_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "raw_vibranium"));
    public static final Item RAW_VIBRANIUM = registerItem(new Item(new Item.Settings().registryKey(RAW_VIBRANIUM_KEY)), RAW_VIBRANIUM_KEY);  // color of Vibranium Hex = 14244d | darker Hex = 091124

    public static final RegistryKey<Item> VIBRANIUM_NUGGET_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_nugget"));
    public static final Item VIBRANIUM_NUGGET = registerItem(new Item(new Item.Settings().registryKey(VIBRANIUM_NUGGET_KEY)), VIBRANIUM_NUGGET_KEY);

    public static final RegistryKey<Item> VIBRANIUM_REINFORCED_STICK_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_reinforced_stick"));
    public static final Item VIBRANIUM_REINFORCED_STICK = registerItem(new Item(new Item.Settings().registryKey(VIBRANIUM_REINFORCED_STICK_KEY)), VIBRANIUM_REINFORCED_STICK_KEY);

    // Ingredients for Uru
    public static final RegistryKey<Item> URU_INGOT_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "uru_ingot"));
    public static final Item URU_INGOT = registerItem(new Item(new Item.Settings().registryKey(URU_INGOT_KEY)), URU_INGOT_KEY);

    public static final RegistryKey<Item> RAW_URU_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "raw_uru"));
    public static final Item RAW_URU = registerItem(new Item(new Item.Settings().registryKey(RAW_URU_KEY)), RAW_URU_KEY);

    public static final RegistryKey<Item> URU_NUGGET_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "uru_nugget"));
    public static final Item URU_NUGGET = registerItem(new Item(new Item.Settings().registryKey(URU_NUGGET_KEY)), URU_NUGGET_KEY);

    public static final RegistryKey<Item> URU_CORE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "uru_core"));
    public static final Item URU_CORE = registerItem(new UruCore(new Item.Settings().registryKey(URU_CORE_KEY)), URU_CORE_KEY);

    public static final RegistryKey<Item> STORM_CORE_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "storm_core"));
    public static final Item STORM_CORE = registerItem(new Item(new Item.Settings().registryKey(STORM_CORE_KEY)), STORM_CORE_KEY);


    // Tools
    public static final RegistryKey<Item> VIBRANIUM_HAMMER_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "vibranium_hammer"));
    public static final Item VIBRANIUM_HAMMER = registerItem(new VibraniumHammer(ModToolMaterials.VIBRANIUM_TOOL_MATERIAL, 7, -3.4f, new Item.Settings().registryKey(VIBRANIUM_HAMMER_KEY)), VIBRANIUM_HAMMER_KEY);

    // Weapons
    public static final RegistryKey<Item> MJOLNIR_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, "mjolnir"));
    public static final Item MJOLNIR = registerItem(new Mjolnir(ModToolMaterials.URU_TOOL_MATERIAL,8, -2.8f,
                    new Item.Settings()
                            .rarity(Rarity.EPIC) // Add .repairable(URU_BLOCK)
                            .registryKey(MJOLNIR_KEY)
            ), MJOLNIR_KEY);

    private static Item registerItem(Item item, RegistryKey<Item> registryKey) {
        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static void registerModItems() {
        Marvel.LOGGER.info("Registering Mod Items for '" + Marvel.MOD_ID + "' mod...");
        ItemGroupEvents.modifyEntriesEvent(ModItemGroups.MARVEL_ITEM_GROUP_KEY).register(entries -> {
            entries.add(VIBRANIUM_INGOT);
            entries.add(RAW_VIBRANIUM);
            entries.add(VIBRANIUM_NUGGET);
            entries.add(VIBRANIUM_REINFORCED_STICK);

            entries.add(URU_INGOT);
            entries.add(RAW_URU);
            entries.add(URU_NUGGET);
            entries.add(URU_CORE);
            entries.add(STORM_CORE);

            entries.add(VIBRANIUM_HAMMER);
            entries.add(MJOLNIR);
        });
    }
}
