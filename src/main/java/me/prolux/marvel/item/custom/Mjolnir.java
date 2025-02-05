package me.prolux.marvel.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.MaceItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;

public class Mjolnir extends SwordItem {
    public Mjolnir(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient()) {
            //context.getWorld().spawnEntity(EntityType.LIGHTNING_BOLT)
            return ActionResult.CONSUME;
        } else {
            return ActionResult.PASS;
        }
    }
}
