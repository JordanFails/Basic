package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Utils;
import me.qiooip.lazarus.handlers.staff.RebootHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LockdownCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player = (Player) sender;


        for(Player onlinePlayers : Bukkit.getServer().getOnlinePlayers()){
            if(!onlinePlayers.hasPermission("hcf.command.vanish")) {
                onlinePlayers.kickPlayer("This server has gone into lockdown mode!");
            }
        }


        Bukkit.getServer().setWhitelist(true);
        return false;
    }
}
