package br.com.playdreamcraft.dreamgui.api.container;

import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import org.bukkit.inventory.Inventory;

import java.util.List;
import java.util.Optional;

/**
 * Created by lucasd on 21/07/16.
 * Container is a box that store pages
 */
public interface Container {

    public List<Page> getPages();
    /**
     * Add a page manually
     * @param page
     */
    public void addPage(Page page);

    /**
     * Add a page component, the system automatically populates and create the pages
     * @param pageComponent
     */
    public void addPageComponent(PageComponent pageComponent);

    /**
     * A name for internal usages (id), will not be shown, must be unique
     * @return
     */
    public String getName();

    /**
     * The container displayname will be used on paginator, to name the new page created
     * @return
     */
    public String getDisplayName();

    /**
     * Get a page by the inventory
     * @param inventory
     * @return
     */
    public Optional<Page> getPagePerInventory(Inventory inventory);

    /**
     * Get the index of a page, start at 0
     * @param page
     * @return
     */
    public int getPageIndex(Page page);

    /**
     * PlayerInteractEvent handler (hotbar right/left click)
     * @return
     */
    public boolean isOnInteractProcessAction();



}
