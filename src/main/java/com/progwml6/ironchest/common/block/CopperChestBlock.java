package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.block.tileentity.CopperChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CopperChestBlock extends GenericIronChestBlock {

  public CopperChestBlock(Properties properties) {
    super(IronChestsTypes.COPPER, IronChestsTileEntityTypes.COPPER_CHEST::get, properties);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new CopperChestTileEntity(pos, state);
  }
}
