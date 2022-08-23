package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Utils;
import me.qiooip.lazarus.Lazarus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        boolean staffVanish = Lazarus.getInstance().getVanishManager().isVanished(player);
        int chatSlowed = Lazarus.getInstance().getChatControlHandler().getDelay();
        boolean chatMuted = Lazarus.getInstance().getChatControlHandler().isMuted();

        if(!player.hasPermission("hcf.command.staffinfo")){
            player.sendMessage(Utils.chat("&cAn error has occurred in your permissions!"));
        }else{
            player.sendMessage(Utils.chat("&eVanish:&r " + staffVanish));
            player.sendMessage(Utils.chat("&eChat Delay:&r " + chatSlowed + "&e's"));
            player.sendMessage(Utils.chat("&eChat Muted:&r " + chatMuted));
        }

        return false;
    }
}
