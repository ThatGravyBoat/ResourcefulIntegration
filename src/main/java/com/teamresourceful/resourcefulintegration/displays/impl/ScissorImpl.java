package com.teamresourceful.resourcefulintegration.displays.impl;

import com.teamresourceful.resourcefulintegration.displays.GuiScissor;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.opengl.GL11;

@ApiStatus.Internal
@PreprocessedReplaced
public class ScissorImpl implements GuiScissor {

    private final Minecraft mc;

    public ScissorImpl(Minecraft minecraft) {
        this.mc = minecraft;
    }

    @Override
    public void enable(int x, int y, int width, int height) {
        int displayHeight = this.mc.displayHeight;
        ScaledResolution resolution = new ScaledResolution(this.mc);
        int scale = resolution.getScaleFactor();
        GL11.glScissor(
            x * scale,
            displayHeight - (y + height) * scale,
            width * scale,
            height * scale
        );
        GL11.glEnable(GL11.GL_SCISSOR_TEST);
    }

    @Override
    public void disable() {
        GL11.glDisable(GL11.GL_SCISSOR_TEST);
    }
}
