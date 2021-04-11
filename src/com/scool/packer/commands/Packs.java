package com.scool.packer.commands;

import com.scool.packer.screens.PackScreen;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Packs implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use that command");
            return true;
        }
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("packs")) {
            player.sendMessage(ChatColor.AQUA + "Select a pack");
            player.openInventory(new PackScreen().getInventory());
            return true;
        }

        return true;
    }
}
