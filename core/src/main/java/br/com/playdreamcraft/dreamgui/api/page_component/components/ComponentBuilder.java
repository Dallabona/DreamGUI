package br.com.playdreamcraft.dreamgui.api.page_component.components;

import br.com.playdreamcraft.dreamgui.Enchantment;
import br.com.playdreamcraft.dreamgui.api.page_component.components.button.Button;
import br.com.playdreamcraft.dreamgui.imp.page_component.components.ButtonImp;
import br.com.playdreamcraft.dreamgui.imp.page_component.components.StaticComponentImp;
import br.com.playdreamcraft.dreamgui.imp.utils.PreConditionsGUI;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lucasd on 30/07/16.
 */
public class ComponentBuilder {

    private Material type;
    private int amount = 1;
    private int data = 0;

    private String name;
    private String displayName;
    private Enchantment enchantment;
    private List<String> lore;


    public ComponentBuilder setType(Material type) {
        this.type = type;
        return this;
    }

    public ComponentBuilder setName(String name) {
        this.name = name;

        if(displayName == null)
            displayName = name;
        return this;
    }

    public ComponentBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ComponentBuilder setEnchantment(Enchantment enchantment) {
        this.enchantment = enchantment;
        return this;
    }

    public ComponentBuilder setAmount(int amount) {
        this.amount = amount;
        return this;
    }

    public ComponentBuilder setData(int data) {
        this.data = data;
        return this;
    }

    public ComponentBuilder setLore(String ... lore) {
        this.lore = new ArrayList<>(Arrays.asList(lore));
        return this;
    }

    public ComponentBuilder setLore(List<String> lore){
        this.lore = lore;
        return this;
    }

    public StaticComponent buildStatic() {
        preConditions();

        StaticComponent staticComponent = new StaticComponentImp(type, name, displayName, enchantment, amount, data);
        staticComponent.setLore(lore);
        return staticComponent;
    }

    public Button buildButton(){
        preConditions();

        Button button = new ButtonImp(type, name, displayName, enchantment, amount, data);
        button.setLore(lore);
        return button;
    }

    private void preConditions(){
        PreConditionsGUI.preConditionsType(type);
        PreConditionsGUI.preConditionsName(name);
        PreConditionsGUI.preConfitionsDisplayName(displayName);
    }

}
