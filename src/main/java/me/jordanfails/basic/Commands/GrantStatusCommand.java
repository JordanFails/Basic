package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import lombok.NonNull;
import me.activated.core.api.player.GlobalPlayer;
import me.activated.core.api.player.PlayerData;
import me.activated.core.api.rank.RankData;
import me.activated.core.api.rank.grant.Grant;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Utils.CC;
import org.bukkit.entity.Player;

import static me.jordanfails.basic.Basic.RANKPREFIX;

public class GrantStatusCommand {
    @Command(
            name = "grantstatus",
            inGameOnly = true,
            usage = "Usage: /grantstatus"
    )
    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        GlobalPlayer globalPlayer = AquaCoreAPI.INSTANCE.getGlobalPlayer(player.getUniqueId());
        @NonNull RankData rankData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true);
        String rankName = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayName();
        String rankColor = rankData.getDisplayColor();
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        Grant grant = playerData.getHighestGrant();


        player.sendMessage(CC.translate(RANKPREFIX + "&rYour currently rank is " + rankColor + rankName + "&r."));
        if(grant.getNiceExpire().equals("null")){
            player.sendMessage(CC.translate(RANKPREFIX + "&rYour current rank will not expire!"));
            return;
        }
        player.sendMessage(CC.translate(RANKPREFIX + "&rYour current rank will expire in: &a" + grant.getNiceExpire() + "&r."));

    }
}
