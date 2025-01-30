package me.prolux.marvel;

import me.prolux.marvel.datagen.MarvelBlockTagProvider;
import me.prolux.marvel.datagen.MarvelItemTagProvider;
import me.prolux.marvel.datagen.MarvelModelProvider;
import me.prolux.marvel.datagen.MarvelRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MarvelDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(MarvelRecipeProvider::new);
        pack.addProvider(MarvelItemTagProvider::new);
        pack.addProvider(MarvelBlockTagProvider::new);
        pack.addProvider(MarvelModelProvider::new);
    }
}
