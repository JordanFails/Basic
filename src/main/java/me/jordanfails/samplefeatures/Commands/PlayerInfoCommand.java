package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Utils.CC;
import me.qiooip.lazarus.Lazarus;
import me.qiooip.lazarus.factions.FactionsManager;
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

            if(args.length() == 0){
                player.sendMessage(" ");
                player.sendMessage(CC.translate("&6&lUser:&r " + player.getName()));
                player.sendMessage(CC.translate("&6&l* &eBalance: &a$" + Lazarus.getInstance().getEconomyManager().getBalance(player)));
                player.sendMessage(CC.translate("&6&l* &eLunar Client: " + Lazarus.getInstance().getLunarClientManager().isOnLunarClient(player.getUniqueId())));
                player.sendMessage(" ");
                player.sendMessage(CC.translate("&7&l&o(!) &7&oIn the future, you can click the faction to get more information!"));
            }else if(args.length() == 1){
                Player target = Bukkit.getPlayer(args.getArgs(0));
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "You cannot modify an offline player.");
                    return;
                }
                    player.sendMessage(" ");
                    player.sendMessage(CC.translate("&6&lUser:&r " + target.getName()));
                    player.sendMessage(CC.translate("&6&l* &eBalance: &a$" + Lazarus.getInstance().getEconomyManager().getBalance(target)));
                    player.sendMessage(CC.translate("&6&l* &eLunar Client: " + Lazarus.getInstance().getLunarClientManager().isOnLunarClient(target.getUniqueId())));
                    player.sendMessage(CC.translate("&6&l* &eFaction: &cNull"));
                    player.sendMessage(" ");
                    player.sendMessage(CC.translate("&7&l&o(!) &7&oIn the future, you can click the faction to get more information!"));

            }
        }

    }
// > more than
// < less than