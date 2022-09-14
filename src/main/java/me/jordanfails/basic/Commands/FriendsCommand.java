package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Inventories.Inventories;
import org.bukkit.entity.Player;

public class FriendsCommand {
    @Command(
            name = "friends"
    )
    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        Inventories.factionGUI(player);
    }
}
