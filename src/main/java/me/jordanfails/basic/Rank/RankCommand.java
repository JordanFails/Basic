package me.jordanfails.basic.Rank;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        Player p = (Player) sender;
        if(args.length == 0) {
            p.sendMessage(ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH.toString() + "-----------------------------------");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lRank &7(AquaCore)"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/srank &7set <player> <group>"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/srank &7<group> setprefix <prefix>"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/srank &7<group> setsuffix <suffix>"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/srank &7<player> add <permission>"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/srank &7<player> remove <permission>"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/srank &7<>"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/srank &7groups"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/srank &7delgroup <group>"));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
            p.sendMessage(ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH.toString() + "-----------------------------------");
            return true;
        }

        else if(args.length == 1 && (args[0].equalsIgnoreCase("set"))) {
            p.sendMessage(ChatColor.RED  + "Please specify a group");
            return true;
        }
        Player target = Bukkit.getPlayer(args[1]);
        if(target == null) {
            p.sendMessage(ChatColor.RED + "Could not find a player called " + args[0]);
            return true;
        }
        // StringBuilder x = new StringBuilder();

        // for (int i = 2; i < args.length; i++) {
        //     x.append(args[i]+" ");
        // }
        // Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + target.getName() + " group set " + x.toString().trim());
        // p.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Zorex §8» " + ChatColor.GRAY + "You have set " + target.getName() + " to " + x.toString().trim());
        // target.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Zorex §8» " + ChatColor.GRAY + "Your group has been set to " + x.toString().trim());
        return true;

    }
}
