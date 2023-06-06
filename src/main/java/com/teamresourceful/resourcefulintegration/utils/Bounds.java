package com.teamresourceful.resourcefulintegration.utils;

public class Bounds {

    private int x;
    private int y;
    private int width;
    private int height;

    private Bounds(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width + x;
        this.height = height + y;
    }

    public static Bounds of(int x, int y, int width, int height) {
        return new Bounds(x, y, width, height);
    }

    public static Bounds empty() {
        return new Bounds(0, 0, 0, 0);
    }

    public boolean contains(int x, int y) {
        return x >= this.x && x <= this.width && y >= this.y && y <= this.height;
    }

    public boolean contains(double x, double y) {
        return x >= this.x && x <= this.width && y >= this.y && y <= this.height;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public int centerX() {
        return (width - x) / 2;
    }

    public int centerY() {
        return (height - y) / 2;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
