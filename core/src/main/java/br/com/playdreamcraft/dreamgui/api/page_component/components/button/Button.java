package br.com.playdreamcraft.dreamgui.api.page_component.components.button;

import br.com.playdreamcraft.dreamgui.api.Action;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import org.bukkit.entity.Player;

/**
 * Created by lucasd on 21/07/16.
 */
public interface Button extends PageComponent{

    public void onClick(Player player);
    public void setAction(Action action);

}
