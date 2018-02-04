package br.com.playdreamcraft.dreamgui.imp.utils;

import com.google.common.base.Preconditions;
import org.bukkit.Material;

/**
 * Created by lucasd on 20/08/16.
 */
public class PreConditionsGUI {

    public static void preConditionsType(Material type){
        Preconditions.checkNotNull(type,"Type can't be null");
    }

    public static void preConditionsName(String name){
        Preconditions.checkNotNull(name,"Name can't be null");
    }

    public static void preConfitionsDisplayName(String displayName){
        Preconditions.checkNotNull(displayName,"DisplayName can't be null");
    }

}
