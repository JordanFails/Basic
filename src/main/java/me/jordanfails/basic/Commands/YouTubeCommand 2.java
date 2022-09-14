package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;


public class YouTubeCommand{

    @Command(
            name = "youtube"

    )
    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        sender.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "--------------------------------");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "YouTube Rank Requirements:");
        sender.sendMessage(ChatColor.WHITE + "Sub Requirement" + ChatColor.LIGHT_PURPLE + " » " + ChatColor.WHITE + ChatColor.UNDERLINE + "200");
        sender.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + ChatColor.GOLD + "View Requirement" +" » " + ChatColor.WHITE + "100");
        sender.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "--------------------------------");
    }
}
