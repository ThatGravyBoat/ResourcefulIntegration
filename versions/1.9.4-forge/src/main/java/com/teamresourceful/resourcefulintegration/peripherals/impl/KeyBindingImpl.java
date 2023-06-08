package com.teamresourceful.resourcefulintegration.peripherals.impl;

import com.teamresourceful.resourcefulintegration.peripherals.Key;
import com.teamresourceful.resourcefulintegration.peripherals.MappedKey;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.settings.KeyBinding;
import org.jetbrains.annotations.ApiStatus;

@ApiStatus.Internal
@PreprocessedReplaced
public class KeyBindingImpl extends KeyBinding implements MappedKey {

    private final String name;
    private final String category;
    private final Key initial;


    public KeyBindingImpl(String name, String category, Key initial) {
        super(name, initial.code(), category);
        this.name = name;
        this.category = category;
        this.initial = initial;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String category() {
        return this.category;
    }

    @Override
    public Key initial() {
        return this.initial;
    }

    @Override
    public boolean isDown() {
        return isKeyDown();
    }
}
