package br.com.playdreamcraft.dreamgui.imp.utils;

import br.com.playdreamcraft.dreamgui.api.page_component.components.ComponentBuilder;
import org.bukkit.Material;
import org.bukkit.SkullType;

/**
 * Created by lucasd on 03/09/16.
 */
public class GUIHelper {

    public static ComponentBuilder createPlayerSkullComponentBuilder(){
        return new ComponentBuilder().setType(Material.SKULL_ITEM).setAmount(1)
                .setData(SkullType.PLAYER.ordinal());
    }

}
