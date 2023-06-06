package com.teamresourceful.resourcefulintegration.commands;

import java.util.Map;

public interface Command {

    /**
     * Returns the id of the command.
     */
    String id();

    /**
     * Returns a map of runnables that will be executed when the command is run.
     * The key is the name of the sub command and the value is the runnable.
     * The key of '""' is the default command.
     */
    Map<String, Runnable> commands();

}
