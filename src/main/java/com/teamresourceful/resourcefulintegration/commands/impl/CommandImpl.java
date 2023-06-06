package com.teamresourceful.resourcefulintegration.commands.impl;

import com.teamresourceful.resourcefulintegration.commands.Command;
import com.teamresourceful.resourcefulintegration.utils.PreprocessedReplaced;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import org.jetbrains.annotations.ApiStatus;

import java.util.ArrayList;
import java.util.List;

@ApiStatus.Internal
@PreprocessedReplaced
public class CommandImpl extends CommandBase {

    private final Command command;

    public CommandImpl(Command command) {
        this.command = command;
    }

    @Override
    public String getCommandName() {
        return command.id();
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + command.id();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {
            command.commands().getOrDefault("", () -> {
            }).run();
        } else if (command.commands().containsKey(args[0])) {
            command.commands().getOrDefault(args[0], () -> {
            }).run();
        }
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            for (String key : command.commands().keySet()) {
                if (key.startsWith(args[0])) {
                    completions.add(key);
                }
            }
        } else if (args.length == 0) {
            completions.addAll(command.commands().keySet());
        }
        return completions;
    }
}
