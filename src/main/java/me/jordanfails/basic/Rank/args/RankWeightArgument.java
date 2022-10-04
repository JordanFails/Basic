package me.jordanfails.basic.Rank.args;

import LorexMC.us.utils.other.command.CommandArgument;
import me.activated.core.api.player.Note;
import me.activated.core.plugin.AquaCore;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collections;
import java.util.List;

public class RankWeightArgument extends CommandArgument {

    private final Basic plugin;

    public RankWeightArgument(Basic plugin) {
        super("setweight", "sets the weight of ranks");
        this.plugin = plugin;
    }

    @Override
    public String getUsage(String label) {
        return '/' + label + ' ' + getName() + " <rank> <weight>";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 1) {
            sender.sendMessage(ChatColor.RED + "usage /rank set <player> <group>");
            return true;
        }
        Player target = Bukkit.getPlayer(args[1]);
        AquaCoreAPI api = AquaCoreAPI.INSTANCE;
        String console = "CONSOLE";

        if(target == null) {
            sender.sendMessage(ChatColor.RED  + "Could not find the player " + args[1]);
            return true;
        }
        StringBuilder x = new StringBuilder();

        for (int i = 2; i < args.length; i++) {
            x.append(args[i]+" ");
        }

        String rank = StringUtils.capitalize(x.toString().trim());


        sender.sendMessage(CC.translate("&6&lFeatures &8»&r You have set " + AquaCore.INSTANCE.getRankManagement().getRank(x.toString().trim()).getColor() + args[1] + "&r to the rank " + AquaCore.INSTANCE.getRankManagement().getRank(x.toString().trim()).getColor() + rank));
        target.sendMessage(CC.translate("&6&lFeatures &8»&r Your rank has been set to " + AquaCore.INSTANCE.getRankManagement().getRank(x.toString().trim()).getColor() + x.toString().trim() + "&r by &4CONSOLE&r."));
        Bukkit.getConsoleSender().sendMessage(CC.translate("&6&lFeatures &8» " + AquaCore.INSTANCE.getRankManagement().getRank(x.toString().trim()).getColor() + target.getName() + " &rhas been granted " + AquaCore.INSTANCE.getRankManagement().getRank(x.toString().trim()).getColor() + rank + "&r."));
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "setrank " +  args[1] + " " + x.toString().trim() + " perm global Owner");
        return true;

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        return args.length == 2 ? null : Collections.emptyList();
    }
}
