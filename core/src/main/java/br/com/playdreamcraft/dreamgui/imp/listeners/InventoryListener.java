package br.com.playdreamcraft.dreamgui.imp.listeners;

import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page_component.PageComponent;
import br.com.playdreamcraft.dreamgui.api.page_component.components.button.Button;
import br.com.playdreamcraft.dreamgui.imp.page_component.components.ComponentSearcher;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

import static br.com.playdreamcraft.dreamgui.imp.utils.GUIValidators.*;

/**
 * Created by lucasd on 21/07/16.
 */
public class InventoryListener implements Listener{

    private ComponentSearcher componentSearcher = ComponentSearcher.getInstance();


    /**
     * Handle the page component click
     * @param inventoryClickEvent
     */
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onInventoryClick(InventoryClickEvent inventoryClickEvent){

        Inventory inventory = inventoryClickEvent.getClickedInventory();

        ItemStack itemStack = inventoryClickEvent.getCurrentItem();

        if(!isValidItemStack(itemStack))
            return;

        if(!isValidMaterial(itemStack.getType()))
            return;

        if(!hasItemMeta(itemStack))
            return;



        boolean cancelEvent = processClick(inventory, itemStack, ((Player)inventoryClickEvent.getWhoClicked()));

        if(cancelEvent)
            inventoryClickEvent.setCancelled(true);

    }

    private boolean processClick(Inventory inventory, ItemStack itemStack, Player player){


        Optional<PageComponent> pageComponentOptional = componentSearcher.searchPageComponentByItemStackAndInventory(itemStack, inventory);

        if(!pageComponentOptional.isPresent())
            return false;

        PageComponent pageComponent = pageComponentOptional.get();

        if(pageComponent instanceof Button)
            ((Button) pageComponent).onClick(player);

        return true;
    }


    /**
     * Cancel item move
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemInventoryClick(InventoryClickEvent clickEvent){

        if(clickEvent.getClick().isShiftClick())
            return;

        ItemStack itemStack = clickEvent.getCurrentItem();

        if(!isValidItemStack(itemStack))
            return;

        Inventory inventoryDestino = clickEvent.getClickedInventory();
        Optional<Page> pageOptional = componentSearcher.searchPagePerInventory(inventoryDestino);

        if(pageOptional.isPresent())
            clickEvent.setCancelled(true);
    }

    /**
     * Cancel put item on gui inventory, shift button
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemInventoryClickShift(InventoryClickEvent clickEvent){

        if(!clickEvent.getClick().isShiftClick())
            return;

        ItemStack itemStack = clickEvent.getCurrentItem();

        if(!isValidItemStack(itemStack))
            return;

        if(!isValidMaterial(itemStack.getType()))
            return;

        Inventory inventoryDestino = clickEvent.getInventory();
        Optional<Page> pageOptional = componentSearcher.searchPagePerInventory(inventoryDestino);

        if(pageOptional.isPresent())
            clickEvent.setCancelled(true);
    }

     /**
     * Cancel item move
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onItemInventoryDrag(InventoryDragEvent inventoryMoveItemEvent){

        Inventory inventoryDestino = inventoryMoveItemEvent.getInventory();
        Optional<Page> pageOptional = componentSearcher.searchPagePerInventory(inventoryDestino);

        if(pageOptional.isPresent())
            inventoryMoveItemEvent.setCancelled(true);
    }

    /**
     * Handle the right click hotbar ( interact )
     * @param event
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void hotbarClick(PlayerInteractEvent event){
        Action action = event.getAction();
        ItemStack itemStack = event.getItem();

        if(!isValidItemStack(itemStack))
            return;

        if(!isValidAction(action))
            return;

        if(!isValidMaterial(itemStack.getType()))
            return;

        if(!hasItemMeta(itemStack))
            return;

        // if is a gui item, we need to cancel the click
        if(processHotbarInteract(itemStack, event.getPlayer()))
            event.setCancelled(true);
    }

    private boolean processHotbarInteract(ItemStack itemStack, Player player){
        ComponentSearcher componentSearcher = ComponentSearcher.getInstance();

        Optional<PageComponent> pageComponentOptional = componentSearcher.searchPageComponentByItemStack(itemStack, true);
        if(!pageComponentOptional.isPresent())
            return false;

        PageComponent pageComponent = pageComponentOptional.get();

        if(pageComponent instanceof Button)
            ((Button) pageComponent).onClick(player);

        return true;
    }

    /**
     * When the interact mode is enable, player can't drop the item
     * @param dropItemEvent
     */
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void hotbarDropItem(PlayerDropItemEvent dropItemEvent){
        ItemStack itemStack = dropItemEvent.getItemDrop().getItemStack();

        if(!isValidItemStack(itemStack))
            return;

        Optional<PageComponent> pageComponentOptional =  componentSearcher.searchPageComponentByItemStack(itemStack, true);

        if(pageComponentOptional.isPresent())
            dropItemEvent.setCancelled(true);
    }

    /**
     * When the interact mode is enable, we need to process the inventory click of the hotbar
     * @param onInventoryClick
     */
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onClickHotBar(InventoryClickEvent onInventoryClick){
        ItemStack itemStack = onInventoryClick.getCurrentItem();

        Player player = null;
        if(onInventoryClick.getWhoClicked() instanceof Player)
           player = (Player) onInventoryClick.getWhoClicked();

        if(player == null)
            return;

        if(!isValidItemStack(itemStack))
            return;

        Optional<PageComponent> pageComponentOptional = componentSearcher.searchPageComponentByItemStack(itemStack, true);

        if(!pageComponentOptional.isPresent())
            return;

        PageComponent pageComponent = pageComponentOptional.get();

        if(pageComponent instanceof Button)
            ((Button) pageComponent).onClick(player);

        // When the interact mode is enable, player can't move the item of hotbar
        onInventoryClick.setCancelled(true);
    }






}
