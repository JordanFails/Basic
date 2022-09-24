package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Inventories.Inventories;
import org.bukkit.entity.Player;

public class AbilityGUICommand {
    @Command(
            name = "items",
            inGameOnly = true,
            usage = "Usage: /items"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        Inventories.abilityGUI(player);
    }
}
