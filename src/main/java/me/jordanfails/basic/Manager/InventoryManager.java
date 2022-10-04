package me.jordanfails.basic.Manager;

import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.Cooldown;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static net.md_5.bungee.api.ChatColor.DARK_PURPLE;

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
                if(Cooldown.isOnCooldown("youtube_cooldown", player)){
                    event.setCancelled(true);
                    player.sendMessage(CC.translate("&cYou are still on cooldown for &c&l" + Basic.getRemaining(Cooldown.getCooldownForPlayerLong("youtube_cooldown", player), true)));
                    player.closeInventory();
                    return;
                }

                for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()){
                    if(onlinePlayers.hasPermission("hcf.staff.media")){
                       onlinePlayers.sendMessage(CC.translate("&6&l" + name + "&r is trying to apply for &c&nYouTube&r Rank!"));
                        player.sendMessage(ChatColor.GREEN + "Your request has been sent to staff members!");
                        Cooldown.addCooldown("youtube_cooldown", player, 1800);
                        player.closeInventory();
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPartnerClick(InventoryClickEvent event) {
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

            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&b&lPartner Requirements"))){
                if(Cooldown.isOnCooldown("partner_cooldown", player)){
                    event.setCancelled(true);
                    player.sendMessage(CC.translate("&cYou are still on cooldown for &c&l" + Basic.getRemaining(Cooldown.getCooldownForPlayerLong("partner_lookdown", player), true)));
                    player.closeInventory();
                    return;
                }

                for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()){
                    if(onlinePlayers.hasPermission("hcf.staff.media")){
                        onlinePlayers.sendMessage(CC.translate("&6&l" + name + "&r is trying to apply for &b&lPartner&r Rank!"));
                        player.sendMessage(ChatColor.GREEN + "Your request has been sent to staff members!");
                        Cooldown.addCooldown("partner_cooldown", player, 1800);
                        player.closeInventory();
                    }
                }
            }
        }
    }

    @EventHandler
    public void onTwitchClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String name = player.getName();
        TextComponent message = new TextComponent(CC.translate("&6&lMedia&7 » &6&l" + name + "&r is trying to apply for &5&nTwitch&r Rank!"));
        message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/msg " + name + " Create a Ticket in our Discord in #open-a-ticket!"));
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

            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&5&lTwitch Requirements"))){
                if(Cooldown.isOnCooldown("twitch_cooldown", player)){
                    event.setCancelled(true);
                    player.sendMessage(CC.translate("&cYou are still on cooldown for &c&l" + Basic.getRemaining(Cooldown.getCooldownForPlayerLong("twitch_cooldown", player), true)));
                    player.closeInventory();
                    return;
                }

                for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()){
                    if(onlinePlayers.hasPermission("hcf.staff.media")){
                        onlinePlayers.spigot().sendMessage(message);
                        player.sendMessage(ChatColor.GREEN + "Your request has been sent to staff members!");
                        Cooldown.addCooldown("twitch_cooldown", player, 1800);
                        player.closeInventory();
                    }
                }
            }
        }
    }
}
