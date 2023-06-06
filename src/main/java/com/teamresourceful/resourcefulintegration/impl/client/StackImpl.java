package com.teamresourceful.resourcefulintegration.impl.client;

import com.teamresourceful.resourcefulintegration.client.api.GuiStack;
import net.minecraft.client.renderer.GlStateManager;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
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
