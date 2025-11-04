package dev.aunarky.rudimentary.tileentity;

import dev.aunarky.rudimentary.client.model.ModelAbatis;
import net.minecraft.src.ModelBase;
import net.minecraft.src.ResourceLocation;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;
import org.lwjgl.opengl.GL11;

public class TileEntityAbatisRenderer extends TileEntitySpecialRenderer {
    private final ModelBase model = new ModelAbatis();

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float partialTicks) {
        GL11.glPushMatrix();
        GL11.glTranslated(x + 0.5, y, z + 0.5);

        TileEntityAbatis abatis = (TileEntityAbatis) te;
        int rot = abatis.getRotation();
        GL11.glRotatef(rot * 90F, 0, 1, 0);

        bindTexture(new ResourceLocation("rudimentaryblocks:textures/blocks/abatis.png"));
        model.render(null, 0, 0, 0, 0, 0, 0.0625F);
        GL11.glPopMatrix();
    }
}