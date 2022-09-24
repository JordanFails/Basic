package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import com.lunarclient.bukkitapi.LunarClientAPI;
import me.activated.core.permissible.AquaPermissible;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.entity.Player;

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
