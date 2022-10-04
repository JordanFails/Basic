package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.activated.core.api.rank.RankData;
import me.activated.core.plugin.AquaCoreAPI;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

import static me.jordanfails.basic.Basic.RANKPREFIX;

public class CurrentRankCommand implements CommandExecutor {
    /**
     * Executes the given command, returning its success
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            UUID uuid = player.getUniqueId();
            RankData rankData = AquaCoreAPI.INSTANCE.getPlayerRank(uuid);

            if (args.length == 0) {
                player.sendMessage(RANKPREFIX + "Current Rank: " + rankData.getDisplayColor() + rankData.getName());
            }
        }
        return false;
    }
}
