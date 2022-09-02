package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.entity.Player;

public class NitroCommand {
    @Command(
            name = "nitro",
            inGameOnly = false,
            permission = "hcf.command.nitro",
            noPerm = "You lack the permissions to execute this command"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        player.sendMessage(CC.translate(""));
    }
}
