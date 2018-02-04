package br.com.playdreamcraft.dreamgui.imp.container;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import com.google.common.collect.ImmutableSet;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by lucasd on 18/08/16.
 * Bind multiple containers to a player, get it when you need
 *
 * PS: When a player logoff the container binded will be released , we don't like memory leaks :D
 */
public class ContainerBinder {
    private static ContainerBinder ourInstance = new ContainerBinder();

    public static ContainerBinder getInstance() {
        return ourInstance;
    }

    private ContainerBinder() {
    }

    private Map<String, Set<String>> playerContainerMap = new HashMap<>();

    /**
     * Bind a container to a player
     * @param player
     * @param container
     */
    public void bindContainer(String player, String container){
        if(playerContainerMap.containsKey(player))
            playerContainerMap.get(player).add(container);
        else{
            Set<String> containers = new HashSet<>();
            containers.add(container);
            playerContainerMap.put(player, containers);
        }
    }

    public void bindContainer(Player player, String container){
        bindContainer(player.getName(), container);
    }

    public void bindContainer(String player, Container container){
        bindContainer(player, container.getName());
    }

    public void bindContainer(Player player, Container container){
        bindContainer(player.getName(), container.getName());
    }

    /**
     * Get all the containers that was binded to a player
     * @param player
     * @return
     */
    public ImmutableSet<Container> getAllContainersByPlayer(String player){
        Set<Container> containers = new HashSet<>();

        playerContainerMap.get(player).forEach(containerName ->  containers.add(ContainersStorage.getInstance().getContainer(containerName)));

        return ImmutableSet.copyOf(containers);
    }

    public ImmutableSet<Container> getAllContainersByPlayer(Player player){
        return getAllContainersByPlayer(player.getName());
    }

    /**
     * Release the resources of all the containers binded to a player
     * @param player
     */
    public void releaseAllContainers(String player){
        if(!playerContainerMap.containsKey(player))
            return;

        playerContainerMap.get(player).forEach((containerName-> ContainersStorage.getInstance().unregisterContainer(containerName)));

        playerContainerMap.remove(player);
    }

    public void releaseAllContainers(Player player){
        releaseAllContainers(player.getName());
    }

    /**
     * Release the resources of one container binded to a player
     * @param player
     */
    public void releaseOneContainer(String player, String container){
        if(!playerContainerMap.containsKey(player))
            return;

        playerContainerMap.get(player).remove(container);
        ContainersStorage.getInstance().unregisterContainer(container);
    }

    public void releaseOneContainer(Player player, String container){
        releaseOneContainer(player.getName(), container);
    }

    public void releaseOneContainer(Player player, Container container){
        releaseOneContainer(player.getName(), container.getName());
    }


}
