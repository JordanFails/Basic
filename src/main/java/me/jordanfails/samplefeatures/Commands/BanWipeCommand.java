package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanWipeCommand {
    @Command(
            name = "banwipe",
            permission = "hcf.command.banwipe"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();
        Player player = args.getPlayer();




    }
}
