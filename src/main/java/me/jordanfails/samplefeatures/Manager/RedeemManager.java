package me.jordanfails.samplefeatures.Manager;

import com.minnymin.command.Command;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RedeemManager implements Listener {

    @EventHandler
    public void onRedeem(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory() != null) {
            if (event.getInventory().getName().startsWith(ChatColor.GRAY + "Redeem")) {
                event.setCancelled(true);
            }

            if (event.getCurrentItem() == null) {
                return;
            }

            if (event.getCurrentItem().getItemMeta() == null) {
                return;
            }

            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + ChatColor.BOLD.toString() + "SimplyHate")){
                if(!SampleFeatures.redeem.contains(player.getUniqueId())){
                    SampleFeatures.redeem.add(event.getWhoClicked().getUniqueId());
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + CC.White + " has redeemed for " + ChatColor.AQUA + ChatColor.BOLD.toString() + "SimplyHate" + ChatColor.WHITE + ".");
                    player.closeInventory();
                }else if(SampleFeatures.redeem.contains(player.getUniqueId())){
                    player.sendMessage(CC.translate("&c&l(!)&c You have already redeemed this map!"));
                    player.closeInventory();
                }
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Pampa")){
                if(!SampleFeatures.redeem.contains(player.getUniqueId())){
                    SampleFeatures.redeem.add(event.getWhoClicked().getUniqueId());
                    Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + CC.White + " has redeemed for " + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Pampa" + ChatColor.WHITE + ".");
                    player.closeInventory();
                }else if(SampleFeatures.redeem.contains(player.getUniqueId())){
                    player.sendMessage(CC.translate("&c&l(!)&c You have already redeemed this map!"));
                    player.closeInventory();
                }
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Goos")){
                if(!SampleFeatures.redeem.contains(player.getUniqueId())){
                    SampleFeatures.redeem.add(event.getWhoClicked().getUniqueId());
                    Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + CC.White + " has redeemed for " + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Goos" + ChatColor.WHITE + ".");
                    player.closeInventory();
                }else if(SampleFeatures.redeem.contains(player.getUniqueId())){
                    player.sendMessage(CC.translate("&c&l(!)&c You have already redeemed this map!"));
                    player.closeInventory();
                }
            }
        }
    }
}