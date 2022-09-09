package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.Objects;

public class ProfileCommand {
    @Command(
            name = "profile"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        PlayerFaction getFaction = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId());

        if(getFaction == null){
            player.sendMessage(CC.translate("&cYou must be in a faction to execute this command."));
        }else{
            Inventories.profileGUI(player);
        }
    }
}
