package dev.aunarky.rudimentary;

import dev.aunarky.rudimentary.blocks.RudimentaryBlocks;
import dev.aunarky.rudimentary.tileentity.TileEntityAbatis;
import dev.aunarky.rudimentary.tileentity.TileEntityAbatisRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.src.TileEntityRenderer;
import net.minecraft.src.TileEntitySpecialRenderer;

public class RudimentaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("Rudimentary Client");
        TileEntityAbatisRenderer renderer = new TileEntityAbatisRenderer();
        TileEntityRenderer.instance.specialRendererMap.put(TileEntityAbatis.class, renderer);
        renderer.setTileEntityRenderer(TileEntityRenderer.instance);
    }
}
