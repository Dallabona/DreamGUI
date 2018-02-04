package br.com.playdreamcraft.dreamgui.imp.page_component.components;

import br.com.playdreamcraft.dreamgui.Enchantment;
import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.components.StaticComponent;
import br.com.playdreamcraft.dreamgui.imp.utils.ItemStackUtils;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lucasd on 21/07/16.
 */
@Getter
public class StaticComponentImp implements StaticComponent {

    private ItemStack itemStack;
    private String name;

    private String displayName;

    private List<String> lore;


    @Setter
    private Page page;

    public StaticComponentImp(Material type, String name, String displayName) {
        this(type, name, displayName, null);
    }

    public StaticComponentImp(Material type, String name, String displayName, Enchantment enchantment) {
        this.name = name;
        this.displayName = displayName;
        setupItemStack(type, enchantment, 1,(byte)0);
    }

    public StaticComponentImp(Material type, String name, String displayName, Enchantment enchantment, int amount) {
        this(type, name, displayName, enchantment, amount, 0);
    }

    public StaticComponentImp(Material type, String name, String displayName, Enchantment enchantment, int amount, int data) {
        this.name = name;
        this.displayName = displayName;
        setupItemStack(type, enchantment, amount,(byte) data);
    }

    private void setupItemStack(Material material, Enchantment enchantment, int amount, byte data){
        if(data == 0)
            itemStack = new ItemStackGUI(material, amount, this);
        else
            itemStack = new ItemStackGUI(material, amount,(short) 0,  data, this);

        ItemMeta itemMeta = itemStack.getItemMeta();

        if(lore!= null)
          itemMeta.setLore(lore);


        if(enchantment != null)
          itemMeta.addEnchant(enchantment.getEnchantment(), enchantment.getLevel(), true);

        itemMeta.setDisplayName(displayName);
        itemStack.setItemMeta(itemMeta);
    }

    @Override
    public void setLore(String... lore) {

        setLore(new ArrayList<>(Arrays.asList(lore)));
    }

    @Override
    public void setLore(List<String> lore) {
        if(lore == null)
            return;

        this.lore = lore;
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setLore(this.lore);
        itemStack.setItemMeta(itemMeta);
    }

    @Override
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        ItemStackUtils.applyDisplayName(itemStack, displayName);
    }

    @Override
    public String toString() {
        return "StaticComponentImp{" +
                "itemstack=" + itemStack +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", lore=" + lore +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if(o instanceof ItemStack) {
            ItemStack itemStack = (ItemStack) o;

            if(!itemStack.hasItemMeta())
                return false;

            if(itemStack.getItemMeta().getDisplayName() == null)
                return false;

            if(ItemStackUtils.isSkull(itemStack) && ItemStackUtils.isSkull(this.itemStack))
                if(!testEqualsSkullOwner(itemStack, this.itemStack))
                    return false;

            boolean mesmoDisplayName = itemStack.getItemMeta().getDisplayName().equals(displayName);
            boolean bukkitCheck = itemStack.equals(o);
            return  mesmoDisplayName && bukkitCheck;
        }
        if(o instanceof StaticComponent)
            ((StaticComponent) o).getName().equals(name);

        return super.equals(o);
    }

    private boolean testEqualsSkullOwner(ItemStack itemStack1, ItemStack itemStack2){

        SkullMeta skullMeta1 = (SkullMeta) itemStack1.getItemMeta();
        SkullMeta skullMeta2 = (SkullMeta) itemStack2.getItemMeta();

        return skullMeta1.getOwner().equalsIgnoreCase(skullMeta2.getOwner());
    }
}

