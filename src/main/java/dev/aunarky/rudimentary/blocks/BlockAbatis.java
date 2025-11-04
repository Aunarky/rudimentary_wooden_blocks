package dev.aunarky.rudimentary.blocks;

import btw.block.util.Flammability;
import dev.aunarky.rudimentary.tileentity.TileEntityAbatis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.*;

public class BlockAbatis extends BlockContainer {

    public BlockAbatis(int id) {
        super(id, Material.wood);
        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setStepSound(soundWoodFootstep);
        this.setUnlocalizedName("abatis");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTextureName("rudimentaryblocks:abatis");
        this.setFireProperties(Flammability.PLANKS);
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {}

    @Override
    public Icon getIcon(int side, int meta) {
        return Block.planks.getIcon(side, meta);
    }

    @Override
    @Environment(value = EnvType.CLIENT)
    public boolean renderBlock(RenderBlocks renderBlocks, int x, int y, int z) {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World par1World) {
        return new TileEntityAbatis();
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
    public int getRenderType() {
        return -1;
    }
}