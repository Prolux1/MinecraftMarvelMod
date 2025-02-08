package me.prolux.marvel.datagen;

import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLib;
import com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient;
import com.github.crimsondawn45.fabricshieldlib.lib.config.FabricShieldLibConfig;
import com.github.crimsondawn45.fabricshieldlib.lib.config.FabricShieldLibModMenuIntegration;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldModelComponent;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldModelRenderer;
import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldUtils;
import me.prolux.marvel.Marvel;
import me.prolux.marvel.block.ModBlocks;
import me.prolux.marvel.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.render.item.model.special.ShieldModelRenderer;
import net.minecraft.client.render.item.property.bool.BooleanProperties;
import net.minecraft.client.render.item.property.bool.BooleanProperty;
import net.minecraft.client.render.item.property.bool.UsingItemProperty;
import net.minecraft.util.Identifier;

public class MarvelModelProvider extends FabricModelProvider {
    public MarvelModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VIBRANIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_VIBRANIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URU_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_URU_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAW_VIBRANIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.VIBRANIUM_REINFORCED_STICK, Models.HANDHELD);

        itemModelGenerator.register(ModItems.RAW_URU, Models.GENERATED);
        itemModelGenerator.register(ModItems.URU_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.URU_NUGGET, Models.GENERATED);
        itemModelGenerator.register(ModItems.URU_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STORM_CORE, Models.GENERATED);

        itemModelGenerator.register(ModItems.VIBRANIUM_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.MJOLNIR, Models.HANDHELD_MACE);
    }
}