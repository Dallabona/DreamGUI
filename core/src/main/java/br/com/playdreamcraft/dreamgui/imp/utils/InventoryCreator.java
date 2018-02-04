package br.com.playdreamcraft.dreamgui.imp.utils;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

/**
 * Created by lucasd on 21/07/16.
 */
public class InventoryCreator {
    private static InventoryCreator ourInstance = new InventoryCreator();

    public static InventoryCreator getInstance() {
        return ourInstance;
    }

    private InventoryCreator() {
    }

    public Inventory createInventory(String name, int size){
        return Bukkit.createInventory(null, size, name);
    }
}
