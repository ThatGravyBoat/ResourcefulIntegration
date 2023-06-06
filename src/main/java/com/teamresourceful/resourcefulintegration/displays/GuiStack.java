package com.teamresourceful.resourcefulintegration.displays;

public interface GuiStack {

    void push();

    void pop();

    void translate(int x, int y, int z);

    void scale(float x, float y, float z);

    void rotate(float angle, float x, float y, float z);

}
