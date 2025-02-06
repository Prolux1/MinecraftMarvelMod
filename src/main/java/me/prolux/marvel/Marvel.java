package me.prolux.marvel;

import me.prolux.marvel.block.ModBlocks;
import me.prolux.marvel.item.ModItemGroups;
import me.prolux.marvel.item.ModItems;
import me.prolux.marvel.util.HammerUsageEvent;
import me.prolux.marvel.world.gen.ModWorldGeneration;
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

    @Override
    public void onInitialize() {
        LOGGER.info("'" + MOD_ID + "' mod is starting...");
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModItemGroups.registerItemGroups();
        ModWorldGeneration.generateModWorldGen();

        // Hammer Event registering
        PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
    }
}
