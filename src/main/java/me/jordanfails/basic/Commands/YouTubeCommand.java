package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Inventories.Inventories;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class YouTubeCommand{

    @Command(
            name = "youtube",
            inGameOnly = true

    )
    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        Inventories.youtubeGUI(player);
    }
}
