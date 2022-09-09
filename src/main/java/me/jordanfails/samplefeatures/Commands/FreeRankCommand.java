package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import me.jordanfails.samplefeatures.Utils.Config;
import me.jordanfails.samplefeatures.Utils.ConfigurationService;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FreeRankCommand {
    @Command(
            name = "freerank"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        if(!ConfigurationService.getFreeRankConfig().contains(player.getUniqueId().toString())) {
            Inventories.freeRankGUI(player);
            return;
        }else if(ConfigurationService.getFreeRankConfig().contains(player.getUniqueId().toString())){
            Inventories.claimedRankGUI(player);
            return;
        }
    }
}
