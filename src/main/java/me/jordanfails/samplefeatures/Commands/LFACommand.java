package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.entity.Player;

public class LFACommand {
    @Command(
            name = "lfa",
            inGameOnly = true,
            usage = "/lfa"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        player.sendMessage(CC.translate("&c&l(!)&c This command is a WIP."));
    }

}
