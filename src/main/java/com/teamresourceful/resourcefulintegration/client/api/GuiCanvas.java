package com.teamresourceful.resourcefulintegration.client.api;

public interface GuiCanvas {

    void fill(int x, int y, int width, int height, int color);

    void fillGradient(int x, int y, int width, int height, int colorStart, int colorEnd);

    void drawTexture(
        String texture,
        int x, int y,
        int width, int height,
        int u, int v,
        int textureWidth, int textureHeight
    );

    GuiText text();

    GuiStack stack();

    GuiScissor scissor();


}
