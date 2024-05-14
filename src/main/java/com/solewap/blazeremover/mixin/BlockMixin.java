package com.solewap.blazeremover.mixin;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Blaze;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlazeBurnerBlock.class)
public class BlockMixin {

    @Inject(at = @At("HEAD"),method = "use", cancellable = true)
    public void unblazesYourBlazeBurner(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult blockRayTraceResult, CallbackInfoReturnable<InteractionResult> cir) {
        if (!world.isClientSide() && hand == InteractionHand.MAIN_HAND) {

            if (state.getValue(BlazeBurnerBlock.HEAT_LEVEL) != BlazeBurnerBlock.HeatLevel.NONE) {
                ItemStack item = player.getInventory().getSelected();
                if (Items.SHEARS == item.getItem()) {
                    item.hurtAndBreak(1, player, (p_186374_) -> {
                        p_186374_.broadcastBreakEvent(hand);
                    });
                    Blaze blaze = new Blaze(EntityType.BLAZE, world);
                    Vec3 blazePos = new Vec3(pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5);
                    blaze.setPos(blazePos);
                    world.addFreshEntity(blaze);
                    BlockState newBlaze =  AllBlocks.BLAZE_BURNER.getDefaultState()
                            .setValue(BlazeBurnerBlock.HEAT_LEVEL, BlazeBurnerBlock.HeatLevel.NONE)
                            .setValue(BlazeBurnerBlock.FACING, state.getValue(BlazeBurnerBlock.FACING));
                    world.removeBlockEntity(pos);
                    world.setBlock(pos,newBlaze,0);
                }
            }

        }
        if (hand == InteractionHand.MAIN_HAND) {
            if (state.getValue(BlazeBurnerBlock.HEAT_LEVEL) != BlazeBurnerBlock.HeatLevel.NONE) {
                ItemStack item = player.getInventory().getSelected();
                if (Items.SHEARS == item.getItem()) {
                    cir.setReturnValue(InteractionResult.SUCCESS);
                }
            }

        }
    }

}
