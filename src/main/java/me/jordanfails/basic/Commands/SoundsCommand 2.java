package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.entity.Player;

public class SoundsCommand {
    @Command(
            name = "sounds"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        player.performCommand("togglesounds");
    }
}
