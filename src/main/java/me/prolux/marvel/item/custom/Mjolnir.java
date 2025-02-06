package me.prolux.marvel.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class Mjolnir extends SwordItem {
    public Mjolnir(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient()) {
            // Raycast to find where the player is looking (max range of 50 blocks)
            HitResult hitResult = user.raycast(50, 0.0F, false);

            // Get the position the player is looking at
            Vec3d hitPos = hitResult.getPos();

            // Create lightning at the target position
            LightningEntity lightning_bolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
            lightning_bolt.setPos(hitPos.x, hitPos.y, hitPos.z);

            // Spawn the lightning bolt in the world
            world.spawnEntity(lightning_bolt);

            // Damage the item (10 durability point)
            user.getStackInHand(hand).damage(10, user);

            return ActionResult.SUCCESS;
        } else {
            return ActionResult.PASS;
        }
    }
}
