package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.SampleFeatures;
import com.jordanfails.samplefeatures.Utils.Utils;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.config.Config;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class LFACommand implements CommandExecutor {

    private SampleFeatures plugin;
    final PlayerFaction playerFaction = null;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        final FactionsManager fm;

        if(command.getName().equalsIgnoreCase("lfa")){
            if(sender instanceof Player){
                Player player = (Player) sender;

            }
        }
        return false;
    }
}
