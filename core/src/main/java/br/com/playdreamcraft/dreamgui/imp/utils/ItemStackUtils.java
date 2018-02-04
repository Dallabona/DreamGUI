package br.com.playdreamcraft.dreamgui.imp.utils;

import br.com.playdreamcraft.dreamgui.imp.page_component.components.ItemStackGUI;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

/**
 * Created by lucasd on 01/08/16.
 */
public class ItemStackUtils {

    public static void applyDisplayName(ItemStack itemStack, String displayName){
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
    }

    public static boolean isSkull(ItemStack itemStack){
        return itemStack.getItemMeta() instanceof SkullMeta;
    }

    public static boolean isGUIItemStack(ItemStack itemStack){
        return itemStack instanceof ItemStackGUI;
    }

}
