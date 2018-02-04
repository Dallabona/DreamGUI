package br.com.playdreamcraft.dreamgui.api;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.imp.container.ContainerBinder;
import br.com.playdreamcraft.dreamgui.imp.container.ContainersStorage;
import br.com.playdreamcraft.dreamgui.imp.listeners.ContainerCleanerListener;
import br.com.playdreamcraft.dreamgui.imp.listeners.InventoryListener;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/**
 * Created by lucasd on 21/07/16.
 */
public class GuiAPI {
    private static GuiAPI ourInstance = new GuiAPI();

    public static GuiAPI getInstance() {
        return ourInstance;
    }
    @Getter
    private ContainersStorage containersStorage = ContainersStorage.getInstance();

    @Getter
    private GUIRegister guiRegister = new GUIRegister();
    @Getter
    private GUIDisplayer guiDisplayer = new GUIDisplayer();

    private boolean setup = false;

    private GuiAPI() {
    }

    public void setupGui(Plugin plugin){
        if(!setup) {
            setup = true;
            Bukkit.getPluginManager().registerEvents(new InventoryListener(), plugin);
            Bukkit.getPluginManager().registerEvents(new ContainerCleanerListener(), plugin);
        }
    }



    public class GUIDisplayer {

        public void showGui(Player player, String containerName){
            Container container = ContainersStorage.getInstance().getContainer(containerName);
            showGui(player, container);
        }

        public void showGui(Player player, String containerName, int page){
            Container container = ContainersStorage.getInstance().getContainer(containerName);
            showGui(player, container, page);
        }

        /**
         * Show the gui to a player (first page)
         * @param player
         * @param container
         */
        public void showGui(Player player, Container container){
            showGui(player, container, 0);
        }

        /**
         * Show a container to a player
         * @param player
         * @param container
         * @param page start at 0 index
         */
        public void showGui(Player player, Container container, int page){
            container.getPages().get(page).showGui(player);
        }

        /**
         * Remove a gui
         * @param player
         */
        public void removeGui(Player player){
            player.closeInventory();
        }
    }


    public class GUIRegister {



        /**
         * Register a container, the api will listen the events and handle the actions
         * @param container
         */
        public void registerContainer(Container container){
            containersStorage.registerContainer(container.getName(), container);
        }

        /**
         * Register a container and associate to a player, when player logoff the container reference will be removed
         * @param container
         */
        public void registerContainerAndBindToPlayer(Container container, String player){
            ContainerBinder.getInstance().bindContainer(player, container);
            containersStorage.registerContainer(container.getName(), container);
        }

        public void registerContainerAndBindToPlayer(Container container, Player player){
            ContainerBinder.getInstance().bindContainer(player.getName(), container);
            containersStorage.registerContainer(container.getName(), container);
        }

        public void unregisterContainerAndUnbind(String container, String player){
            ContainerBinder.getInstance().releaseOneContainer(player, container);
        }

        public void unregisterContainer(Container container){
            unregisterContainer(container);
        }

        public void unregisterContainer(String container){
            containersStorage.unregisterContainer(container);
        }
    }

}
