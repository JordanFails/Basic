package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.CC;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreeRankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;

            LuckPermsProvider.get().getUserManager().getUser(player.getUniqueId()).setPrimaryGroup("toprank"); //TODO: replace top rank name.
        }else{
            sender.sendMessage(CC.translate("&c&l(!)&c This is a player only command!"));
        }

        return false;
    }
}
