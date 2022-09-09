package me.jordanfails.samplefeatures.Manager;

import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.ConfigurationService;
import me.qiooip.lazarus.config.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

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
                if (!ConfigurationService.getPlayerConfig().contains(player.getUniqueId().toString())) {
                    Bukkit.getServer().broadcastMessage(ChatColor.AQUA + player.getName() + CC.White + " has redeemed for " + ChatColor.AQUA + ChatColor.BOLD.toString() + "SimplyHate" + ChatColor.WHITE + ".");
                    player.closeInventory();
                    ConfigurationService.getPlayerConfig().set(player.getUniqueId().toString(), true);
                } else if (ConfigurationService.getPlayerConfig().contains(player.getUniqueId().toString())) {
                    player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "(!) " + ChatColor.RED + "You have already supported a creator this map!");
                    player.closeInventory();
                    return;
                }
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Pampa")) {
                if (!ConfigurationService.getPlayerConfig().contains(player.getUniqueId().toString())) {
                    Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + CC.White + " has redeemed for " + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Pampa" + ChatColor.WHITE + ".");
                    player.closeInventory();
                    ConfigurationService.getPlayerConfig().set(player.getUniqueId().toString(), true);
                } else if (ConfigurationService.getPlayerConfig().contains(player.getUniqueId().toString())) {
                    player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "(!) " + ChatColor.RED + "You have already supported a creator this map!");
                    player.closeInventory();
                    return;
                }
            }
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Goos")) {
                if (!ConfigurationService.getPlayerConfig().contains(player.getUniqueId().toString())) {
                    Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + player.getName() + CC.White + " has redeemed for " + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Goos" + ChatColor.WHITE + ".");
                    player.closeInventory();
                    ConfigurationService.getPlayerConfig().set(player.getUniqueId().toString(), true);
                } else if (ConfigurationService.getPlayerConfig().contains(player.getUniqueId().toString())) {
                    player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "(!) " + ChatColor.RED + "You have already supported a creator this map!");
                    player.closeInventory();
                }
            }
        }
    }

    @EventHandler
    public void onFreeRank(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String uuid = player.getUniqueId().toString();
        if (event.getInventory() != null) {
            if (event.getInventory().getName().startsWith(CC.translate("&8Your Profile"))) {
                event.setCancelled(true);
            }

            if (event.getCurrentItem() == null) {
                return;
            }

            if (event.getCurrentItem().getItemMeta() == null) {
                return;
            }

        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&a&l[LIMITED TIME] &r&lF&b&lR&r&lE&b&lE &r&lR&b&lA&r&lN&b&lK"))) {
            if (!ConfigurationService.getFreeRankConfig().contains(player.getUniqueId().toString())) {
                Bukkit.getServer().broadcastMessage(CC.translate("&b&l" + player.getName() + "&r has claimed the &b&nFREE&r &b&nTOP&r &b&nRANK&r, and you can too!"));
                Bukkit.getServer().broadcastMessage(CC.translate("&rUse the command &b&n/freerank&r to claim it!"));
                player.closeInventory();
                ConfigurationService.getFreeRankConfig().set(player.getUniqueId().toString(), true);
            } else if (ConfigurationService.getFreeRankConfig().contains(player.getUniqueId().toString())) {
                player.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "(!) " + ChatColor.RED + "You have already claimed your free rank!");
                player.closeInventory();
                return;
            }
        }

        if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&a&lStore Information&7&o (Click)"))){
            player.performCommand("store");
            player.closeInventory();
        }
    }


}