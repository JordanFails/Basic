package com.jordanfails.samplefeatures.Commands;

import com.jordanfails.samplefeatures.Utils.Utils;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheckRankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("currentrank")){
            if(sender instanceof Player){
                Player player = (Player) sender;
                Player target = Bukkit.getPlayer(args[0]);
                User user = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(player);
                User user1 = LuckPermsProvider.get().getPlayerAdapter(Player.class).getUser(target);
                String rank = user.getPrimaryGroup();
                String rank1 = user1.getPrimaryGroup();


                if(args.length == 0){
                    player.sendMessage(Utils.chat("&e&lHighest Current Rank&e: " + rank));
                }else if(args.length == 1 && target != null){
                    player.sendMessage(Utils.chat("&e&lHighest Current Rank&e: " + rank1));
                }else{
                    player.sendMessage(Utils.chat("&cSomething went wrong then trying to perform this command!"));
                }
            }
        }



        return false;
    }
}
