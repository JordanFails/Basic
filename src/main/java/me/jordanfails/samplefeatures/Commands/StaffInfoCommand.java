package me.jordanfails.samplefeatures.Commands;

import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.Utils;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.Faction;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Player;

public class StaffInfoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        final PlayerFaction fm;
        int chatSlowed = Lazarus.getInstance().getChatControlHandler().getDelay();

        if(!player.hasPermission("hcf.command.staffinfo")){
            player.sendMessage(CC.translate("&c&l(!)&c You lack the permissions to execute this command!"));
        }else{
            player.sendMessage(ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH.toString() + "------------------------------");
            if(Lazarus.getInstance().getVanishManager().isVanished(player)){
                player.sendMessage(CC.translate("&e[Staff]&r You are currently vanished!"));
            }else if(!Lazarus.getInstance().getVanishManager().isVanished(player)){
                player.sendMessage(CC.translate("&e[Staff]&r You are &e&nnot&r currently vanished!"));
            }
            if(chatSlowed <= 0){
                player.sendMessage(CC.translate("&e[Staff]&r Chat is currently &e&nnot&r slowed."));
            }else if(chatSlowed == 0){
                player.sendMessage(CC.translate("&e[Staff]&r Chat is currently slowed by &e&n" + chatSlowed + "&e seconds."));
            }
            if(Lazarus.getInstance().getChatControlHandler().isMuted()){
                player.sendMessage(CC.translate("&e[Staff]&r Chat is currently &e&nmuted&e."));
            }else if(!Lazarus.getInstance().getChatControlHandler().isMuted())
                player.sendMessage(CC.translate("&e[Staff]&r Chat is &e&nnot&r currently &e&nmuted&e."));
            FactionsManager.getInstance().getPlayerFaction(player.getUniqueId());
        }

        return false;
    }
}
