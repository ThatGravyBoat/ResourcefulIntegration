package com.teamresourceful.resourcefulintegration.management;

import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraftforge.fml.client.FMLClientHandler;

@PreprocessedReplaced
public final class Servers {

    private Servers() {
        throw new IllegalStateException("Utility class");
    }

    @PreprocessedReplaced
    public static void addServerToList(String name, String address) {
        addServerToList(name, address, false);
    }

    @PreprocessedReplaced
    public static void addServerToList(String name, String address, boolean lan) {
        ServerList list = new ServerList(Minecraft.getMinecraft());
        list.loadServerList();
        list.addServerData(new ServerData(name, address, lan));
        list.saveServerList();
    }

    @PreprocessedReplaced
    public static void joinServer(String name, String address) {
        joinServer(name, address, false);
    }

    @PreprocessedReplaced
    public static void joinServer(String name, String address, boolean lan) {
        GuiScreen screen = Minecraft.getMinecraft().currentScreen;
        FMLClientHandler.instance().connectToServer(screen, new ServerData(name, address, lan));
    }

}
