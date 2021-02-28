package com.progwml6.ironchest.client.tileentity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import com.progwml6.ironchest.common.block.GenericIronChestBlock;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import com.progwml6.ironchest.common.block.tileentity.GenericIronChestTileEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoubleBlockCombiner;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class IronChestTileEntityRenderer<T extends BlockEntity & LidBlockEntity> implements BlockEntityRenderer<T> {

  private final ModelPart chestLid;
  private final ModelPart chestBottom;
  private final ModelPart chestLock;

  @SuppressWarnings("unused")
  public IronChestTileEntityRenderer(BlockEntityRendererProvider.Context context) {
    ModelPart part = context.bakeLayer(ModelLayers.CHEST);
    this.chestBottom = part.getChild("bottom");
    this.chestLid = part.getChild("lid");
    this.chestLock = part.getChild("lock");
  }

  @Override
  public void render(T tileEntityIn, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, int combinedOverlayIn) {
    GenericIronChestTileEntity tileEntity = (GenericIronChestTileEntity) tileEntityIn;

    Level world = tileEntity.getLevel();
    boolean flag = world != null;

    BlockState blockstate = flag ? tileEntity.getBlockState() : (BlockState) tileEntity.getBlockToUse().defaultBlockState().setValue(GenericIronChestBlock.FACING, Direction.SOUTH);
    Block block = blockstate.getBlock();
    IronChestsTypes chestType = IronChestsTypes.IRON;
    IronChestsTypes actualType = GenericIronChestBlock.getTypeFromBlock(block);

    if (actualType != null) {
      chestType = actualType;
    }

    if (block instanceof GenericIronChestBlock) {
      GenericIronChestBlock ironChestBlock = (GenericIronChestBlock) block;

      matrixStackIn.pushPose();
      float f = blockstate.getValue(GenericIronChestBlock.FACING).toYRot();
      matrixStackIn.translate(0.5D, 0.5D, 0.5D);
      matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(-f));
      matrixStackIn.translate(-0.5D, -0.5D, -0.5D);

      DoubleBlockCombiner.NeighborCombineResult<? extends GenericIronChestTileEntity> iCallbackWrapper;
      if (flag) {
        iCallbackWrapper = ironChestBlock.getWrapper(blockstate, world, tileEntity.getBlockPos(), true);
      }
      else {
        iCallbackWrapper = DoubleBlockCombiner.Combiner::acceptNone;
      }

      float f1 = iCallbackWrapper.apply(GenericIronChestBlock.getLid((LidBlockEntity) tileEntity)).get(partialTicks);
      f1 = 1.0F - f1;
      f1 = 1.0F - f1 * f1 * f1;
      int i = iCallbackWrapper.apply(new BrightnessCombiner<>()).applyAsInt(combinedLightIn);

      Material material = new Material(Sheets.CHEST_SHEET, IronChestsModels.chooseChestTexture(chestType));
      VertexConsumer ivertexbuilder = material.buffer(bufferIn, RenderType::entityCutout);

      this.handleModelRender(matrixStackIn, ivertexbuilder, this.chestLid, this.chestLock, this.chestBottom, f1, i, combinedOverlayIn);

      matrixStackIn.popPose();
    }
  }

  private void handleModelRender(PoseStack matrixStackIn, VertexConsumer iVertexBuilder, ModelPart firstModel, ModelPart secondModel, ModelPart thirdModel, float f1, int p_228871_7_, int p_228871_8_) {
    firstModel.xRot = -(f1 * ((float) Math.PI / 2F));
    secondModel.xRot = firstModel.xRot;
    firstModel.render(matrixStackIn, iVertexBuilder, p_228871_7_, p_228871_8_);
    secondModel.render(matrixStackIn, iVertexBuilder, p_228871_7_, p_228871_8_);
    thirdModel.render(matrixStackIn, iVertexBuilder, p_228871_7_, p_228871_8_);
  }
}
