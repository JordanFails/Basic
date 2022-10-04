package me.jordanfails.basic.Rank.args;

import LorexMC.us.utils.other.command.CommandArgument;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class RankDeleteArgument extends CommandArgument {

    private Basic plugin;

    public RankDeleteArgument(Basic plugin) {
        super("del", "delete ranks");
        this.plugin = plugin;
    }

    @Override
    public String getUsage(String label) {
        return '/' + label + ' ' + getName() + "<group>";
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        StringBuilder x = new StringBuilder();

        for (int i = 1; i < args.length; i++) {
            x.append(args[i]+" ");
        }

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "rank delete " + x.toString().trim());
        sender.sendMessage(CC.translate("Features &8» &eDeleted " + x.toString().trim() + " from our database!"));
        return true;

    }
}
