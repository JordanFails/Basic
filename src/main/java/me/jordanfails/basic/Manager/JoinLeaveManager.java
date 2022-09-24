package me.jordanfails.basic.Manager;

import com.lunarclient.bukkitapi.LunarClientAPI;
import me.activated.core.api.player.GlobalPlayer;
import me.activated.core.api.player.PlayerData;
import me.activated.core.api.rank.RankData;
import me.activated.core.api.rank.grant.Grant;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import me.qiooip.lazarus.lunarclient.LunarClientManager;
import me.qiooip.lazarus.staffmode.VanishManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import static me.jordanfails.basic.Basic.PREFIX;

public class JoinLeaveManager implements Listener {

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
    public void onRankJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        GlobalPlayer globalPlayer = AquaCoreAPI.INSTANCE.getGlobalPlayer(player.getUniqueId());
        String rank = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayName();
        String rankColor = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayColor();
        RankData rankData = AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId());
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        Grant grant = playerData.getHighestGrant();
        PlayerFaction getFaction = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId());

        if (getFaction == null) {
            player.sendMessage(CC.translate("&7You are not in a faction!"));
        }

        player.sendTitle(CC.translate("&6&lHCF"),CC.translate("&rWelcome Back To HCF!"));
        player.sendMessage(CC.translate(PREFIX + "&rYour currently rank is " + rankColor + rank + "&r."));
        player.sendMessage(CC.translate(PREFIX + "&rThis rank expires in: " + rankColor + grant.getNiceExpire() + "&r."));
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
}
