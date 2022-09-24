package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import static me.jordanfails.basic.Basic.NOPERMS;

public class PunishCommand {
    @Command(
            name = "punish",
            description = "Open a GUI to punish speific people.",
            usage = "Usage: /punish <player>",
            permission = "hcf.command.punish"
    )
    public void execute(CommandArgs args) {
        Player player = args.getPlayer();

        if(!player.hasPermission(args.getCommand().getPermission())){
            player.sendMessage(CC.translate(NOPERMS));
        }
    }
}
