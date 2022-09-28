package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import me.activated.core.plugin.AquaCore;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Utils.BukkitReflection;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.entity.Player;

public class PingCommand {
    @Command(name = "ping")
    public void execute(Player player){
        player.sendMessage(CC.Yellow + "Your Ping: " + colorPing(BukkitReflection.getPing(player)));
    }

    public void execute(Player player, Player target) {
        if (target == null) {
            player.sendMessage(CC.Red + "A player with that name could not be found.");
        } else {
            player.sendMessage(AquaCoreAPI.INSTANCE.getPlayerNameColor(target.getUniqueId()) + CC.Yellow + "'s Ping: " +
                    colorPing(BukkitReflection.getPing(target)));
        }
    }

    private String colorPing(int ping) {
        if (ping <= 40) {
            return CC.Green + ping;
        } else if (ping <= 70) {
            return CC.Yellow + ping;
        } else if (ping <= 100) {
            return CC.Gold + ping;
        } else {
            return CC.Red + ping;
        }
    }

}
