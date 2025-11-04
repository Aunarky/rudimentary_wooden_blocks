package dev.aunarky.rudimentary.tileentity;

import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.TileEntity;

public class TileEntityAbatis extends TileEntity {
    private int rotation;

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("Rotation", rotation);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        this.rotation = compound.getInteger("Rotation");
    }
}
