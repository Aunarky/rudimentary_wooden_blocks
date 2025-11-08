package dev.aunarky.rudimentary.blocks;

import btw.block.model.BlockModel;
import btw.block.util.Flammability;
import btw.item.BTWItems;
import btw.util.MiscUtils;
import dev.aunarky.rudimentary.client.model.ModelAbatis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.*;

import java.util.Random;

public class BlockAbatis extends Block {
    ModelAbatis model = new ModelAbatis();

    public BlockAbatis(int id) {
        super(id, Material.wood);
        //this.setHardness(0.2F);
        //this.setResistance(5.0F);
        this.setAxesEffectiveOn();
        this.setBuoyant();

        this.setUnlocalizedName("abatis");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setFireProperties(Flammability.PLANKS);
        this.setStepSound(soundWoodFootstep);
    }

    @Override
    public int getHarvestToolLevel(IBlockAccess blockAccess, int i, int j, int k) {
        return 2;
    }
    
    @Override
    public boolean dropComponentItemsOnBadBreak(World world, int i, int j, int k, int iMetadata, float fChanceOfDrop) {
        this.dropItemsIndividually(world, i, j, k, BTWItems.sawDust.itemID, 3, 0, fChanceOfDrop);
        this.dropItemsIndividually(world, i, j, k, Item.stick.itemID, 1, 0, fChanceOfDrop);
        return true;
    }

    @Override
    public void onBlockDestroyedWithImproperTool(World world, EntityPlayer player, int i, int j, int k, int iMetadata)
    {
        world.playAuxSFX(2272, i, j, k, this.blockID + (iMetadata << 12));
        dropComponentItemsOnBadBreak(world, i, j, k, iMetadata, 1F);
    }

    @Override
    public int onBlockPlaced(World world, int i, int j, int k, int iFacing, float fClickX, float fClickY, float fClickZ, int iMetadata) {
        return this.setFacing(iMetadata, iFacing);
    }

    @Override
    public int preBlockPlacedBy(World world, int i, int j, int k, int iMetadata, EntityLivingBase entityBy) {
        int iFacing = MiscUtils.convertOrientationToFlatBlockFacing(entityBy);
        return this.setFacing(iMetadata, iFacing);
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public MovingObjectPosition collisionRayTrace(World world, int i, int j, int k, Vec3 startRay, Vec3 endRay) {
        int iFacing = this.getFacing(world, i, j, k);
        BlockModel transformedModel = this.model.makeTemporaryCopy();
        transformedModel.rotateAroundYToFacing(iFacing);
        return transformedModel.collisionRayTrace(world, i, j, k, startRay, endRay);
    }

    @Override
    public int getFacing(int iMetadata) {
        int iOrientation = iMetadata & 3;
        if ((iOrientation & 1) == 0) {
            if (iOrientation == 0) {
                return 3;
            }
            return 2;
        }
        if (iOrientation == 1) {
            return 4;
        }
        return 5;
    }

    @Override
    public int setFacing(int iMetadata, int iFacing) {
        int iOrientation = iFacing == 2 ? 2 : (iFacing == 3 ? 0 : (iFacing == 4 ? 1 : 3));
        return (iMetadata &= 0xFFFFFFFC) | iOrientation;
    }

    @Override
    public boolean canRotateOnTurntable(IBlockAccess blockAccess, int i, int j, int k) {
        return true;
    }

    @Override
    @Environment(value=EnvType.CLIENT)
    public void registerIcons(IconRegister register) {
        this.blockIcon = register.registerIcon("log_oak");
    }

    @Override
    @Environment(value=EnvType.CLIENT)
    public boolean renderBlock(RenderBlocks renderer, int i, int j, int k) {
        int iMetadata = renderer.blockAccess.getBlockMetadata(i, j, k);
        int iFacing = this.getFacing(iMetadata);
        BlockModel transformedModel = this.model.makeTemporaryCopy();
        transformedModel.rotateAroundYToFacing(iFacing);
        renderer.setUVRotateTop(this.convertFacingToTopTextureRotation(iFacing));
        renderer.setUVRotateBottom(this.convertFacingToBottomTextureRotation(iFacing));
        boolean bReturnValue = transformedModel.renderAsBlock(renderer, this, i, j, k);
        renderer.clearUVRotation();
        return bReturnValue;
    }

    @Override
    @Environment(value=EnvType.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int iNeighborI, int iNeighborJ, int iNeighborK, int iSide) {
        return this.currentBlockRenderer.shouldSideBeRenderedBasedOnCurrentBounds(iNeighborI, iNeighborJ, iNeighborK, iSide);
    }

    @Override
    @Environment(value=EnvType.CLIENT)
    public void renderBlockAsItem(RenderBlocks renderer, int iItemDamage, float fBrightness) {
        this.model.renderAsItemBlock(renderer, this, iItemDamage);
    }

    @Override
    @Environment(value=EnvType.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int i, int j, int k) {
        AxisAlignedBB transformedBox = this.model.boxSelection.makeTemporaryCopy();
        transformedBox.rotateAroundYToFacing(this.getFacing(world, i, j, k));
        transformedBox.offset(i, j, k);
        return transformedBox;
    }
}

