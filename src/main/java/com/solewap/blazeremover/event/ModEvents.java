package com.solewap.blazeremover.event;

import com.solewap.blazeremover.CreateHelp;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = CreateHelp.MODID)
public class ModEvents {




    @SubscribeEvent
    public static void fuckYouUnblazesYourBlazeBurner(PlayerInteractEvent.RightClickBlock event) {
        /*
        Player player = event.getEntity();
        BlockState block = event.getEntity().getLevel().getBlockState(event.getPos());
        if (!event.getLevel().isClientSide() && event.getHand() == InteractionHand.MAIN_HAND) {
            if (block.getBlock() instanceof BlazeBurnerBlock) {
                if (block.getValue(BlazeBurnerBlock.HEAT_LEVEL) != BlazeBurnerBlock.HeatLevel.NONE) {
                    ItemStack item = player.getInventory().getSelected();
                    if (Items.SHEARS == item.getItem()) {
                        item.hurtAndBreak(1, player, (p_186374_) -> {
                            p_186374_.broadcastBreakEvent(event.getHand());
                        });
                        Blaze blaze = new Blaze(EntityType.BLAZE, event.getLevel());
                        Vec3 blazePos = new Vec3(event.getPos().getX() + 0.5, event.getPos().getY() + 1, event.getPos().getZ() + 0.5);
                        blaze.setPos(blazePos);
                        event.getLevel().addFreshEntity(blaze);
                        BlockState newBlaze =  AllBlocks.BLAZE_BURNER.getDefaultState()
                                .setValue(BlazeBurnerBlock.HEAT_LEVEL, BlazeBurnerBlock.HeatLevel.NONE)
                                .setValue(BlazeBurnerBlock.FACING, block.getValue(BlazeBurnerBlock.FACING));
                        event.getLevel().removeBlockEntity(event.getPos());
                        event.getLevel().setBlock(event.getPos(),newBlaze,0);
                    }
                }
            }
        }
        if (event.getHand() == InteractionHand.MAIN_HAND) {
            if (block.getBlock() instanceof BlazeBurnerBlock) {
                if (block.getValue(BlazeBurnerBlock.HEAT_LEVEL) != BlazeBurnerBlock.HeatLevel.NONE) {
                    ItemStack item = player.getInventory().getSelected();
                    if (Items.SHEARS == item.getItem()) {
                        event.setCancellationResult(InteractionResult.SUCCESS);
                        event.setCanceled(true);
                    }
                }
            }
        }

         */
    }
}
