package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import org.bukkit.entity.Player;

public class BugCommand {
    @Command(
            name = "bug",
            permission = "hcf.command.buy"
    )

    public void execute(CommandArgs args){
        Player playe = args.getPlayer();
    }
}
