package br.com.playdreamcraft.dreamgui.imp.container;

import br.com.playdreamcraft.dreamgui.api.container.Container;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucasd on 21/07/16.
 */
public class ContainersStorage {
    private static ContainersStorage ourInstance = new ContainersStorage();

    @Getter
    private Map<String, Container> containers = new HashMap<>();

    public static ContainersStorage getInstance() {
        return ourInstance;
    }

    private ContainersStorage() {
    }

    public Collection<Container> getAllContainers(){
        return containers.values();
    }

    public void registerContainer(String nome, Container container){
        containers.put(nome, container);
    }

    public void unregisterContainer(Container container){
        unregisterContainer(container.getName());
    }

    public void unregisterContainer(String nome){
        containers.remove(nome);
    }

    public Container getContainer(String nome){
        return containers.get(nome);
    }

    public void clearAllContainers(){
        containers.clear();
    }

}
