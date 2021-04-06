package com.progwml6.ironchest;

import com.progwml6.ironchest.client.screen.IronChestScreen;
import com.progwml6.ironchest.client.tileentity.IronChestTileEntityRenderer;
import com.progwml6.ironchest.client.tileentity.IronChestsModels;
import com.progwml6.ironchest.common.block.IronChestsBlocks;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import com.progwml6.ironchest.common.inventory.IronChestsContainerTypes;
import com.progwml6.ironchest.common.item.IronChestsItems;
import net.blueberrymc.common.Blueberry;
import net.blueberrymc.common.bml.BlueberryMod;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.world.item.CreativeModeTab;

public class IronChests extends BlueberryMod {

  public static final String MODID = "ironchest";

  /*
  public static final CreativeModeTab IRONCHESTS_ITEM_GROUP = (new CreativeModeTab("ironchest") {
    @Override
    public ItemStack makeIcon() {
      return new ItemStack(IronChestsBlocks.IRON_CHEST.get());
    }
  });
  */
  public static CreativeModeTab IRONCHESTS_ITEM_GROUP;

  @Override
  public void onPreInit() {
    IRONCHESTS_ITEM_GROUP = CreativeModeTab.TAB_DECORATIONS;
    IronChestsBlocks.BLOCKS.registerAll();
    IronChestsItems.ITEMS.registerAll();
    IronChestsTileEntityTypes.TILE_ENTITIES.registerAll();
    IronChestsContainerTypes.CONTAINERS.registerAll();
  }

  @Override
  public void onInit() {
    if (Blueberry.isClient()) {
      Blueberry.getEventManager().registerEvents(this, new IronChestsModels());
      ScreenManager.registerFactory(IronChestsContainerTypes.IRON_CHEST.get(), IronChestScreen::new);
      ScreenManager.registerFactory(IronChestsContainerTypes.GOLD_CHEST.get(), IronChestScreen::new);
      ScreenManager.registerFactory(IronChestsContainerTypes.DIAMOND_CHEST.get(), IronChestScreen::new);
      ScreenManager.registerFactory(IronChestsContainerTypes.CRYSTAL_CHEST.get(), IronChestScreen::new);
      ScreenManager.registerFactory(IronChestsContainerTypes.COPPER_CHEST.get(), IronChestScreen::new);
      ScreenManager.registerFactory(IronChestsContainerTypes.SILVER_CHEST.get(), IronChestScreen::new);
      ScreenManager.registerFactory(IronChestsContainerTypes.OBSIDIAN_CHEST.get(), IronChestScreen::new);
      ScreenManager.registerFactory(IronChestsContainerTypes.DIRT_CHEST.get(), IronChestScreen::new);

      BlockEntityRenderers.register(IronChestsTileEntityTypes.IRON_CHEST.get(), IronChestTileEntityRenderer::new);
      BlockEntityRenderers.register(IronChestsTileEntityTypes.GOLD_CHEST.get(), IronChestTileEntityRenderer::new);
      BlockEntityRenderers.register(IronChestsTileEntityTypes.DIAMOND_CHEST.get(), IronChestTileEntityRenderer::new);
      BlockEntityRenderers.register(IronChestsTileEntityTypes.COPPER_CHEST.get(), IronChestTileEntityRenderer::new);
      BlockEntityRenderers.register(IronChestsTileEntityTypes.SILVER_CHEST.get(), IronChestTileEntityRenderer::new);
      BlockEntityRenderers.register(IronChestsTileEntityTypes.CRYSTAL_CHEST.get(), IronChestTileEntityRenderer::new);
      BlockEntityRenderers.register(IronChestsTileEntityTypes.OBSIDIAN_CHEST.get(), IronChestTileEntityRenderer::new);
      BlockEntityRenderers.register(IronChestsTileEntityTypes.DIRT_CHEST.get(), IronChestTileEntityRenderer::new);
    }
  }
}
