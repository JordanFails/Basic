package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomTeleportCommand {


    @Command(
            name = "randomtp"
    )

    public void execute(CommandArgs args){
        CommandSender sender = args.getSender();

        if(sender instanceof Player){
            final Player player = (Player) sender;
            final List<Player> players = new ArrayList<>();
            for(final Player players2 : Bukkit.getOnlinePlayers()){
                players.add(players2);
            }
            Collections.shuffle(players);
            final Random random = new Random();
            final int randoms = random.nextInt(Bukkit.getOnlinePlayers().size());
            final Player p = players.get(randoms);
            if(player.canSee(p) && player.hasPermission("hcf.teleport")){
                player.teleport((Entity)p);

            }
            else if (player.canSee(p)) {
                player.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Zorex §8» " + ChatColor.GRAY + "You have found " + p.getName());
            }
            else {
                player.sendMessage(ChatColor.GOLD + ChatColor.BOLD.toString() + "Zorex §8» " + ChatColor.RED + "Player could not be found.");
            }
        }
    }
}
