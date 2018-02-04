package br.com.playdreamcraft.dreamgui.api.page_component;

import br.com.playdreamcraft.dreamgui.api.page.Page;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by lucasd on 21/07/16.
 * Represents the page components, buttons, static component (itemstack)
 */
public interface PageComponent {

    public Page getPage();
    public void setPage(Page page);
    public String getName();
    public void setDisplayName(String displayName);
    public String getDisplayName();
    public ItemStack getItemStack();
    public void setLore(String ... lore);
    public void setLore(List<String> lore);
    public List<String> getLore();
}
