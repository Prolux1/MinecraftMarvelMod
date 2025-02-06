package me.prolux.marvel;

import me.prolux.marvel.datagen.*;
import me.prolux.marvel.world.ModConfiguredFeatures;
import me.prolux.marvel.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MarvelDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(MarvelRecipeProvider::new);
        pack.addProvider(MarvelItemTagProvider::new);
        pack.addProvider(MarvelBlockTagProvider::new);
        pack.addProvider(MarvelModelProvider::new);
        pack.addProvider(MarvelLootTableProvider::new);
        pack.addProvider(MarvelDynamicRegistryProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
