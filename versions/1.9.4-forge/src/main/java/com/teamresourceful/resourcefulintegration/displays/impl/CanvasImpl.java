package com.teamresourceful.resourcefulintegration.displays.impl;

import com.teamresourceful.resourcefulintegration.displays.GuiCanvas;
import com.teamresourceful.resourcefulintegration.displays.GuiScissor;
import com.teamresourceful.resourcefulintegration.displays.GuiStack;
import com.teamresourceful.resourcefulintegration.displays.GuiText;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.jetbrains.annotations.ApiStatus;

import java.util.HashMap;
import java.util.Map;

@ApiStatus.Internal
@PreprocessedReplaced
public class CanvasImpl extends Gui implements GuiCanvas {

    private static final Map<String, ResourceLocation> TEXTURE_MAP = new HashMap<>();

    private final Minecraft minecraft;
    private final GuiText text;
    private final GuiScissor scissor;

    public CanvasImpl(Minecraft minecraft) {
        this.minecraft = minecraft;
        this.text = new TextImpl(minecraft);
        this.scissor = new ScissorImpl(minecraft);
    }

    @Override
    public void fill(int x, int y, int width, int height, int color) {
        drawRect(x, y, width, height, color);
    }

    @Override
    public void fillGradient(int x, int y, int width, int height, int colorStart, int colorEnd) {
        drawGradientRect(x, y, width, height, colorStart, colorEnd);
    }

    @Override
    public void drawTexture(String texture, int x, int y, int width, int height, int u, int v, int textureWidth, int textureHeight) {
        ResourceLocation id = getTexture(texture);
        if (id == null) return;
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        minecraft.getTextureManager().bindTexture(id);
        drawModalRectWithCustomSizedTexture(x, y, u, v, width, height, textureWidth, textureHeight);
    }

    @Override
    public GuiText text() {
        return this.text;
    }

    @Override
    public GuiStack stack() {
        return StackImpl.INSTANCE;
    }

    @Override
    public GuiScissor scissor() {
        return this.scissor;
    }

    private static ResourceLocation getTexture(String texture) {
        if (TEXTURE_MAP.containsKey(texture)) {
            return TEXTURE_MAP.get(texture);
        }

        try {
            ResourceLocation id = new ResourceLocation(texture);
            TEXTURE_MAP.put(texture, id);
            return id;
        } catch (Exception e) {
            TEXTURE_MAP.put(texture, null);
            return null;
        }
    }
}
