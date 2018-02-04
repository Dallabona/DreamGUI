package br.com.playdreamcraft.guitest;

import br.com.playdreamcraft.dreamgui.api.GuiAPI;
import br.com.playdreamcraft.dreamgui.api.container.Container;
import br.com.playdreamcraft.dreamgui.api.container.ContainerBuilder;
import br.com.playdreamcraft.dreamgui.api.page.Page;
import br.com.playdreamcraft.dreamgui.api.page.PageBuilder;
import br.com.playdreamcraft.dreamgui.api.page_component.components.ComponentBuilder;
import br.com.playdreamcraft.dreamgui.api.page_component.components.button.Button;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by lucasd on 21/07/16.
 */
public class GuiTest extends JavaPlugin implements Listener {


    int ra = 0;
        @Override
        public void onDisable() {
            HandlerList.unregisterAll((Plugin) this);
        }

        @Override
        public void onEnable() {
            GuiAPI.getInstance().setupGui(this);
            Bukkit.getPluginManager().registerEvents(this, this);
            criarGUI();
            criarAtualizadorGUI();
        }

        private void criarAtualizadorGUI(){

            Bukkit.getScheduler().scheduleSyncRepeatingTask(this, () -> {
                Button button = (Button) GuiAPI.getInstance().getContainersStorage().getContainer("teste").getPages().get(0).getPageComponents()[0];
                button.setLore("teste "+ra);
                button.setDisplayName("aa"+ra);
                Page page = button.getPage();

                page.updateComponents();

                ra++;
                System.out.println("Atualizou "+button);
            }, 0 , 20 );
        }


        private void criarGUI(){
            Button button = new ComponentBuilder().setName("teste").setDisplayName(":D").setType(Material.SUGAR_CANE).setLore("teste").buildButton();
            Page page = new PageBuilder().setName("tra").setDisplayName("tro").addPageComponent(button).build();
            Container container = new ContainerBuilder().setName("teste").addPage(page).build();
            button.setAction((container1, page1, button1, player) -> System.out.println("hai"));
            GuiAPI.getInstance().getGuiRegister().registerContainer(container);

        }


    @EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent){
        Bukkit.getScheduler().runTaskLater(this, ()-> GuiAPI.getInstance().getGuiDisplayer().showGui(playerJoinEvent.getPlayer(), "teste"), 20);

    }

    /*@EventHandler
    public void onJoin(PlayerJoinEvent playerJoinEvent){

        Enchantment enchantment = new Enchantment(org.bukkit.enchantments.Enchantment.DAMAGE_UNDEAD, 10);
        Button button = new ComponentBuilder().setType(Material.SUGAR_CANE).setName("cana").setDisplayName(ChatColor.GREEN + "Cana canosa")
                .setEnchantment(enchantment).buildButton();



        button.setAction((container, page, botao, player)->{
                container.getPages().get(1).showGui(player) ;
            System.out.println("Botao clico "+botao.getDisplayName());}
       );

       //Page page2 = new PageBuilder().setSize(9).setName("testeeee").setDisplayName("aleho").addPageComponent(button2).build();


        Page page = new PageBuilder().setSize(54).setName("testegui").
                setDisplayName("Testee").build();
        page.addComponent(button, 18);





        Container container = new ContainerBuilder().setName("teste").setDisplayName(ChatColor.GREEN+"Kits").enableNavigator().enableInteractListener().build();

        for (int i = 0; i < 80; i++) {
            Button button2 = new ComponentBuilder().setType(Material.SUGAR_CANE).setAmount(1).
                    setName("barrier").setDisplayName(ChatColor.GREEN + "Barrier barriosa")
                    .setEnchantment(enchantment).buildButton();
            container.addPageComponent(button2);
        }





        GuiAPI.getInstance().getGuiRegister().registerContainer(container);




            Bukkit.getScheduler().runTaskLater(this, ()->{
                        GuiAPI.getInstance().getGuiDisplayer().showGui(playerJoinEvent.getPlayer(), container);
                playerJoinEvent.getPlayer().getInventory().addItem(button.getItemStack());

                },60);

    }*/





}
