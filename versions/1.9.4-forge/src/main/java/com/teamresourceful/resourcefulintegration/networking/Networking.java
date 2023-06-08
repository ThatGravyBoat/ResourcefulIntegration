package com.teamresourceful.resourcefulintegration.networking;

import com.teamresourceful.resourcefulintegration.networking.impl.NetworkBufferImpl;
import com.teamresourceful.resourcefulintegration.utils.Identifier;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;

import java.util.function.Consumer;

@PreprocessedReplaced
public final class Networking {

    private Networking() {
        throw new IllegalStateException("Utility class");
    }

    @PreprocessedReplaced
    public static void sendPacket(@Identifier String id, Consumer<NetworkBuffer> writer) {
        PacketBuffer buf = new PacketBuffer(Unpooled.buffer());
        NetworkBuffer buffer = new NetworkBufferImpl(buf);
        writer.accept(buffer);
        Minecraft.getMinecraft().getConnection()
                .sendPacket(new CPacketCustomPayload(id, buf));
    }
}
