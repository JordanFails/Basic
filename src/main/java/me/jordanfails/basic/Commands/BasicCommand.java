package me.jordanfails.basic.Commands;

import com.minnymin.command.Command;
import com.minnymin.command.CommandArgs;
import me.jordanfails.basic.Basic;
import me.jordanfails.basic.Utils.CC;
import me.jordanfails.basic.Utils.ConfigurationService;
import org.bukkit.entity.Player;

public class BasicCommand {
    @Command(
            name = "basic",
            permission = "hcf.command.basic"
    )

    public void execute(CommandArgs args){
        Player player = args.getPlayer();
        if(args.length() == 0){
            player.sendMessage(CC.translate(" "));
            player.sendMessage(CC.translate("&6&lBasic Plugin"));
            player.sendMessage(CC.translate("&a&l*&r Version: " + Basic.get().getDescription().getVersion()));
            player.sendMessage(CC.translate("&a&l*&r Author: " + Basic.get().getDescription().getAuthors()));
        }

        if(args.getArgs(0).equals("reload")){
            ConfigurationService.reload();
            Basic.get().reloadConfig();
            player.sendMessage(CC.translate("&b[Basic]&r Plugin configuration has been reloaded"));
        }
    }
}
