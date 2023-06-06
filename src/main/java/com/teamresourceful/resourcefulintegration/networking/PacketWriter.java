package com.teamresourceful.resourcefulintegration.networking;

@FunctionalInterface
public interface PacketWriter<T> {

    void write(NetworkBuffer buffer, T object);
}
