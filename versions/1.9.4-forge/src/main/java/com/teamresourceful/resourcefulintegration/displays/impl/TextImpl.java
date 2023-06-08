package com.teamresourceful.resourcefulintegration.displays.impl;

import com.teamresourceful.resourcefulintegration.displays.GuiText;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.translation.I18n;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@PreprocessedReplaced
public class TextImpl implements GuiText {

    private final Minecraft minecraft;

    public TextImpl(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    @Override
    @SuppressWarnings("deprecation")
    public String translate(String key) {
        return I18n.translateToLocal(key);
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
