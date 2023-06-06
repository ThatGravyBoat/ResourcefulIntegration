package com.teamresourceful.resourcefulintegration.displays.impl;

import com.teamresourceful.resourcefulintegration.displays.GuiStack;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@PreprocessedReplaced
public class StackImpl implements GuiStack {

    public static final GuiStack INSTANCE = new StackImpl();
    @Override
    public void push() {
        GlStateManager.pushMatrix();
    }

    @Override
    public void pop() {
        GlStateManager.popMatrix();
    }

    @Override
    public void translate(int x, int y, int z) {
        GlStateManager.translate(x, y, z);
    }

    @Override
    public void scale(float x, float y, float z) {
        GlStateManager.scale(x, y, z);
    }

    @Override
    public void rotate(float angle, float x, float y, float z) {
        GlStateManager.rotate(angle, x, y, z);
    }
}
