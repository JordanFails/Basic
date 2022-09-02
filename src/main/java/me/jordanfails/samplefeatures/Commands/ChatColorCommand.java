package me.jordanfails.samplefeatures.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.samplefeatures.Inventories.Inventories;
import org.bukkit.entity.Player;

public class ChatColorCommand {
    @Command(
            name = "chatcolor"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        Inventories.chatColorGUI(player);
    }
}
