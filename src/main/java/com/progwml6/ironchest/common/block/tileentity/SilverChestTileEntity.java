package com.progwml6.ironchest.common.block.tileentity;

import com.progwml6.ironchest.common.block.IronChestsBlocks;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import com.progwml6.ironchest.common.inventory.IronChestContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class SilverChestTileEntity extends GenericIronChestTileEntity {

  public SilverChestTileEntity(BlockPos blockPos, BlockState blockState) {
    super(IronChestsTileEntityTypes.SILVER_CHEST.get(), blockPos, blockState, IronChestsTypes.SILVER, IronChestsBlocks.SILVER_CHEST::get);
  }

  @Override
  protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
    return IronChestContainer.createSilverContainer(id, playerInventory, this);
  }
}