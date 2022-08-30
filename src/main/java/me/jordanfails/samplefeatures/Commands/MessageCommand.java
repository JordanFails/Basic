package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class MessageCommand {

    @Command(
            name = "message",
            inGameOnly = true,
            usage = "Usage: /message <player> <message>"
    )


    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();
        if(args.length() < 2){
            sender.sendMessage(ChatColor.RED + args.getCommand().getUsage());
        }
    }
}
