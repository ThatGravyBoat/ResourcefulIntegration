package com.teamresourceful.resourcefulintegration.client;

import com.teamresourceful.resourcefulintegration.client.api.GuiDisplay;
import com.teamresourceful.resourcefulintegration.impl.client.ScreenImpl;
import net.minecraft.client.Minecraft;

public class ScreenUtils {

    public static void setScreen(GuiDisplay display) {
        ScreenImpl screen = new ScreenImpl(display);
        Minecraft.getMinecraft().displayGuiScreen(screen);
    }
}
