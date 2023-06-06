package com.teamresourceful.resourcefulintegration.displays;

import com.teamresourceful.resourcefulintegration.utils.Bounds;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

public abstract class GuiDisplay implements Renderable, UiEventHandler {

    protected final List<Renderable> renderables = new ArrayList<>();
    protected final List<UiEventHandler> handlers = new ArrayList<>();

    protected Bounds bounds = Bounds.empty();

    public abstract void init();

    public boolean doesPause() {
        return true;
    }

    public void removed() {

    }

    public void added() {

    }

    @ApiStatus.Internal
    public void setupComponents(int x, int y, int width, int height) {
        bounds = Bounds.of(x, y, width, height);
        renderables.clear();
        handlers.clear();
        init();
    }

    protected <T extends Renderable> T addRenderable(T renderable) {
        renderables.add(renderable);
        return renderable;
    }

    protected <T extends UiEventHandler> T addHandler(T handler) {
        handlers.add(handler);
        return handler;
    }

    protected <T extends Renderable & UiEventHandler> T addComponent(T component) {
        addRenderable(component);
        addHandler(component);
        return component;
    }

    @Override
    public void render(GuiCanvas canvas, int mouseX, int mouseY, float partialTicks) {
        renderables.forEach(renderable -> renderable.render(canvas, mouseX, mouseY, partialTicks));
    }

    @Override
    public boolean mouseAction(int mouseX, int mouseY, int button, boolean down) {
        for (UiEventHandler handler : handlers) {
            if (handler.bounds().contains(mouseX, mouseY) && handler.mouseAction(mouseX, mouseY, button, down)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean dragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        for (UiEventHandler handler : handlers) {
            if (handler.bounds().contains(mouseX, mouseY) && handler.dragged(mouseX, mouseY, button, deltaX, deltaY)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean keyAction(int keyCode, boolean clicked) {
        for (UiEventHandler handler : handlers) {
            if (handler.keyAction(keyCode, clicked)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean scrolled(double mouseX, double mouseY, double amount) {
        for (UiEventHandler handler : handlers) {
            if (handler.bounds().contains(mouseX, mouseY) && handler.scrolled(mouseX, mouseY, amount)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Bounds bounds() {
        return this.bounds;
    }
}
