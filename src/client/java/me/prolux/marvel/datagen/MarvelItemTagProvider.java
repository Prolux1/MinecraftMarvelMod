package me.prolux.marvel.datagen;


import me.prolux.marvel.item.ModItems;
import me.prolux.marvel.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class MarvelItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public MarvelItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.VIBRANIUM_TOOL_MATERIALS)
                .add(ModItems.VIBRANIUM_HAMMER)
        ;

        getOrCreateTagBuilder(ModTags.Items.URU_TOOL_MATERIALS)
                .add(ModItems.MJOLNIR)
        ;

        getOrCreateTagBuilder(ItemTags.PICKAXES)  // make enchants for pickaxes applicable to the hammer
                .add(ModItems.VIBRANIUM_HAMMER)
        ;

        getOrCreateTagBuilder(ItemTags.DURABILITY_ENCHANTABLE)  // adds unbreaking enchants possible
                .add(ModItems.MJOLNIR)
        ;
    }
}