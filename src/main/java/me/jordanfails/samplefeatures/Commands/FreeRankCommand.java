package me.jordanfails.samplefeatures.Commands;

import me.jordanfails.samplefeatures.Utils.CC;
import me.jordanfails.samplefeatures.Utils.Utils;
import net.luckperms.api.LuckPermsProvider;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class FreeRankCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
            ArrayList<UUID> freerank = new ArrayList<>();
            UUID uuid = player.getUniqueId();

            if(!freerank.contains(uuid)) {
                Bukkit.getServer().dispatchCommand(console, "grant " + player.getName() + "owner 7d"); //TODO: replace top rank name.
                player.sendMessage(Utils.chat("&e&l[FREE RANK]&e Your rank has been updated!"));
                freerank.add(uuid);
            } else if(freerank.contains(uuid)) {
                player.sendMessage(CC.prefix('c') + "You already claimed your free rank!");
                player.sendMessage(CC.translate("&cTry again next season!"));

            }
        }else{
            sender.sendMessage(CC.translate("&c&l(!)&c This is a player only command!"));
        }

        return false;
    }
}
