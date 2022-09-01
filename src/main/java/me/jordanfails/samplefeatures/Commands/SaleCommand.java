package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import com.mysql.jdbc.TimeUtil;
import me.jordanfails.samplefeatures.ConfigurationService;
import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.timer.Timer;
import me.qiooip.lazarus.timer.TimerManager;
import me.qiooip.lazarus.utils.Tasks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class SaleCommand {
    @Command(
            name = "activesale",
            permission = "hcf.command.salealert",
            description = "a command to tell everyone about a sale!",
            usage = "Usage: /activesale <percentage/clear>"
    )

    public void execute(CommandArgs args){
        Player player = (Player) args.getSender();
        CommandSender sender = args.getSender();

        if(args.length() == 0){
            if(!sender.hasPermission("hcf.command.salealert")){
                player.sendMessage(ChatColor.RED + args.getCommand().getPermissionMessage());
            }else if(sender.hasPermission("hcf.command.salealert")){
                Bukkit.getServer().broadcastMessage(CC.translate(" "));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &a&l&nCONSOLE&r has &a&nactivated&r a sale for &a&n25% OFF&r for &a&n1 day&r!"));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &rTake advantage at &a&nhttps://store.samplefeatures.org&r!"));
                Bukkit.getServer().broadcastMessage(CC.translate(""));
                TimerManager.getInstance().getSaleTimer().activate();
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
