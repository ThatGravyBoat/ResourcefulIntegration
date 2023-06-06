package com.teamresourceful.resourcefulintegration.displays;

import com.teamresourceful.resourcefulintegration.utils.Bounds;

public interface UiEventHandler {

    default boolean mouseAction(int mouseX, int mouseY, int button, boolean down) {
        return false;
    }

    default boolean dragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        return false;
    }

    default boolean keyAction(int keyCode, boolean clicked) {
        return false;
    }

    default boolean scrolled(double mouseX, double mouseY, double amount) {
        return false;
    }

    default Bounds bounds() {
        return Bounds.empty();
    }
}
