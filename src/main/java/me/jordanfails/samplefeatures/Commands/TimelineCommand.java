package me.jordanfails.samplefeatures.Commands;

import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class TimelineCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            UUID uuid = player.getUniqueId();


            if(!player.hasPermission("hcf.timeline")){
                player.sendMessage(CC.prefix('c') + " You lack the permissions required to execute this command.");
            }else if(player.hasPermission("hcf.timeline")){
                player.sendMessage(CC.prefix('c') + "This command is coming in the future! \nBe on the look out!");
            }
        }
        return false;
    }
}
