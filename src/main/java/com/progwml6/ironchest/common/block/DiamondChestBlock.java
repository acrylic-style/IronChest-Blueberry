package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.block.tileentity.DiamondChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class DiamondChestBlock extends GenericIronChestBlock {

  public DiamondChestBlock(Properties properties) {
    super(IronChestsTypes.DIAMOND, IronChestsTileEntityTypes.DIAMOND_CHEST::get, properties);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new DiamondChestTileEntity(pos, state);
  }
}