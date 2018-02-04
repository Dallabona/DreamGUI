package br.com.playdreamcraft.dreamgui.imp.page_component.components.specific;

import br.com.playdreamcraft.dreamgui.imp.page_component.components.StaticComponentImp;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullStaticComponent extends StaticComponentImp {

    public SkullStaticComponent(String name, String displayName, String owner) {
        super(Material.SKULL_ITEM, name, displayName, null, 1, SkullType.PLAYER.ordinal());

        SkullMeta skullMeta = (SkullMeta) getItemStack().getItemMeta();
        skullMeta.setOwner(owner);

        getItemStack().setItemMeta(skullMeta);
    }

}
