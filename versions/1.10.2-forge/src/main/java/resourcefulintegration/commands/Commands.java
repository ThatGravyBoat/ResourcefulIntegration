package resourcefulintegration.commands;

import net.minecraftforge.client.ClientCommandHandler;

public final class Commands {

    private Commands() {
        throw new IllegalStateException("Utility class");
    }

    public static void register(Command command) {
        ClientCommandHandler.instance.registerCommand(new CommandImpl(command));
    }
}