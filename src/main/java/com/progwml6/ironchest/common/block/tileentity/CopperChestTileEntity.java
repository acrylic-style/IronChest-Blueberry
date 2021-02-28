package com.progwml6.ironchest.common.block.tileentity;

import com.progwml6.ironchest.common.block.IronChestsBlocks;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import com.progwml6.ironchest.common.inventory.IronChestContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

public class CopperChestTileEntity extends GenericIronChestTileEntity {

  public CopperChestTileEntity(BlockPos blockPos, BlockState blockState) {
    super(IronChestsTileEntityTypes.COPPER_CHEST.get(), blockPos, blockState, IronChestsTypes.COPPER, IronChestsBlocks.COPPER_CHEST::get);
  }

  @Override
  protected AbstractContainerMenu createMenu(int id, Inventory playerInventory) {
    return IronChestContainer.createCopperContainer(id, playerInventory, this);
  }
}