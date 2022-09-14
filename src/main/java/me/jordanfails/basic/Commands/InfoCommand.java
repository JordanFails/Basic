package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;


public class InfoCommand{

    @Command(
            name = "info",
            permission = "hcf.command.info"
    )
    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        int online = Bukkit.getServer().getOnlinePlayers().size();
        int max = Bukkit.getMaxPlayers();

        if(!player.hasPermission("hcf.command.info")){
            player.sendMessage(CC.translate("&cNo Permission"));
        }else if(player.hasPermission("hcf.command.info")){
            player.sendMessage(CC.translate("&rWe current have &a&n" + online + "/" + max + "&r on the server!"));
            CraftPlayer handler = (CraftPlayer) player;
            player.sendMessage(ChatColor.WHITE + "" + ChatColor.AQUA + handler.getHandle().playerConnection.player.ping + ChatColor.GRAY + " ms.");
            if(Bukkit.getServer().hasWhitelist()){
                player.sendMessage(CC.translate("&rWhitelisted: &a&nTrue"));
            }else{
                player.sendMessage(CC.translate("&rWhitelisted: &c&nFalse"));
            }
        }
    }
}
