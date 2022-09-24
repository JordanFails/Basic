package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.activated.core.api.rank.RankData;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.entity.Player;

import static me.jordanfails.basic.Basic.RANKPREFIX;

public class CurrentRankCommand {
    @Command(
            name = "crank"
    )

    public void execute(CommandArgs args){
        Player player  = args.getPlayer();
        if(args.length() == 0){
            RankData rankData = AquaCoreAPI.INSTANCE.getPlayerRank(args.getPlayer().getUniqueId());

            player.sendMessage(RANKPREFIX + "Current Rank: " + rankData.getDisplayColor() + rankData.getName());
        }else{
            return;
        }
    }
}
