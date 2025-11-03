package btw.community.rudimentary;

import btw.AddonHandler;
import btw.BTWAddon;
import dev.aunarky.rudimentary.blocks.BlockAbatis;

public class RudimentaryAddon extends BTWAddon {
    private static RudimentaryAddon instance;

    public RudimentaryAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}