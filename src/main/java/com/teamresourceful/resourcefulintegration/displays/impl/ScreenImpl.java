package com.teamresourceful.resourcefulintegration.displays.impl;

import com.teamresourceful.resourcefulintegration.displays.GuiDisplay;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.jetbrains.annotations.ApiStatus;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.io.IOException;

@ApiStatus.Internal
@PreprocessedReplaced
public class ScreenImpl extends GuiScreen {

    private final GuiDisplay display;
    private final CanvasImpl canvas;

    private boolean isInited = false;

    private int clickedX = 0;
    private int clickedY = 0;

    public ScreenImpl(GuiDisplay display) {
        super();
        this.display = display;
        this.canvas = new CanvasImpl(Minecraft.getMinecraft());
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        display.render(this.canvas, mouseX, mouseY, partialTicks);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        display.mouseAction(mouseX, mouseY, mouseButton, true);
        clickedX = mouseX;
        clickedY = mouseY;
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        display.mouseAction(mouseX, mouseY, state, false);
    }

    @Override
    protected void mouseClickMove(int mouseX, int mouseY, int clickedMouseButton, long timeSinceLastClick) {
        int deltaX = mouseX - clickedX;
        int deltaY = mouseY - clickedY;

        display.dragged(mouseX, mouseY, clickedMouseButton, deltaX, deltaY);
    }

    public void handleKeyboardInput() throws IOException {
        super.handleKeyboardInput();
        if (Keyboard.getEventKey() != Keyboard.KEY_NONE) {
            display.keyAction(Keyboard.getEventKey(), Keyboard.getEventKeyState());
        }
    }

    @Override
    public void handleMouseInput() throws IOException {
        super.handleMouseInput();
        int scroll = Mouse.getEventDWheel();
        if (scroll != 0) {
            int mouseX = Mouse.getEventX() * this.width / this.mc.displayWidth;
            int mouseY = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;
            display.scrolled(mouseX, mouseY, scroll);
        }
    }

    @Override
    public void onGuiClosed() {
        display.removed();
    }

    @Override
    public void initGui() {
        display.setupComponents(0, 0, this.width, this.height);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return display.doesPause();
    }

    @Override
    public void setWorldAndResolution(Minecraft mc, int width, int height) {
        super.setWorldAndResolution(mc, width, height);
        if (!isInited) {
            isInited = true;
            display.added();
        }
    }
}
