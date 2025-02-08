package me.prolux.marvel.item;

import me.prolux.marvel.Marvel;
import me.prolux.marvel.item.custom.CaptainAmericasShield;
import me.prolux.marvel.item.custom.Mjolnir;
import me.prolux.marvel.item.custom.UruCore;
import me.prolux.marvel.item.custom.VibraniumHammer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    // Ingredients for Vibranium
    public static final Item VIBRANIUM_INGOT = registerBasicItem("vibranium_ingot");
    public static final Item RAW_VIBRANIUM = registerBasicItem("raw_vibranium");  // color of Vibranium Hex = 14244d | darker Hex = 091124
    public static final Item VIBRANIUM_NUGGET = registerBasicItem("vibranium_nugget");
    public static final Item VIBRANIUM_REINFORCED_STICK = registerBasicItem("vibranium_reinforced_stick");

    // Ingredients for Uru
    public static final Item URU_INGOT = registerBasicItem("uru_ingot");
    public static final Item RAW_URU = registerBasicItem("raw_uru");
    public static final Item URU_NUGGET = registerBasicItem("uru_nugget");
    public static final RegistryKey<Item> URU_CORE_KEY = registerKey("uru_core");
    public static final Item URU_CORE = registerItem(new UruCore(new Item.Settings().registryKey(URU_CORE_KEY)), URU_CORE_KEY);
    public static final Item STORM_CORE = registerBasicItem("storm_core");

    // Tools
    public static final RegistryKey<Item> VIBRANIUM_HAMMER_KEY = registerKey("vibranium_hammer");
    public static final Item VIBRANIUM_HAMMER = registerItem(new VibraniumHammer(ModToolMaterials.VIBRANIUM_TOOL_MATERIAL, 7, -3.4f,
            new Item.Settings().registryKey(VIBRANIUM_HAMMER_KEY)), VIBRANIUM_HAMMER_KEY);

    // Weapons
    public static final RegistryKey<Item> MJOLNIR_KEY = registerKey("mjolnir");
    public static final Item MJOLNIR = registerItem(new Mjolnir(ModToolMaterials.URU_TOOL_MATERIAL,8, -2.8f,
                    new Item.Settings()
                            .rarity(Rarity.EPIC) // Add .repairable(URU_BLOCK)
                            .registryKey(MJOLNIR_KEY)
            ), MJOLNIR_KEY);

    // Shields
    public static final RegistryKey<Item> CAPTAIN_AMERICAS_SHIELD_KEY = registerKey("captain_americas_shield");
    public static final Item CAPTAIN_AMERICAS_SHIELD = registerItem(new CaptainAmericasShield(
            new Item.Settings()
                    .rarity(Rarity.EPIC) // Add .repairable(URU_BLOCK)
                    .registryKey(CAPTAIN_AMERICAS_SHIELD_KEY), 10, ModToolMaterials.VIBRANIUM_TOOL_MATERIAL
    ), CAPTAIN_AMERICAS_SHIELD_KEY);


    private static RegistryKey<Item> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Marvel.MOD_ID, name));
    }

    private static Item registerBasicItem(String name) {
        RegistryKey<Item> item_key = registerKey(name);
        return registerItem(new Item(new Item.Settings().registryKey(item_key)), item_key);
    }

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

            entries.add(CAPTAIN_AMERICAS_SHIELD);
        });
    }
}
