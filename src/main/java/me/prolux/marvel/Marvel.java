package me.prolux.marvel;

import me.prolux.marvel.block.ModBlocks;
import me.prolux.marvel.item.ModItems;
import net.fabricmc.api.ModInitializer;
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
    }
}
