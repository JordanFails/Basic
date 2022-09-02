package me.jordanfails.samplefeatures.Inventories;

import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.ItemBuilder;
import me.jordanfails.samplefeatures.Utils.Utils;
import lombok.Getter;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
@Getter
public class Inventories {
    private static final SampleFeatures plugin = SampleFeatures.get();
    public static void punishFactionInventory(Player player, PlayerFaction playerFaction){
        Inventory inventory = Bukkit.getServer().createInventory(null, 54, CC.translate("&cPunish faction " + playerFaction.getName()));
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
        Inventory inventory = Bukkit.getServer().createInventory(null, 54, CC.translate("History for: &c&n" + player.getName()));

        inventory.setItem(20, new ItemBuilder(Material.WOOL).data(DyeColor.YELLOW.getData()).displayName(ChatColor.YELLOW + "Warnings").build());
        inventory.setItem(29, new ItemBuilder(Material.WOOL).data(DyeColor.ORANGE.getData()).displayName(ChatColor.GOLD + "Mutes").build());
        inventory.setItem(38, new ItemBuilder(Material.WOOL).data(DyeColor.RED.getData()).displayName(ChatColor.RED + "Bans").build());
    }

    public static void abilityGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 54, CC.translate("&7Partner Items"));

        inventory.setItem(13, new ItemBuilder(Material.ANVIL).lore(ChatColor.YELLOW.toString()  + " members", " " , ChatColor.GRAY + "Click to see members").displayName(ChatColor.RED + "Faction: " + "'" +player.getName() + "'").build());

        inventory.setItem(0, new ItemBuilder(Material.ENDER_PEARL).loreLine(CC.White + " " + CC.LightPurple.toString() + "|" + "If thrown, you will revive").loreLine(CC.White + "special potions effects!").displayName(CC.DarkPurpleB + "Aggressive Pearl").build());
        inventory.setItem(1, new ItemBuilder(Material.INK_SACK).data(DyeColor.ORANGE.getData()).loreLine(CC.White + "Hit a player 3 times in a row").loreLine(CC.White + "and they wont be able to use").loreLine(CC.White + "pressure plates, buttons and").loreLine(CC.White + "levers for a total of 15 seconds.").displayName(CC.DarkRedB + "Anti Redstone").build());
        inventory.setItem(2, new ItemBuilder(Material.SLIME_BALL).lore(CC.White + "Right click this item to put", "players in 10 block radius", "on global ability cooldown!").displayName(CC.GoldB + "Anti Ability Ball").build());
        inventory.setItem(3, new ItemBuilder(Material.NETHER_STAR).displayName(CC.DarkBlueB + "Anti Trap Star").lore(CC.White + "Teleport you to the player" + CC.White + " " + "that hit you in the last 10" + CC.White + "\nseconds, with a 5 second delay").build());
        inventory.setItem(4, new ItemBuilder(Material.SUGAR).displayName(CC.AquaB + "Cocaine").lore((CC.White + " " + CC.LightPurple.toString() + "|" + "Right click the item to give" + CC.White.toString() + ("yourself speed 4 for 10 seconds") + CC.White.toString() + "and confusion for 5 seconds!")).build());
        //inventory.setItem(5, new ItemBuilder(Material.RAW_FISH).data(Puf));
        player.openInventory(inventory);
    }


    public static void lffGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&7Classes"));

        inventory.setItem(0, new ItemBuilder(Material.DIAMOND_HELMET).displayName(CC.AquaB + "Diamond").loreLine(CC.GrayI + "Click to select " + CC.Aqua + "Diamond Class").build());
        inventory.setItem(1, new ItemBuilder(Material.IRON_HELMET).displayName(CC.AquaB + "Miner").loreLine(CC.GrayI + "Click to select " + CC.Aqua + "Miner Class").build());
        inventory.setItem(2, new ItemBuilder(Material.GOLD_HELMET).displayName(CC.GoldB + "Bard").loreLine(CC.GrayI + "Click to select " + CC.Gold + "Bard Class").build());
        inventory.setItem(3, new ItemBuilder(Material.LEATHER_HELMET).displayName(CC.LightPurpleB + "Archer").loreLine(CC.GrayI + "Click to select " + CC.LightPurple + "Archer Class").build());
        inventory.setItem(4, new ItemBuilder(Material.CHAINMAIL_HELMET).displayName(CC.RedB + "Rouge").loreLine(CC.GrayI + "Click to select " + CC.Red + "Rouge Class").build());
        inventory.setItem(5, new ItemBuilder(Material.BREWING_STAND_ITEM).displayName(CC.YellowB + "Brewer").loreLine(CC.GrayI + "Click to select " + CC.Yellow + "Brewer Class").build());
        inventory.setItem(8, new ItemBuilder(Material.EMERALD_BLOCK).displayName(CC.GreenB + "Confirm Classes").loreLine(CC.GrayI + "Click to confirm your class choices.").build());

        player.openInventory(inventory);

    }

    public static void redeemGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9 * 3, CC.translate("&7Redeem"));

        inventory.setItem(12, new ItemBuilder(Material.SKULL_ITEM).displayName(ChatColor.AQUA + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString() + "SimplyHate").loreLine(CC.White + "Click to support me " + CC.RedB + "\u2764").toSkullBuilder().withOwner(player.getName()).buildSkull());
        inventory.setItem(13, new ItemBuilder(Material.SKULL_ITEM).displayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Pampa").loreLine(CC.White + "Click to support me " + CC.RedB + "\u2764").toSkullBuilder().withOwner("Pampa").buildSkull());
        inventory.setItem(14, new ItemBuilder(Material.SKULL_ITEM).displayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Goos").loreLine(CC.White + "Click to support me " + CC.RedB + "\u2764").toSkullBuilder().withOwner("Goos").buildSkull());

        player.openInventory(inventory);

    }
}
