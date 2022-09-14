package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.entity.Player;

public class NitroCommand {
    @Command(
            name = "nitro",
            permission = "hcf.command.nitro",
            noPerm = "You lack the permissions to execute this command"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        player.sendMessage(CC.translate(""));
    }
}
