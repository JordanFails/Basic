package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.SampleFeatures;
import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.timer.TimerManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class SaleCommand {

    @Command(
            name = "activesale",
            permission = "hcf.command.salealert",
            description = "a command to tell everyone about a sale!",
            usage = "Usage: /activesale (clear)")


    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        if(args.length() == 0){
            if(!sender.hasPermission("hcf.command.salealert")){
                sender.sendMessage(CC.translate("&cYou lack the permissions to execute this command."));
            }else if(sender.hasPermission("hcf.command.salealert")){
                Bukkit.getServer().broadcastMessage(CC.translate(" "));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &a&l&nCONSOLE&r has &a&nactivated&r a &a&nSALE&r!"));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &rTake advantage at &a&nhttps://store.samplefeatures.org&r!"));
                Bukkit.getServer().broadcastMessage(CC.translate(""));
                for(Player player : Bukkit.getServer().getOnlinePlayers()){
                    player.playSound(player.getLocation(), Sound.VILLAGER_YES, 100F, 1F);
                }
                TimerManager.getInstance().getSaleTimer().activate(SampleFeatures.get().getConfig().getInt("SALETIMER"));
            }
        }else if(args.length() == 1)
            if(args.getArgs(0).equalsIgnoreCase("clear")) {
                Bukkit.getServer().broadcastMessage(CC.translate(" "));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &a&l&nCONSOLE&r has &c&ndeactivated&r the current sale."));
                Bukkit.getServer().broadcastMessage(CC.translate("&7[&4ALERT&7] &rYou can still shop at &a&nhttps://store.samplefeatures.org"));
                Bukkit.getServer().broadcastMessage(CC.translate(""));
                TimerManager.getInstance().getSaleTimer().disable();
                for(Player player : Bukkit.getServer().getOnlinePlayers()){
                    player.playSound(player.getLocation(), Sound.FIZZ, 80F, 2F);
                }
            }
    }
}
