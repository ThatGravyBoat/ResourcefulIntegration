package com.teamresourceful.resourcefulintegration.peripherals;

public interface MappedKey {

    String name();

    String category();
    
    Key initial();

    boolean isDown();

}
