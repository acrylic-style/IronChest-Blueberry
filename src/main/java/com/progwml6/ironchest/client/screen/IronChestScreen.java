package com.progwml6.ironchest.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import com.progwml6.ironchest.common.inventory.IronChestContainer;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class IronChestScreen extends AbstractContainerScreen<IronChestContainer> implements MenuAccess<IronChestContainer> {

  private final IronChestsTypes chestType;

  private final int textureXSize;

  private final int textureYSize;
  private final Inventory inventory;

  public IronChestScreen(IronChestContainer container, Inventory playerInventory, Component title) {
    super(container, playerInventory, title);
    this.inventory = playerInventory;

    this.chestType = container.getChestType();
    this.imageWidth = container.getChestType().xSize;
    this.imageHeight = container.getChestType().ySize;
    this.textureXSize = container.getChestType().textureXSize;
    this.textureYSize = container.getChestType().textureYSize;

    this.passEvents = false;
  }

  @Override
  public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
    this.renderBackground(matrixStack);
    super.render(matrixStack, mouseX, mouseY, partialTicks);
    this.renderTooltip(matrixStack, mouseX, mouseY);
  }

  @Override
  protected void renderLabels(PoseStack matrixStack, int mouseX, int mouseY) {
    this.font.draw(matrixStack, this.title, 8.0F, 6.0F, 4210752);
    this.font.draw(matrixStack, this.inventory.getDisplayName(), 8.0F, (float) (this.imageHeight - 96 + 2), 4210752);
  }

  @Override
  protected void renderBg(PoseStack matrixStack, float partialTicks, int mouseX, int mouseY) {
    RenderSystem.setShader(GameRenderer::getPositionTexColorShader);
    RenderSystem.setShaderTexture(0, this.chestType.guiTexture);
    RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

    int x = (this.width - this.imageWidth) / 2;
    int y = (this.height - this.imageHeight) / 2;

    blit(matrixStack, x, y, 0, 0, this.imageWidth, this.imageHeight, this.textureXSize, this.textureYSize);
  }
}

