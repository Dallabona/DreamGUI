package br.com.playdreamcraft.dreamgui.imp.page_component.components;

import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;


/**
 * Created by lucasd on 21/01/17.
*/
@Getter
public class ItemStackGUI extends ItemStack{

    private final PageComponent pageComponent;

    public ItemStackGUI(PageComponent pageComponent) {
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(int type, PageComponent pageComponent) {
        super(type);
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(Material type, PageComponent pageComponent) {
        super(type);
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(int type, int amount, PageComponent pageComponent) {
        super(type, amount);
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(Material type, int amount, PageComponent pageComponent) {
        super(type, amount);
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(int type, int amount, short damage, PageComponent pageComponent) {
        super(type, amount, damage);
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(Material type, int amount, short damage, PageComponent pageComponent) {
        super(type, amount, damage);
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(int type, int amount, short damage, Byte data, PageComponent pageComponent) {
        super(type, amount, damage, data);
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(Material type, int amount, short damage, Byte data, PageComponent pageComponent) {
        super(type, amount, damage, data);
        this.pageComponent = pageComponent;
    }

    public ItemStackGUI(ItemStack stack, PageComponent pageComponent) throws IllegalArgumentException {
        super(stack);
        this.pageComponent = pageComponent;
    }

}
