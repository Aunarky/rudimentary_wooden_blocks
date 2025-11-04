package dev.aunarky.rudimentary;

import dev.aunarky.rudimentary.blocks.RudimentaryBlocks;
import dev.aunarky.rudimentary.tileentity.TileEntityAbatis;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.src.TileEntity;

public class RudimentaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Rudimentary Client");
        TileEntity.addMapping(TileEntityAbatis.class, "fcAbatis");
    }
}
