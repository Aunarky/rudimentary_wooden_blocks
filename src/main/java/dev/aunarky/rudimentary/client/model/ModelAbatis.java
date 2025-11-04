package dev.aunarky.rudimentary.client.model;

import btw.block.model.BlockModel;
import net.minecraft.src.AxisAlignedBB;

public class ModelAbatis extends BlockModel {
	public AxisAlignedBB boxSelection;

	@Override
	protected void initModel() {
		this.addBox(0.6875, 0.1250, 0.6875, 0.9375, 0.2500, 0.8125);
		this.addBox(0.6875, 0.1875, 0.5625, 0.9375, 0.3125, 0.6875);
		this.addBox(0.6875, 0.3125, 0.4375, 0.9375, 0.4375, 0.5625);
		this.addBox(0.6875, 0.4375, 0.3125, 0.9375, 0.5625, 0.4375);
		this.addBox(0.6875, 0.5625, 0.1875, 0.9375, 0.6875, 0.3125);
		this.addBox(0.6875, 0.6875, 0.0625, 0.9375, 0.8125, 0.1875);
		this.addBox(0.6875, 0.0000, 0.8125, 0.9375, 0.1250, 0.9375);
		this.addBox(0.0625, 0.1250, 0.6875, 0.3125, 0.2500, 0.8125);
		this.addBox(0.0625, 0.1875, 0.5625, 0.3125, 0.3125, 0.6875);
		this.addBox(0.0625, 0.3125, 0.4375, 0.3125, 0.4375, 0.5625);
		this.addBox(0.0625, 0.4375, 0.3125, 0.3125, 0.5625, 0.4375);
		this.addBox(0.0625, 0.5625, 0.1875, 0.3125, 0.6875, 0.3125);
		this.addBox(0.0625, 0.6875, 0.0625, 0.3125, 0.8125, 0.1875);
		this.addBox(0.0625, 0.0000, 0.8125, 0.3125, 0.1250, 0.9375);
		this.addBox(0.3750, 0.1250, 0.6875, 0.6250, 0.2500, 0.8125);
		this.addBox(0.3750, 0.1875, 0.5625, 0.6250, 0.3125, 0.6875);
		this.addBox(0.3750, 0.3125, 0.4375, 0.6250, 0.4375, 0.5625);
		this.addBox(0.3750, 0.4375, 0.3125, 0.6250, 0.5625, 0.4375);
		this.addBox(0.3750, 0.5625, 0.1875, 0.6250, 0.6875, 0.3125);
		this.addBox(0.3750, 0.6875, 0.0625, 0.6250, 0.8125, 0.1875);
		this.addBox(0.3750, 0.0000, 0.8125, 0.6250, 0.1250, 0.9375);
		this.addBox(0.0000, 0.3125, 0.3125, 1.0000, 0.4375, 0.4375);
		this.addBox(0.0000, 0.1875, 0.4375, 1.0000, 0.3125, 0.5625);
		// Optional selection box (can tweak this)
		this.boxSelection = new AxisAlignedBB(0.0, 0.0, 0.0, 1.0, 0.8125, 1.0); // Adjust to your block’s footprint
	}
}
