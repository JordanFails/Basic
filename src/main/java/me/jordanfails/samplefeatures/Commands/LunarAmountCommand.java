package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import com.lunarclient.bukkitapi.LunarClientAPI;
import me.jordanfails.samplefeatures.Utils.CC;
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

        player.sendMessage(CC.translate("&rCurrently, we have &b&n" + amount + "&r running &bLunar Client&r!"));
    }
}
