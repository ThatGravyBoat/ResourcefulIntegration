package com.teamresourceful.resourcefulintegration.commands;

import com.teamresourceful.resourcefulintegration.commands.impl.CommandImpl;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraftforge.client.ClientCommandHandler;

@PreprocessedReplaced
public final class Commands {

    private Commands() {
        throw new IllegalStateException("Utility class");
    }

    public static void register(Command command) {
        ClientCommandHandler.instance.registerCommand(new CommandImpl(command));
    }
}
