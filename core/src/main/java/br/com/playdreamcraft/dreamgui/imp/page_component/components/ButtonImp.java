package br.com.playdreamcraft.dreamgui.imp.page_component.components;

import br.com.playdreamcraft.dreamgui.Enchantment;
import br.com.playdreamcraft.dreamgui.api.Action;
import br.com.playdreamcraft.dreamgui.api.page_component.components.button.Button;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Created by lucasd on 21/07/16.
 */
public class ButtonImp extends  StaticComponentImp implements Button {

    private Action action;

    public ButtonImp(Material type, String name, String displayName) {
        super(type, name, displayName, null);
    }

    public ButtonImp(Material type, String name, String displayName, Enchantment enchantment) {
        super(type, name, displayName, enchantment);
    }

    public ButtonImp(Material type, String name, String displayName, Enchantment enchantment, int amount) {
        super(type, name, displayName, enchantment, amount);
    }

    public ButtonImp(Material type, String name, String displayName, Enchantment enchantment, int amount, int data) {
        super(type, name, displayName, enchantment, amount, data);
    }

    @Override
    public void onClick(Player player) {
        if(action != null)
            action.onButtonClick(getPage().getContainer(),getPage(),this, player);
    }

    @Override
    public void setAction(Action action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return super.toString()+"action = "+action;
    }
}
