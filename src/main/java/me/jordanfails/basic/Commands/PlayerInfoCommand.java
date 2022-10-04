package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Inventories.Inventories;
import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerInfoCommand {

    @Command(
            name = "playerinfo",
            inGameOnly = true,
            usage = "Usage: /playerinfo <otherPlayers>"

    )

    public void execute(CommandArgs args) {
        Player player = args.getPlayer();
        Player target = Bukkit.getPlayer(args.getArgs(0));

        if(args.length() == 1){
            Inventories.playerStatsGUI(player, target);
        }
    }
}
// > more than
// < less than