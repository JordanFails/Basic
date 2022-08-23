package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Inventories.Inventories;
import com.jordanfails.samplefeatures.SampleFeatures;
import com.jordanfails.samplefeatures.Utils.CommandArgument;
import me.qiooip.lazarus.factions.Faction;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class FPunishCommand extends CommandArgument {

    private final SampleFeatures plugin;

    public FPunishCommand(SampleFeatures plugin) {
        super("punish", "Punish a whole faction.");
        this.plugin = plugin;
        this.permission = "hcf.command.faction.argument." + getName();
    }

    @Override
    public String getUsage(String label) {
        return "/" + label + " <faction>";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) throws IOException {

        PlayerFaction playerFaction = FactionsManager.getInstance().getPlayerFaction(args[0]);

        if(!(sender instanceof Player)){
            return true;
        }
        if (args.length < 1) {
            sender.sendMessage(ChatColor.RED + "Usage: " + getUsage(label));
            return true;
        }
        if (playerFaction.getName().equals("null")){
            sender.sendMessage(ChatColor.RED + "Faction containing member with IGN or UUID " + args[1] + " not found.");
            return true;
        }
        Faction faction = FactionsManager.getInstance().getPlayerFaction(args[0]);
        if (!(faction instanceof PlayerFaction)) {
            sender.sendMessage(ChatColor.RED + "This is not a player created faction!");
            return true;
        }

        Player player = (Player) sender;

        Inventories.punishFactionInventory(player, playerFaction);

        return true;
    }
}
