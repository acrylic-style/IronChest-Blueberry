package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.block.tileentity.IronChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IronChestBlock extends GenericIronChestBlock {

  public IronChestBlock(Properties properties) {
    super(IronChestsTypes.IRON, IronChestsTileEntityTypes.IRON_CHEST::get, properties);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new IronChestTileEntity(pos, state);
  }
}
