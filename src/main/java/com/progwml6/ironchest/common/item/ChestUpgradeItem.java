package com.progwml6.ironchest.common.item;

import com.progwml6.ironchest.common.block.GenericIronChestBlock;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import com.progwml6.ironchest.common.block.tileentity.GenericIronChestTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
/*
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.InteractionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
*/

import java.util.List;

public class ChestUpgradeItem extends Item {

  private final IronChestsUpgradeType type;

  public ChestUpgradeItem(IronChestsUpgradeType type, Properties properties) {
    super(properties);
    this.type = type;
  }

  @Override
  public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
    super.appendHoverText(stack, worldIn, tooltip, flagIn);
    //tooltip.add(new TranslationTextComponent(this.getTranslationKey() + ".desc").applyTextStyle(TextFormatting.GRAY));
  }

  @Override
  public InteractionResult useOn(UseOnContext context) {
    Player entityPlayer = context.getPlayer();
    BlockPos blockPos = context.getClickedPos();
    Level world = context.getLevel();
    ItemStack itemStack = context.getItemInHand();

    if (world.isClientSide) {
      return InteractionResult.PASS;
    }

    if (entityPlayer == null) {
      return InteractionResult.PASS;
    }

    if (this.type.canUpgrade(IronChestsTypes.WOOD)) {
      if (!(world.getBlockState(blockPos).getBlock() instanceof ChestBlock)) {
        return InteractionResult.PASS;
      }
    }
    else {
      if (world.getBlockState(blockPos).getBlock().defaultBlockState() != IronChestsTypes.get(this.type.source).defaultBlockState()) {
        return InteractionResult.PASS;
      }
    }

    BlockEntity tileEntity = world.getBlockEntity(blockPos);

    if (this.type.canUpgrade(IronChestsTypes.WOOD)) {
      if (!(tileEntity instanceof ChestBlockEntity)) {
        return InteractionResult.PASS;
      }
    }

    GenericIronChestTileEntity newChest = null;
    Component customName = null;
    NonNullList<ItemStack> chestContents = NonNullList.withSize(27, ItemStack.EMPTY);
    Direction chestFacing = Direction.NORTH;

    if (tileEntity != null) {
      if (tileEntity instanceof GenericIronChestTileEntity) {
        GenericIronChestTileEntity chest = (GenericIronChestTileEntity) tileEntity;
        BlockState chestState = world.getBlockState(blockPos);

        if (GenericIronChestTileEntity.getPlayersUsing(world, blockPos) > 0) {
          return InteractionResult.PASS;
        }

        if (!chest.canOpen(entityPlayer)) {
          return InteractionResult.PASS;
        }

        chestContents = chest.getItems();
        chestFacing = chestState.getValue(GenericIronChestBlock.FACING);
        customName = chest.getCustomName();
        newChest = this.type.target.makeEntity(blockPos, chestState);

        if (newChest == null) {
          return InteractionResult.PASS;
        }
      }
      else if (tileEntity instanceof ChestBlockEntity) {
        BlockState chestState = world.getBlockState(blockPos);
        chestFacing = chestState.getValue(ChestBlock.FACING);
        ChestBlockEntity chest = (ChestBlockEntity) tileEntity;

        if (ChestBlockEntity.getOpenCount(world, blockPos) > 0) {
          return InteractionResult.PASS;
        }

        if (!chest.canOpen(entityPlayer)) {
          return InteractionResult.PASS;
        }

        if (!this.type.canUpgrade(IronChestsTypes.WOOD)) {
          return InteractionResult.PASS;
        }

        chestContents = NonNullList.withSize(chest.getContainerSize(), ItemStack.EMPTY);

        for (int slot = 0; slot < chestContents.size(); slot++) {
          chestContents.set(slot, chest.getItem(slot));
        }

        customName = chest.getCustomName();

        newChest = this.type.target.makeEntity(blockPos, chestState);
      }
    }

    tileEntity.setChanged();

    world.removeBlockEntity(blockPos);
    world.removeBlock(blockPos, false);

    BlockState iBlockState = IronChestsTypes.get(this.type.target).defaultBlockState().setValue(GenericIronChestBlock.FACING, chestFacing);

    world.setBlock(blockPos, iBlockState, 3);
    world.setBlockEntity(newChest);

    world.sendBlockUpdated(blockPos, iBlockState, iBlockState, 3);

    BlockEntity tileEntity2 = world.getBlockEntity(blockPos);

    if (tileEntity2 instanceof GenericIronChestTileEntity) {
      if (customName != null) {
        ((GenericIronChestTileEntity) tileEntity2).setCustomName(customName);
      }

      ((GenericIronChestTileEntity) tileEntity2).setItems(chestContents);
    }

    if (!entityPlayer.getAbilities().instabuild) {
      itemStack.shrink(1);
    }

    return InteractionResult.SUCCESS;
  }

}
