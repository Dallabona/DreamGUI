package br.com.playdreamcraft.dreamgui.imp.utils;


import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;

/**
 * Created by lucasd on 13/09/16.
 */
public class GUIValidators {

    public static boolean isValidAction(Action action){
        if(action == Action.PHYSICAL)
            return false;

        if(action == null)
            return false;

        return true;
    }

    public static boolean isValidItemStack(ItemStack itemStack){
        return itemStack!=null;
    }

    public static boolean isValidMaterial(Material material){
        if(material == null)
            return false;

        if(material == Material.AIR)
            return false;

        return true;
    }

    public static boolean hasItemMeta(ItemStack itemStack){
        return itemStack.hasItemMeta();
    }

}
