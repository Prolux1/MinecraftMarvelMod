package me.prolux.marvel.item.custom;

import me.prolux.marvel.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class UruCore extends Item {
    public UruCore(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient()) {
            if (entity instanceof CreeperEntity creeper) {
                if (creeper.isCharged()) {
                    user.giveItemStack(new ItemStack(ModItems.STORM_CORE));

                    ItemStack stack_in_hand = user.getStackInHand(hand);
                    stack_in_hand.setCount(stack_in_hand.getCount() - 1);

                    // Remove the charged state using NBT
                    NbtCompound nbt = new NbtCompound();
                    creeper.writeNbt(nbt);
                    nbt.putBoolean("powered", false); // "powered" is the tag for charged creepers
                    creeper.readNbt(nbt);

                    return ActionResult.SUCCESS;
                }
            }
        }
        return ActionResult.PASS;
    }
}
