package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.Utils;
import net.minecraft.server.v1_7_R4.MathHelper;
import net.minecraft.server.v1_7_R4.MinecraftServer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        int online = Bukkit.getServer().getOnlinePlayers().size();
        int max = Bukkit.getMaxPlayers();

        player.sendMessage(Utils.chat("&eYou currently have &r&n" + online + "/" + max + "&e on the server."));
        player.sendMessage(Utils.chat("&eThe current TPS is &e&n" + MathHelper.a(MinecraftServer.getServer().g) * 1.0E-6D));
        if(Bukkit.getServer().hasWhitelist()){
            player.sendMessage(Utils.chat("&eWhitelisted: &a&nTrue"));
        }else{
            player.sendMessage(Utils.chat("&eWhitelisted: &c&nFalse"));
        }
        return false;
    }

    @com.minnymin.command.Command(
            name = "info",
            permission = "hcf.command.info"
    )
    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        int online = Bukkit.getServer().getOnlinePlayers().size();
        int max = Bukkit.getMaxPlayers();



    }
}
