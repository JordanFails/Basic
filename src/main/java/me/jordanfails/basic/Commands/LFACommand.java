package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Inventories.Inventories;
import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.config.Language;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.entity.Player;

import java.util.Objects;

public class LFACommand {
    @Command(
            name = "lfa",
            inGameOnly = true,
            usage = "/lfa"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        String name = player.getName();
        PlayerFaction getFaction = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId());
        String leaderName = getFaction.getLeader().getPlayer().getName();

        if(getFaction == null){
            player.sendMessage(Language.FACTION_PREFIX + Language.FACTIONS_NOT_IN_FACTION_SELF);
        }else if(getFaction != null){
            if(getFaction.getLeader().equals(player.getName())){

            }
        }
    }

}
