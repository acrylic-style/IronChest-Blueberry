package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.block.tileentity.GoldChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class GoldChestBlock extends GenericIronChestBlock {

  public GoldChestBlock(Properties properties) {
    super(IronChestsTypes.GOLD, IronChestsTileEntityTypes.GOLD_CHEST::get, properties);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new GoldChestTileEntity(pos, state);
  }
}
