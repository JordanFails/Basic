package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.entity.Player;

public class CraftCommand {
    @Command(
            name = "craft",
            permission = "hcf.command.craft",
            inGameOnly = true
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        player.openWorkbench(player.getLocation(), true);
    }
}
