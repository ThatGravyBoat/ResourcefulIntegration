package com.teamresourceful.resourcefulintegration.messages;

import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

@PreprocessedReplaced
public final class Messages {

    private Messages() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Sends a message to the server.
     * @param message The message to send.
     */
    @PreprocessedReplaced
    public static void sendServerMessage(String message) {
        Minecraft.getMinecraft().thePlayer.sendChatMessage(message);
    }

    /**
     * Sends a message to the server.
     * @param text The message to send.
     */
    @PreprocessedReplaced
    public static void sendServerMessage(FormattedText text) {
        sendServerMessage(Formatting.strip(text.toString()));
    }

    /**
     * Adds a message to the client chat.
     * @param message The message to add.
     */
    @PreprocessedReplaced
    public static void addClientMessage(String message) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI()
                .printChatMessage(new ChatComponentText(message));
    }

    /**
     * Adds a message to the client chat.
     * @param text The message to add.
     */
    @PreprocessedReplaced
    public static void addClientMessage(FormattedText text) {
        addClientMessage(text.toString());
    }

    /**
     * Sets the action bar message.
     * @param message The message to set.
     */
    @PreprocessedReplaced
    public static void setOverlayMessage(String message) {
        Minecraft.getMinecraft().ingameGUI.setRecordPlaying(message, false);
    }

    /**
     * Sets the action bar message.
     * @param text The message to set.
     */
    @PreprocessedReplaced
    public static void setOverlayMessage(FormattedText text) {
        setOverlayMessage(text.toString());
    }
}
