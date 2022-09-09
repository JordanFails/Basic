package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.command.CommandSender;

public class TopRankCommand {
    //TODO: TO CHANGE TO RANK NAME!

    @Command(
            name = "toprank"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        sender.sendMessage(CC.translate("&aInterested in purchasing the &2High Roller&a rank? Head over to"));
        sender.sendMessage(CC.translate("&b&nsamplefeatures.org&a."));
    }
}
