package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.command.CommandSender;

public class TimelineCommand {
    @Command(
            name = "timeline",
            inGameOnly = true,
            permission = "hcf.command.timeline"
    )
    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

    }

}
