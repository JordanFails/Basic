package me.jordanfails.samplefeatures.Commands;

import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FactionInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        final PlayerFaction pf;
        String faction = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).toString();
        double dtr = FactionsManager.getInstance().getPlayerFaction(player).getDtr();
        double maxDTR = FactionsManager.getInstance().getPlayerFaction(player).getMaxDtr();
        int amountOnline = FactionsManager.getInstance().getPlayerFaction(player).getOnlineMemberCount();
        String output = faction.substring(0, 1).toUpperCase() + faction.substring(1);



        if(FactionsManager.getInstance().getPlayerFaction(player) == null){
            player.sendMessage(CC.translate("Faction: None"));
        }else if(FactionsManager.getInstance().getPlayerFaction(player) != null){
            player.sendMessage(CC.translate("&eFaction: " + faction));
            if(dtr != maxDTR){
                player.sendMessage(CC.translate("&eCurrent DTR: &c" + dtr + "&e/&a" + maxDTR));
            }else if(dtr == maxDTR){
                player.sendMessage(CC.translate("&eCurrent DTR: &a" + dtr + "&e/&a" + maxDTR));
            }
            player.sendMessage(CC.translate("&eCurrently Online: " + amountOnline));
        }

        return false;
    }
}
