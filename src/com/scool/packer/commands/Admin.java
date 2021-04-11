package com.scool.packer.commands;

import com.scool.packer.Packer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Admin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("packer")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    new Packer().reloadConfig();
                    return true;
                }
            }
        }


        return true;
    }
}
