package com.teamresourceful.resourcefulintegration.management;

import com.teamresourceful.resourcefulintegration.utils.Gamemode;

public class WorldBuilder {

    public final String name;
    public Gamemode gamemode = Gamemode.SURVIVAL;
    public boolean hardcore = false;
    public long seed = 0;
    public Type type = Type.DEFAULT;
    public boolean cheats = false;

    public WorldBuilder(String name) {
        this.name = name;
    }

    public WorldBuilder gamemode(Gamemode gamemode) {
        this.gamemode = gamemode;
        return this;
    }

    public WorldBuilder hardcore(boolean hardcore) {
        this.hardcore = hardcore;
        return this;
    }

    public WorldBuilder seed(long seed) {
        this.seed = seed;
        return this;
    }

    public WorldBuilder type(Type type) {
        this.type = type;
        return this;
    }

    public WorldBuilder cheats(boolean cheats) {
        this.cheats = cheats;
        return this;
    }

    public enum Type {
        DEFAULT,
        FLAT,
        DEBUG,
    }
}
