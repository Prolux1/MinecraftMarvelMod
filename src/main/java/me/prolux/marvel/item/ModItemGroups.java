package me.prolux.marvel.item;

import me.prolux.marvel.Marvel;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final RegistryKey<ItemGroup> MARVEL_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Marvel.MOD_ID, "item_group"));
    public static final ItemGroup MARVEL_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.VIBRANIUM_INGOT))
            .displayName(Text.translatable("itemGroup.marvel"))
            .build();

    public static void registerItemGroups() {
        Marvel.LOGGER.info("Registering Mod Item Groups for '" + Marvel.MOD_ID + "' mod...");
        Registry.register(Registries.ITEM_GROUP, MARVEL_ITEM_GROUP_KEY, MARVEL_ITEM_GROUP);
    }
}
