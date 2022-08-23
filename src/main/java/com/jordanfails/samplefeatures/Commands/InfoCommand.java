package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Lag;
import com.jordanfails.samplefeatures.Utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        int online = Bukkit.getServer().getOnlinePlayers().size();
        int max = Bukkit.getMaxPlayers();

        player.sendMessage(Utils.chat("&eYou currently have &r&n" + online + "/" + max + "&6 on the server."));
        player.sendMessage(Utils.chat("&eThe current TPS is &e&n" + Lag.getTPS()));
        if(Bukkit.getServer().hasWhitelist()){
            player.sendMessage(Utils.chat("&eWhitelisted: &a&nTrue"));
        }else{
            player.sendMessage(Utils.chat("&eWhitelisted: &c&nFalse"));
        }
        return false;
    }
}
