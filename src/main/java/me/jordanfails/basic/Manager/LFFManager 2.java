package me.jordanfails.basic.Manager;

import me.jordanfails.basic.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.UUID;

public class LFFManager implements Listener {

    HashMap<UUID, String> lffChoices = new HashMap<>();

    @EventHandler
    public void onPunish(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        UUID uuid = player.getUniqueId();

        if (event.getInventory() != null) {
            if (event.getInventory().getName().startsWith(ChatColor.GRAY + "Classes")) {
                event.setCancelled(true);
            }

            if(event.getCurrentItem() == null){
                return;
            }

            if(event.getCurrentItem().getItemMeta() == null){
                return;
            }

            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.AquaB + "Diamond")){
                event.setCancelled(true);
                if(!(lffChoices.containsValue("Diamond"))){
                    lffChoices.put(uuid, "Diamond");
                    player.sendMessage(CC.translate("&a&l(!)&a You've added &b&lDiamond&a to your selected classes."));
                }else if(lffChoices.containsValue("Diamond")){
                    lffChoices.remove(uuid, "Diamond");
                    player.sendMessage(CC.translate("&c&l(!)&c You've removed &b&lDiamond&c from your selected classes."));
                }
                return;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.AquaB + "Miner")){
                event.setCancelled(true);
                if(!lffChoices.containsValue("Miner")){
                    lffChoices.put(uuid, "Miner");
                    player.sendMessage(CC.translate("&a&l(!)&a You've added &b&lMiner&a to your selected classes."));
                }else if(lffChoices.containsValue("Miner")){
                    lffChoices.remove(uuid, "Miner");
                    player.sendMessage(CC.translate("&c&l(!)&c You've removed &b&lMiner&c from your selected classes."));
                }
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.GoldB + "Bard")){
                event.setCancelled(true);
                player.sendMessage(CC.translate("&a&l(!)&a You've added &b&lDiamond&a to your selected classes."));

                return;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.LightPurpleB + "Archer")){
                event.setCancelled(true);
                player.sendMessage(CC.translate("&a&l(!)&a You've added &b&lDiamond&a to your selected classes."));

                return;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.RedB + "Rouge")){
                event.setCancelled(true);
                player.sendMessage(CC.translate("&a&l(!)&a You've added &b&lDiamond&a to your selected classes."));

                return;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.YellowB + "Brewer")){
                event.setCancelled(true);
                player.sendMessage(CC.translate("&a&l(!)&a You've added &b&lDiamond&a to your selected classes."));

                return;
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.GreenB + "Confirm Classes")){
                event.setCancelled(true);
                Bukkit.getServer().broadcastMessage(CC.Yellow + CC.Strike + "--------------------------------");
                Bukkit.getServer().broadcastMessage(CC.LightPurpleB + player.getName() + CC.White + " is looking to join a "  + CC.LightPurpleB + "faction");
                Bukkit.getServer().broadcastMessage(CC.White + "Classes » " + lffChoices.values().size());
                Bukkit.getServer().broadcastMessage(CC.Yellow + CC.Strike + "--------------------------------");

                player.sendMessage(CC.translate("&a&l(!)&a You have successfully confirm your classes!"));
                player.closeInventory();
                return;
            }

        }
    }
}