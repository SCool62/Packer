package com.scool.packer.commands;

import com.scool.packer.Packer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Admin implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage("§cThis command does not currently work.");
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.isOp()){
                player.sendMessage("§cYou must be and Operator to use that command!");
                return true;
            }
        }
        if (cmd.getName().equalsIgnoreCase("packer")) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("reload")) {
                    new Packer().reloadConfig();
                    return true;
                }
                if (args[0].equalsIgnoreCase("version")) {
                    sender.sendMessage("[Packer] version "+ new Packer().getDescription().getVersion());
                    return true;
                }
            }
        }


        return true;
    }
}
