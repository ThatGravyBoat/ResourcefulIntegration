package com.teamresourceful.resourcefulintegration.management;

import com.teamresourceful.resourcefulintegration.utils.Gamemode;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiCreateWorld;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import org.apache.commons.lang3.StringUtils;

@PreprocessedReplaced
public final class Worlds {

    private Worlds() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * Creates a new world with the given builder.
     * This will always return true if the player is in a world.
     * @param builder The builder to use to create the world.
     * @return true if the world was created, false if the world was not created.
     */
    public static boolean createAndJoinWorld(WorldBuilder builder) {
        if (Minecraft.getMinecraft().isIntegratedServerRunning()) return false;
        WorldSettings settings = new WorldSettings(builder.seed, toType(builder.gamemode), true, builder.hardcore, toType(builder.type));
        if (builder.cheats) settings.enableCommands();
        Minecraft.getMinecraft().launchIntegratedServer(
                folderName(builder.name),
                builder.name.trim(),
                settings
        );
        return true;
    }

    private static WorldSettings.GameType toType(Gamemode gamemode) {
        switch (gamemode) {
            case CREATIVE:
                return WorldSettings.GameType.CREATIVE;
            case SURVIVAL:
                return WorldSettings.GameType.SURVIVAL;
            case ADVENTURE:
                return WorldSettings.GameType.ADVENTURE;
            case SPECTATOR:
                return WorldSettings.GameType.SPECTATOR;
            default:
                return WorldSettings.GameType.NOT_SET;
        }
    }

    private static WorldType toType(WorldBuilder.Type type) {
        switch (type) {
            case FLAT:
                return WorldType.FLAT;
            case DEBUG:
                return WorldType.DEBUG_WORLD;
            default:
                return WorldType.DEFAULT;
        }
    }

    private static String folderName(String name) {
        name = name.trim();
        for (char c0 : ChatAllowedCharacters.allowedCharactersArray) {
            name = name.replace(c0, '_');
        }

        if (StringUtils.isEmpty(name)) {
            name = "World";
        }

        return GuiCreateWorld.getUncollidingSaveDirName(Minecraft.getMinecraft().getSaveLoader(), name);
    }
}
