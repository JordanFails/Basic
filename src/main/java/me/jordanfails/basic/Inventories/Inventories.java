package me.jordanfails.basic.Inventories;

import me.activated.core.api.rank.RankData;
import me.activated.core.plugin.AquaCore;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.ItemBuilder;
import lombok.Getter;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

@Getter
public class Inventories {
    private static final Basic plugin = Basic.get();

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
        Inventory inventory = Bukkit.getServer().createInventory(null, 54, CC.translate("&cPunish faction " + playerFaction.getName()));

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
        inventory.setItem(2, new ItemBuilder(Material.SLIME_BALL).lore(CC.White + "Right click this item to put", "&rplayers in 10 block radius", "&ron global ability cooldown!").displayName(CC.GoldB + "Anti Ability Ball").build());
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

        inventory.setItem(12, new ItemBuilder(Material.SKULL_ITEM).displayName(ChatColor.AQUA + ChatColor.BOLD.toString() + ChatColor.ITALIC.toString() + "SimplyHate").loreLine(CC.White + "Click to support me " + CC.RedB + "\u2764").toSkullBuilder().withOwner("SimplyHate").buildSkull());
        inventory.setItem(13, new ItemBuilder(Material.SKULL_ITEM).displayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Pampa").loreLine(CC.White + "Click to support me " + CC.RedB + "\u2764").toSkullBuilder().withOwner("Pampa").buildSkull());
        inventory.setItem(14, new ItemBuilder(Material.SKULL_ITEM).displayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Goos").loreLine(CC.White + "Click to support me " + CC.RedB + "\u2764").toSkullBuilder().withOwner("Goos").buildSkull());

        player.openInventory(inventory);

    }

    public static void chatColorGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&7ChatColor"));

        inventory.setItem(0, new ItemBuilder(Material.INK_SACK).data(DyeColor.ORANGE.getData()).displayName(CC.Red + CC.Bold + "Red").enchant(Enchantment.DURABILITY, 10, true).build());

        player.openInventory(inventory);
    }

