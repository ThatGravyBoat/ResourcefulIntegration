package com.teamresourceful.resourcefulintegration.peripherals;

public class Key {

    private final int code;

    public Key(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }

    public boolean isDown() {
        return Peripherals.isKeyDown(this);
    }
}
