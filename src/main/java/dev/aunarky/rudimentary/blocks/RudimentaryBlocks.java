package dev.aunarky.rudimentary.blocks;

import dev.aunarky.rudimentary.tileentity.TileEntityAbatis;
import net.minecraft.src.TileEntity;

public class RudimentaryBlocks {
    public static BlockAbatis abatis;

    public static void initBlocks(String... args) {
        abatis = new BlockAbatis(2910);
        TileEntity.addMapping(TileEntityAbatis.class, "Abatis");
    }
}
