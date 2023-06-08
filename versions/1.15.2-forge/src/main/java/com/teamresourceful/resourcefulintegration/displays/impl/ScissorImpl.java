package com.teamresourceful.resourcefulintegration.displays.impl;

import com.teamresourceful.resourcefulintegration.displays.GuiScissor;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
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
        MainWindow window = this.mc.getMainWindow();
        int scale = (int) window.getGuiScaleFactor();
        GL11.glScissor(
            x * scale,
            window.getHeight() - (y + height) * scale,
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
