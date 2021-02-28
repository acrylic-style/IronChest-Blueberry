package com.progwml6.ironchest.common.block;

import com.progwml6.ironchest.common.Util;
import com.progwml6.ironchest.common.block.tileentity.CopperChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.CrystalChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.DiamondChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.DirtChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.GenericIronChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.GoldChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.ObsidianChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.SilverChestTileEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;
import java.util.Locale;

public enum IronChestsTypes implements StringRepresentable {

  IRON(54, 9, 184, 222, new ResourceLocation("ironchest", "textures/gui/iron_container.png"), 256, 256),
  GOLD(81, 9, 184, 276, new ResourceLocation("ironchest", "textures/gui/gold_container.png"), 256, 276),
  DIAMOND(108, 12, 238, 276, new ResourceLocation("ironchest", "textures/gui/diamond_container.png"), 256, 276),
  COPPER(45, 9, 184, 204, new ResourceLocation("ironchest", "textures/gui/copper_container.png"), 256, 256),
  SILVER(72, 9, 184, 258, new ResourceLocation("ironchest", "textures/gui/silver_container.png"), 256, 276),
  CRYSTAL(108, 12, 238, 276, new ResourceLocation("ironchest", "textures/gui/diamond_container.png"), 256, 276),
  OBSIDIAN(108, 12, 238, 276, new ResourceLocation("ironchest", "textures/gui/diamond_container.png"), 256, 276),
  DIRT(1, 1, 184, 184, new ResourceLocation("ironchest", "textures/gui/dirt_container.png"), 256, 256),
  WOOD(0, 0, 0, 0, null, 0, 0);

  private final String name;
  public final int size;
  public final int rowLength;
  public final int xSize;
  public final int ySize;
  public final ResourceLocation guiTexture;
  public final int textureXSize;
  public final int textureYSize;

  IronChestsTypes(int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize) {
    this(null, size, rowLength, xSize, ySize, guiTexture, textureXSize, textureYSize);
  }

  IronChestsTypes(@Nullable String name, int size, int rowLength, int xSize, int ySize, ResourceLocation guiTexture, int textureXSize, int textureYSize) {
    this.name = name == null ? Util.toEnglishName(this.name()) : name;
    this.size = size;
    this.rowLength = rowLength;
    this.xSize = xSize;
    this.ySize = ySize;
    this.guiTexture = guiTexture;
    this.textureXSize = textureXSize;
    this.textureYSize = textureYSize;
  }

  public String getId() {
    return this.name().toLowerCase(Locale.ROOT);
  }

  public String getEnglishName() {
    return this.name;
  }

  @Override
  public String getSerializedName() {
    return this.getEnglishName();
  }

  public int getRowCount() {
    return this.size / this.rowLength;
  }

  public boolean isTransparent() {
    return this == CRYSTAL;
  }

  public static Block get(IronChestsTypes type) {
    switch (type) {
      case IRON:
        return IronChestsBlocks.IRON_CHEST.get();
      case GOLD:
        return IronChestsBlocks.GOLD_CHEST.get();
      case DIAMOND:
        return IronChestsBlocks.DIAMOND_CHEST.get();
      case COPPER:
        return IronChestsBlocks.COPPER_CHEST.get();
      case SILVER:
        return IronChestsBlocks.SILVER_CHEST.get();
      case CRYSTAL:
        return IronChestsBlocks.CRYSTAL_CHEST.get();
      case OBSIDIAN:
        return IronChestsBlocks.OBSIDIAN_CHEST.get();
      case DIRT:
        return IronChestsBlocks.DIRT_CHEST.get();
      default:
        return Blocks.CHEST;
    }
  }

  public GenericIronChestTileEntity makeEntity(BlockPos pos, BlockState state) {
    switch (this) {
      case IRON:
        return new IronChestTileEntity(pos, state);
      case GOLD:
        return new GoldChestTileEntity(pos, state);
      case DIAMOND:
        return new DiamondChestTileEntity(pos, state);
      case COPPER:
        return new CopperChestTileEntity(pos, state);
      case SILVER:
        return new SilverChestTileEntity(pos, state);
      case CRYSTAL:
        return new CrystalChestTileEntity(pos, state);
      case OBSIDIAN:
        return new ObsidianChestTileEntity(pos, state);
      case DIRT:
        return new DirtChestTileEntity(pos, state);
      default:
        return null;
    }
  }
}
