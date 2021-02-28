package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import com.progwml6.ironchest.common.block.tileentity.SilverChestTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SilverChestBlock extends GenericIronChestBlock {

  public SilverChestBlock(Properties properties) {
    super(IronChestsTypes.SILVER, IronChestsTileEntityTypes.SILVER_CHEST::get, properties);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new SilverChestTileEntity(pos, state);
  }
}
