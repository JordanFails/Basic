package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.entity.Player;

public class VoteCommand {
    @Command(
            name = "vote",
            inGameOnly = true
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        player.sendMessage(CC.translate("&6&lVOTING"));
        player.sendMessage(CC.translate("&rVote daily for the network to receive various prizes."));
        player.sendMessage(" ");
        player.sendMessage(CC.translate("&6&lREWARDS"));
        player.sendMessage(CC.translate("&rVoting can get you the following:"));
        player.sendMessage(CC.translate("&6&l|&r You will always get &6&l3x Keys&r."));
        player.sendMessage(CC.translate(" "));
        player.sendMessage(CC.translate("&6&lLINKS"));
        player.sendMessage(CC.translate("&6&l|&r Link #1"));
        player.sendMessage(CC.translate("&6&l|&r Link #2"));
        player.sendMessage(CC.translate("&6&l|&r Link #3"));

    }
}
