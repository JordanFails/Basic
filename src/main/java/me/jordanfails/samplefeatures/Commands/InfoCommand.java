package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.Utils;
import net.minecraft.server.v1_7_R4.MathHelper;
import net.minecraft.server.v1_7_R4.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import static net.minecraft.server.v1_7_R4.MinecraftServer.currentTick;

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
