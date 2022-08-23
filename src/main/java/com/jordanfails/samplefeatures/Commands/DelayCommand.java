package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Utils;
import me.qiooip.lazarus.Lazarus;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            int slowChatDelay = Integer.parseInt(args[0]);

            if(player.hasPermission("hcf.staff.delaychat")){
                if(isInt(args[0], player)){
                    Lazarus.getInstance().getChatControlHandler().setDelay(slowChatDelay);
                    player.sendMessage(Utils.chat("&a&l(!)&a You have successfully slow chat to &r&n" + slowChatDelay + "&a seconds."));
                }else{
                    player.sendMessage(Utils.chat("&c&l(!)&c Only integers can be used to slow chat!"));
                }
            }else{
                player.sendMessage("&c&l(!)&c You lack the required permissions to use this command!");
            }
        }else{
            sender.sendMessage(Utils.chat("&c&l(!)&c This is a player only command."));
        }

        return false;
    }




    public static boolean isInt(String s, CommandSender sender) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            sender.sendMessage(Utils.chat("&c&l(!)&c Only integers can be used to slow chat!"));
            return false;
        }
        return true;
    }
}
