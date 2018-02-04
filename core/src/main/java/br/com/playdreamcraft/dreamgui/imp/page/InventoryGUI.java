package br.com.playdreamcraft.dreamgui.imp.page;

import br.com.playdreamcraft.dreamgui.api.page.Page;
import lombok.RequiredArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by lucasd on 21/01/17.
 */
@RequiredArgsConstructor
public class InventoryGUI implements Inventory {

    private final Inventory bukkitBackendInventory;
    private final Page page;

    @Override
    public int getSize() {
        return bukkitBackendInventory.getSize();
    }

    @Override
    public int getMaxStackSize() {
        return bukkitBackendInventory.getMaxStackSize();
    }

    @Override
    public void setMaxStackSize(int i) {
        bukkitBackendInventory.setMaxStackSize(i);
    }

    @Override
    public String getName() {
        return bukkitBackendInventory.getName();
    }

    @Override
    public ItemStack getItem(int i) {
        return bukkitBackendInventory.getItem(i);
    }

    @Override
    public void setItem(int i, ItemStack itemStack) {
        bukkitBackendInventory.setItem(i, itemStack);
    }

    @Override
    public HashMap<Integer, ItemStack> addItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return bukkitBackendInventory.addItem(itemStacks);
    }

    @Override
    public HashMap<Integer, ItemStack> removeItem(ItemStack... itemStacks) throws IllegalArgumentException {
        return bukkitBackendInventory.removeItem(itemStacks);
    }

    @Override
    public ItemStack[] getContents() {
        return bukkitBackendInventory.getContents();
    }

    @Override
    public void setContents(ItemStack[] itemStacks) throws IllegalArgumentException {
        bukkitBackendInventory.setContents(itemStacks);
    }

    @Override
    @Deprecated
    public boolean contains(int i) {
        return bukkitBackendInventory.contains(i);
    }

    @Override
    public boolean contains(Material material) throws IllegalArgumentException {
        return bukkitBackendInventory.contains(material);
    }

    @Override
    public boolean contains(ItemStack itemStack) {
        return bukkitBackendInventory.contains(itemStack);
    }

    @Override
    @Deprecated
    public boolean contains(int i, int i1) {
        return bukkitBackendInventory.contains(i, i1);
    }

    @Override
    public boolean contains(Material material, int i) throws IllegalArgumentException {
        return bukkitBackendInventory.contains(material, i);
    }

    @Override
    public boolean contains(ItemStack itemStack, int i) {
        return bukkitBackendInventory.contains(itemStack, i);
    }

    @Override
    public boolean containsAtLeast(ItemStack itemStack, int i) {
        return bukkitBackendInventory.containsAtLeast(itemStack, i);
    }

    @Override
    @Deprecated
    public HashMap<Integer, ? extends ItemStack> all(int i) {
        return bukkitBackendInventory.all(i);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(Material material) throws IllegalArgumentException {
        return bukkitBackendInventory.all(material);
    }

    @Override
    public HashMap<Integer, ? extends ItemStack> all(ItemStack itemStack) {
        return bukkitBackendInventory.all(itemStack);
    }

    @Override
    @Deprecated
    public int first(int i) {
        return bukkitBackendInventory.first(i);
    }

    @Override
    public int first(Material material) throws IllegalArgumentException {
        return bukkitBackendInventory.first(material);
    }

    @Override
    public int first(ItemStack itemStack) {
        return bukkitBackendInventory.first(itemStack);
    }

    @Override
    public int firstEmpty() {
        return bukkitBackendInventory.firstEmpty();
    }

    @Override
    @Deprecated
    public void remove(int i) {
        bukkitBackendInventory.remove(i);
    }

    @Override
    public void remove(Material material) throws IllegalArgumentException {
        bukkitBackendInventory.remove(material);
    }

    @Override
    public void remove(ItemStack itemStack) {
        bukkitBackendInventory.remove(itemStack);
    }

    @Override
    public void clear(int i) {
        bukkitBackendInventory.clear(i);
    }

    @Override
    public void clear() {
        bukkitBackendInventory.clear();
    }

    @Override
    public List<HumanEntity> getViewers() {
        return bukkitBackendInventory.getViewers();
    }

    @Override
    public String getTitle() {
        return bukkitBackendInventory.getTitle();
    }

    @Override
    public InventoryType getType() {
        return bukkitBackendInventory.getType();
    }

    @Override
    public InventoryHolder getHolder() {
        return bukkitBackendInventory.getHolder();
    }

    @Override
    public ListIterator<ItemStack> iterator() {
        return bukkitBackendInventory.iterator();
    }

    @Override
    public ListIterator<ItemStack> iterator(int i) {
        return bukkitBackendInventory.iterator(i);
    }

    @Override
    public void forEach(Consumer<? super ItemStack> consumer) {
        bukkitBackendInventory.forEach(consumer);
    }

    @Override
    public Spliterator<ItemStack> spliterator() {
        return bukkitBackendInventory.spliterator();
    }

    @Override
    public String toString() {
        return "InventoryGUI{" +
                "bukkitBackendInventory=" + bukkitBackendInventory +
                '}';
    }
}
