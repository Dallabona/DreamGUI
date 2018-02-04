package br.com.playdreamcraft.dreamgui.imp.container;

import br.com.playdreamcraft.dreamgui.api.container.Paginator;
import br.com.playdreamcraft.dreamgui.api.page.PageNavigator;
import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import br.com.playdreamcraft.dreamgui.imp.page.PageNavigatorImp;
import lombok.Getter;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by lucasd on 21/07/16.
 */
public class ContainerImp implements Container {

    @Getter
    private List<Page> pages = new ArrayList<>();
    @Getter
    private String name;
    @Getter
    private String displayName;

    private PageNavigator pageNavigator;
    private boolean navigatorEnabled;

    @Getter
    private boolean onInteractProcessAction = false;

    private Paginator paginator = new PaginatorImp(this);

    public ContainerImp(String name, String displayName) {
        this(name, displayName, false, false);
    }

    public ContainerImp(String name, String displayName,  boolean navigatorEnabled, boolean onInteractProcessAction) {
        this.name = name;
        this.displayName = displayName;
        this.navigatorEnabled = navigatorEnabled;

        this.onInteractProcessAction = onInteractProcessAction;

        if(navigatorEnabled)
            pageNavigator = new PageNavigatorImp();
    }


    public void addPage(Page page) {
        page.setContainer(this);
        pages.add(page);
        if(navigatorEnabled)
            reAddNavigatorsForAllPages();


    }

    private void reAddNavigatorsForAllPages(){
        pages.forEach(page -> pageNavigator.addNavigator(page, getPageIndex(page), pages.size() ));
    }

    public void addPageComponent(PageComponent pageComponent){
        paginator.addPageComponent(pageComponent);
    }

    @Override
    public int getPageIndex(Page page) {
        for (int i = 0; i < pages.size(); i++) {
            if(pages.get(i).equals(page))
                return i;
        }
        throw new RuntimeException("There is no page "+page.toString()+" in this container");
    }

    @Override
    public Optional<Page> getPagePerInventory(Inventory inventory) {

        for (Page page : pages) {
            if(page.equals(inventory))
                return Optional.of(page);
        }

        return Optional.empty();
    }

    @Override
    public String toString() {
        return "ContainerImp{" +
                "pages=" + pages +
                ", name='" + name + '\'' +
                ", name='" + displayName + '\'' +
                '}';
    }
}
