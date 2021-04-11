package com.scool.packer;

import com.scool.packer.commands.Admin;
import com.scool.packer.commands.Packs;
import com.scool.packer.screens.PackScreen;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;
import sun.jvm.hotspot.ui.ObjectHistogramPanel;

public class Packer extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        super.onEnable();
        // Create config.yml
        saveDefaultConfig();
        // Register Commands
        getCommand("packs").setExecutor(new Packs());
        getCommand("packer").setExecutor(new Admin());
        // Register Events
        getServer().getPluginManager().registerEvents(this, this);
        // Plugin enabled properly
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[Packer] Plugin enabled");
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Packer] Plugin disabled");
    }

    // Inventory events
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getHolder() instanceof PackScreen) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            player.closeInventory();
            int slot = event.getSlot() + 1;
            String url = getConfig().getString("packs."+slot+".url");
            if (url == null) {
                getServer().getConsoleSender().sendMessage(ChatColor.RED + player.getName() + " tried to load a resource pack that was null. Check your config.yml");
            }
            assert url != null;
            player.setResourcePack(url);
        }
    }
}
