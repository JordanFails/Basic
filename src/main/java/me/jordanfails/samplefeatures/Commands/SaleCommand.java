package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.timer.TimerManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;


public class SaleCommand {
    @Command(
            name = "activesale",
            permission = "hcf.command.salealert",
            description = "a command to tell everyone about a sale!",
            usage = "Usage: /activesale <percentage/clear>",
            inGameOnly = false
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        if(args.length() == 0){
            if(!sender.hasPermission("hcf.command.salealert")){
                sender.sendMessage(CC.Red + args.getCommand().getPermissionMessage());
            }else if(sender.hasPermission("hcf.command.salealert")){
                Bukkit.getServer().broadcastMessage(CC.translate(" "));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &a&l&nCONSOLE&r has &a&nactivated&r a &a&nSALE&r!"));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &rTake advantage at &a&nhttps://store.samplefeatures.org&r!"));
                Bukkit.getServer().broadcastMessage(CC.translate(""));
                TimerManager.getInstance().getSaleTimer().activate(84600);
                //TODO: delay = how much time in seconds.
            }
        }else if(args.length() == 1)
            if(args.getArgs(0).equalsIgnoreCase("clear")) {
                Bukkit.getServer().broadcastMessage(CC.translate(" "));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &a&l&nCONSOLE&r has &c&ndeactivated&r the current sale."));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &rYou can still shop at &a&nhttps://store.samplefeatures.org"));
                Bukkit.getServer().broadcastMessage(CC.translate(""));
                TimerManager.getInstance().getSaleTimer().disable();
            }
    }
}
