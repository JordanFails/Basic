package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import me.jordanfails.basic.Inventories.Inventories;
import org.bukkit.entity.Player;

public class AbilityGUICommand {
    @Command(
            name = "items"
    )
    public void execute(Player player){

        Inventories.abilityGUI(player);

    }
}
