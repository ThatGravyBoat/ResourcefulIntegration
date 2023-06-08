package com.teamresourceful.resourcefulintegration.displays.impl;

import com.teamresourceful.resourcefulintegration.displays.GuiDisplay;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.StringTextComponent;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@PreprocessedReplaced
public class ScreenImpl extends Screen {

    private final GuiDisplay display;
    private final CanvasImpl canvas;

    private boolean isInited = false;

    private double clickedX = 0;
    private double clickedY = 0;

    public ScreenImpl(GuiDisplay display) {
        super(new StringTextComponent(""));
        this.display = display;
        this.canvas = new CanvasImpl(Minecraft.getInstance());
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks) {
        display.render(this.canvas, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int mouseButton) {
        boolean clicked = display.mouseAction((int) mouseX, (int) mouseY, mouseButton, true);
        clickedX = mouseX;
        clickedY = mouseY;
        return clicked;
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int state) {
        return display.mouseAction((int) mouseX, (int) mouseY, state, false);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int clickedMouseButton, double deltaX, double deltaY) {
        return display.dragged(mouseX, mouseY, clickedMouseButton, deltaX, deltaY);
    }

    @Override
    public boolean keyPressed(int code, int scanCode, int modifiers) {
        return display.keyAction(code, true);
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        return display.keyAction(keyCode, false);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scroll) {
        return display.scrolled((int) mouseX, (int) mouseY, (int) scroll);
    }



    @Override
    public void removed() {
        display.removed();
    }

    @Override
    protected void init() {
        display.setupComponents(0, 0, this.width, this.height);
    }

    @Override
    public boolean isPauseScreen() {
        return display.doesPause();
    }

    @Override
    public void init(Minecraft arg, int i, int j) {
        super.init(arg, i, j);
        if (!isInited) {
            isInited = true;
            display.added();
        }
    }
}
