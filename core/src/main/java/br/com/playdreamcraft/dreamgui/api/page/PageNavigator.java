package br.com.playdreamcraft.dreamgui.api.page;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import org.bukkit.entity.Player;

/**
 * Created by lucasd on 30/07/16.
 */
public interface PageNavigator {

    public void addNavigator(Page page, int pageIndex, int numberOfPages);
    public void nextPage(Player player, int currentPage, Container container);
    public void lastPage(Player player, int currentPage, Container container);

}
