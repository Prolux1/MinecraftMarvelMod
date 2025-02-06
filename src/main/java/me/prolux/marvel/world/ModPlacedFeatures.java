package me.prolux.marvel.world;

import me.prolux.marvel.Marvel;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> VIBRANIUM_ORE_PLACED_KEY = registerKey("ore_vibranium");
    public static final RegistryKey<PlacedFeature> END_URU_ORE_PLACED_KEY = registerKey("end_uru_ore");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, VIBRANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VIBRANIUM_ORE_KEY),
                List.of(CountPlacementModifier.of(4), SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(-50)), BiomePlacementModifier.of()));

        register(context, END_URU_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_URU_ORE_KEY),
                List.of(CountPlacementModifier.of(4), SquarePlacementModifier.of(),
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-80), YOffset.fixed(80)), BiomePlacementModifier.of()));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(Marvel.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}