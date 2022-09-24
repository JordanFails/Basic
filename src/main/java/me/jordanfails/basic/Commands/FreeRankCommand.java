package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.activated.core.api.rank.grant.Grant;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Inventories.Inventories;
import me.jordanfails.basic.Utils.BukkitReflection;
import me.jordanfails.basic.Utils.BukkitUtils;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.ConfigurationService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FreeRankCommand {
    @Command(
            name = "freerank",
            inGameOnly = true
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        if(!ConfigurationService.getFreeRankConfig().contains(player.getUniqueId().toString())) {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "setrank " + player.getName() + "toprank 7d global FreeRank");
            player.sendMessage(" ");
            player.sendMessage(CC.translate("&eYou have claimed your free &c&k;;&4TopRank&c&k;;&e Rank!"));
            player.sendMessage(CC.translate("&eThank you for supporting &6Sample Frank&c " + "\u2764"));
            player.sendMessage(" ");
            ConfigurationService.getFreeRankConfig().set(player.getUniqueId().toString(), true);
            return;
        }else if(ConfigurationService.getFreeRankConfig().contains(player.getUniqueId().toString())){
            player.sendMessage(CC.translate("&eYou have already claimed your free rank."));
            return;
        }
    }
}
