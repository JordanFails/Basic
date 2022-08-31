package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.Utils;
import com.lunarclient.bukkitapi.LunarClientAPI;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;

import java.util.Set;

public class LunarAmountCommand{

    @Command(
            name = "lunaramount",
            aliases = "la, lamount",
            usage = "/lunaramount"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        int amount = LunarClientAPI.getInstance().getPlayersRunningLunarClient().size();

        player.sendMessage(Utils.chat("&rCurrently, we have &b&n" + amount + "&r running &bLunar Client&r!"));
    }
}
