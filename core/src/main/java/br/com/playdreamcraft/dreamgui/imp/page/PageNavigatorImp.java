package br.com.playdreamcraft.dreamgui.imp.page;

import br.com.playdreamcraft.dreamgui.api.page.PageNavigator;
import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.components.ComponentBuilder;
import br.com.playdreamcraft.dreamgui.api.page_component.components.StaticComponent;
import br.com.playdreamcraft.dreamgui.api.page_component.components.button.Button;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Created by lucasd on 30/07/16.
 *
 * PageNavigator creates buttons to navigate over the pages
 */
public class PageNavigatorImp implements PageNavigator {



    private StaticComponent blank;


    public PageNavigatorImp() {
        blank = new ComponentBuilder().setName("next_page_blank").setDisplayName(" ").
                setType(Material.STAINED_GLASS_PANE).setAmount(1).setData(15).buildStatic();
    }

    private Button generatePreviusPageButton(){
        Button previousPageButton = new ComponentBuilder().setName("previus_page").
                setDisplayName(ChatColor.GREEN+"Voltar").
                setType(Material.STAINED_GLASS_PANE).setAmount(1).setData(11).buildButton();
        previousPageButton.setAction(((container, page, button, player) -> lastPage(player, container.getPageIndex(page),container) ));

        return  previousPageButton;
    }

    private Button generateNextPageButton(){
       Button button = new ComponentBuilder().setName("next_page").setDisplayName(ChatColor.GREEN+"Próximo").
                setType(Material.STAINED_GLASS_PANE).setAmount(1).setData(14).buildButton();

        button.setAction(((container, page, button1, player) -> nextPage(player, container.getPageIndex(page),container) ));
        return button;
    }

    @Override
    public void addNavigator(Page page, int pageIndex, int numberOfPages) {

        int nextPageIndex = page.getSize()-1;
        int previousPageIndex = page.getSize()-9;

        if(pageIndex == 0) //first page, empty previous button
            page.addComponent(blank, previousPageIndex);
        else
            page.addComponent(generatePreviusPageButton(), previousPageIndex);


        if(isLastPage(pageIndex, numberOfPages)) //last page, empty next button
            page.addComponent(blank, nextPageIndex);
        else
            page.addComponent(generateNextPageButton(), nextPageIndex);

    }

    private boolean isLastPage(int pageIndex, int numberOfPages){
        return pageIndex == (numberOfPages-1);
    }

    @Override
    public void nextPage(Player player, int currentPage, Container container) {
        Page nextPage = container.getPages().get(currentPage+1);
        nextPage.showGui(player);
    }

    @Override
    public void lastPage(Player player, int currentPage, Container container) {
        Page lastPage = container.getPages().get(currentPage-1);
        lastPage.showGui(player);
    }
}
