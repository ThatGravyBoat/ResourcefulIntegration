package com.teamresourceful.resourcefulintegration.client.api;

import com.teamresourceful.resourcefulintegration.client.Bounds;
import com.teamresourceful.resourcefulintegration.client.PeripheralAction;

public interface UiEventHandler {

    default boolean mouseAction(int mouseX, int mouseY, int button, PeripheralAction action) {
        return false;
    }

    default boolean dragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        return false;
    }

    default boolean keyAction(int keyCode, PeripheralAction action) {
        return false;
    }

    default boolean scrolled(double mouseX, double mouseY, double amount) {
        return false;
    }

    default Bounds bounds() {
        return Bounds.empty();
    }
}
