package com.teamresourceful.resourcefulintegration.impl.client;

import com.teamresourceful.resourcefulintegration.client.api.GuiText;
import net.minecraft.client.Minecraft;
import net.minecraft.util.StatCollector;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
public class TextImpl implements GuiText {

    private final Minecraft minecraft;

    public TextImpl(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    @Override
    public String translate(String key) {
        return StatCollector.translateToLocal(key);
    }

    @Override
    public int width(String text) {
        return minecraft.fontRendererObj.getStringWidth(text);
    }

    @Override
    public void drawString(String text, int x, int y, int color, boolean shadow) {
        minecraft.fontRendererObj.drawString(text, x, y, color, shadow);
    }
}
