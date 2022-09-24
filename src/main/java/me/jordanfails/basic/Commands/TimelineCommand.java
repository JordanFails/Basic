package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.activated.core.api.player.GlobalPlayer;
import me.activated.core.api.player.PlayerData;
import me.activated.core.api.rank.RankData;
import me.activated.core.api.rank.grant.Grant;
import me.activated.core.plugin.AquaCoreAPI;
import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.config.Language;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;

import static me.jordanfails.basic.Basic.PREFIX;
import static me.jordanfails.basic.Basic.RANKPREFIX;

public class TimelineCommand {
    @Command(
            name = "timeline",
            inGameOnly = true,
            permission = "hcf.command.timeline"
    )
    public void execute(CommandArgs args) {
        Player player = args.getPlayer();
        Player target = Bukkit.getPlayer(args.getArgs(0));
        GlobalPlayer globalPlayer = AquaCoreAPI.INSTANCE.getGlobalPlayer(player.getUniqueId());
        String rank = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayName();
        String rankColor = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId()).getHighestRank(true).getDisplayColor();
        RankData rankData = AquaCoreAPI.INSTANCE.getPlayerRank(player.getUniqueId());
        PlayerData playerData = AquaCoreAPI.INSTANCE.getPlayerData(player.getUniqueId());
        Grant grant = playerData.getHighestGrant();

        player.sendMessage(CC.translate(PREFIX + "&rYour currently rank is &7»" + rankColor + rank + "&r."));

    }
}