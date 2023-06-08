package com.teamresourceful.resourcefulintegration.peripherals;

import com.teamresourceful.resourcefulintegration.peripherals.impl.KeyBindingImpl;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

@PreprocessedReplaced
public final class Peripherals {

    private Peripherals() {
        throw new IllegalStateException("Utility class");
    }

    @PreprocessedReplaced
    public static MappedKey registerMapping(String name, String category, Key initial) {
        return new KeyBindingImpl(name, category, initial);
    }

    @PreprocessedReplaced
    public static boolean isKeyDown(Key key) {
        return isKeyDown(key.code());
    }

    @PreprocessedReplaced
    public static boolean isKeyDown(int key) {
        if (key == Keys.NONE.code()) return false;
        return Keyboard.isKeyDown(key);
    }

    @PreprocessedReplaced
    public static int mouseX() {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        return Mouse.getX() * scaledResolution.getScaledWidth() / Minecraft.getMinecraft().displayWidth;
    }

    @PreprocessedReplaced
    public static int mouseY() {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        int height = Minecraft.getMinecraft().displayHeight;
        return (height - Mouse.getY() - 1) * scaledResolution.getScaledHeight() / Math.max(1, height - 1);
    }
}
