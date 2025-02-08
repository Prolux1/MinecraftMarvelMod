package me.prolux.marvel.item.custom;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.minecraft.item.Item;
import net.minecraft.registry.entry.RegistryEntryList;
import org.jetbrains.annotations.Nullable;

public class CaptainAmericasShield extends FabricShieldItem {
    public CaptainAmericasShield(Settings settings, int coolDownTicks, int enchantability, @Nullable RegistryEntryList<Item> repairItems) {
        super(settings, coolDownTicks, enchantability, repairItems);
    }
}
