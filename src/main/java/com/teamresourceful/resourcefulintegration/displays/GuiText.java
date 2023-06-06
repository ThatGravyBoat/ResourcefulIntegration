package com.teamresourceful.resourcefulintegration.displays;

public interface GuiText {

    String translate(String key);

    int width(String text);

    void drawString(String text, int x, int y, int color, boolean shadow);

    default void drawString(String text, int x, int y, int color) {
        drawString(text, x, y, color, false);
    }

    default void drawCenteredString(String text, int x, int y, int color, boolean shadow) {
        drawString(text, x - width(text) / 2, y, color, shadow);
    }

    default void drawCenteredString(String text, int x, int y, int color) {
        drawCenteredString(text, x, y, color, false);
    }

}
