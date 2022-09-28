package me.jordanfails.basic.Manager;

import com.lunarclient.bukkitapi.LunarClientAPI;
import com.lunarclient.bukkitapi.nethandler.client.LCPacketTitle;
import me.activated.core.api.events.impl.PlayerGrantEvent;
import me.activated.core.api.player.GlobalPlayer;
import me.activated.core.api.player.PlayerData;
import me.activated.core.api.rank.grant.Grant;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.BukkitUtils;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.Config;
import me.jordanfails.basic.Utils.ConfigurationService;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import me.qiooip.lazarus.lunarclient.LunarClientManager;
import me.qiooip.lazarus.staffmode.VanishManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.concurrent.TimeUnit;

public class JoinLeaveManager implements Listener {

    // 20 ticks = 1 second
    /*@EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String rank = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayName();
        RankData rankData = AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId());
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        Grant grant = playerData.getHighestGrant();

        if(Lazarus.getInstance().getLunarClientManager().isOnLunarClient(player.getUniqueId())){
            LunarClientAPI.getInstance().registerPlayer(player);
            player.sendMessage(CC.Green + "You have been auto-logged as a premium user.");
            return;
        }else if(!Lazarus.getInstance().getLunarClientManager().isOnLunarClient(player.getUniqueId())){
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(" ");
            player.sendMessage(CC.AquaB + "LUNAR CLIENT");
            player.sendMessage(CC.translate("&7Hello &b" + player.getName() + "&7, we have noticed that you not using the &7&nofficial"));
            player.sendMessage(CC.translate("&7&nLunar Client&7 to play on Basic. Download and install it"));
            player.sendMessage(CC.translate("&7today, and connect to Basic with Lunar Client from now on to experience"));
            player.sendMessage(" ");
            player.sendMessage(CC.translate("&b&l*&7 Faction Focus on Nametags"));
            player.sendMessage(CC.translate("&b&l*&7 Forced Spawn and Faction Home Waypoints"));
            player.sendMessage(" ");
            player.sendMessage(CC.translate("&b&lREAD MORE: &r&nhttps://lunar.gg/client"));
            player.sendMessage(" ");
        }

        if(!Basic.staff.contains(player.getUniqueId())) {
            Basic.staff.add(player.getUniqueId());
        }

        player.sendMessage(CC.translate("&7&m-----------------------------"));
        player.sendMessage(CC.translate("&rWelcome to the &a&lSampleFeature Network&r!"));
        player.sendMessage(" ");
        player.sendMessage(CC.translate("&a&l*&r Faction Size:&7 www.samplefeatures.org"));
        player.sendMessage(CC.translate("&a&l*&r Map Kit:&7 www.samplefeatures.org"));
        player.sendMessage(CC.translate("&a&l*&r Teamspeak:&7 www.samplefeatures.org"));
        player.sendMessage(CC.translate("&a&l*&r Discord:&7 www.samplefeatures.org"));
        player.sendMessage(CC.translate("&a&l*&r Double Points:&a Enabled"));
        player.sendMessage(CC.translate("&a&l*&r Blocking Up:&a Enabled"));
        player.sendMessage(CC.translate("&7&m-----------------------------"));
        player.sendMessage(" ");
    }
*/

    @EventHandler
    public void onFreeRankJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        String rank = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayName();
        String rankColor = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayColor();
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        Grant grant = playerData.getHighestGrant();
        String expire = grant.getNiceExpire();
        String duration = grant.getNiceDuration();

        if(!ConfigurationService.getFreeRankConfig().contains(player.getUniqueId().toString())){
            player.sendMessage(" ");
            player.sendMessage(CC.translate("&6&lFree Rank"));
            player.sendMessage(CC.translate("&eYou have a free &7&lTop Rank&e waiting for you!"));
            player.sendMessage(CC.translate("&7Type &r/freerank&7 to claim your free Top Rank!"));
            player.sendMessage(" ");
        }else{
            player.sendMessage(" ");
            player.sendMessage(CC.translate("&6&l| Remaining Subscriptions"));
            player.sendMessage(CC.translate("&6&l| &rRenew these subscriptions at &e&nstore.samplefeatures.org&r."));
            player.sendMessage(CC.translate("&7&l• " + rankColor + rank + " &7» &r" + duration));
            player.sendMessage(" ");
        }

    }
    @EventHandler
    public void onRankJoin(PlayerJoinEvent event) throws InterruptedException {
        Player player = event.getPlayer();
        String rank = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayName();
        String rankColor = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayColor();
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        Grant grant = playerData.getHighestGrant();
        String expire = grant.getNiceExpire();
        String duration = grant.getNiceDuration();
        PlayerFaction getFaction = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId());
        LCPacketTitle title = new LCPacketTitle("TITLE", CC.translate("&6&lHCF"), TimeUnit.SECONDS.toMillis(5L), 4L, 10L);
        LCPacketTitle subTitle = new LCPacketTitle("SUBTITLE", CC.translate("&rWelcome Back To HCF"), TimeUnit.SECONDS.toMillis(5L), 4L, 10L);
        if (getFaction == null) {
            player.sendMessage(CC.translate("&7You are not in a faction!"));
        }

        player.sendTitle(CC.translate("&6Get Started"), CC.translate("&rType &6/f create [name]&r to create a faction!"));

        //    override fun sendTitle(player: Player, title: String, fadeIn:Int, stay:Int, fadeOut:Int, withPlaceholders: Boolean) {
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        Lazarus laz = Lazarus.getInstance();
        VanishManager vanishManager = Lazarus.getInstance().getVanishManager();
        LunarClientManager lunarClientManager = Lazarus.getInstance().getLunarClientManager();

        if(player.hasPermission("hcf.staffonline") || player.isOp() && Basic.staff.contains(player.getUniqueId())){
            Basic.staff.remove(player.getUniqueId());
            if(laz.getStaffModeManager().isInStaffMode(player)){
                laz.getStaffModeManager().disable();
            }
            if(vanishManager.isVanished(player)){
                vanishManager.getAllVanished().remove(player.getUniqueId());
            }else{
                return;
            }
        }

        if(lunarClientManager.isOnLunarClient(player)){
            LunarClientAPI.getInstance().unregisterPlayer(player, true);
        }

    }
    public void on(ServerListPingEvent event) {
        event.setMotd(CC.translate("&"));
        event.setMaxPlayers(250);
    }

    }
