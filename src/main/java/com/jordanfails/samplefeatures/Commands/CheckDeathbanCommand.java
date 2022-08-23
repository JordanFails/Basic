package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Utils;
import me.qiooip.lazarus.Lazarus;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CheckDeathbanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Player target = (Player) Bukkit.getServer().getOfflinePlayer(UUID.fromString(args[0]));

            player.sendMessage(Utils.chat("&e&l&n" + target.getDisplayName() + "'s &eCurrent Status&e: " + Lazarus.getInstance().getDeathbanManager().isDeathBanned(target.getUniqueId())));
        }else{
            return false;
        }
        return false;
    }
}
