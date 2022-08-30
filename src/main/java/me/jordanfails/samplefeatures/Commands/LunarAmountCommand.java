package me.jordanfails.samplefeatures.Commands;

import me.jordanfails.samplefeatures.Utils.Utils;
import com.lunarclient.bukkitapi.LunarClientAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Set;

public class LunarAmountCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            int amount = LunarClientAPI.getInstance().getPlayersRunningLunarClient().size();
            if (player.isOp() || player.hasPermission("hcf.command.lunaramount")) {
                player.sendMessage(Utils.chat("&rCurrently, we have &b&n" + amount + "&r running &bLunar Client&r!"));
            }else{
                player.sendMessage(Utils.chat("&c&l(!)&c You lack significant permissions to preform this command!"));
            }
        }else{
            sender.sendMessage("This is a player only command.");
        }

        return false;
    }
}
