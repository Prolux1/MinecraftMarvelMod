package me.prolux.marvel;

import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldSetModelCallback;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;

public class MarvelClient implements ClientModInitializer {
    public static final EntityModelLayer CAPTAIN_AMERICAS_SHIELD_MODEL_LAYER = new EntityModelLayer(Identifier.of(Marvel.MOD_ID, "captain_americas_shield"),"main");
    public static ShieldEntityModel CAPTAIN_AMERICAS_SHIELD_MODEL;

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(CAPTAIN_AMERICAS_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);

        ShieldSetModelCallback.EVENT.register((loader) -> {
            CAPTAIN_AMERICAS_SHIELD_MODEL = new ShieldEntityModel(loader.getModelPart(CAPTAIN_AMERICAS_SHIELD_MODEL_LAYER));
            return ActionResult.PASS;
        });
    }
}
