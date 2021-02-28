package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.block.tileentity.CrystalChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class CrystalChestBlock extends GenericIronChestBlock {

  public CrystalChestBlock(Properties properties) {
    super(IronChestsTypes.CRYSTAL, IronChestsTileEntityTypes.CRYSTAL_CHEST::get, properties);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new CrystalChestTileEntity(pos, state);
  }
}
