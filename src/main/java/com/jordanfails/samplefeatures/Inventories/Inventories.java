package com.jordanfails.samplefeatures.Inventories;

import com.jordanfails.samplefeatures.SampleFeatures;
import com.jordanfails.samplefeatures.Utils.ItemBuilder;
import com.jordanfails.samplefeatures.Utils.Utils;
import lombok.Getter;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import me.qiooip.lazarus.integration.Chat_Atom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
@Getter
public class Inventories {
    private static SampleFeatures plugin = SampleFeatures.getPlugin(SampleFeatures.class);
    public static void punishFactionInventory(Player player, PlayerFaction playerFaction){
        Inventory inventory = Bukkit.getServer().createInventory(null, 54, Utils.chat("&cPunish faction " + playerFaction.getName()));
        inventory.setItem(13, new ItemBuilder(Material.ANVIL).lore(ChatColor.YELLOW.toString() + playerFaction.getMembers().size() + " members", " " , ChatColor.GRAY + "Click to see members").displayName(ChatColor.RED + "Faction: " + "'" +playerFaction.getName() + "'").build());

        inventory.setItem(20, new ItemBuilder(Material.WOOL).data(DyeColor.YELLOW.getData()).displayName(ChatColor.RED + "Tempmute faction for 1h").build());
        inventory.setItem(29, new ItemBuilder(Material.WOOL).data(DyeColor.ORANGE.getData()).displayName(ChatColor.RED + "Tempmute faction for 24h").build());
        inventory.setItem(38, new ItemBuilder(Material.WOOL).data(DyeColor.RED.getData()).displayName(ChatColor.RED + "Mute faction permanently").build());

        inventory.setItem(22, new ItemBuilder(Material.WOOL).data(DyeColor.YELLOW.getData()).displayName(ChatColor.RED + "Warn faction").build());
        inventory.setItem(31, new ItemBuilder(Material.WOOL).data(DyeColor.ORANGE.getData()).displayName(ChatColor.RED + "Kick faction").build());

        inventory.setItem(24, new ItemBuilder(Material.WOOL).data(DyeColor.YELLOW.getData()).displayName(ChatColor.RED + "Ban faction for 1h").build());
        inventory.setItem(33, new ItemBuilder(Material.WOOL).data(DyeColor.ORANGE.getData()).displayName(ChatColor.RED + "Ban faction for 24h").build());
        inventory.setItem(42, new ItemBuilder(Material.WOOL).data(DyeColor.RED.getData()).displayName(ChatColor.RED + "Ban faction permanently").build());

        player.openInventory(inventory);
    }

    public static void factionMembers(Player player, PlayerFaction playerFaction){
        Inventory inventory = Bukkit.getServer().createInventory(null, 54, Utils.chat("&cPunish faction " + playerFaction.getName()));

        playerFaction.getOnlinePlayers().forEach(member -> {
            inventory.addItem(new ItemBuilder(Material.SKULL_ITEM).displayName(ChatColor.YELLOW + member.getName()).toSkullBuilder().withOwner(member.getDisplayName()).buildSkull());

            inventory.setItem(53, new ItemBuilder(Material.REDSTONE_BLOCK).displayName(ChatColor.RED + "Go back").build());
            player.openInventory(inventory);
        });
    }

    public static void historyGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 54, Utils.chat("History for: &c&n" + player.getName()));

        inventory.setItem(20, new ItemBuilder(Material.WOOL).data(DyeColor.YELLOW.getData()).displayName(ChatColor.YELLOW + "Warnings").build());
        inventory.setItem(29, new ItemBuilder(Material.WOOL).data(DyeColor.ORANGE.getData()).displayName(ChatColor.GOLD + "Mutes").build());
        inventory.setItem(38, new ItemBuilder(Material.WOOL).data(DyeColor.RED.getData()).displayName(ChatColor.RED + "Bans").build());
    }

}
