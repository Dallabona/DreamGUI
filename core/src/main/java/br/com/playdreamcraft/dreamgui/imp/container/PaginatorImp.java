package br.com.playdreamcraft.dreamgui.imp.container;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.api.container.Paginator;
import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page.PageBuilder;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import lombok.RequiredArgsConstructor;
import net.md_5.bungee.api.ChatColor;

import java.util.Optional;

/**
 * Created by lucasd on 26/08/16.
 */
@RequiredArgsConstructor
public class PaginatorImp implements Paginator{

    private final Container container;

    public void addPageComponent(PageComponent pageComponent){
        Optional<Page> firstPageFree = firstFreeSlot();
        if(firstPageFree.isPresent())
            firstPageFree.get().addComponent(pageComponent);
        else{
            int indexNewPage = container.getPages().size();
            String name = container.getName()+"-"+indexNewPage;
            Page page = new PageBuilder().setName(name).
                    setDisplayName(container.getDisplayName()+ ChatColor.RED+" Página "+(indexNewPage+1) )
                    .setSize(54)
                    .addPageComponent(pageComponent)
                    .build();
            container.addPage(page);
        }

    }

    private Optional<Page> firstFreeSlot(){
        for (Page page : container.getPages()) {
            if(page.hasFreeSlot())
                return Optional.of(page);
        }
        return Optional.empty();
    }
}
