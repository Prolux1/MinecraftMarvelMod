package me.prolux.marvel.item.custom;

import me.prolux.marvel.util.HammerUsageEvent;
import net.fabricmc.fabric.api.item.v1.EnchantingContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class VibraniumHammer extends MiningToolItem {
    public VibraniumHammer(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, BlockTags.PICKAXE_MINEABLE, attackDamage, attackSpeed, settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient()) {
            // System.out.println("Vibranium Hammer used");
            HammerUsageEvent.incMaxHammerRange();
            return ActionResult.CONSUME;
        } else {
            return ActionResult.PASS;
        }
    }

    public static List<BlockPos> getBlocksToBeDestroyed(int range, BlockPos initalBlockPos, ServerPlayerEntity player) {
        List<BlockPos> positions = new ArrayList<>();
        HitResult hit = player.raycast(20, 0, false);
        if (hit.getType() == HitResult.Type.BLOCK) {
            BlockHitResult blockHit = (BlockHitResult) hit;

            int z_start = 0, z_end = 0;
            switch (blockHit.getSide()) {
                case DOWN, NORTH, WEST -> z_end = range;
                case UP, SOUTH, EAST -> z_start = -range;
            }

            if(blockHit.getSide() == Direction.DOWN || blockHit.getSide() == Direction.UP) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        for(int z = z_start; z <= z_end; z++) {
                            positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + z, initalBlockPos.getZ() + y));
                        }

                    }
                }
            }

            if(blockHit.getSide() == Direction.NORTH || blockHit.getSide() == Direction.SOUTH) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        for(int z = z_start; z <= z_end; z++) {
                            positions.add(new BlockPos(initalBlockPos.getX() + x, initalBlockPos.getY() + y, initalBlockPos.getZ() + z));
                        }

                    }
                }
            }

            if(blockHit.getSide() == Direction.EAST || blockHit.getSide() == Direction.WEST) {
                for(int x = -range; x <= range; x++) {
                    for(int y = -range; y <= range; y++) {
                        for(int z = z_start; z <= z_end; z++) {
                            positions.add(new BlockPos(initalBlockPos.getX() + z, initalBlockPos.getY() + y, initalBlockPos.getZ() + x));
                        }
                    }
                }
            }
        }

        return positions;
    }
}
