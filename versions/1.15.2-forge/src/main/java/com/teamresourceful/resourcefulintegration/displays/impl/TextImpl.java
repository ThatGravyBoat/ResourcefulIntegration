package com.teamresourceful.resourcefulintegration.displays.impl;

import com.teamresourceful.resourcefulintegration.displays.GuiText;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.LanguageMap;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@PreprocessedReplaced
public class TextImpl implements GuiText {

    private final Minecraft minecraft;

    public TextImpl(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    @Override
    public String translate(String key) {
        return LanguageMap.getInstance().translateKey(key);
    }

    @Override
    public int width(String text) {
        return minecraft.fontRenderer.getStringWidth(text);
    }

    @Override
    public void drawString(String text, int x, int y, int color, boolean shadow) {
        if (shadow) {
            minecraft.fontRenderer.drawStringWithShadow(text, x, y, color);
        } else {
            minecraft.fontRenderer.drawString(text, x, y, color);
        }
    }
}
