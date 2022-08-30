package me.jordanfails.samplefeatures.Commands;

import me.jordanfails.samplefeatures.Utils.CC;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StoreCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            player.sendMessage(CC.translate("&eYou can purchase ranks at: &dstore.samplefeatures.net&e."));
            player.playSound(player.getLocation(), Sound.CHICKEN_EGG_POP, 100F, 1F);
        }else{
            sender.sendMessage(CC.translate("&eYou can purchase ranks at: &dstore.samplefeatures.net&e."));
        }

        return false;
    }
}
