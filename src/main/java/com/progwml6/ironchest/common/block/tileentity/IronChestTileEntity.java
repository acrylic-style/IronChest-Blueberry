package com.progwml6.ironchest.common.block.tileentity;

import com.progwml6.ironchest.common.block.IronChestsBlocks;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class IronChestTileEntity extends GenericIronChestTileEntity {

  public IronChestTileEntity(BlockPos blockPos, BlockState blockState) {
    super(IronChestsTileEntityTypes.IRON_CHEST.get(), blockPos, blockState, IronChestsTypes.IRON, IronChestsBlocks.IRON_CHEST::get);
  }
}
