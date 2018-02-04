package br.com.playdreamcraft.dreamgui.imp.listeners;

import br.com.playdreamcraft.dreamgui.imp.container.ContainerBinder;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by lucasd on 18/08/16.
 * On player quit release all containers that was binded to a player
 */
public class ContainerCleanerListener implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onLogout(PlayerQuitEvent playerQuitEvent){
        ContainerBinder.getInstance().releaseAllContainers(playerQuitEvent.getPlayer());
    }

}
