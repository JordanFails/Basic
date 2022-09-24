package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.ConfigurationService;
import org.bukkit.entity.Player;

public class PronounCommand {
    @Command(
            name = "pronoun"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();

        if(ConfigurationService.getPronounsConfig().contains(player.getUniqueId().toString()) && args.length() == 0){
            player.sendMessage(CC.translate("Currently Pronouns: "));
        }
    }
}
