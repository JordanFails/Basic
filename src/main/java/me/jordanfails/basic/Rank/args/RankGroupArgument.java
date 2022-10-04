package me.jordanfails.basic.Rank.args;

import LorexMC.us.utils.other.command.CommandArgument;
import me.activated.core.plugin.AquaCore;
import me.jordanfails.basic.Basic;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class RankGroupArgument extends CommandArgument {

    private final Basic plugin;

    public RankGroupArgument(Basic plugin) {
        super("list", "check available ranks");
        this.plugin = plugin;
    }

    @Override
    public String getUsage(String label) {
        return '/' + label + ' ' + getName() + " <player> <group>";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Bukkit.dispatchCommand(sender, "rank list");
        sender.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Features §8» " + ChatColor.YELLOW + "Getting ranks from database!");
        return true;

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return args.length == 0 ? null : Collections.emptyList();
    }
}
