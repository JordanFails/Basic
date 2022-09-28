package me.jordanfails.basic.Manager;


import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.UUID;

public class PlayerData implements Listener {
    private UUID uniqueID;

    public PlayerData(UUID uuid) {
        this.uniqueID = uuid;
    }

    public UUID getUniqueID() {
        return this.uniqueID;
    }
}
