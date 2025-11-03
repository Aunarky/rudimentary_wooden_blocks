package dev.aunarky.rudimentary;

import dev.aunarky.rudimentary.blocks.BlockAbatis;
import net.fabricmc.api.ModInitializer;

public class RudimentaryMod implements ModInitializer {
    public static BlockAbatis abatis;

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        abatis = new BlockAbatis(2910);
        System.out.println("Hello Fabric world! Added BlockAbatis!");
    }
}
