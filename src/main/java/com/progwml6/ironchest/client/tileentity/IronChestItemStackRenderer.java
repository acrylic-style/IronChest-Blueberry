package com.progwml6.ironchest.client.tileentity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiFunction;

public class IronChestItemStackRenderer<T extends BlockEntity> extends BlockEntityWithoutLevelRenderer {

  private final BiFunction<BlockPos, BlockState, T> te;

  public IronChestItemStackRenderer(BiFunction<BlockPos, BlockState, T> te) {
    super(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    this.te = te;
  }

  @Override
  public void renderByItem(ItemStack itemStackIn, ItemTransforms.TransformType transformType, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
    Minecraft.getInstance().getBlockEntityRenderDispatcher().renderItem(this.te.apply(BlockPos.ZERO, null), matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn);
  }
}
