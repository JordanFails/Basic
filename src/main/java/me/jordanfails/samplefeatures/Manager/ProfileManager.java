package me.jordanfails.samplefeatures.Manager;

import me.confuser.banmanager.common.ormlite.stmt.query.In;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ProfileManager implements Listener {
    //ArrayList<String> name = new ArrayList<>();

    @EventHandler
    public void onProfileCommand(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory() != null) {
            if (event.getInventory().getName().equals(ChatColor.GRAY + "Your Profile")) {
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

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lStatistics"))) {
                Inventories.statsGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lSocial Media"))) {
                Inventories.socialMedia(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lYour Profile"))) {
                Inventories.publicProfile(player);
                return;
            }


            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lFaction"))) {
                Inventories.factionGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lNotifications"))) {
                Inventories.notifyGUI(player);
            }

        }
    }

    @EventHandler
    public void onStats(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory() != null) {
            if (event.getInventory().getName().equals(CC.translate("&8Statistics"))) {
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

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lStatistics"))) {
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lSocial Media"))) {
                Inventories.socialMedia(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lYour Profile"))) {
                Inventories.publicProfile(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lFaction"))) {
                Inventories.factionGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lNotifications"))) {
                Inventories.notifyGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lHCF Statistics"))) {
                return;
            }
        }
    }

    @EventHandler
    public void onSocialMedia(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory() != null) {
            if (event.getInventory().getName().equals(CC.translate("&8Social Media"))) {
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

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lStatistics"))) {
                Inventories.statsGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lSocial Media"))) {
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lYour Profile"))) {
                Inventories.publicProfile(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lFaction"))) {
                Inventories.factionGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lNotifications"))) {
                Inventories.notifyGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lDiscord"))) {
                player.sendMessage(CC.translate("&cThis feature is a work in progress."));
            }
        }
    }

    @EventHandler
    public void onPublicProfile(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory() != null) {
            if (event.getInventory().getName().equals(CC.translate("&8Your Public Profile"))) {
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

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lStatistics"))) {
                Inventories.statsGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lSocial Media"))) {
                Inventories.socialMedia(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lYour Profile"))) {
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lFaction"))) {
                Inventories.factionGUI(player);
                return;
            }

            if (event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lNotifications"))) {
                Inventories.notifyGUI(player);
                return;
            }
            
            if(event.getCurrentItem().getItemMeta().getDisplayName().equals(CC.translate("&6&lFaction Information"))){
                player.performCommand("f info");
                player.closeInventory();
                return;
                
            }
        }
    }
}