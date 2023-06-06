package com.teamresourceful.resourcefulintegration.networking;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public interface NetworkBuffer {

    void writeByte(byte b);

    void writeShort(short s);

    void writeInt(int i);

    void writeLong(long l);

    void writeFloat(float f);

    void writeDouble(double d);

    void writeBoolean(boolean b);

    void writeVarInt(int i);

    void writeByteArray(byte[] b);

    void writeIntArray(int[] i);

    void writeLongArray(long[] l);

    void writeFloatArray(float[] f);

    void writeDoubleArray(double[] d);

    void writeBooleanArray(boolean[] b);

    void writeVarIntArray(int[] i);


    void writeString(String s);

    void writeEnum(Enum<?> e);

    void writeUUID(UUID u);

    <T> void writeCollection(Collection<T> c, PacketWriter<T> writer);

    <K, V> void writeMap(Map<K, V> m, PacketWriter<K> keyWriter, PacketWriter<V> valueWriter);

    <T> void writeNullable(T t, PacketWriter<T> writer);

}
