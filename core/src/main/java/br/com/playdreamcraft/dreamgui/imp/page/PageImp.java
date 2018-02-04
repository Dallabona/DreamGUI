package br.com.playdreamcraft.dreamgui.imp.page;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import br.com.playdreamcraft.dreamgui.imp.utils.InventoryCreator;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created by lucasd on 21/07/16.
 */
@Getter
public class PageImp implements Page {


    private Inventory inventory;
    private int size;
    private String name;
    private String displayName;
    @Setter
    private Container container;
    private PageComponent[] pageComponents;



    public PageImp(int size, String name, String displayName) {
        if(size % 9 != 0)
            throw new RuntimeException("Size must be a multiple of 9");


        pageComponents = new PageComponent[size];

        this.size = size;
        this.name = name;
        this.displayName = displayName;
        setupInventory();
    }

    private void setupInventory(){
        Inventory bukkitBackendInventory =  InventoryCreator.getInstance().createInventory(displayName, size);
        inventory= bukkitBackendInventory;
        //inventory = new InventoryGUI(bukkitBackendInventory, this);
    }

    public void addComponent(PageComponent pageComponent){
        if(pageComponent != null)
            pageComponent.setPage(this);

        for (int i = 0; i < pageComponents.length; i++) {
            if(pageComponents[i] == null) {
                pageComponents[i] = pageComponent;
                break;
            }
        }
        populateInventory();
        
    }

    public void addComponent(PageComponent pageComponent, int index){
        if(pageComponent != null)
            pageComponent.setPage(this);
        pageComponents[index] = pageComponent;
        populateInventory();
    }


    public void removeComponent(String name){
        for (int i = 0; i < pageComponents.length; i++) {
            if(pageComponents[i] == null)
                continue;
            if(pageComponents[i].getName().equals(name))
                pageComponents[i] = null;
        }
        populateInventory();
    }

    public void clearComponents(){
        for (int i = 0; i < pageComponents.length; i++) {
            pageComponents[i] = null;
        }
        populateInventory();
    }

    @Override
    public void showGui(Player player) {
        player.openInventory(inventory);
    }

    private void populateInventory(){
        for (int i = 0; i < pageComponents.length; i++) {

            if(pageComponents[i] == null)
                continue;

            inventory.setItem(i, pageComponents[i].getItemStack());
        }
    }

    @Override
    public boolean hasFreeSlot() {
        for (int i = 0; i < pageComponents.length; i++) {

            if(pageComponents[i] == null)
                return true;
        }
        return false;
    }

    @Override
    public void updateComponents() {
        for (int i = 0; i < pageComponents.length; i++) {
            if(pageComponents[i] == null)
                continue;

            PageComponent pageComponent = pageComponents[i];

            inventory.setItem(i, pageComponent.getItemStack());
        }
    }


    @Override
    public boolean equals(Object o) {
        if(o instanceof Inventory)
            return inventory.equals(o);

          return  super.equals(o);
    }

    @Override
    public int hashCode() {
        int result = inventory != null ? inventory.hashCode() : 0;
        result = 31 * result + size;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (pageComponents != null ? pageComponents.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PageImp{" +
                "inventory=" + inventory +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                ", pageComponents=" + pageComponents +
                '}';
    }

    @Override
    public void putPageComponentsPlayerHotbar(Player player) {
        for (int i = 0; i < 9; i++) {
            if(pageComponents[i] != null)
                player.getInventory().setItem(i, pageComponents[i].getItemStack());
        }
    }
}
