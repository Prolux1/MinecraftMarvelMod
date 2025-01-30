package me.prolux.marvel;

import me.prolux.marvel.block.ModBlocks;
import me.prolux.marvel.item.ModItemGroups;
import me.prolux.marvel.item.ModItems;
import me.prolux.marvel.util.HammerUsageEvent;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Marvel implements ModInitializer {
    public static final String MOD_ID = "marvel";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Vibranium Ore Generation Key
    public static final RegistryKey<PlacedFeature> VIBRANIUM_ORE_PLACED_KEY = RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID,"ore_vibranium"));

    @Override
    public void onInitialize() {
        LOGGER.info("'" + MOD_ID + "' mod is starting...");
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();

        // Vibranium Ore Generation Feature
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, VIBRANIUM_ORE_PLACED_KEY);

        // Hammer Event registering
        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
    }
}
