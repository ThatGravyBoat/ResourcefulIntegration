package com.teamresourceful.resourcefulintegration.displays;

import com.teamresourceful.resourcefulintegration.displays.impl.ScreenImpl;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;

@PreprocessedReplaced
public final class Display {

    private Display() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Sets the display as a new screen.
     * @param display The display to set.
     */
    @PreprocessedReplaced
    public static void setDisplay(GuiDisplay display) {
        ScreenImpl screen = new ScreenImpl(display);
        Minecraft.getMinecraft().displayGuiScreen(screen);
    }

    @PreprocessedReplaced
    public static void setOverlay(GuiDisplay display) {
        //TODO implement
    }
}
