package br.com.playdreamcraft.dreamgui;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by lucasd on 21/07/16.
 */
@RequiredArgsConstructor
public class Enchantment {

    @Getter
    private final org.bukkit.enchantments.Enchantment enchantment;
    @Getter
    private final int level;

}