    //UNCLAIMED GUI FOR /FREERANK
    public static void freeRankGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 27, CC.translate("&7Free Rank"));


        inventory.setItem(12, new ItemBuilder(Material.BOOK, 1).displayName(CC.translate("&a&lStore Information&7&o (Click)")).lore(CC.translate("&7We currently have a &6&l50% Flash Sale!"), CC.translate("&7Be sure to take advamtage before it end!"), " ", CC.translate("&7Visit our store today using &astore.samplefeatures.org"), CC.translate("&7or click the book to open the store menu!")).build());
        inventory.setItem(14, new ItemBuilder(Material.NETHER_STAR, 1).displayName(CC.translate("&a&l[LIMITED TIME] &r&lF&6&lR&r&lE&6&lE &r&lR&6&lA&r&lN&6&lK")).lore(CC.translate("&7&oBy clicking this beacon and gaining TOP rank, you unlock"), CC.translate("&7a vareity of commands including the ones"), CC.translate("&7that are listed below:"), CC.translate(" "), CC.translate("&6&lCommand"), CC.translate("&6&l|&7 Access to /condense - Condense your materials")).build());

        player.openInventory(inventory);

    }


    //CLAIMED GUI FOR /FREERANK
    public static void claimedRankGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 27, CC.translate("&7Free Rank"));


        inventory.setItem(12, new ItemBuilder(Material.BOOK, 1).displayName(CC.translate("&a&lStore Information&7&o (Click)")).lore(CC.translate("&7We currently have a &6&l50% Flash Sale!"), CC.translate("&7Be sure to take advamtage before it end!"), " ", CC.translate("&7Visit our store today using &astore.samplefeatures.org"), CC.translate("&7or click the book to open the store menu!")).build());
        inventory.setItem(14, new ItemBuilder(Material.NETHER_STAR, 1).displayName(CC.translate("&c&l[CLAIMED] &r&lF&6&lR&r&lE&6&lE &r&lR&6&lA&r&lN&6&lK")).lore(CC.translate("&7&oBy clicking this beacon and gaining TOP rank, you unlock"), CC.translate("&7a vareity of commands including the ones"), CC.translate("&7that are listed below:"), CC.translate(" "), CC.translate("&6&lCommand"), CC.translate("&6&l|&7 Access to /condense - Condense your materials")).build());

        player.openInventory(inventory);

    }

    //DEFAULT /PROFILE
    public static void profileGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&8Your Profile"));
        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        RankData rank = api.getPlayerData(player.getUniqueId()).getHighestRank(true);
        FactionsManager factionsManager = FactionsManager.getInstance();
        String factionName = factionsManager.getPlayerFaction(player.getUniqueId()).getName();
        String factionOutput = factionName.substring(0, 1).toUpperCase() + factionName.substring(1);


        inventory.setItem(0, new ItemBuilder(Material.PAPER, 1).displayName(CC.translate("&6&lStatistics")).lore(CC.translate("&7View your statistics across all servers."), " ", CC.translate("&6&l»&r Global Kills: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getKills()), CC.translate("&6&l»&r Global Deaths: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getDeaths()), CC.translate(" "), CC.translate("&aClick to view all your statistics")).build());
        inventory.setItem(2, new ItemBuilder(Material.PAINTING, 1).displayName(CC.translate("&6&lSocial Media")).lore(CC.translate("&7Release your social media to the public."), " ", CC.translate("&6&l»&r Social Media Connected: &60/1"), " ", CC.translate("&aClick to view all your social media")).build());
        inventory.setItem(4, new ItemBuilder(Material.SKULL_ITEM, 1).displayName(CC.translate("&6&lYour Profile")).lore(CC.translate("&7Manage your profile in a simple system."), " ", CC.translate("&6&l»&r Rank: " + rank ), CC.translate("&6&l»&r VIP Status:&6 N/A"), " ", CC.translate("&aClick to view all your statistics")).toSkullBuilder().withOwner(player.getName()).buildSkull());
        inventory.setItem(6, new ItemBuilder(Material.EYE_OF_ENDER, 1).displayName(CC.translate("&6&lFaction")).lore(CC.translate("&7Manage your factions."), " ", CC.translate("&6&l»&r Faction Name: &6" + factionOutput ), CC.translate("&6&l»&r Faction Size: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getOnlineMemberCount() + " &7(" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getMembers().size() + "&7)"), " ", CC.translate("&aClick to view all your faction stats")).build());        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications."), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());          //Online (FactionSize)

        player.openInventory(inventory);
    }

    //STATS GUI
    public static void statsGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9 * 6, CC.translate("&8Statistics"));

        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        RankData rank = api.getPlayerData(player.getUniqueId()).getHighestRank(true);
        FactionsManager factionsManager = FactionsManager.getInstance();
        String factionName = factionsManager.getPlayerFaction(player.getUniqueId()).getName();
        String factionOutput = factionName.substring(0, 1).toUpperCase() + factionName.substring(1);

        inventory.setItem(0, new ItemBuilder(Material.PAPER, 1).displayName(CC.translate("&6&lStatistics")).lore(CC.translate("&7View your statistics across all servers."), " ", CC.translate("&6&l»&r Global Kills: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getKills()), CC.translate("&6&l»&r Global Deaths: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getDeaths()), CC.translate(" "), CC.translate("&aClick to view all your statistics")).build());
        inventory.setItem(2, new ItemBuilder(Material.PAINTING, 1).displayName(CC.translate("&6&lSocial Media")).lore(CC.translate("&7Release your social media to the public."), " ", CC.translate("&6&l»&r Social Media Connected: &60/1"), " ", CC.translate("&aClick to view all your social media")).build());
        inventory.setItem(4, new ItemBuilder(Material.SKULL_ITEM, 1).displayName(CC.translate("&6&lYour Profile")).lore(CC.translate("&7Manage your profile in a simple system."), " ", CC.translate("&6&l»&r Rank: " + rank ), CC.translate("&6&l»&r VIP Status:&6 N/A"), " ", CC.translate("&aClick to view all your statistics")).toSkullBuilder().withOwner(player.getName()).buildSkull());
        inventory.setItem(6, new ItemBuilder(Material.EYE_OF_ENDER, 1).displayName(CC.translate("&6&lFaction")).lore(CC.translate("&7Manage your factions."), " ", CC.translate("&6&l»&r Faction Name: &6" + factionOutput ), CC.translate("&6&l»&r Faction Size: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getOnlineMemberCount() + " &7(" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getMembers().size() + "&7)"), " ", CC.translate("&aClick to view all your faction stats")).build());        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications."), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());          //Online (FactionSize)
        inventory.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(10, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(31, new ItemBuilder(Material.NETHER_STAR, 1).displayName(CC.translate("&6&lHCF Statistics")).lore(CC.translate("&7All your HCF stats are shown below"), " ", CC.translate("&6&l»&r Kills: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getKills()), CC.translate("&6&l»&r Deaths: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getDeaths()), " ", CC.translate("&6&l»&r Maps Played: &61"), CC.translate("&6&l»&r KOTH Captured: &6") + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getKothsCapped(), " ", CC.translate("&aClick to view more statistics.")).build());
        inventory.setItem(45, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(46, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(47, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(48, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(49, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(50, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(52, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(53, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        player.openInventory(inventory);
    }

    //SOCIAL MEDIA GUI
    public static void socialMedia(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9 * 6, CC.translate("&8Social Media"));

        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        RankData rank = api.getPlayerData(player.getUniqueId()).getHighestRank(true);

        inventory.setItem(0, new ItemBuilder(Material.PAPER, 1).displayName(CC.translate("&6&lStatistics")).lore(CC.translate("&7View your statistics across all servers."), " ", CC.translate("&6&l»&r Global Kills: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getKills()), CC.translate("&6&l»&r Global Deaths: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getDeaths()), CC.translate(" "), CC.translate("&aClick to view all your statistics")).build());
        inventory.setItem(2, new ItemBuilder(Material.PAINTING, 1).displayName(CC.translate("&6&lSocial Media")).lore(CC.translate("&7Release your social media to the public."), " ", CC.translate("&6&l»&r Social Media Connected: &60/1"), " ", CC.translate("&aClick to view all your social media")).build());
        inventory.setItem(4, new ItemBuilder(Material.SKULL_ITEM, 1).displayName(CC.translate("&6&lYour Profile")).lore(CC.translate("&7Manage your profile in a simple system."), " ", CC.translate("&6&l»&r Rank: " + rank ), CC.translate("&6&l»&r VIP Status:&6 N/A"), " ", CC.translate("&aClick to view all your statistics")).toSkullBuilder().withOwner(player.getName()).buildSkull());
        inventory.setItem(6, new ItemBuilder(Material.EYE_OF_ENDER, 1).displayName(CC.translate("&6&lFaction")).lore(CC.translate("&7Manage your faction."), " ", CC.translate("&6&l»&r Faction Name: &6" +FactionsManager.getInstance().getPlayerFaction(player).getName() ), CC.translate("&6&l»&r Faction Size: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getOnlineMemberCount() + " &7(" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getMembers().size() + "&7)"), " ", CC.translate("&aClick to view all your faction stats")).build());        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(10, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(31, new ItemBuilder(Material.NAME_TAG, 1).displayName(CC.translate("&6&lDiscord")).lore( " ", CC.translate("&6&l»&r Discord Tag: &6N/A "), " ", CC.translate("&aLeft click to change this link"), CC.translate("&aRight click to remove link")).build());
        inventory.setItem(45, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(46, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(47, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(48, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(49, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(50, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(52, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(53, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        player.openInventory(inventory);
    }

    public static void factionGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9 * 6, CC.translate("&8Your friends - 1/1"));
        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        RankData rank = api.getPlayerData(player.getUniqueId()).getHighestRank(true);

        inventory.setItem(0, new ItemBuilder(Material.PAPER, 1).displayName(CC.translate("&6&lStatistics")).lore(CC.translate("&7View your statistics across all servers."), " ", CC.translate("&6&l»&r Global Kills: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getKills()), CC.translate("&6&l»&r Global Deaths: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getDeaths()), CC.translate(" "), CC.translate("&aClick to view all your statistics")).build());
        inventory.setItem(2, new ItemBuilder(Material.PAINTING, 1).displayName(CC.translate("&6&lSocial Media")).lore(CC.translate("&7Release your social media to the public."), " ", CC.translate("&6&l»&r Social Media Connected: &60/1"), " ", CC.translate("&aClick to view all your social media")).build());
        inventory.setItem(4, new ItemBuilder(Material.SKULL_ITEM, 1).displayName(CC.translate("&6&lYour Profile")).lore(CC.translate("&7Manage your profile in a simple system."), " ", CC.translate("&6&l»&r Rank: " + rank ), CC.translate("&6&l»&r VIP Status:&6 N/A"), " ", CC.translate("&aClick to view all your statistics")).toSkullBuilder().withOwner(player.getName()).buildSkull());        inventory.setItem(6, new ItemBuilder(Material.EYE_OF_ENDER, 1).displayName(CC.translate("&6&lFaction")).lore(CC.translate("&7Manage your faction."), " ", CC.translate("&6&l»&r Faction Name: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getName()), CC.translate("&6&l»&r Faction Size: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getOnlineMemberCount() + " &7(" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getMembers().size() + "&7)"), " ", CC.translate("&aClick to view all your faction stats")).build());        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(10, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(19, new ItemBuilder(Material.NAME_TAG, 1).displayName(CC.translate("&6&lRename Faction")).lore(" ", CC.translate("&aClick to rename to your faction.")).build());
        inventory.setItem(21, new ItemBuilder(Material.BONE, 1).displayName(CC.translate("&6&lDTR")).lore(" ").build());
        inventory.setItem(45, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(46, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(47, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(48, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(49, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(50, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(52, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(53, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());

        player.openInventory(inventory);
    }

    public static void publicProfile(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9 * 6, CC.translate("&8Your Public Profile"));

        UUID uuid = player.getUniqueId();
        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        RankData rank = api.getPlayerData(uuid).getHighestRank(true);
        String factionName = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getName();
        String factionNameOutput = factionName.substring(0, 1).toUpperCase() + factionName.substring(1);
        boolean isOnLunar = Lazarus.getInstance().getLunarClientManager().isOnLunarClient(player.getUniqueId());
        String input = String.valueOf(isOnLunar).toString();
        String lunarOutput = input.substring(0, 1).toUpperCase() + input.substring(1);

        inventory.setItem(0, new ItemBuilder(Material.PAPER, 1).displayName(CC.translate("&6&lStatistics")).lore(CC.translate("&7View your statistics across all servers."), " ", CC.translate("&6&l»&r Global Kills: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getKills()), CC.translate("&6&l»&r Global Deaths: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getDeaths()), CC.translate(" "), CC.translate("&aClick to view all your statistics")).build());
        inventory.setItem(2, new ItemBuilder(Material.PAINTING, 1).displayName(CC.translate("&6&lSocial Media")).lore(CC.translate("&7Release your social media to the public."), " ", CC.translate("&6&l»&r Social Media Connected: &60/1"), " ", CC.translate("&aClick to view all your social media")).build());
        inventory.setItem(4, new ItemBuilder(Material.SKULL_ITEM, 1).displayName(CC.translate("&6&lYour Profile")).lore(CC.translate("&7Manage your profile in a simple system."), " ", CC.translate("&6&l»&r Rank: " + rank ), CC.translate("&6&l»&r VIP Status:&6 N/A"), " ", CC.translate("&aClick to view all your statistics")).toSkullBuilder().withOwner(player.getName()).buildSkull());        inventory.setItem(6, new ItemBuilder(Material.EYE_OF_ENDER, 1).displayName(CC.translate("&6&lFaction")).lore(CC.translate("&7Manage your faction."), " ", CC.translate("&6&l»&r Faction Name: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getName()), CC.translate("&6&l»&r Faction Size: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getOnlineMemberCount() + " &7(" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getMembers().size() + "&7)"), " ", CC.translate("&aClick to view all your faction stats")).build());        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(10, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(29, new ItemBuilder(Material.SLIME_BALL, 1).displayName(CC.translate("&6&lBalance")).lore(" ", CC.translate("&6&l»&r Current Balance: &6$" + Lazarus.getInstance().getEconomyManager().getBalance(player)), " ").build());
        inventory.setItem(31, new ItemBuilder(Material.SKULL_ITEM, 1).displayName(CC.translate("&6&lPlayer Information")).lore(" ", CC.translate("&6&l»&r Name: &6" + player.getDisplayName()), CC.translate("&6&l»&r Rank: &6" + rank ), CC.translate("&6&l»&r Lunar Client: &6" + lunarOutput), " ").toSkullBuilder().withOwner(player.getName()).buildSkull());
        inventory.setItem(33, new ItemBuilder(Material.NAME_TAG, 1).displayName(CC.translate("&6&lFaction Information")).lore(" ", CC.translate("&6&l»&r Faction Name: &6" + factionNameOutput), CC.translate("&6&l»&r Points:&6 " + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getPoints()), CC.translate("&6&l»&r DTR:&6 " + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getDtr() + "/" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getMaxDtr()), " ", CC.translate("&aClick to view more about your faction!")).build());
        inventory.setItem(45, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(46, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(47, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(48, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(49, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(50, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(52, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(53, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        player.openInventory(inventory);
    }

    public static void notifyGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9 * 6, CC.translate("&8Notifications"));
        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        RankData rank = api.getPlayerData(player.getUniqueId()).getHighestRank(true);

        inventory.setItem(0, new ItemBuilder(Material.PAPER, 1).displayName(CC.translate("&6&lStatistics")).lore(CC.translate("&7View your statistics across all servers."), " ", CC.translate("&6&l»&r Global Kills: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getKills()), CC.translate("&6&l»&r Global Deaths: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getDeaths()), CC.translate(" "), CC.translate("&aClick to view all your statistics")).build());
        inventory.setItem(2, new ItemBuilder(Material.PAINTING, 1).displayName(CC.translate("&6&lSocial Media")).lore(CC.translate("&7Release your social media to the public."), " ", CC.translate("&6&l»&r Social Media Connected: &60/1"), " ", CC.translate("&aClick to view all your social media")).build());
        inventory.setItem(4, new ItemBuilder(Material.SKULL_ITEM, 1).displayName(CC.translate("&6&lYour Profile")).lore(CC.translate("&7Manage your profile in a simple system."), " ", CC.translate("&6&l»&r Rank: " + rank ), CC.translate("&6&l»&r VIP Status:&6 N/A"), " ", CC.translate("&aClick to view all your statistics")).toSkullBuilder().withOwner(player.getName()).buildSkull());        inventory.setItem(6, new ItemBuilder(Material.EYE_OF_ENDER, 1).displayName(CC.translate("&6&lFaction")).lore(CC.translate("&7Manage your faction."), " ", CC.translate("&6&l»&r Faction Name: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getName()), CC.translate("&6&l»&r Faction Size: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getOnlineMemberCount() + " &7(" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getMembers().size() + "&7)"), " ", CC.translate("&aClick to view all your faction stats")).build());        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(10, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(29+1, new ItemBuilder(Material.REDSTONE, 1).displayName(CC.translate("&6&lRead All")).lore(" ", CC.translate("&aClick to mark all your notifications read")).build());
        inventory.setItem(33-1, new ItemBuilder(Material.GLOWSTONE_DUST, 1).displayName(CC.translate("&6&lNotification Settings")).lore(" ", CC.translate("&aClick to view all your notification settings")).build());
        inventory.setItem(45, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(46, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(47, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(48, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(49, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(50, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(52, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(53, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        player.openInventory(inventory);
    }

    public static void notificationsGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9 * 6, CC.translate("&8Notifications"));
        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        RankData rank = api.getPlayerData(player.getUniqueId()).getHighestRank(true);

        inventory.setItem(0, new ItemBuilder(Material.PAPER, 1).displayName(CC.translate("&6&lStatistics")).lore(CC.translate("&7View your statistics across all servers."), " ", CC.translate("&6&l»&r Global Kills: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getKills()), CC.translate("&6&l»&r Global Deaths: &6" + Lazarus.getInstance().getUserdataManager().getUserdata(player.getUniqueId()).getDeaths()), CC.translate(" "), CC.translate("&aClick to view all your statistics")).build());
        inventory.setItem(2, new ItemBuilder(Material.PAINTING, 1).displayName(CC.translate("&6&lSocial Media")).lore(CC.translate("&7Release your social media to the public."), " ", CC.translate("&6&l»&r Social Media Connected: &60/1"), " ", CC.translate("&aClick to view all your social media")).build());
        inventory.setItem(4, new ItemBuilder(Material.SKULL_ITEM, 1).displayName(CC.translate("&6&lYour Profile")).lore(CC.translate("&7Manage your profile in a simple system."), " ", CC.translate("&6&l»&r Rank: " + rank ), CC.translate("&6&l»&r VIP Status:&6 N/A"), " ", CC.translate("&aClick to view all your statistics")).toSkullBuilder().withOwner(player.getName()).buildSkull());        inventory.setItem(6, new ItemBuilder(Material.EYE_OF_ENDER, 1).displayName(CC.translate("&6&lFaction")).lore(CC.translate("&7Manage your faction."), " ", CC.translate("&6&l»&r Faction Name: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getName()), CC.translate("&6&l»&r Faction Size: &6" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getOnlineMemberCount() + " &7(" + FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getMembers().size() + "&7)"), " ", CC.translate("&aClick to view all your faction stats")).build());        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(8, new ItemBuilder(Material.WATCH).displayName(CC.translate("&6&lNotifications")).lore(CC.translate("&7View all of your pending notifications"), " ", CC.translate("&6&l»&r Unread Notifications: &60"), " ", CC.translate("&aClick to view all your notifications")).build());
        inventory.setItem(9, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(10, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(11, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(12, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(13, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(14, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(15, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(16, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(17, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(30, new ItemBuilder(Material.TNT, 1).displayName(CC.translate("&6&lPunishments")).lore(CC.translate("&7Get notified when you get punished"), " ", CC.translate("&6&lNotified Actions"), CC.translate("&6&l»&r All Punishments"), CC.translate("&6&l»&r Punishment Reasons"), CC.translate("&6&l»&r Punishment Durations"), " ", CC.translate("&6&l»&r Status:&e Unknown"), "").build());
        inventory.setItem(32, new ItemBuilder(Material.GLOWSTONE_DUST, 1).displayName(CC.translate("&6&lNotification Settings")).lore(" ", CC.translate("&aClick to view all your notification settings")).build());
        inventory.setItem(45, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(46, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(47, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(48, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(49, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(50, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(51, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(52, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        inventory.setItem(53, new ItemBuilder(Material.STAINED_GLASS_PANE, 1).data(DyeColor.WHITE.getData()).displayName(" ").build());
        player.openInventory(inventory);
    }

    public static void lfaGUI(Player player, PlayerFaction playerFaction){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&8Looking For Allies"));

        inventory.setItem(3, new ItemBuilder(Material.EMERALD_BLOCK, 1).displayName(CC.translate("&a&lLook For Ally")).enchant(Enchantment.DURABILITY, 10, true).build());
        inventory.setItem(5, new ItemBuilder(Material.REDSTONE_BLOCK, 1).displayName(CC.translate("&c&lCancel")).enchant(Enchantment.DURABILITY, 10, true).build());


        player.openInventory(inventory);
    }

    public static void youtubeGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&8YouTube Requirements"));

        inventory.setItem(4, new ItemBuilder(Material.INK_SACK).data(DyeColor.ORANGE.getData()).displayName(CC.translate("&c&lYouTube Requirements")).lore(CC.translate("&c&l»&r Sub Requirements:&r 200"), CC.translate("&c&l»&r View Requirements:&r 100"), " ", CC.translate("&aMessage a staff member to apply.")).enchant(Enchantment.SILK_TOUCH, 10, true).build());

        player.openInventory(inventory);
    }
    public static void partnerGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&8Partner Requirements"));

        inventory.setItem(4, new ItemBuilder(Material.INK_SACK).data(DyeColor.BROWN.getData()).displayName(CC.translate("&b&lPartner Requirements")).lore(CC.translate("&b&l»&r Sub Requirements:&r 500"), CC.translate("&b&l»&r View Requirements:&r 250"), " ", CC.translate("&aMessage a staff member to apply.")).enchant(Enchantment.SILK_TOUCH, 10, true).build());

        player.openInventory(inventory);
    }
    public static void streamerGUI(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&8Streamer Requirements"));

        inventory.setItem(4, new ItemBuilder(Material.INK_SACK).data(DyeColor.LIME.getData()).displayName(CC.translate("&5&lTwitch Requirements")).lore(CC.translate("&5&l»&r Sub Requirements:&r 1000"), CC.translate("&5&l»&r View Requirements:&r 500"), " ", CC.translate("&aMessage a staff member to apply.")).enchant(Enchantment.SILK_TOUCH, 10, true).build());

        player.openInventory(inventory);
    }


    public static void pronouns(Player player){
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&8Select a Pronoun"));

        inventory.setItem(3, new ItemBuilder(Material.NETHER_STAR, 1).displayName(CC.translate("&b&lHe/Him/His")).enchant(Enchantment.DURABILITY, 10, true).build());
        inventory.setItem(4, new ItemBuilder(Material.NETHER_STAR, 1).displayName(CC.translate("&d&lShe/Her/Hers")).enchant(Enchantment.DURABILITY, 10, true).build());
        inventory.setItem(5, new ItemBuilder(Material.NETHER_STAR, 1).displayName(CC.translate("&e&lThey/Them/Theirs")).enchant(Enchantment.DURABILITY, 10, true).build());

        player.openInventory(inventory);

    }

    public static void playerStatsGUI(Player player, Player target){
        String name = player.getName();
        Inventory inventory = Bukkit.getServer().createInventory(null, 9, CC.translate("&7" + target.getName() + "'s stats"));
        inventory.setItem(4, new ItemBuilder(Material.WATCH, 1).displayName(CC.translate("&6&l" + name + "'s Stats")).lore(CC.translate("&7Player stats for the current map of HCF"),
                " ",
                CC.translate("&6Balance" ),
                CC.translate("&2$&a" + Lazarus.getInstance().getUserdataManager().getUserdata(target.getUniqueId()).getBalance()),
                " ",
                CC.translate("&6&lKills"),
                CC.translate("&f" + Lazarus.getInstance().getUserdataManager().getUserdata(target).getKills()),
                " ",
                CC.translate("&6&lDeaths"),
                CC.translate("&f" + Lazarus.getInstance().getUserdataManager().getUserdata(target).getDeaths())).enchant(Enchantment.DURABILITY, 10, true).build());

        player.openInventory(inventory);
    }



}
