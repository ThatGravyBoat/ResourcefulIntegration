package com.teamresourceful.resourcefulintegration.displays.impl;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.teamresourceful.resourcefulintegration.displays.GuiStack;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.renderer.Quaternion;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@PreprocessedReplaced
public class StackImpl implements GuiStack {

    private final MatrixStack stack;

    public StackImpl(MatrixStack stack) {
        this.stack = stack;
    }

    @Override
    public void push() {
        stack.push();
    }

    @Override
    public void pop() {
        stack.pop();
    }

    @Override
    public void translate(int x, int y, int z) {
        stack.translate(x, y, z);
    }

    @Override
    public void scale(float x, float y, float z) {
        stack.scale(x, y, z);
    }

    @Override
    public void rotate(float angle, float x, float y, float z) {
        stack.rotate(new Quaternion(x, y, z, angle));
    }
}
