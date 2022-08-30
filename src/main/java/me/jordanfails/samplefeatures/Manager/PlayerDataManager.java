package me.jordanfails.samplefeatures.Manager;

import me.jordanfails.samplefeatures.SampleFeatures;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PlayerDataManager implements Listener {
    private HashMap<UUID, PlayerData> playerDataHashMap = new HashMap();
    private ArrayList<UUID> haltUUID = new ArrayList();

    public PlayerDataManager(SampleFeatures sampleFeatures) {
        Bukkit.getOnlinePlayers().stream().forEach((player) -> {
            this.playerDataHashMap.put(player.getUniqueId(), new PlayerData(player.getUniqueId()));
        });
        (new BukkitRunnable() {
            public void run() {
                Bukkit.getOnlinePlayers().stream().forEach((player) -> {
                    if (PlayerDataManager.this.haltUUID.contains(player.getUniqueId())) {
                        PlayerDataManager.this.sendHaltAlert(player);
                    }

                });
            }
        }).runTaskTimer(sampleFeatures, 20L, 20L);
        sampleFeatures.getServer().getPluginManager().registerEvents(this, sampleFeatures);
    }

    public void onDisable() {
    }

    public PlayerData getPlayerData(Player player) {
        return this.getPlayerData(player.getUniqueId());
    }

    public PlayerData getPlayerData(UUID uuid) {
        return (PlayerData)this.playerDataHashMap.getOrDefault(uuid, new PlayerData(uuid));
    }

    @EventHandler
    public void onPlayerDataAdd(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        this.playerDataHashMap.put(player.getUniqueId(), new PlayerData(player.getUniqueId()));
    }

    @EventHandler
    public void onPlayerDataRemove(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        this.playerDataHashMap.remove(player.getUniqueId());
    }

    public boolean haltPlayer(Player player) {
        return !this.isPlayerHalted(player.getUniqueId()) ? this.haltUUID.add(player.getUniqueId()) : false;
    }

    public boolean isPlayerHalted(UUID uuid) {
        return this.haltUUID.contains(uuid);
    }

    public boolean unhaltPlayer(Player player) {
        return this.isPlayerHalted(player.getUniqueId()) ? this.haltUUID.remove(player.getUniqueId()) : false;
    }

    public void sendHaltAlert(Player player) {
        player.sendMessage("");
        player.sendMessage(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Halted!");
        player.sendMessage(ChatColor.RED + "You have been halted by a staff member.");
        player.sendMessage("");
    }
}
