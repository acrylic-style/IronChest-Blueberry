package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.block.tileentity.DirtChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DirtChestBlock extends GenericIronChestBlock {

  public DirtChestBlock(Properties properties) {
    super(IronChestsTypes.DIRT, IronChestsTileEntityTypes.DIRT_CHEST::get, properties);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new DirtChestTileEntity(pos, state);
  }
}
