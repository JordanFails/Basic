package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.Utils;
import me.qiooip.lazarus.Lazarus;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class DelayCommand {
    @Command(
            name = "delay",
            usage = "Usage: /delay <delayInSeconds>"
    )
    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();
        int chatDelay = Integer.parseInt(args.getArgs(0));
        if(args.length() > 0){
            sender.sendMessage(ChatColor.RED + args.getCommand().getUsage());
        }else if(isInt(args.getArgs(0), sender)){
            Lazarus.getInstance().getChatControlHandler().setDelay(chatDelay);
        }

    }

    public static boolean isInt(String s, CommandSender sender) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            sender.sendMessage(Utils.chat("&c&l(!)&c Only integers can be used to slow chat!"));
            return false;
        }
        return true;
    }
}

