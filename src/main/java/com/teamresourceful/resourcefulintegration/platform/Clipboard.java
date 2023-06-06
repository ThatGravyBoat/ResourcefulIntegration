package com.teamresourceful.resourcefulintegration.platform;

import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.gui.GuiScreen;

@PreprocessedReplaced
public final class Clipboard {

    private Clipboard() {
        throw new IllegalStateException("Utility class");
    }

    @PreprocessedReplaced
    public static void set(String string) {
        GuiScreen.setClipboardString(string);
    }

    @PreprocessedReplaced
    public static String get() {
        return GuiScreen.getClipboardString();
    }
}
