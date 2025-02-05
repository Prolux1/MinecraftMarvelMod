package me.prolux.marvel.item;

import me.prolux.marvel.util.ModTags;
import net.minecraft.item.ToolMaterial;

public class ModToolMaterials {
    public static final ToolMaterial VIBRANIUM_TOOL_MATERIAL = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_VIBRANIUM_TOOL,
            3046,  // 3046
            19.0F,
            7.0F,
            22,
            ModTags.Items.VIBRANIUM_TOOL_MATERIALS
    );

    public static final ToolMaterial URU_TOOL_MATERIAL = new ToolMaterial(
            ModTags.Blocks.INCORRECT_FOR_URU_TOOL,
            4569,  // 1.5 times better than vibranium
            21.0F,
            10.0F,
            33,
            ModTags.Items.URU_TOOL_MATERIALS
    );
}
