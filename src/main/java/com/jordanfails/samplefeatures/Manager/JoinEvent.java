package com.jordanfails.samplefeatures.Manager;

import com.jordanfails.samplefeatures.Utils.Utils;
import com.lunarclient.bukkitapi.LunarClientAPI;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.event.PlayerLeaveFactionEvent;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginEnableEvent;

import java.util.Set;

public class JoinEvent implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(LunarClientAPI.getInstance().isRunningLunarClient(player)){
            LunarClientAPI.getInstance().registerPlayer(player);
        }else{
            player.sendMessage(Utils.chat("&b&l(!)&r You have not been verified using &b&nLunar Client!"));
            player.sendMessage(Utils.chat("&rUsing &b&nLunar Client&r can boost your overall experience bringing"));
            player.sendMessage(Utils.chat("&rWaypoints, F focus, and &b&nmany&r more!"));
        }
    }

    @EventHandler
    public void onOwnerJoin(PlayerLeaveFactionEvent event, PlayerFaction playerFaction){

    }
}
