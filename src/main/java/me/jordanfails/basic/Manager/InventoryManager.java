package me.jordanfails.basic.Manager;

import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.Cooldown;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryManager implements Listener {

    @EventHandler
    public void onYoutubeClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String name = player.getName();
        if (event.getInventory() != null) {
            if (event.getInventory().getName().equals(CC.translate("&"))) {
                event.setCancelled(true);
            }

            if (event.getCurrentItem() == null) {
                return;
            }

            if (event.getCurrentItem().getItemMeta() == null) {
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate(" "))) {
                return;
            }

            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&c&lYouTube Requirements"))){
                if(Cooldown.isOnCooldown("lff_cooldown", player)){
                    player.sendMessage(CC.translate("&cYou are still on cooldown for &c&l" + Basic.getRemaining(Cooldown.getCooldownForPlayerLong("youtube_cooldown", player), true)));
                    player.closeInventory();
                    return;
                }

                for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()){
                    if(onlinePlayers.hasPermission("hcf.staff.youtube")){
                       onlinePlayers.sendMessage(CC.translate("&6&l" + name + "&r is trying to apply for &c&nYouTube&r Rank!"));
                       player.sendMessage(ChatColor.GREEN + "Your request has been sent to staff members!");
                       Cooldown.addCooldown("youtube_cooldown", player, 1800);
                    }
                }
                player.closeInventory();
            }
        }
    }
}
