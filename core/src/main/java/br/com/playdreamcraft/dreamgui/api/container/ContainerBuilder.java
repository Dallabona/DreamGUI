package br.com.playdreamcraft.dreamgui.api.container;

import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import br.com.playdreamcraft.dreamgui.imp.container.ContainerImp;
import br.com.playdreamcraft.dreamgui.imp.utils.PreConditionsGUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucasd on 30/07/16.
 */
public class ContainerBuilder {


    private String name;
    private String displayName ="";

    private List<Page> pageList = new ArrayList<>();

    private List<PageComponent> pageComponents = new ArrayList<>();

    private boolean navigator = false;
    private boolean onInteractProcessAction = false;

    public ContainerBuilder addPage(Page page){
        pageList.add(page);
        return this;
    }

    public ContainerBuilder addPage(Page page, int index){
        pageList.add(index, page);
        return this;
    }

    public ContainerBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ContainerBuilder setDisplayName(String displayName){
        this.displayName = displayName;
        return this;
    }

    public ContainerBuilder enableNavigator() {
        this.navigator = true;
        return this;
    }

    public ContainerBuilder enableInteractListener() {
        this.onInteractProcessAction = true;
        return this;
    }

    /**
     * Add a page component, the system automatically populates and create the pages
     * @param pageComponent
     */
    public ContainerBuilder addPageComponent(PageComponent pageComponent){
        pageComponents.add(pageComponent);
        return this;
    }


    public Container build(){
        PreConditionsGUI.preConditionsName(name);

        Container container = new ContainerImp(name, displayName,  navigator, onInteractProcessAction);
        pageList.forEach((page)->container.addPage(page));
        pageComponents.forEach((pageComponent -> container.addPageComponent(pageComponent)));
        return container;
    }

}
