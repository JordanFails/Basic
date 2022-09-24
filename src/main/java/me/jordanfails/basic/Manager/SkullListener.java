package me.jordanfails.basic.Manager;

import net.minecraft.util.org.apache.commons.lang3.text.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.SkullType;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SkullListener implements Listener {
    private static final String KILL_BEHEAD_PERMISSION = "kill.behead";

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onPlayerInteract(final PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            final Player player = event.getPlayer();
            final BlockState state = event.getClickedBlock().getState();
            if(state instanceof Skull) {
                final Skull skull = (Skull) state;
                player.sendMessage(ChatColor.YELLOW + "This head belongs to " + ChatColor.WHITE + ((skull.getSkullType() == SkullType.PLAYER && skull.hasOwner()) ? skull.getOwner() : ("a " + WordUtils.capitalizeFully(skull.getSkullType().name()) + " skull")) + ChatColor.YELLOW + '.');
            }
        }
    }
}
