package com.teamresourceful.resourcefulintegration.networking.impl;

import com.teamresourceful.resourcefulintegration.networking.NetworkBuffer;
import com.teamresourceful.resourcefulintegration.networking.PacketWriter;
import net.minecraft.network.PacketBuffer;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

public class NetworkBufferImpl implements NetworkBuffer {

    private final PacketBuffer buffer;

    public NetworkBufferImpl(PacketBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void writeByte(byte b) {
        this.buffer.writeByte(b);
    }

    @Override
    public void writeShort(short s) {
        this.buffer.writeShort(s);
    }

    @Override
    public void writeInt(int i) {
        this.buffer.writeInt(i);
    }

    @Override
    public void writeLong(long l) {
        this.buffer.writeLong(l);
    }

    @Override
    public void writeFloat(float f) {
        this.buffer.writeFloat(f);
    }

    @Override
    public void writeDouble(double d) {
        this.buffer.writeDouble(d);
    }

    @Override
    public void writeBoolean(boolean b) {
        this.buffer.writeBoolean(b);
    }

    @Override
    public void writeVarInt(int i) {
        this.buffer.writeVarIntToBuffer(i);
    }

    @Override
    public void writeByteArray(byte[] b) {
        this.buffer.writeByteArray(b);
    }

    @Override
    public void writeIntArray(int[] i) {
        this.writeVarInt(i.length);
        for (int j : i) {
            this.writeInt(j);
        }
    }

    @Override
    public void writeLongArray(long[] l) {
        this.writeVarInt(l.length);
        for (long i : l) {
            this.writeLong(i);
        }
    }

    @Override
    public void writeFloatArray(float[] f) {
        this.writeVarInt(f.length);
        for (float i : f) {
            this.writeFloat(i);
        }
    }

    @Override
    public void writeDoubleArray(double[] d) {
        this.writeVarInt(d.length);
        for (double i : d) {
            this.writeDouble(i);
        }
    }

    @Override
    public void writeBooleanArray(boolean[] b) {
        this.writeVarInt(b.length);
        for (boolean i : b) {
            this.writeBoolean(i);
        }
    }

    @Override
    public void writeVarIntArray(int[] i) {
        this.writeVarInt(i.length);
        for (int j : i) {
            this.writeVarInt(j);
        }
    }

    @Override
    public void writeString(String s) {
        this.buffer.writeString(s);
    }

    @Override
    public void writeEnum(Enum<?> e) {
        this.buffer.writeEnumValue(e);
    }

    @Override
    public void writeUUID(UUID u) {
        this.buffer.writeUuid(u);
    }

    @Override
    public <T> void writeCollection(Collection<T> c, PacketWriter<T> writer) {
        this.buffer.writeVarIntToBuffer(c.size());
        for (T o : c) {
            writer.write(this, o);
        }
    }

    @Override
    public <K, V> void writeMap(Map<K, V> m, PacketWriter<K> keyWriter, PacketWriter<V> valueWriter) {
        this.buffer.writeVarIntToBuffer(m.size());
        for (Map.Entry<K, V> entry : m.entrySet()) {
            keyWriter.write(this, entry.getKey());
            valueWriter.write(this, entry.getValue());
        }
    }

    @Override
    public <T> void writeNullable(T t, PacketWriter<T> writer) {
        this.buffer.writeBoolean(t != null);
        if (t != null) {
            writer.write(this, t);
        }
    }
}
