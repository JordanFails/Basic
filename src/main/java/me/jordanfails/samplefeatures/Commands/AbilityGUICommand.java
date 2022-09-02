package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import org.bukkit.entity.Player;

public class AbilityGUICommand {
    @Command(
            name = "abilitygui",
            inGameOnly = true,
            usage = "Usage: /ability"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        Inventories.abilityGUI(player);
    }
}
