package dev.aunarky.rudimentary.blocks;

import btw.block.util.Flammability;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Material;

public class BlockAbatis extends Block {

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
}