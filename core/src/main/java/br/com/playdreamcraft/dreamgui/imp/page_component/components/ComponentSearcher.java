package br.com.playdreamcraft.dreamgui.imp.page_component.components;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import br.com.playdreamcraft.dreamgui.imp.container.ContainersStorage;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

/**
 * Created by lucasd on 13/09/16.
 */
public class ComponentSearcher {
    private static ComponentSearcher ourInstance = new ComponentSearcher();

    public static ComponentSearcher getInstance() {
        return ourInstance;
    }

    private ContainersStorage containersStorage = ContainersStorage.getInstance();



    public Optional<PageComponent> searchPageComponentByName(String name, Page page){
        for (PageComponent pageComponent : page.getPageComponents()) {
            if(pageComponent == null)
                continue;
            if(pageComponent.getName().equals(name))
                return Optional.of(pageComponent);
        }
        return Optional.empty();
    }

    public Optional<Page> searchPagePerInventory(Inventory inventory){
        for (Container containerFor : containersStorage.getContainers().values()) {
            Optional<Page> page = containerFor.getPagePerInventory(inventory);
            if(page.isPresent())
                return page;
        }
        return Optional.empty();
    }

    public Optional<PageComponent> searchPageComponentByItemStackAndInventory(ItemStack itemStack, Inventory inventory){
        for (Container containerFor : containersStorage.getContainers().values()) {

            Optional<Page> page =  containerFor.getPagePerInventory(inventory);

            if(!page.isPresent())
                continue;

            for (PageComponent pageComponent : page.get().getPageComponents()) {

                if(pageComponent == null)
                    continue;


                if(!pageComponent.equals(itemStack))
                    continue;


                return Optional.of(pageComponent);
            }
        }

        return Optional.empty();
    }

    public Optional<PageComponent> searchPageComponentByItemStack(ItemStack itemStack, boolean onlyOnIteract){
        for (Container containerFor : containersStorage.getContainers().values()) {

            if(onlyOnIteract) {
                if (!containerFor.isOnInteractProcessAction())
                    continue;
            }

            for (Page page : containerFor.getPages()) {
                for (int i = 0; i < page.getPageComponents().length; i++) {



                    PageComponent pageComponent = page.getPageComponents()[i];
                    if(pageComponent == null)
                        continue;

                    if(!pageComponent.equals(itemStack))
                        continue;

                    return Optional.of(pageComponent);

                }
            }
        }
        return Optional.empty();
    }

    public Optional<PageComponent> searchPageComponentByItemStack(ItemStack itemStack){
        return searchPageComponentByItemStack(itemStack, false);
    }

}
