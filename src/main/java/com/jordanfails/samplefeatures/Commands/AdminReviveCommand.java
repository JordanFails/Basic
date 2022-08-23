package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Utils;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.Faction;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import me.qiooip.lazarus.factions.type.SystemFaction;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class AdminReviveCommand implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player admin = (Player) sender;
        Player target = Bukkit.getServer().getPlayer(args[0]);

        if(admin.hasPermission("hcf.revive.admin") && args.length == 1){
            if(target != null){
                Lazarus.getInstance().getDeathbanManager().revivePlayer(target.getUniqueId());
                Lazarus.getInstance().getUserdataManager().getUserdata(target.getUniqueId()).getNotes().add("Revived by " + admin.getDisplayName());

                admin.playSound(admin.getLocation(), Sound.ANVIL_USE, 100F, 1F);
                admin.sendMessage("&a&l(!)&a You have successfully revived &a&n" + target.getName() + "&a.");
            }else{
                admin.playSound(admin.getLocation(), Sound.ANVIL_BREAK, 100F, 1F);
                admin.sendMessage(Utils.chat("&cThat isn't a valid player!"));
            }
        }else if(args.length > 1){
            admin.playSound(admin.getLocation(), Sound.ANVIL_BREAK, 100F, 1F);
            admin.sendMessage(Utils.chat("&cToo many arguments!"));
        }

        return false;
    }
}
