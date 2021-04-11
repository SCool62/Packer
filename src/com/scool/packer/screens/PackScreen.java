package com.scool.packer.screens;

import com.scool.packer.items.Items;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PackScreen implements InventoryHolder {

    private Inventory inv;

    public PackScreen() {
        inv = Bukkit.createInventory(this, 9, "Select a pack");
        init();
    }

    private void init() {
        ItemStack item;
        for(int i = 0; i < 9; i++) {
            item = Items.createItem("Pack " + (i + 1), Material.PAINTING);
            //ItemMeta meta = item.getItemMeta();
            inv.setItem(inv.firstEmpty(), item);
        }
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }
}
