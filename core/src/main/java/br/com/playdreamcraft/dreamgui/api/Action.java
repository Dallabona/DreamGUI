package br.com.playdreamcraft.dreamgui.api;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.components.button.Button;
import org.bukkit.entity.Player;

/**
 * Created by lucasd on 30/07/16.
 */
public interface Action {

    public void onButtonClick(Container container, Page page, Button button, Player player);

}
