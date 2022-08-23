package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Utils;
import com.lunarclient.bukkitapi.LunarClientAPI;
import me.qiooip.lazarus.lunarclient.LunarClientManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class LunarAmountCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            Set<Player> amount = LunarClientAPI.getInstance().getPlayersRunningLunarClient();
            if (player.isOp()) {
                player.sendMessage(Utils.chat("&rCurrently, we have &b&n" + amount + "&r running &bLunar Client&r!"));
            }else{
                player.sendMessage(Utils.chat("&c&l(!)&c You lack the permissions to preform this command!"));
            }
        }else{
            sender.sendMessage("This is a player only command.");
        }

        return false;
    }
}
