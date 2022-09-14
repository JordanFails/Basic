package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.FactionsManager;
import me.qiooip.lazarus.factions.type.PlayerFaction;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerInfoCommand {

    @Command(
            name = "playerinfo",
            inGameOnly = true,
            usage = "Usage: /playerinfo <otherPlayers>"

    )

    public void execute(CommandArgs args) {

            Player player = args.getPlayer();
            CommandSender sender = args.getSender();
            Lazarus laz = Lazarus.getInstance();
            FactionsManager fm = FactionsManager.getInstance();
            String faction = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId()).getName();
            PlayerFaction playerFaction = FactionsManager.getInstance().getPlayerFaction(player.getUniqueId());
            String output = faction.substring(0, 1).toUpperCase() + faction.substring(1);

            if(args.length() == 0){
                player.sendMessage(" ");
                player.sendMessage(CC.translate("&6&lUser:&r " + player.getName()));
                player.sendMessage(CC.translate("&6&l* &eBalance: &a$" + laz.getEconomyManager().getBalance(player)));
                player.sendMessage(CC.translate("&6&l* &eFaction: " + output));
                player.sendMessage(CC.translate("&6&l* &eDTR: &r" + playerFaction.getDtr() + "&r/&r" + playerFaction.getMaxDtr()));
                player.sendMessage(CC.translate("&6&l* &eLunar Client: " + laz.getLunarClientManager().isOnLunarClient(player.getUniqueId())));

                player.sendMessage(CC.translate("&7&l&o(!) &7&oIn the future, you can click the faction to get more information!"));
                player.sendMessage(" ");
            }else if(args.length() == 1){
                Player target = Bukkit.getPlayer(args.getArgs(0));
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "You cannot check an offline player right now.");
                    return;
                }
                    player.sendMessage(" ");
                    player.sendMessage(CC.translate("&6&lUser:&r " + target.getName()));
                    player.sendMessage(CC.translate("&6&l* &eBalance: &a$" + laz.getEconomyManager().getBalance(target)));
                    player.sendMessage(CC.translate("&6&l* &eLunar Client: " + laz.getLunarClientManager().isOnLunarClient(target.getUniqueId())));
                    player.sendMessage(CC.translate("&6&l* &eFaction: &cNull"));
                    player.sendMessage(" ");
                    player.sendMessage(CC.translate("&c&l&o(!) &rIn the future, you can click the faction to get more information!"));
                    player.sendMessage(" ");
            }
        }

    }
// > more than
// < less than