package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class PingCommand{
    @Command(
            name = "ping"
    )
    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        if(args.length() < 1){
            if(sender instanceof Player){
                CraftPlayer handler = (CraftPlayer) sender;
                String name = sender.getName();
                sender.sendMessage(ChatColor.LIGHT_PURPLE + name + ChatColor.YELLOW + " has a ping of " + ChatColor.LIGHT_PURPLE + handler.getHandle().playerConnection.player.ping + ChatColor.YELLOW + " ms.");
            }else{
                sender.sendMessage(ChatColor.RED + "Correct usage: /ping <player>");
            }
        }else{
            boolean found = false;
            for(Player player : Bukkit.getServer().getOnlinePlayers()){
                String name = player.getName();
                CraftPlayer handler = (CraftPlayer) player;
                if(name.equalsIgnoreCase(args.getArgs(0))){
                    sender.sendMessage(ChatColor.LIGHT_PURPLE + name + ChatColor.YELLOW + " has a ping of " + ChatColor.LIGHT_PURPLE + handler.getHandle().playerConnection.player.ping + ChatColor.YELLOW + " ms.");
                    found = true;
                    break;
                }
            }
            if(!found){
                sender.sendMessage(ChatColor.RED + "Player not found.");
            }
        }

    }
}
