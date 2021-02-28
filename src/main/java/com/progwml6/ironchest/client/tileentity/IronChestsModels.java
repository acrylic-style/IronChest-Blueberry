package com.progwml6.ironchest.client.tileentity;

import com.progwml6.ironchest.IronChests;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import net.blueberrymc.client.event.TextureStitchEvent;
import net.blueberrymc.common.bml.event.EventHandler;
import net.blueberrymc.common.bml.event.Listener;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.resources.ResourceLocation;

public class IronChestsModels implements Listener {

  public static final ResourceLocation IRON_CHEST_LOCATION = new ResourceLocation(IronChests.MODID, "model/iron_chest");
  public static final ResourceLocation GOLD_CHEST_LOCATION = new ResourceLocation(IronChests.MODID, "model/gold_chest");
  public static final ResourceLocation DIAMOND_CHEST_LOCATION = new ResourceLocation(IronChests.MODID, "model/diamond_chest");
  public static final ResourceLocation COPPER_CHEST_LOCATION = new ResourceLocation(IronChests.MODID, "model/copper_chest");
  public static final ResourceLocation SILVER_CHEST_LOCATION = new ResourceLocation(IronChests.MODID, "model/silver_chest");
  public static final ResourceLocation CRYSTAL_CHEST_LOCATION = new ResourceLocation(IronChests.MODID, "model/crystal_chest");
  public static final ResourceLocation OBSIDIAN_CHEST_LOCATION = new ResourceLocation(IronChests.MODID, "model/obsidian_chest");
  public static final ResourceLocation DIRT_CHEST_LOCATION = new ResourceLocation(IronChests.MODID, "model/dirt_chest");
  public static final ResourceLocation VANILLA_CHEST_LOCATION = new ResourceLocation("entity/chest/normal");

  public static ResourceLocation chooseChestTexture(IronChestsTypes type) {
    switch (type) {
      case IRON:
        return IRON_CHEST_LOCATION;
      case GOLD:
        return GOLD_CHEST_LOCATION;
      case DIAMOND:
        return DIAMOND_CHEST_LOCATION;
      case COPPER:
        return COPPER_CHEST_LOCATION;
      case SILVER:
        return SILVER_CHEST_LOCATION;
      case CRYSTAL:
        return CRYSTAL_CHEST_LOCATION;
      case OBSIDIAN:
        return OBSIDIAN_CHEST_LOCATION;
      case DIRT:
        return DIRT_CHEST_LOCATION;
      case WOOD:
      default:
        return VANILLA_CHEST_LOCATION;
    }
  }

  @EventHandler
  public static void onStitch(TextureStitchEvent.Pre event) {
    if (!event.getTextureAtlas().location().equals(Sheets.CHEST_SHEET)) {
      return;
    }

    event.addSprite(IRON_CHEST_LOCATION);
    event.addSprite(GOLD_CHEST_LOCATION);
    event.addSprite(DIAMOND_CHEST_LOCATION);
    event.addSprite(COPPER_CHEST_LOCATION);
    event.addSprite(SILVER_CHEST_LOCATION);
    event.addSprite(CRYSTAL_CHEST_LOCATION);
    event.addSprite(OBSIDIAN_CHEST_LOCATION);
    event.addSprite(DIRT_CHEST_LOCATION);
  }
}
