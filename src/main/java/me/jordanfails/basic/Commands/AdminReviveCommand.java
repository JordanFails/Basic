package me.jordanfails.basic.Commands;

import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminReviveCommand implements CommandExecutor {


    @Override public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player admin = (Player) sender;
            OfflinePlayer target = Bukkit.getServer().getOfflinePlayer(args[0]);

            if(!admin.hasPermission("hcf.adminrevive")){
                admin.sendMessage(CC.translate("&C&L(!)&c You lack the permissions to execute this command."));
            }else if(admin.hasPermission("hcf.adminrevive")){
                if(target == null){
                    admin.sendMessage(CC.translate("&C&L(!)&c This player is null."));
                }else{
                    if(!Lazarus.getInstance().getDeathbanManager().isDeathBanned(target.getUniqueId())){
                        admin.sendMessage(CC.translate("&C&L(!)&c This player isnt deathbanned."));
                    }else if(Lazarus.getInstance().getDeathbanManager().isDeathBanned(target.getUniqueId())){
                        Lazarus.getInstance().getDeathbanManager().revivePlayer(target.getUniqueId());
                        Lazarus.getInstance().getUserdataManager().getUserdata(target.getUniqueId()).getNotes().add(admin.getName() + " has revived" + target.getName());
                        admin.sendMessage(CC.translate("&a&l(!)&a You have &r&nsuccessfully revived &r&n" + target.getName() + "&a."));
                        Bukkit.getConsoleSender().sendMessage(CC.translate("&a&n" + admin.getName() + "&r has revived " + target.getName()));
                    }
                }
            }
        }
        return false;
    }
}