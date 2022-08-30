package me.jordanfails.samplefeatures.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class YouTubeCommand implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "This is a player only command");
            return true;
        }
        sender.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "--------------------------------");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "YouTube Rank Requirements:");
        sender.sendMessage(ChatColor.WHITE + "Sub Requirement" + ChatColor.LIGHT_PURPLE + " » " + ChatColor.WHITE + ChatColor.UNDERLINE + "200");
        sender.sendMessage(ChatColor.AQUA + ChatColor.BOLD.toString() + ChatColor.GOLD + "View Requirement" +" » " + ChatColor.WHITE + "100");
        sender.sendMessage(ChatColor.GRAY + ChatColor.STRIKETHROUGH.toString() + "--------------------------------");
        return false;
    }
}
