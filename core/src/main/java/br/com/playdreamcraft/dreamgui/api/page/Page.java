package br.com.playdreamcraft.dreamgui.api.page;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created by lucasd on 21/07/16.
 * Represents a gui page (inventory), store page components
 */

public interface Page {

    public int getSize();
    public Container getContainer();
    public void setContainer(Container containerss);

    public String getName();
    public String getDisplayName();
    public PageComponent[] getPageComponents();

    public void putPageComponentsPlayerHotbar(Player player);

    public void showGui(Player player);
    public void addComponent(PageComponent pageComponent);
    public void addComponent(PageComponent pageComponent, int index);

    public Inventory getInventory();

    public boolean hasFreeSlot();
    public void clearComponents();
    public void removeComponent(String name);

    public void updateComponents();

}
