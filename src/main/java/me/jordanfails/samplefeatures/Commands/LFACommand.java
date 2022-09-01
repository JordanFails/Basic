package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.FactionsManager;
import org.bukkit.entity.Player;

public class LFACommand {
    @Command(
            name = "lfa",
            inGameOnly = true,
            usage = "/lfa"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        player.sendMessage(CC.translate("&c&l(!)&c This command is a WIP."));
        if(FactionsManager.getInstance().getFactions().containsKey(player.getUniqueId())){
            player.sendMessage(CC.translate("&c&l(!)&c You already have a faction!"));
            return;
        }else if(!FactionsManager.getInstance().getFactions().containsKey(player.getUniqueId())){
            Inventories.lffGUI(player);
        }
    }

}
