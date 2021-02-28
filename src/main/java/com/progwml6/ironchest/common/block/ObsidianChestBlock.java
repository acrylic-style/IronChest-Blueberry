package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import com.progwml6.ironchest.common.block.tileentity.ObsidianChestTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ObsidianChestBlock extends GenericIronChestBlock {

  public ObsidianChestBlock(Properties properties) {
    super(IronChestsTypes.OBSIDIAN, IronChestsTileEntityTypes.OBSIDIAN_CHEST::get, properties);
  }

  @Override
  public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
    return new ObsidianChestTileEntity(pos, state);
  }
}
