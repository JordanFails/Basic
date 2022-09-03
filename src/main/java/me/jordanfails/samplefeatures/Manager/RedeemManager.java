package me.jordanfails.samplefeatures.Manager;

import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.ConfigurationService;
import me.qiooip.lazarus.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RedeemManager implements Listener {

    @EventHandler
    public void onRedeem(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String uuid = player.getUniqueId().toString();
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

            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.AQUA + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString() + "SimplyHate")) {
                if (!ConfigurationService.getConfig().contains(player.getUniqueId().toString())) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + CC.White + " has redeemed for " + ChatColor.AQUA + ChatColor.BOLD.toString() + "SimplyHate" + ChatColor.WHITE + ".");
                    player.closeInventory();
                    ConfigurationService.getConfig().set(player.getUniqueId().toString(), Integer.parseInt("1"));
                } else if (ConfigurationService.getConfig().contains(player.getUniqueId().toString())) {
                    player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "(!) " + ChatColor.RED + "You have already supported a creator this map!");
                    player.closeInventory();
                    return;
                }
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Pampa")) {
                if (!ConfigurationService.getConfig().contains(player.getUniqueId().toString())) {
                    Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + CC.White + " has redeemed for " + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Pampa" + ChatColor.WHITE + ".");
                    player.closeInventory();
                    ConfigurationService.getConfig().set(player.getUniqueId().toString(), Integer.parseInt("1"));
                } else if (ConfigurationService.getConfig().contains(player.getUniqueId().toString())) {
                    player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "(!) " + ChatColor.RED + "You have already supported a creator this map!");
                    player.closeInventory();
                    return;
                }
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Goos")) {
                if (!ConfigurationService.getConfig().contains(player.getUniqueId().toString())) {
                    Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + CC.White + " has redeemed for " + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Goos" + ChatColor.WHITE + ".");
                    player.closeInventory();
                    ConfigurationService.getConfig().set(player.getUniqueId().toString(), Integer.parseInt("1"));
                } else if (ConfigurationService.getConfig().contains(player.getUniqueId().toString())) {
                    player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "(!) " + ChatColor.RED + "You have already supported a creator this map!");
                    player.closeInventory();
                }
            }
        }
    }


}