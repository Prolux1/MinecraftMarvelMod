package me.prolux.marvel.world;

import me.prolux.marvel.Marvel;
import me.prolux.marvel.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIBRANIUM_ORE_KEY = registerKey("ore_vibranium");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_URU_ORE_KEY = registerKey("end_uru_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest deepslate_replaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest end_replaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworld_vibranium_ores =
                List.of(OreFeatureConfig.createTarget(deepslate_replaceables, ModBlocks.DEEPSLATE_VIBRANIUM_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> end_uru_ores =
                List.of(OreFeatureConfig.createTarget(end_replaceables, ModBlocks.END_URU_ORE.getDefaultState()));

        register(context, VIBRANIUM_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworld_vibranium_ores, 5));
        register(context, END_URU_ORE_KEY, Feature.ORE, new OreFeatureConfig(end_uru_ores, 4));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Marvel.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}