package br.com.playdreamcraft.dreamgui.api.page;

import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import br.com.playdreamcraft.dreamgui.imp.page.PageImp;
import br.com.playdreamcraft.dreamgui.imp.utils.PreConditionsGUI;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class PageBuilder {
    private int size = 54;
    private String name;
    private String displayName ="";

    private List<PageComponent> pageComponentList = new ArrayList<>(60);

    public PageBuilder() {
        for (int i = 0; i < 61; i++) {
            pageComponentList.add(null);
        }
    }

    public PageBuilder setSize(int size) {
        this.size = size;
        return this;
    }

    public PageBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PageBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public PageBuilder addPageComponent(PageComponent pageComponent){
        for (int i = 0; i < pageComponentList.size(); i++) {
            if(pageComponentList.get(i) == null) {
                pageComponentList.set(i, pageComponent);
                break;
            }
        }
        pageComponentList.add(pageComponent);
        return this;
    }

    public PageBuilder addPageComponent(PageComponent pageComponent, int index){
        Preconditions.checkArgument(index<size, "Index out of bounds, the size of the page is "+size);
        pageComponentList.set(index, pageComponent);
        return this;
    }

    public Page build() {
        PreConditionsGUI.preConditionsName(name);
        PreConditionsGUI.preConfitionsDisplayName(displayName);
        Page page = new PageImp(size, name, displayName);
        for (int i = 0; i < size; i++) {
            page.addComponent(pageComponentList.get(i), i);
        }
        return page;
    }
}